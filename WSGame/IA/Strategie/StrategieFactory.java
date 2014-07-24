package IA.strategie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefano on 15/07/2014.
 */
public class StrategieFactory {

    public enum STRATEGIE{RANDOM, MINMAXAB}

    private static StrategieFactory instance = new StrategieFactory();
    private Map<STRATEGIE, Strategia> strategie = new HashMap<>();

    private StrategieFactory() {
        strategie.put(STRATEGIE.RANDOM, new Strategia());
        strategie.put(STRATEGIE.MINMAXAB, new MinMaxAB());
    }

    public static StrategieFactory getInstance() {
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
