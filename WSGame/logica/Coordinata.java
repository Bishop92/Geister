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

/**
 * <p align="left">Questa classe permette di identificare univocamente una casella del tavolo di gioco mediante l'uso di due numeri, che rappresentano, rispettivamente, la riga e la colonna.
 * </p>
 * <p align="left">Il tavolo di gioco e' rappresentato da un quadrato 6x6 e gli indici (sia delle righe che delle colonne) vanno da 0 a 5
 *  partendo dal lato inferiore sinistro (coordinata [0,0] ) per finire 
 *  al lato superiore destro (coordinata [5,5] ).
 * </p>
 * <p align="left">&nbsp;</p>
 * <p align="left">&nbsp;</p>
 * <p><u><i>elenco versioni:</i></u></p>
 * <p><i>Ver. 1.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 17/11/2007</i></p>
 * <ul>
 *   <li>aggiunto metodo avanza</li>
 *   <li>aggiunto metodo indietreggie</li>
 *   <li>aggiunto metodo mossoLateralmente</li>
 * </ul>
 * <p><i>Ver. 1.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 9/11/2007</i></p>
 * <ul>
 *   <li>aggiunto metodo getPosizione</li>
 * </ul>
 * <p><i>Ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 26/10/2007</i></p>
 * <ul>
 *   <li>Modificata visibilita' costruttore</li>
 * </ul>
 * <p><i>Ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/10/2007</i></p>
 * <ul>
 *   <li>bozza iniziale</li>
 *  </ul>
 *
 * @author  Mazzarelli Ivan
 * @version 1.2 del 17/11/2007
 */
public class Coordinata implements Cloneable{
	/** indica la riga della coordinata*/
	private byte riga;
	/**indica la colonna della coordinata*/
	private byte colonna;

	/** Costruttore a due parametri
	 * 
	 * @param rig indica la riga della coordinata
	 * @param col indica la colonna della coordinata
	 */
	public Coordinata(byte rig, byte col){
		riga=rig;
		colonna=col;
	}
	
	/** Metodo senza parametri che determina la riga rappresentata dalla coordinata
	 * 
	 * @return riga contenuta all'interno della coordinata
	 * 
	 */
	public byte getRiga(){return riga;}
	
	/** Metodo senza parametri che determina la colonna rappresentata dalla coordinata
	 * 
	 * @return colonna contenuta all'interno della coordinata
	 * 
	 */
	public byte getColonna(){return colonna;}
	
	/** Metodo senza parametri che determina in che posizione di gioco e' posizionata
	 * la coordinata.<p>
	 * i valori che possono essere restituiti sono:<p>
	 * Coordinata [0:1] = 1 <p>
	 * Coordinata [0:2] = 2 <p>
	 * Coordinata [0:3] = 3 <p>
	 * Coordinata [0:4] = 4 <p>
	 * Coordinata [1:1] = 5 <p>
	 * Coordinata [1:2] = 6 <p>
	 * Coordinata [1:3] = 7 <p>
	 * Coordinata [1:4] = 8 <p>
	 * Coordinata [4:1] = 8 <p>
	 * Coordinata [4:2] = 7 <p>
	 * Coordinata [4:3] = 6 <p>
	 * Coordinata [4:4] = 5 <p>
	 * Coordinata [5:1] = 4 <p>
	 * Coordinata [5:2] = 3 <p>
	 * Coordinata [5:3] = 2 <p>
	 * Coordinata [5:4] = 1 <p>
	 * Tutte le altre coordinate torneranno il valore -1
	 * 
	 * @return posizione della coordinata
	 */	
	public byte getPosizione(){
		switch (riga){
			case 0:{
				switch (colonna){
					case 1: return 1;
					case 2: return 2;
					case 3: return 3;
					case 4: return 4;
					default: return -1;
				}
			}
			case 1:{
				switch (colonna){
					case 1: return 5;
					case 2: return 6;
					case 3: return 7;
					case 4: return 8;
					default: return -1;
				}
			}
			case 4:{
				switch (colonna){
					case 1: return 8;
					case 2: return 7;
					case 3: return 6;
					case 4: return 5;
					default: return -1;
				}
			}
			case 5:{
				switch (colonna){
					case 1: return 4;
					case 2: return 3;
					case 3: return 2;
					case 4: return 1;
					default: return -1;
				}
			}
			default: return -1;
		}
	}
	
	/**
	 * metodo a due parametri che pemette di determinare se la coordinata di arrivo e' posta anteriormente
	 * rispetto la coordinata di partenza
	 * 
	 * @param arrivo coordinata di arrivo
	 * @param giocatore giocatore a cui 'appartiene' la coordinata di partenza
	 * 
	 * @return true se la coordinata di arrivo e' posta anteriormente, false altrimenti
	 */
	public boolean avanza(Coordinata arrivo, int giocatore){
		//distinguo i due caso di giocatore
		if (giocatore == 1){
			//se la riga di arrivo e' maggiore di quella di partenza
            return arrivo.riga > riga;
		}
		else{ //giocatore == 2
			//se la riga di arrivo e' minore di quella di partenza
            return arrivo.riga < riga;
		}
	}
	
	/**
	 * metodo a due parametri che pemette di determinare se la coordinata di arrivo e' posta posteriormente
	 * rispetto la coordinata di partenza
	 * 
	 * @param arrivo coordinata di arrivo
	 * @param giocatore giocatore a cui 'appartiene' la coordinata di partenza
	 * 
	 * @return true se la coordinata di arrivo e' posta posteriormente, false altrimenti
	 */
	public boolean indietreggia(Coordinata arrivo, int giocatore){
		//distinguo i due caso di giocatore
		if (giocatore == 1){
			//se la riga di arrivo e' minore di quella di partenza
            return arrivo.riga < riga;
		}
		else{ //giocatore == 2
			//se la riga di arrivo e' maggiore di quella di partenza
            return arrivo.riga > riga;
		}
	}
	
	/**
	 * metodo ad un parametro che pemette di determinare se la coordinata di arrivo e' posta sulla stessa 
	 * colonna della coordinata di partenza
	 * 
	 * @param arrivo coordinata di arrivo
	 * 
	 * @return true se la colonna della coordinata di arrivo e' uguale a quella di partenza, false altrimenti
	 */
	public boolean mossoLateralmente(Coordinata arrivo){
		//se la colonna di arrivo non e' uguale a quella di partenza ritorno true
        return arrivo.colonna != colonna;
	}
	
	/**Metodo con un parametro di tipo Object che permette di effettuare il confronto
	 * tra un oggetto di tipo Coordinata ed un Object. 
     * 
     * @param o indica l'oggetto con il quale bisogna fare il confronto.
     * 
     * @return true se l'oggetto d'invocazione e' uguale al parametro passato alla funzione,
     * false altrimenti.
     */
	public boolean equals(Object o){
		if (o!=null){
			Coordinata cor=(Coordinata)o;
            return this.colonna == cor.colonna && this.riga == cor.riga;
        }
		return false;
	}
    
	/**Metodo senza parametri che permette di effettuare una copia profonda dell'oggetto
     * di invocazione.
     * Questo metodo concretizza l'interfaccia Clonable e, proprio per questo motivo, 
     * l'oggetto ritornato e' di tipo Object. 
     * 
     * @return ritorna un Object rappresentante la copia della coordinata su cui e' stato 
     * richiamato il metodo.
     */
	public Object clone() {
		try{Coordinata c=(Coordinata) super.clone();
			c.riga= this.riga;
			c.colonna= this.colonna;
			return c;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
}