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
     * @param pezzo           Il pezzo di cui si vuole conoscere la bonta
     * @param vettore_buoni   Il profilo dei pezzi buoni
     * @param vettore_cattivi Il profilo dei pezzi cattivi
     * @param livello         Il livello della partita
     * @return La bonta del pezzo
     */
    public double getBonta(PezzoNascosto pezzo, Vector<Double> vettore_buoni, Vector<Double> vettore_cattivi, double livello);
}
