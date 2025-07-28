package exceptions;

public class arrobaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public arrobaException()
	{}

	@Override
	public String getMessage() {
		return "El mail debe contener arroba '@'";
	}
	
	
}