package entidad;

import java.sql.Date;

public class Transferencia {
   
	private int id_transferencia;
	private Cuenta cbuEmisor_transferencia;
	private Cuenta cbuReceptor_transferencia;
	private float monto_transferencia;
	private Date fecha_transferencia;
	private String motivo;
	
	public Transferencia() {}
		
	public Transferencia(int id, Cuenta cbu_emisor, Cuenta cbu_receptor,
			float monto_transferencia, Date fecha, String motivo) {

		this.id_transferencia = id;
		this.cbuEmisor_transferencia = cbu_emisor;
		this.cbuReceptor_transferencia = cbu_receptor;
		this.monto_transferencia = monto_transferencia;
		this.fecha_transferencia = fecha;
		this.motivo = motivo;
	}
	
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public int getId_transferencia() {
		return id_transferencia;
	}
	public void setId_transferencia(int id_transferencia) {
		this.id_transferencia = id_transferencia;
	}
	
	public Cuenta getCbuEmisor_transferencia() {
		return cbuEmisor_transferencia;
	}

	public void setCbuEmisor_transferencia(Cuenta cbuEmisor_transferencia) {
		this.cbuEmisor_transferencia = cbuEmisor_transferencia;
	}

	public Cuenta getCbuReceptor_transferencia() {
		return cbuReceptor_transferencia;
	}

	public void setCbuReceptor_transferencia(Cuenta cbuReceptor_transferencia) {
		this.cbuReceptor_transferencia = cbuReceptor_transferencia;
	}

	public Cuenta getCbu_emisor_transferencia() {
		return cbuEmisor_transferencia;
	}
	public Cuenta getCbu_receptor_transferencia() {
		return cbuReceptor_transferencia;
	}
	public float getMonto_transferencia() {
		return monto_transferencia;
	}
	public void setMonto_transferencia(float monto_transferencia) {
		this.monto_transferencia = monto_transferencia;
	}
	public Date getFecha_transferencia() {
		return fecha_transferencia;
	}
	public void setFecha_transferencia(Date fecha_transferencia) {
		this.fecha_transferencia = fecha_transferencia;
	}

	@Override
	public String toString() {
		return "Transferencia [id_transferencia=" + id_transferencia + ", cbuEmisor_transferencia="
				+ cbuEmisor_transferencia + ", cbuReceptor_transferencia=" + cbuReceptor_transferencia
				+ ", monto_transferencia=" + monto_transferencia + ", fecha_transferencia=" + fecha_transferencia
				+ ", motivo=" + motivo + "]";
	}
	
}
