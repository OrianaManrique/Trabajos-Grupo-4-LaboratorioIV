package entidad;

public class Usuario {
	private String usuario_us;
	private String contraseña_us;
	private String tipo_us;
	private int dniCliente_us;
	private String nombreCliente_us;
	private String apellido_us;
	private int estado_us;
	
	public Usuario() {}

	public Usuario(String usuario, String contraseña, String tipo, int dni, String nombre, String apellido, int estado) {
		usuario_us = usuario;
		contraseña_us = contraseña;
		tipo_us = tipo;
		dniCliente_us = dni;
		nombreCliente_us = nombre;
		apellido_us = apellido;
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

	public int getDniCliente_us() {
		return dniCliente_us;
	}

	public void setDniCliente_us(int dniCliente_us) {
		this.dniCliente_us = dniCliente_us;
	}

	public String getNombreCliente_us() {
		return nombreCliente_us;
	}

	public void setNombreCliente_us(String nombreCliente_us) {
		this.nombreCliente_us = nombreCliente_us;
	}

	public String getApellido_us() {
		return apellido_us;
	}

	public void setApellido_us(String apellido_us) {
		this.apellido_us = apellido_us;
	}

	public int getEstado_us() {
		return estado_us;
	}

	public void setEstado_us(int estado_us) {
		this.estado_us = estado_us;
	}

	@Override
	public String toString() {
		return "Usuario [usuario_us=" + usuario_us + ", contraseña_us=" + contraseña_us + ", tipo_us=" + tipo_us
				+ ", dniCliente_us=" + dniCliente_us + ", nombreCliente_us=" + nombreCliente_us + ", apellido_us="
				+ apellido_us + ", estado_us=" + estado_us + "]";
	}
	
	
}
