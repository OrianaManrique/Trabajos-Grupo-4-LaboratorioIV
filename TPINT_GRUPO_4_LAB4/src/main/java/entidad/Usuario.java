package entidad;

public class Usuario {
	private String dniUsuario;
	private String passwordUsuario;
	private String tipoUsuario;
	private int estadoUsuario;
	
	public Usuario() {}

	public Usuario(String dniUsuario, String passwordUsuario, String tipoUsuario, String estadoUsuario) {
		super();
		this.dniUsuario = dniUsuario;
		this.passwordUsuario = passwordUsuario;
		this.tipoUsuario = tipoUsuario;
		this.estadoUsuario = 1;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(int estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [dniUsuario=" + dniUsuario + ", passwordUsuario=" + passwordUsuario + ", tipoUsuario="
				+ tipoUsuario + ", estadoUsuario=" + estadoUsuario + "]";
	}
}
