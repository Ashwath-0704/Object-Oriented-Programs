package stockaccount;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AcountTest {

	static String name;
	static Long withdrawal1;
	static Integer id = 1;
	static double Balance;
	static ArrayList<String> accountData = new ArrayList<>();
	static ArrayList<Double> balanceData = new ArrayList<>();
	static ArrayList<Integer> ID = new ArrayList<>();

//	static ArrayList<Double> withdrawalData = new ArrayList<>();
	/*
	 * Open the account
	 */
	public void openAccount() {
		name = JOptionPane.showInputDialog("Enter full name: ");
		accountData.add(name);
	}

	/*
	 * Displaying the account info
	 */
	public void accountPrint() {
		System.out.println("Name of account holder name is : " + name);
		System.out.println("Name of account holder ID is : " + id);
		System.out.println("Your last transaction was : " + withdrawal1);
		System.out.println("Current balance is : " + Balance);
	}

	/*
	 * Deposit money into account balance
	 */
	public void deposit() {
		Long amt;
		amt = Long.parseLong(JOptionPane.showInputDialog("Enter the amount you want to deposit: "));
		Balance += amt;
	}

	/*
	 * Withdrawn money from current balance
	 */
	public void withdrawn() {
		accountPrint();
		withdrawal1 = Long.parseLong(JOptionPane.showInputDialog("Enter the amount you want to withdrawn : "));

		if (Balance >= withdrawal1) {
			Balance = Balance - withdrawal1;
		} else {

			System.out.println(name + " you can not withdraw " + withdrawal1);
			System.out.println("your balance is: " + Balance);
		}
	}

	/*
	 * Delete account
	 */
	public void DeleteAccount() {
		String Name1 = JOptionPane.showInputDialog("Enter the account name you want to search: ");
		for (int i = 0; i < accountData.size(); i++) {
			if (Name1.equals(accountData.get(i))) {
				accountData.remove(i);
				System.out.println("Account got deleted");
				System.out.println(accountData);
			} else
				System.out.println("Account with this given name not found!!!!!");
		}
	}

	/*
	 * Adding multi accounts, deposit and withdrawn
	 */
	public void addMultiaccount() {
		long count = Long.parseLong(JOptionPane.showInputDialog("How many accounts you want to add : "));
		for (long i = 0; i < count; i++) {
			openAccount();
			deposit();
			withdrawn();
			balanceData.add(Balance);
			System.out.println("\nIndex number : [" + i + "]");
			accountPrint();
			System.out.println("\n***************************************************************");
			Balance = 0;
			withdrawal1 = null;
			id++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AcountTest acc = new AcountTest();

//		acc.openAccount();
//		acc.withdrawn();	
//		acc.accountPrint();
		acc.addMultiaccount();
//		acc.DeleteAccount();
//		acc.SerchAccountandAddmoney();

		/*
		 * display the data inside array
		 */
//		System.out.println("\n\n"+accountData);
//		System.out.println(balanceData);
//		for (int i = 0; i < accountData.size(); i++) {
//			System.out.println(accountData.get(i));
//			System.out.println(balanceData.get(i));
//		}
	}

}
