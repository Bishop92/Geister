package apprendimento.features;

import java.util.Vector;

/**
 * Feature indicante il numero di volte che il pezzo e scappato quando viene posto sotto minaccia
 */
public class MossaScappa implements Feature {

    private Vector<Integer> pezzi = new Vector<Integer>();
    private Controllore controllore;

    public MossaScappa(int numPezzi, Controllore c) {
        controllore = c;
        for (int i = 0; i < numPezzi; ++i)
            pezzi.add(i, 0);
    }

    @Override
    public void resolve(int numMossa, String mossa, int pezzo, int giocatore) {
        if (controllore.minacciaPos(mossa.substring(0, 2), 2) && !controllore.mangia(mossa, giocatore))
            pezzi.setElementAt(pezzi.elementAt(pezzo) + 1, pezzo);
    }

    @Override
    public Double getFeature(int pezzo) {
        return pezzi.elementAt(pezzo).doubleValue();
    }

}
