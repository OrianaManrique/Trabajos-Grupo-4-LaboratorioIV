package entidad;

import java.sql.Date;

public class Movimiento {
    
	private int id_movimiento;
	private int nroCuenta_movimiento;
	private Date fecha_movimiento;
	private String detalle_movimiento;
	private float importe_movimiento;
	private TipoMovimiento id_tipoMovimiento;
	
	public Movimiento(int id_movimiento, int nroCuenta_movimiento, Date fecha_movimiento, String detalle_movimiento,
			float importe_movimiento, int id_tipoMovimiento) {
		super();
		this.id_movimiento = id_movimiento;
		this.nroCuenta_movimiento = nroCuenta_movimiento;
		this.fecha_movimiento = fecha_movimiento;
		this.detalle_movimiento = detalle_movimiento;
		this.importe_movimiento = importe_movimiento;
		this.id_tipoMovimiento.setId_tipomovimiento(id_tipoMovimiento);
	}
	
	public int getId_movimiento() {
		return id_movimiento;
	}
	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}
	public int getNroCuenta_movimiento() {
		return nroCuenta_movimiento;
	}
	public void setNroCuenta_movimiento(int nroCuenta_movimiento) {
		this.nroCuenta_movimiento = nroCuenta_movimiento;
	}
	public Date getFecha_movimiento() {
		return fecha_movimiento;
	}
	public void setFecha_movimiento(Date fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}
	public String getDetalle_movimiento() {
		return detalle_movimiento;
	}
	public void setDetalle_movimiento(String detalle_movimiento) {
		this.detalle_movimiento = detalle_movimiento;
	}
	public float getImporte_movimiento() {
		return importe_movimiento;
	}
	public void setImporte_movimiento(float importe_movimiento) {
		this.importe_movimiento = importe_movimiento;
	}
	public TipoMovimiento getId_tipoMovimiento() {
		return id_tipoMovimiento;
	}

	@Override
	public String toString() {
		return "Movimiento [id_movimiento=" + id_movimiento + ", nroCuenta_movimiento=" + nroCuenta_movimiento
				+ ", fecha_movimiento=" + fecha_movimiento + ", detalle_movimiento=" + detalle_movimiento
				+ ", importe_movimiento=" + importe_movimiento + ", id_tipoMovimiento=" + id_tipoMovimiento + "]";
	}
		
}
