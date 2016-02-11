package assignment2;

public class CheckingAccount extends BankAccount{
	
	public CheckingAccount(double initialBalance) {
		super(initialBalance);
	}
	
	public CheckingAccount(int acct, Customer owner, double initBalance)
    {
        super(acct, owner, initBalance);
    }
	
	/**
	 * TODO: type description
	 * 
	 * @pre-condition: Savings Account was able to provide overdraft protection because you had enough money
	 * @post-condition: Balance is $0 and Savings account gets a $20 fee
	 * 
	 * @param amount: amount to be deducted from checking account
	 * @return owedAmount: what is left over to pay for savings account
	 */
	public double overdraftProtection(double amount){
		double owedAmount = amount - this.balance; // get the remainder that is still due
		this.withdraw(this.balance); // balance is $0
		return owedAmount; // what is owed
	}
	
	
}
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
/*
 * Name: Karime Saad
 *EID: ks38728
 *EE 422C lab time: TH 9:30-11am 
 */
package assignment2;

import javax.swing.JOptionPane;


public class driver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		while(true){
			String transaction = JOptionPane.showInputDialog("Please input a value");
			int customerId = -1;
			String transactionType = "";
			String tmp = "";
			double amount = -1;
			String accountType = "";
			String accountType2 = "";
			
			// expected transaction type: 
			// CUSTOMER ID - TRANSACTION TYPE - AMOUNT - ACCOUNT TYPE - ACCOUNT TYPE 2
			try{
				customerId = Integer.parseInt(transaction.substring(0, 1));
				transaction = transaction.substring(2, transaction.length());
				
				transactionType = transaction.substring(0,1).toUpperCase();
				transaction = transaction.substring(2, transaction.length());
				
				if(transaction.indexOf(' ') > 0){
					tmp = transaction.substring(0, transaction.indexOf(' '));
				}
				
				if(tmp.indexOf('.') > 0){
					amount = Double.parseDouble(tmp);
					transaction = transaction.substring(transaction.indexOf(' ')+1, transaction.length());
					if(transaction.length() > 0){
						accountType = transaction.substring(0, 1).toUpperCase(); // C - checking, S - primary, L - student loan savings, A - auto loan savings
						transaction = transaction.substring(2, transaction.length());
					}
				} else{
					accountType = transaction.substring(0, 1).toUpperCase(); // C - checking, S - primary, L - student loan savings, A - auto loan savings
					if(transaction.length() > 2){
						transaction = transaction.substring(2, transaction.length());
					} else {
						transaction = transaction.substring(1, transaction.length());
					}
				}
	
				if(transaction.length() > 0){
					accountType2 = transaction.substring(0,1).toUpperCase(); // optional
				}
			} catch(Exception e){
				System.out.println("Invalid input");
			}
			
			System.out.println("Customer ID: " + customerId);
			System.out.println("Transaction Type: " + transactionType);
			System.out.println("Amount: " + amount);
			System.out.println("Account Type: " + accountType);
			System.out.println("Account Type2: " + accountType2);
			System.out.println();
		}
		
		
		//Customer Karime = new Customer("Karime", 1, "123 University");
		//CheckingAccount Bank = new CheckingAccount(rand(), Karime, 1000);
		

		//Karime.depositToAccount("C", 120);
		//Karime.withdrawFromAccount("C", 100);		
	}

	


}
package assignment2;

public class SavingsAccount extends BankAccount{
	private double interestRate = 4.0;
	private static final int FEE = 20;
	
	public SavingsAccount(double initialBalance) {
		super(initialBalance);
		// TODO Auto-generated constructor stub
	}
	
	public SavingsAccount(int acct, Customer owner, double initBalance)
    {
        super(acct, owner, initBalance);
    }

	public boolean overdraftProtectionValid(double amount){
		if((amount + FEE) > this.balance){
			System.out.println("ERROR.");
			return false;
		} else {
			return true;
		}
	}
	
}
