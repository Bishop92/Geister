package IA.Euristiche;

import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */
public interface Euristica {
    /**
     * Effettua la valutazione del tavolo
     * @param tavolo Il tavolo da valutare
     * @param giocatore Il giocatore a cui tocca muovere
     * @return double La valutazione del tavolo
     */
    public double valuta(Tavolo tavolo, byte giocatore);
}
