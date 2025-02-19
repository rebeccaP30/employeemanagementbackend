package Exception;

public class CustomException extends RuntimeException {
	public CustomException(String message) {
		super(message);
	}

	public static class EmployeeAlreadyExistsException extends RuntimeException {
	    public EmployeeAlreadyExistsException(String message) {
	        super(message);
	    }
	}
}
