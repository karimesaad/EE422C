package assignment2;

public class SavingsAccount extends BankAccount{
	protected static final double INTEREST_RATE = 4.0;
	protected static final int FEE = 20;

// constructor
	
	public SavingsAccount(int acct, Customer owner, double initBalance)
    {
        super(acct, owner, initBalance);
    }
	
	/**
	 * Subtracts from savings account the remaining amount for overdraft.
	 * pre-req: the remaining amount comes from subtracting the original amount from the checkings account.
	 * @param remaining
	 */
	
	protected void overdraftWithdraw(double remaining){
		this.withdraw(remaining + FEE);
		System.out.println("Overdraft protection:" + this.balance);
	}
	
	/**
	 * Performs interest accrue on savings accounts. 
	 */
	protected void interestAccrue(){
		if(this.balance >= 1000){
			double amount = this.getBalance() * (INTEREST_RATE / 100);
			this.deposit(amount);
		} else{
			System.out.println("Customer must have at least 1000 dlls to accrue interest.");
		}
	}
	
}
