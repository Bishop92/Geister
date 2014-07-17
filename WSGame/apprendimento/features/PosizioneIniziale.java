package apprendimento.features;

import java.util.Vector;

/**
 * Feature indicante la posizione iniziale dei pezzi
 */
public class PosizioneIniziale implements Feature {

    private Vector<Integer> pezzi = new Vector<Integer>();
    private int posizione;

    public PosizioneIniziale(int numPezzi, int p) {
        posizione = p;
        for (int i = 0; i < numPezzi; ++i) {
            pezzi.add(i, 0);
        }
    }

    @Override
    public void resolve(int posizioneIniziale, String mossa, int pezzo, int giocatore) {
        if (posizioneIniziale == posizione && mossa.equals("Posizionamento"))
            pezzi.setElementAt(1, pezzo);
    }

    @Override
    public Double getFeature(int pezzo) {
        return pezzi.elementAt(pezzo).doubleValue();
    }

}
