package IA.euristiche;

import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */

public class BuoniMangiati implements Euristica {

    /**
     * Array di coefficienti in cui l'indice corrisponde al numero di pezzi buoni mangiaticoeff[0] -> 0
     * coeff[1] -> 0.5
     * coeff[2] -> 0.6
     * coeff[3] -> 0.8
     * coeff[4] -> 1000
     */
    private double[] coeff = {0, 0.5, 0.6, 0.8, 1000};

    @Override
    public double valuta(Tavolo tavolo, byte giocatore, String partita) {
        // ritorno il coeff corretto corrispondente al numero di pezzi buoni mangiati
        if (giocatore == 1)
            return coeff[(4 - tavolo.vettorePezzi((byte) 3).size())];
        return coeff[(4 - tavolo.vettorePezzi((byte) 1).size())];
    }
}
