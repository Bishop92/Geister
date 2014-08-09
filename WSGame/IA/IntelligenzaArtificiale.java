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

import java.util.Vector;

import IA.euristiche.*;
import IA.euristiche.operations.AddEvaluationOperation;
import IA.euristiche.operations.LearnOperation;
import IA.strategie.Strategia;
import IA.strategie.StrategieFactory;
import apprendimento.ValutaPezzi;
import apprendimento.ranker.RankerFactory;
import logica.*;

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
     * L'oggetto incaricato di fornire la tipologia dei pezzi
     */
    private ValutaPezzi valutaPezzi;
    /**
     * Indica il tavolo sul quale si e attivata l'intelligenza artificiale
     */
    private Tavolo tavolo;
    /**
     * Indica il giocatore che viene rappresentato dall'intelligenza artificiale
     */
    private Giocatore giocatore;
    /**
     * Livello del giocatore corrente
     */
    private double livelloIA;
    /**
     * Indica l'avversario contro cui l'intelligenza artificiale sta giocando
     */
    private Giocatore avversario;
    /**
     * La partita di riferimento
     */
    private String partita;
    /**
     * L'euristica selezionata per la valutazione del tavolo
     */
    private EuristicheFactory.EURISTICHE euristica;
    /**
     * La strategia da utilizzare per scegliere la mossa
     */
    private Strategia strategia;
    /**
     * Indica se l'intelligenza artificiale ha vinto o perso la partita
     */
    private double esito = 0;

    /**
     * @param g   Il giocatore corrente
     * @param a   L'avversario
     * @param lIA Il livello del giocatore corrente (IA)
     * @param p   La partita in corso
     * @param e   L'euristica impiegata per valutare il tavolo
     * @param s   La strategia per scelgiere le mosse
     * @param r   Il ranker che effettuera la valutazione della tipologia dei pezzi
     */
    public IntelligenzaArtificiale(Giocatore g, Giocatore a, double lIA, String p, EuristicheFactory.EURISTICHE e, StrategieFactory.STRATEGIE s, RankerFactory.RANKERS r) {
        giocatore = g;
        livelloIA = lIA;
        avversario = a;
        partita = p;
        euristica = e;
        strategia = StrategieFactory.getInstance().getStrategia(s);
        valutaPezzi = new ValutaPezzi(giocatore, a, livelloIA, partita, r);
    }

    /**
     * Imposta il tavolo dopo una mossa da parte dell'avversario
     *
     * @param t Il tavolo
     */
    public void setTavolo(Tavolo t) {
        valutaPezzi.setTavolo(t);
        tavolo = t;
    }

    /**
     * Attiva il valutaPezzi ovvero rendere nacosti i pezzi avversari per utilizzare
     * gli algoritmi di apprendimento e di intelligenza o li disattiva in caso contrario
     *
     * @param bool Se true attiva il valutaPezzi, altrimenti lo disattiva
     */
    void attivaProfilo(boolean bool) {
        if (bool)
            valutaPezzi.aggiornaProfilo();
        else
            valutaPezzi.disattivaProfilo();
    }

    /**
     * Determina la mossa da effettuare
     * Esistono 3 casi:
     * CASO_1: se un pezzo buono del giocatore corrente, cioe colui che ha il turno e usa l'ia, e nella condizione
     * di poter uscire dal tavolo (casella di uscita) la mossa ritornata sara quella che permette di uscire dal tavolere e VINCERE la sfida
     * CASO_2: se il livello di IA e 1 significa che sto usando l'algoritmo con grado di rumore massimo pertanto la mossa sara sicuramente RANDOM (mossaRandom())
     * CASO_3: se il livello di IA e tra 0 e 1 allora devo applicare l'algoritmo richiesto per il calcolo della mossa migliore (getMossa())
     */
    public Mossa calcolaMossa() {
        /*attivo il valutaPezzi per aggiornarlo e permettere l'uso dell'intelligenza artificiale,
        i pezzi avversari saranno stanziati a PezzoNascosto e ad ogni pezzo sara associato
        il prorpio valutaPezzi grazie all'algoritmo di apprendimento*/
        attivaProfilo(true);
        //cancello i valori precedenti
        tavolo.aggiornaMosseLegali();

        //contiene il vettore dei pezzi buoni del giocatore corrente.
        Vector<Pezzo> pezziBuoni;

        if (giocatore.getNumero() == (byte) 1) {
            //assegno apez_buoni i pezzi buoni del giocatore 1
            pezziBuoni = tavolo.vettorePezzi((byte) 1);
            //controllo se un pezzo buono e in una casella da cui puo uscire dal tavoliere e vincere la partita
            for (Pezzo pezzo : pezziBuoni)
                if ((pezzo.getCoordinata().getRiga() == 5 && pezzo.getCoordinata().getColonna() == 0) ||
                        (pezzo.getCoordinata().getRiga() == 5 && pezzo.getCoordinata().getColonna() == 5)) {
                    esito = 1;
                    return new Mossa(pezzo.getCoordinata(), null);
                }
        }

        if (giocatore.getNumero() == (byte) 2) {
            pezziBuoni = tavolo.vettorePezzi((byte) 3);
            //controllo se un pezzo buono e in una casella da cui puo uscire dal tavoliere e vincere la partita
            for (Pezzo pezzo : pezziBuoni)
                if ((pezzo.getCoordinata().getRiga() == 0 && pezzo.getCoordinata().getColonna() == 0) ||
                        (pezzo.getCoordinata().getRiga() == 0 && pezzo.getCoordinata().getColonna() == 5)) {
                    esito = 1;
                    return new Mossa(pezzo.getCoordinata(), null);
                }
        }
        //se il livello del giocatore o 1 attivo la modalita random in quanto la componente di apprendimento viene annullata

        Mossa mossa;
        if (livelloIA == -1)
            mossa = mossaRandom();
        else
            //la modalita non e random allora calcola tutte le possibili mosse richiamando l'algoritmo di ricerca in MinMaxAB
            mossa = getMossa();
        //disattivo valutaPezzi in quanto non pio necessario per l'intelligenza
        attivaProfilo(false);

        //ottengo l'euristica implementata per aggiungere il tavolo selezionato all'eventuale training set
        Euristica e = EuristicheFactory.getInstance().getEuristica(euristica);

        //ottengo una copia del tavolo su cui effettuare la mossa
        Tavolo tavoloValutabile = (Tavolo) tavolo.clone();
        //effettuo la mossa
        tavoloValutabile.muoviPezzo(mossa.getPartenza(), mossa.getArrivo());
        //fornisco all'euristica il tavolo da valutare che effettivamente è stato selezionato tra tutti quelli generati
        //la valutazione del tavolo finirà nel training set
        e.doOperation(new AddEvaluationOperation(partita, giocatore.getNumero(), tavoloValutabile));

        return mossa;
    }

    /**
     * Sceglie una mossa a caso da effettuare
     *
     * @return La mossa scelta a caso
     */
    private Mossa mossaRandom() {
        StrategieFactory strategieFactory = StrategieFactory.getInstance();
        return strategieFactory.getStrategia(StrategieFactory.STRATEGIE.RANDOM).getMossa(tavolo, giocatore, euristica, partita);
    }

    /**
     * Determina la mossa migliore da eseguire
     *
     * @return La mossa fornita dalla strategia scelta
     */
    private Mossa getMossa() {
        return strategia.getMossa(tavolo, giocatore, euristica, partita);
    }

    /**
     * Conclude la partita controllando se devono essere avviati eventuali apprendimenti
     */
    public void terminaPartita() {

        if (tavolo.getNumeroPezziBuoni(avversario.getNumero()) < 1)
            esito = 1;
        if (tavolo.getNumeroPezziCattivi(giocatore.getNumero()) < 1)
            esito = 1;

        //ottengo l'euristica ed eseguo l'apprendimento
        Euristica e = EuristicheFactory.getInstance().getEuristica(euristica);
        e.doOperation(new LearnOperation(partita, esito));
    }
}

