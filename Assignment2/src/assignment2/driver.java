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
