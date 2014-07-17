package IA.euristiche;

import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */

public class BuoniInGioco implements Euristica {

    /**
     * Array di coefficienti in cui l'indice corrisponde al numero di pezzi buoni in gioco
     * coeff[0] -> -1000
     * coeff[1] -> -0.8
     * coeff[2] -> -0.6
     * coeff[3] -> -0.5
     * coeff[4] ->  0.2
     */
    private double[] coeff = {-1000, -0.8, -0.6, -0.5, 0.2};

    @Override
    public double valuta(Tavolo tavolo, byte giocatore) {
        if (giocatore == 1)
            return coeff[tavolo.getNumeroPezziBuoni((byte) 1)];
        return coeff[tavolo.getNumeroPezziBuoni((byte) 2)];
    }
}
