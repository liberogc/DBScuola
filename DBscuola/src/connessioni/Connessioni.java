package connessioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessioni {

	public Connection connettiScuola() {
		String url="jdbc:mysql://localhost:3306/scuolaesami";
		String user="root";
        String pw="root";
        Connection conn = null;
        try {
			conn=DriverManager.getConnection(url,user,pw);
		} catch (SQLException e) {
			System.out.println("Errore di connessione allo Schema 'scuolaesami'");
		}
		return conn;		
	}
}
