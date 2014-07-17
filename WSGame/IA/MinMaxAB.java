package IA;

import java.util.Stack;
import java.util.Vector;

import logica.Coordinata;
import logica.Pezzo;
import logica.Tavolo;


/**
 * Questa classe implementa l'algoritmo MinMax con la potatura alfa-beta<p>&nbsp;</p>
 *
 * @author Appon Luca
 * @version 4.2 del 25/11/2007
 */

public class MinMaxAB {

    private static String[] euristische_disponibili = {"buoniMangiati", "cattiviMangiati", "buoniInGioco", "cattiviInGioco", "attaccoAiBuoni", "buoniSottoMinaccia", "distanzaBuoniUscita", "distanzaBuoniUscitaAvversario"};
    private Tavolo tavolo = null;
    private int profondita = 0;
    private byte giocatore_corrente = -1;
    private ValutaMosse mossa = null;
    private Vector<String> euristische_selezionate = new Vector<String>();
    private int MAX = 1000;

    /**
     * Costruttore a  4 parametri
     *
     * @param t    il tavolo da gioco
     * @param gioc il giocatore che intende usare l'algoritmo di ricerca
     * @param prof la profondit� di esplorazione
     * @param eur  le euristiche del giocatore
     */

    public MinMaxAB(Tavolo t, byte gioc, int prof, Vector<String> eur) {
        tavolo = t;
        giocatore_corrente = gioc;
        profondita = prof;
        euristische_selezionate = eur;
//	System.out.println("IL GIOCATORE INIZIALE CHE DEVE MUOVERE E' "+giocatore_corrente);
        mossa = alphaBeta(null, 0, tavolo, giocatore_corrente, MAX, -MAX);
        System.out.println("il cammino migliore ha: " + mossa.getCammino().size() + " stati ");
        System.out.println("gli stati hanno queste coordinate hanno questi punteggi");
        for (int i = 0; i < mossa.getCammino().size(); i++) {
            System.out.print(mossa.getCammino().elementAt(i).getPartenza().getRiga() + "," + mossa.getCammino().elementAt(i).getPartenza().getColonna() +
                    " : " + mossa.getCammino().elementAt(i).getArrivo().getRiga() + "," + mossa.getCammino().elementAt(i).getArrivo().getColonna());
            System.out.println(" -> " + mossa.getValore());
        }
    }

    /**
     * Metodo statico che restituisce un array con le euristiche disponibili.
     * Nel caso si voglia inserire una nuova euristica baster� aggionare questo array
     */
    public static String[] euristiche() {
        return euristische_disponibili;
    }

    /**
     * @param p           nodo padre
     * @param prof        profondit� di esplorazione
     * @param tav         tavolo da gioco
     * @param giocatore   giocatore che ha il gioco in mano
     * @param usaSoglia   parametro che memorizza il punteggio della mossa mogliore
     * @param passaSoglia parametro che memorizza il valore da passare al prossimo livello di esplorazione
     * @return l'intero cammino contenente la mossa migliore
     */
    public ValutaMosse alphaBeta(Nodo p, int prof, Tavolo tav, byte giocatore, double usaSoglia, double passaSoglia) {
        Stack<Nodo> cammino_migliore = new Stack<Nodo>();
        ValutaMosse ris_succ = null;
        double nuovo_valore;


        /** CASO BASE se abbastanza profondo si restituisce la struttura con valore determinato dalla fuinzine euristica e cammino nullo*/

        if (prof == profondita)
            return new ValutaMosse(valuta_tavolo(tav, giocatore), new Stack<Nodo>());

        else {
            /** altrimenti si genera un altro stadio dell'albero invocando la funzione generaMosse e associando a successori
             * la lista che essa restituisce
             */

            Vector<Nodo> successori = generaMosse(tav, p, giocatore);
            /** se succesori � vuoto allora non ci sono mosse da fare e quindi si restituisce la stessa struttura che si restituirebbe nel caso base*/
            if (successori.size() == 0)
                return new ValutaMosse(valuta_tavolo(tav, giocatore), new Stack<Nodo>());
            /** altrimenti se esistono successori si esamina a turno ogni elemento tenendo traccia del migliore */
            else {


//				System.out.println(tav.printTavolo());
                /** per ogni elemento di successori*/
                for (int i = 0; i < successori.size(); i++) {
                    /** creo una copia del tavolo */
                    Tavolo nuovo_tavolo = (Tavolo) tav.clone();

                    /** effettuo la ValutaMosse sul nuovo tavolo */
                    nuovo_tavolo.muoviPezzo(successori.get(i).getPartenza(), successori.get(i).getArrivo());
//					System.out.println("Ho mosso pezzo da -> "+successori.get(i).getPartenza().getRiga()+" : "+successori.get(i).getPartenza().getColonna());
//					System.out.println("a-> "+successori.get(i).getArrivo().getRiga()+" : "+successori.get(i).getArrivo().getColonna());
//					//					System.out.println("Richiamo Alphabeta per il giocatore "+getAvversario(giocatore));
//					System.out.println("STO ESPLORANDO IL NODO "+successori.get(i).getPartenza().getRiga()+" : "+successori.get(i).getPartenza().getColonna());
                    /** si attribuisce a ris_succ il valore della funzione Alphabeta */
                    ris_succ = alphaBeta(successori.get(i), prof + 1, nuovo_tavolo, getAvversario(giocatore), -passaSoglia, -usaSoglia);
//					System.out.println("controllo valore ");
                    /** si assegna  a nuovo valore il valore di ris_succ cambiato di segno */
                    nuovo_valore = -(ris_succ.getValore());
                    /** se nuovo_valore>passaSoglia trovo un successore migliore di quelli esaminati fino ad ora e lo memorizzo */
                    if (nuovo_valore > passaSoglia) {
                        passaSoglia = nuovo_valore;
                        ris_succ.getCammino().push(successori.get(i));
                        cammino_migliore = ris_succ.getCammino();
//						System.out.println("Entro in if(nuovo_valore>passaSoglia) ");
                    }
                    /** se passaSoglia( che riflette il valore maggiore corrente ) non � migliore di usaSoglia si deve
                     * terminare l'esame di questo cammino. E' il TAGLIO ALPHABETA
                     * Essendo i due valori delle soglie invertiti se  passaSoglia>=usaSoglia
                     * allora si termina immediatamente la struttura restituendo
                     *  la struttura con valore passaSoglia e cammino il cammino migliore*/
                    if (passaSoglia >= usaSoglia) {
//						System.out.println("Entro in if(passaSoglia>=usaSoglia)  ");
                        return new ValutaMosse(passaSoglia, cammino_migliore);
                    }


                }
            }
            /** restituisco la struttura con valore passaSoglia e cammino il cammino migliore*/
            return new ValutaMosse(passaSoglia, cammino_migliore);
        }
    }

    /**
     * Metodo che genera un vettore con tutte le mosse fattibili del giocatore passato come parametro
     * nella situazione di gioco attuale
     *
     * @param t    il tavolo di gioco
     * @param p    nodo padre
     * @param gioc giocatore corrente
     * @return
     */
    private Vector<Nodo> generaMosse(Tavolo t, Nodo p, byte gioc) {


        /** creo un vettore contenente tutti i pezzi (buoni/cattivi) in gioco del giocatore di cui si vuol generare le mosse fattibili */
        Vector<Pezzo> pez = t.getPezziInGioco(gioc);

        Vector<Pezzo> pezzi = new Vector<Pezzo>();

        // determina quando i pezzi sono stati tutti distribuiti casualmente nel vettore pezzi
        boolean continua = true;
        int pezzi_totali = pez.size();

        while (continua) {
            // se il vettore pezzi ha gi� tutti i pezzi inseriti esco dal ciclo
            if (pezzi.size() == pezzi_totali)
                continua = false;
            else {
                // scelgo un pezzo casualmete da inserire nel vettore pezzi
                int index = ((int) Math.random() * 10) % pez.size();
                //altrimenti se nel vettore pezzi non c'� il pezzo lo inserisco e continuo il ciclo
                if (!pezzi.contains(pez.get(index)))
                    pezzi.add(pez.remove(index));
            }
        }

        /** vettore che conterr� le mosse fattibili del giocatore passato come parametro*/
        Vector<Nodo> mosse = new Vector<Nodo>();
        /** scorro tutti i pezzi del giocatore */

//		System.out.println("LE MOSSE FATTIBILI del GIOCATORE "+gioc+" SONO: ");
        int conta = 0;
        for (int i = 0; i < pezzi.size(); i++) {
            /** per ogni pezzo scorro le mosse fattibili */
            for (int y = 0; y < pezzi.get(i).getMosseFattibili().size(); y++) {
                conta++;
                /** identifico la coordinata di partenza */
                Coordinata partenza = pezzi.get(i).getCoordinata();
                /** identifico la coordinata di arrivo */
                Coordinata arrivo = pezzi.get(i).getMosseFattibili().get(y);
//				System.out.println("Costruisco un nuovo nodo ");
                Nodo succ = new Nodo(p, partenza, arrivo);
                /** aggiungo la ValutaMosse nel vettore mosse fattibili */
                mosse.add(succ);
//				System.out.println("PARTENZA: "+partenza.getRiga()+" : "+partenza.getColonna());
//				System.out.println("ARRIVO: "+arrivo.getRiga()+" : "+arrivo.getColonna());
//				System.out.println();
            }
        }
//		System.out.println("LE MOSSE TOTALI FATTIBILI del GIOCATORE "+gioc+" SONO: "+conta);
        return mosse;
    }

    /**
     * Metodo che restituisce il numero del giocatore avversario
     */
    private byte getAvversario(byte g) {
        if (g == 1)
            return 2;
        return 1;
    }

    /**
     * Questa funzione richiama le euristiche selezionate e calcola il punteggio STATICO del tavolo
     */
    private double valuta_tavolo(Tavolo t, byte giocatore) {
//			System.out.println("Pezzi in tavolo vecchio == "+t.getNumeroPezziBuoni(giocatore));
        Vector<Double> punteggi = new Vector<Double>();

        for (int i = 0; i < euristische_selezionate.size(); i++) {
            if (euristische_selezionate.get(i).equals("buoniMangiati"))
                punteggi.add(buoniMangiati(t, giocatore));
            if (euristische_selezionate.get(i).equals("cattiviMangiati"))
                punteggi.add(cattiviMangiati(t, giocatore));
            if (euristische_selezionate.get(i).equals("buoniInGioco"))
                punteggi.add(buoniInGioco(t, giocatore));
            if (euristische_selezionate.get(i).equals("cattiviInGioco"))
                punteggi.add(cattiviInGioco(t, giocatore));
            if (euristische_selezionate.get(i).equals("attaccoAiBuoni"))
                punteggi.add(attaccoAiBuoni(t, giocatore));
            if (euristische_selezionate.get(i).equals("buoniSottoMinaccia"))
                punteggi.add(buoniSottoMinaccia(t, giocatore));
            if (euristische_selezionate.get(i).equals("distanzaBuoniUscita"))
                punteggi.add(distanzaBuoniUscita(t, giocatore));
            if (euristische_selezionate.get(i).equals("distanzaBuoniUscitaAvversario"))
                punteggi.add(distanzaBuoniUscitaAvversario(t, giocatore));
        }
        if (punteggi.contains(MAX)) return MAX;
        if (punteggi.contains(-MAX)) return -MAX;
        double punt = 0;
        for (int i = 0; i < punteggi.size(); i++)
            punt = punt + punteggi.get(i);

        return (punt / euristische_selezionate.size());
    }

    /**
     * Metodo che assegna un punteggio per i pezzi buoni mangiati all'avversario.
     * I coefficienti da assegnare sono memorizzati all'interno di una stringa coeff in cui l'indice corrisponde al numero di pezzi buoni mangiati
     * coeff[0] -> 0
     * coeff[1] -> 0.5
     * coeff[2] -> 0.6
     * coeff[3] -> 0.8
     * coeff[4] -> MAX
     */

    private double buoniMangiati(Tavolo t, byte gioc) {
        //memorizzo i coefficienti dei pezzi buoni mangiati a seconda del loro numero (corrispondente all'indice dell'array)
        double[] coeff = {0, 0.5, 0.6, 0.8, MAX};
        //se giocatore da valutare � giocatore 1
        if (gioc == 1)
            // ritorno il coeff corretto corrispondente al numero di pezzi cattivi mangiati
            return coeff[(4 - t.vettorePezzi((byte) 3).size())];

            //se giocatore da valutare � giocatore 2
        else
            // ritorno il coeff corretto corrispondente al numero di pezzi cattivi mangiati
            return coeff[(4 - t.vettorePezzi((byte) 1).size())];
    }

    /**
     * Metodo che assegna un punteggio per i pezzi cattivi mangiati all'avversario.
     * I coefficienti da assegnare sono memorizzati all'interno di una stringa coeff in cui l'indice corrisponde al numero di pezzi cattivi mangiati
     * coeff[0] -> 0
     * coeff[1] -> 0.05
     * coeff[2] -> 0.1
     * coeff[3] -> 0.15
     * coeff[4] -> -MAX
     */


    private double cattiviMangiati(Tavolo t, byte gioc) {
        //memorizzo i coefficienti dei pezzi buoni mangiati a seconda del loro numero (corrispondente all'indice dell'array)
        double[] coeff = {0, 0.05, 0.1, 0.15, -MAX};
        //se giocatore da valutare � giocatore 1
        if (gioc == 1)
            // ritorno il coeff corretto corrispondente al numero di pezzi cattivi mangiati
            return coeff[(4 - t.vettorePezzi((byte) 4).size())];

            //se giocatore da valutare � giocatore 2
        else
            // ritorno il coeff corretto corrispondente al numero di pezzi cattivi mangiati
            return coeff[(4 - t.vettorePezzi((byte) 2).size())];
    }

    /**
     * Metodo che assegna un punteggio per i pezzi buoni in gioco del giocatore corrente.
     * I coefficienti da assegnare sono memorizzati all'interno di una stringa coeff in cui l'indice corrisponde al numero di pezzi cattivi mangiati
     * coeff[0] -> -MAX
     * coeff[1] -> -0.8
     * coeff[2] -> -0.6
     * coeff[3] -> -0.5
     * coeff[4] ->  0.2
     */


    private double buoniInGioco(Tavolo t, byte gioc) {
        double[] coeff = {-MAX, -0.8, -0.6, -0.5, 0.2};
        if (gioc == 1)
            return coeff[t.getNumeroPezziBuoni((byte) 1)];
        else
            return coeff[t.getNumeroPezziBuoni((byte) 2)];
    }

    /**
     * Metodo che assegna un punteggio per i pezzi cattivi in gioco del giocatore corrente.
     * I coefficienti da assegnare sono memorizzati all'interno di una stringa coeff in cui l'indice corrisponde al numero di pezzi cattivi mangiati
     * coeff[0] -> MAX
     * coeff[1] -> -0.15
     * coeff[2] -> -0.1
     * coeff[3] -> -0.05
     * coeff[4] -> 	0.1
     */

    private double cattiviInGioco(Tavolo t, byte gioc) {
        double[] coeff = {MAX, -0.15, -0.1, -0.05, 0.1};
        if (gioc == 1)
            return coeff[t.getNumeroPezziCattivi((byte) 1)];
        else
            return coeff[t.getNumeroPezziCattivi((byte) 2)];
    }

    /**
     * Metodo che controlla se un pezzo cattivo del giocatore corrente sta minacciando un pezzo buono avversario.
     * il coeff viene moltiplicato per il numero dei pezzi buoni sotto  minaccia
     */

    private double attaccoAiBuoni(Tavolo t, byte g) {
        //se giocatore 1
        int conta = 0;
        double coeff = 0.05;

        if (g == 1) {
            for (int i = 0; i < t.vettorePezzi((byte) 2).size(); i++) {
                //scorro tutte le mosse in cui il pezzo in questione mangia un pezzo avversario
                Pezzo p = t.vettorePezzi((byte) 2).get(i);
                for (int j = 0; j < p.getCoordinatePezziMangiabili().size(); j++)
                    //se il pezzo avversario sotto minaccia � buono
                    if (t.getPezzo(p.getCoordinatePezziMangiabili().get(j)).getBuono() == true)
                        conta++;
            }
        } else {
            for (int i = 0; i < t.vettorePezzi((byte) 4).size(); i++) {
                //scorro tutte le mosse in cui il pezzo in questione mangia un pezzo avversario
                Pezzo p = t.vettorePezzi((byte) 4).get(i);
                for (int j = 0; j < p.getCoordinatePezziMangiabili().size(); j++)
                    //se il pezzo avversario sotto minaccia � buono
                    if (t.getPezzo(p.getCoordinatePezziMangiabili().get(j)).getBuono() == true)
                        conta++;
            }
        }
        return coeff * conta;
    }

    /**
     * Metodo che determina se qualche pezzo buono del giocatore corrente � sotto minaccia.
     */
    private double buoniSottoMinaccia(Tavolo t, byte g) {
        //se giocatore 1
        int conta = 0;
        double coeff = 0.05;

        if (g == 1) {
            for (int i = 0; i < t.vettorePezzi((byte) 1).size(); i++) {
                //scorro tutte le mosse in cui il pezzo in questione  pu� essere mangiato
                Pezzo p = t.vettorePezzi((byte) 1).get(i);
                for (int j = 0; j < p.getCoordinatePezziMangiabili().size(); j++)
                    //se il pezzo � sotto minaccia
                    conta++;
            }
        } else {
            for (int i = 0; i < t.vettorePezzi((byte) 3).size(); i++) {
                //scorro tutte le mosse in cui il pezzo in questione pu� essere mangiato
                Pezzo p = t.vettorePezzi((byte) 3).get(i);
                for (int j = 0; j < p.getCoordinatePezziMangiabili().size(); j++)
                    //se il pezzo � sotto minaccia
                    conta++;
            }
        }
        return -(coeff * conta);
    }

    /**
     * Metodo per calcolare la distanza del pezzo pi� vicino ad una casella d'uscita.
     * Ad ogni distanza � associato un coefficiente.
     * distanza 0 -> 0.8
     * distanza 1 -> 0.4
     * distanza 2 -> 0.2
     * distanza 3 -> 0.1
     * distanza 4 -> -0.1
     * distanza 5 -> -0.2
     * distanza 6 -> -0.3
     * distanza 7 -> -0.4
     */
    private double distanzaBuoniUscita(Tavolo t, byte g) {
        double[] coeff = {0.8, 0.4, 0.2, 0.1, -0.1, -0.2, -0.3, -0.4};
        // distanza inizialmente a 7 e'la massima distanza (minima) possibile
        int distanza = 7;
        //se giocatore 1
        if (g == 1) {
            // scorro tutti i suoi pezzi buoni per trovare quello con distanza minore dall'uscita
            for (int i = 0; i < t.vettorePezzi((byte) 1).size(); i++) {
                // calcolo la distanza dalle due caselle di uscita [5,0] e [5,5]
                int d1 = Math.abs(t.vettorePezzi((byte) 1).get(i).getCoordinata().getRiga() - 5) + Math.abs(t.vettorePezzi((byte) 1).get(i).getCoordinata().getColonna() - 0);
                int d2 = Math.abs(t.vettorePezzi((byte) 1).get(i).getCoordinata().getRiga() - 5) + Math.abs(t.vettorePezzi((byte) 1).get(i).getCoordinata().getColonna() - 5);

                // se trovo una distanza minore della precedente allora la memorizzo
                if (distanza > d1 || distanza > d2)
                    distanza = Math.min(d1, d2);

                // se distanza==0 allora controllo che nelle caselle adiacenti non ci siano pezzi avversari
                // se non vi sono ritorna valore MAX in quanto al prossimo turno il giocatore vincer� la partita

                if (distanza == 0) {
                    if (d1 == 0) {
                        Coordinata c1 = new Coordinata((byte) 4, (byte) 0);
                        Coordinata c2 = new Coordinata((byte) 5, (byte) 1);
                        if (t.getPezzo(c1) == null)
                            return MAX;
                        else if (t.getPezzo(c1).getGiocatore() == 1)
                            return MAX;

                        if (t.getPezzo(c2) == null)
                            return MAX;
                        else if (t.getPezzo(c2).getGiocatore() == 1)
                            return MAX;
                    }
                    if (d2 == 0) {
                        Coordinata c1 = new Coordinata((byte) 5, (byte) 4);
                        Coordinata c2 = new Coordinata((byte) 4, (byte) 5);
                        if (t.getPezzo(c1) == null)
                            return MAX;
                        else if (t.getPezzo(c1).getGiocatore() == 1)
                            return MAX;

                        if (t.getPezzo(c2) == null)
                            return MAX;
                        else if (t.getPezzo(c2).getGiocatore() == 1)
                            return MAX;
                    }
                }
            }
        } else {
            //se giocatore 2
            for (int i = 0; i < t.vettorePezzi((byte) 3).size(); i++) {
                // scorro tutti i suoi pezzi buoni per trovare quello con distanza minore dall'uscita
                int d1 = Math.abs(t.vettorePezzi((byte) 3).get(i).getCoordinata().getRiga() - 0) + Math.abs(t.vettorePezzi((byte) 3).get(i).getCoordinata().getColonna() - 0);
                int d2 = Math.abs(t.vettorePezzi((byte) 3).get(i).getCoordinata().getRiga() - 0) + Math.abs(t.vettorePezzi((byte) 3).get(i).getCoordinata().getColonna() - 5);
                // se trovo una distanza minore della precedente allora la memorizzo
                if (distanza > d1 || distanza > d2)
                    distanza = Math.min(d1, d2);


                // se distanza==0 allora controllo che nelle caselle adiacenti non ci siano pezzi avversari
                // se non vi sono ritorna valore MAX in quanto al prossimo turno il giocatore vincer� la partita
                if (distanza == 0) {
                    if (d1 == 0) {
                        Coordinata c1 = new Coordinata((byte) 0, (byte) 1);
                        Coordinata c2 = new Coordinata((byte) 1, (byte) 0);
                        if (t.getPezzo(c1) == null)
                            return MAX;
                        else if (t.getPezzo(c1).getGiocatore() == 2)
                            return MAX;

                        if (t.getPezzo(c2) == null)
                            return MAX;
                        else if (t.getPezzo(c2).getGiocatore() == 2)
                            return MAX;
                    }
                    if (d2 == 0) {
                        Coordinata c1 = new Coordinata((byte) 1, (byte) 5);
                        Coordinata c2 = new Coordinata((byte) 0, (byte) 4);
                        if (t.getPezzo(c1) == null)
                            return MAX;
                        else if (t.getPezzo(c1).getGiocatore() == 2)
                            return MAX;

                        if (t.getPezzo(c2) == null)
                            return MAX;
                        else if (t.getPezzo(c2).getGiocatore() == 2)
                            return MAX;
                    }
                }
            }
        }
        // altrimenti ritorno il coefficiente
        return coeff[distanza];
    }

    /**
     * Metodo per calcolare la distanza del pezzo buono avversario pi� vicino ad una casella d'uscita.
     * questo metodo richiama il metodo distanzaBuoniUscita passando come giocatore, l'avversario e con segno opposto
     */
    private double distanzaBuoniUscitaAvversario(Tavolo t, byte g) {
        return -distanzaBuoniUscita(t, getAvversario(g));
    }

    /**
     * Metodo che ritona la coordinata di partenza della mossa migliore
     */
    public Coordinata getPosizioneIniziale() {
        return mossa.getCammino().lastElement().da;

    }

    /**
     * Metodo che ritorna la coordinata di arrivo della mossa migliore
     */
    public Coordinata getPosizioneFinale() {
        return mossa.getCammino().lastElement().a;
    }

    /**
     * Metodo che ritorna il punteggio della mossa  migliore
     */
    public double getPunteggio() {
        return mossa.getValore();
    }

    private class Nodo {
        private Coordinata da = null;
        private Coordinata a = null;
        private Nodo padre = null;

        public Nodo(Nodo p, Coordinata par, Coordinata arr) {
            padre = p;
            da = par;
            a = arr;
        }

        public Coordinata getPartenza() {
            return da;
        }

        public Coordinata getArrivo() {
            return a;
        }
    }

    private class ValutaMosse {
        private double val = 0;
        private Stack<Nodo> cammino = new Stack<Nodo>();

        public ValutaMosse(double d, Stack<Nodo> cam) {
            val = d;
            cammino = cam;
        }

        public Stack<Nodo> getCammino() {
            return cammino;
        }

        public double getValore() {
            return val;
        }
    }

}

		
	
	


