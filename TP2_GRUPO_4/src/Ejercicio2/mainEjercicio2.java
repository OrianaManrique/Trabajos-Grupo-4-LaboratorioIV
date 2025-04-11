package Ejercicio2;

public class mainEjercicio2 {

	public static void main(String[] args) {


		// llenando los objetos con los constructores vacios o por defecto
				Producto p1 = new ProductoFresco();			
				Producto p2 = new ProductoRefrigerado();
				Producto p3 = new ProductoCongelado();
				
		// llenando los objetos con sus constructores que reciben parametros
				Producto p4 = new ProductoFresco("2026/04/04",10,"2025/04/04" ,"Argentina");
				Producto p5 = new ProductoRefrigerado("2027/04/04", 30, "COD01121");	
				Producto p6 = new ProductoCongelado("2026/10/07",15);
				
				Producto[] productos = {p1, p2, p3, p4, p5, p6};
				
				for (Producto p : productos) {
			        imprimir(p);
			    }
				
	}
	
	public static void imprimir(Object objeto) {
		System.out.println(objeto);
	}
	

}
