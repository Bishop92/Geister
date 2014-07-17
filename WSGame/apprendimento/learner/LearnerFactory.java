package apprendimento.learner;

import apprendimento.features.FeatureCollector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefano on 15/07/2014.
 */
public class LearnerFactory {

    public enum LEARNER{MEDIAVETTORI}

    private static LearnerFactory instance = null;
    private Map<LEARNER, Learner> learners = new HashMap<LEARNER, Learner>();

    private LearnerFactory() {
        FeatureCollector featureCollector = new FeatureCollector();
        learners.put(LEARNER.MEDIAVETTORI, new MediaVettori(featureCollector));
    }

    public static LearnerFactory getInstance() {
        synchronized (LearnerFactory.class) {
            if (instance == null)
                instance = new LearnerFactory();
        }
        return instance;
    }

    /**
     * Fornisce l'algoritmo di profilazione richiesto
     * @param learner LEARNER L'algoritmo di profilazione richiesto
     * @return L'algoritmo di profilazione richiesto
     */
    public Learner getLearner(LEARNER learner) {
        return learners.get(learner);
    }

    /**
     * Fornisce le euristiche esistenti
     * @return Le euristiche esistenti
     */
    public Collection<Learner> getLearners() {
        return learners.values();
    }
}
