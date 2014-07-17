package apprendimento;

import logica.*;
import java.io.FileNotFoundException;
import java.util.Vector;
/**
 *
 * @author Ivan Mazzarelli
 */

/** Questa classe permette di generare il profilo (buoni/cattivi) dei pezzi dell'avversario grazie all'algoritmo di apprendimento
 * /
 * @author Ivan Mazzarelli
 */ 
public class Profilo {
	/** rappresente il profilo che i pezzi buoni posseggono*/
	private Vector<Double> profilo_buoni = null;
	/** Rappresenta il profilo che i pezzi cattivi posseggono*/
	private Vector<Double> profilo_cattivi = null;
	/** indica la partita sulla quale si e' attivata l'intelligenza artificiale*/
	private Partita par;
	/** indica il giocatore che ha richiesto l'attivazione dell'intelligenza artificiale*/
	Giocatore giocatore_corrente;
	/** indica il giocatore del quale si vuole prevedere la bonta' dei pezzi */
	Giocatore avversario;
	
        /** Costruttore a 3 parametri che inizializza il profilo
         * 
         * @param p è la partita in questione
         * @param gioc_corr è il giocatore corrente
         * @param avv è l'avversario di cui si vuole tracciare il profilo dei suoi pezzi
         */
        public Profilo(Partita p, Giocatore gioc_corr, Giocatore avv) throws FileNotFoundException{
		par = p;
		giocatore_corrente = gioc_corr;
		avversario = avv;
		profilo_buoni = ottieniProfilo(true);
		profilo_cattivi = ottieniProfilo(false);
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
	Vector<Double> ottieniProfilo(boolean buono){
		return new GestisceFileProfilo(avversario.getNome(), avversario.getIdentificatore()).mediaVettori(buono);
	}
	
        /**
	 * Metodo senza parametri che permette di disabilitare l'intelligenza artificiale per evitare di prevedere 
	 * di che tipo sono i fantasmi avversari.
	 */
    public void disattivaProfilo(){
		par.getTavolo().ripristinaTavolo(avversario.getNumero());
		par.getTavolo().ripristinaDisposizionePezzi(avversario.getNumero());
	}
	
	/**
	 * Metodo senza parametri che permette di abilitare l'intelligenza artificiale per poter prevedere di che
	 * tipo sono i fantasmi avversari.
	 */
	public void aggiornaProfilo(){
		//reimposto i pezzi dell'avversario
		par.getTavolo().reimpostaTavolo(avversario.getNumero());
		//se esiste un profilo aggiorno la bonta' dei pezzi e poi li ridistribuisco all'interno dei vettori
		if(profilo_buoni != null){
//			System.out.println("AGGIORNO LE BONTA' DEI PEZZI DEL PROFILO");
			aggiornaBontaPezzi();
		}
		else{ //se non c'e' il profilo
			//dispongo correttamente i pezzi all'interno dei vettori
			par.getTavolo().reimpostaDisposizionePezzi(avversario.getNumero());
		}
	}
	
        
	/**
	 * Metodo senza parametri che assegna ad ogni pezzo dell'avversario, il suo profilo.
	 */
	private void caricaProfiloNeiPezzi(){
		//salvo in una variabile il vettore di log della partita
		Vector<String> log = par.getVettoreLog();
		//se sto controllando i pezzi del giocatore 1
		if (avversario.getNumero()==1){
			//scorro il vettore dei pezzi buoni del giocatore uno
			for (int indice=0; indice<par.getTavolo().vettorePezzi((byte)1).size(); indice++){
				//memorizzo il numero del pezzo in esame
				byte num_pezzo = par.getTavolo().vettorePezzi((byte)1).get(indice).getNumero();
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
				//assegno al pezzo il vettore appena creato
				((PezzoNascosto)par.getTavolo().vettorePezzi((byte)1).get(indice)).setVettore(profilo_pezzo);
			}
			//scorro il vettore dei pezzi cattivi del giocatore uno
			for (int indice=0; indice<par.getTavolo().vettorePezzi((byte)2).size(); indice++){
				//memorizzo il numero del pezzo in esame
				byte num_pezzo = par.getTavolo().vettorePezzi((byte)2).get(indice).getNumero();
				//determino il vettore del profilo
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
				//assegno al pezzo il vettore appena creato
				((PezzoNascosto)par.getTavolo().vettorePezzi((byte)2).get(indice)).setVettore(profilo_pezzo);
			}
		}
		else{ //giocatore == 2
			//scorro il vettore dei pezzi buoni del giocatore due
			for (int indice=0; indice<par.getTavolo().vettorePezzi((byte)3).size(); indice++){
				//memorizzo il numero del pezzo in esame
				byte num_pezzo = par.getTavolo().vettorePezzi((byte)3).get(indice).getNumero();
				//determino il vettore del profilo
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
				//assegno al pezzo il vettore appena creato
				((PezzoNascosto)par.getTavolo().vettorePezzi((byte)3).get(indice)).setVettore(profilo_pezzo);
			}
			//scorro il vettore dei pezzi cattivi del giocatore due
			for (int indice=0; indice<par.getTavolo().vettorePezzi((byte)4).size(); indice++){
				//memorizzo il numero del pezzo in esame
				byte num_pezzo = par.getTavolo().vettorePezzi((byte)4).get(indice).getNumero();
				//determino il vettore del profilo
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
				//assegno al pezzo il vettore appena creato
				((PezzoNascosto)par.getTavolo().vettorePezzi((byte)4).get(indice)).setVettore(profilo_pezzo);
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
		Vector<String> log = par.getVettoreLog();
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
		Vector<String> log = par.getVettoreLog();
		//vedo se ha iniziato il giocatore in esame
		byte caso = GestisceFileProfilo.determinaCasoPartenza(log.get(0),avversario.getIdentificatore());
		//determino qual'e' la posizione del primo pezzo mosso
		byte posizione = GestisceFile.ottieniPartenza(log.get(20+caso)).getPosizione();
		//determinto qual'è il pezzo che si e' mosso per primo
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
		Vector<String> log = par.getVettoreLog();
		//distinguo i vari casi di partenza
		byte caso = GestisceFileProfilo.determinaCasoPartenza(log.get(0),avversario.getIdentificatore());
		//determino qual'e' la posizione del secondo pezzo mosso
		byte posizione = GestisceFile.ottieniPartenza(log.get(22+caso)).getPosizione();
		//controllo se e' stato mosso lo stesso pezzo che e' stato spostato nella prima mossa
		if (posizione == -1){
			//memorizzo la posizione di partenza che aveva il primo pezzo mosso
			posizione = GestisceFile.ottieniPartenza(log.get(20+caso)).getPosizione();
		}
		//determinto qual'è il pezzo che si e' mosso per secondo
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
		//aggiorno il profilo di ogni pezzo
		caricaProfiloNeiPezzi();
		//controllo se i pezzi da aggiornare sono del giocatore 1
		if (avversario.getNumero()==1){
//			System.out.print("imposto bont� pezzi con livello "+par.getLivelloG2());
			//scorro il vettore dei pezzi buoni del giocatore uno
			for (int indice=0; indice<par.getTavolo().vettorePezzi((byte)1).size(); indice++){
				//aggiorno la bonta' del pezzo in esame
				((PezzoNascosto)par.getTavolo().vettorePezzi((byte)1).get(indice)).impostaBonta(profilo_buoni, profilo_cattivi,par.getLivelloG2());
			}
			//scorro il vettore dei pezzi cattivi del giocatore uno
			for (int indice=0; indice<par.getTavolo().vettorePezzi((byte)2).size(); indice++){
				//aggiorno la bonta' del pezzo in esame
				((PezzoNascosto)par.getTavolo().vettorePezzi((byte)2).get(indice)).impostaBonta(profilo_buoni, profilo_cattivi,par.getLivelloG2());
			}
			par.getTavolo().reimpostaDisposizionePezzi(avversario.getNumero());
//			System.out.println("AGGIORNA BONTA' PEZZI Giovatore 1: ");
//			System.out.println("BUONI: "+par.getTavolo().vettorePezzi((byte)1).size());
//			System.out.println("CATTIVI: "+par.getTavolo().vettorePezzi((byte)2).size());
		}
		else{ //giocatore == 2
//			System.out.print("imposto bont� pezzi con livello "+par.getLivelloG1());
			//scorro il vettore dei pezzi buoni del giocatore due
			for (int indice=0; indice<par.getTavolo().vettorePezzi((byte)3).size(); indice++){
				//aggiorno la bonta' del pezzo in esame
				((PezzoNascosto)par.getTavolo().vettorePezzi((byte)3).get(indice)).impostaBonta(profilo_buoni, profilo_cattivi,par.getLivelloG1());
			}
			//scorro il vettore dei pezzi cattivi del giocatore due
			for (int indice=0; indice<par.getTavolo().vettorePezzi((byte)4).size(); indice++){
				//aggiorno la bonta' del pezzo in esame
				((PezzoNascosto)par.getTavolo().vettorePezzi((byte)4).get(indice)).impostaBonta(profilo_buoni, profilo_cattivi,par.getLivelloG1());
			}
			par.getTavolo().reimpostaDisposizionePezzi(avversario.getNumero());
//			System.out.println("AGGIORNA BONTA' PEZZI Giocatore 2: ");
//			System.out.println("BUONI: "+par.getTavolo().vettorePezzi((byte)3).size());
//			System.out.println("CATTIVI: "+par.getTavolo().vettorePezzi((byte)4).size());

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
		Vector<String> log = par.getVettoreLog();
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
		Vector<String> log = par.getVettoreLog();
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
		Vector<String> log = par.getVettoreLog();
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






