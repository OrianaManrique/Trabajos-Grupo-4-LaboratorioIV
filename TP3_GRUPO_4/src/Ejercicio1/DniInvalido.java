package Ejercicio1;

import java.io.IOException;

public class DniInvalido extends IOException {
	
	public DniInvalido()
	{
		
	}

	public static boolean verificarDniInvalido (String dni) throws InvalidDniException
	{
		Boolean validDni = false;
		
		if(dni.matches("[0-9]+")) {
			validDni = true;
		}
		
		if(validDni == false) {
			throw new InvalidDniException();
		}
		
		return false;
	}

}
