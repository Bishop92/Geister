package apprendimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ValutaPezziLog {
	public ValutaPezziLog(String messaggio)
	{
		String insertQuery="";
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/geister";
			Connection con = DriverManager.getConnection(url, "root", "sportster");
			Statement cmd = con.createStatement();
			messaggio=messaggio.replaceAll("'", "''");

			insertQuery = "INSERT INTO ranker_log VALUES ("+
			   		"NULL"+","+//id autoincrement
			   		"'"+messaggio+"'"+//funzione chiamante
					");";
			cmd.executeUpdate(insertQuery);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(insertQuery);
			e.printStackTrace();
		}
	}
}
