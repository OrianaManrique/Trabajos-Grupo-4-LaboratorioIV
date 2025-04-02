package Ejercicio1;

public class Profesor extends Empleado {
	
	private String cargo;
	private int antiguedadDocente;
	
	public Profesor() 
	{
		super();
	}
	
	public Profesor(String Cargo , int AntiguedadDocente , String Nombre , int Edad) 
	{   
		super(Nombre, Edad);
		this.cargo = Cargo;
		this.antiguedadDocente = AntiguedadDocente;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getAntiguedadDocente() {
		return antiguedadDocente;
	}

	public void setAntiguedadDocente(int antiguedadDocente) {
		this.antiguedadDocente = antiguedadDocente;
	}

}
