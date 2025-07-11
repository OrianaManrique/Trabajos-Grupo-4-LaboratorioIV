package entidad;

import java.sql.Date;

public class Cuota {
	
	private int id_Cuota;
	private Prestamo idprestamo_cuota;
	private float monto_cuota;
	private Date fechaPago_cuota;
	
	public Cuota(){}
			
	public Cuota(int id_Cuota, int idprestamo_cuota, float monto_cuota, Date fechaPago_cuota) {
		super();
		this.id_Cuota = id_Cuota;
		this.idprestamo_cuota.setId_prestamo(idprestamo_cuota);
		this.monto_cuota = monto_cuota;
		this.fechaPago_cuota = fechaPago_cuota;
	}
	
	public int getId_Cuota() {
		return id_Cuota;
	}
	public void setId_Cuota(int id_Cuota) {
		this.id_Cuota = id_Cuota;
	}
	public Prestamo getIdprestamo_cuota() {
		return idprestamo_cuota;
	}
	public float getMonto_cuota() {
		return monto_cuota;
	}
	public void setMonto_cuota(float monto_cuota) {
		this.monto_cuota = monto_cuota;
	}
	public Date getFechaPago_cuota() {
		return fechaPago_cuota;
	}
	public void setFechaPago_cuota(Date fechaPago_cuota) {
		this.fechaPago_cuota = fechaPago_cuota;
	}

	@Override
	public String toString() {
		return "CuotasPrestamo [id_Cuota=" + id_Cuota + ", idprestamo_cuota=" + idprestamo_cuota + ", monto_cuota="
				+ monto_cuota + ", fechaPago_cuota=" + fechaPago_cuota + "]";
	}

}
