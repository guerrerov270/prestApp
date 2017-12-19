package co.prestapp.controlador;

import co.prestapp.vista.VentanaPrincipal;

public class ControlaVentanaPrincipal {
	
	VentanaPrincipal ventana= new VentanaPrincipal();

	public void completarDatosClienteNuevo(int codigo, String nombre){
		
		ventana.jLabelNombreCliente.setText(nombre);
		ventana.jLabelCodigo.setText(codigo + "");
		
	}
	
	
}
