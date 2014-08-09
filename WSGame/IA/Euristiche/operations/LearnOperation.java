package IA.euristiche.operations;

/**
 * Created by Stefano on 09/08/2014.
 */

import IA.euristiche.Euristica;
import IA.euristiche.LearningHeuristic;
import IA.euristiche.operations.HeuristicOperation;

/**
 * Avvia l'apprendimento dai dati memorizzati durante la partita
 */
public class LearnOperation implements HeuristicOperation {

    /**
     * La chiave univoca che identifica la partita
     */
    private String partita;

    /**
     * L'esito della partita dove 1 rappresenta la vittoria del computer e 0 la sconfitta
     */
    private double esito;

    /**
     * @param p La chiave univoca che identifica la partita
     * @param e L'esito della partita dove 1 rappresenta la vittoria del computer e 0 la sconfitta
     */
    public LearnOperation(String p, double e) {
        partita = p;
        esito = e;
    }

    @Override
    public void doHeuristicOperation(Euristica euristica) {}

    @Override
    public void doLearningHeuristicOperation(LearningHeuristic euristica) {
        euristica.learn(partita, esito);
    }
}
