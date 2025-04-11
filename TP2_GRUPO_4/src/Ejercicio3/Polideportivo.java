package Ejercicio3;

public class Polideportivo extends Edificio implements InstalacionDeportiva {
	
	private int instDep;
	//CONSTRUCTORES
	public Polideportivo() {
		super();
		instDep = 0;
	}

	public Polideportivo(String nombre, double superficie, int instDep) {
		super(nombre,superficie);
		this.instDep = instDep;
	}
	
	//GETTER AND SETTERS
	public int getInstDep() {
		return instDep;
	}

	public void setInstDep(int instDep) {
		this.instDep = instDep;
	}

	@Override
	public double getSuperficieEdificio() {
		return getSuperficie();
	}

	@Override
	public int getTipoDeInstalacion() {
		return instDep;
	}

	@Override
	public String toString() {
		return ">> POLIDEPORTIVO:\n" +
		           "Nombre: " + getNombre() + "\n" +
		           "Superficie: " + getSuperficie() + "\n" +
		           "Tipo instalación: " + getTipoDeInstalacion() + "\n" +
		           "-----------------------------";
	}
	
	
}
