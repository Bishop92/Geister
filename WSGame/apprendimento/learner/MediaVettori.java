package apprendimento.learner;

import apprendimento.features.FeatureCollector;
import apprendimento.LogPartita;

import java.util.Vector;

public class MediaVettori extends Learner {

    public MediaVettori(FeatureCollector featureCollector) {
        super("mediaV", featureCollector);
    }

    /**
     * Determina il profilo medio dei pezzi buoni o cattivi
     */
    @Override
    protected StringBuilder buildProfilo(Vector<LogPartita> partite) {
        //calcolo quante partite ho gia giocato
        int partite_giocate = partite.size();

        //se non ho giocato nessuna partita, ritorno null
        Vector<Double> media_buoni;
        Vector<Double> media_cattivi;

        //creo un vettore in cui 'fondere' tutti i vettori del profilo dei buoni
        Vector<Double> risultato_b = new Vector<Double>();
        //creo un vettore in cui 'fondere' tutti i vettori del profilo dei cattivi
        Vector<Double> risultato_r = new Vector<Double>();

        //inizializzo il vettore con un numero di elementi neutri (0) pari al numero di regole
        //fissate nel profilo
        for (int indice = 0; indice < featureCollector.getNumFeatures(); indice++) {
            risultato_b.add((double) 0);
            risultato_r.add((double) 0);
        }

        //conto totale dei vettori, su cui fare la media dei buoni
        int tot_vettori_b = 0;
        //conto totale dei vettori, su cui fare la media dei cattivi
        int tot_vettori_r = 0;

        //scorro tutte le partite presenti nel file di log
        for (int partita = 0; partita < partite_giocate; partita++) {
            FeatureCollector.FeaturePezzi features = getFeatures(partite.elementAt(partita));

            for (Vector<Double> vettore : features.getVettoriPezzi()) {
                for (int indice = 1; indice < featureCollector.getNumFeatures(); indice++) {
                    //Se e un pezzo buono
                    if (vettore.elementAt(0) < 4) {
                        Double nuovo_valore = vettore.elementAt(indice);
                        nuovo_valore = nuovo_valore + risultato_b.get(indice);
                        risultato_b.setElementAt(nuovo_valore, indice);
                        if (indice == 16)
                            tot_vettori_b++;
                    }
                    //Se e un pezzo cattivo
                    if (vettore.elementAt(0) > 3) {
                        Double nuovo_valore = vettore.elementAt(indice);
                        nuovo_valore = nuovo_valore + risultato_r.get(indice);
                        risultato_r.setElementAt(nuovo_valore, indice);
                        if (indice == 16)
                            tot_vettori_r++;
                    }
                }
            }
        }

        //divido ogni elemento del risultato per il numero totale di vettori
        for (int indice = 0; indice < risultato_b.size() && indice < risultato_r.size(); indice++) {
            //creo il nuovo valore
            Double nuovo_valore = risultato_b.get(indice) / tot_vettori_b;
            //inserisco il nuovo valore al posto di quello vecchio
            risultato_b.setElementAt(nuovo_valore, indice);
            //faccio lo stesso per i cattivi
            nuovo_valore = risultato_r.get(indice) / tot_vettori_r;
            risultato_r.setElementAt(nuovo_valore, indice);
        }
        media_buoni = risultato_b;
        media_cattivi = risultato_r;

        StringBuilder profilo = new StringBuilder();
        return profilo.append("b").append(media_buoni).append("r").append(media_cattivi).append("::");
    }
}