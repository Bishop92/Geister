package apprendimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import apprendimento.features.FeatureCollector;
import apprendimento.ranker.Ranker;
import apprendimento.ranker.RankerFactory;
import logica.Giocatore;
import logica.Pezzo;
import logica.Tavolo;

/**
 * Dato un pezzo, chiede la bonta rispetto ad un algoritmo
 * <p>&nbsp;
 * ChangeLog:
 * LS:Cambiato costruttore, invece di Partita, passo tavolo direttamente.
 * </p>
 *
 * @author Appon Luca
 * @author Luca Semenzato
 * @version 2.0 del 02/01/2012
 */

public class ValutaPezzi {

    /**
     * Il tavolo da valutare
     */
    private Tavolo tavolo;
    /**
     * Il giocatore che deve muovere
     */
    private Giocatore giocatoreCorrente;
    /**
     * L'avversario del giocatore
     */
    private Giocatore avversario;
    /**
     * Il livello dell'avversario
     */
    private double livelloAvversario;
    /**
     * Il nome dell'algoritmo necessario per valutare il profilo offline
     */
    private String learner;
    /**
     * Il nome della partita che si sta giocando
     */
    private String nomePartita;
    /**
     * L'oggetto adibito a raccogliere le feature dei pezzi
     */
    private FeatureCollector featureCollector;
    /**
     * L'algoritmo che definisce la tipologia dei pezzi
     */
    private Ranker ranker;

    /**
     * @param gCorrente   Il giocatore corrente
     * @param a           L'avversario del giocatore corrente
     * @param lAvversario Livello dell'avversario
     * @param nPartita    Nome della partita
     * @param r           L'algoritmo per la valutazione della tipologia dei pezzi
     */
    public ValutaPezzi(Giocatore gCorrente, Giocatore a, double lAvversario, String nPartita, RankerFactory.RANKERS r) {
        giocatoreCorrente = gCorrente;
        avversario = a;
        livelloAvversario = lAvversario;
        nomePartita = nPartita;
        learner = getNomeLearner(getNomeRanker());
        RankerFactory rankerFactory = RankerFactory.getInstance();
        ranker = rankerFactory.getRanker(r);
        featureCollector = new FeatureCollector();
    }

    /**
     * Imposta il tavolo dopo una mossa da parte dell'avversario
     * @param t Il tavolo
     */
    public void setTavolo(Tavolo t) {
        tavolo = t;
    }

    /**
     * Recupera il nome del Learner associato a questo Ranker.
     * I Learner possono essere piu d'uno, di default prende il primo.<br>
     * Se non e presente alcun learner, prova con MediaV<br>
     * Se si desidera forzare l'uso di un learner specifico, usare setNomeLearner(...)
     *
     * @return String nome del Learner associato.
     */
    private String getNomeLearner(String nomeRanker) {
        String nL = "mediaV";
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/geister";
            Connection con = DriverManager.getConnection(url, "root", "sportster");
            Statement cmd = con.createStatement();
            String query = "SELECT learners.nome FROM profili_u_l_r " +
                    " INNER JOIN utenti ON profili_u_l_r.id_utente=utenti.id " +
                    " INNER JOIN learners_rankers ON profili_u_l_r.id_learner_ranker=learners_rankers.id " +
                    " INNER JOIN learners ON learners_rankers.id_learner=learners.id " +
                    " INNER JOIN rankers ON learners_rankers.id_ranker=rankers.id " +
                    " WHERE utenti.username LIKE '" + avversario.getNome() + "' " +
                    " AND rankers.nome LIKE '" + nomeRanker + "' ORDER BY profili_u_l_r.id;";

            ResultSet res = cmd.executeQuery(query);
            if (res.next())
                nL = res.getString(1);

            res.close(); // chiudere le risorse DB e obbligatorio
            cmd.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nL;
    }

    /**
     * Resituisce il nome del ranker in base all'utente IA ad esso associato nel database.
     *
     * @return Nome del ranker associato a quell'utente
     */
    private String getNomeRanker() {
        String nR = "rankerMV"; //default
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/geister";
            Connection con = DriverManager.getConnection(url, "root", "sportster");
            Statement cmd = con.createStatement();
            String query = "SELECT rankers.nome FROM rankers " +
                    " INNER JOIN utenti ON rankers.id_IA=utenti.id " +
                    " WHERE utenti.username LIKE '" + giocatoreCorrente.getNome() + "'" +
                    " ORDER BY rankers.id;";

            ResultSet res = cmd.executeQuery(query);
            if (res.next())
                nR = res.getString(1);

            res.close(); // chiudere le risorse DB e obbligatorio
            cmd.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nR;
    }

    /**
     * Fornisce il profilo dei pezzi buoni e cattivi dell'avversario
     *
     * @return Il profilo dei pezzi buoni e cattivi dell'avversario
     */
    public Vector<Vector<Double>> getValutazione() {
        Vector<Vector<Double>> pezzi = new Vector<Vector<Double>>();
        pezzi.add(ottieniProfilo(true));
        pezzi.add(ottieniProfilo(false));
        return pezzi;
    }

    /**
     * Metodo con un parametro che restituisce un vettore di double che rappresenta
     * il profilo medio dei pezzi buoni o cattivi.
     * Dato il parametro booleano buono se e true crea il profilo dei pezzi buoni dell'avversario se false quello dei pezzo cattivi e lo ritorna
     *
     * @param buono Indica se viene richiesto l'elenco dei pezzi buoni o l'elenco dei pezzi cattivi
     * @return il vettore dei pezzi buoni o cattivi
     */
    private Vector<Double> ottieniProfilo(boolean buono) {
        Vector<Double> risultato = new Vector<Double>();
        String profilo = "";
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/geister";
            Connection con = DriverManager.getConnection(url, "root", "sportster");
            Statement cmd = con.createStatement();
            String query = "SELECT profilo FROM profili_u_l_r " +
                    " INNER JOIN utenti ON profili_u_l_r.id_utente=utenti.id " +
                    " INNER JOIN learners_rankers ON profili_u_l_r.id_learner_ranker=learners_rankers.id " +
                    " INNER JOIN learners ON learners_rankers.id_learner=learners.id " +
                    " WHERE utenti.username LIKE '" + avversario.getNome() + "' AND " +
                    " learners.nome like '" + learner + "';";
            ResultSet res = cmd.executeQuery(query);
            while (res.next())
                profilo = res.getString("profilo");

            res.close(); // chiudere le risorse DB e obbligatorio
            cmd.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        new ValutaPezziLog("Ottieni profilo");
        //se l'algoritmo scelto non e in profilo, esco
        if (!profilo.contains(learner + ":")) {
            new ValutaPezziLog("ALGO NON IN PROFILO");
            return null;
        }

        int inizio = profilo.indexOf(learner + ":") + learner.length() + 1;

        int fine = profilo.indexOf("::", inizio);

        int inizio_r = profilo.indexOf("r", inizio);
        //+2 per evitare "r" e "[", -1 per evitare "]"
        String buoni = profilo.substring(inizio + 2, inizio_r - 1);
        String cattivi = profilo.substring(inizio_r + 2, fine - 1);

        String[] val_buoni = buoni.split(",");
        String[] val_cattivi = cattivi.split(",");
        for (int i = 0; i < val_buoni.length; i++) {
            if (buono)
                risultato.add(Double.parseDouble(val_buoni[i].trim()));
            else
                risultato.add(Double.parseDouble(val_cattivi[i].trim()));
        }

        new ValutaPezziLog("PROFILO=" + risultato);
        return risultato;
    }

    /**
     * Disabilitare l'intelligenza artificiale per evitare di prevedere di che tipo sono i fantasmi avversari.
     */
    public void disattivaProfilo() {
        tavolo.ripristinaTavolo(avversario.getNumero());
        tavolo.ripristinaDisposizionePezzi(avversario.getNumero());
    }

    /**
     * Abilitare l'intelligenza artificiale per poter prevedere di che tipo sono i pezzi avversari.
     */
    public void aggiornaProfilo() {
        Vector<Vector<Double>> pezzi = getValutazione();
        Vector<Double> profiloBuoni = pezzi.elementAt(0);
        Vector<Double> profiloCattivi = pezzi.elementAt(1);
        //reimposto i pezzi dell'avversario
        tavolo.reimpostaTavolo(avversario.getNumero());
        //se esiste un profilo aggiorno la bonta dei pezzi e poi li ridistribuisco all'interno dei vettori
        if (profiloBuoni != null)
            aggiornaBontaPezzi(profiloBuoni, profiloCattivi);
        else
            //se non c'e' il profilo dispongo correttamente i pezzi all'interno dei vettori
            tavolo.reimpostaDisposizionePezzi(avversario.getNumero());
    }


    /**
     * Assegna ad ogni pezzo dell'avversario, il suo profilo.
     */
    private void caricaProfiloNeiPezzi() {
        //salvo in una variabile il vettore di log della partita
        LogPartita logPartita = new LogPartita(nomePartita);

        //ottengo le varie feature dei pezzi registrate turno per turno
        FeatureCollector.FeaturePezzi output = featureCollector.analizzaMosse(avversario.getNumero(), logPartita, 0);

        //creo un unico vettore contenente tutti i pezzi
        Vector<Pezzo> pezzi;
        if (avversario.getNumero() == 1) {
            pezzi = tavolo.vettorePezzi((byte) 1);
            pezzi.addAll(tavolo.vettorePezzi((byte) 2));
        } else {
            pezzi = tavolo.vettorePezzi((byte) 3);
            pezzi.addAll(tavolo.vettorePezzi((byte) 4));
        }

        for (Pezzo pezzo : pezzi) {
            //memorizzo il numero del pezzo in esame
            byte num_pezzo = pezzo.getNumero();

            //scorro l'output alla ricerca dell'ultimo vettore coi dati per quel pezzo
            Vector<Double> vettorePezzo = new Vector<Double>();
            for (Vector<Double> vPezzo : output.getVettoriPezzi())
                if (vPezzo.elementAt(0) == num_pezzo)
                    vettorePezzo = vPezzo;

            //memorizzo il vettore di quel pezzo, partendo dall'elemento 1 poiche in 0 si trova l'id del pezzo
            Vector<Double> profilo_pezzo = new Vector<Double>();
            profilo_pezzo.addAll(vettorePezzo);
            profilo_pezzo.remove(0);

            //assegno al pezzo il vettore appena creato
            ((PezzoNascosto) pezzo).setFeatures(profilo_pezzo);
        }
    }

    /**
     * Aggiorna il coefficiente di bonta di ogni pezzo avversario
     */
    public void aggiornaBontaPezzi(Vector<Double> profiloBuoni, Vector<Double> profiloCattivi) {

        //aggiorno il profilo di ogni pezzo
        caricaProfiloNeiPezzi();

        Vector<Pezzo> pezzi = new Vector<Pezzo>();

        if (avversario.getNumero() == 1) {
            pezzi.addAll(tavolo.vettorePezzi((byte) 1));
            pezzi.addAll(tavolo.vettorePezzi((byte) 2));
        } else {
            pezzi.addAll(tavolo.vettorePezzi((byte) 3));
            pezzi.addAll(tavolo.vettorePezzi((byte) 4));
        }

        //scorro il vettore dei pezzi
        for (Pezzo pezzo : pezzi)
            //aggiorno la bonta del pezzo in esame
            ((PezzoNascosto) pezzo).setBonta(ranker.getBonta((PezzoNascosto) pezzo, profiloBuoni, profiloCattivi, livelloAvversario));
    }
}