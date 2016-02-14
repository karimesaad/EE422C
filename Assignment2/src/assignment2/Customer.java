/*
 * Name: Karime Saad
 *EID: ks38728
 *EE 422C lab time: TH 9:30-11am 
 */

package assignment2;

import java.util.Random;

public class Customer{

	private String name;
	private int uniqueNumber;
	private String address;
	private CheckingAccount checkingAccount = new CheckingAccount(rand(), this, 0);
	private SavingsAccount savingsAccount = new SavingsAccount(rand(), this, 0);
	private StudentLoanSavingsAccount studentLoanAccount = new StudentLoanSavingsAccount(rand(), this, 0);
	private AutoLoanSavingsAccount autoLoanAccount = new AutoLoanSavingsAccount(rand(), this, 0);

//constructors
	
	public Customer(String name, int uniqueNumber, String address) {
		super();
		this.name = name;
		this.uniqueNumber = uniqueNumber;
		this.address = address;
	}

	public Customer() {
		this.name = "";
		this.uniqueNumber = -1;
		this.address = "";
	}

	
//getters and setters 
	
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
	
	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}
	
	public StudentLoanSavingsAccount getStudentLoanAccount() {
		return studentLoanAccount;
	}

	public AutoLoanSavingsAccount getAutoLoanAccount() {
		return autoLoanAccount;
	}


	/**
	 * Generates a random number between 0 - 1000 for the bank account number
	 * 
	 * @return Integer value between 0-1000
	 */
	public static int rand() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(1000);
	}

	/**
	 * Withdraws money from account's balance. If accountType is checkings, then check for overdraft protection. 
	 * @param accountType
	 * @param amt
	 */
	
	public void withdrawFromAccount(String accountType, double amt) {
		switch (accountType) {
		case "C":
			if (this.checkingAccount.withdraw(amt)) {
				break;
			}
			if ((this.checkingAccount.balance + this.savingsAccount.balance) >= amt + this.savingsAccount.FEE) {
				double remaining = this.checkingAccount.overdraftProtection(amt);
				this.savingsAccount.overdraftWithdraw(remaining);
			} else {
				System.out.println("Cannot complete. Insufficient Funds.");
			}
			break;
		case "S":
			if(this.savingsAccount.balance < amt){
				System.out.println("Cannot complete. Insufficient Funds.");
			} else{
				this.savingsAccount.withdraw(amt);	
			}
			break;
		case "L":
			if(this.studentLoanAccount.balance < amt){
				System.out.println("Cannot complete. Insufficient Funds.");
			} else{
				this.studentLoanAccount.withdraw(amt);	
			}
			break;
		case "A":
			if(this.autoLoanAccount.balance < amt){
				System.out.println("Cannot complete. Insufficient Funds.");
			} else{
				this.autoLoanAccount.withdraw(amt);	
			}
			break;
		default:
			System.out.println("Invalid Account Type");
		}

	}

	/**
	 * Deposits amount to account. 
	 * @param accountType
	 * @param amount
	 */
	public void depositToAccount(String accountType, double amount) {
		switch (accountType) {
		case "C":
			this.checkingAccount.deposit(amount); 
			break;
		case "S":
			this.savingsAccount.deposit(amount);
			break;
		case "L":
			this.studentLoanAccount.deposit(amount);
			break;
		case "A":
			this.autoLoanAccount.deposit(amount);
			break;
		default:
			System.out.println("Invalid Account Type");
		}
	}

	/**
	 * Checks if the accountType is valid. If valid, then does interest transaction. 
	 * @param accountType
	 */
	public void interestTransaction(String accountType){
	switch (accountType) {
		case "S":
			this.savingsAccount.interestAccrue();
			break;
		case "L":
				this.studentLoanAccount.interestAccrue();
			break;
		case "A":
				this.autoLoanAccount.interestAccrue();
			break;
		default:
			System.out.println("Invalid Account Type");
		}
	}
	
	/**
	 * Gets balance from account
	 * @param accountType
	 * @return balance (if account type valid), otherwise displays error message. 
	 * 
	 */
	public double getBalanceTransaction(String accountType){
		switch (accountType) {
		case "C":
			return this.checkingAccount.getBalance();
		case "S":
			return this.savingsAccount.getBalance();
		case "L":
			return this.studentLoanAccount.getBalance();

		case "A":
			return this.autoLoanAccount.getBalance();
		default:
			System.out.println("Invalid Account Type");
			return -999.99;
		}
	}
	/**
	 * Checks to see if both accounts are valid to perform a transfer between accounts. 
	 * @param accountType
	 * @param accountType2
	 * @param amt
	 */
	public void transferTransaction(String accountType, String accountType2, double amt){
		switch (accountType) {
		case "C":
			if(!this.checkingAccount.transferValid(amt)){
				System.out.println("Not enough funds in source.");
			} else{
				// transfer function
				if(isAccountTypeValid(accountType2)){	//check if the second account is valid.
					this.checkingAccount.withdraw(amt);
					transferTo(accountType2, amt);
				} else{
					System.out.println("Destination account is an invalid type");
				}
			}
			break;
		case "S":
			if(!this.savingsAccount.transferValid(amt)){
				System.out.println("Not enough funds in source.");
			} else{
				// transfer function
				if(isAccountTypeValid(accountType2)){ //check if the second account is valid.
					this.savingsAccount.withdraw(amt);
					transferTo(accountType2, amt);
				} else{
					System.out.println("Destination account is an invalid type");
				}
			}
			break;
		case "L":
			if(!this.studentLoanAccount.transferValid(amt)){
				System.out.println("Not enough funds in source.");
			} else{
				// transfer function
				if(isAccountTypeValid(accountType2)){ //check if the second account is valid.
					this.studentLoanAccount.withdraw(amt);
					transferTo(accountType2, amt);
				} else{
					System.out.println("Destination account is an invalid type");
				}
			}
			break;
		case "A":
			if(!this.autoLoanAccount.transferValid(amt)){
				System.out.println("Not enough funds in source.");
			} else{
				// transfer function
				if(isAccountTypeValid(accountType2)){ //check if the second account is valid.
					this.autoLoanAccount.withdraw(amt);
					transferTo(accountType2, amt);
				} else{
					System.out.println("Destination account is an invalid type");
				}
			}
			break;
		default:
			System.out.println("Invalid Account Type");
		}
	}

	/**
	 * Performs transfer transaction.
	 * @param accountType
	 * @param amount
	 */
	
	private void transferTo(String accountType, double amount) {
		switch (accountType) {
		case "C":
			this.checkingAccount.deposit(amount); 
			break;
		case "S":
			this.savingsAccount.deposit(amount);
			break;
		case "L":
			this.studentLoanAccount.deposit(amount);
			break;
		case "A":
			this.autoLoanAccount.deposit(amount);
			break;
		default:
			System.out.println("Invalid Account Type");
		}
	}

	/**
	 * Checks if the account type passed is valid.
	 * @param accountType
	 * @returns true if valid, otherwise returns false. 
	 */
	public boolean isAccountTypeValid(String accountType){
		if(accountType.contains("C") ||accountType.contains("S") || accountType.contains("L") || accountType.contains("A")){
			return true;
		}
		return false;
	}
	
}
