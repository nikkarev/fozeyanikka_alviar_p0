package exception;

public class LoginFailedException extends Exception{
	
	@Override
	public String getMessage() {
		return "Incorrect username or password. Please try again.";
	}
}
