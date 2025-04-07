package Ejercicio1;

import java.util.Objects;

public class Empleado {

	//ATRIBUTOS
	
		private final int  id;
		private String nombre;
		private int edad;
		
		private static int IDBASE = 999;
		
		// GETTERS AND SETTERS
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public int getId() {
			return id;		
		}
		public static int getIdBase() {
			return IDBASE;		
		}
		
		
		//CONSTRUCTORES
		
		public Empleado() 
		{
			IDBASE++;
			id = IDBASE;
			nombre = "sin nombre";
			edad = 99;			
		}
		
		public Empleado(String Nombre , int Edad) 
		{
			IDBASE++;
			id = IDBASE;
			this.nombre =  Nombre;
			this.edad = Edad;			
		}
		
		public static int devuelveProximoID() 
		{		
			return IDBASE+1;
		}
		
		//TO STRING
		
		@Override
		public String toString() {
			return "Empleado: " + nombre + ", Edad: " + edad + ", Legajo: " + id;
		}
		
		
		@Override
		public int hashCode() {
			return Objects.hash(edad, id, nombre);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Empleado other = (Empleado) obj;
			return edad == other.edad && id == other.id && Objects.equals(nombre, other.nombre);
		}
		
		
}
