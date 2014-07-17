package IA.Strategie;

import java.util.Stack;
import java.util.Vector;

import IA.Euristiche.Euristica;
import IA.Euristiche.EuristicheFactory;
import logica.*;


/**
 * Questa classe implementa l'algoritmo MinMax con la potatura alfa-beta<p>&nbsp;</p>
 *
 * @author Appon Luca
 * @version 4.2 del 25/11/2007
 */

public class MinMaxAB extends Strategia {

    @Override
    public Mossa getMossa(Tavolo tavolo, Giocatore giocatore, EuristicheFactory.EURISTICHE euristica) {
        int MAX = 1000;
        ValutaMosse mosse = alphaBeta(0, tavolo, giocatore.getNumero(), MAX, -MAX, euristica);
        System.out.println("il cammino migliore ha: " + mosse.getCammino().size() + " stati ");
        System.out.println("gli stati hanno queste coordinate hanno questi punteggi");
        for (Mossa mossa : mosse.getCammino()) {
            System.out.print(mossa.getPartenza().getRiga() + "," + mossa.getPartenza().getColonna() +
                    " : " + mossa.getArrivo().getRiga() + "," + mossa.getArrivo().getColonna());
            System.out.println(" -> " + mosse.getValore());
        }
        Coordinata partenza = mosse.getCammino().lastElement().getPartenza();
        Coordinata arrivo = mosse.getCammino().lastElement().getArrivo();

        return new Mossa(partenza, arrivo);
    }

    /**
     * @param prof        Profondita di esplorazione attuale
     * @param tavolo      Tavolo da gioco
     * @param giocatore   Giocatore che ha il gioco in mano
     * @param usaSoglia   Parametro che memorizza il punteggio della mossa mogliore
     * @param passaSoglia Parametro che memorizza il valore da passare al prossimo livello di esplorazione
     * @param euristica   L'euristica da utilizzare per valutare il tavolo
     * @return L'intero cammino contenente la mossa migliore
     */
    ValutaMosse alphaBeta(int prof, Tavolo tavolo, byte giocatore, double usaSoglia, double passaSoglia, EuristicheFactory.EURISTICHE euristica) {
        Stack<Mossa> cammino_migliore = new Stack<Mossa>();
        ValutaMosse ris_succ;
        double nuovo_valore;

        //CASO BASE se abbastanza profondo si restituisce la struttura con valore determinato dalla fuinzine euristica e cammino nullo

        int profondita = 4;
        if (prof == profondita)
            return new ValutaMosse(valuta_tavolo(tavolo, giocatore, euristica), new Stack<Mossa>());

        //altrimenti si genera un altro stadio dell'albero invocando la funzione generaMosse e associando a successori la lista che essa restituisce
        Vector<Mossa> successori = generaMosse(tavolo, giocatore);

        //se succesori e vuoto allora non ci sono mosse da fare e quindi si restituisce la stessa struttura che si restituirebbe nel caso base
        if (successori.isEmpty())
            return new ValutaMosse(valuta_tavolo(tavolo, giocatore, euristica), new Stack<Mossa>());

        //altrimenti se esistono successori si esamina a turno ogni elemento tenendo traccia del migliore

        //per ogni elemento di successori
        for (Mossa successore : successori) {
            // creo una copia del tavolo
            Tavolo nuovo_tavolo = (Tavolo) tavolo.clone();

            //effettuo la ValutaMosse sul nuovo tavolo
            nuovo_tavolo.muoviPezzo(successore.getPartenza(), successore.getArrivo());
            //si attribuisce a ris_succ il valore della funzione Alphabeta
            ris_succ = alphaBeta(prof + 1, nuovo_tavolo, getAvversario(giocatore), -passaSoglia, -usaSoglia, euristica);
            //si assegna a nuovo valore il valore di ris_succ cambiato di segno
            nuovo_valore = -(ris_succ.getValore());
            //se nuovo_valore>passaSoglia trovo un successore migliore di quelli esaminati fino ad ora e lo memorizzo
            if (nuovo_valore > passaSoglia) {
                passaSoglia = nuovo_valore;
                ris_succ.getCammino().push(successore);
                cammino_migliore = ris_succ.getCammino();
            }
            /* se passaSoglia (che riflette il valore maggiore corrente) non e migliore di usaSoglia si deve
            terminare l'esame di questo cammino. E il TAGLIO ALPHABETA
            Essendo i due valori delle soglie invertiti se  passaSoglia>=usaSoglia
            allora si termina immediatamente la struttura restituendo
            la struttura con valore passaSoglia e cammino il cammino migliore */
            if (passaSoglia >= usaSoglia)
                return new ValutaMosse(passaSoglia, cammino_migliore);
        }
        //restituisco la struttura con valore passaSoglia e seguo il cammino migliore
        return new ValutaMosse(passaSoglia, cammino_migliore);
    }

    /**
     * Metodo che genera un vettore con tutte le mosse fattibili del giocatore passato come parametro
     * nella situazione di gioco attuale
     *
     * @param tavolo    Il tavolo di gioco
     * @param giocatore Il giocatore corrente
     * @return Le mosse generate
     */
    private Vector<Mossa> generaMosse(Tavolo tavolo, byte giocatore) {
        //creo un vettore contenente tutti i pezzi (buoni/cattivi) in gioco del giocatore di cui si vuol generare le mosse fattibili
        Vector<Pezzo> pez = tavolo.getPezziInGioco(giocatore);

        Vector<Pezzo> pezzi = new Vector<Pezzo>();

        // determina quando i pezzi sono stati tutti distribuiti casualmente nel vettore pezzi
        boolean continua = true;
        int pezzi_totali = pez.size();

        while (continua) {
            // se il vettore pezzi ha gia tutti i pezzi inseriti esco dal ciclo
            if (pezzi.size() == pezzi_totali)
                continua = false;
            else {
                // scelgo un pezzo casualmete da inserire nel vettore pezzi
                int index = ((int) (Math.random() * 10)) % pez.size();
                //altrimenti se nel vettore pezzi non c'e il pezzo lo inserisco e continuo il ciclo
                if (!pezzi.contains(pez.get(index)))
                    pezzi.add(pez.remove(index));
            }
        }

        //vettore che conterra le mosse fattibili del giocatore passato come parametro
        Vector<Mossa> mosse = new Vector<Mossa>();
        //scorro tutti i pezzi del giocatore

        for (Pezzo pezzo : pezzi) {
            //per ogni pezzo scorro le mosse fattibili
            for (Coordinata arrivo : pezzo.getMosseFattibili()) {
                //identifico la coordinata di partenza
                Coordinata partenza = pezzo.getCoordinata();
                //identifico la coordinata di arrivo
                Mossa succ = new Mossa(partenza, arrivo);
                //aggiungo la ValutaMosse nel vettore mosse fattibili
                mosse.add(succ);
            }
        }
        return mosse;
    }

    /**
     * Metodo che restituisce il numero del giocatore avversario
     *
     * @return byte L'avversario
     */
    private byte getAvversario(byte g) {
        if (g == 1)
            return 2;
        return 1;
    }

    /**
     * Questa funzione richiama le euristiche selezionate e calcola il punteggio statico del tavolo
     *
     * @param giocatore byte Giocatore di cui si vuole valutare il tavolo
     * @param tavolo    Tavolo Tavolo da valutare
     * @param euristica L'euristica da utilizzare per valutare il tavolo
     * @return La valutazione del tavolo
     */
    private double valuta_tavolo(Tavolo tavolo, byte giocatore, EuristicheFactory.EURISTICHE euristica) {
        Euristica e = EuristicheFactory.getInstance().getEuristica(euristica);
        return e.valuta(tavolo, giocatore);
    }

    /**
     * Classe che contiene l'elenco delle mosse fornite dall'esplorazione dell'albero
     */
    private class ValutaMosse {
        //valore dello stato più vicino allo stato di partenza
        private double val = 0;
        //elenco delle mosse da eseguire
        private Stack<Mossa> cammino = new Stack<Mossa>();

        public ValutaMosse(double d, Stack<Mossa> cam) {
            val = d;
            cammino = cam;
        }

        public Stack<Mossa> getCammino() {
            return cammino;
        }

        public double getValore() {
            return val;
        }
    }
}

		
	
	


