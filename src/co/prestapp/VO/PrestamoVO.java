package co.prestapp.VO;

import java.sql.Date;

public class PrestamoVO {

	private double montoPrestamo;
	private int tasaInteresPrestamo;
	private double saldoPendienteprestamo;
	private double saldoPagadoPrestamo;
	private Date fechaInicioPrestamo;
	private Date fechafinPrestamo;

	private enum tipoPlazoPrestamo {
		MENSUAL, QUINCENAL, SEMANAL, OTRO
	};

	private int idCliente;

	private enum estadoPrestamo {
		PENDIENTE, PAGADO, REFINANCIADO
	}

	public double getMontoPrestamo() {
		return montoPrestamo;
	}

	public void setMontoPrestamo(double montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}

	public int getTasaInteresPrestamo() {
		return tasaInteresPrestamo;
	}

	public void setTasaInteresPrestamo(int tasaInteresPrestamo) {
		this.tasaInteresPrestamo = tasaInteresPrestamo;
	}

	public double getSaldoPendienteprestamo() {
		return saldoPendienteprestamo;
	}

	public void setSaldoPendienteprestamo(double saldoPendienteprestamo) {
		this.saldoPendienteprestamo = saldoPendienteprestamo;
	}

	public double getSaldoPagadoPrestamo() {
		return saldoPagadoPrestamo;
	}

	public void setSaldoPagadoPrestamo(double saldoPagadoPrestamo) {
		this.saldoPagadoPrestamo = saldoPagadoPrestamo;
	}

	public Date getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}

	public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}

	public Date getFechafinPrestamo() {
		return fechafinPrestamo;
	}

	public void setFechafinPrestamo(Date fechafinPrestamo) {
		this.fechafinPrestamo = fechafinPrestamo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	};

}
