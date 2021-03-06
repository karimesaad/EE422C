package assignment2;

public class CheckingAccount extends BankAccount{
	
// constructors
	
	public CheckingAccount(double initialBalance) {
		super(initialBalance);
	}
	
	public CheckingAccount(int acct, Customer owner, double initBalance)
    {
        super(acct, owner, initBalance);
    }
	
	/**
	 * Subtracts amount from checkings balance, and gets the remainder that will be withdrawn from the
	 * savings account. 
	 * 
	 * @pre-condition: Savings Account was able to provide overdraft protection because you had enough money
	 * @post-condition: Balance is $0 and Savings account gets a $20 fee
	 * 
	 * @param amount: amount to be deducted from checking account
	 * @return owedAmount: what is left over to pay for savings account
	 */
	protected double overdraftProtection(double amount){
		double owedAmount = amount - this.balance; // get the remainder that is still due
		this.withdraw(this.balance); // balance is $0
		return owedAmount; // what is owed
	}
	
	
}
