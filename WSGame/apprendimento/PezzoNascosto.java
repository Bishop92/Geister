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

import logica.*;
import java.util.Vector;

/**
 * Questa classe ha lo scopo di rappresentare i pezzi avversari di cui non si conosce l'effettiva bonta',
 * &nbsp; ma solo la probabilita' che un pezzo sia buono o cattivo.<p>&nbsp;</p>
 * <p>&nbsp;</p>
 * <p><u><i>Elenco versioni:</i></u> </p>
 * <p><i>ver. 1.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/11/2007 </i></p>
 * <ul>
 *   <li>aggiunto metodo aggiungiNonta </li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 15/11/2007 </i></p>
 * <ul>
 *   <li>aggiunto metodo clone
 *  </li>
 *   <li>aggiunto metodo distanzaTraVettori </li>
 *   <li>aggiunto metodo impostaBonta </li>
 *   <li>costruttore modificato 
 *  </li>
 * </ul>
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 11/11/2007 </i></p>
 * <ul>
 *   <li>bozza </li>
 * </ul>
 * 
 * 
 * @author  Mazzarelli Ivan
 * @version 1.1 del 18/11/2007
 */
public class PezzoNascosto extends Pezzo implements Cloneable{
	/** rappresenta il profilo del pezzo*/
	private Vector<Double> profilo = new Vector<Double>();
	/** indica la distanza che c'e' tra il profilo ed il vettore di riferimento dei pezzi buoni */
	private double distanza_buono;
	/** indica la distanza che c'e' tra il profilo ed il vettore di riferimento dei pezzi cattivi */
	private double distanza_cattivo;
	/** indica il grado di bonta' che un pezzo puo' avere. Tale valore varia da -1 (indicante i pezzi buoni)
	 * a +1 (indicante i pezzi cattivi). Piu' il valore si avvicina a 0, minore sara' la sicurezza di
	 * identificare correttamente la bonta' del pezzo */
	private double bonta;
	
	/**
	 * Costruttore a due parametri che permette di inizializzare il pezzoNascosto
	 * 
	 * @param p pezzo che si vuole trasformare in pezzoNascosto
	 * @param tavolo tavolo su cui si vuole inserire il pezzoNascosto
	 */
	public PezzoNascosto(Pezzo p, Pezzo[][] tavolo) {
		//costruisco il pezzo
		super(p.getCoordinata(), p.getGiocatore(), p.getNumero(), tavolo);
		//aggiungo l'informazione aggiuntiva del pezzo nascosto
		distanza_buono = 0.5;
		distanza_cattivo = 0.5;
		bonta = 0;
	}
	
	/**
	 * Metodo senza parametri che permette sapere a quanto equivale la bonta' del pezzo
	 */
	public double getBonta(){
		return bonta;
	}
	
	/**
	 * Metodo ad un parametro che permette di impostare il vettore del pezzo
	 * 
	 * @param p vettore rappresentante il profilo del pezzo
	 */
	public void setVettore(Vector<Double> p){
		profilo = p;
	}
	
	/**
	 * Metodo a tre parametri che permette di determinare la bonta' di un pezzo confrontando
	 * la distanza che c'e' tra il vettore del profilo del pezzo ed i vettori di riferimento
	 * passati come parametri
	 * 
	 * @param vettore_buoni vettore di riferimento dei pezzi buoni
	 * @param vettore_cattivi vettore di riferimento dei pezzi cattivi
	 */
	public void impostaBonta(Vector<Double> vettore_buoni, Vector<Double> vettore_cattivi, double liv){
//		System.out.println("Livello == "+liv);
		//determino la distanza che c'e' tra il vettore buono e cattivo
		distanza_buono = distanzaTraVettori(vettore_buoni);
		distanza_cattivo = distanzaTraVettori(vettore_cattivi);
		//imposto la variabile bonta in relazione alle distanze appena calcolate
		double bonta_teorica = (distanza_buono - distanza_cattivo) / (distanza_cattivo + distanza_buono);
		// se il livello == 0 non c'è rumore nell'apprendimento la bonta è quella teorica calcolata con l'algoritmo di apprendimento
		if(liv==0.0){
			bonta=bonta_teorica;
			System.out.println("BONTA==Bonta teorica");
		}
//		 se livello >0 allora alla bonta_teorica va aggiunto un rumore che sara maggiore con l'aumentare del livello
		else{
		// valore random compreso tra -1 e 1 
		double random= 2*Math.random()-1;
		// ritorna il valore random così trovato 
		double bonta_con_rumore=(liv*random)+((1-liv)*bonta_teorica);
		bonta=bonta_con_rumore;
		System.out.println("BONTA==Bonta con rumore");
		}
	}
	
		
	/**
	 * metodo ad un parametro che permette di incrementare la bonta' di un pezzo del valore passato
	 * nel parametro
	 * 
	 * @param valore valore da aggiungere alla bonta' del pezzo
	 */
	public void aggiungiBonta(double valore){
		bonta = bonta + valore;
		//controllo che la bonta' sia rimasta compresa tra -1 e 1
		if (bonta < -1)
			bonta = -1;
		if (bonta > 1)
			bonta = 1;
	}
	
	/**
	 * Metodo ad un parametro che permette di determinare la distanza che c'e' tra due vettori
	 * 
	 * @param di_riferimento vettore del quale si vuole calcolare la distanza rispetto al vettore
	 * del profilo
	 * 
	 * @return double rappresentante la distanza tra i due vettori
	 */
	private double distanzaTraVettori(Vector<Double> di_riferimento){
		double distanza = 0;
		//scorro tutti i valori del vettore da confrontare
		for (int indice=0; indice<profilo.size(); indice++){
			double distanza_parziale = di_riferimento.get(indice).doubleValue() 
					- profilo.get(indice).doubleValue();
			//aggiungo alla distanza totale, il valore assoluto della distanza parziale
			distanza = distanza + Math.abs(distanza_parziale);
		}
		return distanza;
	}
	
	/** Metodo senza parametri che permette di effettuare una copia profonda dell'oggetto
     * di invocazione.
     * Questo metodo concretizza l'interfaccia Clonable, e proprio per questo motivo, 
     * l'oggetto ritornato Ã¨ di tipo Object. 
     * 
     * @return ritorna un Object rappresentante la copia del pezzo su cui Ã¨ stato 
     * richiamato il metodo.
     */
	public Object clone(){
		PezzoNascosto p=(PezzoNascosto) super.clone();
		p.cor = (Coordinata)this.cor.clone();
		p.giocatore = this.giocatore;
		p.numero = this.numero;
		//creo un vettore temporaneo dove copiare il vettore mosse_fattibili
		Vector<Coordinata> vettore_temporaneo1 = new Vector<Coordinata>();
		//copio il vettore mosse_fattibili nel vettore_temporaneo1
		for(int a=0; a<mosse_fattibili.size(); a++){
			Coordinata coordinata_temporanea = (Coordinata) mosse_fattibili.get(a).clone();
			vettore_temporaneo1.addElement(coordinata_temporanea);
		}
		//copio il vettore temporaneo nel nuovo oggetto
		p.mosse_fattibili = vettore_temporaneo1;
		//creo un vettore temporaneo dove copiare il vettore coordinate_pezzi_mangiabili
		Vector<Coordinata> vettore_temporaneo2 = new Vector<Coordinata>();
		//copio il vettore coordinate_pezzi_mangiabili nel vettore_temporaneo2
		for(int a=0; a<coordinate_pezzi_mangiabili.size(); a++){
			Coordinata coordinata_temporanea = (Coordinata) coordinate_pezzi_mangiabili.get(a).clone();
			vettore_temporaneo2.addElement(coordinata_temporanea);
		}
		//copio il vettore temporaneo nel nuovo oggetto
		p.coordinate_pezzi_mangiabili = vettore_temporaneo2;
		//copio il vettore del profilo
		Vector<Double> profilo_temporaneo = new Vector<Double>();
		for(int a=0; a<profilo.size(); a++){
			double valore = profilo.get(a).doubleValue();
			profilo_temporaneo.addElement(valore);
		}
		//copio il profilo temporaneo nel profilo dell'oggetto copiato
		p.profilo = profilo_temporaneo;
		//ritorno l'oggetto appena creato
		return p;
	}
	
	/**
	 * metodo senza parametri che permette di stabilire se, per l'intelligenza artificiale,
	 * il pezzo e' buono
	 * 
	 * @return true se l'IA crede che sia buono, false se crede che sia cattivo
	 */
	public boolean getBuono(){
		if (bonta<=0)
			return true;
		return false;
	}
}
