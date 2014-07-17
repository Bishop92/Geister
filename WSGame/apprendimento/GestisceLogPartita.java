package apprendimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

class GestisceLogPartita {

	private Vector<LogPartita> partite;

    public GestisceLogPartita(int id_giocatore){
		partite = trovaPartite(id_giocatore);
	}

	private Vector<LogPartita> trovaPartite(int id_giocatore){
		Vector<LogPartita> partite = new Vector<LogPartita>();
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost/sql81876_4";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement cmd = con.createStatement();
			String query = "SELECT * FROM partite_giocatori WHERE gioc1=" + id_giocatore +" OR gioc2=" + id_giocatore;
			ResultSet res = cmd.executeQuery(query);
			while (res.next()){
				//partite.add(new LogPartita(res.getInt("partita")));
			}
			res.close(); // chiudere le risorse DB � obbligatorio
			cmd.close();
			con.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		return partite;
	}
	
	public Vector<LogPartita> getPartite(){
		return partite;
	}
	
}
