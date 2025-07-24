package exceptions;

public class puntoException extends RuntimeException{

	public puntoException()
	{}

	@Override
	public String getMessage() {

		return "El mail debe contener punto '.'";
	}
	
	
	
}
