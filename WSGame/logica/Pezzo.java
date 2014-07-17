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

package logica;

import java.util.Vector;

/**
 * <p>Questa classe ha lo scopo di definire tutte le azioni che i pezzi possono
 * fare.</p>
 * <p>&nbsp;</p>
 * <p>&nbsp;</p>
 * <p><i><u>Elenco versini:</u></i></p>
 * <p><i>ver. 1.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 1/11/2007
 * </i></p>
 * <ul>
 * <li>modificato il metodo getBuono</li>
 * <li>eliminato campo dati buono</li>
 * <li>modificato il costruttore</li>
 * <li>modificato il metodo equals</li>
 * <li>modificato il metodo clone</li>
 * <li>aggiunto costruttore ad un parametro</li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 22/10/2007
 * </i></p>
 * <ul>
 * <li>aggiunto il metodo equals </li>
 * </ul>
 * <p><i>ver. 0.3&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 21/10/2007
 * </i></p>
 * <ul>
 * <li>aggiunto metodo getMosseFattibili </li>
 * <li>modifica del metodo getBuono </li>
 * <li>implementata la funzione clone </li>
 * <li>implementata la funzione ricalcolaMosseFattibili </li>
 * <li>implementata la funzione setCoordinata </li>
 * </ul>
 * <p><i>ver. 0.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 19/10/2007
 * </i></p>
 * <ul>
 * <li>modifica campi dati
 * </li>
 * </ul>
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/10/2007
 * </i></p>
 * <ul>
 * <li>bozza iniziale
 * </li>
 * </ul>
 *
 * @author Mazzarelli Ivan
 * @version 1.1 del 1/11/2007
 * @see Coordinata
 * @see Giocatore
 */
public class Pezzo implements Cloneable {
    /**
     * indica la coordinata del pezzo
     */
    protected Coordinata cor;
    /**
     * indica a quel dei due giocatori appartiene il pezzo (1=giocatore 1, 2=giocatore 2)
     */
    protected byte giocatore;
    /**
     * rappresenta ogni pezzo in modo univoco.<p>
     * i valori che puo' assumere questa variabile sono:<p>
     * 0..3 = pezzi buoni giocatore 1;
     * 4..7 = pezzi cattivi giocatore 1
     * 10..13 = pezzi buoni giocatore 2
     * 14..17 = pezzi cattivi giocatore 2
     */
    protected byte numero;
    /**
     * vettore di Coordinate, contenente tutte le coordinate delle mosse
     * fattibili che può effettuare un pezzo
     */
    protected Vector<Coordinata> mosse_fattibili = new Vector<Coordinata>();
    /**
     * vettore di Coordinate, contenente tutte le coordinate delle mosse
     * in cui il pezzo mosso, ne mangia un'alto
     */
    protected Vector<Coordinata> coordinate_pezzi_mangiabili = new Vector<Coordinata>();

    /**
     * Costruttore a quattro parametri che inizializza un pezzo e ne determina tutte
     * le mosse legali
     *
     * @param c      Coordinata in cui si trova i pezzo
     * @param gioc   giocatore a cui appartiene il pezzo
     * @param num    indca il numero del pezzo
     * @param tavolo matrice logica che rappresenta la scacchiera in cui verra inserito il pezzo
     */
    public Pezzo(Coordinata c, byte gioc, byte num, Pezzo[][] tavolo) {
        cor = c;
        giocatore = gioc;
        numero = num;
        calcolaMosseFattibili(tavolo);
    }

    /**
     * Costruttore ad un parametro che inizializza un pezzo a partire da un pezzo passato come parametro
     *
     * @param vecchio Pezzo dal quale si vogliono prendere i parametri necessari per inizializzare un
     *                nuovo pezzo
     */
    public Pezzo(Pezzo vecchio) {
        cor = vecchio.getCoordinata();
        giocatore = vecchio.getGiocatore();
        numero = vecchio.getNumero();
        mosse_fattibili = vecchio.mosse_fattibili;
        coordinate_pezzi_mangiabili = vecchio.coordinate_pezzi_mangiabili;
    }

    /**
     * metodo senza parametri che ritorna il numero del pezzo
     *
     * @return byte - numero del pezzo
     */
    public byte getNumero() {
        return numero;
    }

    /**
     * Metodo senza parametri per determinare a chi appartiene il pezzo
     *
     * @return byte - giocatore a cui appartiene il pezzo
     */
    public byte getGiocatore() {
        return giocatore;
    }

    /**
     * Metodo senza parametri che ritorna la coordinata in cui e' posizionato il pezzo
     *
     * @return Coordinata coordinata in cui e' posizionato il pezzo
     */
    public Coordinata getCoordinata() {
        return cor;
    }

    /**
     * metodo ad un parametro che setta la coordinata di un pezzo
     *
     * @param c coordinata da assegnare al pezzo
     */
    public void setCoordinata(Coordinata c) {
        cor = c;
    }

    /**
     * metodo senza parametri che determina se il pezzo e' buono o cattivo
     *
     * @return boolean - indica se il pezzo e' buono o cattivo
     */
    public boolean isBuono() {
        return numero % 10 >= 0 && numero % 10 < 4;
    }

    /**
     * Metodo senza parametri che ritorna il vettore delle mosse fattibili che il pezzo
     * puo' compiere
     *
     * @return Vector<Coordinata> vettore contenente tutte le mosse legali che il pezzo puo' fare
     */
    public Vector<Coordinata> getMosseFattibili() {
        return mosse_fattibili;
    }

    /**
     * Metodo con un parametro che calcola tutte le sue mosse legai del pezzo
     *
     * @param tav matrice logica rappresentante il tavolo su cui e' posizionato il pezzo
     */
    private void calcolaMosseFattibili(Pezzo[][] tav) {
        //controllo se può andare in alto
        if (cor.getRiga() < 5) {
            Coordinata su = new Coordinata((byte) (cor.getRiga() + 1), cor.getColonna());
            //controllo se la casella in alto è vuota
            if (tav[su.getRiga()][su.getColonna()] == null) {
                mosse_fattibili.addElement(su);
            } else { //controllo se nella casella in alto c'è un pezzo avversario
                if (tav[su.getRiga()][su.getColonna()].getGiocatore() != giocatore) {
                    mosse_fattibili.addElement(su);
                    coordinate_pezzi_mangiabili.addElement(su);
                }
                //se c'è un mio pezzo, non posso muovermi in quella casella e non faccio niente
            }
        }
        //controllo se può andare in basso
        if (cor.getRiga() > 0) {
            Coordinata giu = new Coordinata((byte) (cor.getRiga() - 1), cor.getColonna());
            //controllo se la casella in basso è vuota
            if (tav[giu.getRiga()][giu.getColonna()] == null) {
                mosse_fattibili.addElement(giu);
            } else { //controllo se nella casella in basso c'è un pezzo avversario
                if (tav[giu.getRiga()][giu.getColonna()].getGiocatore() != giocatore) {
                    mosse_fattibili.addElement(giu);
                    coordinate_pezzi_mangiabili.addElement(giu);
                }
                //se c'è un mio pezzo, non posso muovermi in quella casella e non faccio niente
            }
        }


        //controllo se può andare a destra
        if (cor.getColonna() < 5) {
            Coordinata destra = new Coordinata(cor.getRiga(), (byte) (cor.getColonna() + 1));
            //controllo se la casella a destra è vuota
            if (tav[destra.getRiga()][destra.getColonna()] == null) {
                mosse_fattibili.addElement(destra);
            } else { //controllo se nella casella a destra c'è un pezzo avversario
                if (tav[destra.getRiga()][destra.getColonna()].getGiocatore() != giocatore) {
                    mosse_fattibili.addElement(destra);
                    coordinate_pezzi_mangiabili.addElement(destra);
                }
                //se c'è un mio pezzo, non posso muovermi in quella casella e non faccio niente
            }
        }


        //controllo se può andare a sinistra
        if (cor.getColonna() > 0) {
            Coordinata sinistra = new Coordinata(cor.getRiga(), (byte) (cor.getColonna() - 1));
            //controllo se la casella a sinistra è vuota
            if (tav[sinistra.getRiga()][sinistra.getColonna()] == null) {
                mosse_fattibili.addElement(sinistra);
            } else { //controllo se nella casella a sinistra c'è un pezzo avversario
                if (tav[sinistra.getRiga()][sinistra.getColonna()].getGiocatore() != giocatore) {
                    mosse_fattibili.addElement(sinistra);
                    coordinate_pezzi_mangiabili.addElement(sinistra);
                }
                //se c'è un mio pezzo, non posso muovermi in quella casella e non faccio niente
            }
        }
    }

    /**
     * Metodo ad un parametro che ricalcola le mosse fattibili che un pezzo puo' effettuare
     *
     * @param tav matrice logica rappresentante il tavolo su cui e' posizionato il pezzo
     */
    public void ricalcolaMosseFattibili(Pezzo[][] tav) {
        //elimino il contenuto dei vecchi vettori
        mosse_fattibili.removeAllElements();
        coordinate_pezzi_mangiabili.removeAllElements();
        //ricalcolo tutte le possibili mosse
        calcolaMosseFattibili(tav);
    }

    /**
     * Metodo senza parametri che ritorna il vettore delle mosse in cui il pezzo mangia un
     * fantasma avversario
     *
     * @return Vector<Coordinata> vettore contenente tutte le mosse in cui pezzo puo' mangiare
     * un fantasma avversario
     */
    public Vector<Coordinata> getCoordinatePezziMangiabili() {
        return coordinate_pezzi_mangiabili;
    }

    /**
     * Metodo con un parametro di tipo Object che permette di effettuare il confronto tra un oggetto di
     * tipo Pezzo ed un Object.
     *
     * @param o indica l'oggetto con il quale bisogna fare il confronto.
     * @return true se l'oggetto d'invocazione è uguale al parametro passato alla funzione,
     * false altrimenti.
     */
    public boolean equals(Object o) {
        //non eguaglio i due vettori in quanto, date le coordinate, i giocatore ed il numero,
        //i vettori generati devono essere necessariamente uguali
        if (o != null) {
            Pezzo p = (Pezzo) o;
            return this.cor == p.cor && this.giocatore == p.giocatore && this.numero == p.numero;
        }
        return false;
    }

    /**
     * Metodo senza parametri che permette di effettuare una copia profonda dell'oggetto
     * di invocazione.
     * Questo metodo concretizza l'interfaccia Clonable, e proprio per questo motivo,
     * l'oggetto ritornato è di tipo Object.
     *
     * @return ritorna un Object rappresentante la copia del pezzo su cui è stato
     * richiamato il metodo.
     */
    public Object clone() {
        try {
            Pezzo p = (Pezzo) super.clone();
            p.cor = (Coordinata) this.cor.clone();
            p.giocatore = this.giocatore;
            p.numero = this.numero;
            //creo un vettore temporaneo dove copiare il vettore mosse_fattibili
            Vector<Coordinata> vettore_temporaneo1 = new Vector<Coordinata>();
            //copio il vettore mosse_fattibili nel vettore_temporaneo1
            for (Coordinata aMosse_fattibili : mosse_fattibili) {
                Coordinata coordinata_temporanea = (Coordinata) aMosse_fattibili.clone();
                vettore_temporaneo1.addElement(coordinata_temporanea);
            }
            //copio il vettore temporaneo nel nuovo oggetto
            p.mosse_fattibili = vettore_temporaneo1;
            //creo un vettore temporaneo dove copiare il vettore coordinate_pezzi_mangiabili
            Vector<Coordinata> vettore_temporaneo2 = new Vector<Coordinata>();
            //copio il vettore coordinate_pezzi_mangiabili nel vettore_temporaneo2
            for (Coordinata aCoordinate_pezzi_mangiabili : coordinate_pezzi_mangiabili) {
                Coordinata coordinata_temporanea = (Coordinata) aCoordinate_pezzi_mangiabili.clone();
                vettore_temporaneo2.addElement(coordinata_temporanea);
            }
            //copio il vettore temporaneo nel nuovo oggetto
            p.coordinate_pezzi_mangiabili = vettore_temporaneo2;
            //ritorno l'oggetto appena creato
            return p;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

