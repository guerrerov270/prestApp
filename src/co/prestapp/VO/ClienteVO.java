package co.prestapp.VO;

public class ClienteVO {

	private int codigoCliente;
	private String nombreCliente;
	private String direccionCliente;
	private String empresaCliente;
	private String telefonoCliente;
	private String referenciaCliente;

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getEmpresaCliente() {
		return empresaCliente;
	}

	public void setEmpresaCliente(String empresaCliente) {
		this.empresaCliente = empresaCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getReferenciaCliente() {
		return referenciaCliente;
	}

	public void setReferenciaCliente(String referenciaCliente) {
		this.referenciaCliente = referenciaCliente;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int i) {
		this.codigoCliente = i;
	}

}
