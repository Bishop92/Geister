package IA.euristiche;

import logica.Coordinata;
import logica.Pezzo;
import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */
/**
 * Controlla se un pezzo cattivo del giocatore corrente sta minacciando un pezzo buono avversario.
 */
public class AttaccoAiBuoni implements Euristica {

    private double coeff = 0.05;

    @Override
    public double valuta(Tavolo tavolo, byte giocatore, String partita) {
        //se giocatore 1
        int conta = 0;

        if (giocatore == 1) {
            for (Pezzo pezzo : tavolo.vettorePezzi((byte) 2)) {
                //scorro tutte le mosse in cui il pezzo in questione mangia un pezzo avversario
                for (Coordinata coordinata : pezzo.getCoordinatePezziMangiabili())
                    //se il pezzo avversario sotto minaccia e buono
                    if (tavolo.getPezzo(coordinata).isBuono())
                        conta++;
            }
        } else {
            for (Pezzo pezzo : tavolo.vettorePezzi((byte) 4)) {
                //scorro tutte le mosse in cui il pezzo in questione mangia un pezzo avversario
                for (Coordinata coordinata : pezzo.getCoordinatePezziMangiabili())
                    //se il pezzo avversario sotto minaccia e buono
                    if (tavolo.getPezzo(coordinata).isBuono())
                        conta++;
            }
        }
        return coeff * conta;
    }
}
