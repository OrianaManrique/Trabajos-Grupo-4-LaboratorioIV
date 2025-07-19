package entidad;

public class Usuario {
	private String usuario_us;
	private String contraseña_us;
	private String tipo_us;
	private String nombre_us;
	private String apellido_us;
	private int dni_us;
	
	private int estado_us;
	
	public Usuario() {}

	public Usuario(String usuario, String contraseña, String tipo, String nombre, String apellido, int dni, int estado) {
		
		
		super();
		
		usuario_us = usuario;
		contraseña_us = contraseña;
		tipo_us = tipo;
		nombre_us = nombre;
		apellido_us = apellido;
		dni_us = dni;
		estado_us = estado;
	}

	public String getUsuario_us() {
		return usuario_us;
	}

	public void setUsuario_us(String usuario_us) {
		this.usuario_us = usuario_us;
	}

	public String getContraseña_us() {
		return contraseña_us;
	}

	public void setContraseña_us(String contraseña_us) {
		this.contraseña_us = contraseña_us;
	}

	public String getTipo_us() {
		return tipo_us;
	}

	public void setTipo_us(String tipo_us) {
		this.tipo_us = tipo_us;
	}

	
	public int getEstado_us() {
		return estado_us;
	}

	public String getNombre_us() {
		return nombre_us;
	}

	public void setNombre_us(String nombre_us) {
		this.nombre_us = nombre_us;
	}

	public String getApellido_us() {
		return apellido_us;
	}

	public void setApellido_us(String apellido_us) {
		this.apellido_us = apellido_us;
	}

	public int getDni_us() {
		return dni_us;
	}

	public void setDni_us(int dni_us) {
		this.dni_us = dni_us;
	}

	public void setEstado_us(int estado_us) {
		this.estado_us = estado_us;
	}

	@Override
	public String toString() {
		return "Usuario [usuario_us=" + usuario_us + ", contraseña_us=" + contraseña_us + ", tipo_us=" + tipo_us
				+ ", nombre_us=" + nombre_us + ", apellido_us=" + apellido_us + ", dni_us=" + dni_us + ", estado_us="
				+ estado_us + "]";
	}
	
	
	
}
