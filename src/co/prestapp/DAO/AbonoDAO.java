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
import java.util.Locale;

import co.prestapp.VO.AbonoVO;
import co.prestapp.connection.DBConnection;

public class AbonoDAO {

	public void agregarAbono(double montoACobrar, double montoPagado, String completoAbono, Date fechaCobro,
			String abonoPrestamoFK, String puntualAbono, String estadoAbono, int numeroAbono) {

		java.sql.Date fechaCobroFormateada = new java.sql.Date(fechaCobro.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		String codigoAbono = recuperarCodigoAbono();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call agregar_abono(?,?,?,?,?,?,?,?,?)}");
			miProcedimiento.setString(1, codigoAbono);
			miProcedimiento.setDouble(2, montoACobrar);
			miProcedimiento.setDouble(3, montoPagado);
			miProcedimiento.setString(4, completoAbono);
			miProcedimiento.setDate(5, fechaCobroFormateada);
			miProcedimiento.setString(6, abonoPrestamoFK);
			miProcedimiento.setString(7, puntualAbono);
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

	public String[] getColumnas() {

		String encabezados[] = { "#", "Código", "Cobrar", "Pagado", "Completo", "Cobrar", "Pagado", "Préstamo",
				"Puntual", "Estado", "Abono#" };
		return encabezados;
	}// Fin getColumnas

	public String recuperarCodigoAbono() {

		String codigoAbono = "";
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call generar_codigo_abono(?)}");
			miProcedimiento.registerOutParameter(1, Types.VARCHAR);
			miProcedimiento.executeQuery();
			codigoAbono = miProcedimiento.getString(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para generar codigo de abono");
			System.out.println(e.getMessage());
		}

		return codigoAbono;

	}// Fin recuperarCodigoAbono

	public void crearAbonosPrestamo(double totalAPagar, int numeroCuotas, ArrayList<Date> fechasPago,
			String codigoPrestamo) {

		double montoACobrar = totalAPagar / numeroCuotas;
		double montoPagado = 0;
		String completoAbono = "NO";
		// fecha de Pago no voy a enviar
		String puntualAbono = "NO";
		String estadoAbono = "PENDIENTE";

		for (int i = 0; i < fechasPago.size(); i++) {

			agregarAbono(montoACobrar, montoPagado, completoAbono, fechasPago.get(i), codigoPrestamo, puntualAbono,
					estadoAbono, i + 1);
		}

	}// Fin crearAbonosPrestamo

	// ----------------------------------------------VO-----------------------------------------------------
	public ArrayList<AbonoVO> buscarAbonosConMatriz() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<AbonoVO> listaAbonos = new ArrayList<AbonoVO>();
		AbonoVO miAbono;
		;
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_abonos}");
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miAbono = new AbonoVO();
				miAbono.setIDAbono(miRs.getInt("idAbono"));
				miAbono.setCodigoAbono(miRs.getString("codigoAbono"));
				miAbono.setMontoACobrar(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miAbono.setMontoPagado(formatoMoneda.format(miRs.getDouble("montoPagado")));
				miAbono.setCompletoAbono(miRs.getString("completoAbono"));
				miAbono.setFechaACobrar(formato.format(miRs.getDate("fechaACobrar")));
				if (miRs.getDate("fechaPago") != null) {
					miAbono.setFechaPago(formato.format(miRs.getDate("fechaPago")));
				}
				miAbono.setAbonoPrestamo(miRs.getString("abonoPrestamo"));
				miAbono.setPuntualAbono(miRs.getString("puntualAbono"));
				miAbono.setEstadoAbono(miRs.getString("estadoAbono"));
				miAbono.setNumeroAbono(miRs.getInt("numeroAbono"));

				listaAbonos.add(miAbono);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar abonos");
			System.out.println(e.getMessage());

		}
		return listaAbonos;
	}// Fin buscarPrestamosConMatriz

	public String[][] obtenerMatrizAbonos() {

		ArrayList<AbonoVO> listaAbonos = buscarAbonosConMatriz();
		String matrizInfo[][] = new String[listaAbonos.size()][11];

		for (int i = 0; i < listaAbonos.size(); i++) {
			matrizInfo[i][0] = listaAbonos.get(i).getIDAbono() + "";
			matrizInfo[i][1] = listaAbonos.get(i).getCodigoAbono() + "";
			matrizInfo[i][2] = listaAbonos.get(i).getMontoACobrar() + "";
			matrizInfo[i][3] = listaAbonos.get(i).getMontoPagado() + "";
			matrizInfo[i][4] = listaAbonos.get(i).getCompletoAbono() + "";
			matrizInfo[i][5] = listaAbonos.get(i).getFechaACobrar() + "";
			matrizInfo[i][6] = listaAbonos.get(i).getFechaPago() + "";
			matrizInfo[i][7] = listaAbonos.get(i).getAbonoPrestamo() + "";
			matrizInfo[i][8] = listaAbonos.get(i).getPuntualAbono() + "";
			matrizInfo[i][9] = listaAbonos.get(i).getEstadoAbono() + "";
			matrizInfo[i][10] = listaAbonos.get(i).getNumeroAbono() + "";
		}

		return matrizInfo;
	}// Fin obtenerMatrizAbonos

	// -------------------------VO
	// BUSQUEDA-----------------------------------------------------------------
	public ArrayList<AbonoVO> buscarAbonosPrestamo(String abonoPrestamo) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<AbonoVO> listaAbonos = new ArrayList<AbonoVO>();
		AbonoVO miAbono;
		;
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call buscar_abono_prestamo(?)}");
			miProcedimiento.setString(1, abonoPrestamo);
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miAbono = new AbonoVO();
				miAbono.setIDAbono(miRs.getInt("idAbono"));
				miAbono.setCodigoAbono(miRs.getString("codigoAbono"));
				miAbono.setMontoACobrar(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miAbono.setMontoPagado(formatoMoneda.format(miRs.getDouble("montoPagado")));
				miAbono.setCompletoAbono(miRs.getString("completoAbono"));
				miAbono.setFechaACobrar(formato.format(miRs.getDate("fechaACobrar")));
				if (miRs.getDate("fechaPago") != null) {
					miAbono.setFechaPago(formato.format(miRs.getDate("fechaPago")));
				}
				miAbono.setAbonoPrestamo(miRs.getString("abonoPrestamo"));
				miAbono.setPuntualAbono(miRs.getString("puntualAbono"));
				miAbono.setEstadoAbono(miRs.getString("estadoAbono"));
				miAbono.setNumeroAbono(miRs.getInt("numeroAbono"));

				listaAbonos.add(miAbono);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para buscar abono por codigo de prestamo");
			System.out.println(e.getMessage());

		}
		return listaAbonos;
	}// Fin buscarPrestamosConMatriz

	public String[][] obtenerMatrizAbonosBusqueda(String abonoPrestamo) {

		ArrayList<AbonoVO> listaAbonos = buscarAbonosPrestamo(abonoPrestamo);
		String matrizInfo[][] = new String[listaAbonos.size()][11];

		for (int i = 0; i < listaAbonos.size(); i++) {
			matrizInfo[i][0] = listaAbonos.get(i).getIDAbono() + "";
			matrizInfo[i][1] = listaAbonos.get(i).getCodigoAbono() + "";
			matrizInfo[i][2] = listaAbonos.get(i).getMontoACobrar() + "";
			matrizInfo[i][3] = listaAbonos.get(i).getMontoPagado() + "";
			matrizInfo[i][4] = listaAbonos.get(i).getCompletoAbono() + "";
			matrizInfo[i][5] = listaAbonos.get(i).getFechaACobrar() + "";
			matrizInfo[i][6] = listaAbonos.get(i).getFechaPago() + "";
			matrizInfo[i][7] = listaAbonos.get(i).getAbonoPrestamo() + "";
			matrizInfo[i][8] = listaAbonos.get(i).getPuntualAbono() + "";
			matrizInfo[i][9] = listaAbonos.get(i).getEstadoAbono() + "";
			matrizInfo[i][10] = listaAbonos.get(i).getNumeroAbono() + "";
		}

		return matrizInfo;
	}// Fin obtenerMatrizAbonos

	// -----------------------------------PAGO
	// ABONO----------------------------------------------
	public void pagarAbono(String codigoAbono, Date fechaPago, double montoPagado) {

		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);
		String completoAbono = "NO";
		String puntualAbono = "NO";
		AbonoVO miAbono = buscarAbono(codigoAbono);
		// Verifico si puntual y si completo
		SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
		Date fechaCobro = null;
		try {

			fechaCobro = formato.parse(miAbono.getFechaACobrar());

		} catch (ParseException ex) {

			ex.printStackTrace();

		}
		// Comparo fechas
		if (fechaPago.before(fechaCobro)) {
			puntualAbono = "SI";
		}

		try {
			if (montoPagado >= formatoMoneda.parse(miAbono.getMontoACobrar()).doubleValue()) {
				completoAbono = "SI";
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			System.out.println("No sé si el abono es completo o no");
		}

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		java.sql.Date fechaPagoFormateada = new java.sql.Date(fechaPago.getTime());
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call pagar_abono(?,?,?,?,?)}");
			miProcedimiento.setString(1, codigoAbono);
			miProcedimiento.setDate(2, fechaPagoFormateada);
			miProcedimiento.setDouble(3, montoPagado);
			miProcedimiento.setString(4, completoAbono);
			miProcedimiento.setString(5, puntualAbono);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar el pago del abono");
			System.out.println(e.getMessage());

		}

	}// Fin pagarAbono

	public AbonoVO buscarAbono(String codigoAbono) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		AbonoVO miAbono = null;

		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call buscar_abono(?)}");
			miProcedimiento.setString(1, codigoAbono);
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miAbono = new AbonoVO();
				miAbono.setIDAbono(miRs.getInt("idAbono"));
				miAbono.setCodigoAbono(miRs.getString("codigoAbono"));
				miAbono.setMontoACobrar(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miAbono.setMontoPagado(formatoMoneda.format(miRs.getDouble("montoPagado")));
				miAbono.setCompletoAbono(miRs.getString("completoAbono"));
				miAbono.setFechaACobrar(formato.format(miRs.getDate("fechaACobrar")));
				if (miRs.getDate("fechaPago") != null) {
					miAbono.setFechaPago(formato.format(miRs.getDate("fechaPago")));
				}
				miAbono.setAbonoPrestamo(miRs.getString("abonoPrestamo"));
				miAbono.setPuntualAbono(miRs.getString("puntualAbono"));
				miAbono.setEstadoAbono(miRs.getString("estadoAbono"));
				miAbono.setNumeroAbono(miRs.getInt("numeroAbono"));
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para buscar abono");
			System.out.println(e.getMessage());

		}
		return miAbono;
	}// Fin buscarPrestamosConMatriz

	public String[][] obtenerMatrizAbonosPendientes() {
		ArrayList<AbonoVO> listaAbonos = buscarAbonosPendientesConMatriz();
		String matrizInfo[][] = new String[listaAbonos.size()][11];

		for (int i = 0; i < listaAbonos.size(); i++) {
			matrizInfo[i][0] = listaAbonos.get(i).getIDAbono() + "";
			matrizInfo[i][1] = listaAbonos.get(i).getCodigoAbono() + "";
			matrizInfo[i][2] = listaAbonos.get(i).getMontoACobrar() + "";
			matrizInfo[i][3] = listaAbonos.get(i).getMontoPagado() + "";
			matrizInfo[i][4] = listaAbonos.get(i).getCompletoAbono() + "";
			matrizInfo[i][5] = listaAbonos.get(i).getFechaACobrar() + "";
			matrizInfo[i][6] = listaAbonos.get(i).getFechaPago() + "";
			matrizInfo[i][7] = listaAbonos.get(i).getAbonoPrestamo() + "";
			matrizInfo[i][8] = listaAbonos.get(i).getPuntualAbono() + "";
			matrizInfo[i][9] = listaAbonos.get(i).getEstadoAbono() + "";
			matrizInfo[i][10] = listaAbonos.get(i).getNumeroAbono() + "";
		}

		return matrizInfo;
	}

	private ArrayList<AbonoVO> buscarAbonosPendientesConMatriz() {
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<AbonoVO> listaAbonos = new ArrayList<AbonoVO>();
		AbonoVO miAbono;
		;
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_abonos_pendientes}");
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miAbono = new AbonoVO();
				miAbono.setIDAbono(miRs.getInt("idAbono"));
				miAbono.setCodigoAbono(miRs.getString("codigoAbono"));
				miAbono.setMontoACobrar(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miAbono.setMontoPagado(formatoMoneda.format(miRs.getDouble("montoPagado")));
				miAbono.setCompletoAbono(miRs.getString("completoAbono"));
				miAbono.setFechaACobrar(formato.format(miRs.getDate("fechaACobrar")));
				if (miRs.getDate("fechaPago") != null) {
					miAbono.setFechaPago(formato.format(miRs.getDate("fechaPago")));
				}
				miAbono.setAbonoPrestamo(miRs.getString("abonoPrestamo"));
				miAbono.setPuntualAbono(miRs.getString("puntualAbono"));
				miAbono.setEstadoAbono(miRs.getString("estadoAbono"));
				miAbono.setNumeroAbono(miRs.getInt("numeroAbono"));

				listaAbonos.add(miAbono);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar abonos pendientes");
			System.out.println(e.getMessage());

		}
		return listaAbonos;
	}

	public String[][] obtenerMatrizAbonosPagados() {
		ArrayList<AbonoVO> listaAbonos = buscarAbonosPagadosConMatriz();
		String matrizInfo[][] = new String[listaAbonos.size()][11];

		for (int i = 0; i < listaAbonos.size(); i++) {
			matrizInfo[i][0] = listaAbonos.get(i).getIDAbono() + "";
			matrizInfo[i][1] = listaAbonos.get(i).getCodigoAbono() + "";
			matrizInfo[i][2] = listaAbonos.get(i).getMontoACobrar() + "";
			matrizInfo[i][3] = listaAbonos.get(i).getMontoPagado() + "";
			matrizInfo[i][4] = listaAbonos.get(i).getCompletoAbono() + "";
			matrizInfo[i][5] = listaAbonos.get(i).getFechaACobrar() + "";
			matrizInfo[i][6] = listaAbonos.get(i).getFechaPago() + "";
			matrizInfo[i][7] = listaAbonos.get(i).getAbonoPrestamo() + "";
			matrizInfo[i][8] = listaAbonos.get(i).getPuntualAbono() + "";
			matrizInfo[i][9] = listaAbonos.get(i).getEstadoAbono() + "";
			matrizInfo[i][10] = listaAbonos.get(i).getNumeroAbono() + "";
		}

		return matrizInfo;
	}

	private ArrayList<AbonoVO> buscarAbonosPagadosConMatriz() {
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<AbonoVO> listaAbonos = new ArrayList<AbonoVO>();
		AbonoVO miAbono;
		;
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_abonos_pagados}");
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miAbono = new AbonoVO();
				miAbono.setIDAbono(miRs.getInt("idAbono"));
				miAbono.setCodigoAbono(miRs.getString("codigoAbono"));
				miAbono.setMontoACobrar(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miAbono.setMontoPagado(formatoMoneda.format(miRs.getDouble("montoPagado")));
				miAbono.setCompletoAbono(miRs.getString("completoAbono"));
				miAbono.setFechaACobrar(formato.format(miRs.getDate("fechaACobrar")));
				if (miRs.getDate("fechaPago") != null) {
					miAbono.setFechaPago(formato.format(miRs.getDate("fechaPago")));
				}
				miAbono.setAbonoPrestamo(miRs.getString("abonoPrestamo"));
				miAbono.setPuntualAbono(miRs.getString("puntualAbono"));
				miAbono.setEstadoAbono(miRs.getString("estadoAbono"));
				miAbono.setNumeroAbono(miRs.getInt("numeroAbono"));

				listaAbonos.add(miAbono);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar abonos pagados");
			System.out.println(e.getMessage());

		}
		return listaAbonos;
	}

	public String[][] obtenerMatrizAbonosPorFecha(Date fechaSeleccionada) {

		ArrayList<AbonoVO> listaAbonos = buscarAbonosPagadosPorFechaConMatriz(fechaSeleccionada);
		String matrizInfo[][] = new String[listaAbonos.size()][11];

		for (int i = 0; i < listaAbonos.size(); i++) {
			matrizInfo[i][0] = listaAbonos.get(i).getIDAbono() + "";
			matrizInfo[i][1] = listaAbonos.get(i).getCodigoAbono() + "";
			matrizInfo[i][2] = listaAbonos.get(i).getMontoACobrar() + "";
			matrizInfo[i][3] = listaAbonos.get(i).getMontoPagado() + "";
			matrizInfo[i][4] = listaAbonos.get(i).getCompletoAbono() + "";
			matrizInfo[i][5] = listaAbonos.get(i).getFechaACobrar() + "";
			matrizInfo[i][6] = listaAbonos.get(i).getFechaPago() + "";
			matrizInfo[i][7] = listaAbonos.get(i).getAbonoPrestamo() + "";
			matrizInfo[i][8] = listaAbonos.get(i).getPuntualAbono() + "";
			matrizInfo[i][9] = listaAbonos.get(i).getEstadoAbono() + "";
			matrizInfo[i][10] = listaAbonos.get(i).getNumeroAbono() + "";
		}

		return matrizInfo;
	}

	private ArrayList<AbonoVO> buscarAbonosPagadosPorFechaConMatriz(Date fechaSeleccionada) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<AbonoVO> listaAbonos = new ArrayList<AbonoVO>();
		AbonoVO miAbono;
		java.sql.Date fechaSeleccionadaFormateada = new java.sql.Date(fechaSeleccionada.getTime());

		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_abonos_pagados_por_fecha(?)}");
			miProcedimiento.setDate(1, fechaSeleccionadaFormateada);
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miAbono = new AbonoVO();
				miAbono.setIDAbono(miRs.getInt("idAbono"));
				miAbono.setCodigoAbono(miRs.getString("codigoAbono"));
				miAbono.setMontoACobrar(formatoMoneda.format(miRs.getDouble("montoACobrar")));
				miAbono.setMontoPagado(formatoMoneda.format(miRs.getDouble("montoPagado")));
				miAbono.setCompletoAbono(miRs.getString("completoAbono"));
				miAbono.setFechaACobrar(formato.format(miRs.getDate("fechaACobrar")));
				if (miRs.getDate("fechaPago") != null) {
					miAbono.setFechaPago(formato.format(miRs.getDate("fechaPago")));
				}
				miAbono.setAbonoPrestamo(miRs.getString("abonoPrestamo"));
				miAbono.setPuntualAbono(miRs.getString("puntualAbono"));
				miAbono.setEstadoAbono(miRs.getString("estadoAbono"));
				miAbono.setNumeroAbono(miRs.getInt("numeroAbono"));

				listaAbonos.add(miAbono);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar abonos pagados por fecha");
			System.out.println(e.getMessage());

		}
		return listaAbonos;
	}

	public int contarAbonosCobrados() {

		int totalAbonosCobrados = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call contar_abonos_cobrados(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalAbonosCobrados = miProcedimiento.getInt(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para contar abonos cobrados");
			System.out.println(e.getMessage());
		}

		return totalAbonosCobrados;
	}

	public int contarAbonosPendientes() {

		int totalAbonosPendientes = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call contar_abonos_pendientes(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalAbonosPendientes = miProcedimiento.getInt(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para contar abonos pendientes");
			System.out.println(e.getMessage());
		}

		return totalAbonosPendientes;
	}

	public boolean verificarAbonoPendiente(String codigoAbono) {

		boolean respuesta = false;
		AbonoVO miAbonoVO = buscarAbono(codigoAbono);

		if (miAbonoVO.getEstadoAbono().equals("PENDIENTE")) {
			System.out.println(miAbonoVO.getEstadoAbono());
			respuesta = true;
		}

		return respuesta;
	}

} // Fin AbonoDAO
