package IA.traspositiontables.symmetries;

/**
 * Created by Stefano on 24/07/2014.
 */
public class VerticalHorizontalSymmetry implements Symmetry {

    @Override
    public String transform(String key) {
        Symmetry vertical = SymmetryFactory.getInstance().getSymmetry(SymmetryFactory.SYMMETRIES.VERTICAL);
        Symmetry horizontal = SymmetryFactory.getInstance().getSymmetry(SymmetryFactory.SYMMETRIES.HORIZONTAL);
        return vertical.transform(horizontal.transform(key));
    }
}
