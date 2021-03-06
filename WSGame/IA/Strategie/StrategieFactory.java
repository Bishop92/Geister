package IA.strategie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefano on 15/07/2014.
 */
public class StrategieFactory {

    public enum STRATEGIE{RANDOM, MINMAXAB}

    private static StrategieFactory instance = null;
    private Map<STRATEGIE, Strategia> strategie = new HashMap<STRATEGIE, Strategia>();

    private StrategieFactory() {
        strategie.put(STRATEGIE.RANDOM, new Strategia());
        strategie.put(STRATEGIE.MINMAXAB, new MinMaxAB());
    }

    public static StrategieFactory getInstance() {
        synchronized (StrategieFactory.class) {
            if (instance == null)
                instance = new StrategieFactory();
        }
        return instance;
    }

    /**
     * Fornisce la strategia richiesta
     * @param strategia STRATEGIE La Strategia richiesta
     * @return L'oggetto corrispondente alla strategia richiesta
     */
    public Strategia getStrategia(STRATEGIE strategia) {
        return strategie.get(strategia);
    }

    /**
     * Fornisce le strategie esistenti
     * @return Le strategie esistenti
     */
    public Collection<Strategia> getStrategie() {
        return strategie.values();
    }
}
