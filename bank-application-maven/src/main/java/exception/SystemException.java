package exception;

public class SystemException extends Exception{

	@Override
	public String getMessage() {
		return "There is an internal error. \nPlease try again later.";
	}
	
	
}
