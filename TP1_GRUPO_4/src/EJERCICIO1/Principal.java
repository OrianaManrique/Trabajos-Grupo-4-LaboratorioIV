package EJERCICIO1;

public class Principal {

	public static void main(String[] args) {
		
		
		// FORMA SIMPLE 
		
		/*
		Empleado empleado1 = new Empleado();		
		Empleado empleado2 = new Empleado();
		Empleado empleado3 = new Empleado();
		Empleado empleado4 = new Empleado("Carlos" , 23);
		Empleado empleado5 = new Empleado("Carlita" , 23);	
		*/
		
		/*
		System.out.println(empleado1.toString());
		System.out.println(empleado2.toString());
		System.out.println(empleado3.toString());
		System.out.println(empleado4.toString());
		System.out.println(empleado5.toString());
		*/
		
		
		// FORMA CON ARRAY
		
		Empleado ListaEmpleados[] = new Empleado[5];
		ListaEmpleados[0] = new Empleado();
		ListaEmpleados[1] = new Empleado();
		ListaEmpleados[2] = new Empleado();
		ListaEmpleados[3] = new Empleado("Carlos", 23);
		ListaEmpleados[4] = new Empleado("Carlita", 23);
		
		for (Empleado empleado : ListaEmpleados) {		
			
			System.out.println(empleado.toString());
		}
		
		System.out.println("El próximo ID será el " + Empleado.devuelveProximoID());
		System.out.println("Ultimo ID utilizado: " + Empleado.getIdBase());
	}

}
