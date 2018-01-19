package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import co.prestapp.VO.MovimientoVO;
import co.prestapp.connection.DBConnection;

public class MovimientoDAO {

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
}
