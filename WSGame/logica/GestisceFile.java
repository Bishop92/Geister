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

import java.io.*;
import java.util.Vector;
/**
 * <p>Questa classe ha la funzione di gestire i file, sia in lettura che in 
 * scrittura, raggruppando tutte le funzionalita' necessarie a manipolare in modo 
 * corretto i file.</p>
 * <p>&nbsp;</p>
 * <p>&nbsp;</p>
 * <p><u><i>elenco versioni:</i></u></p>
 * <p><i>ver. 2.5&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/11/2007</i></p>
 * <ul>
 *   <li>modificato metodo ottieniArrivo</li>
 * </ul>
 * <p><i>ver. 2.4&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 11/11/2007</i></p>
 * <ul>
 *   <li>modificate le eccezioni invocate</li>
 * </ul>
 * <p><i>ver. 2.3&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 10/11/2007</i></p>
 * <ul>
 *   <li>metodo ottieniPartenza modificato</li>
 *   <li>metodo ottieniArrivo modificato</li>
 *   <li>aggiunto il metodo ottieniCoodinata</li>
 *	 <li>aggiunto il metodo ottieniPezzo</li>
 * </ul>
 * <p><i>ver. 2.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 7/11/2007</i></p>
 * <ul>
 *   <li>aggiunto il metodo togliBianchi</li>
 *   <li>aggiunto il metodo dividiTesto</li>
 *   <li>modificata la visibilita' del campo dati identificativo_giocatore</li>
 * </ul>
 * <p><i>ver. 2.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 28/10/2007</i></p>
 * <ul>
 * <p><i>ver. 2.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 1/11/2007</i></p>
 * <ul>
 *   <li>rinonimato il metodo leggiLinea in leggiLineaX</li>
 *   <li>modificato il metodo leggiLineaX</li>
 * </ul>
 * <p><i>ver. 2.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 28/10/2007</i></p>
 * <ul>
 *   <li>eliminato costruttore senza parametri</li>
 *   <li>modificato costruttore ad un parametro</li>
 *   <li>aggiunto campo dato estensione</li>
 *   <li>creata funzione trasformaInVettore()</li>
 *   <li>rinonimata funzione scrivi in scriviValore</li>
 *   <li>creata funzione scriviVettore(Vector<String></string>)</li>
 *   <li>creata funzione scriviSuFile(Vector<String></string>)</li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 26/10/2007</i></p>
 * <ul>
 *   <li>aggiunto metodo ottieniPartenza</li>
 *   <li>aggiunto metodo ottieniArrivo</li>
 * </ul>
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 25/10/2007</i></p>
 * <ul>
 *   <li>bozza iniziale </li>
 * </ul>
 * 
 * @author  Mazzarelli Ivan
 * @version 2.5 del 18/11/2007
 */
		
public class GestisceFile {
	/** indica il nome del file da gestire */
	protected String nome_file;
	/** indica l'estensione del file da gestire */
	private String estensione = ".txt";
	/** indica l'identificativo del giocatore di cui si sta gestendo il file*/
	protected String identificativo_giocatore;
	
	/** costruttore a tre parametri che prepara un file per eventuali scritture/letture
	 * 
	 * @param nome Indica il nome del file da gestire
	 * @param estensione_file indica l'estensione che avra' il file
	 * @param identificativo Indica l'identificativo del giocatore a cui e' associato il file	 * 
	 */
    protected GestisceFile(String nome, String estensione_file, String identificativo){
		this.estensione = estensione_file;
		identificativo_giocatore = identificativo;
		nome_file = nome + "_" + identificativo_giocatore;
	}
	
	/** costruttore a due parametri che inizializza il file e lo prepara per
	 * le eventuali successive scritture/letture
	 * 
	 * @param nome Indica il nome del file da gestire
	 * @param identificativo Indica l'identificativo del giocatore a cui e' associato il file
	 */
	public GestisceFile(String nome, String identificativo) throws FileNotFoundException{
		nome_file = nome + "_" + identificativo;
		identificativo_giocatore = identificativo;
		//se il file è vuoto, scrivo l'intestazione:
		if (leggiLineaX(0).equals("ERRORE")){
			scriviValore("[*]-[*]-[*]    L O G    P A R T I T E    [*]-[*]-[*]",true);
			String giocatore = "\ngiocatore: " + nome + " # " + identificativo_giocatore;
			scriviValore(giocatore,true);
			scriviValore("\n\nPARTITE GIOCATE: 0\n\n",true);
		}
		//altrimenti non fa niente
	}
	
	/**
	 * Metodo a due parametre che permette di scrivere su un file una stringa a piacere
	 * 
	 * @param valore Stringa da inserire nel file
	 * @param modifica_vecchio indica se si vuole modificare il vecchio file o se si vuole
	 * aggiungere la stringa alla fine del file cancellando il suo vecchio contenuto
	 * 
	 */
    void scriviValore(String valore, boolean modifica_vecchio) throws FileNotFoundException{
		//memorizzo il nome completo del file
		String nome = nome_file + estensione;
		PrintStream destinazione = new PrintStream(new FileOutputStream(nome, modifica_vecchio));
		destinazione.print(valore);
		destinazione.close();
	}
	
	/**
	 * Metodo a due parametri che permette di scrivere su un file un vettore di stringhe a piacere
	 * 
	 * @param vettore stringhe da inserire nel file
	 * @param modifica_vecchio indica se si vuole modificare il vecchio file o se si vuole
	 * aggiungere la stringa alla fine del file cancellando il suo vecchio contenuto
	 * 
	 */
    protected void scriviVettore(Vector<String> vettore, boolean modifica_vecchio) throws FileNotFoundException{
		//memorizzo il nome completo del file
		String nome = nome_file + estensione;
		PrintStream destinazione = new PrintStream(new FileOutputStream(nome, modifica_vecchio));
		//aggiungo ogni elemento del vettore al file
        for (String aVettore : vettore) {
            destinazione.println(aVettore);
        }
		destinazione.close();
	}
	
	/**
	 * Metodo con un parametro che permette di leggere una linea a piacere all'interno di un file
	 * 
	 * @param x indica la linea che voglio leggere (la prima linea ha indice = 0)
	 * 
	 * @return String - Stringa contenuta al rigo x
	 */
    protected String leggiLineaX(int x){
		try{
			//memorizzo il nome completo del file
			String nome = nome_file + estensione;
			BufferedReader testo = new BufferedReader(new InputStreamReader(new FileInputStream(new File(nome))));
			String linea = testo.readLine();
			//controllo che il testo non sia completamente vuoto
			if (linea == null){
				testo.close();
				return "ERRORE";
			}
			//scorro tutte le linee del file
			while (x>0){
				//decremento il contatore
				x--;
				//se la linea non e' nulla
				if (linea != null){
					//salvo la linea corrente
					linea = testo.readLine();
				}
				else{
					//se e' nulla
					testo.close();
					String ritorno = "ERRORE LINEA: " + Integer.toString(x);
					return ritorno;
				}
			}
			testo.close();
			return linea;
		}
		catch (IOException e){
			//se non e' presente il file, ritorno la stringa "ERRORE"
			return "ERRORE";
		}
	}
	
	/** metodo con un parametro che, data una stringa in input, determina se al suo interno e'
	 * rappresentata una mossa eseguita nel gioco. In caso affermativo, ritorna la coordinata di
	 * partenza della mossa.<p>
	 * 
	 * @param testo contiene il testo da analizzare
	 * 
	 * @return Coordinata - se nel testo da analizzare e' rappresentata una mossa eseguita nel gioco,
	 * ritorna la coordinata di partenza della mossa, in caso negativo, ritorna null
	 */
	public static Coordinata ottieniPartenza(String testo){
		//se la stringa è nulla o se non è lunga 20 caratteri ritorno null
		//(20 caratteri è la lunghezza della stringa contenente le coordinate di partenza/arrivo)
		if (testo == null || (testo.length() != 20))
			return null;
		//sono certo che la stringa contiene le coordinate
		//se il terzo carattere è ")" il formato è il seguente: "XXX) [y:y]"
		if (testo.charAt(3) == ')'){
			Byte riga = new Byte (testo.substring(6, 7));
			Byte colonna = new Byte (testo.substring(8, 9));
			//creo la coordinata con i valori appena trovati
			Coordinata partenza = new Coordinata(riga,colonna);
			return partenza;
		}
		else{ //se il secondo carattere non è ')' allora la stringa non contiene coordinate
			return null;
		}
	}
	
	/** metodo con un parametro che, data una stringa in input, determina se al suo interno e'
	 * rappresentata una mossa eseguita nel gioco. In caso affermativo, ritorna la coordinata di
	 * arrivo della mossa.<p>
	 * 
	 * @param testo contiene il testo da analizzare
	 * 
	 * @return Coordinata - se nel testo da analizzare e' rappresentata una mossa eseguita nel gioco,
	 * ritorna la coordinata di arrivo della mossa, in caso negativo, ritorna null
	 */
	public static Coordinata ottieniArrivo(String testo){
		//se la stringa è nulla o se non è lunga 20 caratteri ritorno null
		//(20 caratteri è la lunghezza della stringa contenente le coordinate di partenza/arrivo)
		if (testo == null || (testo.length() != 20))
			return null;
		//sono certo che la stringa contiene le coordinate
		//se il terzo carattere è ")" il formato è il seguente: "XXX) [a:a] --> [y:y]"
		if (testo.charAt(3) == ')'){
			Byte riga = new Byte (testo.substring(16, 17));
			Byte colonna = new Byte (testo.substring(18,19));
			//creo la coordinata con i valori appena trovati
			Coordinata partenza = new Coordinata(riga,colonna);
			return partenza;
		}
		else{ //se il terzo carattere non è ')' allora la stringa non contiene coordinate
			return null;
		}
	}	
	
	/** metodo con un parametro che, data una stringa in input, determina se al suo interno e'
	 * rappresentata una coordinata di disposizione iniziale di pezzi. In caso affermativo, 
	 * ritorna la coordinata di del pezzo<p>
	 * 
	 * @param testo contiene il testo da analizzare
	 * 
	 * @return Coordinata - se nel testo da analizzare e' rappresentata una disposizione iniziale
	 *		di pezzi, ritorna la coordinata del pezzo, in caso negativo, ritorna null
	 */
	public static Coordinata ottieniCoordinata(String testo){
		//se la stringa è nulla o se non è lunga 11 o 12 caratteri ritorno null
		//(11 e 12 caratteri è la lunghezza della stringa contenente le coordinate delle disposizioni di pezzi)
		if (testo == null || (testo.length() != 11 && testo.length() != 12))
			return null;
		//sono certo che la stringa contiene le coordinate
		//se il quarto carattere è "=" il formato è il seguente: "[x:y] ==> a"
		if (testo.charAt(6) == '='){
			Byte riga = new Byte (testo.substring(1, 2));
			Byte colonna = new Byte (testo.substring(3,4));
			//creo la coordinata con i valori appena trovati
			Coordinata partenza = new Coordinata(riga,colonna);
			return partenza;
		}
		else{ //se il terzo carattere non è ')' allora la stringa non contiene coordinate
			return null;
		}
	}
	
	/** metodo con un parametro che, data una stringa in input, determina se al suo interno e'
	 * rappresentata una coordinata di disposizione iniziale di pezzi. In caso affermativo, 
	 * ritorna il numero del pezzo<p>
	 * 
	 * @param testo contiene il testo da analizzare
	 * 
	 * @return Coordinata - se nel testo da analizzare e' rappresentata una disposizione iniziale
	 *		di pezzi, ritorna il numero del pezzo, in caso negativo, ritorna -1
	 */
	public static byte ottieniPezzo(String testo){
		//se la stringa è nulla o se non è lunga 11 o 12 caratteri ritorno null
		//(11 o 12 caratteri è la lunghezza della stringa contenente le coordinate delle disposizioni di pezzi)
		if (testo == null || (testo.length() != 11 && testo.length() != 12))
			return -1;
		//sono certo che la stringa contiene le coordinate
		//se il quarto carattere è "=" il formato è il seguente: "[a:a] ==> x"
		if (testo.charAt(6) == '='){
			byte partenza = Byte.parseByte(dividiTesto(testo).get(2));
			return partenza;
		}
		else{ //se il terzo carattere non è ')' allora la stringa non contiene coordinate
			return -1;
		}
	}
	
	/**
	 * Metodo senza parametri che restituisce un vettore di stringhe contenente il contenuto
	 * del file.
	 * Ogni riga del file corrisponderà ad un elemento del vettore di output
	 * 
	 * @return Vector<String> - al suo interno vi e' il contenuto del file sottoforma di
	 * sequenze di stringhe
	 */ 
	public Vector<String> trasformaInVettore(){
		try{
			//memorizzo il nome completo del file
			String nome = nome_file + estensione;
			Vector<String> vettore = new Vector<String>();
			BufferedReader testo = new BufferedReader(new InputStreamReader(new FileInputStream(new File(nome))));
			String linea = testo.readLine();
			while(linea!=null) {
				vettore.add(linea);
				linea = testo.readLine();
			}
			testo.close();
			return vettore;
		} catch (IOException e){
			return null;
		}

	}
	
	/**
	 * Metodo ad un parametro che salva sul file gestito dalla classe, il log di una partita
	 * (rappresentato da un vettore di stringhe) modificando ed adattando il vecchio testo del 
	 * file in maniera tale da non perdere i vecchi log.
	 * 
	 * @param testo_nuovo log della partita da inserire nel file
	 * 
	 */
	public void salvaSuFile(Vector<String> testo_nuovo) throws FileNotFoundException{
		Vector<String> testo_vecchio = trasformaInVettore();
		//se il vettore non e' stato inizializzato correttamente, lancio l'eccezione
		if (testo_vecchio == null)
			new FileNotFoundException();
		//sono sicuro che il vettore ha almeno quattro elementi (l'intestazione)
		//controllo quante partite sono già state giocate (il numero è al 17esimo posto)
		String stringa_num_partite = testo_vecchio.get(3).substring(17);
		Integer numero_partite = new Integer(stringa_num_partite);
		//aggiorno la posizione delle vecchie partite incrementando di 1 la loro linea
		for (int a=0; a<numero_partite; a++){
			int linea_in_esame = a+5;
			int pos_due_punti = testo_vecchio.get(linea_in_esame).indexOf(":", 0);
			//calcolo il numero della linea da modificare
			String num_linea_vecchio = testo_vecchio.get(linea_in_esame).substring(pos_due_punti+7);
			Integer num_linea = new Integer(num_linea_vecchio);
			//calcolo il nuovo numero da inserire
			num_linea++;
			//creo una stringa con i valori corretti
			String valori_corretti = testo_vecchio.get(linea_in_esame).substring(0, (pos_due_punti+7)) + num_linea.toString();
			//inserisco i valori corretti nel vecchio vettore al posto del valore vecchio
			testo_vecchio.setElementAt(valori_corretti, linea_in_esame);
		}
		//inserisco una linea vuota nel testo_vecchio
		testo_vecchio.add("");
		//determino il numero della partita che ho giocato
		numero_partite++;
		//aggiorno il numero di partite giocate nel vettore vecchio
		String numero_partite_giocate = "PARTITE GIOCATE: " + numero_partite.toString();
		testo_vecchio.set(3, numero_partite_giocate);
		//creo una stringa descrittiva della partita che sto per creare
		String descrizione_partita = "PARTITA NUMERO... " + numero_partite.toString();
		//creo una stringa descrittiva indicante il numero della partita e la sua posizione all'interno del file
		String posizione_partita = "Partita " + numero_partite.toString() + " : ";
		//controllo se è la prima partita che sto giocando, per determinare a che rigo la memorizzo
		if (numero_partite == 1){
			posizione_partita = posizione_partita + "riga " + Integer.toString(testo_vecchio.size()+1);
		}
		else{ //non è la prima partita
			posizione_partita = posizione_partita + "riga " + Integer.toString(testo_vecchio.size()+1);
		}
		//aggiungo nel testo vecchio, la posizione della nuova partita
		testo_vecchio.add(5,posizione_partita);
		//aggiungo il testo_nuovo alla fine del testo_vecchio
		testo_vecchio.add(descrizione_partita);
		testo_vecchio.addAll(testo_nuovo);
		//scrivo il nuovo vettore nel file
		scriviVettore(testo_vecchio, false);
	}

	/**
     * Questo metodo serve a suddividere tutte le parole contenute in una stringa di testo
     *
     * @param testo il testo in input da suddividere.
     *
     * @return un Vector contenente tutte le stringhe(parole) che compongono il testo.
     */
    protected static Vector<String> dividiTesto(String testo){
		Vector <String> parole = new Vector <String>();
		String s = testo;
		boolean itera = true;
		int inizio = 0;
		int fine = 0;
		while(itera){
			if(s.length() != 0)
				s = togliBianchi(s);
			if(s.length() != 0){
				fine = s.indexOf(' ', 0);
				if (fine != -1){
					parole.add(s.substring(inizio,fine));
					s = s.substring(fine);
				}
				else{
					parole.add(s.substring(inizio));
					itera = false;
				}
			}
			else
				itera = false;
		}
		return parole;
    }
        
    /**
     * Questo metodo serve ad eliminare tutti gli spazi bianchi e i caratteri di "tab" iniziali da una
     * stringa di testo.
     *
     * @param s una stringa che rappresenta il testo in input.
     *
     * @return la corrispondente stringa di testo senza spazi bianchi o caratteri di "tab" iniziali.
     */
    private static String togliBianchi(String s)
    {
       int index = 0; 
       for(;s.substring(index).length() > 0 && (s.charAt(index) == ' '); index++);
       return s.substring(index);
    }
    
}
