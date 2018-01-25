package co.prestapp.VO;

public class ClienteVO {

	private int IDCliente;
	private String codigoCliente;
	private String nombreCliente;
	private String empresaCliente; // SIN CATEGORIA, SEMANAL, IMPULSO, SUPERMERCADO, COMUN, VENDEDORES, DON POLLO,
									// DROGUERIA, LA LOCURA, MR POMPY, COMUNICACIONES, MOCAWA, HOGAR INFANTIL, OTRO
	private String referenciaCliente;
	private String estadoCliente; // RECOMENDADO, NO RECOMENDADO, ERROR

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getEmpresaCliente() {
		return empresaCliente;
	}

	public void setEmpresaCliente(String empresaCliente) {
		this.empresaCliente = empresaCliente;
	}

	public String getReferenciaCliente() {
		return referenciaCliente;
	}

	public void setReferenciaCliente(String referenciaCliente) {
		this.referenciaCliente = referenciaCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigo) {
		this.codigoCliente = codigo;
	}

	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

}
