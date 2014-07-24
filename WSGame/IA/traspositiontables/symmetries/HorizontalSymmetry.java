package IA.traspositiontables.symmetries;

/**
 * Created by Stefano on 24/07/2014.
 */
public class HorizontalSymmetry implements Symmetry {

    @Override
    public String transform(String key) {
        String transformedKey = "";
        for(int i = 0; i < key.length(); ++i)
            transformedKey += key.charAt(key.length() - i - 1);
        return transformedKey;
    }
}
