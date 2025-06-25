package entidad;

public class Provincia {
	
	private int id_provincia;
	private String descripcion_provincia;
	
	public Provincia(){
		
	} 
	
    public Provincia(String Descripcion_provincia){
		this.descripcion_provincia = Descripcion_provincia;
	} 
			
	public int getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}
	public String getDescripcion_provincia() {
		return descripcion_provincia;
	}
	public void setDescripcion_provincia(String descripcion_provincia) {
		this.descripcion_provincia = descripcion_provincia;		
	}
	
	@Override
	public String toString() {
		return "provincia [id_provincia=" + id_provincia + ", descripcion_provincia=" + descripcion_provincia + "]";
	}
	
}
