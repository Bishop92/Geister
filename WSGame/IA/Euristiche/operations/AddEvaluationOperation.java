package IA.euristiche.operations;

/**
 * Created by Stefano on 09/08/2014.
 */

import IA.euristiche.Euristica;
import IA.euristiche.LearningHeuristic;
import logica.Tavolo;

/**
 * Aggiunge la valutazione del tavolo alle valutazioni del training set
 */
public class AddEvaluationOperation implements HeuristicOperation {

    /**
     * La chiave univoca che identifica la partita
     */
    private String partita;

    /**
     * Il tavolo da valutare
     */
    private Tavolo tavolo;

    /**
     * Il giocatore a cui spetta il turno
     */
    private byte giocatore;

    /**
     * @param p La chiave univoca che identifica la partita
     * @param g Il giocatore a cui spetta il turno
     * @param t Il tavolo da valutare
     */
    public AddEvaluationOperation(String p, byte g, Tavolo t) {
        partita = p;
        giocatore = g;
        tavolo = t;
    }

    @Override
    public void doHeuristicOperation(Euristica euristica) {
    }

    @Override
    public void doLearningHeuristicOperation(LearningHeuristic euristica) {
        euristica.addValutazioneAlTrainingSet(partita, giocatore, tavolo);
    }
}
