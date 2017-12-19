package co.prestapp.VO;

import java.sql.Date;

public class AbonoVO {

	private double montoAbono;
	private Date fechaAbono;
	private int abonoPrestamo;
	private boolean completoAbono;
	private boolean puntualAbono;

	private enum estadoAbono {
		PENDIENTE, PAGADO
	}

	public double getMontoAbono() {
		return montoAbono;
	}

	public void setMontoAbono(double montoAbono) {
		this.montoAbono = montoAbono;
	}

	public Date getFechaAbono() {
		return fechaAbono;
	}

	public void setFechaAbono(Date fechaAbono) {
		this.fechaAbono = fechaAbono;
	}

	public int getAbonoPrestamo() {
		return abonoPrestamo;
	}

	public void setAbonoPrestamo(int abonoPrestamo) {
		this.abonoPrestamo = abonoPrestamo;
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
	};

}
