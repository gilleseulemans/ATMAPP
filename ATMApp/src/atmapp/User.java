package atmapp;

public class User {
	private String name,lastName,id;
	private int balance;
	
	public User(String name, String lastName,int balance) {
		this.name = name;
		this.lastName = lastName;
		this.balance = balance;
		
	}
	
	public String getName() {
		return this.name;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	public String getID() {
		return this.id;
	}
	
	public int getbalance() {
		return this.balance;
	}
	
	public void setBalance(int newBalance) {
		 this.balance = newBalance;
	}
	
	
	//public Account getAccount() {
		//return new Account(new User())
	//}
}
