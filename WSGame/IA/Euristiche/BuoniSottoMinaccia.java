package IA.euristiche;

import logica.Pezzo;
import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */
/**
 * Determina se qualche pezzo buono del giocatore corrente e sotto minaccia.
 */
public class BuoniSottoMinaccia implements Euristica {

    private double coeff = 0.05;

    @Override
    public double valuta(Tavolo tavolo, byte giocatore, String partita) {
        //se giocatore 1
        int conta = 0;

        if (giocatore == 1)
            for (Pezzo pezzo : tavolo.vettorePezzi((byte) 1))
                //scorro tutte le mosse in cui il pezzo in questione  puo essere mangiato
                conta += pezzo.getCoordinatePezziMangiabili().size();
        else
            for (Pezzo pezzo : tavolo.vettorePezzi((byte) 3))
                //scorro tutte le mosse in cui il pezzo in questione puo essere mangiato
                conta += pezzo.getCoordinatePezziMangiabili().size();
        return -(coeff * conta);
    }
}
