package IA.euristiche;

/**
 * Created by Stefano on 24/07/2014.
 */
import IA.euristiche.operations.HeuristicOperation;
import logica.Tavolo;

/**
 * L'interfaccia permette di aggiungere nuove euristiche che apprendono, rendendo quindi necessaria
 * la fase di apprendimento per adattare la previsione con l'esito della partita
 */
public abstract class LearningHeuristic extends Euristica {

    /**
     * Avvia l'apprendimento dai dati memorizzati durante la partita
     * @param partita La chiave univoca che identifica la partita
     * @param esito L'esito della partita dove 1 rappresenta la vittoria del computer e 0 la sconfitta
     */
    public abstract void learn(String partita, double esito);

    /**
     * Aggiunge la valutazione del tavolo alle valutazioni del training set
     *
     * @param partita   La chiave univoca che identifica la partita
     * @param giocatore Il giocatore a cui spetta il turno
     * @param tavolo    Il tavolo da valutare
     */
    public abstract void addValutazioneAlTrainingSet(String partita, byte giocatore, Tavolo tavolo);

    @Override
    public void doOperation(HeuristicOperation heuristicOperation) {
        heuristicOperation.doLearningHeuristicOperation(this);
    }
}
