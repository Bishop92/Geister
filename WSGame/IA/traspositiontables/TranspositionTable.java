package IA.traspositiontables;

import IA.euristiche.EuristicheFactory;
import IA.traspositiontables.symmetries.Symmetry;
import IA.traspositiontables.symmetries.SymmetryFactory;
import logica.Pezzo;
import logica.Tavolo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Stefano on 24/07/2014.
 */
public class TranspositionTable {

    private static HashMap<String, Euristiche> table = new HashMap<>();

    /**
     * Fornisce il codice identificativo del tavolo
     *
     * @param tavolo Il tavolo di cui si vuole ottenere il codice identificativo
     * @return Il codice identificativo
     */
    final String hash(Tavolo tavolo) {
        Pezzo[][] pezzi = tavolo.getBaseLogica();
        String hash = "";
        for (Pezzo[] row : pezzi)
            for (Pezzo pezzo : row) {
                if (pezzo == null)
                    hash += "0";
                else
                    hash += pezzo.getNumero() % 4;
            }

        String minimumKey = hash;

        for(Symmetry symmetry : SymmetryFactory.getInstance().getSymmetries()) {
            String key = symmetry.transform(hash);
            if(key.compareTo(minimumKey) < 0)
                minimumKey = key;
        }

        return minimumKey;
    }

    /**
     * Imposta la valutazione per il tavolo e l'euristica indicati
     *
     * @param tavolo      Il tavolo di cui si vuole memorizzare la valutazione
     * @param euristica   L'euristica associata alla valutazione
     * @param valutazione La valutazione del tavolo per l'euristica richiesta
     */
    public void addValutazione(Tavolo tavolo, EuristicheFactory.EURISTICHE euristica, double valutazione) {
        String key = hash(tavolo);
        Euristiche euristiche = getEuristiche(key);
        if (euristiche == null) {
            euristiche = new Euristiche();
            table.put(key, euristiche);
        }
        euristiche.setEuristica(euristica, valutazione);
    }

    /**
     * Fornisce la valutazione per il tavolo e l'euristica richiesti
     *
     * @param tavolo    Il tavolo di cui si vuole ottenere la valutazione
     * @param euristica L'euristica associata alla valutazione
     * @return La valutazione richiesta
     */
    public double getValutazione(Tavolo tavolo, EuristicheFactory.EURISTICHE euristica) {
        String key = hash(tavolo);
        Euristiche euristiche = getEuristiche(key);
        if (euristiche != null)
            return euristiche.getValutazione(euristica);
        return 0;
    }

    /**
     * Fornisce l'insieme delle euristiche associate alla chiave
     * @param key La chiave associata alle euristiche
     * @return Le euristiche richieste
     */
    private Euristiche getEuristiche(String key) {
        Vector<Symmetry> symmetries = new Vector<>(SymmetryFactory.getInstance().getSymmetries());
        Euristiche euristiche = table.get(key);
        for (int i = 0; euristiche == null && i < symmetries.size(); ++i)
            euristiche = table.get(symmetries.get(i).transform(key));
        return euristiche;
    }

    /**
     * Indica se è stata memorizzata la valutazione per il tavolo e l'euristica richiesti
     *
     * @param tavolo    Il tavolo di cui si vuole controllare se esiste la valutazione
     * @param euristica L'euristica associata alla valutazione
     * @return true se è presente la valutazione, false altrimenti
     */
    public boolean containsValutazione(Tavolo tavolo, EuristicheFactory.EURISTICHE euristica) {
        String key = hash(tavolo);
        Euristiche euristiche = table.get(key);
        return euristiche != null && euristiche.containsValutazione(euristica);
    }

    private class Euristiche {
        private HashMap<EuristicheFactory.EURISTICHE, Double> valutazioni = new HashMap<>();

        /**
         * Imposta la valutazione per l'euristica indicata
         *
         * @param euristica   L'euristica da aggiornare
         * @param valutazione La valutazione da inserire
         */
        public void setEuristica(EuristicheFactory.EURISTICHE euristica, Double valutazione) {
            valutazioni.put(euristica, valutazione);
        }

        /**
         * Fornisce la valutazione memorizzata per l'euristica richiesta
         *
         * @param euristica L'euristica relativa alla valutazione
         * @return La valutazione richiesta
         */
        public Double getValutazione(EuristicheFactory.EURISTICHE euristica) {
            return valutazioni.get(euristica);
        }

        /**
         * Indica se è stata memorizzata la valutazione per l'euristica richiesta
         *
         * @param euristica L'euristica associata alla valutazione
         * @return true se è presente la valutazione, false altrimenti
         */
        public boolean containsValutazione(EuristicheFactory.EURISTICHE euristica) {
            return valutazioni.containsKey(euristica);
        }
    }
}
