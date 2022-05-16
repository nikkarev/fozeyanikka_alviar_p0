package presentation;

import java.util.List;
import java.util.Scanner;

import exception.SystemException;
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
					CustomerPojo newCustomer = new CustomerPojo();
					System.out.println("Please enter your First Name:");
					scan.nextLine();
					newCustomer.setCustomerFirstName(scan.nextLine());
					System.out.println("Please enter your Last name:");
					scan.nextLine();
					newCustomer.setCustomerLastName(scan.nextLine());
					System.out.println("Create your username:");
					scan.nextLine();
					newCustomer.setUsername(scan.nextLine());
					System.out.println("Create your password:");
					scan.nextLine();
					newCustomer.setPassword(scan.nextLine());
					
					AccountPojo newAccount = new AccountPojo();
					System.out.println("Please enter your initial balance:");
					newAccount.setBalance(scan.nextDouble());
					
					CustomerPojo customerPojo = null;
					AccountPojo accountPojo = null;
					try {
						customerPojo = customerService.createCustomer(newCustomer);
						accountPojo = accountService.createAccount(newAccount); 
					} catch (SystemException e) {
						System.out.println(e.getMessage());
						break;
					}
					
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
					System.out.println("5. Logout");
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
							break;
						
						// Withdraw
						case 3:
							AccountPojo withdrawPojo;
							
							System.out.println("Enter the Account ID:");
							int withdrawID = scan.nextInt();
							
							System.out.println("Enter the amount you want to withdraw:");
							double withdrawAmount = scan.nextDouble();
							depositPojo = accountService.deposit(withdrawID, withdrawAmount);
							withdrawPojo = accountService.withdraw(withdrawID, withdrawAmount);
							
							System.out.println("----------------------------------------");
							System.out.println("Congratulations! You have successfully withdrawn " +withdrawPojo.getAmount()+ "into Account ID: " +withdrawPojo.getAccountNumber());
							System.out.println("Your new balance is:" +withdrawPojo.getBalance());
							System.out.println("----------------------------------------");
							break;
							
						// View Balance
						case 4:
							List<AccountPojo> viewAllBalance;
							
							viewAllBalance = accountService.viewBalance();
							
							System.out.println("----------------------------------------");
							System.out.println("Balances: ");
							viewAllBalance.forEach((balance) -> System.out.println(balance.getBalance()));
							System.out.println("----------------------------------------");
							System.out.println("Would you like to go back to the main menu? (y/n)");
							choice = scan.next().charAt(0);
							break;
							
						// Delete Account
						case 5:
							System.out.println("Enter the Account ID you want to remove:");
							int accountId = scan.nextInt();
							
							AccountPojo getAccountPojo = null;
							CustomerPojo getCustomerPojo = null;
							
							// implement try-catch block
							getAccountPojo = accountService.getAccount(accountId);
							
							if(getAccountPojo == null) {
								System.out.println("----------------------------------------");
								System.out.println("The Account ID you entered does not exist. \nPlease enter a valid Account ID.");
								System.out.println("----------------------------------------");
								break; // why break?
							} else {
								System.out.println("----------------------------------------");
								System.out.println("Account to be removed: ");
								System.out.println("----------------------------------------");
								System.out.println("Account Number: " + getAccountPojo.getAccountNumber());
								System.out.println("Account Balance: " + getAccountPojo.getBalance());
								System.out.println("----------------------------------------");
								System.out.println("Do you want to proceed to delete this account? (y/n)");
								char answer = scan.next().charAt(0);
								System.out.println("----------------------------------------");
								if(answer == 'y') {
									
									// implement try-catch block
									accountService.deleteAccount(accountId);
									System.out.println("Account has been successfully removed.");
								} else {
									System.out.println("Account removal failed.");
								}
								System.out.println("----------------------------------------");
							}
							break;
						
						// Logout
						case 6: 
							System.out.println("----------------------------------------");
							System.out.println("Thank you for using our Banking Application System! \nHave a great day!");
							System.out.println("----------------------------------------");
							System.exit(0);
							break;

					}
					break;
					
					//Logout
					default:
						System.out.println("----------------------------------------");
						System.out.println("Thank you for using our Banking Application System! \nHave a great day!");
						System.out.println("----------------------------------------");
						System.exit(0);
						break;
			}
		}
		System.out.println("----------------------------------------");
		System.out.println("Thank you for using Banking Application System! \n Have a great day!");
		System.out.println("----------------------------------------");
		System.exit(0);
	}
}
