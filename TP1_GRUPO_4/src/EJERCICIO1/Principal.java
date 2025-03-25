package EJERCICIO1;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empleado[] Empleados = new Empleado[5];
		Empleados[0] = new Empleado();
		Empleados[1] = new Empleado();
		Empleados[2] = new Empleado();
		Empleados[3] = new Empleado("Oriana Manrique", 26);
		Empleados[4] = new Empleado("Rodrigo Brichetto", 27);
		
		for (Empleado empleado : Empleados) {
			
			System.out.println(empleado);
		}
		
		System.out.println("El próximo ID de empleado será el " +Empleado.devuelveProximoID());
		
		
	}

}
