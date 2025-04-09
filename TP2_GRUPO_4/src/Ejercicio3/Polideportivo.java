package Ejercicio3;

public class Polideportivo implements InstalacionDeportiva, IEdificio {
	
	private double superficie;
	private String nombre;
	

	@Override
	public double getSuperficieEdificio() {
		
		return superficie;
	}

	@Override
	public int getTipoDeInstalacion() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
