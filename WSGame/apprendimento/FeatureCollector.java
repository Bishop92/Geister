package apprendimento;

import logica.*;
import apprendimento.features.*;

import java.awt.Container;
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

    private Vector<Feature> features;

    //vector con, per ogni pezzo, l'ultima posizione nota nella partita del pezzo
    private Vector<String> pezzi_1 = new Vector<String>();
    private Vector<String> pezzi_2 = new Vector<String>();
    //vector con, per ogni pezzo, 1 se � vivo, 0 se � morto
    private Vector<Integer> pezzi_vivi1 = new Vector<Integer>();
    private Vector<Integer> pezzi_vivi2 = new Vector<Integer>();

    private Vector<Integer> pezzi_1_inizio = new Vector<Integer>();
    private Vector<Integer> pezzi_2_inizio = new Vector<Integer>();

    private Vector<Integer> temp_minacciato1 = new Vector<Integer>();
    private Vector<Integer> temp_minacciato2 = new Vector<Integer>();

    private Vector<Integer> temp_prime_mosse = new Vector<Integer>();
    private Vector<Integer> temp_avanti = new Vector<Integer>();
    private Vector<Integer> temp_indietro = new Vector<Integer>();
    private Vector<Integer> temp_later = new Vector<Integer>();
    private Vector<Integer> temp_avanti2 = new Vector<Integer>();
    private Vector<Integer> temp_indietro2 = new Vector<Integer>();
    private Vector<Integer> temp_later2 = new Vector<Integer>();
    private Vector<Integer> temp_scappa = new Vector<Integer>();
    private Vector<Integer> temp_scappa2 = new Vector<Integer>();
    private Vector<Integer> temp_mangia = new Vector<Integer>();
    private Vector<Integer> temp_mangia2 = new Vector<Integer>();
    private Vector<Integer> temp_resta = new Vector<Integer>();
    private Vector<Integer> temp_resta2 = new Vector<Integer>();
    private Vector<Integer> temp_minaccia = new Vector<Integer>();
    private Vector<Integer> temp_minaccia2 = new Vector<Integer>();

	/*
    private Struttura output;
	*/

    public class Struttura {
        // Vector con array contenenti id pezzo al primo elemento e valori delle feature per ogni turno ai successivi
        private Vector<Integer[]> vettori_pezzi = new Vector<Integer[]>();

        public Struttura() {
			/*
			int gioc=2;
			if(primoGiocatore(id_giocatore))
				gioc=1;
			
			pezzi_vivi=contaPezziVivi(gioc);
			*/
        }

        public void addVettore(Integer[] vettore) {
            vettori_pezzi.add(vettore);
        }

        public Vector<Integer[]> getVettoriPezzi() {
            return vettori_pezzi;
        }

        public int getIdPezzo(int cardinalita) {
            return vettori_pezzi.elementAt(cardinalita)[0];
        }
    }

    /**
     * @param id: identificativo del giocatore
     */
    public FeatureCollector() {
        features = new Vector<Feature>();

        for (int i = 0; i < 8; i++) {
            pezzi_vivi1.add(1);
            pezzi_vivi2.add(1);
            pezzi_1.addElement("");
            pezzi_2.addElement("");
            pezzi_1_inizio.add(0);
            pezzi_2_inizio.add(0);
            temp_minacciato1.add(0);
            temp_minacciato2.add(0);
            temp_avanti.add(0);
            temp_indietro.add(0);
            temp_later.add(0);
            temp_avanti2.add(0);
            temp_indietro2.add(0);
            temp_later2.add(0);
            temp_scappa.add(0);
            temp_scappa2.add(0);
            temp_mangia.add(0);
            temp_mangia2.add(0);
            temp_resta.add(0);
            temp_resta2.add(0);
            temp_minaccia.add(0);
            temp_minaccia2.add(0);
        }
        for (int j = 0; j < 4; j++)
            temp_prime_mosse.add(0);

    }

    //resetta i campi dati nella condizione iniziale
    private void inizializzaTutto() {
        for (int i = 0; i < 8; i++) {
            pezzi_vivi1.set(i, 1);
            pezzi_vivi2.set(i, 1);
            pezzi_1.set(i, "");
            pezzi_2.set(i, "");
            pezzi_1_inizio.set(i, 0);
            pezzi_2_inizio.set(i, 0);
            temp_minacciato1.set(i, 0);
            temp_minacciato2.set(i, 0);
            temp_avanti.set(i, 0);
            temp_indietro.set(i, 0);
            temp_later.set(i, 0);
            temp_avanti2.set(i, 0);
            temp_indietro2.set(i, 0);
            temp_later2.set(i, 0);
            temp_scappa.set(i, 0);
            temp_scappa2.set(i, 0);
            temp_mangia.set(i, 0);
            temp_mangia2.set(i, 0);
            temp_resta.set(i, 0);
            temp_resta2.set(i, 0);
            temp_minaccia.set(i, 0);
            temp_minaccia2.set(i, 0);
        }
        for (int j = 0; j < 4; j++)
            temp_prime_mosse.set(j, 0);
    }

    /**
     *
     * @param id: identificativo del giocatore
     */

    //public FeatureCollector(int id_giocatore, LogPartita partita){
    //this(id_giocatore,partita,0);


    //System.out.println();

    //}

    /**
     * Metodo che stabilisce se il giocatore preso in esame era il giocatore "1" o meno.
     * Utile per leggere il file di log della partita ed interpretare le mosse.
     *
     * @param id: identificativo del giocatore
     * @return TRUE se il giocatore era il primo, FALSE altrimenti
     */
    private boolean primoGiocatore(int id, LogPartita partita) {
        if (Integer.parseInt(partita.getLog().firstElement().substring(2).replace("\n", "")) == id)
            return true;
        return false;
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    private int trovaUcciso(String mossa) {
        int pezzo = -1;
        for (int j = 0; j < 8; j++) {

            //System.out.println(j+ " pezzo 1 in "+pezzi_1.elementAt(j)+" pezzo 2 in "+pezzi_2.elementAt(j));

            if ((isVivo(j, 1) && pezzi_1.elementAt(j).equals(mossa)) || ((isVivo(j, 2) && pezzi_2.elementAt(j).equals(mossa)))) {
                pezzo = j;
            }
        }
        return pezzo;
    }

    private void uccidi(int pezzo, int gioc) {
        Vector<Integer> vec = new Vector<Integer>();
        if (gioc == 1)
            vec = pezzi_vivi1;
        else
            vec = pezzi_vivi2;
        vec.setElementAt(0, pezzo);
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
                pezzi_1.setElementAt(partita.getLog().elementAt(j + 2).substring(0, 2), pezzo);
                pezzi_1_inizio.setElementAt(j, pezzo);
            } else {
                pezzi_2.setElementAt(partita.getLog().elementAt(j + 2).substring(0, 2), pezzo);
                pezzi_2_inizio.setElementAt(j - 8, pezzo);
            }
        }
    }

    public Struttura analizzaMosse(int giocatore, LogPartita partita, int turno) {
        //System.out.println("CHIAMA ANALIZZA, giocatore ="+giocatore);
        //Vector<Container> supporto;

        inizializzaTutto();

        if (turno > getLastTurn(partita))
            turno = 0;
        Struttura output = new Struttura();
        Vector<String> log = partita.getLog();
        int pezzo1 = -1;
        int pezzo2 = -1;

        disposizionePezzo(partita);

        //inizializzo il vettore di 'vite' del pezzo (v. fine ciclo for)
        Vector<Integer> vite1 = new Vector<Integer>();
        Vector<Integer> vite2 = new Vector<Integer>();
        for (int a = 0; a < 8; a++) {
            vite1.add(1);
            vite2.add(1);
        }

        //Scorro i turni di gioco - fino al turno in cui � stato richiesto o fino alla fine
        for (int i = 18; i < log.size() && (turno == 0 || i < 18 + turno); i++) {
            String mossa1 = "";
            String mossa2 = "";
            mossa1 = log.elementAt(i).substring(log.elementAt(i).indexOf(".") + 1, log.elementAt(i).indexOf(".") + 6);

            if (log.elementAt(i).indexOf(",") != -1) {
                System.out.println("INDICE C'� ed �: " + log.elementAt(i).indexOf(","));
                mossa2 = log.elementAt(i).substring(log.elementAt(i).indexOf(",") + 1, log.elementAt(i).indexOf(",") + 6);
            }
            System.out.println("qui:" + mossa2);
            //Scorro le feature da valutare
            for (int feature = 0; feature < features.size(); feature++) {

            }
            //System.out.println("TURNO = "+(i-18));

            if (minacciaPos(mossa1.substring(0, 2), 2)) {
                if (mangia(mossa1)) {
                    uccidi(trovaUcciso(mossa1.substring(3, 5)), 2);
                    addMangia(pezzo1, 1);
                } else
                    addScappa(pezzo1, 1);
            }

            pezzo1 = trovaPezzo(mossa1);

            if (minacciato(pezzo1, 1)) {
                temp_minacciato1.setElementAt(1, pezzo1);
                addMinaccia(pezzo1, 1);
            }

            //caso mossa in avanti
            if ((Integer.parseInt(mossa1.substring(0, 1)) < Integer.parseInt(mossa1.substring(3, 4)))) {
                addAvanti(pezzo1, 1);
            }

            //Feature ftAvanti = new MosseAvanti();
            //temp_avanti.setElementAt(pezzo1, ftAvanti.resolve(mossa1, temp_avanti.get(pezzo1)));

            //caso mossa indietro
            if (Integer.parseInt(mossa1.substring(0, 1)) > Integer.parseInt(mossa1.substring(3, 4))) {
                addIndietro(pezzo1, 1);
            }

            //caso mossa laterale
            if (Integer.parseInt(mossa1.substring(0, 1)) == Integer.parseInt(mossa1.substring(3, 4))) {
                addLaterale(pezzo1, 1);
            }

            //caso resta se minacciato
            for (int p = 0; p < 8; p++) {
                if (pezzo1 != p && isVivo(p, 1)) {
                    if (minacciato(p, 1)) {
                        addResta(p, 1);
                    }
                }
            }

            //Se ha mosso anche il secondo giocatore
            if (mossa2 != "") {
                if (minacciaPos(mossa2.substring(0, 2), 1)) {
                    if (mangia(mossa2)) {
                        //System.out.println(mossa2 + " in "+mossa2.substring(3,5)+" Muore: "+ trovaUcciso(mossa2.substring(3,5)));
                        uccidi(trovaUcciso(mossa2.substring(3, 5)), 1);
                        addMangia(pezzo2, 2);
                    } else
                        addScappa(pezzo2, 2);
                }

                System.out.println("MOSSA2 c'� ed � : " + mossa2);
                pezzo2 = trovaPezzo(mossa2);

                if (minacciato(pezzo2, 2)) {
                    temp_minacciato2.setElementAt(1, pezzo2);
                    addMinaccia(pezzo2, 2);
                }

                if ((Integer.parseInt(mossa2.substring(0, 1)) > Integer.parseInt(mossa2.substring(3, 4)))) {
                    addAvanti(pezzo2, 2);
                }
                if (Integer.parseInt(mossa2.substring(0, 1)) < Integer.parseInt(mossa2.substring(3, 4))) {
                    addIndietro(pezzo2, 2);
                }
                if (Integer.parseInt(mossa2.substring(0, 1)) == Integer.parseInt(mossa2.substring(3, 4))) {
                    addLaterale(pezzo2, 2);
                }

                for (int p = 0; p < 8; p++) {
                    if (pezzo2 != p && isVivo(p, 2)) {
                        if (minacciato(p, 2)) {
                            addResta(p, 2);
                        }
                    }
                }
            }

            if (i == 18) {
                temp_prime_mosse.setElementAt(pezzo1, 0);
                if (mossa2 != "")
                    temp_prime_mosse.setElementAt(pezzo2, 2);
            }
            if (i == 19) {
                temp_prime_mosse.setElementAt(pezzo1, 1);
                if (mossa2 != "")
                    temp_prime_mosse.setElementAt(pezzo2, 3);
            }

            //aggiungo i vivi alla Struttura
            for (int v = 0; v < 8; v++) {
                //se � appena morto, inserisco comunque il suo vettore
                if (pezzi_vivi1.elementAt(v) == 0 && vite1.elementAt(v) == 1 && primoGiocatore(giocatore, partita)) {
                    output.addVettore(resolvePezzo(v, 1));
                    vite1.setElementAt(0, v);
                    pezzi_vivi1.setElementAt(0, v);
                }
                if (pezzi_vivi2.elementAt(v) == 0 && vite2.elementAt(v) == 1 && !primoGiocatore(giocatore, partita)) {
                    output.addVettore(resolvePezzo(v, 2));
                    vite2.setElementAt(0, v);
                    pezzi_vivi2.setElementAt(0, v);
                }

                if (pezzi_vivi1.elementAt(v) == 1 && primoGiocatore(giocatore, partita)) {
                    output.addVettore(resolvePezzo(v, 1));
                }
                if (pezzi_vivi2.elementAt(v) == 1 && !primoGiocatore(giocatore, partita)) {
                    output.addVettore(resolvePezzo(v, 2));
                }
            }
        }
        if (primoGiocatore(giocatore, partita) && false) {
            System.out.println("PEZZI_1 = " + pezzi_1);
            System.out.println("PEZZI_2 = " + pezzi_2);
            System.out.println("PEZZI_1 DOPO = " + pezzi_1);
            System.out.println("PEZZI_2 DOPO = " + pezzi_2);
            System.out.println("PEZZI_1 av = " + temp_avanti);
            System.out.println("PEZZI_1 ind = " + temp_indietro);
            System.out.println("PEZZI_1 later = " + temp_later);
            System.out.println("PEZZI_2 av = " + temp_avanti2);
            System.out.println("PEZZI_2 ind = " + temp_indietro2);
            System.out.println("PEZZI_2 later = " + temp_later2);
            System.out.println("PEZZI_1 mangia = " + temp_mangia);
            System.out.println("PEZZI_1 scappa = " + temp_scappa);
            System.out.println("PEZZI_1 resta = " + temp_resta);
            System.out.println("PEZZI_1 minaccia = " + temp_minaccia);
            System.out.println("PEZZI_2 mangia = " + temp_mangia2);
            System.out.println("PEZZI_2 scappa = " + temp_scappa2);
            System.out.println("PEZZI_2 resta = " + temp_resta2);
            System.out.println("PEZZI_2 minaccia = " + temp_minaccia2);
            System.out.println("PEZZI_1 vivi   = " + pezzi_vivi1);
            System.out.println("PEZZI_2 vivi   = " + pezzi_vivi2);
            System.out.println("PEZZI_1 inizio   = " + pezzi_1_inizio);
            System.out.println("PEZZI_2 inizio   = " + pezzi_2_inizio);
            System.out.println("Prime mosse   = " + temp_prime_mosse);
        }
        return output;
    }

    private int contaPezziVivi(int gioc) {
        int pezziVivi = 8;
        if (gioc == 1) {
            for (int i = 0; i < 8; i++) {
                if (pezzi_vivi1.elementAt(i) == 0)
                    pezziVivi--;
            }
        } else {
            for (int i = 0; i < 8; i++) {
                if (pezzi_vivi2.elementAt(i) == 0)
                    pezziVivi--;
            }
        }
        return pezziVivi;
    }

    public Integer[] resolvePezzo(int pezzo, int gioc) {
        Integer[] featurePezzo = new Integer[18];
        /**
         * 0: id pezzo
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
         */

        featurePezzo[0] = pezzo;

        if (gioc == 1) {
            //Primi 8 elementi: setto 1 nella posizione di partenza, 0 altrove
            for (int i = 1; i < 9; i++) {
                if (i == pezzi_1_inizio.elementAt(pezzo))
                    featurePezzo[i] = 1;
                else
                    featurePezzo[i] = 0;
            }

            //Indici 8 e 9: setto 1 se il pezzo ha fatto la prima/seconda mossa
            if (temp_prime_mosse.elementAt(0) == pezzo)
                featurePezzo[9] = 1;
            else
                featurePezzo[9] = 0;

            if (temp_prime_mosse.elementAt(1) == pezzo)
                featurePezzo[10] = 1;
            else
                featurePezzo[10] = 0;

            featurePezzo[11] = temp_avanti.elementAt(pezzo);
            featurePezzo[12] = temp_indietro.elementAt(pezzo);
            featurePezzo[13] = temp_later.elementAt(pezzo);
            featurePezzo[14] = temp_mangia.elementAt(pezzo);
            featurePezzo[15] = temp_scappa.elementAt(pezzo);
            featurePezzo[16] = temp_resta.elementAt(pezzo);
            featurePezzo[17] = temp_minaccia.elementAt(pezzo);
        } else {
            //Primi 8 elementi: setto 1 nella posizione di partenza, 0 altrove
            for (int i = 1; i < 9; i++) {
                if (i == pezzi_2_inizio.elementAt(pezzo))
                    featurePezzo[i] = 1;
                else
                    featurePezzo[i] = 0;
            }
            //Indici 8 e 9: setto 1 se il pezzo ha fatto la prima/seconda mossa
            if (temp_prime_mosse.elementAt(2) == pezzo)
                featurePezzo[9] = 1;
            else
                featurePezzo[9] = 0;
            if (temp_prime_mosse.elementAt(3) == pezzo)
                featurePezzo[10] = 1;
            else
                featurePezzo[10] = 0;

            featurePezzo[11] = temp_avanti2.elementAt(pezzo);
            featurePezzo[12] = temp_indietro2.elementAt(pezzo);
            featurePezzo[13] = temp_later2.elementAt(pezzo);
            featurePezzo[14] = temp_mangia2.elementAt(pezzo);
            featurePezzo[15] = temp_scappa2.elementAt(pezzo);
            featurePezzo[16] = temp_resta2.elementAt(pezzo);
            featurePezzo[17] = temp_minaccia2.elementAt(pezzo);
        }
        return featurePezzo;
    }

    /**
     * Aggiorna la posizione del pezzo dopo la mossa e restituisce l'id del pezzo che l'ha effettuata
     *
     * @param mossa = mossa (nella forma 01 o 43)
     * @return identificativo del pezzo (da 0 a 7)
     */
    private int trovaPezzo(String mossa) {
        int pezzo = -1;
        for (int j = 0; j < 8; j++) {
            System.out.println("RICERCA MOSSA = " + mossa.substring(0, 2));
            System.out.println("IN PEZZO = " + pezzi_1.elementAt(j));
            if (pezzi_1.elementAt(j).equals(mossa.substring(0, 2))) {
                pezzo = j;
                pezzi_1.setElementAt(mossa.substring(3, 5), j);
            }
            System.out.println("E IN PEZZO = " + pezzi_2.elementAt(j));
            if (pezzi_2.elementAt(j).equals(mossa.substring(0, 2))) {
                pezzo = j;
                pezzi_2.setElementAt(mossa.substring(3, 5), j);
            }
        }
        return pezzo;
    }

    private String getPosPezzo(int pezzo, int gioc) {
        String s = "";
        if (gioc == 1)
            s = pezzi_1.elementAt(pezzo).toString();
        else
            s = pezzi_2.elementAt(pezzo).toString();
        return s;
    }

    private boolean isVivo(int pezzo, int gioc) {
        Vector<Integer> vec;
        if (gioc == 1)
            vec = pezzi_vivi1;
        else
            vec = pezzi_vivi2;
        if (vec.elementAt(pezzo) == 1)
            return true;
        return false;
    }

    private boolean mangia(String mossa) {
        boolean flag = false;
        if (pezzi_1.contains(mossa.substring(3, 5))) {
            //System.out.println("***** E' nei pezzi 1 *****");
            flag = true;
        }
        if (pezzi_2.contains(mossa.substring(3, 5))) {
            //System.out.println("***** E' nei pezzi 2 *****");
            flag = true;
        }
        if ((mossa.charAt(2) == '-' && flag)) {
            //System.out.println("***** ha funzionato!!! *****");
            return true;
        }
        if (mossa.charAt(2) != '-') {
            return true;
        }
        return false;
    }

    private int getLastTurn(LogPartita partita) {
        int res = 0;
        String turno = partita.getLog().elementAt(partita.getLog().size() - 1);
        if (turno.substring(0, 2).endsWith("."))
            res = Integer.parseInt(turno.substring(0, 1));
        if (turno.substring(0, 3).endsWith("."))
            res = Integer.parseInt(turno.substring(0, 2));
        return res;
    }

    private boolean minacciaPos(String posizione, int gioc) {
        int pezzo_avv = 0;
        int pos = Integer.parseInt(posizione);
        boolean minaccia = false;

        for (int i = 0; i < 8; i++) {
            if (gioc == 2)
                pezzo_avv = Integer.parseInt(pezzi_2.elementAt(i));
            else
                pezzo_avv = Integer.parseInt(pezzi_1.elementAt(i));

            if (isVivo(i, gioc)) {
                if (pezzo_avv + 10 == pos || pezzo_avv - 10 == pos || pezzo_avv + 1 == pos || pezzo_avv - 1 == pos) {
                    minaccia = true;
                }
            }
        }
        return minaccia;
    }

    private boolean minacciato(int pezzo, int gioc) {
        int pos_pezzo = 0;
        int pezzo_avv = 0;

        int avv = 1;
        if (gioc == 1)
            avv = 2;

        boolean minaccia = false;

        if (gioc == 1)
            pos_pezzo = Integer.parseInt(pezzi_1.elementAt(pezzo));
        else
            pos_pezzo = Integer.parseInt(pezzi_2.elementAt(pezzo));

        for (int i = 0; i < 8; i++) {
            if (avv == 2) {
                pezzo_avv = Integer.parseInt(pezzi_2.elementAt(i));
            } else {
                pezzo_avv = Integer.parseInt(pezzi_1.elementAt(i));
            }

            if (isVivo(i, avv)) {
                if (pezzo_avv + 10 == pos_pezzo || pezzo_avv - 10 == pos_pezzo || pezzo_avv + 1 == pos_pezzo || pezzo_avv - 1 == pos_pezzo) {
                    //System.out.println(pezzo_avv + " MINACCIA " + pos_pezzo);
                    minaccia = true;
                }
            }
        }

        return minaccia;
    }

    private void addAvanti(int pezzo, int gioc) {
        if (gioc == 1)
            temp_avanti.setElementAt(temp_avanti.elementAt(pezzo) + 1, pezzo);
        else
            temp_avanti2.setElementAt(temp_avanti2.elementAt(pezzo) + 1, pezzo);
    }

    private void addIndietro(int pezzo, int gioc) {
        if (gioc == 1)
            temp_indietro.setElementAt(temp_indietro.elementAt(pezzo) + 1, pezzo);
        else
            temp_indietro2.setElementAt(temp_indietro2.elementAt(pezzo) + 1, pezzo);
    }

    private void addLaterale(int pezzo, int gioc) {
        if (gioc == 1)
            temp_later.setElementAt(temp_later.elementAt(pezzo) + 1, pezzo);
        else
            temp_later2.setElementAt(temp_later2.elementAt(pezzo) + 1, pezzo);
    }

    private void addMangia(int pezzo, int gioc) {
        if (gioc == 1)
            temp_mangia.setElementAt(temp_mangia.elementAt(pezzo) + 1, pezzo);
        else
            temp_mangia2.setElementAt(temp_mangia2.elementAt(pezzo) + 1, pezzo);
    }

    private void addScappa(int pezzo, int gioc) {
        if (gioc == 1)
            temp_scappa.setElementAt(temp_scappa.elementAt(pezzo) + 1, pezzo);
        else
            temp_scappa2.setElementAt(temp_scappa2.elementAt(pezzo) + 1, pezzo);
    }

    private void addResta(int pezzo, int gioc) {
        if (gioc == 1)
            temp_resta.setElementAt(temp_resta.elementAt(pezzo) + 1, pezzo);
        else
            temp_resta2.setElementAt(temp_resta2.elementAt(pezzo) + 1, pezzo);
    }

    private void addMinaccia(int pezzo, int gioc) {
        if (gioc == 1)
            temp_minaccia.setElementAt(temp_minaccia.elementAt(pezzo) + 1, pezzo);
        else
            temp_minaccia2.setElementAt(temp_minaccia2.elementAt(pezzo) + 1, pezzo);
    }

    public int getNumFeatures() {
        return features.size();
    }
}