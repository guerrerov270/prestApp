package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.prestapp.VO.ClienteVO;
import co.prestapp.connection.DBConnection;

public class ClienteDAO {

	public ArrayList<ClienteVO> listarClientes() {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		ArrayList<ClienteVO> listaClientes = new ArrayList<ClienteVO>();
		ClienteVO cliente;
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call listar_clientes}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {
				cliente = new ClienteVO();
				cliente.setCodigoCliente(miRs.getString("idCliente"));
				cliente.setNombreCliente(miRs.getString("nombreCliente"));
				cliente.setDireccionCliente(miRs.getString("direccionCliente"));
				cliente.setEmpresaCliente(miRs.getString("empresaCliente"));
				cliente.setTelefonoCliente(miRs.getString("telefonoCliente"));
				cliente.setReferenciaCliente(miRs
						.getString("referenciaCliente"));
				listaClientes.add(cliente);

			}
			miRs.close();
			conexion.close();
		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para listar clientes");
			System.out.println(e.getMessage());
		}
		return listaClientes;

	}

	public void agregarCliente(int codigoCliente, String nombre,
			String direccion, String empresa, String telefono, String referencia) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call agregar_cliente(?,?,?,?,?,?)}");
			miProcedimiento.setInt(1, codigoCliente);
			miProcedimiento.setString(2, nombre);
			miProcedimiento.setString(3, direccion);
			miProcedimiento.setString(4, empresa);
			miProcedimiento.setString(5, telefono);
			miProcedimiento.setString(6, referencia);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para agregar cliente");
			System.out.println(e.getMessage());
		}

	}

}
