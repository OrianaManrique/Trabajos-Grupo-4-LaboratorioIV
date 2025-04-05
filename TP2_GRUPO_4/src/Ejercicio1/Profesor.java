package Ejercicio1;

public class Profesor extends Empleado {
	
	private String cargo;
	private int antiguedadDocente;
	
	//CONSTRUCTORES
	
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

	//GETTERS Y SETTERS
	
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

	@Override
	public String toString() {
		return "ID: " + super.getId() + " Nombre: " + super.getNombre() + " Edad: " 
				+ super.getEdad() + " Cargo: " + getCargo() + " Antiguedad: " + getAntiguedadDocente();
		}
	
}
