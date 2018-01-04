package co.prestapp.VO;

import java.sql.Date;

public class AbonoVO {

	private int IDAbono;
	private String codigoAbono;
	private double montoAbono;
	private boolean completoAbono;
	private Date fechaACobrar;
	private Date fechaPago;
	private String abonoPrestamoFK;
	private boolean puntualAbono;

	private enum estadoAbono {
		PENDIENTE, PAGADO, ERROR
	}

	private int numeroAbono;

	public double getMontoAbono() {
		return montoAbono;
	}

	public void setMontoAbono(double montoAbono) {
		this.montoAbono = montoAbono;
	}

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

	public boolean isCompletoAbono() {
		return completoAbono;
	}

	public void setCompletoAbono(boolean completoAbono) {
		this.completoAbono = completoAbono;
	}

	public boolean isPuntualAbono() {
		return puntualAbono;
	}

	public void setPuntualAbono(boolean puntualAbono) {
		this.puntualAbono = puntualAbono;
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

	public Date getFechaACobrar() {
		return fechaACobrar;
	}

	public void setFechaACobrar(Date fechaACobrar) {
		this.fechaACobrar = fechaACobrar;
	}

	public int getNumeroAbono() {
		return numeroAbono;
	}

	public void setNumeroAbono(int numeroAbono) {
		this.numeroAbono = numeroAbono;
	};

}
