package stockaccount;

import java.util.*;
import javax.swing.JOptionPane;

interface stock1{
	public void openAccount();
	public void accountPrint();
	public void buyOrSellStock();
	public void addMultiDematAccount();
	public void serch();
}
public class Stock implements stock1 {

	static String name;
	static Integer id = 1;
	static double Balance = 5000, Sheartotal_Balance;
	private static double shearPrice, numberOfShares, numberOfStock, total_Balance;
	static long numofshearbuy;

	static ArrayList<String> stockNameArr = new ArrayList<>();
	static ArrayList<Double> shearPriceArr = new ArrayList<>();
	static ArrayList<Double> numberOfSharesArr = new ArrayList<>();

	static ArrayList<String> accountDemat = new ArrayList<>();
	static ArrayList<Double> balanceDemat = new ArrayList<>();
	static ArrayList<String> accountStock = new ArrayList<>();

//	static ArrayList<Integer> ID = new ArrayList<>();
	/*
	 * Taking inputs N number of Stocks, for Each Stock Read In the 1) Share Name,
	 * 2) Number of Share 3) Share Price
	 */
	public void stockdetails() {

		String stockName = JOptionPane.showInputDialog("Enter the stock name : ");
		stockNameArr.add(stockName);

		shearPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the one share price : "));
		shearPriceArr.add(shearPrice);

		numberOfShares = Double
				.parseDouble(JOptionPane.showInputDialog("Enter the number of shares to want to  buy or sell : "));
		numberOfSharesArr.add(numberOfShares);
	}

	/*
	 * Display the total stocks report
	 */
	public void stockReport() {
		/*
		 * Adding Nth number of stocks in array list
		 */
		numberOfStock = Double.parseDouble(JOptionPane.showInputDialog("Enter the number of stocks need to add :"));
		for (int i = 0; i < numberOfStock; i++) {
			// calling funtion
			stockdetails();
			total_Balance = numberOfSharesArr.get(i) * (1 * shearPriceArr.get(i));
			/*
			 * Displaying total report
			 * 
			 */
			System.out.println("Index number : " + i + "\n");
			System.out.println("Name of the stock is :" + stockNameArr.get(i));
			System.out.println("The stock price for " + 1 + " share  :" + (1 * shearPriceArr.get(i)));
			System.out.println("For " + numberOfSharesArr.get(i) + " shear, The  total stock price is :" + total_Balance
					+ "\n\n****************************************************");
		}
	}

	/*
	 * Open the account
	 */
	public void openAccount() {
		name = JOptionPane.showInputDialog("Enter full name: ");
		accountDemat.add(name);
	}

	/*
	 * Displaying the account info
	 */
	public void accountPrint() {
		System.out.println("Name of account holder name is : " + name);
		System.out.println("Name of account holder ID is : " + id);
		System.out.println("buying the stock : " + Sheartotal_Balance);
		System.out.println("Current balance is : " + Balance);
	}

	/*
	 * BUY and SELL from current balance
	 */
	public void buyOrSellStock() {
//		accountPrint();
		String StockNmae1 = JOptionPane.showInputDialog("Select the stocks given below : \n" + stockNameArr.get(0)
				+ " one share value is : " + shearPriceArr.get(0) + "\n" + stockNameArr.get(1)
				+ " one share value is : " + shearPriceArr.get(1));

		for (int i = 0; i < stockNameArr.size(); i++) {
			if (StockNmae1.equals(stockNameArr.get(i))) {

				numofshearbuy = Long
						.parseLong(JOptionPane.showInputDialog("Enter the shear you want to buy or sell : "));
				Sheartotal_Balance = numofshearbuy * (1 * shearPriceArr.get(i));

				String n = JOptionPane.showInputDialog("Would you like to BUY or SELL ?");
				if (n.equals("BUY")) {
					if (Balance >= Sheartotal_Balance) {

						Balance -= Sheartotal_Balance;
						accountStock.add(stockNameArr.get(i));
						System.out.println("You have buyed " + stockNameArr.get(i) + "stock");

					} else {
						System.out.println("\n***********************************\n" + name
								+ " you can not buy shear of : " + Sheartotal_Balance);
						System.out.println("your balance is: " + Balance);
					}
				} else if (n.equals("SELL")) {

					Balance += Sheartotal_Balance;
					System.out.println("You have Selled " + stockNameArr.get(i) + "stock");

				} else
					System.out.println("You did not buyed any stocks");
			} // end of 1st if condtion
		} // end of for loop

	}

	/*
	 * Add Multi Account
	 */
	public void addMultiDematAccount() {
		long count = Long.parseLong(JOptionPane.showInputDialog("How many demat accounts you want to SignUp : "));
		for (long i = 0; i < count; i++) {
			openAccount();
			buyOrSellStock();
			balanceDemat.add(Balance);
			System.out.println("\nIndex number : [" + i + "]");
			accountPrint();
			System.out.println("\n***************************************************************");
			Balance = 5000;
			id++;
		}
	}

	public void serch(String name) {
		 for (int i = 0; i < stockNameArr.size(); i++) {  
		if (stockNameArr.get(i).equals(name)) {  
			accountPrint();   
        }else 
        	System.out.println("not found");
	}
	}
	@Override
	public void serch() {
		// TODO Auto-generated method stub
		serch();
	}
	/*
	 * main
	 */
	public static void main(String[] args) {
		// creating an object
		Stock stock = new Stock();
		stock.stockReport();
		stock.addMultiDematAccount();
//		stock.serch("a");

//		System.out.println(stockNameArr);
//		System.out.println(shearPriceArr);
//		System.out.println(numberOfSharesArr);
//		System.out.println(accountDemat);
//		System.out.println(balanceDemat);
//		System.out.println(accountStock);

	}

	
}
