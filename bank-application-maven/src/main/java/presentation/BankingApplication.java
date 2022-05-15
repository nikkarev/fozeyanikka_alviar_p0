package presentation;

import java.util.Scanner;

import model.AccountPojo;
import model.CustomerPojo;
import service.AccountService;
import service.AccountServiceImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

public class BankingApplication {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		AccountService accountService = new AccountServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();
		
		String proceed = "yes";
		 
		
		while(proceed == "yes" || proceed == "y") {
			System.out.println("----------------------------------------");
			System.out.println("BANKING APPLICATION SYSTEM");
			System.out.println("-----------------------------------------");
			System.out.println("1. Register New Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("-----------------------------------------");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			System.out.println("----------------------------------------");
			
			switch(option) {
				// Register New Account
				case 1:
					AccountPojo newAccount = new AccountPojo();
					System.out.println("Please enter your initial balance:");
					newAccount.setBalance(scan.nextDouble());
					
					CustomerPojo newCustomer = new CustomerPojo();
					System.out.println("Please enter your First Name:");
					scan.nextLine();
					newCustomer.setCustomerFirstName(scan.nextLine());
					
					System.out.println("Please enter your last name:");
					scan.nextLine();
					newCustomer.setCustomerLastName(scan.nextLine());
					
					System.out.println("Create your username:");
					scan.nextLine();
					newCustomer.setUsername(scan.nextLine());
					
					System.out.println("Create your password:");
					scan.nextLine();
					newCustomer.setPassword(scan.nextLine());
					
					// might throw an exception
					CustomerPojo customerPojo = customerService.createCustomer(newCustomer);
					AccountPojo accountPojo = accountService.createAccount(newAccount);
					
					System.out.println("----------------------------------------");
					System.out.println("Congratulations! Account successfully created! \nYour CustomerID is: " + customerPojo.getCustomerId());
					System.out.println("----------------------------------------");
					System.out.println("Your Account ID is :" +accountPojo.getAccountNumber());
					System.out.println("Your Customer ID is: " +customerPojo.getCustomerId());
					break;
					
				// Login	
				case 2:
					CustomerPojo customerLoginPojo = new CustomerPojo();
					
					System.out.println("----------------------------------------");
					System.out.println("Choose a menu");
					System.out.println("----------------------------------------");
					System.out.println("1. Register new user");
					System.out.println("2. Deposit");
					System.out.println("3. Withdraw");
					System.out.println("4. View Balance");
					System.out.println("5. Delete Account");
					System.out.println("6. Logout");
					System.out.println("----------------------------------------");
					System.out.println("Enter your choice:");
					int choice = Integer.parseInt(scan.nextLine());
					System.out.println("----------------------------------------");
					
					switch(choice) {
						// Register new user
						case 1:
							newCustomer = new CustomerPojo();
							System.out.println("Please enter your First Name:");
							scan.nextLine();
							newCustomer.setCustomerFirstName(scan.nextLine());
							
							System.out.println("Please enter your last name:");
							scan.nextLine();
							newCustomer.setCustomerLastName(scan.nextLine());
							
							System.out.println("Create your username:");
							scan.nextLine();
							newCustomer.setUsername(scan.nextLine());
							
							System.out.println("Create your password:");
							scan.nextLine();
							newCustomer.setPassword(scan.nextLine());
							
							// might throw an exception
							customerPojo = customerService.createCustomer(newCustomer);
							
							System.out.println("----------------------------------------");
							System.out.println("Congratulations! Account successfully created! \nYour CustomerID is: " + customerPojo.getCustomerId());
							System.out.println("----------------------------------------");
							System.out.println("Your Customer ID is: " +customerPojo.getCustomerId());
							break;
						
						// Deposit
						case 2:
							AccountPojo depositPojo;
							
							System.out.println("Enter the Account ID:");
							int depositId = scan.nextInt();
							
							System.out.println("Enter the amount you want to deposit:");
							double depositAmount = scan.nextDouble();
							depositPojo = accountService.deposit(depositId, depositAmount);
							
							System.out.println("----------------------------------------");
							System.out.println("Congratulations! You have successfully deposited " +depositPojo.getAmount()+ "into Account ID: " +depositPojo.getAccountNumber());
							System.out.println("Your new balance is:" +depositPojo.getBalance());
							System.out.println("----------------------------------------");
					}
					break;
			}
		}
		System.out.println("----------------------------------------");
		System.out.println("Thank you for using Banking Application System! \n Have a great day!");
		System.out.println("----------------------------------------");
		System.exit(0);
	}
}
