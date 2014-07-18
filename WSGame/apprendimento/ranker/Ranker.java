package apprendimento.ranker;

import apprendimento.PezzoNascosto;

import java.util.Vector;

/**
 * Created by Stefano on 16/07/2014.
 */
public interface Ranker {

    /**
     * Fornisce la bonta del pezzo nascosto in base ai profili dei pezzi cattivi e buoni
     *
     * @param pezzo          Il pezzo di cui si vuole conoscere la bonta
     * @param vettoreBuoni   Il profilo dei pezzi buoni
     * @param vettoreCattivi Il profilo dei pezzi cattivi
     * @param livello        Il livello della partita
     * @return La bonta del pezzo
     */
    public double getBonta(PezzoNascosto pezzo, Vector<Double> vettoreBuoni, Vector<Double> vettoreCattivi, double livello);
}
