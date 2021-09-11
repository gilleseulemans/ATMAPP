package atmapp;

import java.util.ArrayList;

public class Account {
	
	private User user;
	private String bankName;
	private int balance;
	private ArrayList<String> account = new ArrayList<String>();
	
	public Account(String id,String bankName, int balance ) {
		
		this.user = user;
		this.bankName = bankName;
		this.balance = balance;
		this.account.add(id);
		this.account.add(bankName);
		this.account.add(Integer.toString(balance));
		
	}
	

	public User getUser() {
		return this.user;
	}
	

	public String getBank() {
		return this.bankName;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public Account getAccountById(String id) {
		
		 String bankname = this.account.get(1);
		 String Balance = this.account.get(2);
		 
		 return new Account(id, bankname, Integer.parseInt(Balance));
	}
	
	
	
	
	


}
