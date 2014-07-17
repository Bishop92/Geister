package apprendimento.features;

/**
 * Created by Stefano on 16/07/2014.
 */

import java.util.Vector;

/**
 * Classe per mantere le informazioni relative al tavolo
 */
class Controllore {

    private Vector<Boolean> pezziViviG1, pezziViviG2;
    private Vector<String> posizioniPezziG1, posizioniPezziG2;

    public Controllore(Vector<Boolean> pViviG1, Vector<Boolean> pViviG2, Vector<String> pPezziG1, Vector<String> pPezziG2) {
        pezziViviG1 = pViviG1;
        pezziViviG2 = pViviG2;
        posizioniPezziG1 = pPezziG1;
        posizioniPezziG2 = pPezziG2;
    }

    /**
     * Controlla se la posizione e minacciata
     *
     * @param posizione La posizione da controllare
     * @param giocatore Il giocatore a cui spetta il turno
     * @return True se la posizione e minacciata, false altrimenti
     */
    public boolean minacciaPos(String posizione, int giocatore) {
        int pezzo_avv;
        int pos = Integer.parseInt(posizione);
        boolean minaccia = false;

        for (int i = 0; i < 8; i++) {
            if (giocatore == 1)
                pezzo_avv = Integer.parseInt(posizioniPezziG1.elementAt(i));
            else
                pezzo_avv = Integer.parseInt(posizioniPezziG2.elementAt(i));

            if (isVivo(i, giocatore)) {
                if (pezzo_avv + 10 == pos || pezzo_avv - 10 == pos || pezzo_avv + 1 == pos || pezzo_avv - 1 == pos) {
                    minaccia = true;
                }
            }
        }
        return minaccia;
    }

    /**
     * Controlla se la mossa comporta l'eliminazione di un pezzo, nel caso uccide il pezzo
     *
     * @param mossa     La mossa da controllare
     * @param giocatore Il giocatore che possiede il pezzo
     * @return True se un pezzo viene magiato, false altrimenti
     */
    public boolean mangia(String mossa, int giocatore) {
        boolean flag = false;
        if (posizioniPezziG1.contains(mossa.substring(3, 5)))
            flag = true;
        if (posizioniPezziG2.contains(mossa.substring(3, 5)))
            flag = true;
        boolean result = (mossa.charAt(2) == '-' && flag) || mossa.charAt(2) != '-';
        if (result)
            uccidi(trovaUcciso(mossa.substring(3, 5)), giocatore);
        return result;
    }

    /**
     * Individua quale pezzo e stato ucciso durante la mossa
     * @param mossa La La mossa da controllare
     * @return Il pezzo ucciso
     */
    private int trovaUcciso(String mossa) {
        int pezzo = -1;
        for (int j = 0; j < 8; j++) {
            if ((isVivo(j, 1) && posizioniPezziG1.elementAt(j).equals(mossa)) ||
                    ((isVivo(j, 2) && posizioniPezziG2.elementAt(j).equals(mossa))))
                pezzo = j;
        }
        return pezzo;
    }

    /**
     * Controlla se il pezzo del giocatore e vivo
     *
     * @param pezzo     Il pezzo da controllare
     * @param giocatore Il giocatore che possiede il pezzo
     * @return True se il pezzo e vivo, false altrimenti
     */
    public boolean isVivo(int pezzo, int giocatore) {
        if (giocatore == 1)
            return pezziViviG1.elementAt(pezzo);
        return pezziViviG2.elementAt(pezzo);
    }

    /**
     * Controlla se il pezzo e minacciato
     *
     * @param pezzo     Il pezzo Il pezzo da controllare
     * @param giocatore Il Il giocatore che possiede il pezzo
     * @return True se il pezzo e minacciato, false altrimenti
     */
    public boolean minacciato(int pezzo, int giocatore) {
        int pos_pezzo;
        int pezzo_avv;

        int avv = 1;
        if (giocatore == 1)
            avv = 2;

        boolean minaccia = false;

        if (giocatore == 1)
            pos_pezzo = Integer.parseInt(posizioniPezziG1.elementAt(pezzo));
        else
            pos_pezzo = Integer.parseInt(posizioniPezziG2.elementAt(pezzo));

        for (int i = 0; i < 8; i++) {
            if (avv == 2)
                pezzo_avv = Integer.parseInt(posizioniPezziG2.elementAt(i));
            else
                pezzo_avv = Integer.parseInt(posizioniPezziG1.elementAt(i));

            if (isVivo(i, avv) && pezzo_avv + 10 == pos_pezzo || pezzo_avv - 10 == pos_pezzo ||
                    pezzo_avv + 1 == pos_pezzo || pezzo_avv - 1 == pos_pezzo)
                minaccia = true;
        }
        return minaccia;
    }

    /**
     * Uccide il relativo pezzo del giocatore
     *
     * @param pezzo     Il pezzo da uccidere
     * @param giocatore Il giocatore che possiede il pezzo
     */
    private void uccidi(int pezzo, int giocatore) {
        if (giocatore == 1)
            pezziViviG1.setElementAt(false, pezzo);
        else
            pezziViviG2.setElementAt(false, pezzo);
    }
}
