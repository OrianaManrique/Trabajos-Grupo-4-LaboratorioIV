package entidad;

public class Tipo_Movimientos {

	private int id_tipomovimiento;
	private String descripcion_tipomovimiento;
	
	
	public Tipo_Movimientos() {}
	
	public Tipo_Movimientos(int id, String descripcion) {

		id_tipomovimiento = id;
		descripcion_tipomovimiento = descripcion;
	}


	public int getId_tipomovimiento() {
		return id_tipomovimiento;
	}


	public void setId_tipomovimiento(int id_tipomovimiento) {
		this.id_tipomovimiento = id_tipomovimiento;
	}


	public String getDescripcion_tipomovimiento() {
		return descripcion_tipomovimiento;
	}


	public void setDescripcion_tipomovimiento(String descripcion_tipomovimiento) {
		this.descripcion_tipomovimiento = descripcion_tipomovimiento;
	}


	@Override
	public String toString() {
		return "Tipo_Movimientos [id_tipomovimiento=" + id_tipomovimiento + ", descripcion_tipomovimiento="
				+ descripcion_tipomovimiento + "]";
	}
	

}
