package dominio;

public class TipoSeguro {
	private int idTipo;
	private String Descripcion;

	public TipoSeguro() {
	}

	public TipoSeguro(int idTipo, String Descripcion) {
		this.idTipo = idTipo;
		this.Descripcion = Descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String toString() {
		return "TipoSeguro [idTipo=" + idTipo + ", Descripcion=" + Descripcion + "]";
	}

}
