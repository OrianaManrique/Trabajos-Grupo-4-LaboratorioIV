package exceptions;

public class maximoCuentas extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public maximoCuentas() {}
	
	public String getMessage() {
		return "Ya posee la cantidad de cuentas permitidas 3/3";
	}

}
