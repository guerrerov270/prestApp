package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import co.prestapp.connection.DBConnection;

public class AbonoDAO {

	public void agregarAbono(double montoACobrar, double montoPagado,
			int completoAbono, Date fechaCobro, String abonoPrestamoFK,
			int puntualAbono, String estadoAbono, int numeroAbono) {

		java.sql.Date fechaCobroFormateada = new java.sql.Date(
				fechaCobro.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		String codigoAbono = recuperarCodigoAbono();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call agregar_abono(?,?,?,?,?,?,?,?,?)}");
			miProcedimiento.setString(1, codigoAbono);
			miProcedimiento.setDouble(2, montoACobrar);
			miProcedimiento.setDouble(3, montoPagado);
			miProcedimiento.setInt(4, completoAbono);
			miProcedimiento.setDate(5, fechaCobroFormateada);
			miProcedimiento.setString(6, abonoPrestamoFK);
			miProcedimiento.setInt(7, puntualAbono);
			miProcedimiento.setString(8, estadoAbono);
			miProcedimiento.setInt(9, numeroAbono);
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
		Object datos[] = new Object[11];

		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call listar_abonos}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {

				for (int i = 0; i < 11; i++) {
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

		String encabezados[] = { "#", "Código", "Cobrar", "Pagado",
				"Completo", "Cobrar", "Pagado", "Préstamo", "Puntual",
				"Estado", "Abono#" };
		return encabezados;
	}// Fin getColumnas

	public String recuperarCodigoAbono() {

		String codigoAbono = "";
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call generar_codigo_abono(?)}");
			miProcedimiento.registerOutParameter(1, Types.VARCHAR);
			miProcedimiento.executeQuery();
			codigoAbono = miProcedimiento.getString(1);
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para generar codigo de abono");
			System.out.println(e.getMessage());
		}

		return codigoAbono;

	}// Fin recuperarCodigoAbono

	public void crearAbonosPrestamo(double totalAPagar, int numeroCuotas,
			ArrayList<Date> fechasPago, String codigoPrestamo) {

		double montoACobrar = totalAPagar / numeroCuotas;
		double montoPagado = 0;
		int completoAbono = 0;
		// fecha de Pago no voy a enviar
		int puntualAbono = 0;
		String estadoAbono = "PENDIENTE";

		for (int i = 0; i < fechasPago.size(); i++) {

			agregarAbono(montoACobrar, montoPagado, completoAbono,
					fechasPago.get(i), codigoPrestamo, puntualAbono,
					estadoAbono, i+1);
		}

	}// Fin crearAbonosPrestamo

}
