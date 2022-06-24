package banking;

import javax.naming.InsufficientResourcesException;

public class SavingsAccount extends Account {
	private static final double DEFAULT_INTEREST_RATE = 0.03;
	private double interestRate;	// 이자율
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super();
		this.setInterestRate(interestRate);
	}
	
	public void withdraw(double amount) {	// 출금
		if( balance - amount < 0 ) {
			throw new InsufficientBalance("잔고부족");	// 예외발생
		}
		
		System.out.println("출금 전 금액: " + balance + "원");
		super.balance -= amount;	// 부모의 balance를 super. 으로 데려옴
		System.out.println(amount + "원 출금 후 금액: " + balance + "원");
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
