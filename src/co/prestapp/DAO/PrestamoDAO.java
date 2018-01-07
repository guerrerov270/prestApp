package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import co.prestapp.VO.PrestamoVO;
import co.prestapp.connection.DBConnection;

public class PrestamoDAO {

	/**
	 * Agrega los prestamos llamando a un procedimiento almacenado en BD
	 * 
	 * @param montoPrestamo
	 * @param tasaInteresPrestamo
	 * @param numeroCuotasPrestamo
	 * @param saldoPendientePrestamo
	 * @param saldoPagadoPrestamo
	 * @param fechaInicioPrestamo
	 * @param fechaFinPrestamo
	 * @param tipoPlazoPrestamo
	 * @param idClienteFK
	 * @param estadoPrestamo
	 */
	public String agregarPrestamo(double montoPrestamo,
			int tasaInteresPrestamo, int numeroCuotasPrestamo,
			double saldoPendientePrestamo, double saldoPagadoPrestamo,
			Date fechaInicioPrestamo, Date fechaFinPrestamo,
			String tipoPlazoPrestamo, String codigoClienteFK,
			String estadoPrestamo) {

		java.sql.Date fechaInicioFormateada = new java.sql.Date(
				fechaInicioPrestamo.getTime());
		java.sql.Date fechaFinFormateada = new java.sql.Date(
				fechaFinPrestamo.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		String codigoPrestamo = recuperarCodigoPrestamo();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call agregar_prestamo(?,?,?,?,?,?,?,?,?,?,?)}");
			miProcedimiento.setString(1, codigoPrestamo);
			miProcedimiento.setDouble(2, montoPrestamo);
			miProcedimiento.setInt(3, tasaInteresPrestamo);
			miProcedimiento.setInt(4, numeroCuotasPrestamo);
			miProcedimiento.setDouble(5, saldoPendientePrestamo);
			miProcedimiento.setDouble(6, saldoPagadoPrestamo);
			miProcedimiento.setDate(7, fechaInicioFormateada);
			miProcedimiento.setDate(8, fechaFinFormateada);
			miProcedimiento.setString(9, tipoPlazoPrestamo);
			miProcedimiento.setString(10, codigoClienteFK);
			miProcedimiento.setString(11, estadoPrestamo);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para agregar préstamo");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return codigoPrestamo;

	}// Fin agregar prestamo

	public String[] getColumnas() {

		String encabezados[] = { "#", "Código", "Monto", "Tasa", "#Cuotas",
				"Debe", "Pagado", "Inicio", "Fin", "Plazo", "Cliente", "Estado" };
		return encabezados;
	}// Fin getColumnas

	public double calcularPrestamo(double monto, int tasa, String tipoPlazo,
			int cuotas) {

		double totalPagar = 0;
		switch (tipoPlazo) {
		case "Mensual":
			totalPagar = (monto * tasa) / 100;
			totalPagar = totalPagar * cuotas;
			totalPagar = totalPagar + monto;

			return totalPagar;

		case "Quincenal":
			totalPagar = (monto * tasa) / 100;
			totalPagar = totalPagar * (cuotas / 2);
			totalPagar = totalPagar + monto;

			return totalPagar;

		case "Semanal":
			totalPagar = (monto * tasa) / 100;
			totalPagar = totalPagar * (cuotas / 4);
			totalPagar = totalPagar + monto;
			return totalPagar;

		}
		return totalPagar;

	}

	public ArrayList<Date> calcularFechasPago(String tipoPlazo, int cuotas,
			Date fechaInicio) {

		ArrayList<Date> fechasPago = null;

		switch (tipoPlazo) {
		case "Mensual":

			fechasPago = new ArrayList<Date>();
			for (int i = 1; i <= cuotas; i++) {
				fechasPago.add(sumarRestarMesesFecha(fechaInicio, i));
			}

			return fechasPago;

		case "Quincenal":
			fechasPago = new ArrayList<Date>();

			for (int i = 1; i <= cuotas; i++) {

				fechasPago.add(sumarRestarQuincenaFecha(fechaInicio, i));
			}

			return fechasPago;
		case "Semanal":
			fechasPago = new ArrayList<Date>();

			for (int i = 1; i <= cuotas; i++) {

				fechasPago.add(sumarRestarSemanaFecha(fechaInicio, i));
			}

			return fechasPago;

		}
		return fechasPago;

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
		calendar.add(Calendar.WEEK_OF_MONTH, dias);
		calendar.add(Calendar.WEEK_OF_MONTH, dias);

		return calendar.getTime();

	}// Fin sumarRestarQuincenaFecha

	// Suma los días recibidos a la fecha
	public Date sumarRestarSemanaFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.WEEK_OF_MONTH, dias); // numero de días a añadir,
													// o
													// restar en caso de días<0

		return calendar.getTime();
	}// Fin sumarRestarSemanaFecha

	public String recuperarCodigoPrestamo() {

		String codigoPrestamo = "";
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call generar_codigo_prestamo(?)}");
			miProcedimiento.registerOutParameter(1, Types.VARCHAR);
			miProcedimiento.executeQuery();
			codigoPrestamo = miProcedimiento.getString(1);
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para generar codigo de préstamo");
			System.out.println(e.getMessage());
		}

		return codigoPrestamo;

	}// Fin recuperarCodigoPrestamo

	// ----------------------------------------------VO------------------------------------------------------
	public ArrayList<PrestamoVO> buscarPrestamosConMatriz() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<PrestamoVO> listaPrestamos = new ArrayList<PrestamoVO>();
		PrestamoVO miPrestamo;
		DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
		try {
			CallableStatement miProcedimientoListar = conexion
					.prepareCall("{call listar_prestamos}");
			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {
				miPrestamo = new PrestamoVO();
				miPrestamo.setIdPrestamo(miRs.getInt("idPrestamo"));
				miPrestamo.setCodigoPrestamo(miRs.getString("codigoPrestamo"));
				miPrestamo.setMontoPrestamo(miRs.getDouble("montoPrestamo"));
				miPrestamo.setTasaInteresPrestamo(miRs
						.getInt("tasaInteresPrestamo"));
				miPrestamo.setNumeroCuotasPrestamo(miRs
						.getInt("numeroCuotasprestamo"));
				miPrestamo.setSaldoPendienteprestamo(miRs
						.getDouble("saldoPendientePrestamo"));
				miPrestamo.setSaldoPagadoPrestamo(miRs
						.getDouble("saldoPagadoPrestamo"));
				if (miRs.getDate("fechaInicioPrestamo") != null) {
					miPrestamo.setFechaInicioPrestamo(formato.format(miRs
							.getDate("fechaInicioPrestamo")));
				}
				if (miRs.getDate("fechaFinPrestamo") != null) {
					miPrestamo.setFechafinPrestamo(formato.format(miRs
							.getDate("fechaFinPrestamo")));
				}

				miPrestamo.setTipoPlazoPrestamo(miRs
						.getString("tipoPlazoPrestamo"));
				miPrestamo
						.setcodigoClienteFK(miRs.getString("codigoClienteFK"));
				miPrestamo.setEstadoPrestamo(miRs.getString("estadoPrestamo"));

				listaPrestamos.add(miPrestamo);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para listar prestamos");
			System.out.println(e.getMessage());

		}

		return listaPrestamos;
	}// Fin buscarPrestamosConMatriz

	public void actualizaPagos() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimientoListar = conexion
					.prepareCall("{call listar_prestamos}");
			CallableStatement miProcedimientoSumar = conexion
					.prepareCall("{call sumar_pagos_abono(?)}");
			CallableStatement miProcedimientoVerificar = conexion
					.prepareCall("{call verificar_prestamo_pagado(?)}");
			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {

				// Procedimientos de suma y verificación de montos de abonos y
				// préstamos
				miProcedimientoSumar.setString(1,
						miRs.getString("codigoPrestamo"));
				miProcedimientoVerificar.setString(1,
						miRs.getString("codigoPrestamo"));
				miProcedimientoSumar.execute();
				miProcedimientoVerificar.execute();

			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para actualizar pagos");
			System.out.println(e.getMessage());

		}

	}

	public String[][] obtenerMatrizPrestamos() {

		ArrayList<PrestamoVO> listaPrestamos = buscarPrestamosConMatriz();

		String matrizInfo[][] = new String[listaPrestamos.size()][12];

		for (int i = 0; i < listaPrestamos.size(); i++) {
			matrizInfo[i][0] = listaPrestamos.get(i).getIdPrestamo() + "";
			matrizInfo[i][1] = listaPrestamos.get(i).getCodigoPrestamo() + "";
			matrizInfo[i][2] = listaPrestamos.get(i).getMontoPrestamo() + "";
			matrizInfo[i][3] = listaPrestamos.get(i).getTasaInteresPrestamo()
					+ "";
			matrizInfo[i][4] = listaPrestamos.get(i).getNumeroCuotasPrestamo()
					+ "";
			matrizInfo[i][5] = listaPrestamos.get(i)
					.getSaldoPendienteprestamo() + "";
			matrizInfo[i][6] = listaPrestamos.get(i).getSaldoPagadoPrestamo()
					+ "";
			matrizInfo[i][7] = listaPrestamos.get(i).getFechaInicioPrestamo()
					+ "";
			matrizInfo[i][8] = listaPrestamos.get(i).getFechafinPrestamo() + "";
			matrizInfo[i][9] = listaPrestamos.get(i).getTipoPlazoPrestamo()
					+ "";
			matrizInfo[i][10] = listaPrestamos.get(i).getIcodigoClienteFK()
					+ "";
			matrizInfo[i][11] = listaPrestamos.get(i).getEstadoPrestamo() + "";
		}

		return matrizInfo;
	}// Fin obtenerMatrizPrestamos

}// Fin clase
