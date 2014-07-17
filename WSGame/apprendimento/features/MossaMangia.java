package apprendimento.features;

import java.util.Vector;

/**
 * Feature per indicare il numero di volte che il pezzo ha risposto mangiando il pezzo che lo ha messo sotto minaccia
 */
public class MossaMangia implements Feature {

    private Vector<Integer> pezzi = new Vector<Integer>();
    private Controllore controllore;

    public MossaMangia(int numPezzi, Controllore c) {
        controllore = c;
        for (int i = 0; i < numPezzi; ++i)
            pezzi.add(i, 0);
    }

    @Override
    public void resolve(int numMossa, String mossa, int pezzo, int giocatore) {
        if (controllore.mangia(mossa, giocatore))
            pezzi.setElementAt(pezzi.elementAt(pezzo) + 1, pezzo);
    }

    @Override
    public Double getFeature(int pezzo) {
        return pezzi.elementAt(pezzo).doubleValue();
    }

}
