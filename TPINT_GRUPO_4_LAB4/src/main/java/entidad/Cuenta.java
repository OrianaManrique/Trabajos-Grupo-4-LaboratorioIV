package entidad;

import java.sql.Date;

public class Cuenta {

	private String nroCuenta_cuenta;
	private int dni_Cliente;
	private Date fecha_creacion_cuenta;
	private String cbu_cuenta;
	private Tipo_Cuenta tipo_cuenta;
	private double saldo_cuenta;
	private int estado_cuenta;
	
	public Cuenta() {}

	public Cuenta(String nroCuenta_cuenta, int dni_Cliente, Date fecha_creacion_cuenta, String cbu_cuenta,
			Tipo_Cuenta tipo_cuenta, double saldo_cuenta) {
		this.nroCuenta_cuenta = nroCuenta_cuenta;
		this.dni_Cliente = dni_Cliente;
		this.fecha_creacion_cuenta = fecha_creacion_cuenta;
		this.cbu_cuenta = cbu_cuenta;
		this.tipo_cuenta = tipo_cuenta;
		this.saldo_cuenta = saldo_cuenta;
		this.estado_cuenta = 1;
	}

	public String getNroCuenta_cuenta() {
		return nroCuenta_cuenta;
	}

	public void setNroCuenta_cuenta(String nroCuenta_cuenta) {
		this.nroCuenta_cuenta = nroCuenta_cuenta;
	}

	public int getDni_Cliente() {
		return dni_Cliente;
	}

	public void setDni_Cliente(int dni_Cliente) {
		this.dni_Cliente = dni_Cliente;
	}

	public Date getFecha_creacion_cuenta() {
		return fecha_creacion_cuenta;
	}

	public void setFecha_creacion_cuenta(Date fecha_creacion_cuenta) {
		this.fecha_creacion_cuenta = fecha_creacion_cuenta;
	}

	public String getCbu_cuenta() {
		return cbu_cuenta;
	}

	public void setCbu_cuenta(String cbu_cuenta) {
		this.cbu_cuenta = cbu_cuenta;
	}

	public Tipo_Cuenta getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(Tipo_Cuenta tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public double getSaldo_cuenta() {
		return saldo_cuenta;
	}

	public void setSaldo_cuenta(double saldo_cuenta) {
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
		return "cuenta [nroCuenta_cuenta=" + nroCuenta_cuenta + ", dni_Cliente=" + dni_Cliente
				+ ", fecha_creacion_cuenta=" + fecha_creacion_cuenta + ", cbu_cuenta=" + cbu_cuenta + ", tipo_cuenta="
				+ tipo_cuenta + ", saldo_cuenta=" + saldo_cuenta + ", estado_cuenta=" + estado_cuenta + "]";
	}

}
