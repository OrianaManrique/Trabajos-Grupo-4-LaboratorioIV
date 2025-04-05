package Ejercicio1;

public class Profesor extends Empleado implements Comparable<Profesor>{
	
	private String cargo;
	private int antiguedadDocente;
	
	//CONSTRUCTORES
	
	public Profesor() 
	{
		super();
	}
	

	public Profesor(String Nombre , int Edad , String Cargo , int AntiguedadDocente) 
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

	@Override
	public int compareTo(Profesor o) {
		if(o.getId() == this.getId())
			return 0;
		
		if(o.getId() < this.getId())
			return -1;
		
		return 1;
	}
	
}
