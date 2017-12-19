package co.prestapp.controlador;

import co.prestapp.DAO.ClienteDAO;

public class ControlaDialogo {
	
	ControlaVentanaPrincipal controladorVentana;
	ClienteDAO miClienteDAO;

	public void guardarCliente(int codigoCliente, String nombre, String direccion, String empresa,
			String telefono, String referencia) {

		miClienteDAO = new ClienteDAO();
		miClienteDAO.agregarCliente(codigoCliente,nombre, direccion, empresa, telefono,
				referencia);
		controladorVentana= new ControlaVentanaPrincipal();
		controladorVentana.completarDatosClienteNuevo(codigoCliente, nombre);

	}

}
