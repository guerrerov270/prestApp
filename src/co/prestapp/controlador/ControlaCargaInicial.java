package co.prestapp.controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import co.prestapp.DAO.ClienteDAO;
import co.prestapp.VO.ClienteVO;
import co.prestapp.vista.VentanaPrincipal;

public class ControlaCargaInicial extends WindowAdapter{
	
	ClienteDAO miClienteDAO= new ClienteDAO();
	private VentanaPrincipal ventana;
	
	public ControlaCargaInicial(VentanaPrincipal ventana) {
		
		this.ventana=ventana;
		
	}
	
	public void windowOpened(WindowEvent e){
		
		
		
	}
	
	public String [][] cargarClientes(){
		
		ArrayList<ClienteVO> listaClientes= miClienteDAO.listarClientes();
		String informacion[][]= new String[listaClientes.size()][6];
		
		for (int i = 0; i < listaClientes.size(); i++) {
			informacion[i][0]=listaClientes.get(i).getCodigoCliente()+"";
			informacion[i][1]=listaClientes.get(i).getNombreCliente()+"";
			informacion[i][2]=listaClientes.get(i).getDireccionCliente()+"";
			informacion[i][3]=listaClientes.get(i).getEmpresaCliente()+"";
			informacion[i][4]=listaClientes.get(i).getTelefonoCliente()+"";
			informacion[i][5]=listaClientes.get(i).getReferenciaCliente()+"";			
		}
		return informacion;
		
	}

}
