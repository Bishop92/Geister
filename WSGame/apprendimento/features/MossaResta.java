package apprendimento.features;

import java.util.Vector;

/**
 * Feature rappresentate il numero di volte che il pezzo e rimasto quando viene posto sotto minaccia
 */
public class MossaResta implements Feature {

    private Vector<Integer> pezzi = new Vector<Integer>();
    private Controllore controllore;

    public MossaResta(int numPezzi, Controllore c) {
        controllore = c;
        for (int i = 0; i < numPezzi; ++i)
            pezzi.add(i, 0);
    }

    @Override
    public void resolve(int numMossa, String mossa, int pezzo, int giocatore) {
        for (int p = 0; p < 8; p++)
            if (pezzo != p && controllore.isVivo(p, giocatore) && controllore.minacciato(p, giocatore))
                pezzi.setElementAt(pezzi.elementAt(pezzo) + 1, pezzo);
    }

    @Override
    public Double getFeature(int pezzo) {
        return pezzi.elementAt(pezzo).doubleValue();
    }

}
