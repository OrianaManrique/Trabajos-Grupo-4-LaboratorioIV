package entidad;
import java.sql.Date;

public class Cliente {
	
	private int dni_cliente;
	private int Cuil_cliente;  
	private String nombre_cliente;
	private String apellido_cliente;
	private String sexo_cliente;
	private String nacionalidad_cliente;
	private Date fecha_nacimiento_cliente;
	private String Direccion_cliente;
	private Localidad localidad;
	private Provincia provincia;
	private String correo_electronico_cliente;
	private String telefono_cliente;
	private String usuario_cliente;
	private String contraseña_cliente;
	private int estado;
	
	public Cliente(){
				
	}
	
	public Cliente(int dni, int cuil_cliente, String nombre_cliente, String apellido_cliente,
			String sexo_cliente, String nacionalidad_cliente, Date fecha_nacimiento_cliente, String direccion_cliente,
			Provincia provincia, Localidad localidad, String correo_electronico_cliente, String telefono_cliente) {

		dni_cliente = dni;
		this.Cuil_cliente = cuil_cliente;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.sexo_cliente = sexo_cliente;
		this.nacionalidad_cliente = nacionalidad_cliente;
		this.fecha_nacimiento_cliente = fecha_nacimiento_cliente;
		this.Direccion_cliente = direccion_cliente;
		this.provincia = provincia;
		this.localidad = localidad;
		this.correo_electronico_cliente = correo_electronico_cliente;
		this.telefono_cliente = telefono_cliente;
		this.usuario_cliente = "";
		this.contraseña_cliente = "";
		this.estado = 1;
	}

	public int getDni_cliente() {
		return dni_cliente;
	}

	public void setDni_cliente(int dni_cliente) {
		this.dni_cliente = dni_cliente;
	}

	public int getCuil_cliente() {
		return Cuil_cliente;
	}

	public void setCuil_cliente(int cuil_cliente) {
		Cuil_cliente = cuil_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getSexo_cliente() {
		return sexo_cliente;
	}

	public void setSexo_cliente(String sexo_cliente) {
		this.sexo_cliente = sexo_cliente;
	}

	public String getNacionalidad_cliente() {
		return nacionalidad_cliente;
	}

	public void setNacionalidad_cliente(String nacionalidad_cliente) {
		this.nacionalidad_cliente = nacionalidad_cliente;
	}

	public Date getFecha_nacimiento_cliente() {
		return fecha_nacimiento_cliente;
	}

	public void setFecha_nacimiento_cliente(Date fecha_nacimiento_cliente) {
		this.fecha_nacimiento_cliente = fecha_nacimiento_cliente;
	}

	public String getDireccion_cliente() {
		return Direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		Direccion_cliente = direccion_cliente;
	}

    public Localidad getLocalidad() {   	
    	return localidad;  	
    }
    
    public void setLocalidad(Localidad localidad) { 
    	this.localidad = localidad; 
    }

    public Provincia getProvincia() { 
    	return provincia; 
    }
    
    public void setProvincia(Provincia provincia) { 
    	this.provincia = provincia; 
    }

	public String getCorreo_electronico_cliente() {
		return correo_electronico_cliente;
	}

	public void setCorreo_electronico_cliente(String correo_electronico_cliente) {
		this.correo_electronico_cliente = correo_electronico_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getUsuario_cliente() {
		return usuario_cliente;
	}

	public void setUsuario_cliente(String usuario_cliente) {
		this.usuario_cliente = usuario_cliente;
	}

	public String getContraseña_cliente() {
		return contraseña_cliente;
	}

	public void setContraseña_cliente(String contraseña_cliente) {
		this.contraseña_cliente = contraseña_cliente;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [dni_cliente=" + dni_cliente + ", Cuil_cliente=" + Cuil_cliente + ", nombre_cliente="
				+ nombre_cliente + ", apellido_cliente=" + apellido_cliente + ", sexo_cliente=" + sexo_cliente
				+ ", nacionalidad_cliente=" + nacionalidad_cliente + ", fecha_nacimiento_cliente="
				+ fecha_nacimiento_cliente + ", Direccion_cliente=" + Direccion_cliente + ", provincia="
				+ provincia + ", localidad=" + localidad + ", correo_electronico_cliente="
				+ correo_electronico_cliente + ", telefono_cliente=" + telefono_cliente + ", usuario_cliente="
				+ usuario_cliente + ", contraseña_cliente=" + contraseña_cliente + ", estado=" + estado + "]";
	}

}
