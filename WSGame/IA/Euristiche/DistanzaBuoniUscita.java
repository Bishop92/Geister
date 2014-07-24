package IA.euristiche;

import logica.Coordinata;
import logica.Pezzo;
import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */
public class DistanzaBuoniUscita implements Euristica {
    /** Coefficienti associati alle varie distanze.
     * distanza 0 -> 0.8
     * distanza 1 -> 0.4
     * distanza 2 -> 0.2
     * distanza 3 -> 0.1
     * distanza 4 -> -0.1
     * distanza 5 -> -0.2
     * distanza 6 -> -0.3
     * distanza 7 -> -0.4
     */
    private double[] coeff = {0.8, 0.4, 0.2, 0.1, -0.1, -0.2, -0.3, -0.4};

    @Override
    public double valuta(Tavolo tavolo, byte giocatore, String partita) {

        //distanza inizialmente a 7 e' la massima distanza (minima) possibile
        int distanza = 7;
        //se giocatore 1
        if (giocatore == 1) {
            //scorro tutti i suoi pezzi buoni per trovare quello con distanza minore dall'uscita
            for (Pezzo pezzo : tavolo.vettorePezzi((byte) 1)) {
                // calcolo la distanza dalle due caselle di uscita [5,0] e [5,5]
                int d1 = Math.abs(pezzo.getCoordinata().getRiga() - 5) + Math.abs(pezzo.getCoordinata().getColonna() - 0);
                int d2 = Math.abs(pezzo.getCoordinata().getRiga() - 5) + Math.abs(pezzo.getCoordinata().getColonna() - 5);

                // se trovo una distanza minore della precedente allora la memorizzo
                if (distanza > d1 || distanza > d2)
                    distanza = Math.min(d1, d2);

                // se distanza==0 allora controllo che nelle caselle adiacenti non ci siano pezzi avversari
                // se non vi sono ritorna valore MAX in quanto al prossimo turno il giocatore vincera la partita

                if (distanza == 0) {
                    if (d1 == 0) {
                        Coordinata c1 = new Coordinata((byte) 4, (byte) 0);
                        Coordinata c2 = new Coordinata((byte) 5, (byte) 1);
                        if (tavolo.getPezzo(c1) == null || tavolo.getPezzo(c1).getGiocatore() == 1 ||
                                tavolo.getPezzo(c2) == null || tavolo.getPezzo(c2).getGiocatore() == 1)
                            return 1000;
                    }
                    if (d2 == 0) {
                        Coordinata c1 = new Coordinata((byte) 5, (byte) 4);
                        Coordinata c2 = new Coordinata((byte) 4, (byte) 5);
                        if (tavolo.getPezzo(c1) == null || tavolo.getPezzo(c1).getGiocatore() == 1 ||
                                tavolo.getPezzo(c2) == null || tavolo.getPezzo(c2).getGiocatore() == 1)
                            return 1000;
                    }
                }
            }
        } else {
            //se giocatore 2
            for (Pezzo pezzo : tavolo.vettorePezzi((byte) 3)) {
                // scorro tutti i suoi pezzi buoni per trovare quello con distanza minore dall'uscita
                int d1 = Math.abs(pezzo.getCoordinata().getRiga() - 0) + Math.abs(pezzo.getCoordinata().getColonna() - 0);
                int d2 = Math.abs(pezzo.getCoordinata().getRiga() - 0) + Math.abs(pezzo.getCoordinata().getColonna() - 5);
                // se trovo una distanza minore della precedente allora la memorizzo
                if (distanza > d1 || distanza > d2)
                    distanza = Math.min(d1, d2);


                // se distanza == 0 allora controllo che nelle caselle adiacenti non ci siano pezzi avversari
                // se non vi sono ritorna valore MAX in quanto al prossimo turno il giocatore vincera la partita
                if (distanza == 0) {
                    if (d1 == 0) {
                        Coordinata c1 = new Coordinata((byte) 0, (byte) 1);
                        Coordinata c2 = new Coordinata((byte) 1, (byte) 0);
                        if (tavolo.getPezzo(c1) == null || tavolo.getPezzo(c1).getGiocatore() == 2 ||
                                tavolo.getPezzo(c2) == null || tavolo.getPezzo(c2).getGiocatore() == 2)
                            return 1000;
                    }
                    if (d2 == 0) {
                        Coordinata c1 = new Coordinata((byte) 1, (byte) 5);
                        Coordinata c2 = new Coordinata((byte) 0, (byte) 4);
                        if (tavolo.getPezzo(c1) == null || tavolo.getPezzo(c1).getGiocatore() == 2 ||
                                tavolo.getPezzo(c2) == null || tavolo.getPezzo(c2).getGiocatore() == 2)
                            return 1000;
                    }
                }
            }
        }
        // altrimenti ritorno il coefficiente
        return coeff[distanza];
    }
}
