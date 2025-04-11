package Ejercicio2;

public class ProductoCongelado extends Producto{

	private final int tempCongelacion = - 18;
	
	
	// CONSTRUSCTORES
	
	public ProductoCongelado() {
		super();
	}
	
	public ProductoCongelado(String fechaCaducidad, int numeroLote) {
		super(fechaCaducidad, numeroLote);		
		
	}
	
	// GET Y SET
	
	public int getTemperaturaCongelacion() {
		
		return tempCongelacion;		
	}
	


	@Override
	public String toString() {
		return  "Producto Congelado | Temperatura de Congelación: " + tempCongelacion + 
				" | Fecha de caducidad: " +getFechaCaducidad()  + 
				" | Numero lote: " + getNumeroLote();
	}	
	
	
}
