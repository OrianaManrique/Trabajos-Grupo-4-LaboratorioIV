package entidad;

public class localidad {
   
	private int id_localidad;
	private String descripcion_localidad;
	provincia id_provincia;
	
	public localidad(){
				
	}
	
	public localidad(String Descripcion_localidad){
		this.descripcion_localidad = Descripcion_localidad;
	}

	public int getId_localidad() {
		return id_localidad;
	}

	public void setId_localidad(int id_localidad) {
		this.id_localidad = id_localidad;
	}

	public String getDescripcion_localidad() {
		return descripcion_localidad;
	}

	public void setDescripcion_localidad(String descripcion_localidad) {
		this.descripcion_localidad = descripcion_localidad;
	}

	public provincia getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(provincia id_provincia) {
		this.id_provincia = id_provincia;
	}

	@Override
	public String toString() {
		return "localidad [id_localidad=" + id_localidad + ", descripcion_localidad=" + descripcion_localidad
				+ ", id_provincia=" + id_provincia + "]";
	}
	
}
