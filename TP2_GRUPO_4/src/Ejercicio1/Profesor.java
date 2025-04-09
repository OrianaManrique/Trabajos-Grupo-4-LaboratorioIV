package Ejercicio1;

import java.util.Objects;

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(antiguedadDocente, cargo);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
			
		Profesor other = (Profesor) obj;

	    if (this.getEdad() != other.getEdad())
	        return false;

	    if (this.getNombre() == null) {
	        if (other.getNombre() != null)
	            return false;
	    } else if (!this.getNombre().equals(other.getNombre()))
	        return false;

	    if (this.cargo == null) {
	        if (other.getCargo() != null)
	            return false;
	    } else if (!this.cargo.equals(other.getCargo()))
	        return false;

	    if (antiguedadDocente != other.antiguedadDocente)
	        return false;

	    return true;
	}
	
	
}
