package apprendimento.features;

import java.util.Vector;

/**
 * Feature per indicare se il pezzo ha effettuato la seconda mossa
 */
public class SecondaMossa implements Feature {

    private Vector<Integer> pezzi = new Vector<Integer>();

    public SecondaMossa(int numPezzi) {
        for (int i = 0; i < numPezzi; ++i)
            pezzi.add(i, 0);
    }

    @Override
    public void resolve(int numMossa, String mossa, int pezzo, int giocatore) {
        pezzi.setElementAt((numMossa == 1 ? 1 : 0), pezzo);
    }

    @Override
    public Double getFeature(int pezzo) {
        return pezzi.elementAt(pezzo).doubleValue();
    }

}
