package exceptions;

public class arrobaException extends RuntimeException {

	public arrobaException()
	{}

	@Override
	public String getMessage() {
		return "El mail debe contener arroba '@'";
	}
	
	
}