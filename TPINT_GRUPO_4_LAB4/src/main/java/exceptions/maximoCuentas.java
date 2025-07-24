package exceptions;

public class maximoCuentas extends RuntimeException{

	public maximoCuentas() {}
	
	public String getMessage() {
		return "Ya posee la cantidad de cuentas permitidas 3/3";
	}

}
