package IA.traspositiontables.symmetries;

/**
 * Created by Stefano on 24/07/2014.
 */
public interface Symmetry {

    /**
     * Tranforma la chiave secondo la simmetria selezionata
     *
     * @param key La chiave da trasformare
     * @return La chiave trasformata
     */
    public String transform(String key);
}
