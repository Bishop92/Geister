package apprendimento.ranker;

import apprendimento.PezzoNascosto;
import logica.Pezzo;

import java.util.Vector;

/**
 * Created by Stefano on 23/07/2014.
 */

/**
 * Classe per simulare un'intelligenza artificiale che conosce perfettamente le tipologie delle pedine
 */
public class InformazionePerfetta implements Ranker {
    @Override
    public double getBonta(PezzoNascosto pezzo, Vector<Double> vettoreBuoni, Vector<Double> vettoreCattivi, double livello) {
        if(((Pezzo) pezzo).isBuono())
            return 1;
        return 0;
    }
}
