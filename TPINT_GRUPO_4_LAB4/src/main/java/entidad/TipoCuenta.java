package entidad;

public class TipoCuenta {
	private int id_tipoCuenta;
	private String descripcion_tipoCuenta;
    		
	public TipoCuenta(){}

	public TipoCuenta(int id_tipoCuenta, String descripcion_tipoCuenta) {
		this.id_tipoCuenta = id_tipoCuenta;
		this.descripcion_tipoCuenta = descripcion_tipoCuenta;
	}

	public int getId_tipoCuenta() {
		return id_tipoCuenta;
	}

	public void setId_tipoCuenta(int id_tipoCuenta) {
		this.id_tipoCuenta = id_tipoCuenta;
	}

	public String getDescripcion_tipoCuenta() {
		return descripcion_tipoCuenta;
	}

	public void setDescripcion_tipoCuenta(String descripcion_tipoCuenta) {
		this.descripcion_tipoCuenta = descripcion_tipoCuenta;
	}

	@Override
	public String toString() {
		return "tipo_cuenta [id_tipoCuenta=" + id_tipoCuenta + ", descripcion_tipoCuenta=" + descripcion_tipoCuenta
				+ "]";
	}

}
