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

import IA.Euristiche.EuristicheFactory;
import IA.Strategie.Strategia;
import IA.Strategie.StrategieFactory;
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
    private Tavolo tav;
    /**
     * Indica il giocatore che ha richiesto l'attivazione dell'intelligenza artificiale
     */
    private Giocatore giocatoreCorrente;
    /**
     * Livello del giocatore corrente
     */
    private double livelloGiocatoreCorrente;
    /**
     * L'euristica selezionata per la valutazione del tavolo
     */
    private EuristicheFactory.EURISTICHE euristica;
    /**
     * La strategia da utilizzare per scegliere la mossa
     */
    private Strategia strategia;

    /**
     * @param t                  Il Tavolo
     * @param gCorrente          Il giocatore corrente
     * @param a                  L'avversario
     * @param lGiocatoreCorrente Il livello del giocatore corrente (IA)
     * @param p                  La partita in corso
     * @param e                  L'euristica impiegata per valutare il tavolo
     * @param s                  La strategia per scelgiere le mosse
     * @param r                  Il ranker che effettuera la valutazione della tipologia dei pezzi
     */
    public IntelligenzaArtificiale(Tavolo t, Giocatore gCorrente, Giocatore a, double lGiocatoreCorrente, String p, EuristicheFactory.EURISTICHE e, StrategieFactory.STRATEGIE s, RankerFactory.RANKERS r) {
        tav = t;
        giocatoreCorrente = gCorrente;
        livelloGiocatoreCorrente = lGiocatoreCorrente;
        euristica = e;
        strategia = StrategieFactory.getInstance().getStrategia(s);
        valutaPezzi = new ValutaPezzi(t, giocatoreCorrente, a, livelloGiocatoreCorrente, p, r);
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
     * CASO_3: se il livello di IA e tra 0 e 1 allora devo applicare l'algoritmo alfa_beta  per il calcolo della mossa migliore (mossaMinMaxAB())
     */
    public Mossa calcolaMossa() {
        /*attivo il valutaPezzi per aggiornarlo e permettere l'uso dell'intelligenza artificiale,
        i pezzi avversari saranno stanziati a PezzoNascosto e ad ogni pezzo sara associato
        il prorpio valutaPezzi grazie all'algoritmo di apprendimento*/
        attivaProfilo(true);
        //cancello i valori precedenti
        tav.aggiornaMosseLegali();

        //contiene il vettore dei pezzi buoni del giocatore corrente.
        Vector<Pezzo> pezziBuoni;

        if (giocatoreCorrente.getNumero() == (byte) 1) {
            //assegno apez_buoni i pezzi buoni del giocatore 1
            pezziBuoni = tav.vettorePezzi((byte) 1);
            //controllo se un pezzo buono o in una casella da cui puo uscire dal tavoliere e vincere la partita
            for (Pezzo pezzo : pezziBuoni)
                if ((pezzo.getCoordinata().getRiga() == 5 && pezzo.getCoordinata().getColonna() == 0) ||
                        (pezzo.getCoordinata().getRiga() == 5 && pezzo.getCoordinata().getColonna() == 5))
                    return new Mossa(pezzo.getCoordinata(), null);
        }

        if (giocatoreCorrente.getNumero() == (byte) 2) {
            pezziBuoni = tav.vettorePezzi((byte) 3);
            //controllo se un pezzo buono o in una casella da cui puo uscire dal tavoliere e vincere la partita
            for (Pezzo pezzo : pezziBuoni)
                if ((pezzo.getCoordinata().getRiga() == 0 && pezzo.getCoordinata().getColonna() == 0) ||
                        (pezzo.getCoordinata().getRiga() == 0 && pezzo.getCoordinata().getColonna() == 5))
                    return new Mossa(pezzo.getCoordinata(), null);
        }
        //se il livello del giocatore o 1 attivo la modalita random in quanto la componente di apprendimento viene annullata

        Mossa mossa;
        if (livelloGiocatoreCorrente == -1)
            mossa = mossaRandom();
        else
            //la modalita non e random allora calcola tutte le possibili mosse richiamando l'algoritmo di ricerca in MinMaxAB
            mossa = getMossa();
        //disattivo valutaPezzi in quanto non pio necessario per l'intelligenza
        attivaProfilo(false);

        return mossa;
    }

    /**
     * Sceglie una mossa a caso da effettuare
     */
    private Mossa mossaRandom() {
        StrategieFactory strategieFactory = StrategieFactory.getInstance();
        return strategieFactory.getStrategia(StrategieFactory.STRATEGIE.RANDOM).getMossa(tav, giocatoreCorrente, euristica);
    }

    /**
     * Determina la mossa migliore da eseguire
     */
    private Mossa getMossa() {
        return strategia.getMossa(tav, giocatoreCorrente, euristica);
    }
}

