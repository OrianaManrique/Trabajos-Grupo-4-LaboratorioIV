package entidad;

import java.sql.Date;

public class Cuenta {

	private int nroCuenta_cuenta;
	private int dni_Cliente;
	private Date fechaCreacion_cuenta;
	private int cbu_cuenta;
	private TipoCuenta tipoCuenta_cuenta;
	private Float saldo_cuenta;
	private int estado_cuenta;
	
	public Cuenta() {}

	public Cuenta(int nroCuenta_cuenta, int dni_Cliente, Date fecha_creacion_cuenta, int cbu_cuenta,
			TipoCuenta tipo_cuenta, Float saldo_cuenta) {
		this.nroCuenta_cuenta = nroCuenta_cuenta;
		this.dni_Cliente = dni_Cliente;
		this.fechaCreacion_cuenta = fecha_creacion_cuenta;
		this.cbu_cuenta = cbu_cuenta;
		this.tipoCuenta_cuenta = tipo_cuenta;
		this.saldo_cuenta = saldo_cuenta;
		this.estado_cuenta = 1;
	}

	public int getNroCuenta_cuenta() {
		return nroCuenta_cuenta;
	}

	public void setNroCuenta_cuenta(int nroCuenta_cuenta) {
		this.nroCuenta_cuenta = nroCuenta_cuenta;
	}

	public int getDni_Cliente() {
		return dni_Cliente;
	}

	public void setDni_Cliente(int dni_Cliente) {
		this.dni_Cliente = dni_Cliente;
	}

	public Date getFechaCreacion_cuenta() {
		return fechaCreacion_cuenta;
	}

	public void setFechaCreacion_cuenta(Date fechaCreacion_cuenta) {
		this.fechaCreacion_cuenta = fechaCreacion_cuenta;
	}

	public int getCbu_cuenta() {
		return cbu_cuenta;
	}

	public void setCbu_cuenta(int cbu_cuenta) {
		this.cbu_cuenta = cbu_cuenta;
	}

	public TipoCuenta getTipo_cuenta() {
		return tipoCuenta_cuenta;
	}

	public void setTipo_cuenta(TipoCuenta tipo_cuenta) {
		this.tipoCuenta_cuenta = tipo_cuenta;
	}

	public double getSaldo_cuenta() {
		return saldo_cuenta;
	}

	public void setSaldo_cuenta(Float saldo_cuenta) {
		this.saldo_cuenta = saldo_cuenta;
	}

	public int getEstado_cuenta() {
		return estado_cuenta;
	}

	public void setEstado_cuenta(int estado_cuenta) {
		this.estado_cuenta = estado_cuenta;
	}

	@Override
	public String toString() {
		return "Cuenta [nroCuenta_cuenta=" + nroCuenta_cuenta + ", dni_Cliente=" + dni_Cliente
				+ ", fechaCreacion_cuenta=" + fechaCreacion_cuenta + ", cbu_cuenta=" + cbu_cuenta
				+ ", tipoCuenta_cuenta=" + tipoCuenta_cuenta + ", saldo_cuenta=" + saldo_cuenta + ", estado_cuenta="
				+ estado_cuenta + "]";
	}

	

}
