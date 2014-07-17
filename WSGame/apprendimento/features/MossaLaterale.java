package apprendimento.features;

import java.util.Vector;

/**
 * Feature indicante il numero di volte che il pezzo ha effettuato una mossa laterale
 */
public class MossaLaterale implements Feature {

    private Vector<Integer> pezzi = new Vector<Integer>();

    public MossaLaterale(int numPezzi) {
        for (int i = 0; i < numPezzi; ++i)
            pezzi.add(i, 0);
    }

    @Override
    public void resolve(int numMossa, String mossa, int pezzo, int giocatore) {
        if (Integer.parseInt(mossa.substring(0, 1)) == Integer.parseInt(mossa.substring(3, 4)))
            pezzi.setElementAt(pezzi.elementAt(pezzo) + 1, pezzo);
    }

    @Override
    public Double getFeature(int pezzo) {
        return pezzi.elementAt(pezzo).doubleValue();
    }

}
