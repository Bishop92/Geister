package apprendimento.features;

import apprendimento.LogPartita;

import java.util.Vector;

/**
 * Classe adibita all'estrazione delle feature dei pezzi dal database, dopo aver ricevuto dal client
 * gli identificativi del giocatore e della partita relativi.
 *
 * @author Amir
 */

public class FeatureCollector {

    /**
     * Nel database ho la disposizione iniziale e le mosse.
     * Devo tradurle in feature.
     * <p/>
     * Feature:
     * 1-8: disposizione pezzo;
     * 9: prima mossa?
     * 10: seconda mossa?
     * 11: # avanti
     * 12: # indietro
     * 13: # laterale
     * 14: # minacciato -> mangia
     * 15: # minacciato -> scappa
     * 16: # minacciato -> resta
     * 17: # spostamenti per minacciare
     * <p/>
     * campi dati: id_giocatore,
     */

    //vector con, per ogni pezzo, l'ultima posizione nota nella partita del pezzo
    private Vector<String> pezziG1 = new Vector<String>();
    private Vector<String> pezziG2 = new Vector<String>();
    //vector con, per ogni pezzo, 1 se e vivo, 0 se e morto
    private Vector<Boolean> pezziViviG1 = new Vector<Boolean>();
    private Vector<Boolean> pezziViviG2 = new Vector<Boolean>();

    private Controllore controllore;
    //Feature giocatore 1
    private Vector<Feature> featuresG1 = new Vector<Feature>();
    //Feature giocatore 2
    private Vector<Feature> featuresG2 = new Vector<Feature>();

    public class FeaturePezzi {
        // Vector con array contenenti id pezzo al primo elemento e valori delle feature per ogni turno ai successivi
        private Vector<Vector<Double>> vettori_pezzi = new Vector<Vector<Double>>();

        public void addVettore(Vector<Double> vettore) {
            vettori_pezzi.add(vettore);
        }

        public Vector<Vector<Double>> getVettoriPezzi() {
            return vettori_pezzi;
        }
    }

    public FeatureCollector() {
        featuresG1 = new Vector<Feature>();
        featuresG2 = new Vector<Feature>();
        controllore = new Controllore(pezziViviG1, pezziViviG2, pezziG1, pezziG2);

        for (int i = 0; i < 8; i++) {
            pezziViviG1.add(true);
            pezziViviG2.add(true);
            pezziG1.addElement("");
            pezziG2.addElement("");
        }
        riempiFeatures(featuresG1);
        riempiFeatures(featuresG2);
    }

    //resetta i campi dati nella condizione iniziale
    private void inizializzaTutto() {
        for (int i = 0; i < 8; i++) {
            pezziViviG1.set(i, true);
            pezziViviG2.set(i, true);
            pezziG1.set(i, "");
            pezziG2.set(i, "");
        }
        featuresG1.clear();
        featuresG2.clear();
        riempiFeatures(featuresG1);
        riempiFeatures(featuresG2);
    }

    private void riempiFeatures(Vector<Feature> features) {
        for (int i = 0; i < 8; ++i)
            features.add(new PosizioneIniziale(8, i));
        features.add(new MossaAvanti(8));
        features.add(new MossaIndietro(8));
        features.add(new MossaLaterale(8));
        features.add(new MossaMangia(8, controllore));
        features.add(new MossaMinaccia(8, controllore));
        features.add(new MossaResta(8, controllore));
        features.add(new PrimaMossa(8));
        features.add(new SecondaMossa(8));
    }

    /**
     * Metodo che stabilisce se il giocatore preso in esame era il giocatore "1" o meno.
     * Utile per leggere il file di log della partita ed interpretare le mosse.
     *
     * @param id identificativo del giocatore
     * @return True se il giocatore era il primo, False altrimenti
     */
    private boolean primoGiocatore(int id, LogPartita partita) {
        return Integer.parseInt(partita.getLog().firstElement().substring(2).replace("\n", "")) == id;
    }

    private void disposizionePezzo(LogPartita partita) {

        //leggi righe da 2 a 9 se I, da 10 a 17 se II
        //aggiorna pezzi con la posizione di partenza:
        //per gioc1 => pezzi[x][1]=10, pezzi[x][2]=20, pezzi[x][3]=30,...
        //per gioc2 => pezzi[x][1]=14, pezzi[x][2]=24,...

        System.out.println("**** FEATURECOLLECTOR(DISPOSIZIONEPEZZO): ****** " + partita.getLog());
        /*
         * Disposizione:
		 * 0= 01 / 41
		 * 1= 02 / 42
		 * 2= 03 / 43
		 * 3= 04 / 44
		 * 4= 11 / 51
		 * 5= 12 / 52 
		 * 6= 13 / 53
		 * 7= 14 / 54
		 * 
		 */
        int g = 0;
        for (int j = 0; j < 16; j++) {
            if (j > 7)
                g = 1;

            int pezzo = Integer.parseInt(partita.getLog().elementAt(j + 2).substring(3 + g, 4 + g));

            if (j < 8) {
                pezziG1.setElementAt(partita.getLog().elementAt(j + 2).substring(0, 2), pezzo);
                featuresG1.get(j).resolve(j, "Posizionamento", pezzo, 1);
            } else {
                pezziG2.setElementAt(partita.getLog().elementAt(j + 2).substring(0, 2), pezzo);
                featuresG2.get(j - 8).resolve(j - 8, "Posizionamento", pezzo, 2);
            }
        }
    }

    /**
     * Analizza le mosse che sono state effettuate durante la partita e fornisce la relativa analisi delle feature
     *
     * @param giocatore   Il giocatore di cui si sta analizzando la partita
     * @param partita     La partita relativa da analizzare
     * @param turnoLimite Il turno in cui si vuole interrompere l'analisi
     * @return Il report dell'analisi delle feature
     */
    public FeaturePezzi analizzaMosse(int giocatore, LogPartita partita, int turnoLimite) {
        inizializzaTutto();

        if (turnoLimite > getLastTurn(partita))
            turnoLimite = 0;
        FeaturePezzi output = new FeaturePezzi();
        Vector<String> log = partita.getLog();
        int pezzoG1, pezzoG2;

        disposizionePezzo(partita);

        //tutti i pezzi all'inizio sono presenti nella scacchiera
        Vector<Boolean> pezziViviInizioTurnoG1 = new Vector<Boolean>();
        Vector<Boolean> pezziViviInizioTurnoG2 = new Vector<Boolean>();
        for (int a = 0; a < 8; a++) {
            pezziViviInizioTurnoG1.add(true);
            pezziViviInizioTurnoG2.add(true);
        }

        //Scorro i turni di gioco - fino al turno in cui e stato richiesto o fino alla fine
        for (int i = 18; i < log.size() && (turnoLimite == 0 || i < 18 + turnoLimite); ++i) {
            String mossaG1, mossaG2 = "";
            mossaG1 = log.elementAt(i).substring(log.elementAt(i).indexOf(".") + 1, log.elementAt(i).indexOf(".") + 6);

            pezzoG1 = trovaPezzo(mossaG1);

            for (Feature feature : featuresG1)
                feature.resolve(i - 18, mossaG1, pezzoG1, 1);

            //Se e' stata fatta la mossa da parte del secondo giocatore
            if (log.elementAt(i).contains(","))
                mossaG2 = log.elementAt(i).substring(log.elementAt(i).indexOf(",") + 1, log.elementAt(i).indexOf(",") + 6);
            //Se ha mosso anche il secondo giocatore
            if (!mossaG2.equals("")) {
                pezzoG2 = trovaPezzo(mossaG2);

                for (Feature feature : featuresG2)
                    feature.resolve(i - 18, mossaG2, pezzoG2, 1);
            }

            //aggiungo i vivi alla Struttura
            for (int v = 0; v < 8; v++) {
                //se il pezzo non era vivo all'inizio allora non memorizzo lo inserisco nella struttura
                if (pezziViviInizioTurnoG1.elementAt(v) && primoGiocatore(giocatore, partita)) {
                    output.addVettore(resolvePezzo(v, 1));
                    //se il pezzo e morto durante il turno comunque viene inserito, ma al turno successivo non sara piu presente
                    pezziViviInizioTurnoG1.setElementAt(pezziViviG1.elementAt(v), v);
                }
                if (pezziViviInizioTurnoG2.elementAt(v) && !primoGiocatore(giocatore, partita)) {
                    output.addVettore(resolvePezzo(v, 2));
                    pezziViviInizioTurnoG2.setElementAt(pezziViviG2.elementAt(v), v);
                }
            }
        }
        return output;
    }

    /**
     * Fornisce le feature per il pezzo del giocatorre
     *
     * @param pezzo     Il pezzo di cui si vogliono sapere le feature
     * @param giocatore Il giocatore che possiede il pezzo
     * @return L'insieme delle feature
     */
    Vector<Double> resolvePezzo(int pezzo, int giocatore) {
        Vector<Double> featurePezzo = new Vector<Double>();

        //La prima posizione la riservo per l'id del pezzo
        featurePezzo.add(((Integer)pezzo).doubleValue());

        if (giocatore == 1) {

            for (Feature feature : featuresG1)
                featurePezzo.add(feature.getFeature(pezzo));

        } else {
            for (Feature feature : featuresG2)
                featurePezzo.add(feature.getFeature(pezzo));
        }

        return featurePezzo;
    }

    /**
     * Aggiorna la posizione del pezzo dopo la mossa e restituisce l'id del pezzo che l'ha effettuata
     *
     * @param mossa La mossa (nella forma 01 o 43)
     * @return identificativo del pezzo (da 0 a 7)
     */
    private int trovaPezzo(String mossa) {
        int pezzo = -1;
        for (int j = 0; j < 8; j++) {
            System.out.println("RICERCA MOSSA = " + mossa.substring(0, 2));
            System.out.println("IN PEZZO = " + pezziG1.elementAt(j));
            if (pezziG1.elementAt(j).equals(mossa.substring(0, 2))) {
                pezzo = j;
                pezziG1.setElementAt(mossa.substring(3, 5), j);
            }
            System.out.println("E IN PEZZO = " + pezziG2.elementAt(j));
            if (pezziG2.elementAt(j).equals(mossa.substring(0, 2))) {
                pezzo = j;
                pezziG2.setElementAt(mossa.substring(3, 5), j);
            }
        }
        return pezzo;
    }

    /**
     * Fornisce l'ultimo turno della partita richiesta
     *
     * @param partita La partita di cui si vuole sapere l'ultimo turno
     * @return L'ultimo turno
     */
    private int getLastTurn(LogPartita partita) {
        int res = 0;
        String turno = partita.getLog().elementAt(partita.getLog().size() - 1);
        if (turno.substring(0, 2).endsWith("."))
            res = Integer.parseInt(turno.substring(0, 1));
        if (turno.substring(0, 3).endsWith("."))
            res = Integer.parseInt(turno.substring(0, 2));
        return res;
    }

    public int getNumFeatures() {
        return featuresG1.size();
    }
}