package IA.Euristiche;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefano on 15/07/2014.
 */
public class EuristicheFactory {

    public enum EURISTICHE{ATTACCOAIBUONI, BUONIINGIOCO, BUONIMANGIATI, BUONISOTTOMINACCIA, CATTIVIINGIOCO, CATTIVIMANGIATI,
        DISTANZABUONIUSCITA, DISTANZABUONIUSCITAAVVERSARIO}

    private static EuristicheFactory instance = null;
    private Map<EURISTICHE, Euristica> euristiche = new HashMap<EURISTICHE, Euristica>();

    private EuristicheFactory() {
        euristiche.put(EURISTICHE.ATTACCOAIBUONI, new AttaccoAiBuoni());
        euristiche.put(EURISTICHE.BUONIINGIOCO, new BuoniInGioco());
        euristiche.put(EURISTICHE.BUONIMANGIATI, new BuoniMangiati());
        euristiche.put(EURISTICHE.BUONISOTTOMINACCIA, new BuoniSottoMinaccia());
        euristiche.put(EURISTICHE.CATTIVIINGIOCO, new CattiviInGioco());
        euristiche.put(EURISTICHE.CATTIVIMANGIATI, new CattiviMangiati());
        euristiche.put(EURISTICHE.DISTANZABUONIUSCITA, new DistanzaBuoniUscita());
        euristiche.put(EURISTICHE.DISTANZABUONIUSCITAAVVERSARIO, new DistanzaBuoniUscitaAvversario());
    }

    public static EuristicheFactory getInstance() {
        synchronized (EuristicheFactory.class) {
            if (instance == null)
                instance = new EuristicheFactory();
        }
        return instance;
    }

    /**
     * Fornisce l'euristica richiesta
     * @param euristica EURISTICHE Euristica richiesta
     * @return L'oggetto corrispondente all'euristica richiesta
     */
    public Euristica getEuristica(EURISTICHE euristica) {
        return euristiche.get(euristica);
    }

    /**
     * Fornisce le euristiche esistenti
     * @return Le euristiche esistenti
     */
    public Collection<Euristica> getEuristiche() {
        return euristiche.values();
    }
}
