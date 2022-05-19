package presentation;

import java.util.List;
import java.util.Scanner;

import exception.FundNotEnoughException;
import exception.LoginFailedException;
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
		
		char proceed = 'y';
		
		while(proceed == 'y') {
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
					CustomerPojo newCustomerPojo = new CustomerPojo();
					System.out.println("Create your password:");
					scan.nextLine();
					newCustomerPojo.setPassword(scan.nextLine());
					
					AccountPojo newAccountPojo = new AccountPojo();
					System.out.println("Please enter your initial balance:");
					newAccountPojo.setBalance(scan.nextDouble());
					
					CustomerPojo customerPojo = null;
					AccountPojo accountPojo = null;
					try {
						customerPojo = customerService.createCustomer(newCustomerPojo);
						accountPojo = accountService.createAccount(newAccountPojo); 
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
					AccountPojo returningAccountPojo = new AccountPojo();
					
					System.out.println("Enter your Customer ID: ");
					customerLoginPojo.setCustomerId(scan.nextInt());
					
					System.out.println("Enter password:");
					scan.nextLine();
					customerLoginPojo.setPassword(scan.nextLine());
					
					CustomerPojo returningCustomer = null;
					try {
						returningCustomer = customerService.customerLogin(customerLoginPojo);
					} catch (SystemException e2) {
						e2.printStackTrace();
						System.out.println(e2.getMessage());
						break;
					} catch (LoginFailedException e2) {
						e2.printStackTrace();
						System.out.println(e2.getMessage());
						break;
					}
					
					int returningUserId = returningCustomer.getCustomerId();
					
					if(returningUserId == 0) {
						System.out.println("Username or password is incorrect. Please enter a valid username or password.");
						break;
					} else {
						returningAccountPojo.setAccountNumber(returningUserId);
						
						System.out.println("----------------------------------------");
						System.out.println("Choose a menu");
						System.out.println("----------------------------------------");
						System.out.println("1. Register New User");
						System.out.println("2. Deposit");
						System.out.println("3. Withdraw");
						System.out.println("4. View Balance");
						System.out.println("5. Logout");
						System.out.println("----------------------------------------");
						System.out.println("Please enter your option:");
						int choice = scan.nextInt();
						System.out.println("----------------------------------------");
						
						switch(choice) {
							// Register new user
							case 1:
								newCustomerPojo = new CustomerPojo();
								
								System.out.println("Enter your Customer ID: :");
								scan.nextInt();
								customerLoginPojo.setCustomerId(scan.nextInt());;
								
								System.out.println("Enter password:");
								scan.nextLine();
								customerLoginPojo.setPassword(scan.nextLine());
								
								try {
									customerPojo = customerService.createCustomer(newCustomerPojo);
								} catch(SystemException e) {
									System.out.println(e.getMessage());
									break;
								}
								System.out.println("----------------------------------------");
								System.out.println("Congratulations! Account successfully created! \nYour CustomerID is: " + customerPojo.getCustomerId());
								System.out.println("----------------------------------------");
								System.out.println("Your Customer ID is: " +customerPojo.getCustomerId());
								break;
							
							// Deposit
							case 2:
								AccountPojo depositPojo = new AccountPojo();	
								
								System.out.println("Enter the Account ID you want to deposit funds into: ");
								int accountIdInput = scan.nextInt();
								depositPojo.setAccountNumber(accountIdInput);
								
								System.out.println("Enter the amount you want to deposit:");
								double depositAmount = scan.nextDouble();
															
								try {
									depositPojo = accountService.deposit(depositPojo);
								} catch (SystemException e) {
									e.printStackTrace();
									System.out.println(e.getMessage());
									break;
								}
								
								double newBalance = depositPojo.getBalance() + depositAmount;
								depositPojo.setBalance(newBalance);
								
								System.out.println("----------------------------------------");
								System.out.println("Congratulations! You have successfully deposited " + depositAmount + " into Account ID: " +depositPojo.getAccountNumber());
								System.out.println("Your new balance is:" + depositPojo.getBalance());
								System.out.println("----------------------------------------");
								break;
							
							// Withdraw
							case 3:
								AccountPojo withdrawPojoTemp = new AccountPojo();
								
								withdrawPojoTemp.setAccountNumber(returningUserId);
								
								System.out.println("Enter the amount you want to withdraw:");
								double withdrawalAmount = scan.nextDouble();
								
								AccountPojo withdrawPojo = null;
								try {
									withdrawPojo = accountService.withdraw(withdrawPojoTemp, withdrawalAmount);
								} catch (FundNotEnoughException e) {
									e.printStackTrace();
									System.out.println(e.getMessage());
								} catch (SystemException e) {
									e.printStackTrace();
									System.out.println(e.getMessage());
									break;
								}

								System.out.println("----------------------------------------");
								System.out.println("Congratulations! You have successfully withdrawn $" + withdrawalAmount );
								System.out.println("Your new balance is: " + withdrawPojo.getBalance());
								System.out.println("----------------------------------------");
								break;
								
							// View Balance
							case 4:
								AccountPojo viewAllBalance = null;
								
							try {
								viewAllBalance = accountService.viewBalance(returningAccountPojo);
								
								System.out.println("----------------------------------------");
								System.out.println("Balances: ");
								
								if(viewAllBalance == null) {
									System.out.println("No records to show.");
								} else {
									System.out.println(viewAllBalance.getBalance());
									System.out.println("----------------------------------------");
									System.out.println("Would you like to go back to the main menu? (y/n)");
									choice = scan.next().charAt(0);
									break;
								}
								
							} catch (SystemException e1) {
								e1.printStackTrace();
								System.out.println(e1.getMessage());
							}
							
							// Logout
							case 5: 
								System.out.println("----------------------------------------");
								System.out.println("Thank you for using our Banking Application System! \nHave a great day!");
								System.out.println("----------------------------------------");
								System.exit(0);
								break;

						}
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
