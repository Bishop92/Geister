package skeleton;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import data.CancellaAmiciResponse;
import data.CancellaAmicoResponse;
import data.CancellaUtenteResponse;
import data.DeletePartitaResponse;
import data.GetIdtokenResponse;
import data.GetListaAmiciResponse;
import data.GetListaUtentiOnlineResponse;
import data.GetMosseResponse;
import data.GetNomePartitaResponse;
import data.GetPartitaIDResponse;
import data.GetPartiteResponse;
import data.GetPosizioniInizialiResponse;
import data.GetUtenteCognomeResponse;
import data.GetUtenteEmailResponse;
import data.GetUtenteIAResponse;
import data.GetUtenteNomeResponse;
import data.GetUtenteOnlineResponse;
import data.GetUtentePareggiateResponse;
import data.GetUtentePerseResponse;
import data.GetUtenteResponse;
import data.GetUtenteVinteResponse;
import data.InsertLOGResponse;
import data.InsertMossaResponse;
import data.InsertPartitaResponse;
import data.InsertPosizioneInizialeResponse;
import data.IsUtenteInizialeResponse;
import data.ModificaUtenteResponse;
import data.NuovoAmicoResponse;
import data.NuovoUtenteResponse;
import data.SetUtenteCognomeResponse;
import data.SetUtenteEmailResponse;
import data.SetUtenteIAResponse;
import data.SetUtenteNomeResponse;
import data.SetUtenteOnlineResponse;
import data.SetUtentePareggiateResponse;
import data.SetUtentePerseResponse;
import data.SetUtenteVinteResponse;
import data.UpdateTipoResponse;

/** Classe di definizione dei metodi implementati dal servizio WSData, 
 * creato per agire sui dati inseriti nel database
 * <p><u><i>Elenco versioni:</i></u></p>
 *
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/09/2011</i></p>
 * <ul>
 *   <li>bozza iniziale;</li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 19/09/2011</i></p>
 * <ul>
 *   <li>implementazione getIdtoken;</li>
 *   <li>implementazione nuovoUtente;</li>
 *   <li>implementazione modificaUtente;</li>
 * </ul>
 * <p><i>ver. 1.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 22/09/2011</i></p>
 * <ul>
 *   <li>implementazione cancellaUtente;</li>
 * </ul>
 * <p><i>ver. 1.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 30/09/2011</i></p>
 * <ul>
 *   <li>implementazione Get & Set per Vinte Pareggiate Perse;</li>
 * </ul>
 * <p><i>ver. 1.2&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 06/10/2011</i></p>
 * <ul>
 *   <li>implementazione listaAmici, nuovoAmico,CancellaAmico,cancellaAmici;</li>
 * </ul>
 * <p><i>ver. 1.3&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 17/11/2011</i></p>
 * <ul>
 *   <li>implementazione metodi per Game(partita, pos_iniziali, mosse...);</li>
 * </ul>
 * <p><i>ver. 1.4&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 10/12/2011</i></p>
 * <ul>
 *   <li>implementazione metodi per tipo sfida;</li>
 * </ul>
 */
public class MySkeleton {
	private Connection connection = null;
	/**Costruttore di default vuoto, serve a istanziare l'oggetto
	 * dentro lo Skeleton autogenerato. Si user� poi per richiamare i metodi
	 * riscritti
     */
	public MySkeleton()
	{}
	
	/** Instaura la connessione con il db.
     * @return boolean di conferma
     */
     private boolean setupDB()

     {
    	 try {
    		 
  			Class.forName("com.mysql.jdbc.Driver");
   
  		} catch (ClassNotFoundException e) {return false;}
     	
     	 
  		try {
  			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geister","root", "sportster");
   
  		} catch (SQLException e) { return false; }

         return connection != null;
    	 
     }
     
     /** Conta nella tabella scelta se ci sono tuple che aderiscono alla condizione voluta
      * @param tabella: nome della tabella
      * @param where: stringa di condizione (SQL senza 'WHERE')
      * @return int: numero di righe conformi alla condizione
      */
     private int contaTabella(String tabella, String where)
     {
    	 try {
			Statement s1 = connection.createStatement ();
			String query="SELECT COUNT(*) FROM "+tabella;
			if(!where.equals(""))query+=" where " +where;
			query+=" ;";		 
			s1.executeQuery (query);
			ResultSet rsCount = s1.getResultSet ();
			rsCount.next();
			int count=rsCount.getInt(1);
			s1.close();
			return count;
		} catch (SQLException e) {
			
			return -1;
		}    	 
     }
     /**Restituisce la data corrente in un formato leggibile dal DB
      * 
      * @return String data/ora di adesso
      */
     private static String dateNow()
     {
    	 java.util.Date dt = new java.util.Date();
		  java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String currentTime = sdf.format(dt);
    	 return currentTime;
     }
     /**Esposizione del servizio di inserimento LOG per altri WS.
      * Richiama il metodo omonimo usato anche dentro lo skeleton
      * 
      * 
      * @param insertLOG 
      * @return insertLOGResponse 
      */     
     public data.InsertLOGResponse insertLOG(data.InsertLOG insertLOG)
     {
    	 data.InsertLOGResponse resp=new InsertLOGResponse();
    	 resp.set_return(true);
    	 try {
			
			 String msg=insertLOG.getMessaggio();
			 
			 String fn=insertLOG.getFunzione();
			 
			 String r=insertLOG(msg,fn);
			 
			 if(r.startsWith("ERR")){resp.set_return(false);}
			 else {resp.set_return(true);}
			 return resp;
		} catch (Exception e) {
			resp.set_return(false);
	    	return resp;
		}
     }
     
     /**Inserisce LOG in database
      * 
      * 
      * @param message: string da inserire in LOG
      * @param function: string funzione di provenienza del log
      * @return String log
      */
     String insertLOG(String message, String function)
     {
    	 String insertQuery="";
    	 setupDB();
         try {
        	if(connection!=null){
        		Statement slog;
        		slog= connection.createStatement();
        		message=message.replaceAll("'", "''");
        		function=function.replaceAll("'", "''");
        		insertQuery="INSERT INTO log VALUES ("+
				   		"NULL"+","+//id autoincrement
						"'"+message+"',"+//messaggio
						"'"+dateNow()+"',"+//messaggio
				   		"'"+function+"'"+//funzione chiamante
						");";
        		slog.executeUpdate(insertQuery);
        		slog.close();
        		return insertQuery;
        	}else{return "ERR:conn";}
         } catch (SQLException e) {return "ERR:"+e.toString()+" "+insertQuery;}
         finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
         
     }

     
     /**generazione del codice hash di una stringa
      * 
      * @param stringa String generatore
      * @param algoritmo String MD5, SHA-1
      * @return String hash generata
      */
     private static String hashCode(String stringa, String algoritmo){

 		try{
 			MessageDigest md = MessageDigest.getInstance(algoritmo);
 			if(Charset.isSupported("CP1252"))

 				md.update(stringa.getBytes(Charset.forName("CP1252")));
 			else
 				md.update(stringa.getBytes(Charset.forName("ISO-8859-1")));

 			byte[]bytes = md.digest();
 			StringBuilder str = new StringBuilder();
            for (byte aByte : bytes) str.append(Integer.toHexString((aByte & 0xFF) | 0x100).substring(1, 3));

 			return str.toString();
 		}
 		catch(Exception e){
 			return "Errore: " + e.getMessage();

 		}
 	 }
     
     /**Cancella tutte le relazioni di amicizia di un utente.
      * @param CancellaAmici (token, username)
      * @return CancellaAmiciResponse (boolean conferma)
      */
     public data.CancellaAmiciResponse cancellaAmici(data.CancellaAmici cancellaAmici)
     {
    	 data.CancellaAmiciResponse resp=new CancellaAmiciResponse();
    	 String idtoken=cancellaAmici.getIdtoken();
    	 
    	 
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in cancellaAmici:"+idtoken,"WSData/cancellaAmici/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  	
   	  				 String deleteQuery="DELETE FROM amici " +
							"WHERE (id_utente1="+ID_Utente+") OR "+
							"(id_utente2="+ID_Utente+");";
							
	   	  			s.executeUpdate(deleteQuery);
	   	  			insertLOG("DELETE:"+deleteQuery,"WSData/cancellaAmici");
	   	  			resp.set_return(true);
   	  				 
	  				
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/cancellaAmici");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/cancellaAmici");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/cancellaAmici");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /**Cancella un relazione di amicizia tra l'utente e l'amico passato come parametro.
      * @param CancellaAmico (token, username, username_amico)
      * @return CancellaAmicoResponse (boolean conferma)
      */
     public data.CancellaAmicoResponse cancellaAmico(data.CancellaAmico cancellaAmico)
     {
    	 data.CancellaAmicoResponse resp=new CancellaAmicoResponse();
    	 String idtoken=cancellaAmico.getIdtoken();
    	 String amico=cancellaAmico.getUsername_amico();
    	 
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in cancellaAmico:"+idtoken,"WSData/cancellaAmico/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  	
   	  				 s.executeQuery ("SELECT id FROM utenti where username LIKE '"+amico+"'");
	  				 ResultSet rsAmico=s.getResultSet();
	  				 rsAmico.next();
	  				 int ID_Amico=rsAmico.getInt(1);  	
	  				 if(ID_Amico!=0) //l'amico esiste
	  				 { //cerco una relazione pre-esistente tra i due
	  					String selectQuery="SELECT id_utente2 AS 'id_utente' FROM amici " +
	  							" WHERE id_utente1="+ID_Utente+" AND id_utente2="+ID_Amico+" UNION " +
									"SELECT id_utente1 AS 'id_utente' FROM amici " +
							" WHERE id_utente1="+ID_Amico+" AND id_utente2="+ID_Utente+" ";
	  					s.executeQuery (selectQuery);
		  				 ResultSet rsAmicizia=s.getResultSet();
		  				 ////insertLOG("SELECT: "+selectQuery, "WSData/cancellaAmico");
		  				
		  				if(rsAmicizia.next())
		  				{//sono amici, cancello il record
		  					String deleteQuery="DELETE FROM amici " +
		  							"WHERE (id_utente1="+ID_Utente+" AND id_utente2="+ID_Amico+") OR "+
		  							"(id_utente1="+ID_Amico+" AND id_utente2="+ID_Utente+");";
		  							
		  	   	  			s.executeUpdate(deleteQuery);
		  	   	  			insertLOG("DELETE:"+deleteQuery,"WSData/cancellaAmico");
		  	   	  			resp.set_return(true);
		  				}else{resp.set_return(false);insertLOG("ERR:Friend", "WSData/cancellaAmico");}
	  				 }else{resp.set_return(false);insertLOG("ERR:NoFriend", "WSData/cancellaAmico");}
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/cancellaAmico");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/cancellaAmico");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/cancellaAmico");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /**Ritorna la lista di username online, come stringa separata da virgola.
      * @param GetListaUtentiOnline (token, username)
      * @return GetListaUtentiOnlineResponse (String usernameOnline, separati da virgola)
      */
     public data.GetListaUtentiOnlineResponse getListaUtentiOnline(data.GetListaUtentiOnline getListaUtentiOnline)
     {
    	 data.GetListaUtentiOnlineResponse resp=new GetListaUtentiOnlineResponse();
    	 String idtoken=getListaUtentiOnline.getIdtoken();
    	 String CHAR_SEPARATE=";";
    	 String userOnline="";
    	 
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getListaUtentiOnline:"+idtoken,"WSData/getListaUtentiOnline/ContaTabella");resp.set_return("ERR:noUser");}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  	
   	  				 String selectQuery="SELECT username FROM utenti "+
							" WHERE is_online=1 " +
							" order by username ";
   	  				 s.executeQuery (selectQuery);
   	  				 ResultSet rsOnline=s.getResultSet();
   	  				 ////insertLOG("SELECT: "+selectQuery, "WSData/getListaUtentiOnline");
   	  				 while(rsOnline.next())
   	  				 {//finch� trova utenti online, creo la stringa
   	  					 userOnline+=rsOnline.getString(1)+CHAR_SEPARATE;
   	  					 
   	  				 }
   	  				 //tolgo il carattere separatore finale
   	  				 if(userOnline.endsWith(CHAR_SEPARATE))userOnline = userOnline.substring(0, userOnline.length()-1);
   	  				 resp.set_return(userOnline);
   	  				 
   	  			 }else{resp.set_return("");insertLOG("ERR:InvalidTokenRequest", "WSData/getListaUtentiOnline");}
   	  			 s.close();
   	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getListaUtentiOnline");}
   	  	 }catch(Exception e){resp.set_return("ERR:"+e.toString());insertLOG("ERR:"+e.toString(), "WSData/getListaUtentiOnline");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /**Ritorna la lista di username amici, come stringa separata da virgola.
      * @param GetListaAmici (token, username)
      * @return GetListaAmiciResponse (String usernameAmici, separati da virgola)
      */
     public data.GetListaAmiciResponse getListaAmici(data.GetListaAmici getListaAmici)
     {
    	 data.GetListaAmiciResponse resp=new GetListaAmiciResponse();
    	 String idtoken=getListaAmici.getIdtoken();
    	 String CHAR_SEPARATE=";";
    	 String amici="";
    	 
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getListaAmici:"+idtoken,"WSData/getListaAmici/ContaTabella");resp.set_return("ERR:noUser");}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  	
   	  				 String selectQuery="SELECT username AS 'username' FROM amici " +
   	  						 " INNER JOIN utenti ON utenti.id=amici.id_utente2 "+
							" WHERE amici.id_utente1="+ID_Utente+" UNION " +
							"SELECT username AS 'username' FROM amici " +
							" INNER JOIN utenti ON utenti.id=amici.id_utente1 "+
							" WHERE id_utente2="+ID_Utente+" ";
   	  				 s.executeQuery (selectQuery);
   	  				 ResultSet rsAmicizia=s.getResultSet();
   	  				 ////insertLOG("SELECT: "+selectQuery, "WSData/getListaAmici");
   	  				 while(rsAmicizia.next())
   	  				 {//finch� trova amici, creo la stringa
   	  					 amici+=rsAmicizia.getString(1)+CHAR_SEPARATE;
   	  					 
   	  				 }
   	  				 //tolgo il carattere separatore finale
   	  				 if(amici.endsWith(CHAR_SEPARATE))amici = amici.substring(0, amici.length()-1);
   	  				 resp.set_return(amici);
   	  				 
   	  			 }else{resp.set_return("");insertLOG("ERR:InvalidTokenRequest", "WSData/getListaAmici");}
   	  			 s.close();
   	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getListaAmici");}
   	  	 }catch(Exception e){resp.set_return("ERR:"+e.toString());insertLOG("ERR:"+e.toString(), "WSData/getListaAmici");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /**Crea una nuova associazione di amicizia tra lo user e un altro username.
      * @param NuovoAmico (token, username, username_amico)
      * @return NuovoAmicoResponse (boolean conferma)
      */
     public data.NuovoAmicoResponse nuovoAmico(data.NuovoAmico nuovoAmico)
     {
    	 data.NuovoAmicoResponse resp=new NuovoAmicoResponse();
    	 String idtoken=nuovoAmico.getIdtoken();
    	 String amico=nuovoAmico.getUsername_amico();
    	 String currentDate=dateNow();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in nuovoAmico:"+idtoken,"WSData/nuovoAmico/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  	
   	  				 s.executeQuery ("SELECT id FROM utenti where username LIKE '"+amico+"'");
	  				 ResultSet rsAmico=s.getResultSet();
	  				 rsAmico.next();
	  				 int ID_Amico=rsAmico.getInt(1);  	
	  				 if(ID_Amico!=0) //l'amico esiste
	  				 { //cerco una relazione pre-esistente tra i due
	  					String selectQuery="SELECT id_utente2 AS 'id_utente' FROM amici " +
	  							" WHERE id_utente1="+ID_Utente+" AND id_utente2="+ID_Amico+" UNION " +
									"SELECT id_utente1 AS 'id_utente' FROM amici " +
							" WHERE id_utente1="+ID_Amico+" AND id_utente2="+ID_Utente+" ";
	  					s.executeQuery (selectQuery);
		  				 ResultSet rsAmicizia=s.getResultSet();
		  				 ////insertLOG("SELECT: "+selectQuery, "WSData/nuovoAmico");
		  				
		  				if(!rsAmicizia.next())
		  				{//non sono amici, inserisco il record
		  					String insertQuery="INSERT INTO amici VALUES ("+
		  							"'"+ID_Utente+"',"+//id_utente
		  					   		"'"+ID_Amico+"',"+//id_amico
		  					   		"'"+currentDate+"'"+//data_creazione
		  							");";
		  	   	  			s.executeUpdate(insertQuery);
		  	   	  			insertLOG("INSERT:"+insertQuery,"WSData/nuovoAmico");
		  	   	  			resp.set_return(true);
		  				}else{resp.set_return(false);insertLOG("ERR:Friend", "WSData/nuovoAmico");}
	  				 }else{resp.set_return(false);insertLOG("ERR:NoFriend", "WSData/nuovoAmico");}
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/nuovoAmico");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/nuovoAmico");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/nuovoAmico");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Setta l'utente online.
      * @param SetUtenteOnline (token, username)
      * @return SetUtenteOnlineResponse (boolean conferma)
      */
     public data.SetUtenteOnlineResponse setUtenteOnline(data.SetUtenteOnline setUtenteOnline)
     {
    	 data.SetUtenteOnlineResponse resp=new SetUtenteOnlineResponse();
    	 String idtoken=setUtenteOnline.getIdtoken();
    	 
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in setUtenteOnline:"+idtoken,"WSData/setUtenteOnline/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno l'email utente
   	  				 String updateQuery="update utenti set " +
   	  				 		" is_online='" + 1 +"'"+
   	  				 		" where id="+ID_Utente+";";
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/setUtenteOnline");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/setUtenteOnline");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/setUtenteOnline");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/setUtenteOnline");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Setta l'utente a intelligenza artificiale.
      * @param SetUtenteIA (token, username)
      * @return SetUtenteIAResponse (boolean conferma)
      */
     public data.SetUtenteIAResponse setUtenteIA ( data.SetUtenteIA setUtenteIA )
     {
    	 data.SetUtenteIAResponse resp=new SetUtenteIAResponse();
    	 String idtoken=setUtenteIA.getIdtoken();
    	 
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in setUtenteIA:"+idtoken,"WSData/setUtenteIA/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno l'email utente
   	  				 String updateQuery="update utenti set " +
   	  				 		" is_ia='" + 1 +"'"+
   	  				 		" where id="+ID_Utente+";";
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/setUtenteIA");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/setUtenteIA");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/setUtenteIA");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/setUtenteIA");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /**Setta l'email dell'utente.
      * @param SetUtenteEmail (token, username, String nuovo_cognome)
      * @return SetUtenteEmailResponse (boolean conferma)
      */
     public data.SetUtenteEmailResponse setUtenteEmail(data.SetUtenteEmail setUtenteEmail)
     {
    	 data.SetUtenteEmailResponse resp=new SetUtenteEmailResponse();
    	 String idtoken=setUtenteEmail.getIdtoken();
    	 String valore=setUtenteEmail.getEmail_nuovo();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in setUtenteEmail:"+idtoken,"WSData/setUtenteEmail/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno l'email utente
   	  				 String updateQuery="update utenti set " +
   	  				 		" email='" + valore +"'"+
   	  				 		" where id="+ID_Utente+";";
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/setUtenteEmail");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/setUtenteEmail");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/setUtenteEmail");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/setUtenteEmail");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Setta il cognome dell'utente.
      * @param setUtenteCognome (token, username, String nuovo_cognome)
      * @return SetUtenteCognomeResponse (boolean conferma)
      */
     public data.SetUtenteCognomeResponse setUtenteCognome ( data.SetUtenteCognome setUtenteCognome )
     {
    	 data.SetUtenteCognomeResponse resp=new SetUtenteCognomeResponse();
    	 String idtoken=setUtenteCognome.getIdtoken();
    	 String valore=setUtenteCognome.getCognome_nuovo();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in setUtenteCognome:"+idtoken,"WSData/setUtenteCognome/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno il cgnome utente
   	  				 String updateQuery="update utenti set " +
   	  				 		" cognome='" + valore +"'"+
   	  				 		" where id="+ID_Utente+";";
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/setUtenteCognome");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/setUtenteCognome");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/setUtenteCognome");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/setUtenteCognome");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Setta il nome dell'utente.
      * @param setUtenteNome (token, username, String nuovo_nome)
      * @return SetUtenteNomeResponse (boolean conferma)
      */
     public data.SetUtenteNomeResponse setUtenteNome ( data.SetUtenteNome setUtenteNome )
     {
    	 data.SetUtenteNomeResponse resp=new SetUtenteNomeResponse();
    	 String idtoken=setUtenteNome.getIdtoken();
    	 String valore=setUtenteNome.getNome_nuovo();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in setUtenteNome:"+idtoken,"WSData/setUtenteNome/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno il nome utente
   	  				 String updateQuery="update utenti set " +
   	  				 		" nome='" + valore +"'"+
   	  				 		" where id="+ID_Utente+";";
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/setUtenteNome");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/setUtenteNome");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/setUtenteNome");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/setUtenteNome");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Setta il numero di partite vinte dall'utente.
      * @param setUtenteVinte (token, username, int valoreVinte)
      * @return SetUtenteVinteResponse (boolean conferma)
      */
     public data.SetUtenteVinteResponse setUtenteVinte(data.SetUtenteVinte setUtenteVinte)
     {
    	 data.SetUtenteVinteResponse resp=new SetUtenteVinteResponse();
    	 String idtoken=setUtenteVinte.getIdtoken();
    	 String username=setUtenteVinte.getUsername();
    	 int valore=setUtenteVinte.getValore();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in setUtenteVinte:"+idtoken,"WSData/setUtenteVinte/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 if(username.startsWith("IA"))
   	  				 {
   	  					 username=username.replaceFirst("IA", "");
   	  					 s.executeQuery ("SELECT id FROM utenti where username like '"+username+"'");
   	  				 }else{
   	  					 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 }
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno quante vinte ha l'utente
   	  				 String updateQuery="update utenti set " +
   	  				 		" vinte='" + valore +"'"+
   	  				 		" where id="+ID_Utente+";";
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/setUtenteVinte");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/setUtenteVinte");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/setUtenteVinte");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/setUtenteVinte");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
   	  	 
     }
     /**Setta il numero di partite perse dall'utente.
      * @param setUtentePerse (token, username, int valorePerse)
      * @return SetUtentePerseResponse (boolean conferma)
      */
     public data.SetUtentePerseResponse setUtentePerse(data.SetUtentePerse setUtentePerse)
     {
    	 data.SetUtentePerseResponse resp=new SetUtentePerseResponse();
    	 String idtoken=setUtentePerse.getIdtoken();
    	 String username=setUtentePerse.getUsername();
    	 int valore=setUtentePerse.getValore();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in setUtentePerse:"+idtoken,"WSData/setUtentePerse/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 if(username.startsWith("IA"))
	  				 {
	  					 username=username.replaceFirst("IA", "");
	  					 s.executeQuery ("SELECT id FROM utenti where username like '"+username+"'");
	  				 }else{
	  					 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
	  				 }
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno quante perse ha l'utente
   	  				 String updateQuery="update utenti set " +
   	  				 		" perse='" + valore +"'"+
   	  				 		" where id="+ID_Utente+";";
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/setUtentePerse");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/setUtentePerse");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/setUtentePerse");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/setUtentePerse");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /**Setta il numero di partite pareggiate dall'utente.
      * @param setUtentePareggiate (token, username, int valorePareggiate)
      * @return SetUtentePareggiateResponse (boolean conferma)
      */
     public data.SetUtentePareggiateResponse setUtentePareggiate(data.SetUtentePareggiate setUtentePareggiate)
     {
    	 data.SetUtentePareggiateResponse resp=new SetUtentePareggiateResponse();
    	 String idtoken=setUtentePareggiate.getIdtoken();
    	 int valore=setUtentePareggiate.getValore();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in setUtentePareggiate:"+idtoken,"WSData/setUtentePareggiate/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno quante pareggiate ha l'utente
   	  				 String updateQuery="update utenti set " +
   	  				 		" pareggiate='" + valore +"'"+
   	  				 		" where id="+ID_Utente+";";
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/getUtentePareggiate");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/getUtentePareggiate");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/getUtentePareggiate");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/getUtentePareggiate");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }

     /**Restituisce un valore che indica se l'utente � online, contenuto nel DB
      * @param getUtenteOnline (token)
      * @return GetUtenteOnlineResponse (boolean)
      */
     public data.GetUtenteOnlineResponse getUtenteOnline(data.GetUtenteOnline getUtenteOnline)
     {
    	 data.GetUtenteOnlineResponse resp=new GetUtenteOnlineResponse();
    	 String idtoken=getUtenteOnline.getIdtoken();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtenteOnline:"+idtoken,"WSData/getUtenteOnline/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //seleziono campo online
   	  				 String selectQuery="select is_online from utenti where id="+ID_Utente+";";
   	  				 
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsOnline=s.getResultSet();
   	  				 rsOnline.next();
   	  				 ////insertLOG("SELECT:"+selectQuery,"WSData/getUtenteOnline");
   	  				 if(rsOnline.getInt(1)==0) resp.set_return(false);
   	  				 else if (rsOnline.getInt(1)==1) resp.set_return(true);
   	  				 else resp.set_return(false); //caso finale, occhio, non gestito.
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/getUtenteOnline");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/getUtenteOnline");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/getUtenteOnline");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
	 }
     
     /**Restituisce un valore che indica se l'utente � una intelligenza artificiale (IA), contenuto nel DB
      * @param GetUtenteIA (token)
      * @return GetUtenteIAResponse (boolean)
      */
     public data.GetUtenteIAResponse getUtenteIA ( data.GetUtenteIA getUtenteIA )
     {
    	 data.GetUtenteIAResponse resp=new GetUtenteIAResponse();
    	 String idtoken=getUtenteIA.getIdtoken();
    	 String username=getUtenteIA.getUsername();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtenteIA:"+idtoken,"WSData/getUtenteIA/ContaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1); 
   	  				 int idUser=0;
   	  				 if(!username.equals(""))
   	  				 {
   	  					 s.executeQuery ("SELECT id FROM utenti where username like '"+username+"'");
   	  					 ResultSet rsUser=s.getResultSet();
   	  					 if(rsUser.next())idUser=rsUser.getInt(1);
   	  				 }
   	  				 String selectQuery="select is_ia from utenti where id=";
   	  				 if(idUser!=0 && idUser!=ID_Utente)
   	  					 selectQuery+= idUser+";"; //chiedo per altro user
   	  				 else
   	  					 //seleziono campo IA
   	  					 selectQuery+= ID_Utente+";"; //chiedo per me stesso
   	  				 
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsIA=s.getResultSet();
   	  				 rsIA.next();
   	  				 ////insertLOG("SELECT:"+selectQuery,"WSData/getUtenteIA");
   	  				 if(rsIA.getInt(1)==0) resp.set_return(false);
   	  				 else if (rsIA.getInt(1)==1) resp.set_return(true);
   	  				 else resp.set_return(false);//caso finale, occhio, non gestito.
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/getUtenteIA");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/getUtenteIA");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/getUtenteIA");}
   	  finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /**Restituisce dati generici dell'utente, contenuto nel DB
      * @param GetUtente (token)
      * @return GetUtenteResponse (String username...)
      */
     public data.GetUtenteResponse getUtente(data.GetUtente getUtente)
     {
    	 data.GetUtenteResponse resp=new GetUtenteResponse();
    	 String idtoken=getUtente.getIdtoken();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtente:"+idtoken,"WSData/getUtenteEmail/getUtente");resp.set_return("ERR:noUser");}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //seleziono l'email
   	  				 String selectQuery="select username from utenti where id="+ID_Utente+";";
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsUser=s.getResultSet();
   	  				 if(rsUser.next()){
   	  					 ////insertLOG("SELECT:"+selectQuery,"WSData/getUtente");
   	  					 resp.set_return(rsUser.getString(1));
   	  				 }else{resp.set_return("ERR:User");insertLOG("ERR:User", "WSData/getUtente");}
   	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/getUtente");}
   	  			 s.close();
   	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getUtente");}
   	  	 }catch(Exception e){resp.set_return("ERR");insertLOG("ERR:"+e.toString(), "WSData/getUtente");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /**Restituisce l'email dell'utente, contenuto nel DB
      * @param GetUtenteEmail (token)
      * @return GetUtenteEmailResponse (String cognome)
      */
     public data.GetUtenteEmailResponse getUtenteEmail(data.GetUtenteEmail getUtenteEmail)
     {
    	 data.GetUtenteEmailResponse resp=new GetUtenteEmailResponse();
    	 String idtoken=getUtenteEmail.getIdtoken();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtenteEmail:"+idtoken,"WSData/getUtenteEmail/ContaTabella");resp.set_return("ERR:noUser");}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //seleziono l'email
   	  				 String selectQuery="select email from utenti where id="+ID_Utente+";";
   	  				 
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsEmail=s.getResultSet();
   	  				 rsEmail.next();
   	  				 //insertLOG("SELECT:"+selectQuery,"WSData/getUtenteEmail");
   	  				 resp.set_return(rsEmail.getString(1));
   	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/getUtenteEmail");}
   	  			 s.close();
   	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getUtenteEmail");}
   	  	 }catch(Exception e){resp.set_return("ERR");insertLOG("ERR:"+e.toString(), "WSData/getUtenteEmail");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Restituisce il cognome dell'utente, contenuto nel DB
      * @param getUtenteCognome (token)
      * @return GetUtenteCognomeResponse (String cognome)
      */
     public data.GetUtenteCognomeResponse getUtenteCognome(data.GetUtenteCognome getUtenteCognome)
     {
    	 data.GetUtenteCognomeResponse resp=new GetUtenteCognomeResponse();
    	 String idtoken=getUtenteCognome.getIdtoken();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtenteCognome:"+idtoken,"WSData/getUtenteCognome/ContaTabella");resp.set_return("ERR:noUser");}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //seleziono il cognome
   	  				 String selectQuery="select cognome from utenti where id="+ID_Utente+";";
   	  				 
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsCognome=s.getResultSet();
   	  				 rsCognome.next();
   	  				 //insertLOG("SELECT:"+selectQuery,"WSData/getUtenteCognome");
   	  				 resp.set_return(rsCognome.getString(1));
   	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/getUtenteCognome");}
   	  			 s.close();
   	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getUtenteCognome");}
   	  	 }catch(Exception e){resp.set_return("ERR");insertLOG("ERR:"+e.toString(), "WSData/getUtenteCognome");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Restituisce il nome dell'utente, contenuto nel DB
      * @param getUtenteNome (token)
      * @return GetUtenteNomeResponse (String nome)
      */
     public data.GetUtenteNomeResponse getUtenteNome(data.GetUtenteNome getUtenteNome)
     {
    	 data.GetUtenteNomeResponse resp=new GetUtenteNomeResponse();
    	 String idtoken=getUtenteNome.getIdtoken();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtenteNome:"+idtoken,"WSData/getUtenteNome/ContaTabella");resp.set_return("ERR:noUser");}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //seleziono il nome
   	  				 String selectQuery="select nome from utenti where id="+ID_Utente+";";
   	  				 
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsNome=s.getResultSet();
   	  				 rsNome.next();
   	  				 //insertLOG("SELECT:"+selectQuery,"WSData/getUtenteNome");
   	  				 resp.set_return(rsNome.getString(1));
   	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/getUtenteNome");}
   	  			 s.close();
   	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getUtenteNome");}
   	  	 }catch(Exception e){resp.set_return("ERR");insertLOG("ERR:"+e.toString(), "WSData/getUtenteNome");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Restituisce il numero di partite perse dall'utente, contenuto nel DB
      * @param getUtentePareggiate (token)
      * @return GetUtentePareggiateResponse (int perse)
      */
     public data.GetUtentePareggiateResponse getUtentePareggiate(data.GetUtentePareggiate getUtentePareggiate)
     {
    	 data.GetUtentePareggiateResponse resp=new GetUtentePareggiateResponse();
    	 String idtoken=getUtentePareggiate.getIdtoken();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtentePareggiate:"+idtoken,"WSData/getUtentePareggiate/ContaTabella");resp.set_return(-1);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //seleziono quante pareggiate ha l'utente
   	  				 String selectQuery="select pareggiate from utenti where id="+ID_Utente+";";
   	  				 
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsPareggiate=s.getResultSet();
   	  				 rsPareggiate.next();
   	  				 //insertLOG("SELECT:"+selectQuery,"WSData/getUtentePareggiate");
   	  				 resp.set_return(rsPareggiate.getInt(1));
   	  			 }else{resp.set_return(-1);insertLOG("ERR:InvalidTokenRequest", "WSData/getUtentePareggiate");}
   	  			 s.close();
   	  		 }else{resp.set_return(-1);insertLOG("ERR:noConn", "WSData/getUtentePareggiate");}
   	  	 }catch(Exception e){resp.set_return(-1);insertLOG("ERR:"+e.toString(), "WSData/getUtentePareggiate");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Restituisce il numero di partite vinte dall'utente, contenuto nel DB
      * @param getUtenteVinte ( token)
      * @return GetUtenteVinteResponse (int vinte)
      */ 
     public data.GetUtenteVinteResponse getUtenteVinte ( data.GetUtenteVinte getUtenteVinte )
     {
    	 data.GetUtenteVinteResponse resp=new GetUtenteVinteResponse();
    	 String idtoken=getUtenteVinte.getIdtoken();
    	 String username=getUtenteVinte.getUsername();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtenteVinte:"+idtoken,"WSData/getUtenteVinte/ContaTabella");resp.set_return(-1);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  			if(username.startsWith("IA"))
	  				 {
	  					 username=username.replaceFirst("IA", "");
	  					 s.executeQuery ("SELECT id FROM utenti where username like '"+username+"'");
	  				 }else{
	  					 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
	  				 }
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //seleziono quante vinte ha l'utente
   	  				 String selectQuery="select vinte from utenti where id="+ID_Utente+";";
   	  				 
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsVinte=s.getResultSet();
   	  			rsVinte.next();
   	  				 //insertLOG("SELECT:"+selectQuery,"WSData/getUtenteVinte");
   	  				 resp.set_return(rsVinte.getInt(1));
   	  			 }else{resp.set_return(-1);insertLOG("ERR:InvalidTokenRequest", "WSData/getUtenteVinte");}
   	  			 s.close();
   	  		 }else{resp.set_return(-1);insertLOG("ERR:noConn", "WSData/getUtenteVinte");}
   	  	 }catch(Exception e){resp.set_return(-1);insertLOG("ERR:"+e.toString(), "WSData/getUtenteVinte");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     
     /**Restituisce il numero di partite perse dall'utente, contenuto nel DB
      * @param getUtentePerse (token)
      * @return GetUtentePerseResponse (int perse)
      */
     public data.GetUtentePerseResponse getUtentePerse(data.GetUtentePerse getUtentePerse )
     {
    	 data.GetUtentePerseResponse resp=new GetUtentePerseResponse();
    	 String idtoken=getUtentePerse.getIdtoken();
    	 String username=getUtentePerse.getUsername();
    	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getUtentePerse:"+idtoken,"WSData/getUtentePerse/ContaTabella");resp.set_return(-1);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso scegliere l'utente del token
   	  			if(username.startsWith("IA"))
	  				 {
	  					 username=username.replaceFirst("IA", "");
	  					 s.executeQuery ("SELECT id FROM utenti where username like '"+username+"'");
	  					insertLOG("SELECT:"+username,"WSData/getUtentePerse");
	  				 }else{
	  					 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
	  				 }
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //seleziono quante perse ha l'utente
   	  				 String selectQuery="select perse from utenti where id="+ID_Utente+";";
   	  				 
   	  				 s.executeQuery(selectQuery);
   	  				 ResultSet rsPerse=s.getResultSet();
   	  				 rsPerse.next();
   	  				 //insertLOG("SELECT:"+selectQuery,"WSData/getUtentePerse");
   	  				 resp.set_return(rsPerse.getInt(1));
   	  			 }else{resp.set_return(-1);insertLOG("ERR:InvalidTokenRequest", "WSData/getUtentePerse");}
   	  			 s.close();
   	  		 }else{resp.set_return(-1);insertLOG("ERR:noConn", "WSData/getUtentePerse");}
   	  	 }catch(Exception e){resp.set_return(-1);insertLOG("ERR:"+e.toString(), "WSData/getUtentePerse");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
              
     /**Inserimento in database di un nuovo utente. Sempre possibile (registrazione).
      * Va subito online. In una chiamata a questo metodo, ricordarsi dopo di chiamare
      * anche il rilascio di un nuovo token con getIdtoken(...);
      * @param nuovoUtente ( username, password, nome, cognome, email)
      * @return nuovoUtenteResponse (boolean conferma)
      */
     public data.NuovoUtenteResponse nuovoUtente(data.NuovoUtente nuovoUtente )
     {
    	 NuovoUtenteResponse resp=new NuovoUtenteResponse();
    	 String nome=nuovoUtente.getNome();
    	 String cognome=nuovoUtente.getCognome();
    	 String user=nuovoUtente.getUsername();
   	  	 String password=nuovoUtente.getPassword();
   	  	 String email=nuovoUtente.getEmail();
   	  	 String currentDate=dateNow();
   	  	 
   	  	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" username like '"+user+"';";
   	  			 // ci sono utenti con lo stesso username
   	  			 if (contaTabella("utenti", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in nuovoutente:"+user+" "+password,"WSData/nuovoUtente/contaTabella");resp.set_return(false);}
   	  			 if (contaTabella("utenti", where)==0) 
   	  			 {//non ci sono utenti omonimi, posso creare
   	  				 String insertQuery="INSERT INTO utenti VALUES ("+
				   		"NULL"+","+//id autoincrement
						"'"+user+"',"+//username
				   		"'"+password+"',"+//password
				   		"'"+nome+"',"+//nome
				   		"'"+cognome+"',"+//cognome
				   		"'"+email+"',"+//email
				   		"'"+0+"',"+//is_ia
				   		"'"+1+"',"+//is_online. come lo creo, lo metto online perch� lo autorizzo gi�
				   		"'"+0+"',"+//vinte
				   		"'"+0+"',"+//pareggiate
				   		"'"+0+"',"+//perse
				   		"'"+0+"',"+//is_admin
				   		"'"+currentDate+"'"+//data_creazione
						");";
   	  				 s.executeUpdate(insertQuery);
   	  				 //amicizia default
   	  				 s.executeQuery ("SELECT id FROM utenti where username like '"+user+"';");
	  				 ResultSet rsToken=s.getResultSet();
	  				 rsToken.next();
	  				 int ID_Utente=rsToken.getInt(1);  	
	  				 s.executeQuery ("SELECT id FROM utenti where username LIKE 'MasterIA';");
	  				 ResultSet rsAmico=s.getResultSet();
	  				 rsAmico.next();
	  				 int ID_Amico=rsAmico.getInt(1);  	
   	  				 insertLOG("INSERT:"+insertQuery,"WSData/nuovoUtente");
   	  				 insertQuery="INSERT INTO amici VALUES ("+
	  							"'"+ID_Utente+"',"+//id_utente
	  					   		"'"+ID_Amico+"',"+//id_amico
	  					   		"'"+currentDate+"'"+//data_creazione
	  							");";
   	  				 s.executeUpdate(insertQuery);
	  				 insertLOG("INSERT:"+insertQuery,"WSData/nuovoUtente");
   	  				 resp.set_return(true);
   	  			 }
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/nuovoUtente");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/nuovoUtente");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
    }
     /**Modifica dell'utente loggato. Pu� modificare i dati anagrafici, ma non lo username.
      * Recupera lo username dal token.
      * Mette is_online=1
      * @param modificaUtente ( password, nome, cognome, email)
      * @return ModificaUtenteResponse (boolean conferma)
      */
     
     public data.ModificaUtenteResponse modificaUtente(data.ModificaUtente modificaUtente)
     {
    	 ModificaUtenteResponse resp=new ModificaUtenteResponse();
    	 String idtoken=modificaUtente.getIdtoken();
    	 String nome=modificaUtente.getNome();
    	 String cognome=modificaUtente.getCognome();
   	  	 String password=modificaUtente.getPassword();
   	  	 String email=modificaUtente.getEmail();
   	  	 
   	  	 setupDB();
   	  	 try
   	  	 {
   	  		 if (connection != null) {
   	  			 Statement s;
   	  			 s=connection.createStatement();
   	  			 String where=" idtoken='"+idtoken+"';";
   	  			 // ci sono sessioni valide per il token?
   	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in modificaUtente:"+idtoken,"WSData/modificaUtente/contaTabella");resp.set_return(false);}
   	  			 if (contaTabella("sessioni", where)==1) 
   	  			 {//c'� il token, posso modificare l'utente
   	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
   	  				 ResultSet rsToken=s.getResultSet();
   	  				 rsToken.next();
   	  				 int ID_Utente=rsToken.getInt(1);  			   
   	  				 //aggiorno utente + is_online
   	  				 String updateQuery="UPDATE utenti SET " +
   	  						 			" password='"+ password +"', " +
   	  						 			" nome='"+ nome +"', " +
   	  						 			" cognome='"+ cognome+"', " +
   	  						 			" email='"+ email +"', " +
   	  						 			" is_online='1' where id="+ID_Utente+";";
   	  				 
   	  				 s.executeUpdate(updateQuery);
   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/modificaUtente");
   	  				 resp.set_return(true);
   	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/modificaUtente");}
   	  			 s.close();
   	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/modificaUtente");}
   	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/modificaUtente");}
   	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
   	  	 return resp;
     }
     /** Cancellazione dell'utente loggato, recuperato tramite il token.
      * Lo username potrebbe servire per cancellazioni da administrator. Da valutare.
      * 
      * @param cancellaUtente (token,username)
      * @return CancellaUtenteResponse (boolean di conferma) 
      */           
     public data.CancellaUtenteResponse cancellaUtente(data.CancellaUtente cancellaUtente)
     {
    	CancellaUtenteResponse resp= new CancellaUtenteResponse();
    	String idtoken= cancellaUtente.getIdtoken();
    	String username= cancellaUtente.getUsername();
    	
    	setupDB();
  	  	 try
  	  	 {
  	  		 if (connection != null) {
  	  			 Statement s;
  	  			 s=connection.createStatement();
  	  			 String where=" idtoken='"+idtoken+"';";
  	  			 // ci sono sessioni valide per il token?
  	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in cancellaUtente:"+idtoken,"WSData/cancellaUtente/contaTabella");resp.set_return(false);}
  	  			 if (contaTabella("sessioni", where)==1) 
  	  			 {//c'� il token, posso modificare l'utente
  	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
  	  				 ResultSet rsToken=s.getResultSet();
  	  				 rsToken.next();
  	  				 int ID_Utente=rsToken.getInt(1);  
  	  				 //cancello sessioni
  	  				 String deleteQuery1="DELETE FROM sessioni WHERE id_utente="+ID_Utente;
  	  				 s.executeUpdate(deleteQuery1);
 	  				 insertLOG("DELETE:"+deleteQuery1,"WSData/cancellaUtenti");
 	  				 
 	  				 //cancello utente
  	  				 String deleteQuery2="DELETE FROM utenti WHERE id="+ID_Utente;
  	  				 s.executeUpdate(deleteQuery2);
 	  				 insertLOG("DELETE:"+deleteQuery2,"WSData/cancellaUtenti");
  	  				 resp.set_return(true);
  	  				 
  	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/cancellaUtenti");}
  	  			 s.close();
  	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/cancellaUtenti");}
  	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/cancellaUtenti");}
  	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
  	  	 return resp;
     }
     /** Ritorna il token di sessione valido per l'utente loggato.
      * 
      * @param GetIdtoken ( username, password)
      * @return GetIdtokenResponse (token string) 
      */    
      public data.GetIdtokenResponse getIdtoken(data.GetIdtoken getIdtoken){
    	  GetIdtokenResponse resp=new GetIdtokenResponse();
    	  String user=getIdtoken.getUsername();
    	  String[] password=getIdtoken.getPassword().split("-");
    	  
    	  String currentTime=dateNow();
    	  int ID_Utente=0;
    	  String pass="";
    	  
		  String token=user+ Arrays.toString(password) +currentTime;
		  token=hashCode(token, "SHA-1");
    	  setupDB();
    	  try
    	  {
    	  if (connection != null) {
    		  Statement s;
    		  s=connection.createStatement();
    		   
    		  String where=" username like '"+user+"'";
	   		//			" and password like '"+password+"';";
    		  // ci sono utenti validi?
    		   if (contaTabella("utenti", where)==-1) {insertLOG("ERR:notoken;Exception in contaTabella in getIdToken:"+user+" "+ Arrays.toString(password),"WSData/getIdtoken/contaTabella");resp.set_return("ERR:notoken");}
    		   if (contaTabella("utenti", where)==0) {insertLOG("ERR:notoken;Nessun utente con login  passata:"+user+" "+ Arrays.toString(password),"WSData/getIdtoken");resp.set_return("ERR:notoken");}
    		   else
    		   { 
    			   s.executeQuery ("SELECT id,password FROM utenti where " +
		   					"username LIKE '"+user+"'" +
		   				  ";");
    			   ResultSet rsID = s.getResultSet ();
    			   if(rsID.next())
    			   {
    				   ID_Utente=rsID.getInt(1);
    				   pass=rsID.getString(2);
    			   }
    			   
    			   if(ID_Utente!=0 && !pass.equals(""))
    			   {
    			   if(hashCode(pass+password[1],"SHA-1").equals(password[0]))
    			   {
    				   where="id_utente="+ID_Utente;
    			   
    				   if (contaTabella("sessioni", where)==0)
    				   {//non esiste il token, lo creo 
    					   String insertQuery="INSERT INTO sessioni VALUES ("+
    				   		"NULL"+","+//id autoincrement
    						"'"+token+"',"+//idtoken
    				   		"'"+ID_Utente+"',"+//id_utente
    				   		"'"+currentTime+"'"+//data
    						");";
    					   s.executeUpdate(insertQuery);
    					   insertLOG("INSERT:"+insertQuery,"WSData/getIdtoken");
    					   resp.set_return(token);
    				   }else
    				   {//sessione c'�,  aggiorno token e data
    					   s.executeQuery ("SELECT id FROM sessioni where id_utente="+ID_Utente);
    					   ResultSet rsToken=s.getResultSet();
    					   rsToken.next();
    					   int ID_Sessione=rsToken.getInt(1);
    					   String updateQuery="UPDATE sessioni SET idtoken='"+token+"',data_inizio='"+currentTime+"' where id="+ID_Sessione+";";
    					   s.executeUpdate(updateQuery);
    					   insertLOG("UPDATE:"+updateQuery,"WSData/getIdtoken");
        			   
    					   //aggiorno is_online dell'utente per segnalarlo online
    					   String updateQuery2="UPDATE utenti SET is_online='1' where id="+ID_Utente+";";
    					   s.executeUpdate(updateQuery2);
    					   insertLOG("UPDATE:"+updateQuery2,"WSData/getIdtoken");
    					   resp.set_return(token);
    				   }
    			   }else {resp.set_return("ERR:invalidPassword");insertLOG("ERR:invalidPassword", "WSData/getIdtoken");}
    			   }else {resp.set_return("ERR:noUser");insertLOG("ERR:noUser", "WSData/getIdtoken");}
    			  
    		   }
    		   s.close();
   		  } else {resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getIdtoken");}	  
    	  }catch(Exception e){resp.set_return("ERR:"+e.toString());insertLOG("ERR:"+e.toString(), "WSData/getIdtoken");}
    	  finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
    	  
    	  
    	  return resp;
      }
      
      
      ////////////////////////////////////////////////////////////////// GAME //////////////////// 
      //																						//
      //																						//
      ////////////////////////////////////////////////////////////////////////////////////////////
      /**Aggiorna il tipo ad una partita esistente. 
       * 
       *
       * @param UpdateTipo (String idtoken,String username, String nome_partita,String tipo_nuovo)
       * @return UpdateTipoResponse (String conferma)
       */
      public data.UpdateTipoResponse updateTipo ( data.UpdateTipo updateTipo)
      {
    	  data.UpdateTipoResponse resp=new UpdateTipoResponse();
          String idtoken=updateTipo.getIdtoken();
          String username=updateTipo.getUsername();
          String nome_partita=updateTipo.getNomePartita();
          String tipo_nuovo=updateTipo.getTipo_nuovo();
          String currentDate=dateNow();
          int ID_Utente=0;
          int ID_Partita=0;
          setupDB();
          	try
         	{
          		if (connection != null) {
          			Statement s;
         	  		s=connection.createStatement();
         	  		String where=" idtoken='"+idtoken+"';";
         	  		// ci sono sessioni valide per il token?
         	  		if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in updateTipo:"+idtoken,"WSData/updateTipo/ContaTabella");resp.set_return("Err:noUser");}
         	  			 if (contaTabella("sessioni", where)==1) 
         	  			 {//c'� il token, posso controllare se esiste la partita
         	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
         	  				 ResultSet rsUtente1=s.getResultSet();
         	  				 if(rsUtente1.next()) ID_Utente=rsUtente1.getInt(1);//se esiste l'utente
         	  				   
        	  				 if(ID_Utente!=0) //se esiste l'utente
        	  				 { 
        	  					 s.executeQuery ("SELECT id FROM partite where " +
        	  					 				"(id_utente1="+ID_Utente+" or " +
        	  					 				"id_utente2="+ID_Utente+") and nome_partita like '"+nome_partita+"'");
            	  				 ResultSet rsPartita=s.getResultSet();
            	  				 if(rsPartita.next()) {ID_Partita=rsPartita.getInt(1);}
            	  				
            	  				 if(ID_Partita!=0)//se esiste la partita con questo utente
            	  				 {
            	  					String updateQuery="UPDATE partite SET " +
            	  										" tipo='"+tipo_nuovo+"' "+ 
            	  										"where id="+ID_Partita;
            	   	  				 s.executeUpdate(updateQuery);
            	   	  				 insertLOG("UPDATE:"+updateQuery,"WSData/updateTipo");
            	   	  				 resp.set_return("OK");
            	  				 }
            	  				 else {resp.set_return("ERR:NoMatch");insertLOG("ERR:NoMatch", "WSData/updateTipo");}
        	  				 }else{resp.set_return("ERR:InvalidUsers");insertLOG("ERR:InvalidUsers", "WSData/updateTipo");}
         	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/updateTipo");}
         	  			 s.close();
         	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/updateTipo");}
         	}catch(Exception e){resp.set_return("ERR:"+e.toString());insertLOG("ERR:"+e.toString(), "WSData/updateTipo");}
          	finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
          	return resp;
      }
      /**Restituisce la lista dei nomi delle partite in cui il giocatore � dentro, in base al tipo scelto. 
       * 
       *
       * @param getPartite (String idtoken,String username, String tipo)
       * @return GetPartiteResponse (boolean conferma)
       */
      public data.GetPartiteResponse getPartite(data.GetPartite getPartite)
      {
    	  data.GetPartiteResponse resp=new GetPartiteResponse();
          String idtoken=getPartite.getIdtoken();
          String username=getPartite.getUsername();
          String tipo=getPartite.getTipo();
          int ID_Utente=0;
          String listaPartite="";
          String CHAR_SEPARATE=";";
          setupDB();
          	try
         	{
          		if (connection != null) {
          			Statement s;
         	  		s=connection.createStatement();
         	  		String where=" idtoken='"+idtoken+"';";
         	  		// ci sono sessioni valide per il token?
         	  		if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getPartite:"+idtoken,"WSData/getPartite/ContaTabella");resp.set_return("Err:noUser");}
         	  			 if (contaTabella("sessioni", where)==1) 
         	  			 {//c'� il token, posso controllare se esiste la partita
         	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
         	  				 ResultSet rsUtente1=s.getResultSet();
         	  				 if(rsUtente1.next()) ID_Utente=rsUtente1.getInt(1);//se esiste l'utente
         	  				   
        	  				 if(ID_Utente!=0) //se esiste l'utente
        	  				 { 
        	  					 String selectQuery="SELECT nome_partita FROM partite where " +
 	  					 				"(id_utente1="+ID_Utente+" or " +
 	  					 				"id_utente2="+ID_Utente+") and tipo like '"+tipo+"'";
        	  					 s.executeQuery (selectQuery); 
            	  				 ResultSet rsPartita=s.getResultSet();
            	  				//insertLOG("SELECT:"+selectQuery, "WSData/getPartite");
            	  				while(rsPartita.next())
       	   	  				 	{//finch� trova posizioni, creo la stringa
            	  					listaPartite+=rsPartita.getString(1)+CHAR_SEPARATE;
       	   	  					}
       	   	  				 	//tolgo il carattere separatore finale
       	   	  				 	if(listaPartite.endsWith(CHAR_SEPARATE))listaPartite = listaPartite.substring(0,listaPartite.length()-1);
       	   	  				 	resp.set_return(listaPartite);
        	  				 }else{resp.set_return("ERR:InvalidUsers");insertLOG("ERR:InvalidUsers", "WSData/getPartite");}
         	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/getPartite");}
         	  			 s.close();
         	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getPartite");}
         	}catch(Exception e){resp.set_return("ERR:"+e.toString());insertLOG("ERR:"+e.toString(), "WSData/getPartite");}
          	finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
          	return resp;
      }
      /**Restituisce le posizioni iniziali di una partita in cui l'utente partecipa. 
      * Le posizioni sono nel formato pedina:posizione;
      *
      * @param GetPosizioniIniziali (String idtoken,String username, String nome_partita)
      * @return GetPosizioniInizialiResponse (boolean conferma)
      */
      public data.GetPosizioniInizialiResponse getPosizioniIniziali(data.GetPosizioniIniziali getPosizioniIniziali)
      {
    	  data.GetPosizioniInizialiResponse resp=new GetPosizioniInizialiResponse();
          String idtoken=getPosizioniIniziali.getIdtoken();
          String username=getPosizioniIniziali.getUsername();
          String nome_partita=getPosizioniIniziali.getNomePartita();
          String currentDate=dateNow();
          int ID_Utente=0;
          int ID_Partita=0;
          String posizioni="";
          String CHAR_SEPARATE=";";
          setupDB();
          	try
         	{
          		if (connection != null) {
          			Statement s;
         	  		s=connection.createStatement();
         	  		String where=" idtoken='"+idtoken+"';";
         	  		// ci sono sessioni valide per il token?
         	  		if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getPosizioniIniziali:"+idtoken,"WSData/getPosizioniIniziali/ContaTabella");resp.set_return("Err:noUser");}
         	  			 if (contaTabella("sessioni", where)==1) 
         	  			 {//c'� il token, posso controllare se esiste la partita
         	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
         	  				 ResultSet rsUtente1=s.getResultSet();
         	  				 if(rsUtente1.next()) ID_Utente=rsUtente1.getInt(1);//se esiste l'utente
         	  				   
        	  				 if(ID_Utente!=0) //se esiste l'utente
        	  				 { 
        	  					 s.executeQuery ("SELECT id FROM partite where " +
        	  					 				"(id_utente1="+ID_Utente+" or " +
        	  					 				"id_utente2="+ID_Utente+") and nome_partita like '"+nome_partita+"'");
            	  				 ResultSet rsPartita=s.getResultSet();
            	  				 if(rsPartita.next()) {ID_Partita=rsPartita.getInt(1);}
            	  				
            	  				 if(ID_Partita!=0)//se esiste la partita con questo utente
            	  				 {
            	  					String selectQuery="SELECT id, pedina, posizione " +
            	  										" FROM posizioni_iniziali where id_partita="+ID_Partita +" order by id";
            	   	  				 s.executeQuery (selectQuery);
            	   	  				 ResultSet rsPosizioni=s.getResultSet();
            	   	  				 //insertLOG("SELECT: "+selectQuery, "WSData/getPosizioniIniziali");
            	   	  				 while(rsPosizioni.next())
            	   	  				 {//finch� trova posizioni, creo la stringa
            	   	  				posizioni+=rsPosizioni.getString(2)+":"+rsPosizioni.getInt(3)+CHAR_SEPARATE;
            	   	  				 }
            	   	  				 //tolgo il carattere separatore finale
            	   	  				 if(posizioni.endsWith(CHAR_SEPARATE))posizioni = posizioni.substring(0,posizioni.length()-1);
            	   	  				 resp.set_return(posizioni);
            	  				 }
            	  				 else {resp.set_return("ERR:NoMatch");insertLOG("ERR:NoMatch", "WSData/getPosizioniIniziali");}
        	  				 }else{resp.set_return("ERR:InvalidUsers");insertLOG("ERR:InvalidUsers", "WSData/getPosizioniIniziali");}
         	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/getPosizioniIniziali");}
         	  			 s.close();
         	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getPosizioniIniziali");}
         	}catch(Exception e){resp.set_return("ERR:"+e.toString());insertLOG("ERR:"+e.toString(), "WSData/getPosizioniIniziali");}
          	finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
          	return resp;
      }
      /**Restituisce le mosse di una partita in cui l'utente partecipa. Le mosse sono tutte quelle fatte,
       * nel formato pos_iniziale(mangia)pos_finale;
      *
      * @param GetMosse (String idtoken,String username, String nome_partita)
      * @return GetMosseResponse (boolean conferma)
      */
      public data.GetMosseResponse getMosse(data.GetMosse getMosse)
      {
    	  data.GetMosseResponse resp=new GetMosseResponse();
          String idtoken=getMosse.getIdtoken();
          String username=getMosse.getUsername();
          String nome_partita=getMosse.getNomePartita();
          String currentDate=dateNow();
          int ID_Utente=0;
          int ID_Partita=0;
          String mosse="";
          String CHAR_SEPARATE=";";
          setupDB();
          	try
         	{
          		if (connection != null) {
          			Statement s;
         	  		s=connection.createStatement();
         	  		String where=" idtoken='"+idtoken+"';";
         	  		// ci sono sessioni valide per il token?
         	  		if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getMosse:"+idtoken,"WSData/getMosse/ContaTabella");resp.set_return("Err:noUser");}
         	  			 if (contaTabella("sessioni", where)==1) 
         	  			 {//c'� il token, posso controllare se esiste la partita
         	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
         	  				 ResultSet rsUtente1=s.getResultSet();
         	  				 if(rsUtente1.next()) ID_Utente=rsUtente1.getInt(1);//se esiste l'utente
         	  				   
        	  				 if(ID_Utente!=0) //se esiste l'utente
        	  				 { 
        	  					 s.executeQuery ("SELECT id FROM partite where " +
        	  					 				"(id_utente1="+ID_Utente+" or " +
        	  					 				"id_utente2="+ID_Utente+") and nome_partita like '"+nome_partita+"'");
            	  				 ResultSet rsPartita=s.getResultSet();
            	  				 if(rsPartita.next()) {ID_Partita=rsPartita.getInt(1);}
            	  				
            	  				 if(ID_Partita!=0)//se esiste la partita con questo utente
            	  				 {
            	  					String selectQuery="SELECT mosse.id, pos_iniziale, mangia, pos_finale, username " +
            	  										" FROM mosse inner join utenti on mosse.id_utente=utenti.id " +
            	  										" where id_partita="+ID_Partita +" order by mosse.id";
            	   	  				 s.executeQuery (selectQuery);
            	   	  				 ResultSet rsMosse=s.getResultSet();
            	   	  				 //insertLOG("SELECT: "+selectQuery, "WSData/getMosse");
            	   	  				 while(rsMosse.next())
            	   	  				 {//finch� trova mosse, creo la stringa
            	   	  					 mosse+="("+rsMosse.getString(5)+")"+rsMosse.getInt(2)+rsMosse.getString(3)+rsMosse.getInt(4)+CHAR_SEPARATE;
            	   	  				 }
            	   	  				 //tolgo il carattere separatore finale
            	   	  				 if(mosse.endsWith(CHAR_SEPARATE))mosse = mosse.substring(0, mosse.length()-1);
            	   	  				 resp.set_return(mosse);
            	  				 }
            	  				 else {resp.set_return("ERR:NoMatch");insertLOG("ERR:NoMatch", "WSData/getMosse");}
        	  				 }else{resp.set_return("ERR:InvalidUsers");insertLOG("ERR:InvalidUsers", "WSData/getMosse");}
         	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/getMosse");}
         	  			 s.close();
         	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getMosse");}
         	}catch(Exception e){resp.set_return("ERR:"+e.toString());insertLOG("ERR:"+e.toString(), "WSData/getMosse");}
          	finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
          	return resp;
      }
      /**Restituisce il nome della partita associata a giocatore e giocatore sfidato
      *
      * @param GetNomePartita (String idtoken,String username, String username_sfidato)
      * @return GetNomePartitaResponse (boolean conferma)
      */
      public data.GetNomePartitaResponse getNomePartita(data.GetNomePartita getNomePartita)
      {
    	data.GetNomePartitaResponse resp=new GetNomePartitaResponse();
        String idtoken=getNomePartita.getIdtoken();
        	 String username=getNomePartita.getUsername();
        	 String username_sfidato=getNomePartita.getUsername_sfidato();
        	 String currentDate=dateNow();
        	 int ID_Utente=0;
        	 int ID_Utente_sfidato=0;
        	 setupDB();
       	  	 try
       	  	 {
       	  		 if (connection != null) {
       	  			 Statement s;
       	  			 s=connection.createStatement();
       	  			 String where=" idtoken='"+idtoken+"';";
       	  			 // ci sono sessioni valide per il token?
       	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getNomePartita:"+idtoken,"WSData/getNomePartita/ContaTabella");resp.set_return("Err:noUser");}
       	  			 if (contaTabella("sessioni", where)==1) 
       	  			 {//c'� il token, posso controllare se esiste la partita
       	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
       	  				 ResultSet rsUtente1=s.getResultSet();
       	  				 if(rsUtente1.next()) ID_Utente=rsUtente1.getInt(1);//se esiste l'utente
       	  				 s.executeQuery ("SELECT id FROM utenti where username like '"+username_sfidato+"'");
       	  				 ResultSet rsUtente2=s.getResultSet();
       	  				 if(rsUtente2.next()) ID_Utente_sfidato=rsUtente2.getInt(1);//se esiste l'utente sfidato  
       	  				 String query="";
       	  				 if(ID_Utente!=0 && ID_Utente_sfidato!=0) //se esistono entrambi i giocatori
      	  				 { 	
       	  					 query="SELECT nome_partita FROM partite where " +
 					 				"(id_utente1="+ID_Utente+" and id_utente2="+ID_Utente_sfidato+") or " +
 					 				"(id_utente1="+ID_Utente_sfidato+" and id_utente2="+ID_Utente+") order by id DESC";
      	  					 s.executeQuery (query);
          	  				 ResultSet rsPartita=s.getResultSet();
          	  				 if(rsPartita.next()){resp.set_return(rsPartita.getString(1));}
          	  				 else {resp.set_return("ERR:NoMatch");insertLOG("ERR:NoMatch: "+query, "WSData/getNomePartita");}
      	  				 }else{resp.set_return("ERR:InvalidUsers");insertLOG("ERR:InvalidUsers", "WSData/getNomePartita");}
       	  			 }else{resp.set_return("ERR:InvalidTokenRequest");insertLOG("ERR:InvalidTokenRequest", "WSData/getNomePartita");}
       	  			 s.close();
       	  		 }else{resp.set_return("ERR:noConn");insertLOG("ERR:noConn", "WSData/getNomePartita");}
       	  	 }catch(Exception e){resp.set_return("ERR:"+e.toString());insertLOG("ERR:"+e.toString(), "WSData/getNomePartita");}
       	  finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
       	  	 return resp;
      }
      /**Verifica se il chiamante � l'utente che inizia la sfida.
      *
      * @param IsUtenteIniziale (String idtoken,String nomePartita, String username)
      * @return IsUtenteInizialeResponse (boolean conferma)
      */
      public data.IsUtenteInizialeResponse isUtenteIniziale(data.IsUtenteIniziale isUtenteIniziale)
      {
    	  data.IsUtenteInizialeResponse resp=new IsUtenteInizialeResponse();
       	 String idtoken=isUtenteIniziale.getIdtoken();
       	 String nomePartita=isUtenteIniziale.getNomePartita();
       	  int ID_Utente=0;
       	  int ID_Partita=0;
       	 setupDB();
      	  	 try
      	  	 {
      	  		 if (connection != null) {
      	  			 Statement s;
      	  			 s=connection.createStatement();
      	  			 String where=" idtoken='"+idtoken+"';";
      	  			 // ci sono sessioni valide per il token?
      	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in isUtenteIniziale:"+idtoken,"WSData/isUtenteIniziale/ContaTabella");resp.set_return(false);}
      	  			 if (contaTabella("sessioni", where)==1) 
      	  			 {//c'� il token, posso controllare se esiste la partita
      	  				s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
      	  				ResultSet rsToken=s.getResultSet();
      	  				if(rsToken.next())ID_Utente=rsToken.getInt(1);
      	  				if(ID_Utente!=0){ //l'utente esiste
      	  				 s.executeQuery ("SELECT id FROM partite where nome_partita like '"+nomePartita+"'");
      	  				 ResultSet rsPartita=s.getResultSet();
      	  				 if(rsPartita.next()) ID_Partita=rsPartita.getInt(1);//se esiste la partita
      	  				 
     	  				 if(ID_Partita!=0) //se esiste la partita
     	  				 { 
     	  				 	
     	   	  				 String selectQuery1="SELECT id FROM partite where id="+ID_Partita+
     	   	  						 									 " and id_utente1="+ID_Utente +
     	   	  						 									 " and n_giocatore_init=1";
     	   	  				 s.executeQuery(selectQuery1);
     	   	  				 //insertLOG("SELECT:"+selectQuery1,"WSData/isUtenteIniziale");
     	   	  				 ResultSet rsUtente1=s.getResultSet();
     	   	  				 if(rsUtente1.next()){resp.set_return(true);}//l'utente � il primo e tocca a lui
     	   	  				 else{
     	   	  					 String selectQuery2="SELECT id FROM partite where id="+ID_Partita+
		 									 " and id_utente2="+ID_Utente +
		 									 " and n_giocatore_init=2";
     	   	  					 s.executeQuery(selectQuery2);
     	   	  					 //insertLOG("SELECT:"+selectQuery2,"WSData/isUtenteIniziale");
     	   	  					 ResultSet rsUtente2=s.getResultSet();
     	   	  					 if(rsUtente2.next()){resp.set_return(true);}//l'utente � il secondo e tocca a lui
     	   	  					 else{resp.set_return(false);}//utente e turno iniziale sono discordi
     	   	  				 }
     	  				 }else{resp.set_return(false);insertLOG("ERR:InvalidMatchName", "WSData/isUtenteIniziale");}
      	  				}else{resp.set_return(false);insertLOG("ERR:InvalidUser", "WSData/isUtenteIniziale");}
      	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/isUtenteIniziale");}
      	  			 s.close();
      	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/isUtenteIniziale");}
      	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/isUtenteIniziale");}
      	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
      	  	 return resp;
      }
      /**Inserimento in database di una mossa valida.
      *
      * @param InsertMossa (String idtoken,String nomePartita, int pos_iniziale,int pos_finale)
      * @return InsertMossaResponse (boolean conferma)
      */
      public data.InsertMossaResponse insertMossa(data.InsertMossa insertMossa)
      {
    	 data.InsertMossaResponse resp=new InsertMossaResponse();
       	 String idtoken=insertMossa.getIdtoken();
       	 String nomePartita=insertMossa.getNomePartita();
       	 String username=insertMossa.getUsername();
       	 int pos_iniziale=insertMossa.getPos_iniziale();
       	 int pos_finale=insertMossa.getPos_finale();
       	 String mangia=insertMossa.getMangia();
       	 String currentDate=dateNow();
       	 int ID_Partita=0;
       	 int ID_Utente=0;
       	 setupDB();
      	  	 try
      	  	 {
      	  		 if (connection != null) {
      	  			 Statement s;
      	  			 s=connection.createStatement();
      	  			 String where=" idtoken='"+idtoken+"';";
      	  			 // ci sono sessioni valide per il token?
      	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in insertMossa:"+idtoken,"WSData/insertMossa/ContaTabella");resp.set_return(false);}
      	  			 if (contaTabella("sessioni", where)==1) 
      	  			 {//c'� il token, posso controllare se esiste la partita
      	  				 s.executeQuery ("SELECT id FROM partite where nome_partita like '"+nomePartita+"'");
      	  				 ResultSet rsPartita=s.getResultSet();
      	  				 if(rsPartita.next()) ID_Partita=rsPartita.getInt(1);//se esiste la partita
      	  				 if(username.startsWith("IA"))
      	  				 {//salvo la mossa come se l'avesse fatta lo username avversario (simula IA)
      	  					 username=username.substring(2);
      	  					 s.executeQuery ("SELECT id FROM utenti where username LIKE '"+username+"'");
      	  				 }else{
      	  					s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
      	  				 }
      	  				 
      	  				 ResultSet rsToken=s.getResultSet();
      	  				 rsToken.next();
      	  				 ID_Utente=rsToken.getInt(1);  
     	  				 if(ID_Partita!=0 && ID_Utente!=0) //se esiste la partita e il giocatore
     	  				 { 
     	   	  				 String insertQuery="INSERT INTO mosse VALUES ("+
     	   	  				 					 "NULL"+","+//id autoincrement
     	   	  				 					 "'"+ID_Partita+"',"+//id partita relativa al nome
     	   	  				 					 "'"+ID_Utente+"',"+//id partita relativa al nome
     	   	  				 					 "'"+pos_iniziale+"',"+//pedina
     	   	  				 					 "'"+pos_finale+"',"+//posizione
     	   	  				 					 "'"+mangia+"',"+//posizione
     	   	  				 					 "'"+currentDate+"'"+//data_creazione
     	   	  				 					 ");";
     	   	  				 s.executeUpdate(insertQuery);
     	   	  				 insertLOG("INSERT:"+insertQuery,"WSData/insertMossa");
     	   	  				 resp.set_return(true);
     	   	  				 
     	  				 }else{resp.set_return(false);insertLOG("ERR:InvalidMatchName", "WSData/insertMossa");}
      	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/insertMossa");}
      	  			 s.close();
      	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/insertMossa");}
      	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/insertMossa");}
      	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
      	  	 return resp;
      }
      /**Inserimento in database della posizione iniziale di una pedina sul tavolo di gioco.
       *
       * @param InsertPosizioneIniziale ( String idtoken,String nomePartita, int pedina, int posizione)
       * @return InsertPosizioneInizialeResponse (boolean conferma)
       */
      public data.InsertPosizioneInizialeResponse insertPosizioneIniziale(data.InsertPosizioneIniziale insertPosizioneIniziale)
      {
    	 data.InsertPosizioneInizialeResponse resp=new InsertPosizioneInizialeResponse();
      	 String idtoken=insertPosizioneIniziale.getIdtoken();
      	 String nomePartita=insertPosizioneIniziale.getNomePartita();
      	 String pedina=insertPosizioneIniziale.getPedina();
      	 int posizione=insertPosizioneIniziale.getPosizione();
      	 String currentDate=dateNow();
      	 int ID_Partita=0;
      	 setupDB();
     	  	 try
     	  	 {
     	  		 if (connection != null) {
     	  			 Statement s;
     	  			 s=connection.createStatement();
     	  			 String where=" idtoken='"+idtoken+"';";
     	  			 // ci sono sessioni valide per il token?
     	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in insertPosizioneIniziale:"+idtoken,"WSData/insertPosizioneIniziale/ContaTabella");resp.set_return(false);}
     	  			 if (contaTabella("sessioni", where)==1) 
     	  			 {//c'� il token, posso controllare se esiste la partita
     	  				 s.executeQuery ("SELECT id FROM partite where nome_partita like '"+nomePartita+"'");
     	  				 ResultSet rsPartita=s.getResultSet();
     	  				 if(rsPartita.next()) ID_Partita=rsPartita.getInt(1);//se esiste la partita
     	  				 
    	  				 if(ID_Partita!=0) //se esiste la partita
    	  				 { 
    	  				 	
    	   	  				 String insertQuery="INSERT INTO posizioni_iniziali VALUES ("+
    	   	  				 					 "NULL"+","+//id autoincrement
    	   	  				 					 "'"+ID_Partita+"',"+//id partita relativa al nome
    	   	  				 					 "'"+pedina+"',"+//pedina
    	   	  				 					 "'"+posizione+"',"+//posizione
    	   	  				 					 "'"+currentDate+"'"+//data_creazione
    	   	  				 					 ");";
    	   	  				 s.executeUpdate(insertQuery);
    	   	  				 insertLOG("INSERT:"+insertQuery,"WSData/insertPosizioneIniziale");
    	   	  				 resp.set_return(true);
    	   	  				 
    	  				 }else{resp.set_return(false);insertLOG("ERR:InvalidMatchName", "WSData/insertPosizioneIniziale");}
     	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/insertPosizioneIniziale");}
     	  			 s.close();
     	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/insertPosizioneIniziale");}
     	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/insertPosizioneIniziale");}
     	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
     	  	 return resp;
      }
      /** Cancellazione della partita tra due utenti, recuperato tramite username dei partecipanti.
       * 
       * 
       * @param cancellaUtente (token,username)
       * @return CancellaUtenteResponse (boolean di conferma) 
       */ 
      public data.DeletePartitaResponse deletePartita(data.DeletePartita deletePartita)
      {
    	DeletePartitaResponse resp= new DeletePartitaResponse();
      	String idtoken= deletePartita.getIdtoken();
      	String nomePartita= deletePartita.getNomePartita();
      	
      	int ID_Partita=0;
      	int ID_Utente=0;
      	setupDB();
    	  	 try
    	  	 {
    	  		 if (connection != null) {
    	  			 Statement s;
    	  			 s=connection.createStatement();
    	  			 String where=" idtoken='"+idtoken+"';";
    	  			 // ci sono sessioni valide per il token?
    	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in deletePartita:"+idtoken,"WSData/deletePartita/contaTabella");resp.set_return(false);}
    	  			 if (contaTabella("sessioni", where)==1) 
    	  			 {//c'� il token, posso modificare l'utente
    	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
    	  				 ResultSet rsToken=s.getResultSet();
    	  				 if(rsToken.next())ID_Utente=rsToken.getInt(1);  
    	  				 s.executeQuery ("SELECT id FROM partite where nome_partita like '"+nomePartita+"'");
    	  				 ResultSet rsPartita=s.getResultSet();
    	  				 if(rsPartita.next()) ID_Partita=rsPartita.getInt(1);//se esiste la partita
    	  				 if(ID_Partita!=0 && ID_Utente!=0){
    	  					 //cancello posizioni_iniziali
    	  					 String deleteQuery1="DELETE FROM posizioni_iniziali WHERE id_partita ="+ID_Partita+";";
    	  					 s.executeUpdate(deleteQuery1);
    	  					 insertLOG("DELETE:"+deleteQuery1,"WSData/deletePartita");
    	  					//cancello mosse
    	  					 deleteQuery1="DELETE FROM mosse WHERE id_partita ="+ID_Partita+";";
    	  					 s.executeUpdate(deleteQuery1);
    	  					 insertLOG("DELETE:"+deleteQuery1,"WSData/deletePartita");
    	  					 //cancello partita
    	  					 deleteQuery1="DELETE FROM partite WHERE nome_partita like'"+nomePartita+"';";
    	  					 s.executeUpdate(deleteQuery1);
    	  					 insertLOG("DELETE:"+deleteQuery1,"WSData/deletePartita");
    	  					 resp.set_return(true);
    	  				 }else{resp.set_return(false);insertLOG("ERR:InvalidMatchName", "WSData/deletePartita");}
    	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/deletePartita");}
    	  			 s.close();
    	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/deletePartita");}
    	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/deletePartita");}
    	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
    	  	 return resp;
      }
      /**Inserimento in database di una nuova partita.Controlla se esiste una precedente partita e
       * inserisce la nuova quando possibile (1 partita per coppia). nomePartita � univoco
       *
       * @param InsertPartita ( String idtoken,String nomePartita, byte nGiocatoreInit, String username1,
       * 						String username2,double livello1,double livello2,boolean allenamento1,boolean allenamento2)
       * @return InsertPartitaResponse (boolean conferma)
       */
      public data.InsertPartitaResponse insertPartita(data.InsertPartita insertPartita)
      {
    	  data.InsertPartitaResponse resp=new InsertPartitaResponse();
     	 String idtoken=insertPartita.getIdtoken();
     	 String nomePartita=insertPartita.getNomePartita();
     	 byte nGiocatoreInit=insertPartita.getNGiocatoreInit();
     	 String username_sfidante=insertPartita.getUsername();
     	 String username_sfidato=insertPartita.getUsername_sfidato();
     	 double livello1=insertPartita.getLivello1();
     	 double livello2=insertPartita.getLivello2();
    	 boolean allenamento1=insertPartita.getAllenamento1();
    	 boolean allenamento2=insertPartita.getAllenamento2();
    	 
    	 int ID_Utente1=0;
    	 int ID_Utente2=0;
     	 String currentDate=dateNow();
     	 setupDB();
    	  	 try
    	  	 {
    	  		 if (connection != null) {
    	  			 Statement s;
    	  			 s=connection.createStatement();
    	  			 String where=" idtoken='"+idtoken+"';";
    	  			 // ci sono sessioni valide per il token?
    	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in insertPartita:"+idtoken,"WSData/insertPartita/ContaTabella");resp.set_return(false);}
    	  			 if (contaTabella("sessioni", where)==1) 
    	  			 {//c'� il token, posso controllare i due utenti del token
    	  				s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
      	  				 ResultSet rsToken=s.getResultSet();
      	  				 if(rsToken.next()){ ID_Utente1=rsToken.getInt(1);} //se il token � corretto, utente1 �
      	  				 												  //il proprietario del token
    	  				 
    	  				 s.executeQuery ("SELECT id FROM utenti where username like '"+username_sfidato+"'");
   	  				 	 ResultSet rsUser2=s.getResultSet();
   	  				 	 if(rsUser2.next())ID_Utente2=rsUser2.getInt(1);//se esiste l'utente
   	  				 	 if(ID_Utente1!=0 && ID_Utente2!=0) //esistono entrambi i giocatori
   	  				 	 { //cerco una partita pre-esistente tra i due (solo partite con tipo=0)
   	  				 		 String selectQuery="SELECT id_utente2 AS 'id_utente' FROM partite " +
 	  							" WHERE id_utente1="+ID_Utente1+" AND id_utente2="+ID_Utente2+" and tipo=0 " +
 	  									"UNION " +
 									"SELECT id_utente1 AS 'id_utente' FROM partite " +
 							" WHERE id_utente1="+ID_Utente2+" AND id_utente2="+ID_Utente1+" and tipo=0 ";
   	  				 		 s.executeQuery (selectQuery);
   	  				 		 ResultSet rsPartita=s.getResultSet();
   	  				 		 //insertLOG("SELECT: "+selectQuery, "WSData/insertPartita");
 		  				
   	  				 		 if(!rsPartita.next())
   	  				 		 {//non sono partite pre-esistenti tra i due
   	  				 			 String selectQueryNome="SELECT nome_partita as 'NOME_PARTITA' FROM partite " +
   	 	  							" WHERE nome_partita like '"+nomePartita+"';";
   	   	  				 		 s.executeQuery (selectQueryNome);
   	   	  				 		 //insertLOG("SELECT: "+selectQueryNome, "WSData/insertPartita");
   	   	  				 		 ResultSet rsNomePartita=s.getResultSet();
   	   	  				 		 
   	   	  				 		 if(!rsNomePartita.next())
   	   	  				 		 {//non ci sono partite con lo stesso nome, si pu� inserire il record
   	   	  				 			 String insertQuery="INSERT INTO partite VALUES ("+
   	   	  				 					 "NULL"+","+//id autoincrement
   	   	  				 					 "'"+nomePartita+"',"+//nome partita univoco possibilmente
   	   	  				 					 "'"+nGiocatoreInit+"',"+//nGiocatore init
   	   	  				 					 "'"+ID_Utente1+"',"+//id utente 1
   	   	  				 					 "'"+ID_Utente2+"',"+//id utente 2
   	   	  				 					 "'"+livello1+"',"+//livello1
   	   	  				 					 "'"+livello2+"',"+//livello2
   	   	  				 					 "'"+(allenamento1?1:0)+"',"+//allenamento1 se true=1, else =0
   	   	  				 					 "'"+(allenamento2?1:0)+"',"+//allenamento2 se true=1, else =0
   	   	  				 					 "'"+0+"',"+//tipo
   	   	  				 					 "'"+currentDate+"'"+//data_creazione
   	   	  				 					 ");";
   	   	  				 			 s.executeUpdate(insertQuery);
   	   	  				 			 insertLOG("INSERT:"+insertQuery,"WSData/insertPartita");
   	   	  				 			 resp.set_return(true);
   	   	  				 		 }else{resp.set_return(false);insertLOG("ERR:InvalidMatchName", "WSData/insertPartita");}
   	  				 		 }else{resp.set_return(false);insertLOG("ERR:InvalidMatch", "WSData/insertPartita");}
   	  				 	 }else{resp.set_return(false);insertLOG("ERR:InvalidUsers", "WSData/insertPartita");}
    	  			 }else{resp.set_return(false);insertLOG("ERR:InvalidTokenRequest", "WSData/insertPartita");}
    	  			 s.close();
    	  		 }else{resp.set_return(false);insertLOG("ERR:noConn", "WSData/insertPartita");}
    	  	 }catch(Exception e){resp.set_return(false);insertLOG("ERR:"+e.toString(), "WSData/insertPartita");}
    	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
    	  	 return resp;
	  }
      public data.GetPartitaIDResponse getPartitaID(data.GetPartitaID getPartitaID)
      {
    	 data.GetPartitaIDResponse resp=new GetPartitaIDResponse();
     	 String idtoken=getPartitaID.getIdtoken();
     	 String nomePartita=getPartitaID.getNomePartita();
     	 setupDB();
    	  	 try
    	  	 {
    	  		 if (connection != null) {
    	  			 Statement s;
    	  			 s=connection.createStatement();
    	  			 String where=" idtoken='"+idtoken+"';";
    	  			 // ci sono sessioni valide per il token?
    	  			 if (contaTabella("sessioni", where)==-1) {insertLOG("ERR:noUser;Exception in contaTabella in getPartitaID:"+idtoken,"WSData/getPartitaID/ContaTabella");resp.set_return(-1);}
    	  			 if (contaTabella("sessioni", where)==1) 
    	  			 {//c'� il token, posso scegliere l'utente del token
    	  				 s.executeQuery ("SELECT id_utente FROM sessioni where idtoken='"+idtoken+"'");
    	  				 ResultSet rsToken=s.getResultSet();
    	  				 
    	  				 if(rsToken.next())
    	  				 {
    	  					int ID_Utente=rsToken.getInt(1);  			   
    	  					//seleziono quante perse ha l'utente
    	  					String selectQuery="select id from partite where nome_partita like '"+nomePartita+"';";
       	  				 
       	  				 	s.executeQuery(selectQuery);
       	  				 	ResultSet rsID=s.getResultSet();
       	  				rsID.next();
       	  				 	//insertLOG("SELECT:"+selectQuery,"WSData/getPartitaID");
       	  				 	resp.set_return(rsID.getInt(1));
    	  				 }
    	  				 
    	  			 }else{resp.set_return(-1);insertLOG("ERR:InvalidTokenRequest", "WSData/getPartitaID");}
    	  			 s.close();
    	  		 }else{resp.set_return(-1);insertLOG("ERR:noConn", "WSData/getPartitaID");}
    	  	 }catch(Exception e){resp.set_return(-1);insertLOG("ERR:"+e.toString(), "WSData/getPartitaID");}
    	  	 finally{if (connection!=null)try {connection.close();} catch (SQLException ignored) {}}
    	  	 return resp;
      }
}
