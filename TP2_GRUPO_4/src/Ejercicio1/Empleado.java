package Ejercicio1;

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
		
}
