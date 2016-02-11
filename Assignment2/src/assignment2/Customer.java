/*
 * Name: Karime Saad
 *EID: ks38728
 *EE 422C lab time: TH 9:30-11am 
 */

package assignment2;

import java.util.Random;

public class Customer {

	private String name;
	private int uniqueNumber;
	private String address;
	private CheckingAccount checkingAccount = new CheckingAccount(rand(), this, 0);
	private SavingsAccount savingsAccount = new SavingsAccount(rand(), this, 0);
	
	public Customer(String name, int uniqueNumber, String address) {
		super();
		this.name = name;
		this.uniqueNumber = uniqueNumber;
		this.address = address;
	}
	
	public Customer(){
		this.name = "";
		this.uniqueNumber = -1;
		this.address = "";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUniqueNumber() {
		return uniqueNumber;
	}
	public void setUniqueNumber(int uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Generates a random number between 0 - 1000 for the bank account number
	 * 
	 * @return Integer value between 0-1000
	 */
	public static int rand(){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(1000);
	}
	


	public void withdrawFromAccount(String accountType, double amt) {
		switch(accountType){
			case "C":
					this.checkingAccount.withdraw(amt); // TODO: check if you CAN withdraw 
				break;
			case "S":
					this.savingsAccount.withdraw(amt);
				break;
			case "L":
				break;
			case "A":
				break;
			default:
				System.out.println("Invalid Account Type");
		}

		
	}

	public void depositToAccount(String accountType, double amt) {
		switch(accountType){
			case "C":
					this.checkingAccount.deposit(amt);
				break;
			case "S":
					this.savingsAccount.deposit(amt);
				break;
			case "L":
				break;
			case "A":
				break;
			default:
				System.out.println("Invalid Account Type");
		}
	}
	
	
}
