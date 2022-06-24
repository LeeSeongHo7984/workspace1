package banking;

import java.util.Date;

public class AccountDaoTest {

	public static void main(String[] args) {
		 AccountDao dao = new AccountDao();
	      
	      SavingsAccount sa = new SavingsAccount();
	      sa.setAccountNum("567-89-0123");
	      sa.setBalance(45000);
	      sa.setCustomer(new Customer(1004));
	      sa.setInterestRate(0.04);
	      sa.setRegDate(new Date());
	      sa.setAccountType('S');
	      
	      dao.addAccount(sa);
	      for(Account account : dao.findAccountByssn("930418-1111111")) {
	         System.out.println(account);
	      }

	}
}
