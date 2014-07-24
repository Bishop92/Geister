/*
 **********************************************************************
 **********************************************************************
 **  _______   _______   __   _______   _______  _______    ______   **
 **  | _____|  | _____|  | |  | _____|  |__ __|  | _____|  | _____|  **
 **  | |	   | |       | |  | |         | |    | |       | |  | |  **
 **  | | ___   | |__     | |  | |____     | |    | |__     | |__| |  **
 **  | ||_  |  |  __|    | |  |_____ |    | |    |  __|    |    __|  **
 **  | |  | |  | |       | |       | |    | |    | |       | |\ \    **
 **  | |__| |  | |____   | |   ____| |    | |    | |____   | | \ \   **
 **  |______|  |______|  |_|  |______|    |_|    |______|  |_|  \_\  **
 **															         **
 **********************************************************************
 **********************************************************************
 * 
 * Autore: Mazzarelli Ivan
 * Data: 05/12/2007
*/

package apprendimento;

import logica.*;

import java.util.Vector;

/**
 * Questa classe ha lo scopo di rappresentare i pezzi avversari di cui non si conosce l'effettiva bonta',
 * &nbsp; ma solo la probabilita' che un pezzo sia buono o cattivo.<p>&nbsp;</p>
 * <p>&nbsp;</p>
 * <p><u><i>Elenco versioni:</i></u> </p>
 * <p><i>ver. 1.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/11/2007 </i></p>
 * <ul>
 * <li>aggiunto metodo aggiungiNonta </li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 15/11/2007 </i></p>
 * <ul>
 * <li>aggiunto metodo clone
 * </li>
 * <li>aggiunto metodo distanzaTraVettori </li>
 * <li>aggiunto metodo impostaBonta </li>
 * <li>costruttore modificato
 * </li>
 * </ul>
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 11/11/2007 </i></p>
 * <ul>
 * <li>bozza </li>
 * </ul>
 *
 * @author Mazzarelli Ivan
 * @version 1.1 del 18/11/2007
 */
public class PezzoNascosto extends Pezzo implements Cloneable {
    /**
     * Rappresenta il features del pezzo
     */
    private Vector<Double> features = new Vector<Double>();
    /**
     * Indica il grado di bonta che un pezzo puo avere. Tale valore varia da -1 (indicante i pezzi buoni)
     * a+1 (indicante i pezzi cattivi). Piu il valore si avvicina a 0, minore sara la sicurezza di
     * identificare correttamente la bonta del pezzo
     */
    private double bonta = 0;

    /**
     * Costruttore a due parametri che permette di inizializzare il pezzoNascosto
     *
     * @param p      pezzo che si vuole trasformare in pezzoNascosto
     * @param tavolo tavolo su cui si vuole inserire il pezzoNascosto
     */
    public PezzoNascosto(Pezzo p, Pezzo[][] tavolo) {
        //costruisco il pezzo
        super(p.getCoordinata(), p.getGiocatore(), p.getNumero(), tavolo);
    }

    /**
     * Fornisce la bonta del pezzo
     *
     * @return La bonta del pezzo
     */
    public double getBonta() {
        return bonta;
    }

    /**
     * Imposta la bonta del pezzo
     *
     * @param b La bonta del pezzo
     */
    public void setBonta(double b) {
        bonta = b;
    }

    /**
     * Imposta le feature del pezzo
     *
     * @param p Le feature del pezzo
     */
    public void setFeatures(Vector<Double> f) {
        features = f;
    }

    /**
     * Fornisce le features del pezzo
     *
     * @return Le features del pezzo
     */
    public Vector<Double> getFeatures() {
        return features;
    }

    /**
     * Metodo ad un parametro che permette di incrementare la bonta di un pezzo del valore passato
     * nel parametro
     *
     * @param valore valore da aggiungere alla bonta del pezzo
     */
    public void aggiungiBonta(double valore) {
        bonta = bonta + valore;
        //controllo che la bonta' sia rimasta compresa tra -1 e 1
        if (bonta < -1)
            bonta = -1;
        if (bonta > 1)
            bonta = 1;
    }

    /**
     * Metodo senza parametri che permette di effettuare una copia profonda dell'oggetto di invocazione.
     * Questo metodo concretizza l'interfaccia Clonable, e proprio per questo motivo, l'oggetto ritornato è di tipo Object.
     *
     * @return L'oggetto rappresentante la copia del pezzo su cui è stato
     * richiamato il metodo.
     */
    public Object clone() {
        PezzoNascosto p = (PezzoNascosto) super.clone();
        p.cor = (Coordinata) this.cor.clone();
        p.giocatore = this.giocatore;
        p.numero = this.numero;
        //creo un vettore temporaneo dove copiare il vettore mosse_fattibili
        Vector<Coordinata> vettore_temporaneo1 = new Vector<Coordinata>();
        //copio il vettore mosse_fattibili nel vettore_temporaneo1
        for (Coordinata mossa : mosse_fattibili) {
            Coordinata coordinata_temporanea = (Coordinata) mossa.clone();
            vettore_temporaneo1.addElement(coordinata_temporanea);
        }
        //copio il vettore temporaneo nel nuovo oggetto
        p.mosse_fattibili = vettore_temporaneo1;
        //creo un vettore temporaneo dove copiare il vettore coordinate_pezzi_mangiabili
        Vector<Coordinata> vettore_temporaneo2 = new Vector<Coordinata>();
        //copio il vettore coordinate_pezzi_mangiabili nel vettore_temporaneo2
        for (Coordinata pezzo : coordinate_pezzi_mangiabili) {
            Coordinata coordinata_temporanea = (Coordinata) pezzo.clone();
            vettore_temporaneo2.addElement(coordinata_temporanea);
        }
        //copio il vettore temporaneo nel nuovo oggetto
        p.coordinate_pezzi_mangiabili = vettore_temporaneo2;
        //copio il vettore del features
        Vector<Double> profilo_temporaneo = new Vector<Double>();
        for (double valore : features)
            profilo_temporaneo.addElement(valore);

        //copio il features temporaneo nel features dell'oggetto copiato
        p.features = profilo_temporaneo;
        //ritorno l'oggetto appena creato
        return p;
    }

    /**
     * Indica se il pezzo e buono o cattivo
     *
     * @return true se l'IA crede che sia buono, false se crede che sia cattivo
     */
    public boolean isBuono() {
        return bonta <= 0;
    }

    /**
     * Fornisce il tipo effettivo del pezzo, senza considerare il parametro di bonta
     *
     * @return true se il pezzo e buono, false altrimenti
     */
    public boolean isReallyBuono() {
        return super.isBuono();
    }
}
