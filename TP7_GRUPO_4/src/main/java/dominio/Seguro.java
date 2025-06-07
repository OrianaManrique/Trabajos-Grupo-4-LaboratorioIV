package dominio;

public class Seguro {

	private int id;
	private String descripcion;
	private int idTipo;
	private float costoContratacion;
	private float costoAsegurado;
	
	// Constructores
	public Seguro() {}	
	
	public Seguro(int id, String descripcion, int idTipo, float costoContractacion, float costoAsegurado) {
		this.id = id;
		this.descripcion = descripcion;
		this.idTipo = idTipo;
		this.costoContratacion = costoContractacion;
		this.costoAsegurado = costoAsegurado;
	}
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public float getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public float getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
	
	
	
	
}
