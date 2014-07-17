package apprendimento;

import apprendimento.learner.*;

/**
 * Classe per l'avvio di un server per l'esecuzione dell'apprendimento di profili
 */
class LearnerServer {

    public static void main(String[] args) {
        LearnerExecutor learnerExecutor = new LearnerExecutor();
        LearnerFactory learnerFactory = LearnerFactory.getInstance();
        for(Learner learner : learnerFactory.getLearners())
            learnerExecutor.aggiungiLearner(learner);
        learnerExecutor.execute();
    }
}
