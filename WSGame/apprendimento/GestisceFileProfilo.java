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

import logica.Coordinata;
import logica.GestisceFile;
import logica.Pezzo;
import logica.Tavolo;
import java.io.*;
import java.util.Vector;

/**
* Questa classe ha la funzione di gestire i file contenenti i profili dei giocatori,&nbsp; raggruppando 
* tutte le funzionalita' necessarie a manipolare in modo corretto i file&nbsp;
* e tutte le funzioni indispensabili per estrapolare da un file di log, il profilo di un
* giocatore.<p>Le righe contenute all'interno del profilo, avranno i seguenti significati:</p>
* <p>1° - indica se il pezzo era situato nella posizione 1 </p>
* <p>2° - indica se il pezzo era situato nella posizione 2 </p>
* <p>3° - indica se il pezzo era situato nella posizione 3 </p>
* <p>4° - indica se il pezzo era situato nella posizione 4 </p>
* <p>5° - indica se il pezzo era situato nella posizione 5 </p>
* <p>6° - indica se il pezzo era situato nella posizione 6 </p>
* <p>7° - indica se il pezzo era situato nella posizione 7 </p>
* <p>8° - indica se il pezzo era situato nella posizione 8 </p>
* <p>9° - indica se il pezzo ha fatto prima mossa </p>
* <p>10° - indica se il pezzo ha fatto ha fatto&nbsp; la seconda mossa </p>
* <p>11° - indica il numero di avanzamenti che ha fatto il pezzo</p>
* <p>12° - indica il numero di retrocessioni che ha fatto il pezzo</p>
* <p>13° - indica il numero di spostamenti laterali che ha fatto il pezzo</p>
* <p>14° - numero di volte in cui il pezzo mangia se viene minacciato</p>
* <p>15° - numero di volte in cui il pezzo scappa se viene minacciato</p>
* <p>16° - numero di volte in cui il pezzo rimane fermo se viene minacciato</p>
* <p>17° - numero di volte in cui il pezzo minaccia i pezzi avversari</p>
* <p>&nbsp;</p>
* <p>&nbsp;</p>
* <p><u><i>Elenco versioni:</i></u></p>
* <p><i>ver. 4.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 26/11/2007 </i></p>
* <ul>
*   <li>aggiunto metodo aggiornaProfiloParzialmente</li>
*   <li>aggiunto un secondo costruttore a due parametri</li>
*   <li>aggiunto il metodo trasformaArrayInStringa</li>
*   <li>aggiunto il metodo salvaStatisticheSuFile</li>
* </ul>
* <p><i>ver. 4.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 14/11/2007 </i></p>
* <ul>
*   <li>modificato metodo spostamentiNellaPartita </li>
* </ul>
* <p><i>ver. 4.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 19/11/2007 </i></p>
* <ul>
*   <li>aggiunta classe interna MatricePezzi </li>
*   <li>aggiunto costruttore all'interno della classe MatricePezzi</li>
*   <li>aggiunto metodo setMosseFattibili all'interno della classe MatricePezzi
*   </li>
*   <li>aggiunto metodo mangiaSeMinacciato all'interno della classe MatricePezzi
*   </li>
*   <li>aggiunto metodo scappaSeMinacciato all'interno della classe MatricePezzi
*   </li>
*   <li>aggiunto metodo fermoSeMinacciato all'interno della classe MatricePezzi
*   </li>
*   <li>aggiunto metodo setPezziMangiabili all'interno della classe MatricePezzi
*   </li>
*   <li>aggiunto metodo getVettore all'interno della classe MatricePezzi </li>
*   <li>aggiunto metodo minacciato all'interno della classe MatricePezzi </li>
* </ul>
* <p><i>ver 3.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 17/11/2007 </i></p>
* <ul>
*   <li>aggiunto metodo rigaFinePartita </li>
* </ul>
* <p><i>ver. 3.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 16/11/2007 </i></p>
* <ul>
*   <li>modificato metodo ScriviIntestazione </li>
*   <li>aggiunto metodo posizioneSecondaMossa </li>
* </ul>
* <p><i>ver. 3.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 15/11/2007 </i></p>
* <ul>
*   <li>aggiunto il metodo scriviRiga </li>
*   <li>aggiunto il metodo mediaVettori </li>
*   <li>costruttore modificato
* </li>
*   <li>metodo aggiornaProfilo modificato
*  
*   </li>
* </ul>
* <p><i>ver. 2.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 11/11/2007 </i></p>
* <ul>
*   <li>aggiunto trasformaInVettore </li>
*   <li>aggiunto trasformaInVettoreDiInteger </li>
*   <li>aggiunto scriviIntestazione </li>
* </ul>
* <p><i>ver. 2.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 10/11/2007 </i></p>
* <ul>
*   <li>rinonimato il metodo disposizionePezzi in disposizioneInizialePezzi </li>
*   <li>aggiunto posizionePrimaMossa </li>
*   <li>aggiunto determinaBontaCoordinata </li>
* </ul>
* <p><i>ver.  1.0 ~*~&nbsp;&nbsp;&nbsp; 09/11/2007</i></p>
* <ul>
*   <li>costruttore modificato</li>
*   <li>aggiunto il metodo AggiornaProfilo</li>
*   <li>aggiunto il metodo disposizionePezzi</li>
* </ul>
* <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 07/11/2007
* </i></p>
* <ul>
*   <li>bozza iniziale</li>
* </ul>
* 
* 
* @author Mazzarelli Ivan
* @version 4.2 del 26/11/2007
*/
public class GestisceFileProfilo extends GestisceFile {
	/** vettore che contiene tutte le righe del file di log del giocatore*/
	private Vector<String> log;
	/** vettore contenente tutte le righe del profilo del giocatore*/
	private Vector<String> profilo = new Vector<String>();
	
	/** id giocatore per il DB */
	private int id;
	/** indica se esiste gia' un file contenente il profilo*/
	private boolean nuovo = true;
	
	/**
	 * Costruttore a 2 parametri che inizializza il vettore contenente il profilo, senza 
	 * memorizzare su file il suo contenuto
	 * 
	 * @param nome nome del giocatore
	 * @param identificatore stringa rappresentante l'identificativo del giocatore
	 */
	public GestisceFileProfilo(String nome, String identificatore){
		super("profilo_" + nome, ".txt", identificatore);
		//se il file è vuoto, scrivo l'intestazione:
		if (leggiLineaX(0).equals("ERRORE")){
			//scrivo l'intestazine senza memorizzarla su file
			profilo.addElement("[*]-[*]-[*]    P R O F I L O   [*]-[*]-[*]");
			profilo.addElement("giocatore: " + nome + " ( # " + identificatore + " )");
			profilo.addElement("");
			profilo.addElement("PARTITE GIOCATE: 0");
			profilo.addElement("");
		}
		else{ //se il file esiste gia'
			//inserisce nel vettore profilo, i dati contenuti nel file di profilo
			profilo = trasformaInVettore();
		}
	}

	/**
	 * Costruttore a 3 parametri che inizializza il vettore contenente il log della
	 * partita. Questo costruttore, non salva su file il profilo.
	 *  @param nome nome del giocatore
	 * @param log_partita vettore contenente il log della partita
     * @param identificatore stringa contenente l'identificativo univoco del giocatore
     */
	public GestisceFileProfilo(String nome, Vector<String> log_partita, String identificatore) throws FileNotFoundException{
		super(nome, ".txt", identificatore);
		id=0;
		//abbino al profilo il file di log del giocatore
		log = log_partita;
		//cancello il contenuto del file e scrivo la nuova intestazione
		scriviIntestazione();
	}
	
	
	/**
	 * Costruttore a 3 parametri che inizializza il vettore contenente il profilo e memorizza, all'interno
	 * di un file, il suo contenuto
	 *  @param nome nome del giocatore
	 * @param identificatore stringa rappresentante l'identificativo del giocatore
     * @param log_partita vettore contenente tutti i log di un giocatore
     */
	public GestisceFileProfilo(String nome, String identificatore, boolean ia, Vector<String> log_partita) throws FileNotFoundException{
		super("profilo_" + nome, ".txt", identificatore);
		
		/* ************************ Cercare sul DB il giocatore tramite nome
		 * 
		 */
		if(!ia)
			//id= Integer.parseInt(identificatore);
		System.out.println("*********** GestFileProf. ID="+id);
		
		
		//abbino al profilo il file di log del giocatore
		log = log_partita;
		//se il file è vuoto, scrivo l'intestazione:
		if (leggiLineaX(0).equals("ERRORE")){
			scriviIntestazione();
		}
		else{ //se il file esiste gia'
			//inserisce nel vettore profilo, i dati contenuti nel file di profilo
			profilo = trasformaInVettore();
			//memorizzo che il file del profilo e' stato gia' inizializzato con dei valori
			nuovo = false;
		}
	}

	/**
	 * Metodo a due parametri che permette di scrivere l'intestazione del file contenente il profilo di un giocatore
	 *
     */
	private void scriviIntestazione() {
		/*
		
		profilo.addElement("[*]-[*]-[*]    P R O F I L O   [*]-[*]-[*]");
		profilo.addElement("giocatore: " + nome + " ( # " + identificatore + " )");
//		System.out.println("NOME: "+nome+" ID: "+identificatore);
		profilo.addElement("");
		profilo.addElement("PARTITE GIOCATE: 0");
		profilo.addElement("");
		//scrivo sul file il vettore
		scriviVettore(profilo,true);
		//memorizzo che il file del profilo e' nuovo
		  
		*/
		
		nuovo = true;
	}
	
	/**
	 * Metodo con due parametri che permette di generare un profilo utente a partire da un file di log
	 * Con questo metodo e' possibile selezionare arbitrariamente le partite da prendere in esame
	 * per generare il file di log.
	 * 
	 * @param inizio indica il numero di partite che non verranno considerata a partire dall'inizio del
	 * file di log
	 * @param fine indica il numero di partite che non verranno considerare a partire dalla fine del file
	 * di log
	 */
	public void aggiornaProfiloParzialmente(int inizio, int fine) throws FileNotFoundException{
		//creo un vettore di stringhe contenente le varie parole del rigo numero uno del file di log
		Vector<String> rigo_numero_partite = dividiTesto(log.get(3));
		//calcolo quante partite ho gia' giocato
		int partite_giocate = Integer.parseInt(rigo_numero_partite.get(2));
		//scorro tutte le partite presenti nel file di log, prendendo in esame solo quelle da me scelte
		for (int indice = fine; indice > inizio; indice--){
			//memorizzo la riga della prima partita presente nel file di log
			int riga_partita = Integer.parseInt(dividiTesto(log.get(indice+4)).get(4));
			//creo un vettore temporaneo per memorizzare i risultati della partita
			Vector<String> risultati_partita = new Vector<String>();
			//chiamo la funzione per controllare la disposizione iniziale dei pezzi
			//e memorizzo il risultato in un vettore temporaneo
			risultati_partita.addAll(disposizioneInizialePezzi(riga_partita));
			//chiamo la funzione per controllare chi ha mosso per primo e memorizzo
			//il risultato in un vettore temporaneo. che fine
			risultati_partita.addElement(posizionePrimaMossa(riga_partita));
			//chiamo la funzione per controllare chi ha mosso per secondo e memorizzo
			//il risultato in un vettore temporaneo
			risultati_partita.addElement(posizioneSecondaMossa(riga_partita));
			//memorizzo la matrice contenente il numero ed il tipo dei spostamenti dei pezzi
			int[][] matrice_temp = spostamentiNellaPartita(riga_partita);
			//aggiungo le tre linee al profilo
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 0));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 1));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 2));
			//memorizzo la matrice contenente tutte le caratteristiche dinamiche dei pezzi
			//(mangia se minacciato, scappa se minacciato, rimane fermo se minacciato,
			// minaccia pezzi avversari)
			int[][] matrice_dinamica = dinamicaDiGioco(riga_partita);
			//aggiungo le quattro linee al profilo
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 0));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 1));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 2));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 3));
			//memorizzo sul file il risultato della partita
			salvaSuFile(risultati_partita);
		}
	}
	
	/**
	 * Metodo senza parametri che permette di generare un profilo utente a partire da un file di log.
	 */
	public void aggiornaProfilo() {
		//se il file e' nuovo
		if (nuovo){
			//creo un vettore di stringhe contenente le varie parole del rigo numero uno del file di log
			Vector<String> rigo_numero_partite = dividiTesto(log.get(3));
			
			/*
			//calcolo quante partite ho gia' giocato
			int partite_giocate = Integer.parseInt(rigo_numero_partite.get(2));
			//scorro tutte le partite presenti nel file di log
			for (int x = partite_giocate; x>0; x--){
				//memorizzo la riga della prima partita presente nel file di log
				int riga_partita = Integer.parseInt(dividiTesto(log.get(x+4)).get(4));
				//creo un vettore temporaneo per memorizzare i risultati della partita
				Vector<String> risultati_partita = new Vector<String>();
				//chiamo la funzione per controllare la disposizione iniziale dei pezzi
				//e memorizzo il risultato in un vettore temporaneo
				risultati_partita.addAll(disposizioneInizialePezzi(riga_partita));
				//chiamo la funzione per controllare chi ha mosso per primo e memorizzo
				//il risultato in un vettore temporaneo. che fine
				risultati_partita.addElement(posizionePrimaMossa(riga_partita));
				//chiamo la funzione per controllare chi ha mosso per secondo e memorizzo
				//il risultato in un vettore temporaneo
				risultati_partita.addElement(posizioneSecondaMossa(riga_partita));
				//memorizzo la matrice contenente il numero ed il tipo dei spostamenti dei pezzi
				int[][] matrice_temp = spostamentiNellaPartita(riga_partita);
				//aggiungo le tre linee al profilo
				risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 0));
				risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 1));
				risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 2));
				//memorizzo la matrice contenente tutte le caratteristiche dinamiche dei pezzi
				//(mangia se minacciato, scappa se minacciato, rimane fermo se minacciato,
				// minaccia pezzi avversari)
				int[][] matrice_dinamica = dinamicaDiGioco(riga_partita);
				//aggiungo le quattro linee al profilo
				risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 0));
				risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 1));
				risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 2));
				risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 3));
				//memorizzo sul file il risultato della partita
				salvaSuFile(risultati_partita);
			}
				*/
		}
		else{ //il file esisteva gia'
			/*
			//aggiorno il profilo leggendo i dati dell'ultima partita fatta
			int riga_ultima_partita = Integer.parseInt(dividiTesto(log.get(5)).get(4));
			//creo un vettore temporaneo per memorizzare i risultati della partita
			Vector<String> risultati_partita = new Vector<String>();
			//chiamo la funzione per controllare la disposizione iniziale dei pezzi
			//e memorizzo il risultato in un vettore temporaneo
			risultati_partita.addAll(disposizioneInizialePezzi(riga_ultima_partita));
			//chiamo la funzione per controllare chi ha mosso per primo e memorizzo
			//il risultato in un vettore temporaneo
			risultati_partita.addElement(posizionePrimaMossa(riga_ultima_partita));
			//chiamo la funzione per controllare chi ha mosso per secondo e memorizzo
			//il risultato in un vettore temporaneo
			risultati_partita.addElement(posizioneSecondaMossa(riga_ultima_partita));
			//memorizzo la matrice contenente il numero ed il tipo dei spostamenti dei pezzi
			int[][] matrice_temp = spostamentiNellaPartita(riga_ultima_partita);
			//aggiungo le quattro linee al profilo
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 0));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 1));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_temp, 2));
			//memorizzo la matrice contenente tutte le caratteristiche dinamiche dei pezzi
			//(mangia se minacciato, scappa se minacciato, rimane fermo se minacciato,
			// minaccia pezzi avversari)
			int[][] matrice_dinamica = dinamicaDiGioco(riga_ultima_partita);
			//aggiungo le quattro linee al profilo
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 0));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 1));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 2));
			risultati_partita.addElement(trasformaLineaMatriceInStringa(matrice_dinamica, 3));
			//memorizzo sul file il risultato della partita
			salvaSuFile(risultati_partita);
			*/
		}
	}
	
	/**
	 * Metodo ad un parametro che permette di generare un vettore di stringhe contenente la disposizione
	 * iniziale di tutti i pezzi.
	 * 
	 * @param num_riga rappresenta il numero della riga della partita di cui si
	 * vuole estrapolare il risultato
	 * 
	 * @return Vector<String> vettore di grandezza 8 contenente la disposizione iniziale di tutti i pezzi
	 */
	private Vector<String> disposizioneInizialePezzi(int num_riga){
		//distinguo i vari casi di partenza
		byte caso = determinaPosizionePartenza(log.get(num_riga+1),identificativo_giocatore);
		//creo un vettore temporaneo che contienre il risultato di una partita
		Vector<String> risultato_partita = new Vector<String>();
		//distinguo i vari casi di partenza
		if ( caso == 1 ){
			//scorro tutte le posizioni
			for(int posizione=0; posizione<8; posizione++){
				//memorizzo il numero del pezzo
				byte num_pezzo = ottieniPezzo(log.get(num_riga + 3 + posizione));
				//creo la linea di log di quel pezzo
				String rigo_log = scriviRiga(num_pezzo);
				//inserisco la stringa nel risultato
				risultato_partita.add(rigo_log);
			}
		}
		else{ //caso == 2
			//scorro tutte le posizioni
			for(int posizione=15; posizione>7; posizione--){
				//memorizzo il numero del pezzo
				byte num_pezzo = ottieniPezzo(log.get(num_riga + 3 + posizione));
				//creo la linea di log di quel pezzo
				// il "-10" serve per standardizzare la creazione del file di log
				String rigo_log = scriviRiga(num_pezzo - 10);
				//inserisco la stringa nel risultato
				risultato_partita.add(rigo_log);
			}
		}
		return risultato_partita;
	}
	
	/**
	 * Metodo ad un parametro che crea una stringa di lunghezza 8, conentente sette 0 ed un 1 nella posizione indicata
	 * nel parametro
	 * 
	 * @param posizione posizione dell'1 all'interno della stringa di 8 caratteri
	 * 
	 * @return stringa di caratteri
	 */
	private static String scriviRiga(int posizione){
		String risultato = "";
		//inizializzo la stringa, inserendo in "posizione" il valore 1
		for (int i=0; i<8; i++){
			if (i==posizione)
				risultato = risultato + "1 ";
			else
				risultato = risultato + "0 ";
		}
		return risultato;
	}
	
	/**
	 * Metodo con due parametri che permette di stabilire in che posizione e' partito il giocatore
	 * inserito nel parametro
	 * 
	 * @param riga rappresenta la linea d'intestazione della partita 
	 * @param ident_giocatore rappresenta l'identificativo del giocatore del quale si vuole sapere
	 * dov'e' la posizione di partenza
	 * 
	 * 
	 * @return byte indicante la posizione del giocatore descritto nel parametro ident_giocatore:
	 * 1 se e' situato nella posizione 1, 2 se e' situato nella posizione 2
	 */
	public static byte determinaPosizionePartenza(String riga, String ident_giocatore){
		//vedo se ha iniziato il giocatore in esame
		String giocatore_iniziale = dividiTesto(riga).get(6);
		//memorizzo in che posizione e' partito
		int posizione_giocatore = Integer.parseInt(dividiTesto(riga).get(11));
		//distinguo i vari casi di partenza
		byte caso = 1;
		if ( (giocatore_iniziale.equals(ident_giocatore) && posizione_giocatore == 2) ||
				(!giocatore_iniziale.equals(ident_giocatore) && posizione_giocatore == 1) )
			caso = 2;
		return caso;
	}
	
	/**
	 * Metodo ad un parametro che permette di determinare se il giocatore rappresentato nel profilo,
	 * ha iniziato la partita
	 * 
	 * @param riga rappresenta la linea d'intestazione della partita 
	 * @param ident_giocatore rappresenta l'identificativo del giocatore del quale si vuole sapere
	 * se ha iniziato la partita
	 * 
	 * 
	 * @return 0 se il giocatore che inizia la partita e' il giocatore in esame, 1 altrimenti
	 */
	public static byte determinaCasoPartenza(String riga, String ident_giocatore){
		//memorizzo il giocatore che ha iniziato a giocare
		String giocatore_iniziale = dividiTesto(riga).get(6);
		//vedo se ha iniziato il giocatore in esame
		if ( giocatore_iniziale.equals(ident_giocatore) )
			return 0;
		return 1;
	}
	
	/**metodo con un parametro che restituisce un vettore di double che rappresenta
	 * il profilo medio dei pezzi buoni o cattivi
	 * 
	 * @param buoni indica se il vettore che voglio calcolare, riguarda i pezzi buoni o cattivi
	 * 
	 * @return Vector<Double> profilo medio dei pezzi buoni/cattivi
	 */ 
	public Vector<Double> mediaVettori(boolean buoni){
		//creo un vettore di stringhe contenente le varie parole del rigo numero uno del file di log
		Vector<String> rigo_numero_partite = dividiTesto(profilo.get(3));
		//calcolo quante partite ho gia' giocato
		int partite_giocate = Integer.parseInt(rigo_numero_partite.get(2));
		//se non ho giocato nessuna partita, ritorno null
		if (partite_giocate == 0)
			return null;
		//creo un vettore in cui 'fondere' tutti i vettori del profilo
		Vector<Double> risultato = new Vector<Double>();
		//inizializzo il vettore con un numero di elementi neutri (0) pari al numero di regole
		//fissate nel profilo
		for (int indice=0; indice<17; indice++)
			risultato.addElement((double)0);
		//scorro tutte le partite presenti nel file di log
		for ( int partita=0; partita<partite_giocate; partita++){
			//memorizzo la riga della partita presa in considerazione nel profilo
			int riga_partita = Integer.parseInt(dividiTesto(profilo.get(partita+5)).get(4));
			//scorro tutte le righe del profilo
			for (int riga=0; riga<8; riga++){
				//creo la stringa che devo prendere in esame
				String stringa_riga = profilo.get(riga_partita+1+riga);
				//trasformo la stringa in vettore
				Vector<String> vettore_riga = dividiTesto(stringa_riga);
				//scorro i quattro vettori di cui voglio fare la media (o i quattro vettori dei pezzi buoni
				//o i quattro vettori dei pezzi cattivi)
				if(buoni){
					for (int vettore=0; vettore<4; vettore++){
						Double nuovo_valore = Double.parseDouble(vettore_riga.get(vettore));
						nuovo_valore = nuovo_valore + risultato.get(riga);
						risultato.setElementAt(nuovo_valore, riga);
					}
				}
				else{
					for (int vettore=4; vettore<8; vettore++){
						Double nuovo_valore = Double.parseDouble(vettore_riga.get(vettore));
						nuovo_valore = nuovo_valore + risultato.get(riga);
						risultato.setElementAt(nuovo_valore, riga);
					}
				}
			}
		}
		//divido ogni elemento del risultato per il numero totale di partite
		for (int indice=0; indice<risultato.size(); indice++){
			//creo il nuovo valore
			Double nuovo_valore = risultato.get(indice) / partite_giocate;
			//inserisco il nuovo valore al posto di quello vecchio
			risultato.setElementAt(nuovo_valore, indice);
		}
		return risultato;
	}

	/**
	 * Metodo ad un parametro che determina quale pezzo ha mosso per primo
	 * 
	 * @param num_riga rappresenta il numero della riga della partita di cui si
	 * vuole estrapolare il risultato
	 * 
	 * @return Stringa rappresentante il pezzo che ha effettuato la prima mossa
	 */
	private String posizionePrimaMossa(int num_riga){
		//determino quale giocatore ha iniziato la partita
		byte partenza = determinaCasoPartenza(log.get(num_riga+1),identificativo_giocatore);
		//determino qual'e' la posizione del primo pezzo mosso
		byte posizione = ottieniPartenza(log.get(num_riga+21+partenza)).getPosizione();
		//determinto qual'è il pezzo che si e' mosso per primo
		if (determinaPosizionePartenza(log.get(num_riga+1),identificativo_giocatore) == 1){
			//memorizzo il numero del pezzo che ho mosso per primo
			byte pezzo_mosso = ottieniPezzo(log.get(num_riga+2+posizione));
			return scriviRiga(pezzo_mosso);
		}
		else{ //determinaPosizionePartenza(log.get(num_riga+1)) == 2
			//memorizzo il numero del pezzo che ho mosso per primo
			byte pezzo_mosso = (byte) (ottieniPezzo(log.get(num_riga+(19-posizione))) - 10);
			return scriviRiga(pezzo_mosso);
		}
	}

	/**
	 * Metodo ad un parametro che determina quale pezzo ha mosso per secondo
	 * 
	 * @param num_riga rappresenta il numero della riga della partita di cui si
	 * vuole estrapolare il risultato
	 * 
	 * @return Stringa rappresentante il pezzo che ha effettuato la seconda mossa
	 */
	private String posizioneSecondaMossa(int num_riga){
		//determino quale giocatore ha iniziato la partita
		byte partenza = determinaCasoPartenza(log.get(num_riga+1),identificativo_giocatore);
		//determino qual'e' la posizione del secondo pezzo mosso
		byte posizione = ottieniPartenza(log.get(num_riga+23+partenza)).getPosizione();
		//controllo se e' stato mosso lo stesso pezzo che e' stato spostato nella prima mossa
		if (posizione == -1){
			//memorizzo la posizione di partenza che aveva il primo pezzo mosso
			posizione = ottieniPartenza(log.get(num_riga+21+partenza)).getPosizione();
		}
		//determinto qual'è il pezzo che si e' mosso per secondo
		if (determinaPosizionePartenza(log.get(num_riga+1),identificativo_giocatore) == 1){
			//memorizzo il numero del pezzo che ho mosso per secondo
			byte pezzo_mosso = ottieniPezzo(log.get(num_riga+2+posizione));
			return scriviRiga(pezzo_mosso);
		}
		else{ //determinaPosizionePartenza(log.get(num_riga+1)) == 2
			//memorizzo il numero del pezzo che ho mosso per secondo
			byte pezzo_mosso = (byte) (ottieniPezzo(log.get(num_riga+(19-posizione))) - 10);
			return scriviRiga(pezzo_mosso);
		}
	}
	
	/**
	 * metodo ad un parametro che permette di generare un matrice 3x8 che rappresenta il numero ed il tipo
	 * di spostamenti che ha fatto ogni singolo pezzo
	 * 
	 * @param num_riga rappresenta il numero della riga della partita di cui si
	 * vuole estrapolare il risultato
	 * 
	 * @return matrice 3x8 contenente il numero ed il tipo di spsotamenti che ha fatto ogni singolo pezzo
	 */
	private int[][] spostamentiNellaPartita(int num_riga){
		//memorizzo in che posizione e' partito
		int posizione_giocatore = determinaPosizionePartenza(log.get(num_riga+1),identificativo_giocatore);
		//creo una matrice contenente i risultati della ricerca
		//la matrice avra' tre righe (avanza, retrocede, si sposta lateralmente)
		//e 8 colonne (una per ogni pezzo del giocatore)
		int[][] risultato = new int[3][8];
		//distinguo i vari casi di partenza
		byte caso = determinaCasoPartenza(log.get(num_riga+1),identificativo_giocatore);
		if (posizione_giocatore == 1){
			//scorro tutti i pezzi del giocatore
			for (int i=0; i<8; i++){
				//memorizzo il numero del pezzo che ho preso in esame
				byte num_pezzo = ottieniPezzo(log.get(num_riga+3+i));
				//memorizzo la coordinata presa in esame
				Coordinata cor_in_esame = ottieniCoordinata(log.get(3+i+num_riga));
				//memorizzo la linea del log che sto prendendo in esame
				int linea_in_esame = 21+caso;
				//scorro tutta la partita
				while (linea_in_esame < rigaFinePartita(num_riga)){
					//se la coordinata in esame e' uguale alla coordinata del pezzo
					//che sto muovendo, controllo in che direzione si e' spostato il pezzo
					if (cor_in_esame.equals(ottieniPartenza(log.get(linea_in_esame+num_riga)))){
						//vedo se il pezzo e' avanzato
						if (cor_in_esame.avanza(ottieniArrivo(log.get(linea_in_esame+num_riga)), posizione_giocatore)){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[0][num_pezzo] = risultato[0][num_pezzo]+1;
						}
						//vedo se il pezzo e' indietreggiato
						if (cor_in_esame.indietreggia(ottieniArrivo(log.get(linea_in_esame+num_riga)), posizione_giocatore)){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[1][num_pezzo] = risultato[1][num_pezzo]+1;
						}
						//vedo se il pezzo si e' mosso lateramente
						if (cor_in_esame.mossoLateralmente(ottieniArrivo(log.get(linea_in_esame+num_riga)))){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[2][num_pezzo] = risultato[2][num_pezzo]+1;
						}
						cor_in_esame = ottieniArrivo(log.get(linea_in_esame+num_riga));		
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
				byte num_pezzo = (byte)(ottieniPezzo(log.get(18-i+num_riga)) - 10) ;
				//memorizzo la coordinata presa in esame
				Coordinata cor_in_esame = ottieniCoordinata(log.get(18-i+num_riga));
				//memorizzo la linea del log che sto prendendo in esame
				int linea_in_esame = 21+caso;
				//scorro tutta la partita
				while (linea_in_esame < rigaFinePartita(num_riga)){
					//se la coordinata in esame e' uguale alla coordinata del pezzo
					//che sto muovendo, controllo in che direzione si e' spostato il pezzo
					if (cor_in_esame.equals(ottieniPartenza(log.get(linea_in_esame+num_riga)))){
						//vedo se il pezzo e' avanzato
						if (cor_in_esame.avanza(ottieniArrivo(log.get(linea_in_esame+num_riga)), posizione_giocatore)){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[0][num_pezzo] = risultato[0][num_pezzo]+1;
						}
						//vedo se il pezzo e' indietreggiato
						if (cor_in_esame.indietreggia(ottieniArrivo(log.get(linea_in_esame+num_riga)), posizione_giocatore)){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[1][num_pezzo] = risultato[1][num_pezzo]+1;
						}
						//vedo se il pezzo si e' mosso lateramente
						if (cor_in_esame.mossoLateralmente(ottieniArrivo(log.get(linea_in_esame+num_riga)))){
							//in caso affermativo, aggiorno la matrice del risultato
							risultato[2][num_pezzo] = risultato[2][num_pezzo]+1;
						}
						cor_in_esame = ottieniArrivo(log.get(linea_in_esame+num_riga));
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
	 * metodo a due parametri che consente di trasformare una riga di una matrice in una stringa
	 * 
	 * @param matrice matrice della quale si vuole estrapolare il risultato
	 * @param num_riga numero della riga da trasformare in stringa
	 * 
	 * @return stringa contenente i valori della riga inserita nel parametro della funzione
	 */
	private static String trasformaLineaMatriceInStringa(int[][] matrice, int num_riga){
		String risultato = "";
		//scorro tutte le colonne della matrice tranne l'ultima
		for (int indice=0; indice<7; indice++){
			risultato = risultato + Integer.toString(matrice[num_riga][indice]) + " ";
		}
		//l'ultima colonna, la gestisco diversamente per non inserire lo spazio alla fine della stringa
		risultato = risultato + Integer.toString(matrice[num_riga][7]);
		return risultato;
	}
			
	/**
	 * metodo ad un parametro che, data la riga iniziale di una partita, ne determina la riga finale
	 * 
	 * @param riga_inizio_partita indica la riga in cui inizia la partita
	 * 
	 * @return rigo in cui la partita termina
	 */
    int rigaFinePartita(int riga_inizio_partita){
		int risultato = 21;
		//continuo ad incrementare il risultato finche' finisco il file
		//di log, o fin quando finisco la partita
		while ( (risultato + riga_inizio_partita < log.size()) &&
				(log.get(riga_inizio_partita + risultato).charAt(3) == ')' ) )
			risultato++;
		return risultato;
	}

	/**
	 * metodo ad un parametro che permete di ricreare la base logica di una partita partendo da un file di log
	 * 
	 * @param num_riga rappresenta il numero della riga della partita di cui si vuole estrapolare la
	 * base logica
	 * 
	 * @return pezzo[][] base logica della partita
	 * 
	 */
    Pezzo[][] generaTavolo(int num_riga){
		//creo la matrice che conterra' il risultato
		Pezzo[][] risultato = new Pezzo[6][6];
		//inizializzo la matrice con i giusti valori
		risultato[0][1] = new Pezzo(ottieniCoordinata(log.get(num_riga+3)), (byte)1, ottieniPezzo(log.get(num_riga+3)), risultato);
		risultato[0][2] = new Pezzo(ottieniCoordinata(log.get(num_riga+4)), (byte)1, ottieniPezzo(log.get(num_riga+4)), risultato);
		risultato[0][3] = new Pezzo(ottieniCoordinata(log.get(num_riga+5)), (byte)1, ottieniPezzo(log.get(num_riga+5)), risultato);
		risultato[0][4] = new Pezzo(ottieniCoordinata(log.get(num_riga+6)), (byte)1, ottieniPezzo(log.get(num_riga+6)), risultato);
		risultato[1][1] = new Pezzo(ottieniCoordinata(log.get(num_riga+7)), (byte)1, ottieniPezzo(log.get(num_riga+7)), risultato);
		risultato[1][2] = new Pezzo(ottieniCoordinata(log.get(num_riga+8)), (byte)1, ottieniPezzo(log.get(num_riga+8)), risultato);
		risultato[1][3] = new Pezzo(ottieniCoordinata(log.get(num_riga+9)), (byte)1, ottieniPezzo(log.get(num_riga+9)), risultato);
		risultato[1][4] = new Pezzo(ottieniCoordinata(log.get(num_riga+10)), (byte)1, ottieniPezzo(log.get(num_riga+10)), risultato);
		risultato[4][1] = new Pezzo(ottieniCoordinata(log.get(num_riga+11)), (byte)2, ottieniPezzo(log.get(num_riga+11)), risultato);
		risultato[4][2] = new Pezzo(ottieniCoordinata(log.get(num_riga+12)), (byte)2, ottieniPezzo(log.get(num_riga+12)), risultato);
		risultato[4][3] = new Pezzo(ottieniCoordinata(log.get(num_riga+13)), (byte)2, ottieniPezzo(log.get(num_riga+13)), risultato);
		risultato[4][4] = new Pezzo(ottieniCoordinata(log.get(num_riga+14)), (byte)2, ottieniPezzo(log.get(num_riga+14)), risultato);
		risultato[5][1] = new Pezzo(ottieniCoordinata(log.get(num_riga+15)), (byte)2, ottieniPezzo(log.get(num_riga+15)), risultato);
		risultato[5][2] = new Pezzo(ottieniCoordinata(log.get(num_riga+16)), (byte)2, ottieniPezzo(log.get(num_riga+16)), risultato);
		risultato[5][3] = new Pezzo(ottieniCoordinata(log.get(num_riga+17)), (byte)2, ottieniPezzo(log.get(num_riga+17)), risultato);
		risultato[5][4] = new Pezzo(ottieniCoordinata(log.get(num_riga+18)), (byte)2, ottieniPezzo(log.get(num_riga+18)), risultato);
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
	
	/**
	 * metodo ad un parametro che permette di generare una matrice 4x8 che rappresenta il tipo di azioni
	 * intraprese da tutti i pezzi durante lo svolgimento di una partita
	 * 
	 * @param num_riga rappresenta il numero del della riga della partita di cui si vuole estrapolare il risultato
	 * 
	 * @return matrice 4x8 contenente il numero ed il tipo di azioni intraprese dai pezzi durante
	 * lo svolgimento di una partita
	 */
	private int[][] dinamicaDiGioco(int num_riga){
		//memorizzo in che posizione e' partito
		int posizione_giocatore = determinaPosizionePartenza(log.get(num_riga+1),identificativo_giocatore);
		//distinguo i vari casi di partenza
		byte caso = determinaCasoPartenza(log.get(num_riga+1),identificativo_giocatore);
		//creo un tavolo di gioco dove simulare la partita
		Tavolo tav = new Tavolo(generaTavolo(num_riga));
		//creo la matrice dei pezzi del giocatore prima d'iniziare la partita
		MatricePezzi matrice = new MatricePezzi((Tavolo)tav.clone(), posizione_giocatore);
		//se la prima mossa spetta all'avversario, aggiorno la matrice dei pezzi
		if (caso == 1){
			//memorizzo la coordinata di partenza del pezzo avversario
			Coordinata partenza = ottieniPartenza(log.get(num_riga+21));
			//memorizzo la coordinata di arrivo del pezzo avversario
			Coordinata arrivo = ottieniArrivo(log.get(num_riga+21));
			//eseguo la mossa sul tavolo
			tav.muoviPezzo(partenza, arrivo);
			//aggiorno la matrice dei pezzi
			matrice = new MatricePezzi((Tavolo)tav.clone(), posizione_giocatore);
		}
		//creo la matrice che conterra' il risultato
		// 4 sono le righe delle varie opzioni da tener conto nei pezzi:
		// riga 0: mangia se minacciato
		// riga 1: scappa se minacciato
		// riga 2: sta fermo se minacciato
		// riga 3: minaccia
		// 8 sono gli otto pezzi del giocatore
		int[][] risultato = new int[4][8];
		//memorizzo la linea del log che sto prendendo in esame
		int linea_in_esame = 21 + caso;
		//memorizzo il numero di mosse eseguite
		boolean turno_avversario = false;
		//scorro tutta le mosse fatte durante la partita
		while (linea_in_esame < rigaFinePartita(num_riga)){
			//controllo di chi e' il turno
			if (turno_avversario){
				//memorizzo la coordinata di partenza del pezzo avversario
				Coordinata partenza = ottieniPartenza(log.get(num_riga+linea_in_esame));
				//memorizzo la coordinata di arrivo del pezzo avversario
				Coordinata arrivo = ottieniArrivo(log.get(num_riga+linea_in_esame));
				//eseguo la mossa sul tavolo
				tav.muoviPezzo(partenza, arrivo);
				//creo la nuova matrice dei pezzi
				MatricePezzi nuova_matrice = new MatricePezzi((Tavolo)tav.clone(), posizione_giocatore);
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
			Coordinata partenza = ottieniPartenza(log.get(num_riga+linea_in_esame));
			//memorizzo la coordinata di arrivo del mio pezzo
			Coordinata arrivo = ottieniArrivo(log.get(num_riga+linea_in_esame));
			//eseguo la mossa sul tavolo
			tav.muoviPezzo(partenza, arrivo);
			//creo la nuova matrice dei pezzi
			MatricePezzi nuova_matrice = new MatricePezzi((Tavolo)tav.clone(), posizione_giocatore);
			//distiunguo i due casi di partenza
			if (posizione_giocatore == 1){
				//scorro tutti i pezzi buoni
				for (int i=0; i<tav.vettorePezzi((byte)1).size(); i++){
					//ricavo il pezzo che ho mosso
					Pezzo pezzo_mosso = tav.vettorePezzi((byte)1).get(i);
					//estrapolo il numero del pezzo
					int num_pezzo = pezzo_mosso.getNumero();
					//vedo se il pezzo soddisfa la carattaristica 'mangia se minacciato'
					if (matrice.mangiaSeMinacciato(pezzo_mosso)){
						risultato[0][num_pezzo] = risultato[0][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'scappa se minacciato'
					if (matrice.scappaSeMinacciato(pezzo_mosso)){
						risultato[1][num_pezzo] = risultato[1][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'rimane fermo se minacciato'
					if (matrice.fermoSeMinacciato(pezzo_mosso)){
						risultato[2][num_pezzo] = risultato[2][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'minaccia pezzi avversari'
					if (matrice.minacciaPezzoAvversario(nuova_matrice, pezzo_mosso)){
						risultato[3][num_pezzo] = risultato[3][num_pezzo] + 1;
					}
				}
				//scorro tutti i pezzi cattivi
				for (int i=0; i<tav.vettorePezzi((byte)2).size(); i++){
					//ricavo il pezzo che ho mosso
					Pezzo pezzo_mosso = tav.vettorePezzi((byte)2).get(i);
					//estrapolo il numero del pezzo
					int num_pezzo = pezzo_mosso.getNumero();
					//vedo se il pezzo soddisfa la carattaristica 'mangia se minacciato'
					if (matrice.mangiaSeMinacciato(pezzo_mosso)){
						risultato[0][num_pezzo] = risultato[0][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'scappa se minacciato'
					if (matrice.scappaSeMinacciato(pezzo_mosso)){
						risultato[1][num_pezzo] = risultato[1][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'rimane fermo se minacciato'
					if (matrice.fermoSeMinacciato(pezzo_mosso)){
						risultato[2][num_pezzo] = risultato[2][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'minaccia pezzi avversari'
					if (matrice.minacciaPezzoAvversario(nuova_matrice, pezzo_mosso)){
						risultato[3][num_pezzo] = risultato[3][num_pezzo] + 1;
					}
				}
			}
			else{ //posizione_giocatore == 2
				//scorro tutti i pezzi buoni
				for (int i=0; i<tav.vettorePezzi((byte)3).size(); i++){
					//ricavo il pezzo che ho mosso
					Pezzo pezzo_mosso = tav.vettorePezzi((byte)3).get(i);
					//estrapolo il numero del pezzo modulo 10 (in questo modo posso usare la matrice 4x8,
					//usanod come indice, il numero del pezzo)
					int num_pezzo = pezzo_mosso.getNumero()%10;
					//vedo se il pezzo soddisfa la carattaristica 'mangia se minacciato'
					if (matrice.mangiaSeMinacciato(pezzo_mosso)){
						risultato[0][num_pezzo] = risultato[0][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'scappa se minacciato'
					if (matrice.scappaSeMinacciato(pezzo_mosso)){
						risultato[1][num_pezzo] = risultato[1][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'rimane fermo se minacciato'
					if (matrice.fermoSeMinacciato(pezzo_mosso)){
						risultato[2][num_pezzo] = risultato[2][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'minaccia pezzi avversari'
					if (matrice.minacciaPezzoAvversario(nuova_matrice, pezzo_mosso)){
						risultato[3][num_pezzo] = risultato[3][num_pezzo] + 1;
					}
				}
				//scorro tutti i pezzi cattivi
				for (int i=0; i<tav.vettorePezzi((byte)4).size(); i++){
					//ricavo il pezzo che ho mosso
					Pezzo pezzo_mosso = tav.vettorePezzi((byte)4).get(i);
					//estrapolo il numero del pezzo modulo 10 (in questo modo posso usare la matrice 4x8,
					//usanod come indice, il numero del pezzo)
					int num_pezzo = pezzo_mosso.getNumero()%10;
					//vedo se il pezzo soddisfa la carattaristica 'mangia se minacciato'
					if (matrice.mangiaSeMinacciato(pezzo_mosso)){
						risultato[0][num_pezzo] = risultato[0][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'scappa se minacciato'
					if (matrice.scappaSeMinacciato(pezzo_mosso)){
						risultato[1][num_pezzo] = risultato[1][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'rimane fermo se minacciato'
					if (matrice.fermoSeMinacciato(pezzo_mosso)){
						risultato[2][num_pezzo] = risultato[2][num_pezzo] + 1;
					}
					//vedo se il pezzo soddisfa la caratteristica 'minaccia pezzi avversari'
					if (matrice.minacciaPezzoAvversario(nuova_matrice, pezzo_mosso)){
						risultato[3][num_pezzo] = risultato[3][num_pezzo] + 1;
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
	 * metodo ad un parametro che restituisce la copia di un vettore
	 * 
	 * @param originale vettore del quale si vuole fare una copia
	 * 
	 * @return clone del vettore passato come parametro
	 */
	public static Vector<Coordinata> copiaVettore(Vector<Coordinata> originale){
		//se l'originale e' null, ritorno null
		if (originale == null)
			return null;
		//creo il vettore che contera' il risultato
		Vector<Coordinata> copia = new Vector<Coordinata>();
		//scorro tutti i valori del vettore originale
        for (Coordinata anOriginale : originale)
            copia.add((Coordinata) anOriginale.clone());
		return copia;
	}
	
	/**
	 * Metodo ad un parametro che permette di scrivere su file il vettore di vettori di array
	 * 
	 * @param statistiche e' il vettore di vettori di array che si vuole scrivere su file
	 */
	public void salvaStatisticheSuFile(Vector<Vector<int[]>> statistiche, Vector<String> stat_riassuntive) throws FileNotFoundException{
		//creo il vettore di stringhe che conterra' il risultato
		Vector<String> risultato = new Vector<String>();
		//creo l'intestazione
		risultato.add("[*]-[*]-[*]    S T A T I S T I C H E   [*]-[*]-[*]");
		risultato.add("giocatore: " + nome_file );
		risultato.add("");
		//memorizzo quante partite ho giocato
		int partite_giocate = statistiche.size();
		risultato.add("PARTITE ESAMINATE: " + partite_giocate);
		risultato.add("");
		//inserisco tanti righi vuoti quante saranno le righe dell'indice delle partite da inserire
        for (Vector<int[]> aStatistiche : statistiche) {
            risultato.add("");
        }
		risultato.add("");
		//scorro tutte le partite
		for (int partita=0; partita<partite_giocate; partita++){
			//memorizzo a che posizione sto inserendo le statistiche
			int rigo_statistiche = risultato.size();
			//creo la stringa da inserire nel vettore del risultato
			String stringa_temp = "Partita " + Integer.toString(partita+1) + " : riga " + rigo_statistiche;
			//inserisco l'informazione del risultato
			risultato.setElementAt( stringa_temp, 5+partita);
			//inserisco il numero della partita
			risultato.add("PARTITA NUMERO... " + Integer.toString(partita+1));
			//scorro tutte le mosse di una singola partita			
			for (int mossa=0; mossa<statistiche.get(partita).size(); mossa++){
				//memorizzo il profilo di tutti gli otto pezzi
				String stat_rigo = trasformaArrayInStringa(statistiche.get(partita).get(mossa));
				risultato.add("mossa " + Integer.toString(mossa+1) + " : " + stat_rigo);
			}
			//aggiungo delle righe vuote
			risultato.add("");
			risultato.add("");
		}
		risultato.addAll(stat_riassuntive);
		scriviVettore(risultato, false);
	}
	
	/**
	 * Metodo ad un aprametro che, dato un aray di input, ritorna una stringa contenente i valori contenuti
	 * nell'array
	 * 
	 * @param array array che si vuole trasformare in stringa
	 * 
	 * @return stringa che contiene i valori contenuti all'interno dell'array
	 */
	private static String trasformaArrayInStringa(int[] array){
		//creo una variabile locale per contenere il risultato
		String risultato = "";
		//scorro tutto l'array
		for (int indice=0; indice<8; indice++){
			risultato = risultato + " " + array[indice];
		}
		return risultato;
	}
	
	/** Questa classe ha lo scopo di rappresentare in modo esaustivo tutte le mosse fattibili e tutti
	 * i pezzi mangiabili di tutti i pezzi di un giocatore
	 */
	public static class MatricePezzi{
		/** matrice a tre dimensioni i cui campi rappresentano rispettivamente: <p>
		 * campo 1: numero del pezzo in questione <p>
		 * campo 2: informazioni del pezzo (0 per mosse_fattibili e 1 per coordinate_pezzi_mangiabili) <p>
		 * campo 3: array con le coordinate di mosse fattibili o pezzi mangiabili [massimo valore che può assumere il valore di mosse_fattibili e coordinate_pezzi_mangiabili] <p>
		 */
		private Coordinata[][][] matrice = new Coordinata[8][2][4];
		/** rappresenta il tavolo su cui si svolte la partita*/
		private Tavolo tav;
		
		/**
		 * Costruttore a due parametri che permette di inizializzare correttamente tutti i campi dati
		 * della classe MatricePezzi
		 * 
		 * @param t tavolo su cui si svolge la partita
		 * @param giocatore giocatore del quale voglio generare la matrice
		 */
		public MatricePezzi(Tavolo t, int giocatore){
			//inizializzo la variabile tav
			tav = t;
			if (giocatore == 1){
				//scorro tutti i pezzi buoni del giocatore 1
				for (int i=0; i<tav.vettorePezzi((byte)1).size(); i++){
					//inizializzo la matrice
					setMosseFattibili(tav.vettorePezzi((byte)1).get(i));
					setPezziMangiabili(tav.vettorePezzi((byte)1).get(i));
				}
				//scorro tutti i pezzi cattivi del giocatore 1
				for (int i=0; i<tav.vettorePezzi((byte)2).size(); i++){
					//inizializzo la matrice
					setMosseFattibili(tav.vettorePezzi((byte)2).get(i));
					setPezziMangiabili(tav.vettorePezzi((byte)2).get(i));
				}
			}
			else{ //giocatore == 2
				//scorro tutti i pezzi buoni del giocatore 2
				for (int i=0; i<tav.vettorePezzi((byte)3).size(); i++){
					//inizializzo la matrice
					setMosseFattibili(tav.vettorePezzi((byte)3).get(i));
					setPezziMangiabili(tav.vettorePezzi((byte)3).get(i));
				}
				//scorro tutti i pezzi cattivi del giocatore 2
				for (int i=0; i<tav.vettorePezzi((byte)4).size(); i++){
					//inizializzo la matrice
					setMosseFattibili(tav.vettorePezzi((byte)4).get(i));
					setPezziMangiabili(tav.vettorePezzi((byte)4).get(i));
				}
			}
		}
		
		/**
		 * metodo ad un parametro che permette di inizializzare la parte di matrice inerente le mosse
		 * fattibili del pezzo passato come parametro.
		 * 
		 * @param p pezzo del quale voglio inserire i dati nella matrice
		 */
		private void setMosseFattibili(Pezzo p){
			//scorro tutte le mosse fattibili del pezzo
			for (int indice=0; indice<p.getMosseFattibili().size(); indice++){
				//memorizzo la coordinata nella giusta posizione
				matrice[p.getNumero()%10][0][indice] = p.getMosseFattibili().get(indice);
			}
		}
		
		/**
		 * metodo ad un parametro che permette di inizializzare la parte di matrice inerente i pezzi
		 * mangiabili dal pezzo passato come parametro.
		 * 
		 * @param p pezzo del quale voglio inserire i dati nella matrice
		 */
		private void setPezziMangiabili(Pezzo p){
			//scorro tutto il vettore dei pezzi mangiabili dal pezzo
			for (int indice=0; indice<p.getCoordinatePezziMangiabili().size(); indice++){
				//memorizzo la coordinata nella giusta posizione
				matrice[p.getNumero()%10][1][indice] = p.getCoordinatePezziMangiabili().get(indice);
			}
		}

		/**
		 * Metodo a due parametri che permette di determinare se un pezzo si e' mosso in seguito
		 * ad una minaccia del pezzo avversario, mangiando il pezzo che lo ha minacciato
		 * 
		 * @param p Pezzo del quale voglio sapere se si e' mosso in seguito ad una minaccia
		 * 
		 * @return true se il pezzo ha mangiato il pezzo che lo stava minacciando, false altrimenti
		 */
		public boolean mangiaSeMinacciato(Pezzo p){
			//controllo se il pezzo si e' mosso
			if (tav.getPezzo(p.getCoordinata()) == null || tav.getPezzo(p.getCoordinata()).getNumero()!=p.getNumero()){
				//se nella matrice vecchia non e' minacciato
				if (!minacciato(p.getNumero()))
					return false;
				else{ //nella matrice vecchia e' minacciato
					//memorizzo quali coordinate minacciavano il mio pezzo
					Vector<Coordinata> pezzi_minacciati = getVettore(1, p.getNumero()%10);
					//memorizzo il numero di pezzi minacciati
					int num_pezzi_minacciati;
					if (pezzi_minacciati == null)
						num_pezzi_minacciati = 0;
					else
						num_pezzi_minacciati = pezzi_minacciati.size();
					//scorro tutte le coordinate che minacciavano il mio pezzo
					for (int indice=0; indice<num_pezzi_minacciati; indice++){
						//se la coordinata del pezzo che minacciava, e' uguale alla coordinata del mio pezzo
						//vuol dire che ho mangiato il pezzo che mi minacciava
						if (pezzi_minacciati.get(indice).equals(p.getCoordinata()))
							return true;						
					}
					//se nessuna delle coordinate coincide con la coordinata attuale del pezzo, vuol dire che
					// ho mosso il pezzo da qualche altra parte
					return false;
				}
			}
			else{ //il pezzo e' rimasto fermo
				return false;				
			}
		}
		
		/**
		 * Metodo a due parametri che permette di determinare se un pezzo si e' mosso in seguito
		 * ad una minaccia del pezzo avversario, senza mangiare il pezzo che lo ha minacciato
		 * 
		 * @param p Pezzo del quale voglio sapere se  si e' mosso in seguito ad una minaccia
		 * 
		 * @return true se il pezzo e' scappato in seguito ad una minaccia di un pezzo avversario, false altrimenti
		 */
		public boolean scappaSeMinacciato(Pezzo p){
			//controllo se il pezzo si e' mosso
			if (tav.getPezzo(p.getCoordinata()) == null || tav.getPezzo(p.getCoordinata()).getNumero()!=p.getNumero()){
				//se nella matrice vecchia non e' minacciato
				if (!minacciato(p.getNumero()))
					return false;
				else{ //nella matrice vecchia e' minacciato
					//memorizzo quali coordinate minacciavano il mio pezzo
					Vector<Coordinata> pezzi_minacciati = getVettore(1, p.getNumero()%10);
					//memorizzo il numero di pezzi minacciati
					int num_pezzi_minacciati;
					//se nessun pezzo minacciava il mio pezzo, ritorno false
					if (pezzi_minacciati == null)
						return false;
					else
						num_pezzi_minacciati = pezzi_minacciati.size();
					//scorro tutte le coordinate che minacciavano il mio pezzo
					for (int indice=0; indice<num_pezzi_minacciati; indice++){
						//se la coordinata del pezzo che minacciava, e' uguale alla coordinata del mio pezzo
						//vuol dire che ho mangiato il pezzo che mi minacciava
						if (pezzi_minacciati.get(indice).equals(p.getCoordinata()))
							return false;						
					}
					//se nessuna delle coordinate coincide con la coordinata attuale del pezzo, vuol dire che
					// ho mosso il pezzo da qualche altra parte
					return true;
				}
			}
			else{ //il pezzo e' rimasto fermo
				return false;				
			}
		}
		
		/**
		 * Metodo ad un parametro che permette di determinare se un pezzo rimane fermo nonostante
		 * sia minacciato da un pezzo avversario
		 * 
		 * @param p Pezzo del quale voglio sapere se e' rimasto fermo nonostnate sia minacciato
		 * 
		 * @return true se il pezzo e' rimasto fermo nonostante fosse minacciato, false altrimenti
		 */
		public boolean fermoSeMinacciato(Pezzo p){
			//controllo se il pezzo si e' mosso
			if (tav.getPezzo(p.getCoordinata()) == null || tav.getPezzo(p.getCoordinata()).getNumero()!=p.getNumero()){
				return false;
			}
			else{ //il pezzo e' rimasto fermo
				//controllo se il pezzo era minacciato
                //il pezzo non era minacciato
                return minacciato(p.getNumero());
			}
		}
		
		/**
		 * Metodo a due parametri che permette di determinare se un mio pezzo, dopo aver
		 * effettuato una mossa, minaccia un pezzo avversario. Nel caso il pezzo minacciasse gia' 
		 * dei pezzi avversari, il metodo ritornera' true sole se i pezzi minacciati sono diversi
		 * da quelli minacciati prima di muovere
		 * 
		 * @param nuova indica la matricePezzi generata dopo aver mosso il pezzo
		 * @param p Pezzo del quale voglio sapere se, una volta spostato, minaccia nuovi pezzi
		 * 
		 * @return true se, dopo aver mosso, il pezzo minaccia dei pezzi avversari, false altrimenti
		 */
		public boolean minacciaPezzoAvversario(MatricePezzi nuova, Pezzo p){
			//controllo se il pezzo si e' mosso
			if (tav.getPezzo(p.getCoordinata()) == null || tav.getPezzo(p.getCoordinata()).getNumero()!=p.getNumero()){
				//memorizzo le coordinate minacciate prima e dopo lo spostamento
				Vector<Coordinata> mangiabili_vecchi = getVettore(1,p.getNumero()%10);
				Vector<Coordinata> mangiabili_nuovi = nuova.getVettore(1,p.getNumero()%10);
				//considero il caso in cui i vettori siano nulli (quindi che non ci siano pezzi mangiabili)
				if (mangiabili_vecchi == null  && mangiabili_nuovi == null)
					return false;
				//considero il caso in cui il vettore vecchio e' nullo e quello nuovo no
				if (mangiabili_vecchi == null && mangiabili_nuovi != null)
					return true;
				//considero il caso in cui il vettore nuovo e' nullo e quello vecchio no
				if (mangiabili_vecchi != null && mangiabili_nuovi == null)
					return false;
				//considero il caso in cui il vettore vecchio e' più piccolo del vettore nuovo
				if (mangiabili_vecchi.size() < mangiabili_nuovi.size())
					return true;
				//considero il vaso in cui il vettore vecchio e' piu' grande del vettore nuovo
				if (mangiabili_vecchi.size() > mangiabili_nuovi.size())
					return false;
				//se i due vettori hanno la stessa dimensione, devo vedere se i loro contenuti sono uguali
				return !mangiabili_vecchi.containsAll(mangiabili_nuovi);
			}
			else{ //il pezzo e' rimasto fermo
				return false;
			}
		}

		/**
		 * metodo a due parametri che mi permette di trasformare gli elementi della terza dimensione della matrice
		 * in un vettore ci coordinate
		 * 
		 * @param tipo e' il tipo di dato che voglio trasformare in vettore
		 * @param pezzo e' il pezzo del quale voglio avere le informazioni
		 * 
		 * @return vettore di coordinate contenenti i vari valori del pezzo in esame. Nell'eventualita' non ci
		 * fossero dati significativi, il risultato sarà uguale a null
		 */
		public Vector<Coordinata> getVettore(int tipo, int pezzo){
			//se non sono presenti valori, ritorno null
			if (matrice[pezzo][tipo][0] == null)
				return null;
			//creo il vettore del risultato
			Vector<Coordinata> risultato = new Vector<Coordinata>();
			//scorro tutti e 4 i possibili valori
			for (int indice=0; indice<4; indice++){
				//se il valore e' null, esco dal ciclo for
				if (matrice[pezzo][tipo][indice]==null){
					break;
				}
				else{
					risultato.addElement(matrice[pezzo][tipo][indice]);
				}					
			}
			return risultato;
		}
		
		/**
		 * Metodo ad un parametro che permette di determinare se un pezzo e' minacciato o meno
		 * 
		 * @param pezzo numero del pezzo del quale si vuole sapere se e' minacciato
		 * 
		 * @return true se il pezzo e' minacciato, false altrimenti
		 */
		private boolean minacciato(int pezzo){
			//un pezzo e' minacciato se a sua volta minaccia
            return matrice[pezzo % 10][1][0] != null;
        }
	}
	
	
}




