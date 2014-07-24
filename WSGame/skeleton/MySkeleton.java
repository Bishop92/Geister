package skeleton;

import IA.euristiche.EuristicheFactory;
import IA.IAFactory;
import IA.strategie.StrategieFactory;
import apprendimento.ValutaPezziLog;
import apprendimento.ranker.RankerFactory;
import game.CancellaPartitaResponse;
import game.EseguiMossaResponse;
import game.GeneraMossaIAResponse;
import game.GetNomePartitaResponse;
import game.GetTurnoResponse;
import game.ListaMosseResponse;
import game.ListaPartiteResponse;
import game.ListaPosizioniInizialiResponse;
import game.ModificaTipoResponse;
import game.NuovaPartitaResponse;
import game.NuovaPosizioneInizialeResponse;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.*;

import IA.IntelligenzaArtificiale;

import data.WSDataStub;

/**
 * Classe di definizione dei metodi implementati dal servizio WSGame,
 * creato per gestire la partita tra due utenti.
 * <p><u><i>Elenco versioni:</i></u></p>
 * <p/>
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/09/2011</i></p>
 * <ul>
 * <li>bozza iniziale;</li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 01/12/2011</i></p>
 * <ul>
 * <li>Prima versione funzionante: implementazione metodi per nuova partita, posizioni iniziali e mosse;</li>
 * </ul>
 * <p><i>ver. 1.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 11/12/2011</i></p>
 * <ul>
 * <li>Aggiunti metodi per generazione mossaIA, gestione tipo in sfida, lista sfide per tipo.</li>
 * </ul>
 */
class MySkeleton {
    Connection connection = null;

    /**
     * Costruttore di default vuoto, serve a istanziare l'oggetto
     * dentro lo Skeleton autogenerato. Si usera poi per richiamare i metodi
     * riscritti
     */
    public MySkeleton() {
    }


    private boolean insertPartitaDB(String idtoken, String username, String username_sfidato, String nomePartita, byte giocatore_init, double livello1, double livello2, boolean allenamento1, boolean allenamento2) {
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.InsertPartita partitaStub = new WSDataStub.InsertPartita();
            partitaStub.setIdtoken(idtoken);
            partitaStub.setUsername(username);
            partitaStub.setUsername_sfidato(username_sfidato);
            partitaStub.setNomePartita(nomePartita);
            partitaStub.setNGiocatoreInit(giocatore_init);
            partitaStub.setLivello1(livello1);
            partitaStub.setLivello2(livello2);
            partitaStub.setAllenamento1(allenamento1);
            partitaStub.setAllenamento2(allenamento2);

            WSDataStub.InsertPartitaResponse dataResp = stub.insertPartita(partitaStub);

            return dataResp.get_return();

        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/InsertPartitaDB");
            return false;
        }
    }

    /**
     * Modifica il tipo per la sfida, presa chiamando il servizio WSData
     *
     * @param modificaTipo String idtoken,String username,String username_sfidato,String nomePartita
     * @return ModificaTipoResponse (String: conferma)
     */
    public game.ModificaTipoResponse modificaTipo(game.ModificaTipo modificaTipo) {
        ModificaTipoResponse resp = new ModificaTipoResponse();
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.UpdateTipo partitaStub = new WSDataStub.UpdateTipo();
            partitaStub.setIdtoken(modificaTipo.getIdtoken());
            partitaStub.setUsername(modificaTipo.getUsername());
            partitaStub.setNomePartita(modificaTipo.getNomePartita());
            partitaStub.setTipo_nuovo(modificaTipo.getTipo_nuovo());

            if (modificaTipo.getTipo_nuovo().equals("100"))
                IAFactory.getInstance().deleteIA(modificaTipo.getNomePartita());

            WSDataStub.UpdateTipoResponse dataResp = stub.updateTipo(partitaStub);

            resp.set_return(dataResp.get_return());
        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/modificaTipo");
            resp.set_return("ERR:" + e.toString());
        }
        return resp;
    }

    /**
     * Recupera il nome della partita tra due sfidanti, presa chiamando il servizio WSData
     *
     * @param token        Token generato per la partita
     * @param user         Utente che ha avviato la partita
     * @param user_sfidato Utente sfidato
     * @return GetNomePartitaResponse (String: nome partita)
     */
    private String getNomePartita(String token, String user, String user_sfidato) {
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.GetNomePartita partitaStub = new WSDataStub.GetNomePartita();
            partitaStub.setIdtoken(token);
            partitaStub.setUsername(user);
            partitaStub.setUsername_sfidato(user_sfidato);
            WSDataStub.GetNomePartitaResponse dataResp = stub.getNomePartita(partitaStub);

            return dataResp.get_return();

        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/getNomePartita");
            return ("ERR:" + e.toString());
        }
    }

    public game.GetNomePartitaResponse getNomePartita(game.GetNomePartita getNomePartita) {
        GetNomePartitaResponse resp = new GetNomePartitaResponse();
        try {
            resp.set_return(getNomePartita(getNomePartita.getIdtoken(), getNomePartita.getUsername(), getNomePartita.getUsername_sfidato()));
            return resp;
        } catch (Exception e) {
            insertLog("ERR:" + e.toString(), "WSGame/getNomePartita");
            resp.set_return("ERR:" + e.toString());
            return resp;
        }
    }

    /**
     * Recupero della lista partite in base al tipo, presa chiamando il servizio WSData
     *
     * @param listaPartite String idtoken,String tipo
     * @return ListaPartiteResponse (String: lista partite)
     */
    public game.ListaPartiteResponse listaPartite(game.ListaPartite listaPartite) {
        ListaPartiteResponse resp = new ListaPartiteResponse();
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.GetPartite partitaStub = new WSDataStub.GetPartite();
            partitaStub.setIdtoken(listaPartite.getIdtoken());
            partitaStub.setUsername(listaPartite.getUsername());
            partitaStub.setTipo(listaPartite.getTipo());
            WSDataStub.GetPartiteResponse dataResp = stub.getPartite(partitaStub);

            resp.set_return(dataResp.get_return());
            return resp;
        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/listaPartite");
            resp.set_return("ERR:" + e.toString());
            return resp;
        }
    }

    /**
     * Recupero della lista posizioni iniziali, presa chiamando il servizio WSData
     *
     * @param listaPosizioniIniziali String idtoken,String nomePartita
     * @return ListaPosizioniInizialiResponse (String: lista posizioni)
     */
    public game.ListaPosizioniInizialiResponse listaPosizioniIniziali(game.ListaPosizioniIniziali listaPosizioniIniziali) {
        ListaPosizioniInizialiResponse resp = new ListaPosizioniInizialiResponse();
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.GetPosizioniIniziali partitaStub = new WSDataStub.GetPosizioniIniziali();
            partitaStub.setIdtoken(listaPosizioniIniziali.getIdtoken());
            partitaStub.setUsername(listaPosizioniIniziali.getUsername());
            partitaStub.setNomePartita(listaPosizioniIniziali.getNomePartita());
            WSDataStub.GetPosizioniInizialiResponse dataResp = stub.getPosizioniIniziali(partitaStub);

            resp.set_return(dataResp.get_return());
            return resp;
        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/listaPosizioniIniziali");
            resp.set_return("ERR:" + e.toString());
            return resp;
        }
    }

    /**
     * Inserisce un log nel database, richiamando il metodo dal servizio WSData
     *
     * @param message  String
     * @param function String
     * @return boolean: conferma inserimento log
     */
    boolean insertLog(String message, String function) {
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.InsertLOG log = new WSDataStub.InsertLOG();
            log.setMessaggio(message);
            log.setFunzione(function);
            log.setIdtoken("");

            stub.insertLOG(log);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Chiamante per gestione mosse, dal DB o XML.
     *
     * @param idtoken     Token della partita generata
     * @param username    Username del giocatore che ha avviato la partita
     * @param nomePartita Nome della partita in analisi.
     * @return GetTurnoResponse (int turno. 1=sfidato, 2=sfidante. -1=ERRORE)
     */
    private String mossePartita(String idtoken, String username, String nomePartita) {

        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.GetMosse partitaStub = new WSDataStub.GetMosse();
            partitaStub.setIdtoken(idtoken);
            partitaStub.setUsername(username);
            partitaStub.setNomePartita(nomePartita);
            WSDataStub.GetMosseResponse dataResp = stub.getMosse(partitaStub);

            return dataResp.get_return();
        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/mossePartita");
            return "ERR:" + e.toString();
        }

    }

    /**
     * Metodo interno di getTurno, separato per essere usato in piu punti del servizio.
     *
     * @param idtoken     Token della partita generata
     * @param username    Username del giocatore che ha avviato la partita
     * @param nomePartita Nome della partita in analisi.
     * @param mosse       Elenco delle mosse che identificano il turno
     * @return int (int turno. 1=chiamante, 2=avversario. -1=ERRORE)
     */
    int getTurno(String idtoken, String username, String nomePartita, String mosse) {
        String CHAR_SEPARATE = ";";
        if (!mosse.startsWith("ERR")) {//non c'e errore nel recupero della lista mosse in DB
            if (mosse.equals("")) {//non ci sono mosse, il turno e del giocatore init
                try {
                    WSDataStub stub = new WSDataStub();
                    WSDataStub.IsUtenteIniziale giocatoreInit = new WSDataStub.IsUtenteIniziale();
                    giocatoreInit.setIdtoken(idtoken);
                    giocatoreInit.setUsername(username);
                    giocatoreInit.setNomePartita(nomePartita);
                    WSDataStub.IsUtenteInizialeResponse dataResp = stub.isUtenteIniziale(giocatoreInit);
                    if (dataResp.get_return()) {
                        return 1;
                    } else {
                        return 2;
                    }
                } catch (RemoteException e) {
                    insertLog("ERR:" + e.toString(), "WSGame/getTurno");
                    return -1;
                }

            } else {//il turno dipende dall'ultima mossa fatta
                try {
                    WSDataStub stub = new WSDataStub();
                    WSDataStub.GetUtente utente = new WSDataStub.GetUtente();
                    utente.setIdtoken(idtoken);
                    WSDataStub.GetUtenteResponse dataResp = stub.getUtente(utente);
                    if (!dataResp.get_return().startsWith("ERR")) {//esiste l'utente e ne controllo lo username con GetUtente
                        String[] arrayMosse = mosse.split(CHAR_SEPARATE);
                        String user = arrayMosse[arrayMosse.length - 1].substring(1, arrayMosse[arrayMosse.length - 1].indexOf(")"));
                        //insertLog(arrayMosse[arrayMosse.length-1]+" -"+user+"-"+"/"+dataResp.get_return()+"/", "WSGame/getTurno");
                        if (user.trim().equals(dataResp.get_return())) {    //ultima mossa � del chiamante, tocca a sfidante
                            return 2;
                        } else {    //ultima mossa dello sfidante, tocca al chiamante
                            return 1;
                        }
                    } else {
                        insertLog(dataResp.get_return(), "WSGame/getTurno");
                        return -1;
                    }
                } catch (RemoteException e) {
                    insertLog("ERR:" + e.toString(), "WSGame/getTurno");
                    return -1;
                }
            }

        } else {
            insertLog(mosse, "WSGame/getTurno");
            return -1;
        }

    }

    /**
     * Restituisce il valore di chi ha il turno, indicando con 1 il chiamante, con 2 l'avversario.
     *
     * @param getTurno (String idtoken,String nomePartita)
     * @return GetTurnoResponse (int turno. 1=chiamante, 2=avversario. -1=ERRORE)
     */
    public game.GetTurnoResponse getTurno(game.GetTurno getTurno) {
        GetTurnoResponse resp = new GetTurnoResponse();

        //recupero i dati dal chiamante
        String idtoken = getTurno.getIdtoken();
        String username = getTurno.getUsername();
        String nomePartita = getTurno.getNomePartita();
        String mosse = "";

        //controllo le mosse per la partita dei due giocatori
        //e decido il turno a chi tocca
        mosse = mossePartita(idtoken, username, nomePartita);
        resp.set_return(getTurno(idtoken, username, nomePartita, mosse));
        return resp;
    }

    /**
     * Cancello una partita esistente, chiamando il servizio WSData per DB.
     *
     * @param cancellaPartita (String idtoken,String nomePartita)
     * @return CancellaPartitaResponse (boolean di conferma)
     */
    public game.CancellaPartitaResponse cancellaPartita(game.CancellaPartita cancellaPartita) {
        CancellaPartitaResponse resp = new CancellaPartitaResponse();

        //recupero i dati dal chiamante
        String idtoken = cancellaPartita.getIdtoken();

        String nomePartita = cancellaPartita.getNomePartita();

        //controllo se esiste una partita per questi due giocatori
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.DeletePartita partitaStub = new WSDataStub.DeletePartita();
            partitaStub.setIdtoken(idtoken);
            partitaStub.setNomePartita(nomePartita);
            WSDataStub.DeletePartitaResponse dataResp = stub.deletePartita(partitaStub);
            //gestire qui eventuale XML!!!!!!!

            if (!dataResp.get_return()) {//non c'e errore nella cancellazione in DB
                resp.set_return(dataResp.get_return());
                return resp;
            } else {
                insertLog("ERR:InvalidMatch", "WSGame/listaMosse");
                resp.set_return(dataResp.get_return());
                return resp;
            }
        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/listaMosse");
            resp.set_return(false);
            return resp;
        }
    }

    /**
     * Recupero della lista delle mosse salvate in una partita, chiamando WSData per DB.
     *
     * @param listaMosse (String idtoken,String username,String nomePartita)
     * @return ListaMosseResponse (String listaMosse)
     */
    public game.ListaMosseResponse listaMosse(game.ListaMosse listaMosse) {
        ListaMosseResponse resp = new ListaMosseResponse();

        //recupero i dati dal chiamante
        String idtoken = listaMosse.getIdtoken();
        String username = listaMosse.getUsername();
        String nomePartita = listaMosse.getNomePartita();
        String mosse = "";
        //controllo se esiste una partita per questi due giocatori

        mosse = mossePartita(idtoken, username, nomePartita);
        if (!mosse.startsWith("ERR")) {//non c'e errore nel recupero della lista mosse in DB
            resp.set_return(mosse);
            return resp;
        } else {
            insertLog(mosse, "WSGame/listaMosse");
            resp.set_return(mosse);
            return resp;
        }

    }

    private String printTavoloLogico(Tavolo tavoloLogico) {
        try {
            String tavolo = "";
            String CHAR_SEPARATE = "|";
            Pezzo[][] pezzo = tavoloLogico.getBaseLogica();
            for (int i = 0; i < pezzo.length; i++) {
                for (int j = 0; j < pezzo[i].length; j++) {
                    if (pezzo[i][j] != null)
                        tavolo += "" + i + j + ";" + pezzo[i][j].getNumero() + ";" + pezzo[i][j].getGiocatore() + "|";
                }
                //tavolo+="\n";
            }
            if (tavolo.endsWith(CHAR_SEPARATE)) tavolo = tavolo.substring(0, tavolo.length() - 1);
            return tavolo;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Prepara il tavolo prendendo i dati in formato raw arrivati come stringa dal client
     *
     * @param rawData String (formato:  coordinata;posizione;giocatore|coordinata2;....)
     * @return Tavolo (Tavolo con pezzi posizionati e pronti)
     */
    private Tavolo preparaTavoloLogico(String rawData) {
        Tavolo t = new Tavolo();
        Pezzo[][] pezzo = new Pezzo[6][6];

        int x, y, posizione, giocatore;
        String vettorePosizioni[] = rawData.split("\\|");
        for (String aVettorePosizioni : vettorePosizioni) {
            String pedina[] = aVettorePosizioni.split("\\;");
            //pedina[0]=coordinata
            //pedina[1]=posizione
            //pedina[2]=giocatore

            x = Integer.parseInt(pedina[0].substring(0, 1));//coordinata 0
            y = Integer.parseInt(pedina[0].substring(1, 2));//coordinata 1
            posizione = Integer.parseInt(pedina[1]);
            giocatore = Integer.parseInt(pedina[2]);

            pezzo[x][y] = new Pezzo(new Coordinata((byte) x, (byte) y), (byte) giocatore, (byte) posizione, t.getBaseLogica());
            t.aggiungiPezzo(new Coordinata((byte) x, (byte) y), pezzo[x][y]);

        }
        System.out.println("PEZZI CATTIVI:" + t.getNumeroPezziCattivi((byte) 1));
        System.out.println("PEZZI BUONI:" + t.getNumeroPezziBuoni((byte) 1));
        System.out.println("PEZZI CATTIVI_man:" + t.getNumeroPezziCattivi((byte) 2));
        System.out.println("PEZZI BUONI_man:" + t.getNumeroPezziBuoni((byte) 2));


        //t.aggiornaMosseLegali();
        return t;
    }

    /**
     * Generazione della mossa dell'IA, chiama la classe IntelligenzaArtificiale, analizza il tavolo
     * in base al profilo dei giocatori e suggerisce la mossa opportuna.
     *
     * @param generaMossaIA (String idtoken,String username,String username_sfidato(tipo composto user+Tavolo))
     * @return GeneraMossaIAResponse (String mossaConsigliata)
     */
    public game.GeneraMossaIAResponse generaMossaIA(game.GeneraMossaIA generaMossaIA) {
        GeneraMossaIAResponse resp = new GeneraMossaIAResponse();
        String idtoken = generaMossaIA.getIdtoken();
        String username = generaMossaIA.getUsername();
        String data = generaMossaIA.getUsername_sfidato();
        String username_sfidato = "";
        String nomePartita = "";

        String temp[] = data.split("TAVOLO:");
        username_sfidato = temp[0].substring(2);//tolgo IA davanti

        Giocatore giocatore_correnteIA = new Giocatore("password", (byte) 2, username_sfidato, "1");
        Giocatore giocatore_avversarioIO = new Giocatore("password", (byte) 1, username, "2");
        nomePartita = getNomePartita(idtoken, username, username_sfidato);
        new ValutaPezziLog(nomePartita);
        Tavolo t = preparaTavoloLogico(temp[1]);
        int id_sfidato = getUtenteIDDB(username_sfidato);
        double liv1 = getLivelloDB(nomePartita, 1);
        double liv2 = getLivelloDB(nomePartita, 2);


        String mossa = getMossaIntelligenzaArtificiale(t, liv1, liv2, giocatore_correnteIA, giocatore_avversarioIO, nomePartita);
        resp.set_return(mossa);
        return resp;
    }

    /**
     * Richiama il DB per recuperare il livello richiesto nella partita specifica
     *
     * @param nomePartita nome della partita in analisi.
     * @param livello     1 per giocatore1, 2 per giocatore2
     * @return double il livello richiesto, settato nei parametri della partita
     * <p/>
     * Probabilmente questo metodo va spostato nel WSData, dipende dal livello di indipendenza si vorr� dare ai vari gestori dell'IA.
     */
    double getLivelloDB(String nomePartita, int livello) {
        double result = 0.5;//default medio su una scala da 1=principiante a 0=difficile ... -1 random
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/geister";
            Connection con = DriverManager.getConnection(url, "root", "sportster");
            Statement s = con.createStatement();
            String selectQuery = "select livello" + livello + " from partite where nome_partita like '" + nomePartita + "';";
            new ValutaPezziLog(selectQuery);
            s.executeQuery(selectQuery);
            ResultSet rsID = s.getResultSet();
            if (rsID.next()) {
                result = rsID.getDouble(1);

            }

            // chiudere le risorse DB e obbligatorio
            rsID.close();
            s.close();
            con.close();
            return result;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return result;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return result;
        }
    }

    /**
     * Richiama il DB per recuperare l'id del giocatore richiesto nel profiler del Ranker.
     *
     * @param username Username del giocatore che ha avviato la partita
     * @return int l'id del giocatore
     * <p/>
     * Probabilmente questo metodo va spostato nel WSData, dipende dal livello di indipendenza si vorr� dare ai vari gestori dell'IA.
     */
    int getUtenteIDDB(String username) {
        int result = 0;//default medio su una scala da 1=principiante a 0=difficile ... -1 random
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/geister";
            Connection con = DriverManager.getConnection(url, "root", "sportster");
            Statement s = con.createStatement();
            String selectQuery = "select id from utenti where username like '" + username + "';";
            s.executeQuery(selectQuery);
            ResultSet rsID = s.getResultSet();
            if (rsID.next()) {
                result = rsID.getInt(1);

            }

            // chiudere le risorse DB � obbligatorio
            rsID.close();
            s.close();
            con.close();
            return result;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            new ValutaPezziLog(e.toString());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            new ValutaPezziLog(e.toString());
            return result;
        }
    }

    /**
     * Chiama l'intelligenza artificiale e restituisce la mossa calcolata in base ai profili
     */
    String getMossaIntelligenzaArtificiale(Tavolo t, double liv, double livAvv, Giocatore gioc_corr, Giocatore avv, String nomePar) {
        try {

            IntelligenzaArtificiale IA = IAFactory.getInstance().getIA(t, gioc_corr, avv, liv, nomePar, EuristicheFactory.EURISTICHE.ATTACCOAIBUONI, StrategieFactory.STRATEGIE.MINMAXAB, RankerFactory.RANKERS.DISTANZAVETTORI);
            Mossa mossa = IA.calcolaMossa();

            Coordinata partenza = mossa.getPartenza();
            Coordinata arrivo = mossa.getArrivo();
            if (arrivo != null) {
                return String.valueOf(partenza.getRiga()) + String.valueOf(partenza.getColonna()) +
                        " " + String.valueOf(arrivo.getRiga() + String.valueOf(arrivo.getColonna()));
            } else {
                String partenza1 = String.valueOf(partenza.getRiga()) + String.valueOf(partenza.getColonna());
                switch (partenza1) {
                    case "00":
                        return partenza1 + " " + "99"; //mossa di uscita in basso a sinistra
                    case "05":
                        return partenza1 + " " + "06"; //mossa di uscita in basso a sinistra
                    default:
                        return partenza1 + " " + "99"; //mossa di uscita in basso a sinistra default test
                }
            }
        } catch (Exception e) {
            return (e.toString());
        }
    }

    /**
     * Inserimento di una nuova mossa, con richiamo al servizio dati per salvare in DB.
     *
     * @param eseguiMossa (String idtoken,String nomePartita, String mossa)
     * @return EseguiMossaResponse (boolean conferma)
     */
    public game.EseguiMossaResponse eseguiMossa(game.EseguiMossa eseguiMossa) {
        EseguiMossaResponse resp = new EseguiMossaResponse();

        //recupero i dati dal chiamante
        String idtoken = eseguiMossa.getIdtoken();
        String nomePartita = eseguiMossa.getNomePartita();
        String mossa = eseguiMossa.getMossa();
        String username = eseguiMossa.getUsername();
        //controllo se esiste una partita per questi due giocatori
        try {
            //controllo le mosse per la partita dei due giocatori
            //e decido il turno a chi tocca
            String mosseP = mossePartita(idtoken, "", nomePartita);
            int turno = getTurno(idtoken, "", nomePartita, mosseP);
            if (turno != -1) {
                if (turno == 1 || (turno == 2 && username.startsWith("IA"))) {
                    //tocca al chiamante o alla realta virtuale, inserimento possibile
                    WSDataStub stub = new WSDataStub();
                    WSDataStub.InsertMossa mosse = new WSDataStub.InsertMossa();
                    mosse.setIdtoken(idtoken);
                    mosse.setNomePartita(nomePartita);
                    mosse.setUsername(username);
                    mosse.setPos_iniziale(Integer.parseInt(mossa.substring(0, 2)));
                    mosse.setMangia(mossa.substring(2, 3));
                    mosse.setPos_finale(Integer.parseInt(mossa.substring(3, 5)));


                    WSDataStub.InsertMossaResponse dataResp = stub.insertMossa(mosse);
                    if (dataResp.get_return()) {//inserimento avvenuto con successo
                        resp.set_return(true);
                        return resp;
                    } else {
                        insertLog("ERR:noInsert", "WSGame/eseguiMossa");
                        resp.set_return(false);
                        return resp;
                    }
                } else {
                    insertLog("ERR:InvalidRound", "WSGame/eseguiMossa");
                    resp.set_return(false);
                    return resp;
                }
            } else {
                insertLog("ERR:", "WSGame/eseguiMossa");
                resp.set_return(false);
                return resp;
            } //turno=-1
        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/eseguiMossa");
            resp.set_return(false);
            return resp;
        }
    }

    /**
     * Inserimento di una nuova posizione iniziale, con richiamo al servizio dati per salvare in DB.
     *
     * @param nuovaPosizioneIniziale (String idtoken,String nomePartita, String pedina, int posizione)
     * @return NuovaPosizioneInizialeResponse (boolean conferma)
     */
    public game.NuovaPosizioneInizialeResponse nuovaPosizioneIniziale(game.NuovaPosizioneIniziale nuovaPosizioneIniziale) {
        NuovaPosizioneInizialeResponse resp = new NuovaPosizioneInizialeResponse();

        //recupero i dati dal chiamante
        String idtoken = nuovaPosizioneIniziale.getIdtoken();
        String nomePartita = nuovaPosizioneIniziale.getNomePartita();
        String pedina = nuovaPosizioneIniziale.getPedina();
        int posizione = nuovaPosizioneIniziale.getPosizione();

        //controllo se esiste una partita per questi due giocatori
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.InsertPosizioneIniziale posizioni = new WSDataStub.InsertPosizioneIniziale();
            posizioni.setIdtoken(idtoken);
            posizioni.setNomePartita(nomePartita);
            posizioni.setPedina(pedina);
            posizioni.setPosizione(posizione);

            WSDataStub.InsertPosizioneInizialeResponse dataResp = stub.insertPosizioneIniziale(posizioni);
            if (dataResp.get_return()) {//inserimento avvenuto con successo
                resp.set_return(true);
                return resp;
            } else {
                insertLog("ERR:noInsert", "WSGame/nuovaPosizioneIniziale");
                resp.set_return(false);
                return resp;
            }
        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/nuovaPosizioneIniziale");
            resp.set_return(false);
            return resp;
        }
    }

    /**
     * Gestione di una nuova partita, con richiamo al servizio dati per salvare in DB.
     *
     * @param nuovaPartita (String idtoken,String nomePartita, byte GiocatoreInizio, String username,String username_sfidato,double livello1,double livello2,boolean allenamento1,boolean allenamento2)
     * @return NuovaPartitaResponse (boolean conferma)
     */
    public game.NuovaPartitaResponse nuovaPartita(game.NuovaPartita nuovaPartita) {
        NuovaPartitaResponse resp = new NuovaPartitaResponse();

        //recupero i dati dal chiamante
        String idtoken = nuovaPartita.getIdtoken();
        String username = nuovaPartita.getUsername();
        String username_sfidato = nuovaPartita.getUsername_sfidato();
        String nomePartita = nuovaPartita.getNomePartita();
        byte giocatore_init = nuovaPartita.getGiocatoreInizio();
        double livello1 = nuovaPartita.getLivello1();
        double livello2 = nuovaPartita.getLivello2();
        boolean allenamento1 = nuovaPartita.getAllenamento1();
        boolean allenamento2 = nuovaPartita.getAllenamento2();


        //controllo se esiste una partita per questi due giocatori
        try {
            WSDataStub stub = new WSDataStub();
            WSDataStub.GetNomePartita partitaStub = new WSDataStub.GetNomePartita();
            partitaStub.setIdtoken(idtoken);
            partitaStub.setUsername(username);
            partitaStub.setUsername_sfidato(username_sfidato);
            WSDataStub.GetNomePartitaResponse dataResp = stub.getNomePartita(partitaStub);

            if (!dataResp.get_return().equals(nomePartita)) {//non c'e match tra i due utenti con questo nome: posso creare la partita nel db
                //gestire qui eventuale XML!!!!!!!

                resp.set_return(insertPartitaDB(idtoken, username, username_sfidato, nomePartita, giocatore_init, livello1, livello2, allenamento1, allenamento2));
                return resp;
            } else {
                insertLog("ERR:InvalidMatch", "WSGame/NuovaPartita");
                resp.set_return(false);
                return resp;
            }
        } catch (RemoteException e) {
            insertLog("ERR:" + e.toString(), "WSGame/NuovaPartita");
            resp.set_return(false);
            return resp;
        }
    }
}
