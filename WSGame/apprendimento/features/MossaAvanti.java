package apprendimento.features;

import java.util.Vector;

/**
 * Feature indicante il numero di volte che il pezzo ha effettuato una mossa in avanti
 */
public class MossaAvanti implements Feature {

    private Vector<Integer> pezzi = new Vector<Integer>();

    public MossaAvanti(int numPezzi) {
        for (int i = 0; i < numPezzi; ++i)
            pezzi.add(i, 0);
    }

    @Override
    public void resolve(int numMossa, String mossa, int pezzo, int giocatore) {
        if (giocatore == 1)
            if ((Integer.parseInt(mossa.substring(0, 1)) < Integer.parseInt(mossa.substring(3, 4))))
                pezzi.setElementAt(pezzi.elementAt(pezzo) + 1, pezzo);
        else
            if ((Integer.parseInt(mossa.substring(0, 1)) > Integer.parseInt(mossa.substring(3, 4))))
                pezzi.setElementAt(pezzi.elementAt(pezzo) + 1, pezzo);
    }

    @Override
    public Double getFeature(int pezzo) {
        return pezzi.elementAt(pezzo).doubleValue();
    }

}
