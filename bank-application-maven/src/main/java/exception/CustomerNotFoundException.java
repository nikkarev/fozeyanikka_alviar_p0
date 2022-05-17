package exception;

public class CustomerNotFoundException extends Exception{
	
	@Override
	public String getMessage() {
		return "Customer Account not found. \nPlease enter a valid Customer Number.";
	}
}
