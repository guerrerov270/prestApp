package co.prestapp.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import co.prestapp.VO.ClienteVO;
import co.prestapp.connection.DBConnection;

public class ClienteDAO {

	public void agregarCliente(String nombre,
			String direccion, String empresa, String telefono, String referencia) {

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call agregar_cliente(?,?,?,?,?)}");
			miProcedimiento.setString(1, nombre);
			miProcedimiento.setString(2, direccion);
			miProcedimiento.setString(3, empresa);
			miProcedimiento.setString(4, telefono);
			miProcedimiento.setString(5, referencia);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para agregar cliente");
			System.out.println(e.getMessage());
		}

	}//Fin agregar cliente
	
	public DefaultTableModel llenaTablaClientes(){
		
		DefaultTableModel modeloTablaClientes;
		modeloTablaClientes= new DefaultTableModel(null,getColumnas());
		return setFilas(modeloTablaClientes);
	
	}// Fin llenaTablaClientes

	private DefaultTableModel setFilas(DefaultTableModel modeloTablaClientes) {
		
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		Object datos[]= new Object[6];
		
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call listar_clientes}");
			ResultSet miRs = miProcedimiento.executeQuery();

			while (miRs.next()) {
				
				for (int i = 0; i < 6; i++) {
					datos[i] = miRs.getObject(i+1);
					
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
		
		String encabezados[] = { "Código", "Nombre",
				"Dirección", "Empresa", "Telefono",
				"Referencia" };
		return encabezados;
	}// Fin getColumnas

	public void eliminarCliente(int idCliente){
		
		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		try {
			CallableStatement miProcedimiento = conexion
					.prepareCall("{call eliminar_cliente(?)}");
			miProcedimiento.setInt(1, idCliente);
			miProcedimiento.execute();
			conexion.close();

		} catch (SQLException e) {
			System.out
					.println("Error al ejecutar consulta para eliminar cliente");
			System.out.println(e.getMessage());
		}
	}
}
