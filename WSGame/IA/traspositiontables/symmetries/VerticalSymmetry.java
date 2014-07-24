package IA.traspositiontables.symmetries;

/**
 * Created by Stefano on 24/07/2014.
 */
public class VerticalSymmetry implements Symmetry {

    @Override
    public String transform(String key) {
        String transformedKey = "";
        for(int i = 0; i < key.length(); ++i)
            transformedKey += key.charAt(6 * (i / 6 + 1) - i % 6 - 1);
        return transformedKey;
    }
}
