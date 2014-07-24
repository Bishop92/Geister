package IA.euristiche;

import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */

public class CattiviInGioco implements Euristica {

    /**
     * Array di coefficienti in cui l'indice corrisponde al numero di pezzi cattivi in gioco
     * coeff[0] -> 1000
     * coeff[1] -> -0.15
     * coeff[2] -> -0.1
     * coeff[3] -> -0.05
     * coeff[4] -> 	0.1
     */
    private double[] coeff = {1000, -0.15, -0.1, -0.05, 0.1};

    @Override
    public double valuta(Tavolo tavolo, byte giocatore, String partita) {
        if (giocatore == 1)
            return coeff[tavolo.getNumeroPezziCattivi((byte) 1)];
        return coeff[tavolo.getNumeroPezziCattivi((byte) 2)];
    }
}
