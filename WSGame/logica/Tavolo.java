/*
 **********************************************************************
 **********************************************************************
 **  _______   _______   __   _______   _______  _______    ______   **
 **  | _____|  | _____|  | |  | _____|  |__ __|  | _____|  | _____|  **
 **  | |	   | |       | |  | |         | |    | |       | |  | |  **
 **  | | ___   | |__     | |  | |____     | |    | |__     | |__| |  **
 **  | ||_  |  |  __|    | |  |_____ |    | |    |  __|    |    __|  **
 **  | |  | |  | |       | |       | |    | |    | |       | |\ \    **
 **  | |__| |  | |____   | |   ____| |    | |    | |____   | | \ \   **
 **  |______|  |______|  |_|  |______|    |_|    |______|  |_|  \_\  **
 **															         **
 **********************************************************************
 **********************************************************************
 * 
 * Autore: Mazzarelli Ivan
 * Data: 05/12/2007
*/

package logica;

import apprendimento.PezzoNascosto;

import java.util.Vector;

/**
 * <p>Questa classe ha lo scopo di rappresentare il tavolo di gioco contenente
 * tutti i pezzi di tutti i giocatori. Inoltre, tramite tale classe, e' possibile
 * inserire o eliminare i pezzi nel tavolo.</p>
 * <p>&nbsp;</p>
 * <p>&nbsp;</p>
 * <p><u><i>Elenco versioni:</i></u></p>
 * <p><i>ver. 5.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 25/11/2007
 * </i></p>
 * <ul>
 * <li>aggiunto metodo ripristinaTavolo</li>
 * <li>aggiunto metodo ripristinaDisposizionePezzi</li>
 * </ul>
 * <p><i>ver. 5.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/11/2007
 * </i></p>
 * <ul>
 * <li>modificato metodo muoviPezzo</li>
 * <li>modificato metodo reimpostaDisposizionePezzi</li>
 * <li>modificato metodo ridistribuzioneBuoniCattivi</li>
 * <li>aggiunto metodo incrementaDecrementaValore</li>
 * <li>aggiunto metodo distribuisciPezzi</li>
 * <li>aggiunto costruttore ad un parametro</li>
 * </ul>
 * <p><i>ver. 4.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 15/11/2007
 * </i></p>
 * <ul>
 * <li>aggiunto campo dati g1_pezzi_mangiati</li>
 * <li>aggiunto campo dati g2_pezzi mangiati</li>
 * <li>metodo muoviPezzo modificato</li>
 * <li>metodo EliminaPezzo modificato</li>
 * <li>metodo reimpostaTavolo modificato</li>
 * </ul>
 * <p><i>ver. 3.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 12/11/2007
 * </i></p>
 * <ul>
 * <li>aggiunto metodo reimpostaTavolo</li>
 * <li>aggiunto metodo reimpostaPezzi</li>
 * </ul>
 * <p><i>ver. 2.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 05/11/2007
 * </i></p>
 * <ul>
 * <li>modificato il metodo clone </li>
 * </ul>
 * <p><i>ver. 2.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 05/11/2007
 * </i></p>
 * <ul>
 * <li>modificato il metodo vettorePezzi </li>
 * <li>modificato il metodo eliminaPezzo </li>
 * <li>modificato il metodo aggiungiPezzo </li>
 * <li>aggiunto il metodo muoviPezzo </li>
 * <li>aggiunto il metodo aggiornaMosseLegali </li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 22/10/2007
 * </i></p>
 * <ul>
 * <li>aggiunto il metodo vettorePezzi </li>
 * <li>aggiunto il metodo getNumeroPezziCattivi </li>
 * <li>aggiunto il medoto getNumeroPezziBuoni </li>
 * </ul>
 * <p><i>ver. 0.3&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 22/10/2007 </i></p>
 * <ul>
 * <li>aggiunto il metodo clone </li>
 * </ul>
 * <p><i>ver. 0.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 21/10/2007
 * </i></p>
 * <ul>
 * <li>modificata la funzione eliminaPezzo </li>
 * <li>modificata la funzione aggiungiPezzo </li>
 * </ul>
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 19/10/2007
 * </i></p>
 * <ul>
 * <li>bozza iniziale
 * </li>
 * </ul>
 *
 * @author Mazzarelli Ivan
 * @version 5.1 del 25/11/2007
 * @see Pezzo
 */
public class Tavolo implements Cloneable {
    /**
     * rappresenta la base logica del gioco, in cui verranno aggiunti
     * tutti i pezzi dei giocatori
     */
    private Pezzo[][] base_logica = new Pezzo[6][6];
    /**
     * vettore contenente tutti i pezzi buoni del giocatore 1
     */
    private Vector<Pezzo> g1_pezzi_buoni = new Vector<Pezzo>();
    /**
     * vettore contenente tutti i pezzi cattivi del giocatore 1
     */
    private Vector<Pezzo> g1_pezzi_cattivi = new Vector<Pezzo>();
    /**
     * vettore contenente tutti i pezzi buoni mangiati dal giocatore 1
     */
    private Vector<Pezzo> g1_pezzi_buoni_mangiati = new Vector<Pezzo>();
    /**
     * vettore contenente tutti i pezzi cattivi mangiati dal giocatore 1
     */
    private Vector<Pezzo> g1_pezzi_cattivi_mangiati = new Vector<Pezzo>();
    /**
     * vettore contenente tutti i pezzi buoni del giocatore 2
     */
    private Vector<Pezzo> g2_pezzi_buoni = new Vector<Pezzo>();
    /**
     * vettore contenente tutti i pezzi cattivi del giocatore 2
     */
    private Vector<Pezzo> g2_pezzi_cattivi = new Vector<Pezzo>();
    /**
     * vettore contenente tutti i pezzi buoni mangiati dal giocatore 2
     */
    private Vector<Pezzo> g2_pezzi_buoni_mangiati = new Vector<Pezzo>();
    /**
     * vettore contenente tutti i pezzi cattivi mangiati dal giocatore 2
     */
    private Vector<Pezzo> g2_pezzi_cattivi_mangiati = new Vector<Pezzo>();

    /**
     * Costruttore ad un parametro che inizializza tutte le variabili della classe, impostando
     * la base logica inserita nel parametro
     *
     * @param tavolo matrice di pezzi rappresentante il tavolo di gioco su cui iniziare la partita
     */
    public Tavolo(Pezzo[][] tavolo) {
        base_logica = tavolo;
        distribuisciPezzi();
    }

    /**
     * Costruttore senza parametri che inizializza tutte le variabili
     * della classe con i valori di default
     */
    public Tavolo() {
        inizializzaBaseLogica();
    }


    /**
     * Metodo che ritorna un vettore contenente i pezzi in gioco del giocatore.
     * Se il giocatore usa l'intelligenza i pezzi avversari saranno di tipo pezzoNascosto
     *
     * @param gioc Giocatore che deve muovere
     * @return pezzi
     */
    public Vector<Pezzo> getPezziInGioco(byte gioc) {
        Vector<Pezzo> pezzi = new Vector<Pezzo>();
        if (gioc == (byte) 1) {
            /** aggiungo i pezzi al vettore da restituire*/
            for (Pezzo pezzo : g1_pezzi_buoni)
                pezzi.add(pezzo);
            for (Pezzo pezzo : g1_pezzi_cattivi)
                pezzi.add(pezzo);
        } else {
            /** aggiungo i pezzi al vettore da restituire*/
            for (Pezzo pezzo : g2_pezzi_buoni)
                pezzi.add(pezzo);
            for (Pezzo pezzo : g2_pezzi_cattivi)
                pezzi.add(pezzo);
        }
        return pezzi;
    }


    /**
     * Metodo a due parametri che elimina un pezzo alla base logica
     *
     * @param cor                   Coordinata dove si vuole eliminare il pezzo
     * @param aggiungere_al_vettore indica se il pezzo da eliminare bisogna aggiungerlo al vettore
     *                              dei pezzi mangiati
     * @return true se il pezzo e' stato eliminato, false altrimenti
     */
    public String eliminaPezzo(Coordinata cor, boolean aggiungere_al_vettore) {
        String temp_s = "-";
        //controllo che la cordinata non sia nulla
        if (cor == null)
            return null;
        //controllo che la casella identificata dalla coordinata non sia vuota
        Pezzo pezzo_da_eliminare = getPezzo(cor);
        if (pezzo_da_eliminare == null)
            return temp_s;
        //controllo se il pezzo è del giocatore 1
        if (pezzo_da_eliminare.getGiocatore() == 1) {

            //controllo se è buono
            if (((Pezzo) pezzo_da_eliminare).isBuono()) {
                temp_s = "b";
//				System.out.println("Sto eliminando pezzo BUONO giocatore 1 in coordinata: "+cor.getRiga()+" : "+cor.getColonna());
                //scorro tutti i pezzi buoni del giocatore 1
                for (int a = 0; a < g1_pezzi_buoni.size(); a++) {
                    //e controllo le coordinate del pezzo che voglio eliminare
                    if (cor.equals(g1_pezzi_buoni.get(a).getCoordinata())) {
                        //salvo temporaneamente il pezzo da eliminare
                        Pezzo temp = base_logica[cor.getRiga()][cor.getColonna()];
                        //testo se devo aggiungere il pezzo al vettore dei pezzi mangiati
                        if (aggiungere_al_vettore) {
                            //lo aggiungo al vettore dei pezzi mangiati da g2
                            g2_pezzi_buoni_mangiati.add(temp);
                        }
                        //elimino il pezzo
                        base_logica[cor.getRiga()][cor.getColonna()] = null;
                        g1_pezzi_buoni.removeElementAt(a);
//						System.out.println("Eliminato Pezzo dalla base logica e da pezzi buoni del giocatore1");
                        return temp_s;
                    }
                }
                //nei pezzi posseduti, non è presente il pezzo che dovrei eliminare
                return null;
            }
            //se è cattivo
            else {
                temp_s = "r";
//				System.out.println("Sto eliminando pezzo CATTIVO giocatore 1 in coordinata: "+cor.getRiga()+" : "+cor.getColonna());

                //scorro tutti i pezzi cattivi del giocatore 2
                for (int a = 0; a < g1_pezzi_cattivi.size(); a++) {
                    //e controllo le coordinate del pezzo che voglio eliminare
                    if (pezzo_da_eliminare.getCoordinata().equals(g1_pezzi_cattivi.get(a).getCoordinata())) {
                        //salvo temporaneamente il pezzo da eliminare
                        Pezzo temp = base_logica[cor.getRiga()][cor.getColonna()];
                        //testo se devo aggiungere il pezzo al vettore dei pezzi mangiati
                        if (aggiungere_al_vettore) {
                            //lo aggiungo al vettore dei pezzi mangiati da g2
                            g2_pezzi_cattivi_mangiati.add(temp);
                        }
                        //elimino il pezzo
                        base_logica[cor.getRiga()][cor.getColonna()] = null;
                        g1_pezzi_cattivi.removeElementAt(a);
//						System.out.println("Eliminato Pezzo dalla base logica e da pezzi cattivi del giocatore1");
                        return temp_s;
                    }
                }
                //nei pezzi posseduti, non è presente il pezzo che dovrei eliminare
                return null;
            }
        }
        //il pezzo è del giocatore 2
        else {
            //controllo se è buono
            if (((Pezzo) pezzo_da_eliminare).isBuono()) {
                temp_s = "b";
//				System.out.print("PRIMA DI ELIMINARE PEZZO.......");
//				System.out.println("pezzi buoni giocatore"+2);
                //scorro tutti i pezzi buoni del giocatore 2
//				System.out.println("ENTRA PER ELIMINARE UN PEZZO BUONO DEL GIOCATORE 2 totale pezzi "+g2_pezzi_buoni.size());
                for (int b = 0; b < g2_pezzi_buoni.size(); b++) {
                    //e controllo le coordinate del pezzo che voglio eliminare
//					System.out.println("pezzo da eliminare" +pezzo_da_eliminare.getCoordinata().getRiga()+pezzo_da_eliminare.getCoordinata().getColonna());
//					System.out.println("pezzo da g2_buoni" +g2_pezzi_buoni.get(b).getCoordinata().getRiga()+g2_pezzi_buoni.get(b).getCoordinata().getColonna());
                    if (pezzo_da_eliminare.getCoordinata().equals(g2_pezzi_buoni.get(b).getCoordinata())) {
                        //salvo temporaneamente il pezzo da eliminare
                        Pezzo temp = base_logica[cor.getRiga()][cor.getColonna()];
//						System.out.println("TROVATO PEZZO DA ELIMINARE COORDINATA "+cor.getRiga()+":"+cor.getColonna());
                        //testo se devo aggiungere il pezzo al vettore dei pezzi mangiati
                        if (aggiungere_al_vettore) {
                            //lo aggiungo al vettore dei pezzi mangiati da g1
                            g1_pezzi_buoni_mangiati.add(temp);
                        }
                        //elimino il pezzo
                        base_logica[cor.getRiga()][cor.getColonna()] = null;
//						System.out.println("NUMERO PEZZI BUONI G2 PRIMA: "+g2_pezzi_buoni.size());
                        g2_pezzi_buoni.removeElementAt(b);
//						System.out.println("NUMERO PEZZI BUONI G2 DOPO: "+g2_pezzi_buoni.size());
                        return temp_s;
                    }
                }
                //nei pezzi posseduti, non è presente il pezzo che dovrei eliminare
                return null;
            }
            //se è cattivo
            else {
                temp_s = "r";
                //scorro tutti i pezzi cattivi del giocatore 2
                for (int b = 0; b < g2_pezzi_cattivi.size(); b++) {
                    //e controllo le coordinate del pezzo che voglio eliminare
                    if (pezzo_da_eliminare.getCoordinata().equals(g2_pezzi_cattivi.get(b).getCoordinata())) {
                        //salvo temporaneamente il pezzo da eliminare
                        Pezzo temp = base_logica[cor.getRiga()][cor.getColonna()];
                        //testo se devo aggiungere il pezzo al vettore dei pezzi mangiati
                        if (aggiungere_al_vettore) {
                            //lo aggiungo al vettore dei pezzi mangiati da g1
                            g1_pezzi_cattivi_mangiati.add(temp);
                        }
                        //elimino il pezzo
                        base_logica[cor.getRiga()][cor.getColonna()] = null;
                        g2_pezzi_cattivi.removeElementAt(b);
                        return temp_s;
                    }
                }
                //nei pezzi posseduti, non è presente il pezzo che dovrei eliminare
                return null;
            }
        }
    }


    /**
     * Metodo a due parametri che aggiunge un pezzo alla base logica
     *
     * @param cor Coordinata dove si vuole aggiungere il pezzo
     * @param p   Pezzo che si vuole aggiungere
     * @return true se il pezzo e' stato aggiunto, false altrimenti
     */
    public boolean aggiungiPezzo(Coordinata cor, Pezzo p) {
        //controllo che i dati in input siano corretti
        if (cor == null || p == null)
            return false;
        //controllo che nella coordinata inserita non ci siano altri pezzi
        if (getPezzo(cor) != null)
            return false;
        //controllo se il pezzo è del giocatore 1
        if (p.getGiocatore() == 1) {
            //controllo se è buono
            if (((Pezzo) p).isBuono()) {
                base_logica[cor.getRiga()][cor.getColonna()] = p;
                //imposto la nuova coordinata del pezzo
                p.setCoordinata(cor);
                //aggiungo il pezzo ai pezzi buoni del primo giocatore
                g1_pezzi_buoni.addElement(p);
                return true;
            } else { //il pezzo è cattivo
                base_logica[cor.getRiga()][cor.getColonna()] = p;
                //imposto la nuova coordinata del pezzo
                p.setCoordinata(cor);
                //aggiungo il pezzo ai pezzi cattivi del primo giocatore
                g1_pezzi_cattivi.addElement(p);
                return true;
            }
        } else {//il pezzo è del giocatore 2
            //controllo se è buono
            if (((Pezzo) p).isBuono()) {
                base_logica[cor.getRiga()][cor.getColonna()] = p;
                //imposto la nuova coordinata del pezzo
                p.setCoordinata(cor);
                //aggiungo il pezzo ai pezzi buoni del secondo giocatore
                g2_pezzi_buoni.addElement(p);
                return true;
            } else { //il pezzo è cattivo
                base_logica[cor.getRiga()][cor.getColonna()] = p;
                //imposto la nuova coordinata del pezzo
                p.setCoordinata(cor);
                //aggiungo il pezzo ai pezzi cattivi del secondo giocatore
                g2_pezzi_cattivi.addElement(p);
                return true;
            }
        }
    }

    /**
     * Metodo con due parametri che, date le coordinate di partenza e di arrivo, muove
     * il pezzo sulla base_logica SENZA aggiornare le mosse legali di tutti i pezzi
     *
     * @param partenza Coordinata di partenza del pezzo
     * @param arrivo   Coordinata di arrivo del pezzo
     */
    public boolean muoviPezzo(Coordinata partenza, Coordinata arrivo) {

        Pezzo pezzo_temporaneo = getPezzo(partenza);
//		System.out.println("Sto muovendo il pezzo in coordinata -> "+pezzo_temporaneo.getCoordinata().getRiga()+" : "+pezzo_temporaneo.getCoordinata().getColonna());
//		System.out.println(" pezzi G1 == "+this.getNumeroPezziBuoni((byte)1)+this.getNumeroPezziCattivi((byte)1)+
//					" pezzi G2== "+this.getNumeroPezziBuoni((byte)2)+this.getNumeroPezziCattivi((byte)2));
        //elimino dalla scacchiera il pezzo che si sta muovendo
        eliminaPezzo(partenza, false);
//		System.out.println("eliminato partenza "+partenza.getRiga()+" : "+partenza.getColonna());
//		System.out.println(" pezzi G1 == "+this.getNumeroPezziBuoni((byte)1)+this.getNumeroPezziCattivi((byte)1)+
//				" pezzi G2== "+this.getNumeroPezziBuoni((byte)2)+this.getNumeroPezziCattivi((byte)2));

        //elimino il pezzo di arrivo
        eliminaPezzo(arrivo, true);
//		System.out.println("eliminato arrivo "+arrivo.getRiga()+" : "+arrivo.getColonna());
//		System.out.println(" pezzi G1 == "+this.getNumeroPezziBuoni((byte)1)+this.getNumeroPezziCattivi((byte)1)+
//				" pezzi G2== "+this.getNumeroPezziBuoni((byte)2)+this.getNumeroPezziCattivi((byte)2));

        //inserisco nella coordinata di arrivo il pezzo che ho mosso
        aggiungiPezzo(arrivo, pezzo_temporaneo);
        aggiornaMosseLegali();
        return true;

    }


    /**
     * Metodo senza parametri che ricalcola le mosse legali di tutti i pezzi.
     */
    public void aggiornaMosseLegali() {
        //per ogni pezzo di ogni vettore
        for (Pezzo pezzo : g1_pezzi_buoni)
            //richiamo il metodo ricalcolaMosseFattibili
            pezzo.ricalcolaMosseFattibili(base_logica);
        for (Pezzo pezzo : g1_pezzi_cattivi)
            //richiamo il metodo ricalcolaMosseFattibili
            pezzo.ricalcolaMosseFattibili(base_logica);
        for (Pezzo pezzo : g2_pezzi_buoni)
            //richiamo il metodo ricalcolaMosseFattibili
            pezzo.ricalcolaMosseFattibili(base_logica);
        for (Pezzo pezzo : g2_pezzi_cattivi)
            //richiamo il metodo ricalcolaMosseFattibili
            pezzo.ricalcolaMosseFattibili(base_logica);
    }

    /**
     * Metodo senza parametri che ritorna la base logica del tavolo
     *
     * @return Pezzo[][] - base logica del tavolo
     */
    public Pezzo[][] getBaseLogica() {
        return base_logica;
    }

    /**
     * Metodo senza parametri che inizializza la base logica con tutti i valori
     * uguali a null
     */
    private void inizializzaBaseLogica() {
        base_logica[0][0] = null;
        base_logica[0][1] = null;
        base_logica[0][2] = null;
        base_logica[0][3] = null;
        base_logica[0][4] = null;
        base_logica[0][5] = null;
        base_logica[1][0] = null;
        base_logica[1][1] = null;
        base_logica[1][2] = null;
        base_logica[1][3] = null;
        base_logica[1][4] = null;
        base_logica[1][5] = null;
        base_logica[2][0] = null;
        base_logica[2][1] = null;
        base_logica[2][2] = null;
        base_logica[2][3] = null;
        base_logica[2][4] = null;
        base_logica[2][5] = null;
        base_logica[3][0] = null;
        base_logica[3][1] = null;
        base_logica[3][2] = null;
        base_logica[3][3] = null;
        base_logica[3][4] = null;
        base_logica[3][5] = null;
        base_logica[4][0] = null;
        base_logica[4][1] = null;
        base_logica[4][2] = null;
        base_logica[4][3] = null;
        base_logica[4][4] = null;
        base_logica[4][5] = null;
        base_logica[5][0] = null;
        base_logica[5][1] = null;
        base_logica[5][2] = null;
        base_logica[5][3] = null;
        base_logica[5][4] = null;
        base_logica[5][5] = null;
    }

    /**
     * Metodo ad un parametro che ritorna il pezzo in una determinata Coordinata. Nel caso in cui
     * su tale coordinata non vi e' nessun pezzo, il metodo ritornera' null
     *
     * @param cor Coordinata della quale si vuole sapere l'eventuale presenta di un pezzo
     * @return Pezzo - pezzo presente nella Coordinata cor
     */
    public Pezzo getPezzo(Coordinata cor) {
        return base_logica[cor.getRiga()][cor.getColonna()];
    }

    /**
     * Metodo ad un parametro che restituisce i numero di pezzi buoni di un giocatore
     *
     * @param num_giocatore giocatore del quale si vuole sapere il numero di pezzi buoni
     * @return byte - numero pezzi buoni del giocatore
     */
    public byte getNumeroPezziBuoni(byte num_giocatore) {
        if (num_giocatore == 1)
            return (byte) g1_pezzi_buoni.size();
        if (num_giocatore == 2)
            return (byte) g2_pezzi_buoni.size();
        //se il num_giocatore è diverso da 1 e 2, ritorna un valore di errore
        return -1;
    }

    /**
     * Metodo ad un parametro che restituisce i numero di pezzi cattivi di un giocatore
     *
     * @param num_giocatore giocatore del quale si vuole sapere il numero di pezzi cattivi
     * @return byte - numero pezzi cattivi del giocatore
     */
    public byte getNumeroPezziCattivi(byte num_giocatore) {
        if (num_giocatore == 1)
            return (byte) g1_pezzi_cattivi.size();
        if (num_giocatore == 2)
            return (byte) g2_pezzi_cattivi.size();
        //se il num_giocatore è diverso da 1 e 2, ritorna un valore di errore
        return -1;
    }


    /**
     * Modifica il tavolo di gioco sostituendo i pezzi di un giocatore
     * con dei pezziNascosti dei quali non si sa esattamente se sono buoni o cattivi
     *
     * @param giocatore giocatore del quale si vogliono sostituire i pezzi
     */
    public void reimpostaTavolo(byte giocatore) {
        //testo se modificare i pezzi del giocator uno o due
        if (giocatore == 1) {
            //modifico i pezzi buoni del giocatore 1
            for (int i = 0; i < g1_pezzi_buoni.size(); i++) {
                Pezzo pezzo_vecchio = g1_pezzi_buoni.get(i);
                PezzoNascosto nuovo_pezzo = new PezzoNascosto(pezzo_vecchio, base_logica);
                g1_pezzi_buoni.setElementAt(nuovo_pezzo, i);
                //salvo il nuovo pezzo sulla base logica
                base_logica[nuovo_pezzo.getCoordinata().getRiga()][nuovo_pezzo.getCoordinata().getColonna()] = nuovo_pezzo;
            }
            //modifico i pezzi cattivi del giocatore 1
            for (int i = 0; i < g1_pezzi_cattivi.size(); i++) {
                Pezzo pezzo_vecchio = g1_pezzi_cattivi.get(i);
                PezzoNascosto nuovo_pezzo = new PezzoNascosto(pezzo_vecchio, base_logica);
                g1_pezzi_cattivi.setElementAt(nuovo_pezzo, i);
                //salvo il nuovo pezzo sulla base logica
                base_logica[nuovo_pezzo.getCoordinata().getRiga()][nuovo_pezzo.getCoordinata().getColonna()] = nuovo_pezzo;
            }
        }
        if (giocatore == 2) {
            //modifico i pezzi buoni del giocatore 2
            for (int i = 0; i < g2_pezzi_buoni.size(); i++) {
                Pezzo pezzo_vecchio = g2_pezzi_buoni.get(i);
                PezzoNascosto nuovo_pezzo = new PezzoNascosto(pezzo_vecchio, base_logica);
                g2_pezzi_buoni.setElementAt(nuovo_pezzo, i);
                //salvo il nuovo pezzo sulla base logica
                base_logica[nuovo_pezzo.getCoordinata().getRiga()][nuovo_pezzo.getCoordinata().getColonna()] = nuovo_pezzo;
            }
            //modifico i pezzi cattivi del giocatore 2
            for (int i = 0; i < g2_pezzi_cattivi.size(); i++) {
                Pezzo pezzo_vecchio = g2_pezzi_cattivi.get(i);
                PezzoNascosto nuovo_pezzo = new PezzoNascosto(pezzo_vecchio, base_logica);
                g2_pezzi_cattivi.setElementAt(nuovo_pezzo, i);
                //salvo il nuovo pezzo sulla base logica
                base_logica[nuovo_pezzo.getCoordinata().getRiga()][nuovo_pezzo.getCoordinata().getColonna()] = nuovo_pezzo;
            }
        }
    }

    /**
     * Metodo ad un parametro che modifica i vettori contenente i pezzi dei giocatori, spostando
     * i pezzi nel vettore opportuno. Questo metodo, gestisce solo il caso in cui i pezzi del
     * giocatore in questione facciano parte della classe pezzoNascosto, in quanto sposta i pezzi
     * prendendo come riferimento di bonta', un valore attribuito dall'intelligenza artificiale, e
     * non il valore effettivo del pezzo.
     *
     * @param giocatore giocatore del quale controllare (e sistemare) i pezzi
     */
    public void reimpostaDisposizionePezzi(byte giocatore) {
        if (giocatore == 1) {
            System.out.println("reimpostaDisposizionePezzi");
            //se i pezzi del giocatore non sono pezzi nascosto, esco dal metodo
            if (g1_pezzi_buoni.size() != 0 && !(g1_pezzi_buoni.get(0) instanceof PezzoNascosto)) {
                //System.out.println("QUI NON DEVE ENTRARE");
                return;
            }
            if (g1_pezzi_cattivi.size() != 0 && !(g1_pezzi_cattivi.get(0) instanceof PezzoNascosto)) {
                //System.out.println("QUI NON DEVE ENTRARE");
                return;
            }
            // � indice del while
            int i = 0;
            //scorro tutto il vettore dei pezzi buoni cercando i pezzi
            //che dovrebbero stare nel vettore dei pezzi cattivi
            while (i < g1_pezzi_buoni.size()) {
                //	for (int i=0; i<g1_pezzi_buoni.size(); i++){
                //se il pezzo e cattivo
                if (!g1_pezzi_buoni.get(i).isBuono()) {
                    //sposto il pezzo da un vettore all'altro
                    g1_pezzi_cattivi.addElement(g1_pezzi_buoni.remove(i));
                } else i++;
            }
            i = 0;
            while (i < g1_pezzi_cattivi.size()) {
                //for (int i=0; i<g1_pezzi_cattivi.size(); i++){
                //se il pezzo è buono
                if (g1_pezzi_cattivi.get(i).isBuono()) {
                    //sposto il pezzo da un vettore all'altro
                    g1_pezzi_buoni.addElement(g1_pezzi_cattivi.remove(i));
                } else i++;
            }
            /*
            //controllo che il numero di pezzi buoni/cattivi sia giusto
			if(g1_pezzi_buoni.size()>4 || g1_pezzi_cattivi.size()>)*/
            ridistribuzioneBuoniCattivi(giocatore);
        } else { //giocatore == 2

//			System.out.println("TAVOLO: Sto REIMPOSTANDO I PEZZI del giocatore "+giocatore);	

            //se i pezzi del giocatore non sono pezzi nascosto, esco dal metodo
            if (g2_pezzi_buoni.size() != 0 && !(g2_pezzi_buoni.get(0) instanceof PezzoNascosto))
                return;
            if (g2_pezzi_cattivi.size() != 0 && !(g2_pezzi_cattivi.get(0) instanceof PezzoNascosto))
                return;
            //scorro tutto il vettore dei pezzi buoni cercando i pezzi
            //che dovrebbero stare nel vettore dei pezzi cattivi
            int i = 0;
            while (i < g2_pezzi_buoni.size())
//			for (int i=0; i<g2_pezzi_buoni.size(); i++){
                //se il pezzo è cattivo
                if (!g2_pezzi_buoni.get(i).isBuono())
                    //sposto il pezzo da un vettore all'altro
                    g2_pezzi_cattivi.addElement(g2_pezzi_buoni.remove(i));
                else i++;
            i = 0;
            while (i < g2_pezzi_cattivi.size())
                //for (int i=0; i<g2_pezzi_cattivi.size(); i++){
                //se il pezzo è buono
                if (g2_pezzi_cattivi.get(i).isBuono())
                    //sposto il pezzo da un vettore all'altro
                    g2_pezzi_buoni.addElement(g2_pezzi_cattivi.remove(i));
                    //faccio ripartire la ricerca dall'indice in cui mi son fermato in quanto
                else i++;
            //controllo che il numero di pezzi buoni/cattivi sia giusto
            ridistribuzioneBuoniCattivi(giocatore);
        }
    }

    /**
     * Metodo con un parametro, che ripristina i pezzi di un giocatore da pezziNascosti a Pezzi
     *
     * @param giocatore byte indicante il giocatore del quale si vogliono ripristinare i pezzi
     */
    public void ripristinaTavolo(byte giocatore) {
        //testo se modificare i pezzi del giocator uno o due
        if (giocatore == 1) {
            //modifico i pezzi buoni del giocatore 1
            for (int i = 0; i < g1_pezzi_buoni.size(); i++) {
                Pezzo pezzo_nuovo = new Pezzo(g1_pezzi_buoni.get(i));
                g1_pezzi_buoni.setElementAt(pezzo_nuovo, i);
                //salvo il pezzo nuovo sulla base logica
                base_logica[pezzo_nuovo.getCoordinata().getRiga()][pezzo_nuovo.getCoordinata().getColonna()] = pezzo_nuovo;
            }
            //modifico i pezzi cattivi del giocatore 1
            for (int i = 0; i < g1_pezzi_cattivi.size(); i++) {
                Pezzo pezzo_nuovo = new Pezzo(g1_pezzi_cattivi.get(i));
                g1_pezzi_cattivi.setElementAt(pezzo_nuovo, i);
                //salvo il pezzo nuovo sulla base logica
                base_logica[pezzo_nuovo.getCoordinata().getRiga()][pezzo_nuovo.getCoordinata().getColonna()] = pezzo_nuovo;
            }
        }
        if (giocatore == 2) {
            //modifico i pezzi buoni del giocatore 2
            for (int i = 0; i < g2_pezzi_buoni.size(); i++) {
                Pezzo pezzo_nuovo = new Pezzo(g2_pezzi_buoni.get(i));
                g2_pezzi_buoni.setElementAt(pezzo_nuovo, i);
                //salvo il pezzo nuovo sulla base logica
                base_logica[pezzo_nuovo.getCoordinata().getRiga()][pezzo_nuovo.getCoordinata().getColonna()] = pezzo_nuovo;
            }
            //modifico i pezzi cattivi del giocatore 2
            for (int i = 0; i < g2_pezzi_cattivi.size(); i++) {
                Pezzo pezzo_nuovo = new Pezzo(g2_pezzi_cattivi.get(i));
                g2_pezzi_cattivi.setElementAt(pezzo_nuovo, i);
                //salvo il pezzo nuovo sulla base logica
                base_logica[pezzo_nuovo.getCoordinata().getRiga()][pezzo_nuovo.getCoordinata().getColonna()] = pezzo_nuovo;
            }
        }
    }

    /**
     * Metodo ad un parametro che modifica i vettori contenente i pezzi dei giocatori, spostando
     * i pezzi nel vettore opportuno.
     *
     * @param giocatore giocatore del quale controllare (e sistemare) i pezzi
     */
    public void ripristinaDisposizionePezzi(byte giocatore) {
        // testo se ripristinare i pezzi del giocatore uno o due
        if (giocatore == 1) {
            //scorro tutto il vettore dei pezzi buoni cercando i pezzi
            //che devono stare nel vettore dei pezzi cattivi
            int i = 0;
            while (i < g1_pezzi_buoni.size())
                //se il pezzo è cattivo
                if (!g1_pezzi_buoni.get(i).isBuono())
                    //sposto il pezzo da un vettore all'altro
                    g1_pezzi_cattivi.addElement(g1_pezzi_buoni.remove(i));
                else i++;
            i = 0;
            while (i < g1_pezzi_cattivi.size())
                if (g1_pezzi_cattivi.get(i).isBuono())
                    //sposto il pezzo da un vettore all'altro
                    g1_pezzi_buoni.addElement(g1_pezzi_cattivi.remove(i));
                else i++;
        } else { //giocatore == 2
            //scorro tutto il vettore dei pezzi buoni cercando i pezzi
            //che devono stare nel vettore dei pezzi cattivi
            int i = 0;
            while (i < g2_pezzi_buoni.size())
                //se il pezzo è cattivo
                if (!g2_pezzi_buoni.get(i).isBuono())
                    //sposto il pezzo da un vettore all'altro
                    g2_pezzi_cattivi.addElement(g2_pezzi_buoni.remove(i));
                else i++;
            i = 0;
            while (i < g2_pezzi_cattivi.size())
                if (g2_pezzi_cattivi.get(i).isBuono())
                    //sposto il pezzo da un vettore all'altro
                    g2_pezzi_buoni.addElement(g2_pezzi_cattivi.remove(i));
                else i++;
        }
    }

    /**
     * Metodo ad un parametro che permette di distribuire il numero di pezzi buoni
     * e cattivi in modo opportuno, tenendo conto dei pezzi che sono stati mangiati
     * dell'avversario.
     *
     * @param giocatore giocatore del quale si vogliono ridistribuire i pezzi
     */
    private void ridistribuzioneBuoniCattivi(byte giocatore) {
        System.out.println("TAVOLO: Sto RIDISTRIBUENDO BUONI/CATTIVI del giocatore " + giocatore);

        if (giocatore == 1) {
            int num_buoni_teorico = 4 - g2_pezzi_buoni_mangiati.size();

            //controllo se il numero teorico ed effettivo dei pezzi coincide
            if (num_buoni_teorico != g1_pezzi_buoni.size()) {
                //i pezzi sono disposti in modo sbagliato
                //i pezzi teorici sono minori dei pezzi effettivi
                if (num_buoni_teorico < g1_pezzi_buoni.size()) {
                    //cerco il pezzo con il grado di bonta' maggiore (tra i pezzi buoni) e lo sposto nel
                    //vettore dei pezzi cattivi
                    double valore_max = -1;
                    int indice_max = 0;
                    for (int indice = 0; indice < g1_pezzi_buoni.size(); indice++) {
                        //memorizzo la bonta' del pezzo in questione
                        double valore_pezzo = ((PezzoNascosto) g1_pezzi_buoni.get(indice)).getBonta();
                        //se la bonta' e' maggiore o uguale al valore massimo,
                        //lo memorizzo nelle variabili valore_max ed indice_max
                        if (valore_pezzo >= valore_max) {
                            valore_max = valore_pezzo;
                            indice_max = indice;
                        }
                    }
                    //memorizzo il valore che devo aggiungere al pezzo che voglio spostare
                    //(quindi devo fare -valore_max, visto che valore_max e' sempre negativo)
                    double valore_da_aggiungere = -valore_max + 0.001;
                    //aggiungo alla bonta' di tutti i pezzi cattivi il valore del pezzo che
                    //sto per inserire
//					incrementaDecrementaValore(g1_pezzi_cattivi, valore_da_aggiungere);
                    //reimposto la bonta' del pezzo che devo spostare
                    ((PezzoNascosto) g1_pezzi_buoni.get(indice_max)).aggiungiBonta(valore_da_aggiungere);
                    //ora so qual'e' il pezzo di valore massimo e lo sposto nel vettore dei pezzi cattivi
                    g1_pezzi_cattivi.addElement(g1_pezzi_buoni.remove(indice_max));
                    //richiamo ricorsivamente la funzione per constatare che il numero di pezzi
                    //teorici ed effettivi dei pezzi, sia uguale
                    ridistribuzioneBuoniCattivi(giocatore);
                } else { //i pezzi teorici sono maggiori del numero di pezzi effettivi
                    //cerco il pezzo con il grado di bonta' minore (tra i pezzi cattivi )e lo sposto nel
                    //vettore dei pezzi buoni

                    double valore_min = 1;
                    int indice_min = 0;
                    for (int indice = 0; indice < g1_pezzi_cattivi.size(); indice++) {
                        //memorizzo la bonta' del pezzo in questione
                        double valore_pezzo = ((PezzoNascosto) g1_pezzi_cattivi.get(indice)).getBonta();
                        //se la bonta' e' minore o uguale al valore minimo,
                        //lo memorizzo nelle variabili valore_min ed indice_min
                        if (valore_pezzo <= valore_min) {
                            valore_min = valore_pezzo;
                            indice_min = indice;
                        }
                    }
                    //memorizzo il valore che devo aggiungere al pezzo che voglio spostare
                    //(quindi devo fare -valore_min, visto che valore_min e' sempre positivo)
                    double valore_da_aggiungere = -valore_min - 0.001;
                    //aggiungo alla bonta' di tutti i pezzi buoni il valore del pezzo che
                    //sto per inserire
//					incrementaDecrementaValore(g1_pezzi_buoni, valore_da_aggiungere);
                    //reimposto la bonta' del pezzo che devo spostare
                    System.out.println("sono qui:" + g1_pezzi_cattivi.size());
                    if (g1_pezzi_cattivi.size() > 0) { //solo se indice=0 e il minimo, e non il default
                        //perche con size=0 va in overflow
                        ((PezzoNascosto) g1_pezzi_cattivi.get(indice_min)).aggiungiBonta(valore_da_aggiungere);

                        //ora so qual'e' il pezzo di valore massimo e lo sposto nel vettore dei pezzi cattivi
                        g1_pezzi_buoni.addElement(g1_pezzi_cattivi.remove(indice_min));
                        //richiamo ricorsivamente la funzione per constatare che il numero di pezzi
                        //teorici ed effettivi dei pezzi, sia uguale
                        ridistribuzioneBuoniCattivi(giocatore);
                    }
                }
            }
        } else { //giocatore == 2
            int num_buoni_teorico = 4 - g1_pezzi_buoni_mangiati.size();
            //controllo se il numero teorico ed effettivo dei pezzi coincide
            if (num_buoni_teorico != g2_pezzi_buoni.size())
                //i pezzi sono disposti in modo sbagliato
                //i pezzi teorici sono minori dei pezzi effettivi
                if (num_buoni_teorico < g2_pezzi_buoni.size()) {
                    //cerco il pezzo con il grado di bonta' maggiore (tra i pezzi buoni) e lo sposto nel
                    //vettore dei pezzi cattivi
                    double valore_max = -1;
                    int indice_max = 0;
                    for (int indice = 0; indice < g2_pezzi_buoni.size(); indice++) {
                        //memorizzo la bonta' del pezzo in questione
                        double valore_pezzo = ((PezzoNascosto) g2_pezzi_buoni.get(indice)).getBonta();
                        //se la bonta' e' maggiore o uguale al valore massimo,
                        //lo memorizzo nelle variabili valore_max ed indice_max
                        if (valore_pezzo >= valore_max) {
                            valore_max = valore_pezzo;
                            indice_max = indice;
                        }
                    }
//					System.out.println("HO TROVATO UN PEZZO DA REDISTRIBUIRE CON BONTA' "+valore_max);
                    //memorizzo il valore che devo aggiungere al pezzo che voglio spostare
                    //(quindi devo fare -valore_max, visto che valore_max e' sempre negativo)
                    double valore_da_aggiungere = -valore_max + 0.001;
                    //aggiungo alla bonta' di tutti i pezzi cattivi il valore del pezzo che
                    //sto per inserire
//					incrementaDecrementaValore(g2_pezzi_cattivi, valore_da_aggiungere);
                    //reimposto la bonta' del pezzo che devo spostare
                    ((PezzoNascosto) g2_pezzi_buoni.get(indice_max)).aggiungiBonta(valore_da_aggiungere);
                    //ora so qual'e' il pezzo di valore massimo e lo sposto nel vettore dei pezzi cattivi
                    g2_pezzi_cattivi.addElement(g2_pezzi_buoni.remove(indice_max));
                    //richiamo ricorsivamente la funzione per constatare che il numero di pezzi
                    //teorici ed effettivi dei pezzi, sia uguale
                    ridistribuzioneBuoniCattivi(giocatore);
                } else { //i pezzi teorici sono maggiori del numero di pezzi effettivi
                    //cerco il pezzo con il grado di bonta' minore (tra i pezzi cattivi )e lo sposto nel
                    //vettore dei pezzi buoni
                    double valore_min = 1;
                    int indice_min = 0;
                    for (int indice = 0; indice < g2_pezzi_cattivi.size(); indice++) {
                        //memorizzo la bonta' del pezzo in questione
                        double valore_pezzo = ((PezzoNascosto) g2_pezzi_cattivi.get(indice)).getBonta();
                        //se la bonta' e' minore o uguale al valore minimo,
                        //lo memorizzo nelle variabili valore_min ed indice_min
                        if (valore_pezzo <= valore_min) {
                            valore_min = valore_pezzo;
                            indice_min = indice;
                        }
                    }
//					System.out.println("HO TROVATO UN PEZZO DA REDISTRIBUIRE CON BONTA' "+valore_min);
                    //memorizzo il valore che devo aggiungere al pezzo che voglio spostare
                    //(quindi devo fare -valore_min, visto che valore_min e' sempre positivo)
                    double valore_da_aggiungere = -valore_min - 0.001;
                    //aggiungo alla bonta' di tutti i pezzi buoni il valore del pezzo che
                    //sto per inserire (quindi devo fare -valore_min, visto che valore_min e' sempre positivo)
//					incrementaDecrementaValore(g2_pezzi_buoni, valore_da_aggiungere);					
                    //reimposto la bonta' del pezzo che devo spostare
                    ((PezzoNascosto) g2_pezzi_cattivi.get(indice_min)).aggiungiBonta(valore_da_aggiungere);
                    //ora so qual'e' il pezzo di valore massimo e lo sposto nel vettore dei pezzi cattivi
                    g2_pezzi_buoni.addElement(g2_pezzi_cattivi.remove(indice_min));
                    //richiamo ricorsivamente la funzione per constatare che il numero di pezzi
                    //teorici ed effettivi dei pezzi, sia uguale
                    ridistribuzioneBuoniCattivi(giocatore);
                }
        }
    }

    /**
     * Metodo ad un parametro che restituisce un vettore contenente tutti i pezzi
     * di un determinato tipo di un giocatore
     *
     * @param tipo indica il tipo di vettore che voglio ottenere:<p>
     *             1 = pezzi buoni giocatore 1<p>
     *             2 = pezzi cattivi giocatore 1<p>
     *             3 = pezzi buoni giocatore 2<p>
     *             4 = pezzi cattivi giocatore 2<p>
     * @return Vector<Pezzo> - contiene l'elenco dei pezzi desiderati
     */
    public Vector<Pezzo> vettorePezzi(byte tipo) {
        switch (tipo) {
            case 1:
                return g1_pezzi_buoni;
            case 2:
                return g1_pezzi_cattivi;
            case 3:
                return g2_pezzi_buoni;
            case 4:
                return g2_pezzi_cattivi;
            default:
                return null;
        }
    }

    /**
     * metodo senza parametri che distribuisce i pezzi presenti nella base logica nei corrispettivi vettori
     */
    private void distribuisciPezzi() {
        for (int riga = 0; riga < 6; riga++) {
            for (int colonna = 0; colonna < 6; colonna++) {
                //se la casella e' vuota, continuo il ciclo
                if (base_logica[riga][colonna] == null)
                    continue;
                //controllo se e' un pezzo buono del giocatore 1
                if (base_logica[riga][colonna].getNumero() >= 0 && base_logica[riga][colonna].getNumero() < 4)
                    g1_pezzi_buoni.add(base_logica[riga][colonna]);
                //controllo se e' un pezzo cattivo del giocatore 1
                if (base_logica[riga][colonna].getNumero() >= 4 && base_logica[riga][colonna].getNumero() < 8)
                    g1_pezzi_cattivi.add(base_logica[riga][colonna]);
                //controllo se e' un pezzo buono del giocatore 2
                if (base_logica[riga][colonna].getNumero() >= 10 && base_logica[riga][colonna].getNumero() < 14)
                    g2_pezzi_buoni.add(base_logica[riga][colonna]);
                //controllo se e' un pezzo cattivo del giocatore 2
                if (base_logica[riga][colonna].getNumero() >= 14 && base_logica[riga][colonna].getNumero() < 18)
                    g2_pezzi_cattivi.add(base_logica[riga][colonna]);
            }
        }
    }

    /**
     * Metodo senza parametri che permette di effettuare una copia profonda dell'oggetto
     * di invocazione.
     * Questo metodo concretizza l'interfaccia Clonable, e proprio per questo motivo,
     * l'oggetto ritornato è di tipo Object.
     *
     * @return ritorna un Object rappresentante la copia del tavolo su cui è stato
     * richiamato il metodo.
     */
    public Object clone() {
        try {
            Tavolo t = (Tavolo) super.clone();
            //creo una base_logica temporanea
            Pezzo[][] temp_base_logica = new Pezzo[6][6];
            //copio la matrice della base logica nella base_logica temporanea
            for (int riga = 0; riga < 6; riga++) {
                for (int colonna = 0; colonna < 6; colonna++) {
                    //se il valore da copiare e' null
                    if (base_logica[riga][colonna] == null) {
                        //inserisco nella matrice logica copiata il valore null
                        temp_base_logica[riga][colonna] = null;
                    } else { //se non e' presente un valore divero da null
                        //creo un pezzo temporaneo clonando il pezzo che voglio inserire
                        Pezzo nuovo_pezzo = (Pezzo) base_logica[riga][colonna].clone();
                        //copio il pezzo nella matrice temporanea
                        temp_base_logica[riga][colonna] = nuovo_pezzo;
                    }
                }
            }
            //sostituisco la base logica di t con la base_logica temporanea appena creata
            t.base_logica = temp_base_logica;
            //creo un vettore temporaneo dove inserire i pezzi buoni del giocatore 1
            Vector<Pezzo> temp_g1_pezzi_buoni = new Vector<Pezzo>();
            //copio nel vettore temp_g1_pezzi_buoni i nuovi reference clonati
            for (Pezzo aG1_pezzi_buoni : g1_pezzi_buoni) {
                Pezzo pezzo_temporaneo = (Pezzo) aG1_pezzi_buoni.clone();
                temp_g1_pezzi_buoni.addElement(pezzo_temporaneo);
            }
            //copio il vettore temporaneo nel vettore dell'oggetto t
            t.g1_pezzi_buoni = temp_g1_pezzi_buoni;

            //creo un vettore temporaneo dove inserire i pezzi cattivi del giocatore 1
            Vector<Pezzo> temp_g1_pezzi_cattivi = new Vector<Pezzo>();
            //copio nel vettore temp_g1_pezzi_cattivi i nuovi reference clonati
            for (Pezzo aG1_pezzi_cattivi : g1_pezzi_cattivi) {
                Pezzo pezzo_temporaneo = (Pezzo) aG1_pezzi_cattivi.clone();
                temp_g1_pezzi_cattivi.addElement(pezzo_temporaneo);
            }
            //copio il vettore temporaneo nel vettore dell'oggetto t
            t.g1_pezzi_cattivi = temp_g1_pezzi_cattivi;

            //creo un vettore temporaneo dove inserire i pezzi buoni mangiati dal giocatore 1
            Vector<Pezzo> temp_g1_pezzi_buoni_mangiati = new Vector<Pezzo>();
            //copio nel vettore temp_g2_pezzi_buoni_mangiati i nuovi reference clonati
            for (Pezzo aG1_pezzi_buoni_mangiati : g1_pezzi_buoni_mangiati) {
                Pezzo pezzo_temporaneo = (Pezzo) aG1_pezzi_buoni_mangiati.clone();
                temp_g1_pezzi_buoni_mangiati.addElement(pezzo_temporaneo);
            }
            //copio il vettore temporaneo nel vettore dell'oggetto t
            t.g1_pezzi_buoni_mangiati = temp_g1_pezzi_buoni_mangiati;

            //creo un vettore temporaneo dove inserire i pezzi cattivi mangiati dal giocatore 1
            Vector<Pezzo> temp_g1_pezzi_cattivi_mangiati = new Vector<Pezzo>();
            //copio nel vettore temp_g2_pezzi_cattivi_mangiati i nuovi reference clonati
            for (Pezzo aG1_pezzi_cattivi_mangiati : g1_pezzi_cattivi_mangiati) {
                Pezzo pezzo_temporaneo = (Pezzo) aG1_pezzi_cattivi_mangiati.clone();
                temp_g1_pezzi_cattivi_mangiati.addElement(pezzo_temporaneo);
            }
            //copio il vettore temporaneo nel vettore dell'oggetto t
            t.g1_pezzi_cattivi_mangiati = temp_g1_pezzi_cattivi_mangiati;

            //creo un vettore temporaneo dove inserire i pezzi buoni del giocatore 2
            Vector<Pezzo> temp_g2_pezzi_buoni = new Vector<Pezzo>();
            //copio nel vettore temp_g2_pezzi_buoni i nuovi reference clonati
            for (Pezzo aG2_pezzi_buoni : g2_pezzi_buoni) {
                Pezzo pezzo_temporaneo = (Pezzo) aG2_pezzi_buoni.clone();
                temp_g2_pezzi_buoni.addElement(pezzo_temporaneo);
            }
            //copio il vettore temporaneo nel vettore dell'oggetto t
            t.g2_pezzi_buoni = temp_g2_pezzi_buoni;

            //creo un vettore temporaneo dove inserire i pezzi cattivi del giocatore 2
            Vector<Pezzo> temp_g2_pezzi_cattivi = new Vector<Pezzo>();
            //copio nel vettore temp_g2_pezzi_cattivi i nuovi reference clonati
            for (Pezzo aG2_pezzi_cattivi : g2_pezzi_cattivi) {
                Pezzo pezzo_temporaneo = (Pezzo) aG2_pezzi_cattivi.clone();
                temp_g2_pezzi_cattivi.addElement(pezzo_temporaneo);
            }
            //copio il vettore temporaneo nel vettore dell'oggetto t
            t.g2_pezzi_cattivi = temp_g2_pezzi_cattivi;

            //creo un vettore temporaneo dove inserire i pezzi buoni mangiati dal giocatore 2
            Vector<Pezzo> temp_g2_pezzi_buoni_mangiati = new Vector<Pezzo>();
            //copio nel vettore temp_g2_pezzi_buoni_mangiati i nuovi reference clonati
            for (Pezzo aG2_pezzi_buoni_mangiati : g2_pezzi_buoni_mangiati) {
                Pezzo pezzo_temporaneo = (Pezzo) aG2_pezzi_buoni_mangiati.clone();
                temp_g2_pezzi_buoni_mangiati.addElement(pezzo_temporaneo);
            }
            //copio il vettore temporaneo nel vettore dell'oggetto t
            t.g2_pezzi_buoni_mangiati = temp_g2_pezzi_buoni_mangiati;

            //creo un vettore temporaneo dove inserire i pezzi cattivi mangiati dal giocatore 2
            Vector<Pezzo> temp_g2_pezzi_cattivi_mangiati = new Vector<Pezzo>();
            //copio nel vettore temp_g2_pezzi_cattivi_mangiati i nuovi reference clonati
            for (Pezzo aG2_pezzi_cattivi_mangiati : g2_pezzi_cattivi_mangiati) {
                Pezzo pezzo_temporaneo = (Pezzo) aG2_pezzi_cattivi_mangiati.clone();
                temp_g2_pezzi_cattivi_mangiati.addElement(pezzo_temporaneo);
            }
            //copio il vettore temporaneo nel vettore dell'oggetto t
            t.g2_pezzi_cattivi_mangiati = temp_g2_pezzi_cattivi_mangiati;


            //ritorno l'oggetto appena creato
            return t;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
