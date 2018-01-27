package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

import co.prestapp.VO.PrestamoVO;
import co.prestapp.VO.PrestamoVOResumido;
import co.prestapp.connection.DBConnection;
import co.prestapp.connection.DBError;

public class PrestamoDAO {

	DBError error = new DBError();

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
	public String agregarPrestamo(double montoPrestamo, int tasaInteresPrestamo, int numeroCuotasPrestamo,
			double saldoPendientePrestamo, double saldoPagadoPrestamo, Date fechaInicioPrestamo, Date fechaFinPrestamo,
			String tipoPlazoPrestamo, String codigoClienteFK, String estadoPrestamo) {

		java.sql.Date fechaInicioFormateada = new java.sql.Date(fechaInicioPrestamo.getTime());
		java.sql.Date fechaFinFormateada = new java.sql.Date(fechaFinPrestamo.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		String codigoPrestamo = recuperarCodigoPrestamo();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call agregar_prestamo(?,?,?,?,?,?,?,?,?,?,?)}");
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
			System.out.println("Error al ejecutar consulta para agregar préstamo");
			System.out.println(e.getMessage());
			e.printStackTrace();
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".agregarPrestamo");
		}
		return codigoPrestamo;

	}// Fin agregar prestamo

	public float calcularPrestamo(float monto, int tasa, String tipoPlazo, int cuotas) {

		float totalPagar = 0;
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

	public ArrayList<Date> calcularFechasPago(String tipoPlazo, int cuotas, Date fechaInicio) {

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
			CallableStatement miProcedimiento = conexion.prepareCall("{call generar_codigo_prestamo(?)}");
			miProcedimiento.registerOutParameter(1, Types.VARCHAR);
			miProcedimiento.executeQuery();
			codigoPrestamo = miProcedimiento.getString(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para generar codigo de préstamo");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".recuperarCodigoPrestamo");
		}

		return codigoPrestamo;

	}// Fin recuperarCodigoPrestamo

	// ----------------------------------------------VO------------------------------------------------------
	public void actualizaPagos() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimientoListar = conexion.prepareCall("{call listar_prestamos}");
			CallableStatement miProcedimientoSumar = conexion.prepareCall("{call sumar_pagos_abono(?)}");
			CallableStatement miProcedimientoVencidos = conexion.prepareCall("{call verificar_prestamo_vencido(?)}");
			CallableStatement miProcedimientoVerificar = conexion.prepareCall("{call verificar_prestamo_pagado(?)}");
			CallableStatement miProcedimientoVerificarClientes = conexion
					.prepareCall("{call verificar_estado_clientes(?)}");
			CallableStatement miProcedimientoActualizaCuotas = conexion
					.prepareCall("{call actualizar_cuotas_pagadas(?)}");

			// De los reportes

			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {

				// Procedimientos de suma y verificación de montos de abonos y
				// préstamos
				miProcedimientoSumar.setString(1, miRs.getString("codigoPrestamo"));
				miProcedimientoVerificar.setString(1, miRs.getString("codigoPrestamo"));
				miProcedimientoVencidos.setString(1, miRs.getString("codigoPrestamo"));
				miProcedimientoVerificarClientes.setString(1, miRs.getString("codigoClienteFK"));
				miProcedimientoActualizaCuotas.setString(1, miRs.getString("codigoPrestamo"));
				miProcedimientoSumar.execute();
				miProcedimientoVerificar.execute();
				miProcedimientoVencidos.execute();
				miProcedimientoVerificarClientes.execute();
				miProcedimientoActualizaCuotas.execute();

			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para actualizar pagos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".actualizaPagos");

		}

	}

	public String[][] obtenerMatrizPrestamosVencidos() {

		ArrayList<PrestamoVOResumido> listaPrestamos = buscarPrestamosVencidosConMatriz();

		String matrizInfo[][] = new String[listaPrestamos.size()][10];

		for (int i = 0; i < listaPrestamos.size(); i++) {
			matrizInfo[i][0] = listaPrestamos.get(i).getNombreCliente() + "";
			matrizInfo[i][1] = listaPrestamos.get(i).getEmpresaCliente() + "";
			matrizInfo[i][2] = listaPrestamos.get(i).getReferenciaCliente() + "";
			matrizInfo[i][3] = listaPrestamos.get(i).getCodigoPrestamo() + "";
			matrizInfo[i][4] = listaPrestamos.get(i).getFechaInicioPrestamo() + "";
			matrizInfo[i][5] = listaPrestamos.get(i).getMontoPrestamo() + "";
			matrizInfo[i][6] = listaPrestamos.get(i).getTipoPlazo() + "";
			matrizInfo[i][7] = listaPrestamos.get(i).getNumeroCuotasPrestamo() + "";
			matrizInfo[i][8] = listaPrestamos.get(i).getValorCuotaPrestamo() + "";
			matrizInfo[i][9] = listaPrestamos.get(i).getSaldoPendientePrestamo() + "";
		}

		return matrizInfo;
	}

	private ArrayList<PrestamoVOResumido> buscarPrestamosVencidosConMatriz() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<PrestamoVOResumido> listaPrestamos = new ArrayList<PrestamoVOResumido>();
		PrestamoVOResumido miPrestamo;
		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		try {
			CallableStatement miProcedimientoListar = conexion.prepareCall("{call listar_prestamos_vencidos}");
			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {
				miPrestamo = new PrestamoVOResumido();

				miPrestamo.setNombreCliente(miRs.getString("nombreCliente"));
				miPrestamo.setEmpresaCliente(miRs.getString("empresaCliente"));
				miPrestamo.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miPrestamo.setCodigoPrestamo(miRs.getString("codigoPrestamo"));
				if (miRs.getDate("fechaInicioPrestamo") != null) {
					miPrestamo.setFechaInicioPrestamo(formatoFecha.format(miRs.getDate("fechaInicioPrestamo")));
				}
				miPrestamo.setMontoPrestamo(formatoMoneda.format(miRs.getDouble("montoPrestamo")));
				miPrestamo.setTipoPlazo(miRs.getString("tipoPlazoPrestamo"));
				miPrestamo.setNumeroCuotasPrestamo(miRs.getInt("numeroCuotasprestamo"));
				miPrestamo.setValorCuotaPrestamo(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miPrestamo.setSaldoPendientePrestamo(formatoMoneda.format(miRs.getDouble("saldoRestantePrestamo")));

				listaPrestamos.add(miPrestamo);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar prestamos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarPrestamosVencidosConMatriz");

		}

		return listaPrestamos;
	}

	public String[][] obtenerMatrizPrestamosPorFecha(Date fechaSeleccionada) {

		ArrayList<PrestamoVOResumido> listaPrestamos = buscarPrestamosPorFecha(fechaSeleccionada);

		String matrizInfo[][] = new String[listaPrestamos.size()][10];

		for (int i = 0; i < listaPrestamos.size(); i++) {
			matrizInfo[i][0] = listaPrestamos.get(i).getNombreCliente() + "";
			matrizInfo[i][1] = listaPrestamos.get(i).getEmpresaCliente() + "";
			matrizInfo[i][2] = listaPrestamos.get(i).getReferenciaCliente() + "";
			matrizInfo[i][3] = listaPrestamos.get(i).getCodigoPrestamo() + "";
			matrizInfo[i][4] = listaPrestamos.get(i).getFechaInicioPrestamo() + "";
			matrizInfo[i][5] = listaPrestamos.get(i).getMontoPrestamo() + "";
			matrizInfo[i][6] = listaPrestamos.get(i).getTipoPlazo() + "";
			matrizInfo[i][7] = listaPrestamos.get(i).getNumeroCuotasPrestamo() + "";
			matrizInfo[i][8] = listaPrestamos.get(i).getValorCuotaPrestamo() + "";
			matrizInfo[i][9] = listaPrestamos.get(i).getSaldoPendientePrestamo() + "";
		}

		return matrizInfo;
	}

	private ArrayList<PrestamoVOResumido> buscarPrestamosPorFecha(Date fechaSeleccionada) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<PrestamoVOResumido> listaPrestamos = new ArrayList<PrestamoVOResumido>();
		PrestamoVOResumido miPrestamo;
		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);
		java.sql.Date fechaSeleccionadaFormateada = new java.sql.Date(fechaSeleccionada.getTime());

		try {
			CallableStatement miProcedimientoListar = conexion.prepareCall("{call listar_prestamos_por_fecha(?)}");
			miProcedimientoListar.setDate(1, fechaSeleccionadaFormateada);
			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {
				miPrestamo = new PrestamoVOResumido();

				miPrestamo.setNombreCliente(miRs.getString("nombreCliente"));
				miPrestamo.setEmpresaCliente(miRs.getString("empresaCliente"));
				miPrestamo.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miPrestamo.setCodigoPrestamo(miRs.getString("codigoPrestamo"));
				if (miRs.getDate("fechaInicioPrestamo") != null) {
					miPrestamo.setFechaInicioPrestamo(formatoFecha.format(miRs.getDate("fechaInicioPrestamo")));
				}
				miPrestamo.setMontoPrestamo(formatoMoneda.format(miRs.getDouble("montoPrestamo")));
				miPrestamo.setTipoPlazo(miRs.getString("tipoPlazoPrestamo"));
				miPrestamo.setNumeroCuotasPrestamo(miRs.getInt("numeroCuotasprestamo"));
				miPrestamo.setValorCuotaPrestamo(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miPrestamo.setSaldoPendientePrestamo(formatoMoneda.format(miRs.getDouble("saldoRestantePrestamo")));

				listaPrestamos.add(miPrestamo);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar prestamos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".buscarPrestamosPorFecha");

		}

		return listaPrestamos;
	}

	public float calcularTotalPrestado() {

		float totalPrestado = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call calcular_total_prestado(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalPrestado = miProcedimiento.getFloat(1);

			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para calcular total prestado");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".calcularTotalPrestado");
		}

		return totalPrestado;
	}

	public float calcularTotalRecaudado() {

		float totalRecaudado = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call calcular_total_recaudado(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalRecaudado = miProcedimiento.getFloat(1);

			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para calcular total recaudado");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".calcularTotalRecaudado");
		}

		return totalRecaudado;
	}

	public float calcularRecaudoPendiente() {

		float totalRecaudoPendiente = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call calcular_total_recaudo_pendiente(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalRecaudoPendiente = miProcedimiento.getFloat(1);

			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para calcular total recaudado");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".calcularRecaudoPendiente");
		}

		return totalRecaudoPendiente;
	}

	public float calcularInteresesRecaudados() {

		float interesesRecaudados = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call calcular_intereses_recaudados(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			interesesRecaudados = miProcedimiento.getFloat(1);

			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para calcular intereses recaudados");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".calcularInteresesRecaudados");
		}

		return interesesRecaudados;
	}

	public float calcularInteresesPendientesRecaudo() {

		float interesesRecaudados = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();

		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call calcular_intereses_a_recaudar(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			interesesRecaudados = interesesRecaudados + miProcedimiento.getFloat(1);

			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para calcular intereses recaudados");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".calcularInteresesPendientesRecaudo");
		}

		return interesesRecaudados;
	}

	public int contarPrestamosActivos() {

		int totalPrestamosActivos = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call contar_prestamos_activos(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalPrestamosActivos = miProcedimiento.getInt(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para contar préstamos activos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".contarPrestamosActivos");
		}

		return totalPrestamosActivos;
	}

	public int contarPrestamosFinalizados() {

		int totalPrestamosFinalizados = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call contar_prestamos_finalizados(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalPrestamosFinalizados = miProcedimiento.getInt(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para contar préstamos finalizados");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".contarPrestamosFinalizados");
		}

		return totalPrestamosFinalizados;
	}

	public int contarPrestamosVencidos() {

		int totalPrestamosVencidos = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call contar_prestamos_vencidos(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalPrestamosVencidos = miProcedimiento.getInt(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para contar préstamos vencidos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".contarPrestamosVencidos");
		}

		return totalPrestamosVencidos;
	}

	public String[][] obtenerMatrizPrestamosPendientes() {

		ArrayList<PrestamoVOResumido> listaPrestamos = buscarPrestamosConMatrizPendientes();

		String matrizInfo[][] = new String[listaPrestamos.size()][10];

		for (int i = 0; i < listaPrestamos.size(); i++) {
			matrizInfo[i][0] = listaPrestamos.get(i).getNombreCliente() + "";
			matrizInfo[i][1] = listaPrestamos.get(i).getEmpresaCliente() + "";
			matrizInfo[i][2] = listaPrestamos.get(i).getReferenciaCliente() + "";
			matrizInfo[i][3] = listaPrestamos.get(i).getCodigoPrestamo() + "";
			matrizInfo[i][4] = listaPrestamos.get(i).getFechaInicioPrestamo() + "";
			matrizInfo[i][5] = listaPrestamos.get(i).getMontoPrestamo() + "";
			matrizInfo[i][6] = listaPrestamos.get(i).getTipoPlazo() + "";
			matrizInfo[i][7] = listaPrestamos.get(i).getNumeroCuotasPrestamo() + "";
			matrizInfo[i][8] = listaPrestamos.get(i).getValorCuotaPrestamo() + "";
			matrizInfo[i][9] = listaPrestamos.get(i).getSaldoPendientePrestamo() + "";
		}

		return matrizInfo;
	}

	private ArrayList<PrestamoVOResumido> buscarPrestamosConMatrizPendientes() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<PrestamoVOResumido> listaPrestamos = new ArrayList<PrestamoVOResumido>();
		PrestamoVOResumido miPrestamo;
		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		try {
			CallableStatement miProcedimientoListar = conexion.prepareCall("{call listar_prestamos_pendientes}");
			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {
				miPrestamo = new PrestamoVOResumido();

				miPrestamo.setNombreCliente(miRs.getString("nombreCliente"));
				miPrestamo.setEmpresaCliente(miRs.getString("empresaCliente"));
				miPrestamo.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miPrestamo.setCodigoPrestamo(miRs.getString("codigoPrestamo"));
				if (miRs.getDate("fechaInicioPrestamo") != null) {
					miPrestamo.setFechaInicioPrestamo(formatoFecha.format(miRs.getDate("fechaInicioPrestamo")));
				}
				miPrestamo.setMontoPrestamo(formatoMoneda.format(miRs.getDouble("montoPrestamo")));
				miPrestamo.setTipoPlazo(miRs.getString("tipoPlazoPrestamo"));
				miPrestamo.setNumeroCuotasPrestamo(miRs.getInt("numeroCuotasprestamo"));
				miPrestamo.setValorCuotaPrestamo(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miPrestamo.setSaldoPendientePrestamo(formatoMoneda.format(miRs.getDouble("saldoRestantePrestamo")));

				listaPrestamos.add(miPrestamo);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar prestamos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarPrestamosConMatrizPendientes");

		}

		return listaPrestamos;
	}

	public String[][] obtenerMatrizPrestamosPagados() {

		ArrayList<PrestamoVOResumido> listaPrestamos = buscarPrestamosConMatrizPagados();

		String matrizInfo[][] = new String[listaPrestamos.size()][10];

		for (int i = 0; i < listaPrestamos.size(); i++) {
			matrizInfo[i][0] = listaPrestamos.get(i).getNombreCliente() + "";
			matrizInfo[i][1] = listaPrestamos.get(i).getEmpresaCliente() + "";
			matrizInfo[i][2] = listaPrestamos.get(i).getReferenciaCliente() + "";
			matrizInfo[i][3] = listaPrestamos.get(i).getCodigoPrestamo() + "";
			matrizInfo[i][4] = listaPrestamos.get(i).getFechaInicioPrestamo() + "";
			matrizInfo[i][5] = listaPrestamos.get(i).getMontoPrestamo() + "";
			matrizInfo[i][6] = listaPrestamos.get(i).getTipoPlazo() + "";
			matrizInfo[i][7] = listaPrestamos.get(i).getNumeroCuotasPrestamo() + "";
			matrizInfo[i][8] = listaPrestamos.get(i).getValorCuotaPrestamo() + "";
			matrizInfo[i][9] = listaPrestamos.get(i).getSaldoPendientePrestamo() + "";
		}

		return matrizInfo;
	}

	private ArrayList<PrestamoVOResumido> buscarPrestamosConMatrizPagados() {
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<PrestamoVOResumido> listaPrestamos = new ArrayList<PrestamoVOResumido>();
		PrestamoVOResumido miPrestamo;
		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		try {
			CallableStatement miProcedimientoListar = conexion.prepareCall("{call listar_prestamos_pagados}");
			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {
				miPrestamo = new PrestamoVOResumido();

				miPrestamo.setNombreCliente(miRs.getString("nombreCliente"));
				miPrestamo.setEmpresaCliente(miRs.getString("empresaCliente"));
				miPrestamo.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miPrestamo.setCodigoPrestamo(miRs.getString("codigoPrestamo"));
				if (miRs.getDate("fechaInicioPrestamo") != null) {
					miPrestamo.setFechaInicioPrestamo(formatoFecha.format(miRs.getDate("fechaInicioPrestamo")));
				}
				miPrestamo.setMontoPrestamo(formatoMoneda.format(miRs.getDouble("montoPrestamo")));
				miPrestamo.setTipoPlazo(miRs.getString("tipoPlazoPrestamo"));
				miPrestamo.setNumeroCuotasPrestamo(miRs.getInt("numeroCuotasprestamo"));
				miPrestamo.setValorCuotaPrestamo(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miPrestamo.setSaldoPendientePrestamo(formatoMoneda.format(miRs.getDouble("saldoRestantePrestamo")));

				listaPrestamos.add(miPrestamo);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar prestamos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarPrestamosConMatrizPagados");

		}

		return listaPrestamos;
	}

	public PrestamoVO buscarPrestamo(String codigoPrestamo) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		PrestamoVO miPrestamo = null;
		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call buscar_prestamo(?)}");
			miProcedimiento.setString(1, codigoPrestamo);
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {
				miPrestamo = new PrestamoVO();
				miPrestamo.setIdPrestamo(miRs.getInt("idPrestamo"));
				miPrestamo.setCodigoPrestamo(miRs.getString("codigoPrestamo"));
				miPrestamo.setMontoPrestamo(formatoMoneda.format(miRs.getDouble("montoPrestamo")));
				miPrestamo.setTasaInteresPrestamo(miRs.getInt("tasaInteresPrestamo"));
				miPrestamo.setNumeroCuotasPrestamo(miRs.getInt("numeroCuotasprestamo"));
				miPrestamo.setSaldoPendienteprestamo(formatoMoneda.format(miRs.getDouble("saldoPendientePrestamo")));
				miPrestamo.setSaldoPagadoPrestamo(formatoMoneda.format(miRs.getDouble("saldoPagadoPrestamo")));
				if (miRs.getDate("fechaInicioPrestamo") != null) {
					miPrestamo.setFechaInicioPrestamo(formatoFecha.format(miRs.getDate("fechaInicioPrestamo")));
				}
				if (miRs.getDate("fechaFinPrestamo") != null) {
					miPrestamo.setFechafinPrestamo(formatoFecha.format(miRs.getDate("fechaFinPrestamo")));
				}

				miPrestamo.setTipoPlazoPrestamo(miRs.getString("tipoPlazoPrestamo"));
				miPrestamo.setcodigoClienteFK(miRs.getString("codigoClienteFK"));
				miPrestamo.setEstadoPrestamo(miRs.getString("estadoPrestamo"));

			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para buscar préstamo");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".buscarPrestamo");

		}

		return miPrestamo;
	}// Fin buscarPrestamosConMatriz

	public boolean prestamoTieneAbonos(String codigoPrestamo) {

		boolean respuesta = false;
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);
		PrestamoVO miPrestamo = buscarPrestamo(codigoPrestamo);

		int montoPagado = 0;
		try {
			montoPagado = formatoMoneda.parse(miPrestamo.getSaldoPagadoPrestamo()).intValue();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		if (montoPagado > 0) {
			respuesta = true;
		}

		return respuesta;
	}

	public void editarPrestamo(String codigoPrestamo, float montoPrestamo, int tasaInteres, int numeroCuotas,
			double totalPagar, Date fechaInicio, Date fechaFin, String tipoPlazoMayus, String codigoCliente) {

		java.sql.Date fechaInicioFormateada = new java.sql.Date(fechaInicio.getTime());
		java.sql.Date fechaFinFormateada = new java.sql.Date(fechaFin.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call editar_prestamo(?,?,?,?,?,?,?,?,?)}");
			miProcedimiento.setString(1, codigoPrestamo);
			miProcedimiento.setDouble(2, montoPrestamo);
			miProcedimiento.setInt(3, tasaInteres);
			miProcedimiento.setInt(4, numeroCuotas);
			miProcedimiento.setDouble(5, totalPagar);
			miProcedimiento.setDate(6, fechaInicioFormateada);
			miProcedimiento.setDate(7, fechaFinFormateada);
			miProcedimiento.setString(8, tipoPlazoMayus);
			miProcedimiento.setString(9, codigoCliente);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para editar préstamo");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".editarPrestamo");
		}

	}

	public String[][] obtenerMatrizPrestamosRequerido() {

		ArrayList<PrestamoVOResumido> listaPrestamos = buscarPrestamosConMatrizRequerido();

		String matrizInfo[][] = new String[listaPrestamos.size()][10];

		for (int i = 0; i < listaPrestamos.size(); i++) {
			matrizInfo[i][0] = listaPrestamos.get(i).getNombreCliente() + "";
			matrizInfo[i][1] = listaPrestamos.get(i).getEmpresaCliente() + "";
			matrizInfo[i][2] = listaPrestamos.get(i).getReferenciaCliente() + "";
			matrizInfo[i][3] = listaPrestamos.get(i).getCodigoPrestamo() + "";
			matrizInfo[i][4] = listaPrestamos.get(i).getFechaInicioPrestamo() + "";
			matrizInfo[i][5] = listaPrestamos.get(i).getMontoPrestamo() + "";
			matrizInfo[i][6] = listaPrestamos.get(i).getTipoPlazo() + "";
			matrizInfo[i][7] = listaPrestamos.get(i).getNumeroCuotasPrestamo() + "";
			matrizInfo[i][8] = listaPrestamos.get(i).getValorCuotaPrestamo() + "";
			matrizInfo[i][9] = listaPrestamos.get(i).getSaldoPendientePrestamo() + "";
		}

		return matrizInfo;
	}

	private ArrayList<PrestamoVOResumido> buscarPrestamosConMatrizRequerido() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<PrestamoVOResumido> listaPrestamos = new ArrayList<PrestamoVOResumido>();
		PrestamoVOResumido miPrestamo;
		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		try {
			CallableStatement miProcedimientoListar = conexion.prepareCall("{call listar_prestamos_requerido}");
			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {
				miPrestamo = new PrestamoVOResumido();

				miPrestamo.setNombreCliente(miRs.getString("nombreCliente"));
				miPrestamo.setEmpresaCliente(miRs.getString("empresaCliente"));
				miPrestamo.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miPrestamo.setCodigoPrestamo(miRs.getString("codigoPrestamo"));
				if (miRs.getDate("fechaInicioPrestamo") != null) {
					miPrestamo.setFechaInicioPrestamo(formatoFecha.format(miRs.getDate("fechaInicioPrestamo")));
				}
				miPrestamo.setMontoPrestamo(formatoMoneda.format(miRs.getDouble("montoPrestamo")));
				miPrestamo.setTipoPlazo(miRs.getString("tipoPlazoPrestamo"));
				miPrestamo.setNumeroCuotasPrestamo(miRs.getInt("numeroCuotasprestamo"));
				miPrestamo.setValorCuotaPrestamo(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miPrestamo.setSaldoPendientePrestamo(formatoMoneda.format(miRs.getDouble("saldoRestantePrestamo")));

				listaPrestamos.add(miPrestamo);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar prestamos requeridos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarPrestamosConMatrizRequerido");

		}

		return listaPrestamos;
	}

	public String[] getColumnasRequerido() {
		String encabezados[] = { "Nombre", "Empresa", "Referencia", "Préstamo", "Inicio", "Monto", "Plazo", "Resta",
				"Cuota", "Debe" };
		return encabezados;
	}

	public String[][] obtenerMatrizPrestamosRequerido(String categoria) {

		ArrayList<PrestamoVOResumido> listaPrestamos = buscarPrestamosConMatrizRequerido(categoria);

		String matrizInfo[][] = new String[listaPrestamos.size()][10];

		for (int i = 0; i < listaPrestamos.size(); i++) {
			matrizInfo[i][0] = listaPrestamos.get(i).getNombreCliente() + "";
			matrizInfo[i][1] = listaPrestamos.get(i).getEmpresaCliente() + "";
			matrizInfo[i][2] = listaPrestamos.get(i).getReferenciaCliente() + "";
			matrizInfo[i][3] = listaPrestamos.get(i).getCodigoPrestamo() + "";
			matrizInfo[i][4] = listaPrestamos.get(i).getFechaInicioPrestamo() + "";
			matrizInfo[i][5] = listaPrestamos.get(i).getMontoPrestamo() + "";
			matrizInfo[i][6] = listaPrestamos.get(i).getTipoPlazo() + "";
			matrizInfo[i][7] = listaPrestamos.get(i).getNumeroCuotasPrestamo() + "";
			matrizInfo[i][8] = listaPrestamos.get(i).getValorCuotaPrestamo() + "";
			matrizInfo[i][9] = listaPrestamos.get(i).getSaldoPendientePrestamo() + "";
		}

		return matrizInfo;
	}

	private ArrayList<PrestamoVOResumido> buscarPrestamosConMatrizRequerido(String categoria) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<PrestamoVOResumido> listaPrestamos = new ArrayList<PrestamoVOResumido>();
		PrestamoVOResumido miPrestamo;
		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		try {
			CallableStatement miProcedimientoListar = conexion.prepareCall("{call listar_prestamos_req_categoria(?)}");
			miProcedimientoListar.setString(1, categoria);
			ResultSet miRs = miProcedimientoListar.executeQuery();

			while (miRs.next()) {
				miPrestamo = new PrestamoVOResumido();

				miPrestamo.setNombreCliente(miRs.getString("nombreCliente"));
				miPrestamo.setEmpresaCliente(miRs.getString("empresaCliente"));
				miPrestamo.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miPrestamo.setCodigoPrestamo(miRs.getString("codigoPrestamo"));
				if (miRs.getDate("fechaInicioPrestamo") != null) {
					miPrestamo.setFechaInicioPrestamo(formatoFecha.format(miRs.getDate("fechaInicioPrestamo")));
				}
				miPrestamo.setMontoPrestamo(formatoMoneda.format(miRs.getDouble("montoPrestamo")));
				miPrestamo.setTipoPlazo(miRs.getString("tipoPlazoPrestamo"));
				miPrestamo.setNumeroCuotasPrestamo(miRs.getInt("numeroCuotasprestamo"));
				miPrestamo.setValorCuotaPrestamo(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miPrestamo.setSaldoPendientePrestamo(formatoMoneda.format(miRs.getDouble("saldoRestantePrestamo")));

				listaPrestamos.add(miPrestamo);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar prestamos requeridos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarPrestamosConMatrizRequerido");

		}

		return listaPrestamos;
	}

	public void eliminarPrestamo(String codigoPrestamo) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call eliminar_prestamo(?)}");
			miProcedimiento.setString(1, codigoPrestamo);
			miProcedimiento.executeQuery();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para eliminar préstamo");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".eliminarPrestamo");
		}

	}

}// Fin clase
