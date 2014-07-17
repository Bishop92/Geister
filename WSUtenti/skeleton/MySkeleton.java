package skeleton;

import geister.CancellaAmiciResponse;
import geister.CancellaAmicoResponse;
import geister.CancellaUtenteResponse;
import geister.GetCognomeResponse;
import geister.GetEmailResponse;
import geister.GetListaAmiciResponse;
import geister.GetNomeResponse;
import geister.IsAmicoResponse;
import geister.IsIAResponse;
import geister.IsOnlineResponse;
import geister.IsPlayingResponse;
import geister.LoginResponse;
import geister.ModificaUtenteResponse;
import geister.NuovoAmicoResponse;
import geister.NuovoUtenteResponse;
import geister.SetCognomeResponse;
import geister.SetEmailResponse;
import geister.SetIAResponse;
import geister.SetNomeResponse;
import geister.SetOnlineResponse;
import geister.SetPasswordResponse;
import geister.SetPlayingResponse;

import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data.WSDataStub;
import data.WSDataStub.CancellaAmici;
import data.WSDataStub.CancellaAmico;
import data.WSDataStub.CancellaUtente;
import data.WSDataStub.GetIdtoken;
import data.WSDataStub.GetListaAmici;
import data.WSDataStub.GetListaUtentiOnline;
import data.WSDataStub.GetListaUtentiOnlineResponse;
import data.WSDataStub.GetUtenteNome;
import data.WSDataStub.GetUtenteNomeResponse;
import data.WSDataStub.GetUtentePerse;
import data.WSDataStub.GetUtenteVinte;
import data.WSDataStub.InsertLOG;
import data.WSDataStub.InsertLOGResponse;
import data.WSDataStub.ModificaUtente;
import data.WSDataStub.NuovoAmico;
import data.WSDataStub.NuovoUtente;
import data.WSDataStub.SetUtentePerse;
import data.WSDataStub.SetUtenteVinte;
/** Classe di definizione dei metodi implementati dal servizio WSUtenti, 
 * creato per agire sui dati relativi all'utente
 * <p><u><i>Elenco versioni:</i></u></p>
 *
 * <p><i>ver. 0.1&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 18/09/2011</i></p>
 * <ul>
 *   <li>bozza iniziale;</li>
 * </ul>
 * <p><i>ver. 1.0&nbsp;&nbsp;&nbsp; ~*~&nbsp;&nbsp;&nbsp; 07/10/2011</i></p>
 * <ul>
 *   <li>implementazione getIdtoken;</li>
 *   <li>implementazione nuovoUtente;</li>
 *   <li>implementazione modificaUtente;</li>
 * </ul>
 */
public class MySkeleton {
	/**Costruttore di default vuoto, serve a istanziare l'oggetto
	 * dentro lo Skeleton autogenerato. Si userà poi per richiamare i metodi
	 * riscritti
     */
	public MySkeleton(){}
	/** Inserisce un log nel database, richiamando il metodo dal servizio WSData
     * @param GetCognome (token,username)
     * @return GetCognomeResponse: cognome dell'utente (String)
     */
	public boolean insertLog(String message,String function)
	{
		boolean resp=false;
		try {
			WSDataStub stub = new WSDataStub();
			InsertLOG log=new InsertLOG();
			log.setMessaggio(message);
			log.setFunzione(function);
			
			InsertLOGResponse logResp=stub.insertLOG(log);
		    if(logResp.get_return()){resp=true;return resp;}
		} catch (RemoteException e) {return resp;}
		return resp;
	}
	/** Setta l'utente come playing, richiamando il metodo dal servizio WSData.
     * @param SetPlaying (token,username,valorePlaying)
     * @return SetPlayingResponse: boolean di conferma (boolean)
     */
	 public geister.SetPlayingResponse setPlaying(geister.SetPlaying setPlaying)
	 {
		 SetPlayingResponse resp= new SetPlayingResponse();
			String idtoken=setPlaying.getIdtoken();
			
			try {
				///////////////////////////////////////////// DA IMPLEMENTARE IN WSDATA!!!!!!!!!!!!!!!!!!!!!!
				//recupero il valore di Playing attuale
				WSDataStub stub = new WSDataStub();
				//WSDataStub.GetUtentePlaying utentePlaying=new WSDataStub.GetUtentePlaying();
				//utentePlaying.setIdtoken(idtoken);
				//WSDataStub.GetUtentePlayingResponse respPlaying=stub.getUtentePlaying(utentePlaying);
				//salvo l'oppsto
				//WSDataStub.SetUtentePlaying utente=new WSDataStub.SetUtentePlaying();
				//utente.setIdtoken(idtoken);
				//if(!respPlaying.get_return())utente.setValore(0);
				//else utente.setValore(1);
				//WSDataStub.SetUtentePlayingResponse dataResp=stub.setUtentePlaying(utente);
			    
				//resp.set_return(dataResp.get_return()); 
				resp.set_return(true);
				return resp;

			} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/SetPlaying"); resp.set_return(false);return resp;}
	 }
	/** Setta l'utente come online sempre, richiamando il metodo dal servizio WSData.
	 * Va in contrasto con il timer per mettere offline gli utenti
     * @param SetOnline (token,username,valoreOnline)
     * @return SetOnlineResponse: boolean di conferma (boolean)
     */
	public geister.SetOnlineResponse setOnline(geister.SetOnline setOnline)
	{
		SetOnlineResponse resp= new SetOnlineResponse();
		String idtoken=setOnline.getIdtoken();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.SetUtenteOnline utente=new WSDataStub.SetUtenteOnline();
			utente.setIdtoken(idtoken);
			utente.setValore(1);
			 
			WSDataStub.SetUtenteOnlineResponse dataResp=stub.setUtenteOnline(utente);
		    
			resp.set_return(dataResp.get_return()); 
			return resp;

		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/SetOnline"); resp.set_return(false);return resp;}
	}
	/** Setta l'utente come IA, richiamando il metodo dal servizio WSData
     * @param SetIA (token,username,valoreIA)
     * @return SetIAResponse: boolean di conferma (boolean)
     */
	public geister.SetIAResponse setIA(geister.SetIA setIA)
	{
		SetIAResponse resp= new SetIAResponse();
		String idtoken=setIA.getIdtoken();
		
		try {
			//recupero il valore di IA attuale
			WSDataStub stub = new WSDataStub();
			WSDataStub.GetUtenteIA utenteIA=new WSDataStub.GetUtenteIA();
			utenteIA.setIdtoken(idtoken);
			WSDataStub.GetUtenteIAResponse respIA=stub.getUtenteIA(utenteIA);
			//salvo l'oppsto
			WSDataStub.SetUtenteIA utente=new WSDataStub.SetUtenteIA();
			utente.setIdtoken(idtoken);
			if(!respIA.get_return())utente.setValore(1);
			else utente.setValore(0);
			WSDataStub.SetUtenteIAResponse dataResp=stub.setUtenteIA(utente);
		    
			resp.set_return(dataResp.get_return()); 
			return resp;

		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/SetIA"); resp.set_return(false);return resp;}
	}
	/** Setta la password dell'utente, richiamando il metodo dal servizio WSData
     * @param SetPassword (token,username,new_password)
     * @return SetPasswordResponse: boolean di conferma (boolean)
     */
	public geister.SetPasswordResponse setPassword(geister.SetPassword setPassword)
	{
		SetPasswordResponse resp= new SetPasswordResponse();
		String idtoken=setPassword.getIdtoken();
		String email=setPassword.getNew_password();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.SetUtentePassword utente=new WSDataStub.SetUtentePassword();
			utente.setIdtoken(idtoken);
			utente.setPassword_nuovo(email);
		    WSDataStub.SetUtentePasswordResponse dataResp=stub.setUtentePassword(utente);
		    
		    resp.set_return(dataResp.get_return());
		    return resp;
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/SetPassword"); resp.set_return(false);return resp;}
	}
	/** Setta il nome dell'utente, richiamando il metodo dal servizio WSData
     * @param setNome (token,username,new_nome)
     * @return SetNomeResponse: boolean di conferma (boolean)
     */
	public geister.SetNomeResponse setNome(geister.SetNome setNome)
	{
		SetNomeResponse resp= new SetNomeResponse();
		String idtoken=setNome.getIdtoken();
		String email=setNome.getNew_nome();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.SetUtenteNome utente=new WSDataStub.SetUtenteNome();
			utente.setIdtoken(idtoken);
			utente.setNome_nuovo(email);
		    WSDataStub.SetUtenteNomeResponse dataResp=stub.setUtenteNome(utente);
		    
		    resp.set_return(dataResp.get_return());
		    return resp;
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/SetNome"); resp.set_return(false);return resp;}
	}
	/** Setta l'email dell'utente, richiamando il metodo dal servizio WSData
     * @param GetEmail (token,username,new_email)
     * @return SetEmailResponse: boolean di conferma (boolean)
     */
	public geister.SetEmailResponse setEmail ( geister.SetEmail setEmail)
	{
		SetEmailResponse resp= new SetEmailResponse();
		String idtoken=setEmail.getIdtoken();
		String email=setEmail.getNew_email();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.SetUtenteEmail utente=new WSDataStub.SetUtenteEmail();
			utente.setIdtoken(idtoken);
			utente.setEmail_nuovo(email);
		    WSDataStub.SetUtenteEmailResponse dataResp=stub.setUtenteEmail(utente);
		    
		    resp.set_return(dataResp.get_return());
		    return resp;
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/SetEmail"); resp.set_return(false);return resp;}
	}
	/** Setta il cognome dell'utente, richiamando il metodo dal servizio WSData
     * @param SetCognome (token,username,new_cognome)
     * @return SetCognomeResponse: boolean di conferma (boolean)
     */
	public geister.SetCognomeResponse setCognome ( geister.SetCognome setCognome )
	{
		SetCognomeResponse resp= new SetCognomeResponse();
		String idtoken=setCognome.getIdtoken();
		String cognome=setCognome.getNew_cognome();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.SetUtenteCognome utente=new WSDataStub.SetUtenteCognome();
			utente.setIdtoken(idtoken);
			utente.setCognome_nuovo(cognome);
		    WSDataStub.SetUtenteCognomeResponse dataResp=stub.setUtenteCognome(utente);
		    
		    resp.set_return(dataResp.get_return());
		    return resp;
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/SetCognome"); resp.set_return(false);return resp;}
	}
	/** Restituisce se l'utente è in fase playing, richiamando il metodo dal servizio WSData
     * @param IsPlaying (token,username)
     * @return IsPlayingResponse: utente playing (boolean)
     */
	public geister.IsPlayingResponse isPlaying(geister.IsPlaying isPlaying)
	{
		IsPlayingResponse resp= new IsPlayingResponse();
		String idtoken=isPlaying.getIdtoken();
		String username=isPlaying.getUsername();
		
		try {
			WSDataStub stub = new WSDataStub();
			///////////////////////////////////////DA IMPLEMENTARE IN WSDATA!!!!!
			//WSDataStub.GetUtentePlaying utente=new WSDataStub.GetUtentePlaying();
			//utente.setIdtoken(idtoken);
			//utente.setUsername(username);
		    //WSDataStub.GetUtentePlayingResponse dataResp=stub.getUtentePlaying(utente);
		    
		    //resp.set_return(dataResp.get_return());
		    resp.set_return(true);
			return resp;
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/IsPlaying"); resp.set_return(false);return resp;}

	}
	/** Restituisce se l'utente è online, richiamando il metodo dal servizio WSData
     * @param IsOnline (token,username)
     * @return IsOnlineResponse: utente online (boolean)
     */
	public geister.IsOnlineResponse isOnline(geister.IsOnline isOnline)
	{
		IsOnlineResponse resp= new IsOnlineResponse();
		String idtoken=isOnline.getIdtoken();
		String username=isOnline.getUsername();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.GetUtenteOnline utente=new WSDataStub.GetUtenteOnline();
			utente.setIdtoken(idtoken);
			utente.setUsername(username);
		    WSDataStub.GetUtenteOnlineResponse dataResp=stub.getUtenteOnline(utente);
		    
		    resp.set_return(dataResp.get_return());
		    return resp;
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/IsOnline"); resp.set_return(false);return resp;}
	}
	/** Restituisce se l'utente è IA, richiamando il metodo dal servizio WSData
     * @param IsIA (token,username)
     * @return IsIAResponse: utente IA (boolean)
     */
	public geister.IsIAResponse isIA(geister.IsIA isIA)
    {
		IsIAResponse resp= new IsIAResponse();
		String idtoken=isIA.getIdtoken();
		String username=isIA.getUsername();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.GetUtenteIA utente=new WSDataStub.GetUtenteIA();
			utente.setIdtoken(idtoken);
			utente.setUsername(username);
		    WSDataStub.GetUtenteIAResponse dataResp=stub.getUtenteIA(utente);
		    
		    resp.set_return(dataResp.get_return());
		    return resp;
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/IsIA"); resp.set_return(false);return resp;}
    }
	/** Restituisce l'email dell'utente, richiamando il metodo dal servizio WSData
     * @param GetEmail (token,username)
     * @return GetEmailResponse: cognome dell'utente (String)
     */
	public geister.GetEmailResponse getEmail(geister.GetEmail getEmail)
	{
		GetEmailResponse resp= new GetEmailResponse();
		String idtoken=getEmail.getIdtoken();
		String username=getEmail.getUsername();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.GetUtenteEmail utente=new WSDataStub.GetUtenteEmail();
			utente.setIdtoken(idtoken);
			utente.setUsername(username);
		    WSDataStub.GetUtenteEmailResponse dataResp=stub.getUtenteEmail(utente);
		    
		    resp.set_return(dataResp.get_return());
		    return resp;
		} catch (RemoteException e) {resp.set_return("ERR:"+e.toString());return resp;}
	}
	/** Restituisce il cognome dell'utente, richiamando il metodo dal servizio WSData
     * @param GetCognome (token,username)
     * @return GetCognomeResponse: cognome dell'utente (String)
     */
	public geister.GetCognomeResponse getCognome(geister.GetCognome getCognome)
	{
		GetCognomeResponse resp= new GetCognomeResponse();
		String idtoken=getCognome.getIdtoken();
		String username=getCognome.getUsername();
		
		try {
			WSDataStub stub = new WSDataStub();
			WSDataStub.GetUtenteCognome utente=new WSDataStub.GetUtenteCognome();
			utente.setIdtoken(idtoken);
			utente.setUsername(username);
		    WSDataStub.GetUtenteCognomeResponse dataResp=stub.getUtenteCognome(utente);
		    
		    resp.set_return(dataResp.get_return());
		    return resp;
		} catch (RemoteException e) {resp.set_return("ERR:"+e.toString());return resp;}
	}
	/** Effettua login al database, richiamando il metodo dal servizio WSData
     * @param Login (username,password)
     * @return LoginResponse: idtoken (String)
     */
	public geister.LoginResponse login(geister.Login login)
	{
		LoginResponse resp=new LoginResponse();
		String user=login.getUsername();
		String password=login.getPassword();
		try {
			WSDataStub stub = new WSDataStub();
			GetIdtoken utente=new GetIdtoken();
			utente.setUsername(user);
			utente.setPassword(password);
		    WSDataStub.GetIdtokenResponse dataResp=stub.getIdtoken(utente);
		    if(dataResp.get_return()!="")
		    {//utente modificato
		    	resp.set_return(dataResp.get_return());
		    	return resp;
		    }else{resp.set_return("ERR:NoToken");return resp;}
		} catch (RemoteException e) {resp.set_return("ERR:"+e.toString());return resp;}
	}
	/** Restituisce il controllo se uno username cercato è amico.Da implementare nel servizio WSData
     * @param IsAmico (idtoken,username,username_amico)
     * @return IsAmicoResponse: boolean di conferma (boolean)
     */
	public geister.IsAmicoResponse isAmico(geister.IsAmico isAmico)
	{
		IsAmicoResponse resp= new IsAmicoResponse();
		
		String token=isAmico.getIdtoken();
		String username=isAmico.getUsername();
		String amico=isAmico.getUsername_amico();
		
		try {
			WSDataStub stub = new WSDataStub();
			//IsAmico utente=new IsAmico();

			//utente.setIdtoken(token);
			//utente.setUsername(username);
			//utente.setUsername_amico(amico);
		    //WSDataStub.IsAmico Response dataResp=stub.isAmico (utente);
		    //if(dataResp.get_return())
		    //{//utente cancellato
		    //	resp.set_return("OK");
		    //	return resp;
		    //}else{insertLog("ERR:noDelete", "WSUtenti/NuovoAmico");resp.set_return("ERR:");return resp;}
			resp.set_return(false);
			insertLog("ERR:No implements in WSData!!", "WSUtenti/IsAmico");
			return resp;
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/IsAmico"); resp.set_return(false);return resp;}
	}
	/** Inserisce un nuovo amico, richiamando il metodo dal servizio WSData
     * @param CancellaAmici (idtoken,username,username_amico)
     * @return CancellaAmiciResponse: boolean di conferma (boolean)
     */
	public geister.NuovoAmicoResponse nuovoAmico ( geister.NuovoAmico nuovoAmico )
	{
		NuovoAmicoResponse resp= new NuovoAmicoResponse();
		
		String token=nuovoAmico.getIdtoken();
		String username=nuovoAmico.getUsername();
		String amico=nuovoAmico.getUsername_amico();
		
		try {
			WSDataStub stub = new WSDataStub();
			NuovoAmico utente=new NuovoAmico();

			utente.setIdtoken(token);
			utente.setUsername(username);
			utente.setUsername_amico(amico);
		    WSDataStub.NuovoAmicoResponse dataResp=stub.nuovoAmico(utente);
		    if(dataResp.get_return())
		    {//amico inserito
		    	resp.set_return("OK");
		    	return resp;
		    }else{insertLog("ERR:noInsert", "WSUtenti/NuovoAmico");resp.set_return("ERR:noInsert");return resp;}
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/NuovoAmico"); resp.set_return("ERR:"+e.toString());return resp;}
	}
	/** Restituisce la lista degli amici, richiamando il metodo dal servizio WSData.
	 * Se username parte con "ONLINEusername", richiama il metodo getListaUtentiOnline dal servizio WSData che ritorna tutti gli utenti attualmente online.
     * @param GetListaAmici (idtoken,username(con opzione tutti))
     * @return GetListaAmiciResponse: stringa di username amici, separati da virgola(String)
     */
	public geister.GetListaAmiciResponse getListaAmici(geister.GetListaAmici getListaAmici)
	{
		GetListaAmiciResponse resp= new GetListaAmiciResponse();
		String token=getListaAmici.getIdtoken();
		String username=getListaAmici.getUsername();
		
		try {
			WSDataStub stub = new WSDataStub();
			if(username.startsWith("ONLINE"))
			{
				username=username.replace("ONLINE", "");
				GetListaUtentiOnline listaOnline=new GetListaUtentiOnline();
				listaOnline.setIdtoken(token);
				listaOnline.setUsername(username);
				GetListaUtentiOnlineResponse respOnline=stub.getListaUtentiOnline(listaOnline);
				if(respOnline.get_return()!="")
				{
					resp.set_return(respOnline.get_return());
					return resp;
				}else{resp.set_return("ERR:noUserOnline");return resp;}
			}
			else{
				
				GetListaAmici utente=new GetListaAmici();
				utente.setUsername(username);
				utente.setIdtoken(token);
			
				WSDataStub.GetListaAmiciResponse dataResp=stub.getListaAmici(utente);
		    
				if(dataResp.get_return()!="")
				{
					resp.set_return(dataResp.get_return());
					return resp;
				}else{resp.set_return("ERR:noFriend");return resp;}
			}
		} catch (RemoteException e) {resp.set_return("ERR:"+e.toString());return resp;}
	}
	/** Cancella tutti gli amici, richiamando il metodo dal servizio WSData
     * @param CancellaAmici (idtoken,username)
     * @return CancellaAmiciResponse: boolean di conferma (boolean)
     */
	public geister.CancellaAmiciResponse cancellaAmici(geister.CancellaAmici cancellaAmici)
	{
		CancellaAmiciResponse resp= new CancellaAmiciResponse();
		
		String token=cancellaAmici.getIdtoken();
		String username=cancellaAmici.getUsername();
		
		try {
			WSDataStub stub = new WSDataStub();
			CancellaAmici utente=new CancellaAmici();

			utente.setIdtoken(token);
			utente.setUsername(username);
			 
		    WSDataStub.CancellaAmiciResponse dataResp=stub.cancellaAmici(utente);
		    if(dataResp.get_return())
		    {//utente cancellato
		    	resp.set_return(true);
		    	return resp;
		    }else{insertLog("ERR:noDelete", "WSUtenti/CancellaAmici");resp.set_return(false);return resp;}
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/CancellaAmici"); resp.set_return(false);return resp;}
	}
	/** Cancella un amico richiesto, richiamando il metodo dal servizio WSData
     * @param CancellaAmico (idtoken,username,username_amico)
     * @return CancellaAmicoResponse: boolean di conferma (boolean)
     */
	public geister.CancellaAmicoResponse cancellaAmico(geister.CancellaAmico cancellaAmico)
	{
		CancellaAmicoResponse resp= new CancellaAmicoResponse();
		
		String token=cancellaAmico.getIdtoken();
		String username=cancellaAmico.getUsername();
		String amico=cancellaAmico.getUsername_amico();
		
		try {
			WSDataStub stub = new WSDataStub();
			CancellaAmico utente=new CancellaAmico();

			utente.setIdtoken(token);
			utente.setUsername(username);
			utente.setUsername_amico(amico);
		    WSDataStub.CancellaAmicoResponse dataResp=stub.cancellaAmico(utente);
		    if(dataResp.get_return())
		    {//utente cancellato
		    	resp.set_return(true);
		    	return resp;
		    }else{insertLog("ERR:noDelete", "WSUtenti/CancellaAmico");resp.set_return(false);return resp;}
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/CancellaAmico"); resp.set_return(false);return resp;}
	}
	/** Cancella un utente esistente, richiamando il metodo dal servizio WSData
	 * e cancellando anche gli amici
     * @param CancellaUtente (idtoken,username)
     * @return CancellaUtenteResponse: boolean di conferma (boolean)
     */
	public geister.CancellaUtenteResponse cancellaUtente(geister.CancellaUtente cancellaUtente)
	{
		CancellaUtenteResponse resp= new CancellaUtenteResponse();
		
		String token=cancellaUtente.getIdtoken();
		String username=cancellaUtente.getUsername();
		
		try {
			WSDataStub stub = new WSDataStub();
			CancellaUtente utente=new CancellaUtente();

			utente.setIdtoken(token);
			utente.setUsername(username);
		    WSDataStub.CancellaUtenteResponse dataResp=stub.cancellaUtente(utente);
		    if(dataResp.get_return())
		    {//utente cancellato
		    	resp.set_return(true);
		    	return resp;
		    }else{insertLog("ERR:noDelete", "WSUtenti/CancellaUtente");resp.set_return(false);return resp;}
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/CancellaUtente"); resp.set_return(false);return resp;}
	}
	/** Modifica un utente esistente, richiamando il metodo dal servizio WSData
     * @param ModificaUtente (nome,cognome,username,email)
     * @return ModificaUtenteResponse: boolean di conferma (boolean)
     */
	public geister.ModificaUtenteResponse modificaUtente(geister.ModificaUtente modificaUtente)
	{
		ModificaUtenteResponse resp= new ModificaUtenteResponse();
		String nome=modificaUtente.getNew_nome();
		String cognome=modificaUtente.getNew_cognome();
		String email=modificaUtente.getNew_email();
		String token=modificaUtente.getIdtoken();
		String password=modificaUtente.getNew_password();
		
		try {
			if(password.startsWith("RISULTATO:"))
			{
				String risultato=password.replace("RISULTATO:", "");
				String username="username";
				if(risultato.startsWith("IA"))
				{
					String[] str=risultato.split(":");
					username=str[0];
					risultato=str[1];
				}
				WSDataStub stub = new WSDataStub();
				if(risultato.equals("v")){
					GetUtenteVinte utenteV=new GetUtenteVinte();
					utenteV.setIdtoken(token);
					utenteV.setUsername(username);
					WSDataStub.GetUtenteVinteResponse dataResp=stub.getUtenteVinte(utenteV);
					SetUtenteVinte utenteV1=new SetUtenteVinte();
					utenteV1.setIdtoken(token);
					utenteV1.setUsername(username);
					utenteV1.setValore(dataResp.get_return()+1);
					WSDataStub.SetUtenteVinteResponse dataRespV=stub.setUtenteVinte(utenteV1);
					if(dataRespV.get_return())
		    		{//vinte modificate
		    			resp.set_return(true);
		    			return resp;
		    		}else{insertLog("ERR:noScoreUpdateVinte", "WSUtenti/ModificaUtente");resp.set_return(false);return resp;}
				}else if(risultato.equals("p")){
					GetUtentePerse utenteP=new GetUtentePerse();
					utenteP.setIdtoken(token);
					utenteP.setUsername(username);
					WSDataStub.GetUtentePerseResponse dataResp=stub.getUtentePerse(utenteP);
					SetUtentePerse utenteP1=new SetUtentePerse();
					utenteP1.setIdtoken(token);
					utenteP1.setUsername(username);
					utenteP1.setValore(dataResp.get_return()+1);
					WSDataStub.SetUtentePerseResponse dataRespP=stub.setUtentePerse(utenteP1);
					if(dataRespP.get_return())
		    		{//vinte modificate
		    			resp.set_return(true);
		    			return resp;
		    		}else{insertLog("ERR:noScoreUpdatePerse", "WSUtenti/ModificaUtente");resp.set_return(false);return resp;}
				}else{insertLog("ERR:noScoreUpdate", "WSUtenti/ModificaUtente");resp.set_return(false);return resp;}
			}else{
				WSDataStub stub = new WSDataStub();
				ModificaUtente utente=new ModificaUtente();
				utente.setNome(nome);
				utente.setCognome(cognome);
				utente.setEmail(email);
				utente.setIdtoken(token);
				utente.setPassword(password);
		    	WSDataStub.ModificaUtenteResponse dataResp=stub.modificaUtente(utente);
		    	if(dataResp.get_return())
		    	{//utente modificato
		    		resp.set_return(true);
		    		return resp;
		    	}else{insertLog("ERR:noUpdate", "WSUtenti/ModificaUtente");resp.set_return(false);return resp;}
			}
		} catch (RemoteException e) {insertLog("ERR:"+e.toString(), "WSUtenti/ModificaUtente"); resp.set_return(false);return resp;}
	}
	/**
	 * Metodo per pulire le stringhe ed evitare caratteri non validi
	 * @param str String da analizzare
	 * @param boolean mail_check true se devo fare un controllo di tipo mail
	 * @return String stringa ripulita 
	 * */
	private String stringPulisci(String str, boolean mail_check)
	{
		try {
			str=str.trim();
			str=str.replaceAll(";", "");
			str=str.replaceAll(",", "");
			str=str.replaceAll("'", "");
			str=str.replaceAll("\\?", "");
			str=str.replaceAll("!", "");
			str=str.replaceAll("/", "");
//			str=str.replaceAll("\\", "");
			str=str.replaceAll(" ", "");
			if(mail_check) //controllo email
			{
				Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
				//Eseguiamo il match della stringa data con il pattern
				Matcher m = p.matcher(str);
				//Salviamo il risultato del match
				boolean matchFound = m.matches();
				if(!matchFound)str="";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	/** Crea un nuovo utente e lo passa al database, richiamando il metodo dal servizio WSData
     * @param NuovoUtente (nome,cognome,username,password,email)
     * @return NuovoUtenteResponse: token dell'utente creato (String)
     */
	public geister.NuovoUtenteResponse nuovoUtente(geister.NuovoUtente nuovoUtente)
	{
		NuovoUtenteResponse resp= new NuovoUtenteResponse();
		String nome=nuovoUtente.getNome();
		String cognome=nuovoUtente.getCognome();
		String username=nuovoUtente.getUsername();
		String password=nuovoUtente.getPassword();
		String email=nuovoUtente.getEmail();
		nome=stringPulisci(nome, false);
		cognome=stringPulisci(cognome, false);
		username=stringPulisci(username, false);
		email=stringPulisci(email, true);
		if(nome!="" && cognome!="" && username!="" && password!="" && email!=""){
		try {
			
			WSDataStub stub = new WSDataStub();
			NuovoUtente utente=new NuovoUtente();
			utente.setNome(nome);
			utente.setCognome(cognome);
			utente.setUsername(username);
			utente.setPassword(password);
			utente.setEmail(email);
		    WSDataStub.NuovoUtenteResponse dataResp=stub.nuovoUtente(utente);
		    if(dataResp.get_return())
		    {//utente creato, preparo anche il token
		    	resp.set_return("OK");return resp;
		    }else{resp.set_return("ERR:noUser");return resp;}
		} catch (RemoteException e) {resp.set_return("ERR:"+e.toString());return resp;}
		}else{resp.set_return("ERR:InvalidFormat");return resp;}
	}
	
	/** Restituisce il nome dell'utente, richiamando il metodo dal servizio WSData
     * @param getNome  (token)
     * @return GetNomeResponse: nome dell'utente (String)
     */
	public geister.GetNomeResponse getNome(geister.GetNome getNome)
	{
		String token=getNome.getIdtoken();
		
		GetNomeResponse resp= new GetNomeResponse();
		
		try {
			WSDataStub stub = new WSDataStub();
			GetUtenteNome Nome=new GetUtenteNome();
			Nome.setIdtoken(token);
			GetUtenteNomeResponse dataResp= stub.getUtenteNome(Nome);
			resp.set_return(dataResp.get_return());
			return resp;
		} catch (RemoteException e) {resp.set_return("ERR:"+e.toString());return resp;}
	}
	
     
}
