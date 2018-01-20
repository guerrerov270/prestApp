package co.prestapp.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DBError {

	public void guardarMensajeError(String mensajeError, String origen) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call agregar_error(?,?)}");
			miProcedimiento.setString(1, mensajeError);
			miProcedimiento.setString(2, origen);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para agregar error");
			System.out.println(e.getMessage());
		}
	}

}
