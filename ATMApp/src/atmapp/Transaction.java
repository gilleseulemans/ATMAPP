package atmapp;

public class Transaction {
	
	/**
	 * gets the user and the amount
	 * @param userFrom
	 * @param userTo
	 * @param money
	 * 
	 * then wil substract and add the amount with the different users
	 * 
	 */
	
	
	public Transaction(User userFrom, User userTo, int money) {
		
		int balanceFrom = userFrom.getbalance();
		int balanceTo = userTo.getbalance();
		
		balanceFrom -= money;
		balanceTo += money;
		
		userFrom.setBalance(balanceFrom);
		userTo.setBalance(balanceTo);
		
		
	}
	

}
