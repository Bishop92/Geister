package apprendimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import logica.Coordinata;
import logica.GestisceFile;
import logica.Giocatore;
import logica.Partita;
import logica.Pezzo;
import logica.Tavolo;
import apprendimento.FeatureCollector.Struttura;
import apprendimento.learner.Learner;
/**
 * Dato un pezzo, chiede la bontà rispetto ad un algoritmo
 * <p>&nbsp;
 * ChangeLog:
 * LS:Cambiato costruttore, invece di Partita, passo tavolo direttamente.
 * </p>
 * 
 * 
 * @author  Appon Luca
 * @author Luca Semenzato
 * 
 * 
 * @version 2.0 del 02/01/2012
 */

public class Ranker {

	/** rappresenta il profilo che i pezzi buoni posseggono*/
	private Vector<Double> profilo_buoni = null;
	/** rappresenta il profilo che i pezzi cattivi posseggono*/
	private Vector<Double> profilo_cattivi = null;
	
	/** indica il tavolo sul quale si e' attivata l'intelligenza artificiale*/
	private Tavolo tav;
	/** indica il giocatore che ha richiesto l'attivazione dell'intelligenza artificiale*/
	Giocatore giocatore_corrente;
	/** indica il giocatore del quale si vuole prevedere la bonta' dei pezzi */
	Giocatore avversario;
	/**Features collector usato per il ranker*/
	private FeatureCollector fc;
	/**Indica il livello dell'avversario umano. Arriva dalla chiamata alla classe IntelligenzaArtificiale*/
	private double livelloAvversario;
	/**nome della Partita*/
	private String nomePartita;
	/**nome del Ranker, deve combaciare con quello usato nella fase di learning*/
	private String nome;
	/**nome del Learner. Di default viene scelto il primo possibile associato al ranker*/
	private String nomeLearner;
	
	
        /** Costruttore a 5 parametri che inizializza il profilo
         * 
         * @param p è la partita in questione
         * @param gioc_corr Ã¨ il giocatore corrente
         * @param avv è l'avversario di cui si vuole tracciare il profilo dei suoi pezzi
         * @param livAvv è il livello dell'avversario umano
         * @param featuresCollector features usate per l'analisi del profilo giocatore
         * @param nomePar nome della Partita
         */
        public Ranker(Tavolo t, Giocatore gioc_corr, Giocatore avv,double livAvv, FeatureCollector featuresCollector,String nomePar){
		tav = t;
		giocatore_corrente = gioc_corr;
		avversario = avv;
		livelloAvversario=livAvv;
		fc=featuresCollector;
		nomePartita=nomePar;
		
		
		//setNomeLearner("MediaV"); //<--- usarlo per forzare il nome ad un particolare learner associato
		
		//nome=getNomeRanker(nomeLearner); //Ranker usato
		nome=getNomeRanker(gioc_corr);
		nomeLearner=getNomeLearner(nome); //il learner associato a questo ranker e del quale l'utente deve avere un profilo
		System.out.println("nomeRanker: " +nome);
		profilo_buoni = ottieniProfilo(true);
		profilo_cattivi = ottieniProfilo(false);
	}
        /**
         * Forza il settaggio del nome del Learner associato a questo Ranker.
         * @param String nome esatto del Learner da usare
         */
        private void setNomeLearner(String nome_learner)
        {
        	nomeLearner=nome_learner;
        }
        /**
         * Forza il settaggio del nome del Ranker da usare.
         * @param String nome esatto del Ranker da usare
         */
        private void setNomeRanker(String nome_ranker)
        {
        	nome=nome_ranker;
        }
        /**
         * Recupera il nome del Learner associato a questo Ranker.
         * I Learner possono essere più d'uno, di default prende il primo.<br>
         * Se non è presente alcun learner, prova con MediaV<br>
         * Se si desidera forzare l'uso di un learner specifico, usare setNomeLearner(...)
         * @return String nome del Learner associato.
         * */
        private String getNomeLearner(String nomeRanker)
        {
        	String nL="mediaV";
        	try
    		{
    			String driver = "com.mysql.jdbc.Driver";
    			Class.forName(driver);
    			String url = "jdbc:mysql://localhost:3306/geister";
    			Connection con = DriverManager.getConnection(url, "root", "sportster");
    			Statement cmd = con.createStatement();
    			String query = "SELECT learners.nome FROM profili_u_l_r "+
    							" INNER JOIN utenti ON profili_u_l_r.id_utente=utenti.id "+
    							" INNER JOIN learners_rankers ON profili_u_l_r.id_learner_ranker=learners_rankers.id "+
    							" INNER JOIN learners ON learners_rankers.id_learner=learners.id "+ 
    							" INNER JOIN rankers ON learners_rankers.id_ranker=rankers.id "+
    							" WHERE utenti.username LIKE '"+avversario.getNome()+"' " +
    							" AND rankers.nome LIKE '"+nomeRanker+"' order by profili_u_l_r.id;";
    			
    			System.out.println("******** QUERY PER *********"+query);
    			ResultSet res = cmd.executeQuery(query);
    			if (res.next())
    			{
    				nL=res.getString(1);
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
        	return nL;
        }
        /**
         * resituisce il nome del ranker in base al learner scelto, sempre associato all'utente,<br>
         *  a meno che non si forzi la chiamate con setNome....
         *  @param nomeLearner nome del learner desiderato
         *  @return String nome del raner associato, per quell'utente
         *  */
        private String getNomeRanker(String nome_learner)
        {
        	String nR="rankerMV";
        	try
    		{
    			String driver = "com.mysql.jdbc.Driver";
    			Class.forName(driver);
    			String url = "jdbc:mysql://localhost:3306/geister";
    			Connection con = DriverManager.getConnection(url, "root", "sportster");
    			Statement cmd = con.createStatement();
    			String query = "SELECT rankers.nome FROM profili_u_l_r "+
    							" INNER JOIN utenti ON profili_u_l_r.id_utente=utenti.id "+
    							" INNER JOIN learners_rankers ON profili_u_l_r.id_learner_ranker=learners_rankers.id "+
    							" INNER JOIN learners ON learners_rankers.id_learner=learners.id "+ 
    							" INNER JOIN rankers ON learners_rankers.id_ranker=rankers.id "+
    							" WHERE utenti.username LIKE '"+avversario.getNome()+"'" +
    									"AND learners.nome like '"+nome_learner+"' order by profili_u_l_r.id;";
    			
    			System.out.println("******** QUERY PER *********"+query);
    			ResultSet res = cmd.executeQuery(query);
    			if (res.next())
    			{
    				nR=res.getString(1);
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
        	return nR;
        }
        /**
         * resituisce il nome del ranker in base all'utente IA ad esso associato nel database.
         *  
         *  @param nomeLearner nome del learner desiderato
         *  @return String nome del raner associato, per quell'utente
         *  */
        private String getNomeRanker(Giocatore ia_ranker)
        {
        	String nR="rankerMV"; //default
        	try
    		{
    			String driver = "com.mysql.jdbc.Driver";
    			Class.forName(driver);
    			String url = "jdbc:mysql://localhost:3306/geister";
    			Connection con = DriverManager.getConnection(url, "root", "sportster");
    			Statement cmd = con.createStatement();
    			String query = "SELECT rankers.nome FROM rankers "+
    							" INNER JOIN utenti ON rankers.id_IA=utenti.id "+
    							" WHERE utenti.username LIKE '"+giocatore_corrente.getNome()+"'" +
    									" order by rankers.id;";
    			
    			System.out.println("******** QUERY PER *********"+query);
    			ResultSet res = cmd.executeQuery(query);
    			if (res.next())
    			{
    				nR=res.getString(1);
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
        	return nR;
        }
        /** Ritorna il profilo dei pezzi buoni dell'avversario
         * 
         * @return
         */
       	public Vector<Double> getBuoni(){return profilo_buoni;}
        
        /** Ritorna il profilo dei pezzi cattivi dell'avversario
         * 
         * @return
         */     
        public Vector<Double> getCattivi(){return profilo_cattivi;}
        
        
        /** Metodo con un parametro che restituisce un vettore di double che rappresenta
	 * il profilo medio dei pezzi buoni o cattivi.
         * Dato il parametro booleano buono se è true crea il profilo dei pezzi buoni dell'avversario se false quello dei pezzo cattivi e lo ritorna
         * 
         * @param buono
         * @return il vettore dei pezzi buoni o cattivi
         */
	private Vector<Double> ottieniProfilo(boolean buono){
		Vector<Double> risultato = new Vector<Double>();
		String profilo="";
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/geister";
			Connection con = DriverManager.getConnection(url, "root", "sportster");
			Statement cmd = con.createStatement();
			String query = "SELECT profilo FROM profili_u_l_r "+
							" INNER JOIN utenti ON profili_u_l_r.id_utente=utenti.id "+
							" INNER JOIN learners_rankers ON profili_u_l_r.id_learner_ranker=learners_rankers.id "+
							" INNER JOIN learners ON learners_rankers.id_learner=learners.id "+ 
							" WHERE utenti.username LIKE '"+avversario.getNome()+"' AND " +
							" learners.nome like '"+nomeLearner+"';";
			
			System.out.println("******** QUERY PER *********"+query);
			ResultSet res = cmd.executeQuery(query);
			while (res.next())
			{
				profilo=res.getString("profilo");
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
		
		
		System.out.println("RANKER - OTTIENI PROFILO!!!!!");
		new RankerLog("Ottieni profilo");
		//se l'algoritmo scelto non è in profilo, esco
		if(profilo.indexOf(nomeLearner+":")==-1){
			System.out.println("*****RANKER.OTTIENIPROFILO ---> ALGO NON IN PROFILO*****");
			new RankerLog("ALGO NON IN PROFILO");
			return null;
		}
		
		int inizio=profilo.indexOf(nomeLearner+":")+nomeLearner.length()+1;
		
		int fine=profilo.indexOf("::", inizio);
		
		int inizio_r=profilo.indexOf("r",inizio);
		//+2 per evitare "r" e "[", -1 per evitare "]"
		String buoni=profilo.substring(inizio+2,inizio_r-1);
		String cattivi=profilo.substring(inizio_r+2,fine-1);

		String[] val_buoni = buoni.split(",");
		String[] val_cattivi = cattivi.split(",");
		for(int i=0;i<val_buoni.length;i++){
			if(buono)
				risultato.add(Double.parseDouble(val_buoni[i].trim()));
			else
				risultato.add(Double.parseDouble(val_cattivi[i].trim()));				
		}
		
		System.out.println("******* RANKER.OTTIENIPROFILO -----> PROFILO = "+risultato);
		new RankerLog("PROFILO="+risultato);
		return risultato;
	}
	
        /**
	 * Metodo senza parametri che permette di disabilitare l'intelligenza artificiale per evitare di prevedere 
	 * di che tipo sono i fantasmi avversari.
	 */
    public void disattivaProfilo(){
    	System.out.println("DISATTIVA PROFILO!OOO!OO!O!O!");
		tav.ripristinaTavolo(avversario.getNumero());
		tav.ripristinaDisposizionePezzi(avversario.getNumero());
	}
	
	/**
	 * Metodo senza parametri che permette di abilitare l'intelligenza artificiale per poter prevedere di che
	 * tipo sono i fantasmi avversari.
	 */
	public void aggiornaProfilo(){
		System.out.println("RANKER.AGGIORNAPROFILO*************");
		//reimposto i pezzi dell'avversario
		tav.reimpostaTavolo(avversario.getNumero());
		//se esiste un profilo aggiorno la bonta' dei pezzi e poi li ridistribuisco all'interno dei vettori
		if(profilo_buoni != null){
				System.out.println("AGGIORNO LE BONTA' DEI PEZZI DEL PROFILO");
			aggiornaBontaPezzi();
		}
		else{ //se non c'e' il profilo
			//dispongo correttamente i pezzi all'interno dei vettori
			tav.reimpostaDisposizionePezzi(avversario.getNumero());
		}
		System.out.println("RANKER Profilo aggiornato*************");
	}
	
        
	/**
	 * Metodo senza parametri che assegna ad ogni pezzo dell'avversario, il suo profilo.
	 */
	private void caricaProfiloNeiPezzi(){
		//salvo in una variabile il vettore di log della partita
		System.out.println(nomePartita);
		LogPartita logPartita = new LogPartita(nomePartita);
		
		Struttura output =fc.analizzaMosse(avversario.getNumero(), logPartita, 0); 
		
				//cambiato learner con chiamata diretta a features Collector 
				//algoritmo.getFeatures(logPartita);
		
		//Vector<String> log = par.getVettoreLog();
		
		//se sto controllando i pezzi del giocatore 1
		if (avversario.getNumero()==1){
			//scorro il vettore dei pezzi buoni del giocatore uno
			for (int indice=0; indice<tav.vettorePezzi((byte)1).size(); indice++){

				//memorizzo il numero del pezzo in esame
				byte num_pezzo = tav.vettorePezzi((byte)1).get(indice).getNumero();

				System.out.println("******************* CASO 0 !!!");
						
				//scorro l'output alla ricerca dell'ultimo vettore coi dati per quel pezzo
				int last_pezzo = 0;
				for(int pos=0;pos<output.getVettoriPezzi().size();pos++){
					System.out.println("SCORRO VETTORI OUTPUT... VETTORE CON ID = "+output.getIdPezzo(pos));
					if(output.getIdPezzo(pos)==num_pezzo){
						System.out.println(" OK PER POS = " + pos + " E PEZZO = "+num_pezzo);
						last_pezzo=pos;
					}
				}
				
				System.out.println("******************* CASO 1!!!");
				
				//memorizzo il vettore di quel pezzo, partendo dall'elemento 1 poichè in 0 si trova l'id del pezzo
				Vector<Double> profilo_pezzo = new Vector<Double>();
				for(int feat=1;output.getVettoriPezzi().size()>0 &&feat<output.getVettoriPezzi().elementAt(last_pezzo).length; feat++){
					profilo_pezzo.add((double)output.getVettoriPezzi().elementAt(last_pezzo)[feat]);
				}
				System.out.println(profilo_pezzo);
				//assegno al pezzo il vettore appena creato
				((PezzoNascosto)tav.vettorePezzi((byte)1).get(indice)).setVettore(profilo_pezzo);
			
				/*
				//determino il vettore del profilo ******posizione iniziale pezzo******
				Vector<Double> profilo_pezzo = disposizioneInizialeSingoloPezzo(num_pezzo);
				//controlo se i giocatori hanno fatto almeno un turno di gioco
				if (log.size()>=22){
					//controllo se ha effettuato la prima mossa
					profilo_pezzo.addElement(posizionePrimaMossaSingoloPezzo(num_pezzo));
					//controllo gli spostamenti che ha effettuato durante la partita
					double[] spostamenti = spostamentiNellaPartitaSingoloPezzo(num_pezzo);
					profilo_pezzo.addElement(spostamenti[0]);
					profilo_pezzo.addElement(spostamenti[1]);
					profilo_pezzo.addElement(spostamenti[2]);
					//controllo la dinamica del gioco
					double[] dinamica_di_gioco = dinamicaDiGiocoSingoloPezzo(num_pezzo);
					profilo_pezzo.addElement(dinamica_di_gioco[0]);
					profilo_pezzo.addElement(dinamica_di_gioco[1]);
					profilo_pezzo.addElement(dinamica_di_gioco[2]);
					profilo_pezzo.addElement(dinamica_di_gioco[3]);
				}
				//controlo se i giocatori hanno fatto almeno due turni di gioco
				if (log.size()>=24){
					//controllo se ha fatto la seconda mossa
					profilo_pezzo.addElement(posizioneSecondaMossaSingoloPezzo(num_pezzo));
				}
			*/
			}
			//scorro il vettore dei pezzi cattivi del giocatore uno
			for (int indice=0; indice<tav.vettorePezzi((byte)2).size(); indice++){
				
				//memorizzo il numero del pezzo in esame
				byte num_pezzo = tav.vettorePezzi((byte)2).get(indice).getNumero();
				
				//scorro l'output alla ricerca dell'ultimo vettore coi dati per quel pezzo
				int last_pezzo = 0;
				for(int pos=0;pos<output.getVettoriPezzi().size();pos++){
					if(output.getIdPezzo(pos)==num_pezzo)
						last_pezzo=pos;
				}

				System.out.println("******************* CASO 2!!!");
				System.out.println("Qui "+indice +" di "+tav.vettorePezzi((byte)2).size());
				//memorizzo il vettore di quel pezzo, partendo dall'elemento 1 poichè in 0 si trova l'id del pezzo
				Vector<Double> profilo_pezzo = new Vector<Double>();
				System.out.println("PEZZI CARICATI "+output.getVettoriPezzi().elementAt(last_pezzo).length);
				for(int feat=1;output.getVettoriPezzi().size()>0 &&feat<output.getVettoriPezzi().elementAt(last_pezzo).length; feat++){
					
					profilo_pezzo.add((double)output.getVettoriPezzi().elementAt(last_pezzo)[feat]);
				}
				//assegno al pezzo il vettore appena creato
				((PezzoNascosto)tav.vettorePezzi((byte)2).get(indice)).setVettore(profilo_pezzo);
				
				
				/*
				//controlo se i giocatori hanno fatto almeno un turno di gioco
				if (log.size()>=22){
					//controllo se ha effettuato la prima mossa
					profilo_pezzo.addElement(posizionePrimaMossaSingoloPezzo(num_pezzo));
					//controllo gli spostamenti che ha effettuato durante la partita
					double[] spostamenti = spostamentiNellaPartitaSingoloPezzo(num_pezzo);
					profilo_pezzo.addElement(spostamenti[0]);
					profilo_pezzo.addElement(spostamenti[1]);
					profilo_pezzo.addElement(spostamenti[2]);
					//controllo la dinamica del gioco
					double[] dinamica_di_gioco = dinamicaDiGiocoSingoloPezzo(num_pezzo);
					profilo_pezzo.addElement(dinamica_di_gioco[0]);
					profilo_pezzo.addElement(dinamica_di_gioco[1]);
					profilo_pezzo.addElement(dinamica_di_gioco[2]);
					profilo_pezzo.addElement(dinamica_di_gioco[3]);
				}
				//controlo se i giocatori hanno fatto almeno due turni di gioco
				if (log.size()>=24){
					//controllo se ha fatto la seconda mossa
					profilo_pezzo.addElement(posizioneSecondaMossaSingoloPezzo(num_pezzo));
				}
			*/
			}
		}
		else{ //giocatore == 2
			
			//scorro il vettore dei pezzi buoni del giocatore due
			for (int indice=0; indice<tav.vettorePezzi((byte)3).size(); indice++){
				
				//memorizzo il numero del pezzo in esame
				byte num_pezzo = tav.vettorePezzi((byte)3).get(indice).getNumero();
				
				//scorro l'output alla ricerca dell'ultimo vettore coi dati per quel pezzo
				int last_pezzo = 0;
				for(int pos=0;pos<output.getVettoriPezzi().size();pos++){
					if(output.getIdPezzo(pos)==num_pezzo)
						last_pezzo=pos;
				}

				System.out.println("******************* CASO 3!!!");
				//memorizzo il vettore di quel pezzo, partendo dall'elemento 1 poichè in 0 si trova l'id del pezzo
				Vector<Double> profilo_pezzo = new Vector<Double>();
				for(int feat=1;output.getVettoriPezzi().size()>0 && feat<output.getVettoriPezzi().elementAt(last_pezzo).length; feat++){
					profilo_pezzo.add((double)output.getVettoriPezzi().elementAt(last_pezzo)[feat]);
				}
				
				//assegno al pezzo il vettore appena creato
				((PezzoNascosto)tav.vettorePezzi((byte)3).get(indice)).setVettore(profilo_pezzo);
			
				/*
				//controlo se i giocatori hanno fatto almeno un turno di gioco  
				if (log.size()>=22){
					//controllo se ha effettuato la prima mossa
					profilo_pezzo.addElement(posizionePrimaMossaSingoloPezzo(num_pezzo));
					//controllo gli spostamenti che ha effettuato durante la partita
					double[] spostamenti = spostamentiNellaPartitaSingoloPezzo(num_pezzo);
					profilo_pezzo.addElement(spostamenti[0]);
					profilo_pezzo.addElement(spostamenti[1]);
					profilo_pezzo.addElement(spostamenti[2]);
					//controllo la dinamica del gioco
					double[] dinamica_di_gioco = dinamicaDiGiocoSingoloPezzo(num_pezzo);
					profilo_pezzo.addElement(dinamica_di_gioco[0]);
					profilo_pezzo.addElement(dinamica_di_gioco[1]);
					profilo_pezzo.addElement(dinamica_di_gioco[2]);
					profilo_pezzo.addElement(dinamica_di_gioco[3]);
				}
				//controlo se i giocatori hanno fatto almeno due turni di gioco
				if (log.size()>=24){
					//controllo se ha fatto la seconda mossa
					profilo_pezzo.addElement(posizioneSecondaMossaSingoloPezzo(num_pezzo));
				}
				
			*/
			}
			//scorro il vettore dei pezzi cattivi del giocatore due
			for (int indice=0; indice<tav.vettorePezzi((byte)4).size(); indice++){
				//memorizzo il numero del pezzo in esame
				byte num_pezzo = tav.vettorePezzi((byte)4).get(indice).getNumero();
				
				//scorro l'output alla ricerca dell'ultimo vettore coi dati per quel pezzo
				int last_pezzo = 0;
				for(int pos=0;pos<output.getVettoriPezzi().size();pos++){
					if(output.getIdPezzo(pos)==num_pezzo)
						last_pezzo=pos;
				}

				System.out.println("******************* CASO 4!!!");
				//memorizzo il vettore di quel pezzo, partendo dall'elemento 1 poichè in 0 si trova l'id del pezzo
				Vector<Double> profilo_pezzo = new Vector<Double>();
				for(int feat=1;output.getVettoriPezzi().size()>0 &&feat<output.getVettoriPezzi().elementAt(last_pezzo).length; feat++){
					profilo_pezzo.add((double)output.getVettoriPezzi().elementAt(last_pezzo)[feat]);
				}
				
				//assegno al pezzo il vettore appena creato
				((PezzoNascosto)tav.vettorePezzi((byte)4).get(indice)).setVettore(profilo_pezzo);
			
				/*
				//controlo se i giocatori hanno fatto almeno un turno di gioco
				if (log.size()>=22){
					//controllo se ha effettuato la prima mossa
					profilo_pezzo.addElement(posizionePrimaMossaSingoloPezzo(num_pezzo));
					//controllo gli spostamenti che ha effettuato durante la partita
					double[] spostamenti = spostamentiNellaPartitaSingoloPezzo(num_pezzo);
					profilo_pezzo.addElement(spostamenti[0]);
					profilo_pezzo.addElement(spostamenti[1]);
					profilo_pezzo.addElement(spostamenti[2]);
					//controllo la dinamica del gioco
					double[] dinamica_di_gioco = dinamicaDiGiocoSingoloPezzo(num_pezzo);
					profilo_pezzo.addElement(dinamica_di_gioco[0]);
					profilo_pezzo.addElement(dinamica_di_gioco[1]);
					profilo_pezzo.addElement(dinamica_di_gioco[2]);
					profilo_pezzo.addElement(dinamica_di_gioco[3]);
				}
				//controlo se i giocatori hanno fatto almeno due turni di gioco
				if (log.size()>=24){
					//controllo se ha fatto la seconda mossa
					profilo_pezzo.addElement(posizioneSecondaMossaSingoloPezzo(num_pezzo));
				}
			*/
			}
		}
		
	}

	/**
	 * Metodo ad un parametro che permette di generare un vettore di double contenente la disposizione
	 * iniziale del pezzo.
	 * 
	 * @param num_pezzo numero del pezzo del quale si vuole ottenere il profilo
	 * 
	 * @return Vector<Double> vettore contenente la disposizione iniziale del pezzo
	 */
	private Vector<Double> disposizioneInizialeSingoloPezzo(byte num_pezzo){
		//salvo in una variabile il vettore di log della partita
		LogPartita logPartita = new LogPartita(nomePartita);
		Vector<String> log = logPartita.getLog();
		//distinguo i vari casi di partenza
		byte caso = GestisceFileProfilo.determinaPosizionePartenza(log.get(0),avversario.getIdentificatore());
		//creo un vettore temporaneo che contienre il risultato di una partita
		Vector<Double> risultato_partita = new Vector<Double>();
		//distinguo i vari casi di partenza
		if ( caso == 1 ){
			//scorro tutte le posizioni
			for(int posizione=0; posizione<8; posizione++){
				//memorizzo il numero del pezzo
				byte num_pezzo_in_esame = GestisceFile.ottieniPezzo(log.get(2 + posizione));
				//controllo se il pezzo in esame e' quello che sto cercando
				if (num_pezzo_in_esame == num_pezzo){
					//aggiungo il valore al vettore dei risultati
					risultato_partita.add(new Double(1));
					//continuo il ciclo for
					continue;
				}
				else{ //non e' il pezzo che sto cercando
					//aggiungo il valore al vettore dei risultati
					risultato_partita.add(new Double(0));
					//continuo il ciclo
					continue;
				}
			}
		}
		else{ //caso == 2
			//scorro tutte le posizioni
			for(int posizione=15; posizione>7; posizione--){
				//memorizzo il numero del pezzo
				byte num_pezzo_in_esame = GestisceFile.ottieniPezzo(log.get(2 + posizione));
				//controllo se il pezzo in esame e' quello che sto cercando
				if (num_pezzo_in_esame == num_pezzo){
					//aggiungo il valore al vettore dei risultati
					risultato_partita.add(new Double(1));
					//continuo il ciclo for
					continue;
				}
				else{ //non e' il pezzo che sto cercando
					//aggiungo il valore al vettore dei risultati
					risultato_partita.add(new Double(0));
					//continuo il ciclo
					continue;
				}
			}
		}
		return risultato_partita;
	}
	
	/**
	 * Metodo ad un parametro che determina se un pezzo ha effettuato la prima mossa
	 * 
	 * @param num_pezzo pezzo del quale si vuole sapere se ha effettuato la prima mossa
	 * 
	 * @return Double indicante se il pezzo ha effettuato o meno la prima mossa (1 = si, 2 = no)
	 */
	private Double posizionePrimaMossaSingoloPezzo(byte num_pezzo){
		//salvo in una variabile il vettore di log della partita
		LogPartita logPartita = new LogPartita(nomePartita);
		Vector<String> log = logPartita.getLog();
		//vedo se ha iniziato il giocatore in esame
		byte caso = GestisceFileProfilo.determinaCasoPartenza(log.get(0),avversario.getIdentificatore());
		//determino qual'e' la posizione del primo pezzo mosso
		byte posizione = GestisceFile.ottieniPartenza(log.get(20+caso)).getPosizione();
		//determinto qual'Ã¨ il pezzo che si e' mosso per primo
		if (GestisceFileProfilo.determinaPosizionePartenza(log.get(0),avversario.getIdentificatore()) == 1){
			//memorizzo il numero del pezzo che ho mosso per primo
			byte pezzo_mosso = GestisceFile.ottieniPezzo(log.get(1+posizione));
			if (pezzo_mosso == num_pezzo)
				return new Double(1);
			else
				return new Double(0);
		}
		else{ //determinaPosizionePartenza == 2
			//memorizzo il numero del pezzo che ho mosso per primo
			byte pezzo_mosso = (byte) (GestisceFile.ottieniPezzo(log.get(18 - posizione)) - 10);
			if (pezzo_mosso == num_pezzo)
				return new Double(1);
			else
				return new Double(0);
		}
	}
	
	/**
	 * Metodo ad un parametro che determina se un pezzo ha effettuato la seconda mossa
	 * 
	 * @param num_pezzo pezzo del quale si vuole sapere se ha effettuato la seconda mossa
	 * 
	 * @return Double indicante se il pezzo ha effettuato o meno la seconda mossa (1 = si, 2 = no)
	 */
	private Double posizioneSecondaMossaSingoloPezzo(byte num_pezzo){
		//salvo in una variabile il vettore di log della partita
		LogPartita logPartita = new LogPartita(nomePartita);
		Vector<String> log = logPartita.getLog();
		//distinguo i vari casi di partenza
		byte caso = GestisceFileProfilo.determinaCasoPartenza(log.get(0),avversario.getIdentificatore());
		//determino qual'e' la posizione del secondo pezzo mosso
		byte posizione = GestisceFile.ottieniPartenza(log.get(22+caso)).getPosizione();
		//controllo se e' stato mosso lo stesso pezzo che e' stato spostato nella prima mossa
		if (posizione == -1){
			//memorizzo la posizione di partenza che aveva il primo pezzo mosso
			posizione = GestisceFile.ottieniPartenza(log.get(20+caso)).getPosizione();
		}
		//determinto qual'Ã¨ il pezzo che si e' mosso per secondo
		if (GestisceFileProfilo.determinaPosizionePartenza(log.get(0),avversario.getIdentificatore()) == 1){
			//memorizzo il numero del pezzo che ho mosso per secondo
			byte pezzo_mosso = GestisceFile.ottieniPezzo(log.get(1+posizione));
			//verifico se il pezzo in esame corrisponde al pezzo trovato nella ricerca
			if (pezzo_mosso == num_pezzo)
				return new Double(1);
			else
				return new Double(0);
		}
		else{ //determinaPosizionePartenza == 2
			//memorizzo il numero del pezzo che ho mosso per secondo
			byte pezzo_mosso = (byte) (GestisceFile.ottieniPezzo(log.get(18-posizione)) - 10);
			//verifico se il pezzo in esame corrisponde al pezzo trovato nella ricerca
			if (pezzo_mosso == num_pezzo)
				return new Double(1);
			else
				return new Double(0);
		}
	}
	
	/**
	 * Metodo senza parametri che aggiorna il coefficiente di bonta' di ogni pezzo avversario
	 */
	public void aggiornaBontaPezzi(){
		
		System.out.println("IA sempre in 2, avversario umano sempre in 1!!! LS");
		//aggiorno il profilo di ogni pezzo
		caricaProfiloNeiPezzi();
		
		
		//controllo se i pezzi da aggiornare sono del giocatore 1
		if (avversario.getNumero()==1){
//				System.out.print("imposto bontà pezzi con livello "+par.getLivelloG2());
			//scorro il vettore dei pezzi buoni del giocatore uno
			for (int indice=0; indice<tav.vettorePezzi((byte)1).size(); indice++){
				//aggiorno la bonta' del pezzo in esame
				((PezzoNascosto)tav.vettorePezzi((byte)1).get(indice)).impostaBonta(profilo_buoni, profilo_cattivi,livelloAvversario);
			}
			//scorro il vettore dei pezzi cattivi del giocatore uno
			for (int indice=0; indice<tav.vettorePezzi((byte)2).size(); indice++){
				//aggiorno la bonta' del pezzo in esame
				((PezzoNascosto)tav.vettorePezzi((byte)2).get(indice)).impostaBonta(profilo_buoni, profilo_cattivi,livelloAvversario);
			}
			tav.reimpostaDisposizionePezzi(avversario.getNumero());
//				System.out.println("AGGIORNA BONTA' PEZZI Giovatore 1: ");
//				System.out.println("BUONI: "+tav.vettorePezzi((byte)1).size());
//				System.out.println("CATTIVI: "+tav.vettorePezzi((byte)2).size());
		}
		else{ //giocatore == 2
//				System.out.print("imposto bontà pezzi con livello "+par.getLivelloG1());
			//scorro il vettore dei pezzi buoni del giocatore due
			for (int indice=0; indice<tav.vettorePezzi((byte)3).size(); indice++){
				//aggiorno la bonta' del pezzo in esame
				((PezzoNascosto)tav.vettorePezzi((byte)3).get(indice)).impostaBonta(profilo_buoni, profilo_cattivi,livelloAvversario);
			}
			//scorro il vettore dei pezzi cattivi del giocatore due
			for (int indice=0; indice<tav.vettorePezzi((byte)4).size(); indice++){
				//aggiorno la bonta' del pezzo in esame
				((PezzoNascosto)tav.vettorePezzi((byte)4).get(indice)).impostaBonta(profilo_buoni, profilo_cattivi,livelloAvversario);
			}
			tav.reimpostaDisposizionePezzi(avversario.getNumero());
//				System.out.println("AGGIORNA BONTA' PEZZI Giocatore 2: ");
//				System.out.println("BUONI: "+tav.vettorePezzi((byte)3).size());
//				System.out.println("CATTIVI: "+tav.vettorePezzi((byte)4).size());

		}
		//dispongo i pezzi nei giusti vettori di appartenenza (g1_pezzi_buoni, g1_pezzi_cattivi,
		//g2_pezzi_buoni, g2_pezzi_cattivi)
		
	
	}

	/**
	 * metodo ad un parametro che permette di generare un array di grandezza 3 che rappresenta il numero ed il tipo
	 * di spostamenti che ha fatto il singolo pezzo
	 * 
	 * @param num_pezzo rappresenta il numero del pezzo del quale si vuole estrapolare il profilo
	 * 
	 * @return array di dimensione 3 contenente il numero ed il tipo di spsotamenti che ha fatto il singolo pezzo
	 */
	private double[] spostamentiNellaPartitaSingoloPezzo(int num_pezzo){
		//salvo in una variabile il vettore di log della partita
		LogPartita logPartita = new LogPartita(nomePartita);
		Vector<String> log = logPartita.getLog();
		//memorizzo in che posizione e' partito
		byte posizione_giocatore = GestisceFileProfilo.determinaPosizionePartenza(log.get(0),avversario.getIdentificatore());
		//creo un array contenente i risultati della ricerca
		//la matrice avra' tre righe (avanza, retrocede, si sposta lateralmente)
		double[] risultato = new double[3];
		//distinguo i vari casi di partenza
		byte caso =  GestisceFileProfilo.determinaCasoPartenza(log.get(0),avversario.getIdentificatore());
		if (posizione_giocatore == 1){
			//scorro tutti i pezzi del giocatore
			for (int i=0; i<8; i++){
				//memorizzo il numero del pezzo che ho preso in esame
				byte num_pezzo_in_esame = GestisceFile.ottieniPezzo(log.get(2+i));
				//se il pezzo in esame non e' uguale al pezzo che devo considerare, continuo il ciclo for
				if (num_pezzo_in_esame != num_pezzo)
					continue;
				//memorizzo la coordinata presa in esame
				Coordinata cor_in_esame = GestisceFile.ottieniCoordinata(log.get(2+i));
				//memorizzo la linea del log che sto prendendo in esame
				int linea_in_esame = 20+caso;
				//scorro tutta la partita
				while (linea_in_esame < log.size()){
					//se la coordinata in esame e' uguale alla coordinata del pezzo
					//che sto muovendo, controllo in che direzione si e' spostato il pezzo
					if (cor_in_esame.equals(GestisceFile.ottieniPartenza(log.get(linea_in_esame)))){
						//vedo se il pezzo e' avanzato
						if (cor_in_esame.avanza(GestisceFile.ottieniArrivo(log.get(linea_in_esame)), posizione_giocatore)){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[0] = risultato[0]+1;
						}
						//vedo se il pezzo e' indietreggiato
						if (cor_in_esame.indietreggia(GestisceFile.ottieniArrivo(log.get(linea_in_esame)), posizione_giocatore)){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[1] = risultato[1]+1;
						}
						//vedo se il pezzo si e' mosso lateramente
						if (cor_in_esame.mossoLateralmente(GestisceFile.ottieniArrivo(log.get(linea_in_esame)))){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[2] = risultato[2]+1;
						}
						cor_in_esame = GestisceFile.ottieniArrivo(log.get(linea_in_esame));
						linea_in_esame = linea_in_esame + 2;										
					}
					else{ //la cordinata in esame e' diversa dalla coordinata del pezzo che sto muovendo
						linea_in_esame = linea_in_esame + 2;
					}
				}
			}
		}
		else{ //posizione_giocatore == 2
			//scorro tutti i pezzi del giocatore
			for (int i=0; i<8; i++){
				//memorizzo il numero del pezzo che ho preso in esame
				byte num_pezzo_in_esame = (byte)(GestisceFile.ottieniPezzo(log.get(17-i)) - 10);
				//se il pezzo in esame non e' uguale al pezzo che devo considerare, continuo il ciclo for
				if (num_pezzo_in_esame != num_pezzo)
					continue;
				//memorizzo la coordinata presa in esame
				Coordinata cor_in_esame = GestisceFile.ottieniCoordinata(log.get(17-i));
				//memorizzo la linea del log che sto prendendo in esame
				int linea_in_esame = 20+caso;
				//scorro tutta la partita
				while (linea_in_esame < log.size()){
					//se la coordinata in esame e' uguale alla coordinata del pezzo
					//che sto muovendo, controllo in che direzione si e' spostato il pezzo
					if (cor_in_esame.equals(GestisceFile.ottieniPartenza(log.get(linea_in_esame)))){
						//vedo se il pezzo e' avanzato
						if (cor_in_esame.avanza(GestisceFile.ottieniArrivo(log.get(linea_in_esame)), posizione_giocatore)){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[0] = risultato[0]+1;
						}
						//vedo se il pezzo e' indietreggiato
						if (cor_in_esame.indietreggia(GestisceFile.ottieniArrivo(log.get(linea_in_esame)), posizione_giocatore)){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[1] = risultato[1]+1;
						}
						//vedo se il pezzo si e' mosso lateramente
						if (cor_in_esame.mossoLateralmente(GestisceFile.ottieniArrivo(log.get(linea_in_esame)))){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[2] = risultato[2]+1;
						}
						cor_in_esame = GestisceFile.ottieniArrivo(log.get(linea_in_esame));
						linea_in_esame = linea_in_esame + 2;
					}
					else{ //la cordinata in esame e' diversa dalla coordinata del pezzo che sto muovendo
						linea_in_esame = linea_in_esame + 2;
					}
				}
			}
		}		
		return risultato;
	}

	/**
	 * metodo ad un parametro che permette di generare un array di grandezza 4 che rappresenta il tipo di azioni
	 * intraprese da un pezzo durante lo svolgimento di una partita
	 * 
	 * @param num_pezzo rappresenta il numero del pezzo del quale si vuole estrapolare il profilo
	 * 
	 * @return array di dimensione 4 contenente il numero ed il tipo di azioni intraprese dal pezzo durante
	 * lo svolgimento di una partita
	 */
	private double[] dinamicaDiGiocoSingoloPezzo(int num_pezzo){
		//salvo in una variabile il vettore di log della partita
		LogPartita logPartita = new LogPartita(nomePartita);
		Vector<String> log = logPartita.getLog();
		//vedo se ha iniziato il giocatore in esame
		byte caso = GestisceFileProfilo.determinaCasoPartenza(log.get(0),avversario.getIdentificatore());
		//memorizzo in che posizione e' partito il giocatore
		byte posizione_giocatore = GestisceFileProfilo.determinaPosizionePartenza(log.get(0),avversario.getIdentificatore());
		//creo un tavolo di gioco dove simulare la partita
		Tavolo tav = new Tavolo(generaTavolo());
		//creo la matrice dei pezzi del giocatore prima d'iniziare la partita
		GestisceFileProfilo.MatricePezzi matrice = new GestisceFileProfilo.MatricePezzi((Tavolo)tav.clone(), posizione_giocatore);
		//se la prima mossa spetta all'avversario, aggiorno la matrice dei pezzi
		if (caso == 1){
			//memorizzo la coordinata di partenza del pezzo avversario
			Coordinata da = GestisceFile.ottieniPartenza(log.get(20));
			//memorizzo la coordinata di arrivo del pezzo avversario
			Coordinata a = GestisceFile.ottieniArrivo(log.get(20));
			//eseguo la mossa sul tavolo
			tav.muoviPezzo(da, a);
			//aggiorno la matrice dei pezzi
			matrice = new GestisceFileProfilo.MatricePezzi((Tavolo)tav.clone(), posizione_giocatore);
		}
		//creo la matrice che conterra' il risultato
		// 4 sono le righe delle varie opzioni da tener conto nei pezzi:
		// riga 0: mangia se minacciato
		// riga 1: scappa se minacciato
		// riga 2: sta fermo se minacciato
		// riga 3: minaccia
		// 8 sono gli otto pezzi del giocatore
		double[] risultato = new double[4];
		//memorizzo la linea del log che sto prendendo in esame
		int linea_in_esame = 20 + caso;
		//memorizzo il numero di mosse eseguite
		boolean turno_avversario = false;
		//scorro tutta le mosse fatte durante la partita
		while (linea_in_esame < log.size()){
			//controllo di chi e' il turno
			if (turno_avversario){
				//memorizzo la coordinata di partenza del pezzo avversario
				Coordinata da = GestisceFile.ottieniPartenza(log.get(linea_in_esame));
				//memorizzo la coordinata di arrivo del pezzo avversario
				Coordinata a = GestisceFile.ottieniArrivo(log.get(linea_in_esame));
				//eseguo la mossa sul tavolo
				tav.muoviPezzo(da, a);
				//creo la nuova matrice dei pezzi
				GestisceFileProfilo.MatricePezzi nuova_matrice = new GestisceFileProfilo.MatricePezzi((Tavolo)tav.clone(), posizione_giocatore);
				//aggiorno la vecchia matrice dei pezzi
				matrice = nuova_matrice;
				//aggiorno il turno
				turno_avversario = false;
				//aggiorno la linea da prendere in considerazione
				linea_in_esame++;
				//vado al turno successivo
				continue;
			}
			//memorizzo la coordinata di partenza del mio pezzo
			Coordinata da = GestisceFile.ottieniPartenza(log.get(linea_in_esame));
			//memorizzo la coordinata di arrivo del mio pezzo
			Coordinata a = GestisceFile.ottieniArrivo(log.get(linea_in_esame));
			//eseguo la mossa sul tavolo
			tav.muoviPezzo(da, a);
			//creo la nuova matrice dei pezzi
			GestisceFileProfilo.MatricePezzi nuova_matrice = new GestisceFileProfilo.MatricePezzi((Tavolo)tav.clone(), posizione_giocatore);
			//distiunguo i due casi di partenza
			if (posizione_giocatore == 1){
				//scorro tutti i pezzi buoni
				for (int i=0; i<tav.vettorePezzi((byte)1).size(); i++){
					//ricavo il pezzo che ho mosso
					Pezzo pezzo_mosso = tav.vettorePezzi((byte)1).get(i);
					//estrapolo il numero del pezzo
					int num_pezzo_temp = pezzo_mosso.getNumero();
					//controllo che il numero del pezzo in esame corrisponda al numero del
					//pezzo passato nel parametro
					if (num_pezzo_temp != num_pezzo){
						//se non corrisponde, continuo la ricerca del pezzo desiderato
						continue;
					}
					//vedo se il pezzo soddisfa la carattaristica 'mangia se minacciato'
					if (matrice.mangiaSeMinacciato(pezzo_mosso)){
						risultato[0] = risultato[0] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'scappa se minacciato'
					if (matrice.scappaSeMinacciato(pezzo_mosso)){
						risultato[1] = risultato[1] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'rimane fermo se minacciato'
					if (matrice.fermoSeMinacciato(pezzo_mosso)){
						risultato[2] = risultato[2] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'minaccia pezzi avversari'
					if (matrice.minacciaPezzoAvversario(nuova_matrice, pezzo_mosso)){
						risultato[3] = risultato[3] + 1;
					}
				}
				//scorro tutti i pezzi cattivi
				for (int i=0; i<tav.vettorePezzi((byte)2).size(); i++){
					//ricavo il pezzo che ho mosso
					Pezzo pezzo_mosso = tav.vettorePezzi((byte)2).get(i);
					//estrapolo il numero del pezzo
					int num_pezzo_temp = pezzo_mosso.getNumero();
					//controllo che il numero del pezzo in esame corrisponda al numero del
					//pezzo passato nel parametro
					if (num_pezzo_temp != num_pezzo){
						//se non corrisponde, continuo la ricerca del pezzo desiderato
						continue;
					}
					//vedo se il pezzo soddisfa la carattaristica 'mangia se minacciato'
					if (matrice.mangiaSeMinacciato(pezzo_mosso)){
						risultato[0] = risultato[0] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'scappa se minacciato'
					if (matrice.scappaSeMinacciato(pezzo_mosso)){
						risultato[1] = risultato[1] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'rimane fermo se minacciato'
					if (matrice.fermoSeMinacciato(pezzo_mosso)){
						risultato[2] = risultato[2] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'minaccia pezzi avversari'
					if (matrice.minacciaPezzoAvversario(nuova_matrice, pezzo_mosso)){
						risultato[3] = risultato[3] + 1;
					}
				}
			}
			else{ //posizione_giocatore == 2
				//scorro tutti i pezzi buoni
				for (int i=0; i<tav.vettorePezzi((byte)3).size(); i++){
					//ricavo il pezzo che ho mosso
					Pezzo pezzo_mosso = tav.vettorePezzi((byte)3).get(i);
					//estrapolo il numero del pezzo
					int num_pezzo_temp = pezzo_mosso.getNumero();
					//controllo che il numero del pezzo in esame corrisponda al numero del
					//pezzo passato nel parametro
					if (num_pezzo_temp != num_pezzo){
						//se non corrisponde, continuo la ricerca del pezzo desiderato
						continue;
					}
					//vedo se il pezzo soddisfa la carattaristica 'mangia se minacciato'
					if (matrice.mangiaSeMinacciato(pezzo_mosso)){
						risultato[0] = risultato[0] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'scappa se minacciato'
					if (matrice.scappaSeMinacciato(pezzo_mosso)){
						risultato[1] = risultato[1] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'rimane fermo se minacciato'
					if (matrice.fermoSeMinacciato(pezzo_mosso)){
						risultato[2] = risultato[2] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'minaccia pezzi avversari'
					if (matrice.minacciaPezzoAvversario(nuova_matrice, pezzo_mosso)){
						risultato[3] = risultato[3] + 1;
					}
				}
				//scorro tutti i pezzi cattivi
				for (int i=0; i<tav.vettorePezzi((byte)4).size(); i++){
					//ricavo il pezzo che ho mosso
					Pezzo pezzo_mosso = tav.vettorePezzi((byte)4).get(i);
					//estrapolo il numero del pezzo
					int num_pezzo_temp = pezzo_mosso.getNumero();
					//controllo che il numero del pezzo in esame corrisponda al numero del
					//pezzo passato nel parametro
					if (num_pezzo_temp != num_pezzo){
						//se non corrisponde, continuo la ricerca del pezzo desiderato
						continue;
					}
					//vedo se il pezzo soddisfa la carattaristica 'mangia se minacciato'
					if (matrice.mangiaSeMinacciato(pezzo_mosso)){
						risultato[0] = risultato[0] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'scappa se minacciato'
					if (matrice.scappaSeMinacciato(pezzo_mosso)){
						risultato[1] = risultato[1] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'rimane fermo se minacciato'
					if (matrice.fermoSeMinacciato(pezzo_mosso)){
						risultato[2] = risultato[2] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'minaccia pezzi avversari'
					if (matrice.minacciaPezzoAvversario(nuova_matrice, pezzo_mosso)){
						risultato[3] = risultato[3] + 1;
					}
				}
			}
			//aggiorno la vecchia matrice dei pezzi
			matrice = nuova_matrice;
			//aggiorno il turno
			turno_avversario = true;
			//aggiorno la linea da prendere in considerazione
			linea_in_esame++;
		}
		return risultato;
	}
	
	/**
	 * metodo senza parametri che permete di ricreare la base logica di una partita partendo da un file di log
	 * 
	 * @return pezzo[][] base logica della partita
	 * 
	 */
	private Pezzo[][] generaTavolo(){
		//salvo in una variabile il vettore di log della partita
		LogPartita logPartita = new LogPartita(nomePartita);
		Vector<String> log = logPartita.getLog();
		//creo la matrice che conterra' il risultato
		Pezzo[][] risultato = new Pezzo[6][6];
		//inizializzo la matrice con i giusti valori
		risultato[0][1] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(2)), (byte)1, GestisceFile.ottieniPezzo(log.get(2)), risultato);
		risultato[0][2] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(3)), (byte)1, GestisceFile.ottieniPezzo(log.get(3)), risultato);
		risultato[0][3] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(4)), (byte)1, GestisceFile.ottieniPezzo(log.get(4)), risultato);
		risultato[0][4] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(5)), (byte)1, GestisceFile.ottieniPezzo(log.get(5)), risultato);
		risultato[1][1] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(6)), (byte)1, GestisceFile.ottieniPezzo(log.get(6)), risultato);
		risultato[1][2] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(7)), (byte)1, GestisceFile.ottieniPezzo(log.get(7)), risultato);
		risultato[1][3] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(8)), (byte)1, GestisceFile.ottieniPezzo(log.get(8)), risultato);
		risultato[1][4] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(9)), (byte)1, GestisceFile.ottieniPezzo(log.get(9)), risultato);
		risultato[4][1] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(10)), (byte)2, GestisceFile.ottieniPezzo(log.get(10)), risultato);
		risultato[4][2] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(11)), (byte)2, GestisceFile.ottieniPezzo(log.get(11)), risultato);
		risultato[4][3] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(12)), (byte)2, GestisceFile.ottieniPezzo(log.get(12)), risultato);
		risultato[4][4] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(13)), (byte)2, GestisceFile.ottieniPezzo(log.get(13)), risultato);
		risultato[5][1] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(14)), (byte)2, GestisceFile.ottieniPezzo(log.get(14)), risultato);
		risultato[5][2] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(15)), (byte)2, GestisceFile.ottieniPezzo(log.get(15)), risultato);
		risultato[5][3] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(16)), (byte)2, GestisceFile.ottieniPezzo(log.get(16)), risultato);
		risultato[5][4] = new Pezzo(GestisceFile.ottieniCoordinata(log.get(17)), (byte)2, GestisceFile.ottieniPezzo(log.get(17)), risultato);
		//aggiorno le mosse fattibili di tutti i pezzi
		risultato[0][1].ricalcolaMosseFattibili(risultato);
		risultato[0][2].ricalcolaMosseFattibili(risultato);
		risultato[0][3].ricalcolaMosseFattibili(risultato);
		risultato[0][4].ricalcolaMosseFattibili(risultato);
		risultato[1][1].ricalcolaMosseFattibili(risultato);
		risultato[1][2].ricalcolaMosseFattibili(risultato);
		risultato[1][3].ricalcolaMosseFattibili(risultato);
		risultato[1][4].ricalcolaMosseFattibili(risultato);
		risultato[4][1].ricalcolaMosseFattibili(risultato);
		risultato[4][2].ricalcolaMosseFattibili(risultato);
		risultato[4][3].ricalcolaMosseFattibili(risultato);
		risultato[4][4].ricalcolaMosseFattibili(risultato);
		risultato[5][1].ricalcolaMosseFattibili(risultato);
		risultato[5][2].ricalcolaMosseFattibili(risultato);
		risultato[5][3].ricalcolaMosseFattibili(risultato);
		risultato[5][4].ricalcolaMosseFattibili(risultato);
		return risultato;
	}
}
