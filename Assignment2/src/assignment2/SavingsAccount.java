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
