package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;

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

	public void calcularPrestamo(double monto, int tasa, String tipoPlazo,
			int cuotas, java.sql.Date fechaInicio) {

	}

	public void calcularFechasPago(String tipoPlazo, int cuotas,
			Date fechaInicio) {

		ArrayList<Date> fechasPago;

		switch (tipoPlazo) {
		case "Mensual":

			fechasPago = new ArrayList<Date>();
			for (int i = 1; i <= cuotas; i++) {
				fechasPago.add(sumarRestarMesesFecha(fechaInicio, i));
			}

			System.out.println("Lista de fechas que contiene" + " "
					+ fechasPago.size() + " " + "elementos");
			Iterator it = fechasPago.iterator();
			while (it.hasNext()) {
				Date fechaSalida = (Date) it.next();
				System.out.println(fechaSalida);
			}

			break;
		case "Quincenal":
			fechasPago = new ArrayList<Date>();

			for (int i = 1; i <= cuotas; i++) {
				Date fechaInicioNueva = sumarRestarQuincenaFecha(fechaInicio, i);
				fechasPago.add(sumarRestarQuincenaFecha(fechaInicioNueva, i));
			}

			System.out.println("Lista de fechas que contiene" + " "
					+ fechasPago.size() + " " + "elementos");
			Iterator it2 = fechasPago.iterator();
			while (it2.hasNext()) {
				Date fechaSalida = (Date) it2.next();
				System.out.println(fechaSalida);
			}

			break;
		case "Semanal":

			break;

		default:
			break;
		}
	}

	// Suma los días recibidos a la fecha
	public Date sumarRestarDiasFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o
													// restar en caso de días<0

		return calendar.getTime(); // Devuelve el objeto Date con los nuevos
									// días añadidos

	}

	// Suma los meses recibidos a la fecha
	public Date sumarRestarMesesFecha(Date fecha, int meses) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.MONTH, meses); // numero de meses a añadir, o
												// restar

		return calendar.getTime(); // Devuelve el objeto Date con los nuevos
									// días añadidos

	}

	// Suma los días recibidos a la fecha
	public Date sumarRestarQuincenaFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, 14); // numero de días a añadir, o
												// restar en caso de días<0

		return calendar.getTime(); // Devuelve el objeto Date con los nuevos
									// días añadidos

	}

}// Fin clase
