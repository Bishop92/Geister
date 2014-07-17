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
 * Autore: Appon Luca
 * Data: 21/11/2008
*/

package IA;

import java.io.FileNotFoundException;
import java.util.Vector;

import logica.Coordinata;
import logica.Giocatore;
import logica.Pezzo;
import logica.Tavolo;
import apprendimento.FeatureCollector;
import apprendimento.Ranker;
import apprendimento.features.MosseAvanti;
import apprendimento.learner.Learner;

/**
 * Questa classe permette di creare un'intelligenza artificiale
 * La creazione di un'intelligenza artificiale, permette di prevedere la bonta' dei
 * pezzi avversari e di calcolare la mossa migliore da effettuare in qualsiasi
 * momento del gioco.
 * <p>&nbsp;
 * ChangeLog:
 * LS:Cambiato costruttore, invece di Partita, passo tavolo direttamente.
 * LS: aggiunto livello umano da passare al ranker
 * </p>
 *
 * @author Appon Luca
 * @author Luca Semenzato
 * @version 5.0 del 02/01/2012
 */
public class IntelligenzaArtificiale {
    /**
     * indica il nodo di origine dell'albero di esplorazione delle mosse fattibili
     */
    private MinMaxAB origine = null;
    /**
     * indica la coordinata di partenza della mossa ritenuta migliore
     */
    private Coordinata partenza = null;
    /**
     * indica la coordinata di arrivo della mossa ritenuta migliore
     */
    private Coordinata arrivo = null;

    /**
     * puntatore al profilo dei pezzi dell'avversario
     */
    private Ranker profilo;
    //private Profilo profilo;

    /**
     * indica il tavolo sul quale si e' attivata l'intelligenza artificiale
     */
    private Tavolo tav;

    /**
     * indica il giocatore che ha richiesto l'attivazione dell'intelligenza artificiale
     */
    private Giocatore giocatore_corrente;
    /**
     * indica il giocatore del quale si vuole prevedere la bonta' dei pezzi
     */
    private Giocatore avversario;
    /**
     * determina la profondit� con cui richiamare l'algoritmo alphabeta per il calcolo della mossa da effettuare.
     * maggiore � la profondita pi� precisa sar� la mossa calcolata
     */
    private final int profondita = 4;
    /**
     * indica il livello del giocatore che usa l'intelligenza artificiale
     */
    private double livello;
    /**
     * indica il livello del giocatore umano (da passare al ranker)
     */
    private double livelloAvversario;
    /**
     * Features collector usato per il ranker
     */
    private FeatureCollector fc;

    /**
     * contiene le euristiche scelte da usare
     */
    private Vector<String> euristiche = new Vector<String>();

    /**
     * contiene il nome univoco del match
     */
    private String nomePartita;

    /**
     * Costruttore a 5 parametri che permette di associare l'intelligenza artificiale
     * ad un determinato giocatore.
     *
     * @param p           partita
     * @param liv         livello del giocatore corrente (IA)
     * @param livAvv      livello del giocatore avversario (umano)
     * @param gioc_corr   il giocatore corrente
     * @param avv         il giocatore avversario
     * @param eur         le euristiche del giocatore corrente
     * @param nomePartita nome della Partita in atto, serve per recuperare informazioni sul match
     * @param nomeRanker  nome del ranker da utilizzare per l'analisi
     * @throws FileNotFoundException
     */
    public IntelligenzaArtificiale(Tavolo t, double liv, double livAvv, Giocatore gioc_corr, Giocatore avv, Vector<String> eur, String nomePar) {
        tav = t;
        livello = liv;
        livelloAvversario = livAvv;
        giocatore_corrente = gioc_corr;
        avversario = avv;
        euristiche = eur;
        nomePartita = nomePar;

        fc = new FeatureCollector();
        for (int i = 0; i < 18; i++) {
            fc.addFeature(new MosseAvanti());
        }
        //profilo = new Profilo(p,gioc_corr,avv);
        profilo = new Ranker(tav, gioc_corr, avv, livelloAvversario, fc, nomePartita);

        System.out.print("giocatore " + giocatore_corrente.getNumero() + " ha livello: " + livello + " e numero di euristiche " + euristiche.size());
        // attivo il profilo per aggiornarlo e permettere l'uso dell'intelligenza artificiale,
        //  i pezzi avversari saranno stanziati a PezzoNascosto e ad ogni pezzo sar� asociato il prorpio profilo grazie all'algoritmo di apprendimento
//		System.out.println("Attivo profilo giocatore con livello == "+livello);
        attivaProfilo(true);
    }


    /**
     * Metodo che consente di attivare il profilo ovvero rendere nacosti i pezzi avversari per utilizzare
     * gli algoritmi di apprendimento e di intelligenza o disattivarli in caso contrario
     *
     * @param bool true attiva il profilo, false lo disattiva
     */
    public void attivaProfilo(boolean bool) {
        if (bool) {
            System.out.println("****** IA.ATTIVAPROFILO *********");
            profilo.aggiornaProfilo();
        } else
            profilo.disattivaProfilo();
    }

    /**
     * Metodo senza parametri che permette di determinare la coordinata di partenza della mossa migliore da effettuare
     *
     * @return Coordinata di partenza della mossa migliore da fare
     */
    public Coordinata getPartenza() {
        return partenza;
    }

    /**
     * Metodo senza parametri che permette di determinare la coordinata di arrivo della mossa migliore da effettuare
     *
     * @return Coordinata di arrivo della mossa migliore da fare
     */
    public Coordinata getArrivo() {
        return arrivo;
    }

    /**
     * Metodo ad un parametro che permette di determinare la mossa da effettuare
     * Esistono 3 casi:
     * CASO_1: se un pezzo buono del giocatore corrente, cio� colui che ha il turno e usa l'ia, � nella condizione
     * di poter uscire dal tavolo (casella di uscita) la mossa ritornata sar� quella che permette di uscire dal tavolere e VINCERE la sfida
     * CASO_2: se il livello di ia � 1 significa che sto usando l'algoritmo con grado di rumore massimo pertanto la mossa sar� sicuramente RANDOM (mossaRandom())
     * CASO_3: se il livello di ia � tra 0 e 1 allora devo applicare l'algoritmo alfa_beta  per il calcolo della mossa migliore (mossaMinMaxAB())
     */
    public void calcolaMossa() {
        //cancello i valori precedenti
        tav.aggiornaMosseLegali();
        partenza = null;
        arrivo = null;
        //contiene il vettore dei pezzi buoni del giocatore corrente.
        Vector<Pezzo> pez_buoni = new Vector<Pezzo>();
        //variablie per testare se un pezzo pu� uscire dal tavolo
        boolean uscito = false;
//		System.out.println("Sto calcolando mossa...");
        if (giocatore_corrente.getNumero() == (byte) 1) {
            //assegno apez_buoni i pezzi buoni del giocatore 1
            pez_buoni = tav.vettorePezzi((byte) 1);
            //controllo se un pezzo buono � in una casella da cui pu� uscire dal tavoliere e vincere la partita
            for (int i = 0; i < pez_buoni.size(); i++)
                if ((pez_buoni.get(i).getCoordinata().getRiga() == 5 && pez_buoni.get(i).getCoordinata().getColonna() == 0) ||
                        (pez_buoni.get(i).getCoordinata().getRiga() == 5 && pez_buoni.get(i).getCoordinata().getColonna() == 5)) {
                    partenza = pez_buoni.get(i).getCoordinata();
                    arrivo = null;
                    //aggiorno lo stato di uscito
                    uscito = true;
                    break;
                }
        }
        if (giocatore_corrente.getNumero() == (byte) 2) {
            pez_buoni = tav.vettorePezzi((byte) 3);
            //controllo se un pezzo buono � in una casella da cui pu� uscire dal tavoliere e vincere la partita
            for (int i = 0; i < pez_buoni.size(); i++)
                if ((pez_buoni.get(i).getCoordinata().getRiga() == 0 && pez_buoni.get(i).getCoordinata().getColonna() == 0) ||
                        (pez_buoni.get(i).getCoordinata().getRiga() == 0 && pez_buoni.get(i).getCoordinata().getColonna() == 5)) {
                    partenza = pez_buoni.get(i).getCoordinata();
                    arrivo = null;
                    uscito = true;
                    break;
                }
        }
        //se nessun pezz buono pu� uscire da tavolo cerco la mossa migliore
        if (uscito == false) {
            //se il livello del giocatore � 1 attivo la modalita' random in quanto la componente di apprendimento viene annullata
            if (livello == -1)
                mossaRandom();
            else { //la modalita' non e' random allora calcola tutte le possibili mosse richiamando l'algoritmo di ricerca in MinMaxAB
                mossaMinMaxAB();
                //per liberare memoria, cancello la radice dell'albero di ricerca poiche' non e'
                //necessaria per individuare la mossa miglire da effettuare (la mossa migliore e'
                //memorizzata in partenza ed arrivo)
                origine = null;
            }
            //disattivo profilo in quanto non pi� necessario per l'intelligenza
            attivaProfilo(false);
//			System.out.print("DOPO AVER DISATTIVATO PROFILO.......");
//			System.out.println("pezzi buoni giocatore"+this.avversario.getNumero());
//			
//			for(int i=0;i<par.getTavolo().vettorePezzi((byte)3).size();i++)
//			{
//				System.out.println(par.getTavolo().vettorePezzi((byte)3).get(i).getCoordinata().getRiga()+":"+par.getTavolo().vettorePezzi((byte)3).get(i).getCoordinata().getColonna());
//			}
        }
    }

    /**
     * Metodo senza parametri che permette di determinare una mossa casuale da effettuare.
     */
    private void mossaRandom() {
//		System.out.println("CALCOLO MOSSA RANDOM");
        //identifico i pezzi buoni e cattivi del giocatore corrente
        byte buoni;
        byte cattivi;
        if (giocatore_corrente.getNumero() == 1) {
            buoni = 1;
            cattivi = 2;
        } else {
            buoni = 3;
            cattivi = 4;
        }
        //variabile booleana per determinare se ho trovato il pezzo da muovere
        boolean continua = true;
        //continuo a cercare il pezzo da muovere fin quando lo trovo
        while (continua) {
            // scelgo se muovere un pezzo buono o cattivo
            // (sono sicuro che ci sono sia pezzi buoni che cattivi, altrimenti il gioco sarebbe finito
            if ((int) (Math.random() * 2) == 0) { //muovo un pezzo buono
                //conto quanti pezzi buoni ha il giocatore corrente
                byte num_pezzi_buoni = (byte) tav.vettorePezzi(buoni).size();
                //scelgo quale pezzo muovere (tra 0 e num_pezzi_buoni - 1)
                byte pezzo_da_muovere = (byte) (Math.random() * (num_pezzi_buoni - 1));
                //conto quante mosse valide puo' fare il pezzo
                byte num_mosse_valide = (byte) tav.vettorePezzi(buoni).get(pezzo_da_muovere).getMosseFattibili().size();
                if (num_mosse_valide == 0) {
                    //se il pezzo non puo' fare mosse legali, cerco un altro pezzo
                    continue;
                } else {
                    //scelgo la mossa che deve fare il pezzo (tra 0 e num_mosse_valide - 1)
                    byte mossa_da_fare = (byte) (Math.random() * (num_mosse_valide - 1));
                    //salvo la coordinata di partenza
                    partenza = tav.vettorePezzi(buoni).get(pezzo_da_muovere).getCoordinata();
                    //salvo la coordinata di arrivo
                    arrivo = tav.vettorePezzi(buoni).get(pezzo_da_muovere).getMosseFattibili().get(mossa_da_fare);
                    //blocco il ciclo while
                    continua = false;
                }
            } else { //muovo un pezzo cattivo
                //conto quanti pezzi cattivi ha il giocatore corrente
                byte num_pezzi_cattivi = (byte) tav.vettorePezzi(cattivi).size();
                //scelgo quale pezzo muovere (tra 0 e num_pezzi_cattivi - 1)
                byte pezzo_da_muovere = (byte) (Math.random() * (num_pezzi_cattivi - 1));
                //conto quante mosse valide puo' fare il pezzo
                byte num_mosse_valide = (byte) tav.vettorePezzi(cattivi).get(pezzo_da_muovere).getMosseFattibili().size();
                if (num_mosse_valide == 0) {
                    //se il pezzo non puo' fare mosse legali, cerco un altro pezzo
                    continue;
                } else {
                    //scelgo la mossa che deve fare il pezzo (tra 0 e num_mosse_valide - 1)
                    byte mossa_da_fare = (byte) (Math.random() * (num_mosse_valide - 1));
                    //salvo la coordinata di partenza
                    partenza = tav.vettorePezzi(cattivi).get(pezzo_da_muovere).getCoordinata();
                    //salvo la coordinata di arrivo
                    arrivo = tav.vettorePezzi(cattivi).get(pezzo_da_muovere).getMosseFattibili().get(mossa_da_fare);
                    //blocco il ciclo while
                    continua = false;
                }
            }
        }
    }

    /**
     * Metodo ad un parametro che permette di determinare la mossa migliore da eseguire
     */
    private void mossaMinMaxAB() {
//		System.out.println("CALCOLO MOSSA Intelligente");
        origine = new MinMaxAB(tav, giocatore_corrente.getNumero(), profondita, euristiche);
        //imposto la coordinata di partenza
//		System.out.println("Trovata coordinata della mossa");
        partenza = origine.getPosizioneIniziale();
        //imposto la coordinata di arrivo
        arrivo = origine.getPosizioneFinale();
//    	System.out.println("LA MOSSA HA PARTENZA IN "+partenza.getRiga()+" : "+partenza.getColonna());
//    	System.out.println("LA MOSSA HA ARRIVO IN "+arrivo.getRiga()+" : "+arrivo.getColonna());
//		System.out.println("punteggio coordinata "+origine.getPunteggio());
    }
}

