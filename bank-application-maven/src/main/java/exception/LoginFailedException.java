package exception;

public class LoginFailedException extends Exception{
	@Override
	public String getMessage() {
		return "Incorrect Username or Password";
	}
}
