package Ejercicio3;

public class Edificio implements IEdificio{
	private double superficie;
	private String nombre;
	
	//CONSTRUCTORES
	public Edificio() {
		superficie = 0;
		nombre = "sin nombre";
	}

	public Edificio(String nombre, double superficie) {
		this.nombre = nombre;
		this.superficie = superficie;
	}

	//GETTER AND SETTERS
	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public double getSuperficieEdificio() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
