package bankManagement;

import java.util.Scanner;

public class BankAccount {

	int balance;
	int previoustransaction;
	String customername;
	String customerID;

	// Constructor Creation
	BankAccount(String customerName, String customID) {
		customername = customerName;
		customerID = customID;
	}

	// Deposit Method
	void deposit(int amount) {
		balance = balance + amount;
		previoustransaction = amount;
	}

	// Withdraw Method
	void withdrawn(int amount) {
		balance = balance - amount;
		previoustransaction = -amount;
	}

	// Method to get a Previous Transactions
	void getprevioustransaction() {
		if (previoustransaction > 0) {
			System.out.println("Credited :" + previoustransaction);
		} else if (previoustransaction < 0) {
			System.out.println("Debited :" + Math.abs(previoustransaction));
		} else {
			System.out.println("No Transactions");
		}
	}

	void showmenu() {

		int option;
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome " + customername);
		System.out.println("Your ID is :" + customerID);
		System.out.println("\n");
		System.out.println("1. Check Balance");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Deposit Amount");
		System.out.println("4. Previous Transactions");
		System.out.println("5. Exit");
		do {
			System.out.println("=====================================================");
			System.out.println(
					"Enter the option (1-Check Balance,2-Withdraw Amount,3-Deposit Amount,4-Previous Transactions,5-Exit:");
			System.out.println("=====================================================");
			option = scn.nextInt();
			System.out.println("\n");
			switch (option) {
			case 1:
				System.out.println("======================================================");
				System.out.println("Balance:  " + balance);
				System.out.println("======================================================");
				System.out.println("\n");
				break;
			case 2:
				System.out.println("======================================================");
				System.out.println("Enter the amount to withdraw:");
				int amount = scn.nextInt();
				withdrawn(amount);
				System.out.println("\n");
				break;
			case 3:
				System.out.println("======================================================");
				System.out.println("Enter the amount to deposit :");
				int amount1 = scn.nextInt();
				deposit(amount1);
				System.out.println("\n");
				break;
			case 4:
				System.out.println("======================================================");
				System.out.println("Your previous transaction is :");
				getprevioustransaction();
				break;
			case 5:
				System.out.println("******************************************************");
				break;
			default:
				System.out.println("Invalid option... Please try again!");
				break;
			}
		} while (option != 5);
		System.out.println("Thank you! Have a great day!");
		scn.close();
	}
}
