package apprendimento.ranker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefano on 15/07/2014.
 */
public class RankerFactory {

    public enum RANKERS{DISTANZAVETTORI}

    private static RankerFactory instance = null;
    private Map<RANKERS, Ranker> rankers = new HashMap<RANKERS, Ranker>();

    private RankerFactory() {
        rankers.put(RANKERS.DISTANZAVETTORI, new DistanzaVettori());
    }

    public static RankerFactory getInstance() {
        synchronized (RankerFactory.class) {
            if (instance == null)
                instance = new RankerFactory();
        }
        return instance;
    }

    /**
     * Fornisce l'algoritmo di valutazione richiesto
     * @param ranker L'algoritmo desiderato
     * @return L'oggetto corrispondente all'algoritmo di valutazione richiesto
     */
    public Ranker getRanker(RANKERS ranker) {
        return rankers.get(ranker);
    }

    /**
     * Fornisce gli algoritmi di valutazione esistenti
     * @return Gli algoritmi di valutazione esistenti
     */
    public Collection<Ranker> getRanker() {
        return rankers.values();
    }
}
