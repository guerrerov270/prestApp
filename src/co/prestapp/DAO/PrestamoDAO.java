package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import co.prestapp.connection.DBConnection;

public class PrestamoDAO {

	public void agregarPrestamo(float montoPrestamo, int tasaInteresPrestamo,
			int numeroCuotasPrestamo, float saldoPendientePrestamo,
			float saldoPagadoPrestamo, Date fechaInicioPrestamo,
			Date fechaFinPrestamo, String tipoPlazoPrestamo, int idClienteFK,
			String estadoPrestamo) {

		java.sql.Date fechaInicioFormateada = new java.sql.Date(
				fechaInicioPrestamo.getTime());
		java.sql.Date fechaFinFormateada = new java.sql.Date(
				fechaFinPrestamo.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call agregar_prestamo(?,?,?,?,?,?,?,?,?,?)}");
			miProcedimiento.setFloat(1, montoPrestamo);
			miProcedimiento.setInt(2, tasaInteresPrestamo);
			miProcedimiento.setInt(3, numeroCuotasPrestamo);
			miProcedimiento.setFloat(4, saldoPendientePrestamo);
			miProcedimiento.setFloat(5, saldoPagadoPrestamo);
			miProcedimiento.setDate(6, fechaInicioFormateada);
			miProcedimiento.setDate(7, fechaFinFormateada);
			miProcedimiento.setString(8, tipoPlazoPrestamo);
			miProcedimiento.setInt(9, idClienteFK);
			miProcedimiento.setString(10, estadoPrestamo);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para agregar préstamo");
			System.out.println(e.getMessage());
		}

	}// Fin agregar prestamo

	public DefaultTableModel llenaTablaPrestamos() {

		DefaultTableModel modeloTablaPrestamos;
		modeloTablaPrestamos = new DefaultTableModel(null, getColumnas());
		return setFilas(modeloTablaPrestamos);

	}// Fin llenaTablaPrestamos

	private DefaultTableModel setFilas(DefaultTableModel modeloTablaPrestamos) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		Object datos[] = new Object[11];

		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call listar_prestamos}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {

				for (int i = 0; i < 11; i++) {
					datos[i] = miRs.getObject(i + 1);

				}
				modeloTablaPrestamos.addRow(datos);

			}
			miRs.close();
			conexion.close();
		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para listar préstamos");
			System.out.println(e.getMessage());
		}
		return modeloTablaPrestamos;

	}// Fin setFilas

	private String[] getColumnas() {

		String encabezados[] = { "Código", "Monto", "Tasa", "#Cuotas", "Debe",
				"Pagado", "Inicio", "Fin", "Cliente", "Estado" };
		return encabezados;
	}// Fin getColumnas

}// Fin clase
