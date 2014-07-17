package logica;

/**
 * Created by Stefano on 15/07/2014.
 */
public class Mossa {
    private Coordinata da = null;
    private Coordinata a = null;

    public Mossa(Coordinata par, Coordinata arr) {
        da = par;
        a = arr;
    }

    public Coordinata getPartenza() {
        return da;
    }

    public Coordinata getArrivo() {
        return a;
    }
}
