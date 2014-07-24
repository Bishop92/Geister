package IA;

import IA.euristiche.EuristicheFactory;
import IA.strategie.StrategieFactory;
import apprendimento.ranker.RankerFactory;
import logica.Giocatore;
import logica.Tavolo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefano on 15/07/2014.
 */
public class IAFactory {

    private static IAFactory instance = new IAFactory();
    private Map<String, IntelligenzaArtificiale> ia = new HashMap<String, IntelligenzaArtificiale>();

    private IAFactory() {
    }

    public static IAFactory getInstance() {
        return instance;
    }

    /**
     * Fornisce l'intelligenza artificiale richiesta
     *
     * @param tavolo                   Il Tavolo
     * @param giocatoreCorrente        Il giocatore corrente
     * @param avversario               L'avversario
     * @param livelloGiocatoreCorrente Il livello del giocatore corrente (IA)
     * @param idPartita                La partita in corso
     * @param euristica                L'euristica impiegata per valutare il tavolo
     * @param strategia                La strategia per scelgiere le mosse
     * @param ranker                   Il ranker che effettuera la valutazione della tipologia dei pezzi
     * @return L'oggetto corrispondente all'intelligenza artificiale richiesta
     */
    public IntelligenzaArtificiale getIA(Tavolo tavolo, Giocatore giocatoreCorrente, Giocatore avversario, double livelloGiocatoreCorrente, String idPartita, EuristicheFactory.EURISTICHE euristica, StrategieFactory.STRATEGIE strategia, RankerFactory.RANKERS ranker) {
        IntelligenzaArtificiale intelligenzaArtificiale = ia.get(idPartita);
        if (intelligenzaArtificiale == null)
            intelligenzaArtificiale = new IntelligenzaArtificiale(tavolo, giocatoreCorrente, avversario, livelloGiocatoreCorrente, idPartita, euristica, strategia, ranker);
        return intelligenzaArtificiale;
    }

    /**
     * Elimina l'intelligenza artificiale richiesta
     *
     * @param idPartita L'identificativo della partita in corso
     */
    public void deleteIA(String idPartita, boolean esito) {
        ia.get(idPartita).terminaPartita();
        ia.remove(idPartita);
    }
}