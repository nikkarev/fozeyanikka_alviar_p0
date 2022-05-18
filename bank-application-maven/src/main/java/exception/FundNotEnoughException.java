package exception;

public class FundNotEnoughException extends Exception{
	
	@Override
	public String getMessage() {
		return "You do not have enough fund for this withdrawal. \nPlease try withdrawing a small amount.";
	}
}
