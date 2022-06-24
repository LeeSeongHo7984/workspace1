package banking;

public class InsufficientBalance extends RuntimeException {
	public InsufficientBalance(String msg) {
		super(msg);
	}
}
