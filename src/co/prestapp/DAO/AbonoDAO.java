package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import co.prestapp.connection.DBConnection;

public class AbonoDAO {

	public void agregarAbono(double montoAbono, int completoAbono,
			Date fechaAbono, int abonoPrestamo, int puntualAbono,
			String estadoAbono, int numeroAbono) {

		java.sql.Date fechaAbonoFormateada = new java.sql.Date(
				fechaAbono.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call agregar_abono(?,?,?,?,?,?,?)}");
			miProcedimiento.setDouble(1, montoAbono);
			miProcedimiento.setInt(2, completoAbono);
			miProcedimiento.setDate(3, fechaAbonoFormateada);
			miProcedimiento.setInt(4, abonoPrestamo);
			miProcedimiento.setInt(5, puntualAbono);
			miProcedimiento.setString(6, estadoAbono);
			miProcedimiento.setInt(7, numeroAbono);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para agregar abono");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}// Fin agregar abono

	public DefaultTableModel llenaTablaAbonos() {

		DefaultTableModel modeloTablaAbonos;
		modeloTablaAbonos = new DefaultTableModel(null, getColumnas());
		return setFilas(modeloTablaAbonos);

	}// Fin llenaTablaAbonos

	private DefaultTableModel setFilas(DefaultTableModel modeloTablaAbonos) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		Object datos[] = new Object[8];

		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call listar_abonos}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {

				for (int i = 0; i < 8; i++) {
					datos[i] = miRs.getObject(i + 1);

				}
				modeloTablaAbonos.addRow(datos);

			}
			miRs.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar abonos");
			System.out.println(e.getMessage());
		}
		return modeloTablaAbonos;

	}// Fin setFilas

	private String[] getColumnas() {

		String encabezados[] = { "Código abono", "Monto", "Completo", "Fecha",
				"Código préstamo", "Puntual", "Estado", "Abono#" };
		return encabezados;
	}// Fin getColumnas

}
