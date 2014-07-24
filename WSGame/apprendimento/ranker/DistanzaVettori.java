package apprendimento.ranker;

import apprendimento.PezzoNascosto;

import java.util.Vector;

/**
 * Created by Stefano on 16/07/2014.
 */
/**
 * Determina la bonta di un pezzo confrontando la distanza che c'e tra il vettore del profilo del pezzo
 * e i vettori di riferimento passati come parametri
 */
public class DistanzaVettori implements Ranker {
    /**
     * Metodo ad un parametro che permette di determinare la distanza che c'e tra due vettori
     *
     * @param diRiferimento vettore del quale si vuole calcolare la distanza rispetto al vettore del profilo
     * @return Il valore rappresentante la distanza tra i due vettori
     */
    private double distanzaTraVettori(Vector<Double> features, Vector<Double> diRiferimento) {
        double distanza = 0;
        //scorro tutti i valori del vettore da confrontare
        for (int i = 0; i < features.size(); ++i) {
            double distanza_parziale = diRiferimento.get(i) - features.get(i);
            //aggiungo alla distanza totale, il valore assoluto della distanza parziale
            distanza = distanza + Math.abs(distanza_parziale);
        }
        return distanza;
    }

    @Override
    public double getBonta(PezzoNascosto pezzo, Vector<Double> vettoreBuoni, Vector<Double> vettoreCattivi, double livello) {
        //determino la distanza che c'e' tra il vettore buono e cattivo
        double distanzaBuono = distanzaTraVettori(pezzo.getFeatures(), vettoreBuoni);
        double distanzaCattivo = distanzaTraVettori(pezzo.getFeatures(), vettoreCattivi);
        //imposto la variabile bonta in relazione alle distanze appena calcolate
        double bonta_teorica = (distanzaBuono - distanzaCattivo) / (distanzaCattivo + distanzaBuono);
        // se il livello == 0 non c'e rumore nell'apprendimento la bonta e quella teorica calcolata con l'algoritmo di apprendimento
        if (livello == 0.0)
            return bonta_teorica;
            // se livello > 0 allora alla bonta_teorica va aggiunto un rumore che sara maggiore con l'aumentare del livello
        else {
            // valore random compreso tra -1 e 1
            double random = 2 * Math.random() - 1;
            // ritorna il valore random cosi trovato
            return (livello * random) + ((1 - livello) * bonta_teorica);
        }
    }
}
