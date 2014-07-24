package IA.traspositiontables.symmetries;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefano on 15/07/2014.
 */
public class SymmetryFactory {

    public enum SYMMETRIES{HORIZONTAL, VERTICAL, VERTICALHORIZONTAL}

    private static SymmetryFactory instance = new SymmetryFactory();
    private Map<SYMMETRIES, Symmetry> symmetries = new HashMap<>();

    private SymmetryFactory() {
        symmetries.put(SYMMETRIES.HORIZONTAL, new HorizontalSymmetry());
        symmetries.put(SYMMETRIES.VERTICAL, new VerticalSymmetry());
        symmetries.put(SYMMETRIES.VERTICALHORIZONTAL, new VerticalHorizontalSymmetry());
    }

    public static SymmetryFactory getInstance() {
        return instance;
    }

    /**
     * Fornisce la simmetria richiesta
     * @param symmetry SYMMETRIES La simmetria richiesta
     * @return L'oggetto corrispondente alla simmetria richiesta
     */
    public Symmetry getSymmetry(SYMMETRIES symmetry) {
        return symmetries.get(symmetry);
    }

    /**
     * Fornisce le simmetrie esistenti
     * @return Le simmetrie esistenti
     */
    public Collection<Symmetry> getSymmetries() {
        return symmetries.values();
    }
}
