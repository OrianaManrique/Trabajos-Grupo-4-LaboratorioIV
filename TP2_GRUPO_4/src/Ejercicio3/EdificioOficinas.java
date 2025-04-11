package Ejercicio3;

public class EdificioOficinas extends Edificio implements IEdificio {
	
	private int numOficinas;
	
	//CONSTRUCTORES
	public EdificioOficinas() {
		super();
		numOficinas = 0;
	
	}

	public EdificioOficinas(String nombre, double superficie, int numOficinas) {
		super(nombre,superficie);
		this.numOficinas = numOficinas;
		
	}

	//GETTER AND SETTERS
	public int getNumOficinas() {
		return numOficinas;
	}

	public void setNumOficinas(int numOficinas) {
		this.numOficinas = numOficinas;
	}
	
	public double getSuperficieEdificio() {
		return getSuperficie();
	}

	@Override
	public String toString() {
		  return ">> EDIFICIO DE OFICINAS:\n" +
		           "Nombre: " + getNombre() + "\n" +
		           "Superficie: " + getSuperficie() + "\n" +
		           "Cantidad de oficinas: " + numOficinas + "\n" +
		           "-----------------------------";
	}
	
	
	
}
