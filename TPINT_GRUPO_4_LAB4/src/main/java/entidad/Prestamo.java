package entidad;

import java.sql.Date;

public class Prestamo {
    
	private int id_prestamo;
	private Cliente dniCliente_prestamo;
	private Cuenta nroCuenta_prestamo;
	private float importeApagar_prestamo;
	private float importeSolicitado_prestamo;
	private int plazoDePago_prestamo;
	private int cuotas_prestamo;
	private Date fechaCreacion_prestamo;
	private float montoMensual_prestamo;
	private String condicion_prestamo;
	private int estado_prestamo;	
		
	public Prestamo() {};
	
	public Prestamo(int id, Cliente dniCliente, Cuenta nroCuenta,float importeApagar, 
			float importeSolicitado, int plazoDePago, int cuotas, Date fechaCreacion, 
			float montoMensual, String condicion, int estado) {
		
		this.id_prestamo = id;
		this.dniCliente_prestamo = dniCliente;
		this.nroCuenta_prestamo = nroCuenta;
		this.importeApagar_prestamo = importeApagar;
		this.importeSolicitado_prestamo = importeSolicitado;
		this.plazoDePago_prestamo = plazoDePago;
		this.cuotas_prestamo = cuotas;
		this.fechaCreacion_prestamo = fechaCreacion;
		this.montoMensual_prestamo = montoMensual;
		this.condicion_prestamo = condicion;
		this.estado_prestamo = estado;
	}
	
	public void setDniCliente_prestamo(Cliente dniCliente_prestamo) {
		this.dniCliente_prestamo = dniCliente_prestamo;
	}

	public int getId_prestamo() {
		return id_prestamo;
	}
	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}
	public Cliente getDniCliente_prestamo() {
		return dniCliente_prestamo;
	}	
	public Cuenta getNroCuenta_prestamo() {
		return nroCuenta_prestamo;
	}
	public void setNroCuenta_prestamo(Cuenta nroCuenta_prestamo) {
		this.nroCuenta_prestamo = nroCuenta_prestamo;
	}
	public float getImporteApagar_prestamo() {
		return importeApagar_prestamo;
	}
	public void setImporteApagar_prestamo(float importeApagar_prestamo) {
		this.importeApagar_prestamo = importeApagar_prestamo;
	}
	public float getImporteSolicitado_prestamo() {
		return importeSolicitado_prestamo;
	}
	public void setImporteSolicitado_prestamo(float importeSolicitado_prestamo) {
		this.importeSolicitado_prestamo = importeSolicitado_prestamo;
	}
	public int getPlazoDePago_prestamo() {
		return plazoDePago_prestamo;
	}
	public void setPlazoDePago_prestamo(int plazoDePago_prestamo) {
		this.plazoDePago_prestamo = plazoDePago_prestamo;
	}
	public int getCuotas_prestamo() {
		return cuotas_prestamo;
	}
	public void setCuotas_prestamo(int cuotas_prestamo) {
		this.cuotas_prestamo = cuotas_prestamo;
	}
	public Date getFechaCreacion_prestamo() {
		return fechaCreacion_prestamo;
	}
	public void setFechaCreacion_prestamo(Date fechaCreacion_prestamo) {
		this.fechaCreacion_prestamo = fechaCreacion_prestamo;
	}
	public float getMontoMensual_prestamo() {
		return montoMensual_prestamo;
	}
	public void setMontoMensual_prestamo(float montoMensual_prestamo) {
		this.montoMensual_prestamo = montoMensual_prestamo;
	}
	public String getCondicion_prestamo() {
		return condicion_prestamo;
	}
	public void setCondicion_prestamo(String condicion_prestamo) {
		this.condicion_prestamo = condicion_prestamo;
	}
	public int getEstado_prestamo() {
		return estado_prestamo;
	}
	public void setEstado_prestamo(int estado_prestamo) {
		this.estado_prestamo = estado_prestamo;
	}
			
}
