package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import co.prestapp.VO.MovimientoVO;
import co.prestapp.connection.DBConnection;
import co.prestapp.connection.DBError;

public class MovimientoDAO {

	DBError error = new DBError();

	public void agregarMovimiento(String codigoMovimiento, Date fechaMovimiento, double entradaMovimiento,
			double salidaMovimiento) {

		java.sql.Date fechaMovimientoFormateada = new java.sql.Date(fechaMovimiento.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call agregar_movimiento(?,?,?,?)}");
			miProcedimiento.setString(1, codigoMovimiento);
			miProcedimiento.setDate(2, fechaMovimientoFormateada);
			miProcedimiento.setDouble(3, entradaMovimiento);
			miProcedimiento.setDouble(4, salidaMovimiento);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para agregar movimiento");
			System.out.println(e.getMessage());
			e.printStackTrace();
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".agregarMovimiento");
		}

	}// Fin agregarMovimiento

	public String[] getColumnas() {

		String encabezados[] = { "#", "Código", "Fecha", "Entrada", "Salida", "Saldo" };
		return encabezados;
	}// Fin getColumnas

	public ArrayList<MovimientoVO> buscarMovimientosConMatriz() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<MovimientoVO> listaMovimientos = new ArrayList<MovimientoVO>();
		MovimientoVO miMovimiento;

		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_movimientos}");
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miMovimiento = new MovimientoVO();
				miMovimiento.setIdMovimiento(miRs.getInt("idMovimiento"));
				miMovimiento.setCodigoMovimiento(miRs.getString("codigoMovimiento"));
				miMovimiento.setFechaMovimiento(formato.format(miRs.getDate("fechaMovimiento")));
				miMovimiento.setEntradaMovimiento(formatoMoneda.format(miRs.getDouble("entradaMovimiento")));
				miMovimiento.setSalidaMovimiento(formatoMoneda.format(miRs.getDouble("salidaMovimiento")));
				miMovimiento.setSaldoMovimiento(formatoMoneda.format(miRs.getDouble("saldoMovimiento")));

				listaMovimientos.add(miMovimiento);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar movimientos");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarMovimientosConMatriz");

		}
		return listaMovimientos;
	}// Fin buscarPrestamosConMatriz

	public String[][] obtenerMatrizMovimientos() {

		ArrayList<MovimientoVO> listaMovimientos = buscarMovimientosConMatriz();
		String matrizInfo[][] = new String[listaMovimientos.size()][6];

		for (int i = 0; i < listaMovimientos.size(); i++) {
			matrizInfo[i][0] = listaMovimientos.get(i).getIdMovimiento() + "";
			matrizInfo[i][1] = listaMovimientos.get(i).getCodigoMovimiento() + "";
			matrizInfo[i][2] = listaMovimientos.get(i).getFechaMovimiento() + "";
			matrizInfo[i][3] = listaMovimientos.get(i).getEntradaMovimiento() + "";
			matrizInfo[i][4] = listaMovimientos.get(i).getSalidaMovimiento() + "";
			matrizInfo[i][5] = listaMovimientos.get(i).getSaldoMovimiento() + "";
		}

		return matrizInfo;
	}// Fin obtenerMatrizAbonos

	public void editarMovimiento(String codigoMovimiento, Date fechaMovimiento, double entradaMovimiento,
			double salidaMovimiento) {

		java.sql.Date fechaFormateada = new java.sql.Date(fechaMovimiento.getTime());

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call editar_movimiento(?,?,?,?)}");
			miProcedimiento.setString(1, codigoMovimiento);
			miProcedimiento.setDate(2, fechaFormateada);
			miProcedimiento.setDouble(3, entradaMovimiento);
			miProcedimiento.setDouble(4, salidaMovimiento);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para editar movimiento");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".editarMovimiento");

		}

	}

	public String[][] obtenerMatrizMovimientosEntrada() {

		ArrayList<MovimientoVO> listaMovimientos = buscarMovimientosEntradaConMatriz();
		String matrizInfo[][] = new String[listaMovimientos.size()][6];

		for (int i = 0; i < listaMovimientos.size(); i++) {
			matrizInfo[i][0] = listaMovimientos.get(i).getIdMovimiento() + "";
			matrizInfo[i][1] = listaMovimientos.get(i).getCodigoMovimiento() + "";
			matrizInfo[i][2] = listaMovimientos.get(i).getFechaMovimiento() + "";
			matrizInfo[i][3] = listaMovimientos.get(i).getEntradaMovimiento() + "";
			matrizInfo[i][4] = listaMovimientos.get(i).getSalidaMovimiento() + "";
			matrizInfo[i][5] = listaMovimientos.get(i).getSaldoMovimiento() + "";
		}

		return matrizInfo;
	}

	private ArrayList<MovimientoVO> buscarMovimientosEntradaConMatriz() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<MovimientoVO> listaMovimientos = new ArrayList<MovimientoVO>();
		MovimientoVO miMovimiento;

		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_movimientos_entrada}");
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miMovimiento = new MovimientoVO();
				miMovimiento.setIdMovimiento(miRs.getInt("idMovimiento"));
				miMovimiento.setCodigoMovimiento(miRs.getString("codigoMovimiento"));
				miMovimiento.setFechaMovimiento(formato.format(miRs.getDate("fechaMovimiento")));
				miMovimiento.setEntradaMovimiento(formatoMoneda.format(miRs.getDouble("entradaMovimiento")));
				miMovimiento.setSalidaMovimiento(formatoMoneda.format(miRs.getDouble("salidaMovimiento")));
				miMovimiento.setSaldoMovimiento(formatoMoneda.format(miRs.getDouble("saldoMovimiento")));

				listaMovimientos.add(miMovimiento);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar movimientos entrada");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarMovimientosEntradaConMatriz");

		}
		return listaMovimientos;
	}

	public String[][] obtenerMatrizMovimientosSalida() {

		ArrayList<MovimientoVO> listaMovimientos = buscarMovimientosSalidaConMatriz();
		String matrizInfo[][] = new String[listaMovimientos.size()][6];

		for (int i = 0; i < listaMovimientos.size(); i++) {
			matrizInfo[i][0] = listaMovimientos.get(i).getIdMovimiento() + "";
			matrizInfo[i][1] = listaMovimientos.get(i).getCodigoMovimiento() + "";
			matrizInfo[i][2] = listaMovimientos.get(i).getFechaMovimiento() + "";
			matrizInfo[i][3] = listaMovimientos.get(i).getEntradaMovimiento() + "";
			matrizInfo[i][4] = listaMovimientos.get(i).getSalidaMovimiento() + "";
			matrizInfo[i][5] = listaMovimientos.get(i).getSaldoMovimiento() + "";
		}

		return matrizInfo;
	}

	private ArrayList<MovimientoVO> buscarMovimientosSalidaConMatriz() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<MovimientoVO> listaMovimientos = new ArrayList<MovimientoVO>();
		MovimientoVO miMovimiento;

		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_movimientos_salida}");
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miMovimiento = new MovimientoVO();
				miMovimiento.setIdMovimiento(miRs.getInt("idMovimiento"));
				miMovimiento.setCodigoMovimiento(miRs.getString("codigoMovimiento"));
				miMovimiento.setFechaMovimiento(formato.format(miRs.getDate("fechaMovimiento")));
				miMovimiento.setEntradaMovimiento(formatoMoneda.format(miRs.getDouble("entradaMovimiento")));
				miMovimiento.setSalidaMovimiento(formatoMoneda.format(miRs.getDouble("salidaMovimiento")));
				miMovimiento.setSaldoMovimiento(formatoMoneda.format(miRs.getDouble("saldoMovimiento")));

				listaMovimientos.add(miMovimiento);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar movimientos salida");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarMovimientosSalidaConMatriz");

		}
		return listaMovimientos;
	}

	public String[][] obtenerMatrizMovimientosFechas(Date fechaInicio, Date fechaFin) {

		ArrayList<MovimientoVO> listaMovimientos = buscarMovimientosFechasConMatriz(fechaInicio, fechaFin);
		String matrizInfo[][] = new String[listaMovimientos.size()][6];

		for (int i = 0; i < listaMovimientos.size(); i++) {
			matrizInfo[i][0] = listaMovimientos.get(i).getIdMovimiento() + "";
			matrizInfo[i][1] = listaMovimientos.get(i).getCodigoMovimiento() + "";
			matrizInfo[i][2] = listaMovimientos.get(i).getFechaMovimiento() + "";
			matrizInfo[i][3] = listaMovimientos.get(i).getEntradaMovimiento() + "";
			matrizInfo[i][4] = listaMovimientos.get(i).getSalidaMovimiento() + "";
			matrizInfo[i][5] = listaMovimientos.get(i).getSaldoMovimiento() + "";
		}

		return matrizInfo;
	}

	private ArrayList<MovimientoVO> buscarMovimientosFechasConMatriz(Date fechaInicio, Date fechaFin) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<MovimientoVO> listaMovimientos = new ArrayList<MovimientoVO>();
		MovimientoVO miMovimiento;
		java.sql.Date fechaInicioFormateada = new java.sql.Date(fechaInicio.getTime());
		java.sql.Date fechaFinFormateada = new java.sql.Date(fechaFin.getTime());

		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_movimientos_fechas(?,?)}");
			miProcedimiento.setDate(1, fechaInicioFormateada);
			miProcedimiento.setDate(2, fechaFinFormateada);
			ResultSet miRs = miProcedimiento.executeQuery();
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			Locale locale = new Locale("es", "CO");
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

			while (miRs.next()) {
				miMovimiento = new MovimientoVO();
				miMovimiento.setIdMovimiento(miRs.getInt("idMovimiento"));
				miMovimiento.setCodigoMovimiento(miRs.getString("codigoMovimiento"));
				miMovimiento.setFechaMovimiento(formato.format(miRs.getDate("fechaMovimiento")));
				miMovimiento.setEntradaMovimiento(formatoMoneda.format(miRs.getDouble("entradaMovimiento")));
				miMovimiento.setSalidaMovimiento(formatoMoneda.format(miRs.getDouble("salidaMovimiento")));
				miMovimiento.setSaldoMovimiento(formatoMoneda.format(miRs.getDouble("saldoMovimiento")));

				listaMovimientos.add(miMovimiento);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar movimientos entre fechas");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".buscarMovimientosFechasConMatriz");

		}
		return listaMovimientos;
	}

	public float calcularTotalEntradas() {

		float totalEntradas = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call sumar_entradas_movimiento(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalEntradas = miProcedimiento.getFloat(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para sumar entradas");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".calcularTotalEntradas");
		}

		return totalEntradas;

	}// Fin calcularTotalEntradas
	
	public float calcularTotalSalidas() {

		float totalSalidas = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call sumar_salidas_movimiento(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalSalidas = miProcedimiento.getFloat(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para sumar salidas");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".calcularTotalSalidas");
		}

		return totalSalidas;

	}// Fin calcularTotalSalidas

	public float calcularTotalEntradas(Date fechaInicio, Date fechaFin) {

		java.sql.Date fechaInicioFormateada = new java.sql.Date(fechaInicio.getTime());
		java.sql.Date fechaFinFormateada = new java.sql.Date(fechaFin.getTime());
		float totalEntradas = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call sumar_entradas_movimiento_fechas(?,?,?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.setDate(2, fechaInicioFormateada);
			miProcedimiento.setDate(3, fechaFinFormateada);
			miProcedimiento.executeQuery();
			totalEntradas = miProcedimiento.getFloat(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para sumar entradas por fecha");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".calcularTotalEntradas");
		}

		return totalEntradas;
	}

	public float calcularTotalSalidas(Date fechaInicio, Date fechaFin) {

		java.sql.Date fechaInicioFormateada = new java.sql.Date(fechaInicio.getTime());
		java.sql.Date fechaFinFormateada = new java.sql.Date(fechaFin.getTime());
		float totalSalidas = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call sumar_salidas_movimiento_fechas(?,?,?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.setDate(2, fechaInicioFormateada);
			miProcedimiento.setDate(3, fechaFinFormateada);
			miProcedimiento.executeQuery();
			totalSalidas = miProcedimiento.getFloat(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para sumar salidas por fecha");
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".calcularTotalSalidas");
		}

		return totalSalidas;
	}
}
