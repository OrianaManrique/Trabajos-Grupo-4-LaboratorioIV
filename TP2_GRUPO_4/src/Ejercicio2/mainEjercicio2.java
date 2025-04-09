package Ejercicio2;

public class mainEjercicio2 {

	public static void main(String[] args) {


		// llenando los objetos con los constructores vacios o por defecto
				Producto p1 = new ProductoFresco();
				imprimir(p1);				
				Producto p2 = new ProductoRefrigerado();
				imprimir(p2);				
				Producto p3 = new ProductoCongelado();
				imprimir(p3);
										
			
				System.out.println('\n');	
				
				// llenando los objetos con sus constructores que reciben parametros
				Producto p4 = new ProductoFresco("2026/04/04",10,"2025/04/04" ,"Argentina");
				imprimir(p4);		
				Producto p5 = new ProductoRefrigerado("2027/04/04", 30, "COD01121");
				imprimir(p5);		
				Producto p6 = new ProductoCongelado("2026/10/07",15);
				imprimir(p6);		
				

	}
	
	
	public static void imprimir(Object objeto) {
		System.out.println(objeto);
	}
	

}
