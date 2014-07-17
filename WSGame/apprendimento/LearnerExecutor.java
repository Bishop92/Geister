package apprendimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import apprendimento.learner.*;

public class LearnerExecutor {
	
	private Vector<Integer> giocatori;
	private Vector<String> log_profili;
	
	private Vector<Learner> learner_scelti;
	
	/*
	private FeatureCollector fc;
	private Vector<LogPartita> partite;
	private Vector<Double> media_buoni;
	private Vector<Double> media_cattivi;
	*/
	
	/**
	 * Costruttore che salva all'interno di un file il profilo del giocatore o lo crea se non esiste
	 * 
	 * @param id: identificativo del giocatore
	 */
	public LearnerExecutor(){
		giocatori=new Vector<Integer>();
		log_profili=new Vector<String>();
		learner_scelti=new Vector<Learner>();
		/*
		partite=new GestisceLogPartita(giocatore).getPartite();
		learner_scelti=learner;
		media_buoni=mediaVettori(true);
		media_cattivi=mediaVettori(false);
		*/
		
		//V. GestisceFileProfilo
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost/sql81876_4";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement cmd = con.createStatement();
			String query = "SELECT * FROM giocatori";
			ResultSet res = cmd.executeQuery(query);
			while (res.next())
			{
				giocatori.add(res.getInt("id"));
				log_profili.add(res.getString("profilo"));
			}
			
			res.close(); // chiudere le risorse DB è obbligatorio
			cmd.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void execute(){
		int giocatore;
		Learner learner_corr;
		Vector<LogPartita> partite;
		//Scorro i giocatori
		for(int gioc=0;gioc<giocatori.size();gioc++){
			String log_profilo="";
			giocatore=giocatori.elementAt(gioc);
			log_profilo=log_profili.elementAt(gioc);
			partite=new GestisceLogPartita(giocatore).getPartite();
			//svuotaProfilo(giocatore);
			//Scorro i learner da eseguire
			if(partite.size()>0){
				for(int learner_corrente=0;learner_corrente<learner_scelti.size();learner_corrente++){
					learner_corr=learner_scelti.elementAt(learner_corrente);
					String nome=learner_corr.getNome();
					
					learner_corr.addGiocatore(giocatore);
					//int dim_nome = nome.length();
					int pos_algoritmo = log_profilo.indexOf(nome);
					String profilo=learner_corr.getProfilo(partite);
					StringBuffer temp_log = new StringBuffer(log_profilo);
					//Controllo se è già stato salvato un profilo per questo algoritmo
					if(pos_algoritmo == -1){
						//è la prima volta che si salva il profilo per questo algoritmo
						temp_log.append("\n"+profilo);
					}
					else{
						//il profilo va aggiornato
						int pos_fine=log_profilo.indexOf("::", pos_algoritmo);
						temp_log.replace(pos_algoritmo, pos_fine+2, profilo);
					}
					log_profilo = temp_log.toString();
					
					salvaProfilo(giocatore,log_profilo);
				}
			}
			System.out.println("GIOCATORE = "+giocatore+"; PROFILO = "+log_profilo);
		}
	}
	
	/*
	private FeatureCollector.Struttura getFeatures(LogPartita partita){
		FeatureCollector fc = new FeatureCollector(giocatore, partita);
		return fc.getOutput();
	}
	*/
	
	private void svuotaProfilo(int giocatore){
		salvaProfilo(giocatore,"");
	}
	
	
	/**metodo con un parametro che restituisce un vettore di double che rappresenta
	 * il profilo medio dei pezzi buoni o cattivi
	 * 
	 * @param buoni indica se il vettore che voglio calcolare, riguarda i pezzi buoni o cattivi
	 * 
	 * @return Vector<Double> profilo medio dei pezzi buoni/cattivi
	 */ 
	/*
	private Vector<Double> mediaVettori(boolean buoni){
		//calcolo quante partite ho gia' giocato
		int partite_giocate = partite.size();
		
		//se non ho giocato nessuna partita, ritorno null
		if (partite_giocate == 0)
			return null;
		
		//creo un vettore in cui 'fondere' tutti i vettori del profilo
		Vector<Double> risultato = new Vector<Double>();
		//conto totale dei vettori, su cui fare la media
		int tot_vettori = 0;
		
		//scorro tutte le partite presenti nel file di log
		for (int partita=0; partita<partite_giocate; partita++){
			FeatureCollector.Struttura features = getFeatures(partite.elementAt(partita));
			
			//inizializzo il vettore con un numero di elementi neutri (0) pari al numero di regole
			//fissate nel profilo
			for (int indice=0; indice<features.getTotFeatures(); indice++){
				risultato.add((double)0);
			}

			for(int vettori=0;vettori<features.getPezzi().size();vettori++){
				//scorro solo tra gli elementi con un valore (id pezzo) compreso tra 0 e 3 per i pezzi buoni
				//e tra 4 e 7 per i pezzi cattivi, all'indice 0 del vettore
				for (int indice=1; indice<features.getTotFeatures(); indice++){
					
					if(buoni){
						if(features.getPezzi().elementAt(vettori)[0]<4){
							Double nuovo_valore = (double) features.getPezzi().elementAt(vettori)[indice];							
							nuovo_valore = nuovo_valore + risultato.get(indice);
							risultato.setElementAt(nuovo_valore, indice);
							if(indice==16)
								tot_vettori++;
						}
					}
					else{
						if(features.getPezzi().elementAt(vettori)[0]>3){
							Double nuovo_valore = (double) features.getPezzi().elementAt(vettori)[indice];
							nuovo_valore = nuovo_valore + risultato.get(indice);
							risultato.setElementAt(nuovo_valore, indice);
							if(indice==16)
								tot_vettori++;
						}
					}
				}
			}
		}
		
		System.out.println(tot_vettori);
		//divido ogni elemento del risultato per il numero totale di partite
		for (int indice=0; indice<risultato.size(); indice++){
			//creo il nuovo valore
			Double nuovo_valore = risultato.get(indice) / tot_vettori;
			//inserisco il nuovo valore al posto di quello vecchio
			risultato.setElementAt(nuovo_valore, indice);
		}
		
		return risultato;
	}
	*/
	
	private void salvaProfilo(int giocatore, String profilo){
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost/sql81876_4";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement cmd = con.createStatement();
			String query = "UPDATE  `giocatori` SET  `profilo` = '"+profilo+"' WHERE  `id` ="+giocatore+";";
			cmd.executeUpdate(query);
			cmd.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	public Vector<Double> getBuoni(){
		return media_buoni;
	}
	
	public Vector<Double> getCattivi(){
		return media_cattivi;
	}
	*/
	
	public void aggiungiLearner(Learner learner){
		learner_scelti.add(learner);
	}
	
	public String getLearners(){
		String nomi="Learner presenti: ";
		for(int i=0;i<learner_scelti.size();i++){
			nomi+=learner_scelti.elementAt(i).getNome();
			if(i<learner_scelti.size()-1)
				nomi+=", ";
			else
				nomi+=".";
		}
		return nomi;
	}
}
