package exception;

public class SystemException extends Exception {
	@Override
	public String getMessage() {
		return "Internal Error. Please try again later.";
	}
}
