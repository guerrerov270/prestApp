package co.prestapp.VO;

import java.sql.Date;

public class PrestamoVO {

	private int idPrestamo;
	private String codigoPrestamo;
	private double montoPrestamo;
	private int tasaInteresPrestamo;
	private int numeroCuotasPrestamo;
	private double saldoPendienteprestamo;
	private double saldoPagadoPrestamo;
	private String fechaInicioPrestamo;
	private String fechafinPrestamo;
	private String tipoPlazoPrestamo; // MENSUAL, QUINCENAL, SEMANAL, OTRO
	private String codigoClienteFK;
	private String estadoPrestamo; // PENDIENTE, PAGADO, REFINANCIADO, ERROR
		


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

	public String getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}

	public void setFechaInicioPrestamo(String fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}

	public String getFechafinPrestamo() {
		return fechafinPrestamo;
	}

	public void setFechafinPrestamo(String fechafinPrestamo) {
		this.fechafinPrestamo = fechafinPrestamo;
	}

	public String getIcodigoClienteFK() {
		return codigoClienteFK;
	}

	public void setcodigoClienteFK(String codigoClienteFK) {
		this.codigoClienteFK = codigoClienteFK;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public String getCodigoPrestamo() {
		return codigoPrestamo;
	}

	public void setCodigoPrestamo(String codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}

	public int getNumeroCuotasPrestamo() {
		return numeroCuotasPrestamo;
	}

	public void setNumeroCuotasPrestamo(int numeroCuotasPrestamo) {
		this.numeroCuotasPrestamo = numeroCuotasPrestamo;
	}

	public String getTipoPlazoPrestamo() {
		return tipoPlazoPrestamo;
	}

	public void setTipoPlazoPrestamo(String tipoPlazoPrestamo) {
		this.tipoPlazoPrestamo = tipoPlazoPrestamo;
	}

	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}

	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	};

}
