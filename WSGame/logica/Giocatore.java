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
 * <p>questa classe contiene tutti i parametri necessari per rappresentare un 
 * giocatore</p>
 * <p>&nbsp;</p>
 * <p>&nbsp;</p>
 * <p><u><i>Elenco versioni:</i></u></p>
 * <p><i>ver. 1.5&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 16/11/2007</i></p>
 * <ul>
 *  <li>aggiunto il metodo getUmano</li>
 *  <li>aggiunto il metodo setUmano</li>
 * </ul> 
 * <p><i>ver. 1.4&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 11/11/2007</i></p>
 * <ul>
 *  <li>aggiunto il campo dato umano</li>
 * </ul> 
 * <p><i>ver. 1.3&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 7/11/2007</i></p>
 * <ul>
 *  <li>modificata la visibilita' del campo dato Identificatore</li>
 *   <li>aggiunto il metodo getIdentificatore</li>
 * </ul> 
 * <p><i>ver. 1.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 5/11/2007</i></p>
 * <ul>
 *   <li>aggiunto il campo identificatore</li>
 * </ul>
 * 
 * <p><i>ver. 1.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 21/10/2007</i></p>
 * <ul>
 *   <li>aggiunto il campo password</li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 19/10/2007</i></p>
 * <ul>
 *   <li>eliminato il campo dato pezzi_posseduti_buoni</li>
 *   <li>eliminato il campo dato pezzi_posseduti_cattivi</li>
 *   <li>eliminato il metodo aggiungiPezzo(Pezzo P)</li>
 *   <li>eliminato il metodo eliminaPezzo(Pezzo P)</li>
 *   <li>eliminato il metodo getNumeroBuoni()</li>
 *   <li>eliminato il metodo getNumeroCattivi()</li>
 * </ul>
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/10/2007</i></p>
 * <ul>
 *   <li>bozza iniziale</li>
 * </ul>
 *
 * @author  Mazzarelli Ivan
 * @version 1.5 del 16/11/2007
 */
public class Giocatore {
	/** indica la password del giocatore */
	private String password;
	/** indica il numero del giocatore */
	private byte numero;
	/** indica il nome del giocatore */
	private String nome;
	/**indica un identificatore univoco per il giocatore*/
	private String identificatore;
	/**indica se il giocatore e' umano o e' un'intelligenza artificiale*/
	private boolean umano = true;
	/**se il giocatore è una IA conterrà le proprie euristiche */
	private Vector<String> euristiche=new Vector<String>();
	/**se il giocatore è una IA conterrà il proprio livello */
	private double livello=0;
	
	/**Costruttore a quattro parametri.
     * 
     * @param pass password del giocatore.
     * @param num numero del giocatore (1 o 2)
	 * @param nom nome del giocatore
	 * @param id identificativo del giocatore
	 * @param umano indica se il giocatore e' umano
     */
	public Giocatore(String pass, byte num, String nom, String id){
		password=pass;
		numero=num;
		nome=nom;
		identificatore = id;
		umano = true;
	}
	
	public Giocatore(String pass, byte num, String nom, String id, double liv,Vector<String> e){
		password=pass;
		numero=num;
		nome=nom;
		identificatore = id;
		umano=false;
		euristiche=e;
		livello=liv;
	}
	
	/**metodo senza parametri che ritorna il numero del giocatore
     * 
     * @return numero giocatore
     */
	public byte getNumero(){
		return numero;
	}
	
	/**metodo senza parametri che ritorna le euristiche del giocatore
     * 
     * @return euristiche giocatore
     */
	public Vector<String> getEuristiche(){
		return euristiche;
	}
	
	/**metodo senza parametri che restituisce il nome del giocatore
     * 
     * @return nome giocatore
     */
	public String getNome(){
		return nome;
	}
	
	/**metodo senza parametri che restituisce l'identificatore del giocatore
     * 
     * @return identificatore giocatore
     */
	public String getIdentificatore(){
		return identificatore;
	}
	
	/** Metodo senza parametri che permette di stabilire se un giocatore e' umano
	 * o e' un'intelligenza artificiale
	 * 
	 */
	public boolean getUmano(){
		return umano;
	}
	
	/**
	 * Metodo ad un parametro che permette di impostare il campo dati 'umano'
	 * 
	 * @param u indica se il giocatore e' umano o e' un'intelligenza artificiale
	 */
	public void setUmano(boolean u){
		umano = u;
	}
}
