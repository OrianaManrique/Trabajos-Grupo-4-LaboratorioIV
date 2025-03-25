package EJERCICIO1;

public class Empleado {

		private final int id;
		private String nombre;
		private int edad;
		private static int cont=999;
		
		//constructores
		Empleado(){
			
			cont++;
			this.id = cont;
			this.nombre = "sin nombre";
			this.edad = 99;
			
		}
		
		Empleado(String nombre, int edad){
			
			cont++;
			this.id = cont;
			this.nombre = nombre;
			this.edad = edad;
		}
		
		//met static
		public static int devuelveProximoID()
		{
			return cont+1;
		}
		
		//met.toString
		@Override
		public String toString() {
			return "Empleado [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
		}
		
		//getters y setters
		public int getId() {
			return id;
		}
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
		
		

	

}
