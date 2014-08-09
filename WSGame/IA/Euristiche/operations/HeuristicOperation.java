package IA.euristiche.operations;

import IA.euristiche.Euristica;
import IA.euristiche.LearningHeuristic;

/**
 * Created by Stefano on 09/08/2014.
 */
public interface HeuristicOperation {

    /**
     * Esegue l'operazione per l'euristica data
     * @param euristica L'euristica su cui eseguire l'operazione
     */
    public void doHeuristicOperation(Euristica euristica);

    /**
     * Esegue l'operazione per la learning heuristic data
     * @param euristica La learning heuristic su cui eseguire l'operazione
     */
    public void doLearningHeuristicOperation(LearningHeuristic euristica);
}
