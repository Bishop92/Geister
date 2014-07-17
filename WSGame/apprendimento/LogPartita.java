package apprendimento;

import logica.*;

import java.sql.*;
import java.util.Vector;

public class LogPartita {
	
	//private int vincitore;
	private Vector<String> log;
	
	public LogPartita(String  nome_partita){
		try
		{
			String temp_log="";
			int id_partita=0;
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/geister";
			Connection con = DriverManager.getConnection(url, "root", "sportster");
			Statement cmd = con.createStatement();
			//riprendo i dati dal db e li piazzo in un log analizzabile come da tesi precedente
			//giocatori coinvolti
			String query = "SELECT * FROM partite WHERE nome_partita like'" + nome_partita+"';";
			ResultSet res = cmd.executeQuery(query);
			while (res.next())
			{
				id_partita=res.getInt("id");
				temp_log = "1:"+res.getString("id_utente1")+"\n";
				temp_log += "2:"+res.getString("id_utente2")+"\n";				
			}
				if(id_partita!=0){
					//posizioni iniziali
					query = "SELECT * FROM posizioni_iniziali WHERE id_partita =" + id_partita +" order by pedina";
					res = cmd.executeQuery(query);

					while (res.next())
					{
				
						//vincitore = res.getInt("winner");
						temp_log += res.getString("pedina")+":"+res.getString("posizione")+"\n";			

					}
					//mosse
					query = "SELECT * FROM mosse WHERE id_partita =" + id_partita;
					res = cmd.executeQuery(query);
					int i=1;
					int y=1;
					int fase=1;
					while (res.next())
					{
						String pos_ini=((Integer)res.getInt("pos_iniziale")).toString();
						if(pos_ini.length()==1)pos_ini="0"+pos_ini;
						String pos_fin=((Integer)res.getInt("pos_finale")).toString();
						if(pos_fin.length()==1)pos_fin="0"+pos_fin;
						if(fase==1){
							temp_log += y+"."+pos_ini+res.getString("mangia")+pos_fin;
							fase=2;
						}else if(fase==2){
							temp_log += ","+pos_ini+res.getString("mangia")+pos_fin+"\n";
							fase=1;
						}
						if(i%2==0)y++;
							i++;
					}
				}//if_id_partita
			log=trasformaInVettore(temp_log);
			
			res.close(); // chiudere le risorse DB � obbligatorio
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
	
	public LogPartita (Partita p){
		log = p.getVettoreLog();
	}
	
	/**
	 * Metodo senza parametri che restituisce un vettore di stringhe contenente il contenuto
	 * del file.
	 * Ogni riga del file corrisponderà ad un elemento del vettore di output
	 * 
	 * @return Vector<String> - al suo interno vi e' il contenuto del file sottoforma di
	 * sequenze di stringhe
	 */ 
	private Vector<String> trasformaInVettore(String log){
			Vector<String> vettore = new Vector<String>();
			String temp="";
			for(int i=0;i<log.length();i++){
				temp+=log.charAt(i);
				if(i+1==log.length() || log.charAt(i+1)=='\n'){
					vettore.add(temp.trim());
					temp="";
					i++;
				}
			}
			return vettore;
	}
	
	/*
	public int getVincitore(){
		return vincitore;
	}
	*/
	
	public Vector<String> getLog(){
		return log;
	}

	public int getLastTurn(){
		String turno = log.elementAt(log.size()-1);
		int res=0;
		//testo se il turno � un numero a singola o doppia (...) cifra
		if(turno.substring(0, 2).endsWith("."))
			res= Integer.parseInt(turno.substring(0, 1));
		if(turno.substring(0, 3).endsWith("."))
			res= Integer.parseInt(turno.substring(0, 2));
		return res;
	}

}
