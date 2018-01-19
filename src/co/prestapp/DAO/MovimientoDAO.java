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

import co.prestapp.VO.AbonoVO;
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
			System.out.println("Error al ejecutar consulta para listar movimientos");
			System.out.println(e.getMessage());

		}
		return listaAbonos;
	}// Fin buscarPrestamosConMatriz

	public String[][] obtenerMatrizMovimientos() {

		ArrayList<MovimientoVO> listaMovimientos = buscarMovimientosConMatriz();
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
}
