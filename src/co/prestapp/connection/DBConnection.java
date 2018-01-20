package co.prestapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	Connection miConexion = null;
	static String url = "jdbc:mysql://localhost:3306/prestapp?autoReconnect=true&useSSL=false";
	static String user = "root";
	static String password = "root";

	public DBConnection() {

	}

	public Connection darConexion() {

		try {
			miConexion = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return miConexion;
	}

}
