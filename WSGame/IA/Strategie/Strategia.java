package IA.Strategie;

import IA.Euristiche.Euristica;
import IA.Euristiche.EuristicheFactory;
import logica.Coordinata;
import logica.Giocatore;
import logica.Mossa;
import logica.Tavolo;

/**
 * Created by Stefano on 15/07/2014.
 */
public class Strategia {

    /**
     * Fornisce la mossa da effettuare
     * @param tavolo Tavolo Il tavolo di cui si vuole determinare la mossa
     * @param giocatore Giocatore che deve effettuare la mossa
     * @return La mossa da effettuare
     */
    public Mossa getMossa(Tavolo tavolo, Giocatore giocatore, EuristicheFactory.EURISTICHE euristica) {
        //identifico i pezzi buoni e cattivi del giocatore corrente
        byte buoni;
        byte cattivi;
        if (giocatore.getNumero() == 1) {
            buoni = 1;
            cattivi = 2;
        } else {
            buoni = 3;
            cattivi = 4;
        }

        Coordinata partenza = null, arrivo = null;

        //variabile booleana per determinare se ho trovato il pezzo da muovere
        boolean continua = true;
        //continuo a cercare il pezzo da muovere fin quando lo trovo
        while (continua) {
            // scelgo se muovere un pezzo buono o cattivo
            // (sono sicuro che ci sono sia pezzi buoni che cattivi, altrimenti il gioco sarebbe finito
            if ((int) (Math.random() * 2) == 0) { //muovo un pezzo buono
                //conto quanti pezzi buoni ha il giocatore corrente
                byte num_pezzi_buoni = (byte) tavolo.vettorePezzi(buoni).size();
                //scelgo quale pezzo muovere (tra 0 e num_pezzi_buoni - 1)
                byte pezzo_da_muovere = (byte) (Math.random() * (num_pezzi_buoni - 1));
                //conto quante mosse valide puo' fare il pezzo
                byte num_mosse_valide = (byte) tavolo.vettorePezzi(buoni).get(pezzo_da_muovere).getMosseFattibili().size();
                if (num_mosse_valide > 0) {
                    //scelgo la mossa che deve fare il pezzo (tra 0 e num_mosse_valide - 1)
                    byte mossa_da_fare = (byte) (Math.random() * (num_mosse_valide - 1));
                    //salvo la coordinata di partenza
                    partenza = tavolo.vettorePezzi(buoni).get(pezzo_da_muovere).getCoordinata();
                    //salvo la coordinata di arrivo
                    arrivo = tavolo.vettorePezzi(buoni).get(pezzo_da_muovere).getMosseFattibili().get(mossa_da_fare);
                    //blocco il ciclo while
                    continua = false;
                }
            } else { //muovo un pezzo cattivo
                //conto quanti pezzi cattivi ha il giocatore corrente
                byte num_pezzi_cattivi = (byte) tavolo.vettorePezzi(cattivi).size();
                //scelgo quale pezzo muovere (tra 0 e num_pezzi_cattivi - 1)
                byte pezzo_da_muovere = (byte) (Math.random() * (num_pezzi_cattivi - 1));
                //conto quante mosse valide puo' fare il pezzo
                byte num_mosse_valide = (byte) tavolo.vettorePezzi(cattivi).get(pezzo_da_muovere).getMosseFattibili().size();
                if (num_mosse_valide > 0) {
                    //scelgo la mossa che deve fare il pezzo (tra 0 e num_mosse_valide - 1)
                    byte mossa_da_fare = (byte) (Math.random() * (num_mosse_valide - 1));
                    //salvo la coordinata di partenza
                    partenza = tavolo.vettorePezzi(cattivi).get(pezzo_da_muovere).getCoordinata();
                    //salvo la coordinata di arrivo
                    arrivo = tavolo.vettorePezzi(cattivi).get(pezzo_da_muovere).getMosseFattibili().get(mossa_da_fare);
                    //blocco il ciclo while
                    continua = false;
                }
            }
        }
        return new Mossa(partenza, arrivo);
    }
}
