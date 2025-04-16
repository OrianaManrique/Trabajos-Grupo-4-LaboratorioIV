package Ejercicio1;

public class InvalidDniException extends RuntimeException {

	public InvalidDniException() {
		
	}

	@Override
	public String getMessage() {
		return "DNI ERROR - El DNI contiene letras";
	}
}
