package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import co.prestapp.VO.ClienteVO;
import co.prestapp.connection.DBConnection;

public class ClienteDAO {

	public void agregarCliente(String nombre, String empresa, String referencia) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		String codigoCliente = recuperarCodigoCliente();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call agregar_cliente(?,?,?,?)}");
			miProcedimiento.setString(1, codigoCliente);
			miProcedimiento.setString(2, nombre);
			miProcedimiento.setString(3, empresa);
			miProcedimiento.setString(4, referencia);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para agregar cliente");
			System.out.println(e.getMessage());
		}

	}// Fin agregar cliente

	public ClienteVO buscarCliente(String codigoCliente) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ClienteVO miCliente = new ClienteVO();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call buscar_cliente(?)}");
			miProcedimiento.setString(1, codigoCliente);
			ResultSet miRs = miProcedimiento.executeQuery();
			if (miRs.next()) {
				miCliente.setIDCliente(miRs.getInt("idCliente"));
				miCliente.setCodigoCliente(miRs.getString("codigoCliente"));
				miCliente.setNombreCliente(miRs.getString("nombreCliente"));
				miCliente.setEmpresaCliente(miRs.getString("empresaCliente"));
				miCliente.setReferenciaCliente(miRs.getString("referenciaCliente"));
			}

			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para buscar cliente");
			System.out.println(e.getMessage());
		}

		return miCliente;
	}

	public String[] getColumnas() {

		String encabezados[] = { "#", "Código", "Nombre", "Empresa", "Referencia", "Estado" };
		return encabezados;
	}// Fin getColumnas

	public String recuperarCodigoCliente() {

		String codigoCliente = "";
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call generar_codigo_cliente(?)}");
			miProcedimiento.registerOutParameter(1, Types.VARCHAR);
			miProcedimiento.executeQuery();
			codigoCliente = miProcedimiento.getString(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para generar codigo de cliente");
			System.out.println(e.getMessage());
		}

		return codigoCliente;

	}// Fin recuperarCodigoCliente

	public int contarClientesRegistrados() {

		int totalRegistrados = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call contar_clientes_registrados(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalRegistrados = miProcedimiento.getInt(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para contar clientes registrados");
			System.out.println(e.getMessage());
		}

		return totalRegistrados;

	}

	public int contarClientesActivos() {

		int totalActivos = 0;
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call contar_clientes_activos(?)}");
			miProcedimiento.registerOutParameter(1, Types.NUMERIC);
			miProcedimiento.executeQuery();
			totalActivos = miProcedimiento.getInt(1);
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para contar clientes activos");
			System.out.println(e.getMessage());
		}

		return totalActivos;
	}

	// ------------------------------------------------------VO-------------------------------------------

	public ArrayList<ClienteVO> buscarClientesConMatriz() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<ClienteVO> listaClientes = new ArrayList<ClienteVO>();
		ClienteVO miCliente;
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_clientes}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {
				miCliente = new ClienteVO();
				miCliente.setIDCliente(miRs.getInt("idCliente"));
				miCliente.setCodigoCliente(miRs.getString("codigoCliente"));
				miCliente.setNombreCliente(miRs.getString("nombreCliente"));
				miCliente.setEmpresaCliente(miRs.getString("empresaCliente"));
				miCliente.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miCliente.setEstadoCliente(miRs.getString("estadoCliente"));

				listaClientes.add(miCliente);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar clientes");
			System.out.println(e.getMessage());

		}
		return listaClientes;
	}// Fin buscarClientesConMatriz

	public String[][] obtenerMatrizClientes() {

		ArrayList<ClienteVO> listaClientes = buscarClientesConMatriz();

		String matrizInfo[][] = new String[listaClientes.size()][6];

		for (int i = 0; i < listaClientes.size(); i++) {
			matrizInfo[i][0] = listaClientes.get(i).getIDCliente() + "";
			matrizInfo[i][1] = listaClientes.get(i).getCodigoCliente() + "";
			matrizInfo[i][2] = listaClientes.get(i).getNombreCliente() + "";
			matrizInfo[i][3] = listaClientes.get(i).getEmpresaCliente() + "";
			matrizInfo[i][4] = listaClientes.get(i).getReferenciaCliente() + "";
			matrizInfo[i][5] = listaClientes.get(i).getEstadoCliente() + "";
		}

		return matrizInfo;
	}// Fin obtenerMatrizClientes

	public void editarCliente(String codigoCliente, String nombre, String empresa, String referencia) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call editar_cliente(?,?,?,?)}");
			miProcedimiento.setString(1, codigoCliente);
			miProcedimiento.setString(2, nombre);
			miProcedimiento.setString(3, empresa);
			miProcedimiento.setString(4, referencia);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para editar clientes");
			System.out.println(e.getMessage());

		}
	}

	public String[][] obtenerMatrizClientesAlfa() {
		ArrayList<ClienteVO> listaClientes = buscarClientesConMatrizAlfa();

		String matrizInfo[][] = new String[listaClientes.size()][6];

		for (int i = 0; i < listaClientes.size(); i++) {
			matrizInfo[i][0] = listaClientes.get(i).getIDCliente() + "";
			matrizInfo[i][1] = listaClientes.get(i).getCodigoCliente() + "";
			matrizInfo[i][2] = listaClientes.get(i).getNombreCliente() + "";
			matrizInfo[i][3] = listaClientes.get(i).getEmpresaCliente() + "";
			matrizInfo[i][4] = listaClientes.get(i).getReferenciaCliente() + "";
			matrizInfo[i][5] = listaClientes.get(i).getEstadoCliente() + "";
		}

		return matrizInfo;
	}

	private ArrayList<ClienteVO> buscarClientesConMatrizAlfa() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<ClienteVO> listaClientes = new ArrayList<ClienteVO>();
		ClienteVO miCliente;
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_clientes_alfa}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {
				miCliente = new ClienteVO();
				miCliente.setIDCliente(miRs.getInt("idCliente"));
				miCliente.setCodigoCliente(miRs.getString("codigoCliente"));
				miCliente.setNombreCliente(miRs.getString("nombreCliente"));
				miCliente.setEmpresaCliente(miRs.getString("empresaCliente"));
				miCliente.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miCliente.setEstadoCliente(miRs.getString("estadoCliente"));

				listaClientes.add(miCliente);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar clientes");
			System.out.println(e.getMessage());

		}
		return listaClientes;
	}

	public String[][] obtenerMatrizClientesActivos() {
		ArrayList<ClienteVO> listaClientes = buscarClientesConMatrizActivos();

		String matrizInfo[][] = new String[listaClientes.size()][6];

		for (int i = 0; i < listaClientes.size(); i++) {
			matrizInfo[i][0] = listaClientes.get(i).getIDCliente() + "";
			matrizInfo[i][1] = listaClientes.get(i).getCodigoCliente() + "";
			matrizInfo[i][2] = listaClientes.get(i).getNombreCliente() + "";
			matrizInfo[i][3] = listaClientes.get(i).getEmpresaCliente() + "";
			matrizInfo[i][4] = listaClientes.get(i).getReferenciaCliente() + "";
			matrizInfo[i][5] = listaClientes.get(i).getEstadoCliente() + "";
		}

		return matrizInfo;
	}

	private ArrayList<ClienteVO> buscarClientesConMatrizActivos() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<ClienteVO> listaClientes = new ArrayList<ClienteVO>();
		ClienteVO miCliente;
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_clientes_activos}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {
				miCliente = new ClienteVO();
				miCliente.setIDCliente(miRs.getInt("idCliente"));
				miCliente.setCodigoCliente(miRs.getString("codigoCliente"));
				miCliente.setNombreCliente(miRs.getString("nombreCliente"));
				miCliente.setEmpresaCliente(miRs.getString("empresaCliente"));
				miCliente.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miCliente.setEstadoCliente(miRs.getString("estadoCliente"));

				listaClientes.add(miCliente);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar clientes");
			System.out.println(e.getMessage());

		}
		return listaClientes;
	}

	public String[][] obtenerMatrizClientesNOActivos() {
		ArrayList<ClienteVO> listaClientes = buscarClientesConMatrizNOActivos();

		String matrizInfo[][] = new String[listaClientes.size()][6];

		for (int i = 0; i < listaClientes.size(); i++) {
			matrizInfo[i][0] = listaClientes.get(i).getIDCliente() + "";
			matrizInfo[i][1] = listaClientes.get(i).getCodigoCliente() + "";
			matrizInfo[i][2] = listaClientes.get(i).getNombreCliente() + "";
			matrizInfo[i][3] = listaClientes.get(i).getEmpresaCliente() + "";
			matrizInfo[i][4] = listaClientes.get(i).getReferenciaCliente() + "";
			matrizInfo[i][5] = listaClientes.get(i).getEstadoCliente() + "";
		}

		return matrizInfo;
	}

	private ArrayList<ClienteVO> buscarClientesConMatrizNOActivos() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<ClienteVO> listaClientes = new ArrayList<ClienteVO>();
		ClienteVO miCliente;
		try {
			CallableStatement miProcedimiento = conexion.prepareCall("{call listar_clientes_no_activos}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {
				miCliente = new ClienteVO();
				miCliente.setIDCliente(miRs.getInt("idCliente"));
				miCliente.setCodigoCliente(miRs.getString("codigoCliente"));
				miCliente.setNombreCliente(miRs.getString("nombreCliente"));
				miCliente.setEmpresaCliente(miRs.getString("empresaCliente"));
				miCliente.setReferenciaCliente(miRs.getString("referenciaCliente"));
				miCliente.setEstadoCliente(miRs.getString("estadoCliente"));

				listaClientes.add(miCliente);
			}
			miRs.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al ejecutar consulta para listar clientes");
			System.out.println(e.getMessage());

		}
		return listaClientes;
	}

}// Fin clase
