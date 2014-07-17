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

import apprendimento.GestisceFileProfilo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.io.*;

/**
 * Questa classe viene utilizzata per la gestione logica del gioco<p>&nbsp;</p>
 * <p>&nbsp;</p>
 * <p><u><i>Elenco versioni:</i></u></p>
 * <p><i>ver. 4.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 26/11/2007</i></p>
 * <ul>
 *   <li>aggiunto un secondo costruttore a quattro parametri</li>
 *   <li>aggiunto metodo getTurnoCorretto</li>
 * </ul>
 * <p><i>ver. 4.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 24/11/2007</i></p>
 * <ul>
 *   <li>costruttore modificato</li>
 *   <li>metodo tavoloPronto modificato</li>
 * </ul>
 * <p><i>ver. 4.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 16/11/2007</i></p>
 * <ul>
 *   <li>aggiunto metodo getIa</li>
 *   <li>aggiunto metodo setIa</li>
 *   <li>aggiunto metodo getAvversario</li>
 *   <li>aggiunto metodo getGiocatore</li>
 * </ul>
 * <p><i>ver. 3.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 15/11/2007</i></p>
 * <ul>
 *   <li>metodo togliPezzo modificato</li>
 *   <li>metodo eseguiMossa modificato</li>
 *   <li>aggiunto metodo getVettoreLog</li>
 * </ul>
 * <p><i>ver. 2.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 10/11/2007</i></p>
 * <ul>
 *   <li>metodo eseguiMossa modificato</li>
 *   <li>modificate le invocazioni delle eccezioni</li>
 * </ul>
 * <p><i>ver. 2.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 7/11/2007</i></p>
 * <ul>
 *   <li>costruttore modificato</li>
 *   <li>metodo finePartita modificato</li>
 * </ul>
 * <p><i>ver. 2.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 5/11/2007</i></p>
 * <ul>
 *   <li>metodo tavoloPronto modificato</li>
 *   <li>metodo aggiornaMosseLegali eliminato</li>
 *   <li>metodo aggiungiPezzo modificato</li>
 *	 <li>metodo togliPezzo modificato</li>
 *   <li>metodo eseguiMossa modificato</li>
 * </ul>
 * <p><i>ver. 1.5&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 1/11/2007</i></p>
 * <ul>
 *   <li>metodo aggiungiPezzo modificato</li>
 *   <li>metodo eliminaPezzo modificato</li>
 *   <li>visibilita' aggiornaMosseLegali modificata</li>
 * </ul>
 * <p><i>ver. 1.4&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 30/10/2007</i></p>
 * <ul>
 *   <li>modificata la formattazione dei log</li>
 * </ul>
 * <p><i>ver. 1.3&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 27/10/2007</i></p>
 * <ul>
 *   <li>aggiunto metodo togliPezzo()</li>
 *   <li>metodo eseguiMosa modificato</li>
 *   <li>aggiunto campo dato vettore_log</li>
 * </ul>
 * <p><i>ver. 1.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 26/10/2007</i></p>
 * <ul>
 *   <li>modifica funzione finePartita()</li>
 *   <li>aggiunto metodo tavoloPronto()</li>
 *   <li>aggiunto metodo getPartenza()</li>
 *   <li>aggiunto metodo getTavolo()</li>
 * </ul>
 * <p><i>ver. 1.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 25/10/2007</i></p>
 * <ul>
 *   <li>modificato il tipo dei campi dati turno e partenza </li>
 *   <li>aggiunto campo dato log_partite </li>
 *   <li>aggiunto campo dato file_log </li>
 *   <li>costruttore modificato </li>
 *   <li>metodo eseguiMossa modificato
 * </li>
 *   <li>rinominato metodo controllaTurno in getTurno </li>
 *   <li>metodo getTurno modificato
 * </li>
 *   <li>aggiunto metodo finePartita()
 * </li>
 * </ul>
 * <p><i>&nbsp;ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 22/10/2007</i></p>
 * <ul>
 *   <li>aggiunto il metodo aggiornaMosseLegali</li>
 *   <li>aggiunto il metodo tavoloPronto</li>
 *   <li>metodo controllaTurno modificato</li>
 *   <li>costruttore modificato</li>
 *   <li>metodo vittoria modificato</li>
 * </ul>
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 21/10/2007</i></p>
 * <ul>
 *   <li>bozza iniziale</li>
 * </ul>
 * 
 * 
 * @see Tavolo
 * @see Giocatore
 * @see GestisceFile
 * 
 * @author  Mazzarelli Ivan
 * @version 4.2 del 26/11/2007
 */
public class Partita {
	/** rappresenta la base logica su cui vengono rappresentati i vari pezzi */
	private Tavolo tav = new Tavolo();
	/** indica il giocatore a cui tocca muovere (1= giocatore 1, 2=giocatore 2) */
	private byte turno;
	/** indica il nome della partita */
	private String nome_partita;
	/** indica il giocatore che inizia (1=giocatore 1, 2=giocatore 2) */
	private byte partenza;
	/** indica il numero totale di mosse eseguite dall'inizio della partita */
	private int mosse_eseguite=0;
	/** rappresenta il giocatore uno */
	private Giocatore giocatore_uno;
	/** rappresenta il giocatore due */
	private Giocatore giocatore_due;
    /** contiene tutte le funzionalita' di caricamento e salvataggio da file del giocatore 1*/
	private GestisceFile file_log_g1;
	/** contiene tutte le funzionalita' di caricamento e salvataggio da file del giocatore 2*/
	private GestisceFile file_log_g2;
	/** contiene tutte le informazioni necessarie a tener traccia delle 
	 * azioni effettuate durante una partita */
	private Vector<String> vettore_log = new Vector<String>();
	
	private String temp_turno="";

    private double livelloG1=0.0;
	
	private double livelloG2=0.0;
	
	private boolean allenamento1=false;
	
	private boolean allenamento2=false;
	
//	boolean attiva_ia1=false;
//	
//	boolean attiva_ia2=false;

	/**
	 * Costruttore senza parametri.
	 */
	public Partita(){}
	
	/** costruttore a sei parametri
	 * 
	 * @param nome indica il nome della partita
	 * @param part indica il giocatore che inizierà a muovere (1= giocatore 1, 2=giocatore 2)
	 * @param uno rappresenta il giocatore uno
	 * @param due rappresenta il giocatore due
	 */
	public Partita(String nome, byte part, Giocatore uno, Giocatore due,double l1,double l2,boolean all1,boolean all2) throws FileNotFoundException{
		turno=part;
		nome_partita=nome;
		partenza=part;		
		giocatore_uno=uno;
		giocatore_due=due;
		livelloG1=l1;
		livelloG2=l2;
		allenamento1=all1;
		allenamento2=all2;
		/* rappresenta il nome del file di log del giocatore 1*/
        String log_partite_g1 = giocatore_uno.getNome();
		/* rappresenta il nome del file di log del giocatore 2*/
        String log_partite_g2 = giocatore_due.getNome();
		file_log_g1 = new GestisceFile(giocatore_uno.getNome(), giocatore_uno.getIdentificatore());
		file_log_g2 = new GestisceFile(giocatore_due.getNome(), giocatore_due.getIdentificatore());
		//creo la stringa iniziale da inserire nel file di log
		String temp="";
		//inizializzo la stringa iniziale da inserire nel file di log
		temp = "1:"+Integer.parseInt(giocatore_uno.getIdentificatore())+"\n";
		//inserisco nel vettore di log la stringa
		vettore_log.add(temp);
		
		System.out.println("PROVA VETTORE LOG IN PARTITA 1: "+vettore_log);
		
		temp = "2:"+Integer.parseInt(giocatore_due.getIdentificatore())+"\n";
		//inserisco nel vettore di log la stringa
		vettore_log.add(temp);

		System.out.println("PROVA VETTORE LOG IN PARTITA 2: "+vettore_log);
		
	}
	
	/**
	 * Metodo a 3 parametri che permette di aggiungere un pezzo nella base logica della partita
	 * 
	 * @param c Coordinata inserire il pezzo
	 * @param gioc giocatore a cui appartiene il pezzo
	 * @param num numero del pezzo
	 * 
	 * @return boolean true se il pezzo e' stato aggiunto correttamente<p>
	 * false se il pezzo non e' stato aggiunto
	 */
	public boolean aggiungiPezzo(Coordinata c, byte gioc, byte num){
		Pezzo p = new Pezzo(c, gioc, num, tav.getBaseLogica());
		return tav.aggiungiPezzo(c, p);
	}
	
	/**
	 * Metodo che permette di eliminare dalla base logica, un pezzo posizionato su una
	 * determinata coordinata
	 * 
	 * @param c Coordinata di cui si vuole eliminare il pezzo
	 * 
	 * @return boolean true se il pezzo e' stato eliminato o se nella coordinata 
	 * inserita non vi era nessun pezzo da liminare<p>
	 * false se il pezzo non e' stato eliminato
	 */
	public void togliPezzo(Coordinata c){
        String char_mangiato = tav.eliminaPezzo(c, false);
		System.out.println("******** CHAR *********** CHAR ************" + char_mangiato);
	}
	
	/**
	 * Metodo senza parametri che permette di inizializzare il vettore contenente i log con le informazioni
	 * iniziali della partita (giocatore che inizia e disposizione iniziale dei pezzi)
	 * 
	 * @return boolean true se ho inizializzato correttamente il vettore dei log<p>
	 * false se sul tavolo non sono presenti tutti e 16 i pezzi
	 */
	public boolean tavoloPronto() {
		//determino se sulla scacchiera sono presenti tutti e 16 i pezzi
		if (tav.vettorePezzi((byte)1).size()==4 &&
			tav.vettorePezzi((byte)2).size()==4 && 
			tav.vettorePezzi((byte)3).size()==4 && 
			tav.vettorePezzi((byte)4).size()==4){
			//creo la stringa da inserire nel file di log contenente la posizione dei pezzi buoni/cattivi
			//e la inserisco nel vettore di log
			//String temp = "Disposizione iniziale dei pezzi:";
			System.out.println("PROVA VETTORE LOG IN PARTITA 3: "+vettore_log);
			String temp;
			//vettore_log.add(temp);
			temp = "01:" + tav.getPezzo(new Coordinata((byte)0,(byte)1)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "02:" + tav.getPezzo(new Coordinata((byte)0,(byte)2)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "03:" + tav.getPezzo(new Coordinata((byte)0,(byte)3)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "04:" + tav.getPezzo(new Coordinata((byte)0,(byte)4)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "11:" + tav.getPezzo(new Coordinata((byte)1,(byte)1)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "12:" + tav.getPezzo(new Coordinata((byte)1,(byte)2)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "13:" + tav.getPezzo(new Coordinata((byte)1,(byte)3)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "14:" + tav.getPezzo(new Coordinata((byte)1,(byte)4)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "41:" + tav.getPezzo(new Coordinata((byte)4,(byte)1)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "42:" + tav.getPezzo(new Coordinata((byte)4,(byte)2)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "43:" + tav.getPezzo(new Coordinata((byte)4,(byte)3)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "44:" + tav.getPezzo(new Coordinata((byte)4,(byte)4)).getNumero() + "\n";
			vettore_log.add(temp);			
			temp = "51:" + tav.getPezzo(new Coordinata((byte)5,(byte)1)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "52:" + tav.getPezzo(new Coordinata((byte)5,(byte)2)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "53:" + tav.getPezzo(new Coordinata((byte)5,(byte)3)).getNumero() + "\n";
			vettore_log.add(temp);
			temp = "54:" + tav.getPezzo(new Coordinata((byte)5,(byte)4)).getNumero() + "\n";
			vettore_log.add(temp);		
			//aggiorno le mosse legali di tutti i pezzi
			tav.aggiornaMosseLegali();
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Metodo con due parametri che, date le coordinate di partenza e di arrivo, esegue la mossa
	 * sulla parte logica del gioco.
	 * 
	 * @param partenza Coordinata di partenza del pezzo
	 * @param arrivo Coordinata di arrivo del pezzo
	 * 
	 * @return boolean true se la mossa e' stata eseguita correttamente<p>
	 * false se la mossa non e' legale
	 */
	public boolean eseguiMossa(Coordinata partenza, Coordinata arrivo, String mangiato){
		
		System.out.println(giocatore_uno.getNome() + " **************** e ************" + giocatore_due.getNome());
		//controllo che le coordinate inserite siano corrette
		if (partenza == null || arrivo == null || partenza.equals(arrivo))
			return false;
		//controllo che la mossa sia legale scorrendo tutte le mosse che il pezzo può fare
		for (int a=0; a<tav.getPezzo(partenza).getMosseFattibili().size(); a++){
			//confronto se la coordinata di arrivo è presente nel vettore delle mosse fattibili
			if (tav.getPezzo(partenza).getMosseFattibili().get(a).equals(arrivo)){
				//muovo il pezzo
				tav.muoviPezzo(partenza, arrivo);
				//aggiorno il numero di mosse seguite
				mosse_eseguite++;
				//aggiorno il turno
				if (turno==1)
					turno=2;
				else
					turno=1;
				//creo la stringa di log
				String temp ="";
				//memorizzo le mosse eseguite nel seguente formato: 001/002/..
				/*
				if ( mosse_eseguite < 10)
					temp = "00" + Integer.toString(mosse_eseguite) + ") ";
				else
					if (mosse_eseguite > 9 && mosse_eseguite < 100)
						temp = "0" + Integer.toString(mosse_eseguite) + ") ";
					else
						temp = Integer.toString(mosse_eseguite) + ") ";
				 */
				
				//memorizzo le mosse nel formato 1. 2. ... 10. 11. ...
				//Una per una mossa di entrambi i giocatori (quindi aggiungo intestazione solo se num=dispari
				boolean pari = mosse_eseguite%2==0;
				int turno_corrente = 0;
				if(!pari){
					//System.out.println(temp + "*** *** **** "+ mosse_eseguite + " " + mosse_eseguite/2 + " " + (int)mosse_eseguite/2);
					turno_corrente= (int)(mosse_eseguite/2)+1;
					temp += turno_corrente + ".";
				}
				if(pari)
					temp += ",";
				
				temp = temp + Byte.toString(partenza.getRiga()) + Byte.toString(partenza.getColonna());
				temp = temp + mangiato;
				temp = temp + Byte.toString(arrivo.getRiga()) + Byte.toString(arrivo.getColonna());
				
				if(pari)
					temp += "\n";
					
				
				//se le mosse sono pari hanno mosso entrambi, aggiorno la mossa completa
				//e la scrivo sul vettore di log sostituendola alla precedente
				//se sono dispari allora aggiorno solo la mossa completa

				temp_turno = temp_turno + temp;
				if(pari){
					int dim = vettore_log.size();
					vettore_log.setElementAt(temp_turno, dim-1);
					temp_turno="";
				}
				else
					vettore_log.add(temp_turno);
				
				return true;
			}
		}
		//la mossa indicata non è corretta
		return false;
	}
	
	/**
	 * Metodo con due parametri che, date le coordinate di partenza e di arrivo, determina
	 * se la mossa e' legale o meno
	 * 
	 * @param partenza Coordinata di partenza del pezzo
	 * @param arrivo Coordinata di arrivo del pezzo
	 * 
	 * @return boolean true se la mossa e' legale, false altrimenti
	 */
	public boolean mossaCorretta(Coordinata partenza, Coordinata arrivo){
		//controllo che le coordinate inserite siano corrette
		if (partenza == null || arrivo == null || partenza.equals(arrivo))
			return false;
		//controllo che la mossa sia legale scorrendo tutte le mosse che il pezzo può fare
		for (int a=0; a<tav.getPezzo(partenza).getMosseFattibili().size(); a++){
			//confronto se la coordinata di arrivo è presente nel vettore delle mosse fattibili
			if (tav.getPezzo(partenza).getMosseFattibili().get(a).equals(arrivo)){
				return true;
			}
		}
		//la mossa indicata non è corretta
		return false;
	}
	
	/**
	 * Metodo senza parametri per determinare se una partita e' finita o meno.
	 * Questo metodo gestisce solo i casi in cui vengono mangiati tutti i pezzi
	 * buoni o tutti i pezzi cattivi.
	 * 
	 * @return byte - 1 se ha vinto il giocatore 1 ( e cioe' se ha mangiato tutti i pezzi
	 * buoni dell'avversario o se l'avversario ha mangiato tutti i suoi pezzi cattivi.<p>
	 * 2 se ha vinto il giocatore 2 ( e cioe' se ha mangiato tutti i pezzi
	 * buoni dell'avversario o se l'avversario ha mangiato tutti i suoi pezzi cattivi.<p>
	 * 0 se ogni giocatore ha almeno un pezzo buono ed uno cattivo
	 * 
	 * */
	public byte vittoria(){
		//se il numero dei pezzi buoni del gicatore 1 è 0, ha vinto il giocatore 2
		if (tav.getNumeroPezziBuoni((byte)1)==0){
			return 2;
		}
		//se il numero dei pezzi buoni del gicatore 2 è 0, ha vinto il giocatore 1
		if (tav.getNumeroPezziBuoni((byte)2)==0){
			return 1;
		}
		//se il numero di pezzi cattivi del giocatore 1 è 0, ha vinto il giocatore 1
		if (tav.getNumeroPezziCattivi((byte)1)==0){
			return 1;
		}
		//se il numero di pezzi cattivi del giocatore 2 è 0, ha vinto il giocatore 2
		if (tav.getNumeroPezziCattivi((byte)2)==0){
			return 2;
		}
		//se il numero di pezzi buoni e cattivi dei due giocatori è maggiore di 0, non posso
		//determinare a priori se la partita è finita e se uno dei due giocatori ha vinto
		return 0;
	}
	
	/** Metodo con un parametro che permette di salvare su file il log della partita
	 * 
	 * @param giocatore numero del giocatore che ha vinto (1=giocatore 1, 2=giocatore 2)
	 */
	public void finePartita(byte giocatore) throws FileNotFoundException{
		//aggiungo una riga vuota nel vettore
		//vettore_log.add("Fine Partita:");
		//creo la stringa di log
		//String temp = "vince il giocatore " + Byte.toString(giocatore) + "( ";
		//inserisco il nome del giocatore
		
		String vincitore;
		if (giocatore == 1)
			vincitore = giocatore_uno.getNome();
		else
			vincitore = giocatore_due.getNome();
		/*
		temp = temp + " ) in " + Integer.toString(mosse_eseguite) + " mosse.";
		//scrivo la mossa sul vettore di log
		vettore_log.add(temp);
		temp = "._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-.";
		vettore_log.add(temp);
		//aggiungo delle righe vuote nel vettore
		vettore_log.add("");
		vettore_log.add("");
		*/
		
		this.salvaPartitaDB("Pippo", "Pluto", "Pippo", vettore_log);
		//this.salvaPartitaDB(giocatore_uno.getNome(), giocatore_due.getNome(), vincitore, vettore_log);
		
		
		
		if(!this.getAllenamentoG1()){
			//salvo la partita sui file di log del giocatore1
			file_log_g1.salvaSuFile(vettore_log);
			//creo il profilo abbinato al giocatore
			GestisceFileProfilo profilo_giocatore_uno = new GestisceFileProfilo(giocatore_uno.getNome(),giocatore_uno.getIdentificatore(), !giocatore_uno.getUmano(), file_log_g1.trasformaInVettore());
			profilo_giocatore_uno.aggiornaProfilo();
		}
		if(!this.getAllenamentoG2()){
			//salvo la partita sui file di log del giocatore2
			file_log_g2.salvaSuFile(vettore_log);
			//creo il profilo abbinato al giocatore
			GestisceFileProfilo profilo_giocatore_due = new GestisceFileProfilo(giocatore_due.getNome(),giocatore_due.getIdentificatore(), !giocatore_due.getUmano(), file_log_g2.trasformaInVettore());
			profilo_giocatore_due.aggiornaProfilo();
		}
	}

	private String logToString(Vector<String> log){
		String temp="";
		for(int i=0;i<log.size();i++)
			temp+=log.elementAt(i);
		//System.out.println(temp);
		return temp;
	}
	
	private void salvaPartitaDB(String nome, String avv, String vincitore, Vector<String> partita){
		try
		{
			int vinc=0;
			int gioc1=0; 
			int gioc2=0;
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost/sql81876_4";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement cmd = con.createStatement();
			String cerca_vinc = "SELECT id FROM giocatori WHERE nome='"+vincitore+"'";
			//System.out.println(cerca_vinc);
			String cerca_g1 = "SELECT id FROM giocatori WHERE nome='"+nome+"'";
			//System.out.println(cerca_g1);
			String cerca_g2 = "SELECT id FROM giocatori WHERE nome='"+avv+"'";
			//System.out.println(cerca_g2);
			ResultSet res_vinc = cmd.executeQuery(cerca_vinc);
			while (res_vinc.next())
			{
				vinc = res_vinc.getInt("id");
				//System.out.println(vinc);
			}
			ResultSet res_g1 = cmd.executeQuery(cerca_g1);
			while (res_g1.next())
			{
				gioc1 = res_g1.getInt("id");
				//System.out.println(gioc1);
			}
			ResultSet res_g2 = cmd.executeQuery(cerca_g2);
			while (res_g2.next())
			{
				gioc2 = res_g2.getInt("id");
				//System.out.println(gioc2);
			}
			if(vinc!=0 && gioc1!=0 && gioc2!=0){
				int id_ultima_partita = 0;
				String cerca_partite = "SELECT * FROM partite ORDER BY id ASC";
				//System.out.println(cerca_partite);
				ResultSet res_partite = cmd.executeQuery(cerca_partite);
				while (res_partite.next())
				{
					id_ultima_partita = res_partite.getInt("id");
				}
				id_ultima_partita++;
				//System.out.println(id_ultima_partita);
				
				String insert_partita = "INSERT INTO partite(id,winner,log) VALUES("+id_ultima_partita+","+vinc+",'"+logToString(partita)+"')";
				cmd.executeUpdate(insert_partita);
				//System.out.println(insert_partita);
				
				String insert_link = "INSERT INTO partite_giocatori(gioc1,gioc2,partita) VALUES("+gioc1+","+gioc2+","+id_ultima_partita+")";
				cmd.executeUpdate(insert_link);
				//System.out.println(insert_link);
				
				String test= "SELECT * FROM partite WHERE id="+id_ultima_partita;
				//System.out.println(cerca_partite);
				ResultSet res_Temp = cmd.executeQuery(test);
				while (res_Temp.next())
				{
					//System.out.println("******** LOG = ******** "+res_Temp.getString("log"));
				}
			}
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
	
	/** Metodo senza parametri per determinare a quale dei due giocatori tocca muove
	 * 
	 * @return byte - 1 se deve muovere il giocatore 1, 2 se deve muovere il giocatore 2
	 */
	public byte getTurno(){
		return turno;
	}
	
	/**
	 * Metodo ad un parametro che permette di stabilire se e' il turno del giocatore
	 * passato come parametro
	 * 
	 * @param ident_giocatore rappresenta l'identificativo del giocatore del quale
	 * voglio sapere se e' il turno
	 * 
	 * @return true se e' il turno di quel giocatore, false altrimenti
	 */
	public boolean getTurnoCorretto(String ident_giocatore){
		//se l'identificativo del giocatore corrisponde al giocatore uno, ed e' il turno
		//del giocatore uno, ritorno true
		if (ident_giocatore.equals(giocatore_uno.getIdentificatore()) && turno == 1)
			return true;
		//se l'identificativo del giocatore corrisponde al giocatore due, ed e' il turno
		//del giocatore due, ritorno true
		if (ident_giocatore.equals(giocatore_due.getIdentificatore()) && turno == 2)
			return true;
		//in tutti gli altri casi ritorna false
		return false;
	}
	
	/**	 metodo senza parametri che ritorna la base logica della partita
	 * 
	 * @return un oggetto di tipo Tavolo, che rappresenta la base logica della partita
	 */
	public Tavolo getTavolo(){
		return tav;
	}
	
	/** Metodo senza parametri per determinare quale dei due giocatori ha iniziato la partita
	 * 
	 * @return byte - 1 se ha iniziato il giocatore 1, 2 se ha iniziato il giocatore 2
	 */
	public byte getPartenza(){
		return partenza;
	}
	
	/** Metodo senza parametri che restituisce il vettore di log della partita
	 * 
	 * @return Vector<String> vettore di stringhe che rappresenta il log di una partita.
	 */
	public Vector<String> getVettoreLog(){
		return vettore_log;
	}
	
	/**
	 * Metodo che ritorna true se il giocatore numero 'giocatore' ha l'IA attiva.
	 *
	 * @param num_giocatore giocatore un byte che rappresenta il numero del giocatore.
	 *
	 * @return un boolean che vale true se il giocatore numero 'giocatore' ha l'IA attiva.
	 */
	public boolean isIA(byte num_giocatore){
		if(num_giocatore == (byte)1)
			return !(giocatore_uno.getUmano());
		else
			return !(giocatore_due.getUmano());
	}
	
	/**
	 * Metodo che ritorna l'avversario del giocatore che riceve come parametro.
	 *
	 * @param num_gioc il giocatore.
	 *
	 * @return un byte che rappresenta il numero del giocatore avversario.
	 */
	public byte getAvversario(byte num_gioc){
		if(num_gioc == (byte)1)
			return 2;
		else
			return 1;
	}
	
	/**
	 * Questo metodo ritorna l'oggetto giocatore corrispondente al 
	 * numero inserito.
	 *
	 * @param num_gioc il numero del giocatore.
	 *
	 * @return un oggetto Giocatore che rappresenta il giocatore corrispondente al numero.
	 */
	public Giocatore getGiocatore(byte num_gioc){
		if(num_gioc == (byte)1)
			return giocatore_uno;
		else
			return giocatore_due;
	}
	
	/**
	 * Questo metodo ritorna il nome della partita.
	 *
	 * @return il nome della partita.
	 */
	public String getNomePartita(){
		return nome_partita;
	}
	
	public double getLivelloG1(){
		return  livelloG1;
	}
	
	public double getLivelloG2(){
		return  livelloG2;
	}
	
	/**
	 * Metodo che ritorna se il giocatore 1 sta giocando in modalit� allenamento con conseguente uso di aiuti
	 * @return lo stato di allenamento1
	 */
    boolean getAllenamentoG1(){
		return  allenamento1;
	}
	
	/**
	 * Metodo che ritorna se il giocatore 2 sta giocando in modalit� allenamento con conseguente uso di aiuti
	 * @return lo stato di allenamento2
	 */
    boolean getAllenamentoG2(){
		return  allenamento2;
	}
	
}





