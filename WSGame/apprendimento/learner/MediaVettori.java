package apprendimento.learner;

import apprendimento.FeatureCollector;
import apprendimento.LogPartita;

import java.util.Vector;

public class MediaVettori extends Learner{

	private Vector<Double> media_buoni;
	private Vector<Double> media_cattivi;
	
	public MediaVettori(FeatureCollector fc){
		super("mediaV",fc);
	}
	
	public String getProfilo(Vector<LogPartita> partite){
		this.partite=partite;
		//this.giocatore=id_giocatore;
		mediaVettori();

		profilo=nome+":";
		profilo+="b"+media_buoni+"r"+media_cattivi+"::";
		
		return profilo;
	}
	
	/**metodo con un parametro che restituisce un vettore di double che rappresenta
	 * il profilo medio dei pezzi buoni o cattivi
	 * 
	 * @param buoni indica se il vettore che voglio calcolare, riguarda i pezzi buoni o cattivi
	 * 
	 * @return Vector<Double> profilo medio dei pezzi buoni/cattivi
	 */ 
	private void mediaVettori(){
		//calcolo quante partite ho gia' giocato
		int partite_giocate = partite.size();
		
		//se non ho giocato nessuna partita, ritorno null
		media_buoni=null;
		media_cattivi=null;
		
		//creo un vettore in cui 'fondere' tutti i vettori del profilo dei buoni
		Vector<Double> risultato_b = new Vector<Double>();
		//creo un vettore in cui 'fondere' tutti i vettori del profilo dei cattivi
		Vector<Double> risultato_r = new Vector<Double>();

		//inizializzo il vettore con un numero di elementi neutri (0) pari al numero di regole
		//fissate nel profilo
		for (int indice=0; indice<feature_collector.getNumFeatures(); indice++){
			risultato_b.add((double)0);
			risultato_r.add((double)0);
		}
		
		//conto totale dei vettori, su cui fare la media dei buoni
		int tot_vettori_b = 0;
		//conto totale dei vettori, su cui fare la media dei cattivi
		int tot_vettori_r = 0;
		
		//scorro tutte le partite presenti nel file di log
		for (int partita=0; partita<partite_giocate; partita++){
			FeatureCollector.Struttura features = getFeatures(partite.elementAt(partita));

			for(int vettori=0;vettori<features.getVettoriPezzi().size();vettori++){
				for (int indice=1; indice<feature_collector.getNumFeatures(); indice++){
					//Se è un pezzo buono
					if(features.getVettoriPezzi().elementAt(vettori)[0]<4){
						Double nuovo_valore = (double) features.getVettoriPezzi().elementAt(vettori)[indice];							
						nuovo_valore = nuovo_valore + risultato_b.get(indice);
						risultato_b.setElementAt(nuovo_valore, indice);
						if(indice==16)
							tot_vettori_b++;
					}
					//Se è un pezzo cattivo
					if(features.getVettoriPezzi().elementAt(vettori)[0]>3){
						Double nuovo_valore = (double) features.getVettoriPezzi().elementAt(vettori)[indice];
						nuovo_valore = nuovo_valore + risultato_r.get(indice);
						risultato_r.setElementAt(nuovo_valore, indice);
						if(indice==16)
							tot_vettori_r++;
					}
				}
			}
		}
		
		//divido ogni elemento del risultato per il numero totale di vettori
		for (int indice=0; indice<risultato_b.size() && indice<risultato_r.size(); indice++){
			//creo il nuovo valore
			Double nuovo_valore = risultato_b.get(indice) / tot_vettori_b;
			//inserisco il nuovo valore al posto di quello vecchio
			risultato_b.setElementAt(nuovo_valore, indice);
			//faccio lo stesso per i cattivi
			nuovo_valore = risultato_r.get(indice) / tot_vettori_r;
			risultato_r.setElementAt(nuovo_valore, indice);
		}
		media_buoni=risultato_b;
		media_cattivi=risultato_r;
	}
}