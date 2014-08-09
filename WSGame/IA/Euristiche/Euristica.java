package IA.euristiche;

import IA.euristiche.operations.HeuristicOperation;
import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */
public abstract class Euristica {
    /**
     * Effettua la valutazione del tavolo
     * @param tavolo Il tavolo da valutare
     * @param giocatore Il giocatore a cui tocca muovere
     * @return double La valutazione del tavolo
     */
    public abstract double valuta(Tavolo tavolo, byte giocatore, String partita);

    /**
     * Esegue l'operazione richiesta
     * @param heuristicOperation L'operazione da eseguire
     */
    public void doOperation(HeuristicOperation heuristicOperation) {
        heuristicOperation.doHeuristicOperation(this);
    }
}
