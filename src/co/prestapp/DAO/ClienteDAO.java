package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import co.prestapp.VO.ClienteVO;
import co.prestapp.connection.DBConnection;

public class ClienteDAO {

	public void agregarCliente(String nombre, String empresa, String referencia) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		String codigoCliente=recuperarCodigoCliente();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call agregar_cliente(?,?,?,?)}");
			miProcedimiento.setString(1, codigoCliente);
			miProcedimiento.setString(2, nombre);
			miProcedimiento.setString(3, empresa);
			miProcedimiento.setString(4, referencia);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para agregar cliente");
			System.out.println(e.getMessage());
		}

	}// Fin agregar cliente

	public ClienteVO buscarCliente(String codigoCliente) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ClienteVO miCliente = new ClienteVO();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call buscar_cliente(?)}");
			miProcedimiento.setString(1, codigoCliente);
			ResultSet miRs = miProcedimiento.executeQuery();
			if (miRs.next()) {
				miCliente.setIDCliente(miRs.getInt("idCliente"));
				miCliente.setCodigoCliente(miRs.getString("codigoCliente"));
				miCliente.setNombreCliente(miRs.getString("nombreCliente"));
				miCliente.setEmpresaCliente(miRs.getString("empresaCliente"));
				miCliente.setReferenciaCliente(miRs
						.getString("referenciaCliente"));
			}

			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para buscar cliente");
			System.out.println(e.getMessage());
		}
		return miCliente;
	}

	public DefaultTableModel llenaTablaClientes() {

		DefaultTableModel modeloTablaClientes;
		modeloTablaClientes = new DefaultTableModel(null, getColumnas());
		return setFilas(modeloTablaClientes);

	}// Fin llenaTablaClientes

	private DefaultTableModel setFilas(DefaultTableModel modeloTablaClientes) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		Object datos[] = new Object[5];

		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call listar_clientes}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {

				for (int i = 0; i < 5; i++) {
					datos[i] = miRs.getObject(i + 1);

				}
				modeloTablaClientes.addRow(datos);

			}
			miRs.close();
			conexion.close();
		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para listar clientes");
			System.out.println(e.getMessage());
		}
		return modeloTablaClientes;

	}// Fin setFilas

	private String[] getColumnas() {

		String encabezados[] = {"ID", "Código", "Nombre", "Empresa", "Referencia" };
		return encabezados;
	}// Fin getColumnas

	public String recuperarCodigoCliente() {

		String codigoCliente = "";
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call generar_codigo_cliente(?)}");
			miProcedimiento.registerOutParameter(1, Types.VARCHAR);
			miProcedimiento.executeQuery();
			codigoCliente = miProcedimiento.getString(1);
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para generar codigo de cliente");
			System.out.println(e.getMessage());
		}

		return codigoCliente;

	}// Fin recuperarCodigoCliente
}
