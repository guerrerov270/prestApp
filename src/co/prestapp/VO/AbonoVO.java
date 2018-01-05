package co.prestapp.VO;

import java.sql.Date;

public class AbonoVO {

	private int IDAbono;
	private String codigoAbono;
	private double montoACobrar;
	private double montoPagado;
	private String completoAbono; // SI, NO
	private String fechaACobrar;
	private Date fechaPago;
	private String abonoPrestamoFK;
	private String puntualAbono; // SI, NO
	private String estadoAbono; // PENDIENTE, PAGADO, ERROR
	private int numeroAbono;

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getAbonoPrestamo() {
		return abonoPrestamoFK;
	}

	public void setAbonoPrestamo(String abonoPrestamo) {
		this.abonoPrestamoFK = abonoPrestamo;
	}

	public int getIDAbono() {
		return IDAbono;
	}

	public void setIDAbono(int iDAbono) {
		IDAbono = iDAbono;
	}

	public String getCodigoAbono() {
		return codigoAbono;
	}

	public void setCodigoAbono(String codigoAbono) {
		this.codigoAbono = codigoAbono;
	}

	public String getFechaACobrar() {
		return fechaACobrar;
	}

	public void setFechaACobrar(String fechaACobrar) {
		this.fechaACobrar = fechaACobrar;
	}

	public int getNumeroAbono() {
		return numeroAbono;
	}

	public void setNumeroAbono(int numeroAbono) {
		this.numeroAbono = numeroAbono;
	}

	public double getMontoACobrar() {
		return montoACobrar;
	}

	public void setMontoACobrar(double montoACobrar) {
		this.montoACobrar = montoACobrar;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public String getCompletoAbono() {
		return completoAbono;
	}

	public void setCompletoAbono(String completoAbono) {
		this.completoAbono = completoAbono;
	}

	public String getPuntualAbono() {
		return puntualAbono;
	}

	public void setPuntualAbono(String puntualAbono) {
		this.puntualAbono = puntualAbono;
	}

	public String getEstadoAbono() {
		return estadoAbono;
	}

	public void setEstadoAbono(String estadoAbono) {
		this.estadoAbono = estadoAbono;
	};

}
