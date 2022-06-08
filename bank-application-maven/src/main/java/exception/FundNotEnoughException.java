package exception;

public class FundNotEnoughException extends Exception{
	@Override
	public String getMessage() {
		return "Fund not Enough. Please try again.";
	}
}
