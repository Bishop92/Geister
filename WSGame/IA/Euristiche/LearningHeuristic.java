package IA.euristiche;

/**
 * Created by Stefano on 24/07/2014.
 */

/**
 * L'interfaccia permette di aggiungere nuove euristiche che apprendono, rendendo quindi necessaria
 * la fase di apprendimento per adattare la previsione con l'esito della partita
 */
public interface LearningHeuristic extends Euristica {

    /**
     * Avvia l'apprendimento dai dati memorizzati durante la partita
     * @param partita La chiave univoca che identifica la partita
     * @param esito L'esito della partita dove 1 rappresenta la vittoria del computer e 0 la sconfitta
     */
    public void learn(String partita, double esito);
}
