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
			System.out.println("1. Register New User");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("-----------------------------------------");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			System.out.println("----------------------------------------");
			
			switch(option) {
				// Register New User Account
				case 1:
					CustomerPojo newCustomerPojo = new CustomerPojo();
					
					System.out.println("Enter your First Name: ");
					scan.nextLine();
					newCustomerPojo.setFirstName(scan.nextLine());
					
					System.out.println("Enter your Last Name: ");
					newCustomerPojo.setLastName(scan.nextLine());
					
					System.out.println("Enter your Username: ");
					newCustomerPojo.setUsername(scan.nextLine());
					
					System.out.println("Create your password:");
					newCustomerPojo.setPassword(scan.nextLine());
					
					CustomerPojo customerPojo = null;
					try {
						customerPojo = customerService.createCustomer(newCustomerPojo);
					} catch (SystemException e) {
						System.out.println(e.getMessage());
						break;
					}
					
					System.out.println("----------------------------------------");
					System.out.println("Welcome " + customerPojo.getFirstName() + " " + customerPojo.getLastName() + "!");
					System.out.println("Customer Account successfully created! \nYour Customer ID is: " + customerPojo.getCustomerId());
					System.out.println("----------------------------------------");
					break;
					
				// Login	
				case 2:
					CustomerPojo customerLoginPojo = new CustomerPojo();
					
					System.out.println("Enter your Username: ");
					scan.nextLine();
					customerLoginPojo.setUsername(scan.nextLine());
					
					System.out.println("Enter password:");
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
					
					int returningCustomerId = returningCustomer.getCustomerId();
					
					if(returningCustomerId == 0) {
						System.out.println("Username or password is incorrect. Please enter a valid username or password.");
						break;
					} else {
						System.out.println("----------------------------------------");
						System.out.println("You have successfully Login!");
						System.out.println("----------------------------------------");
					}
					
					char pick = 'y';
					while(pick == 'y') {
						System.out.println("Choose a Menu");
						System.out.println("----------------------------------------");
						System.out.println("1. Register New Account");
						System.out.println("2. Deposit");
						System.out.println("3. Withdraw");
						System.out.println("4. View Balance");
						System.out.println("5. Logout");
						System.out.println("----------------------------------------");
						System.out.println("Please enter your option:");
						int choice = scan.nextInt();
						System.out.println("----------------------------------------");
						
						switch(choice) {
							// Register New Account
							case 1:
								AccountPojo newAccountPojo = new AccountPojo();
								
								System.out.println("Enter your Initial Balance: ");
								newAccountPojo.setBalance(scan.nextDouble());
								
								AccountPojo accountPojo;
								try {
									accountPojo = accountService.createAccount(newAccountPojo, returningCustomerId);
								} catch(SystemException e) {
									System.out.println(e.getMessage());
									e.printStackTrace();
									break;
								}
								System.out.println("----------------------------------------");
								System.out.println("Congratulations! Account successfully created! \nYour Account ID is: " + accountPojo.getAccountId());
								System.out.println("Your Initial Balance is: $" + accountPojo.getBalance());
								System.out.println("----------------------------------------");
								
								System.out.println("Would you like to go back to the main menu? (y/n)");
								pick = scan.next().charAt(0);
								
								if(pick == 'n') {
									System.out.println("----------------------------------------");
									System.out.println("Thank you for using our Banking Application System! \nHave a great day!");
									System.out.println("----------------------------------------");
									System.exit(0);
								}
								
								break;
							
							// Deposit
							case 2:
								AccountPojo depositPojo = new AccountPojo();	
								
								System.out.println("Enter the Account ID you want to deposit funds into: ");
								int accountIdInput = scan.nextInt();
								depositPojo.setAccountId(accountIdInput);
															
								try {
									depositPojo = accountService.viewBalance(depositPojo);
								} catch (SystemException e) {
									System.out.println(e.getMessage());
									break;
								}
								
								System.out.println("Enter the amount you want to deposit:");
								double depositAmount = scan.nextDouble();
								
								double newBalance = depositPojo.getBalance() + depositAmount;
								depositPojo.setBalance(newBalance);

								try {
									accountService.deposit(depositPojo);
								} catch (SystemException e2) {
									System.out.println(e2.getMessage());
									break;
								}

								System.out.println("----------------------------------------");
								System.out.println("Congratulations! \nYou have successfully deposited $" + depositAmount + " into Account ID: " +depositPojo.getAccountId());
								System.out.println("Your new balance is: $" + depositPojo.getBalance());
								System.out.println("----------------------------------------");
								System.out.println("----------------------------------------");	
								System.out.println("Would you like to go back to the main menu? (y/n)");
								pick = scan.next().charAt(0);
								if(pick == 'n') {
									System.out.println("----------------------------------------");
									System.out.println("Thank you for using our Banking Application System! \nHave a great day!");
									System.out.println("----------------------------------------");
									System.exit(0);
								}
								
								break;
							
							// Withdraw
							case 3:
								AccountPojo withdrawPojo = new AccountPojo();
								
								System.out.println("Enter the Account ID you want to withdraw funds from: ");
								int withdrawalAccountId = scan.nextInt();
								withdrawPojo.setAccountId(withdrawalAccountId);
								
								try {
									withdrawPojo = accountService.viewBalance(withdrawPojo);
								} catch (SystemException e) {
									System.out.println(e.getMessage());
									break;
								}
								
								System.out.println("Enter the amount you want to withdraw:");
								double withdrawalAmount = scan.nextDouble();
								
								if( withdrawalAmount > withdrawPojo.getBalance() ) {
									System.out.println("You do not have enough funds for this withdrawal. \nPlease try again.");
									break;
								} else {
									double updatedBalance = withdrawPojo.getBalance() - withdrawalAmount;
									withdrawPojo.setBalance(updatedBalance);

									try {
										accountService.withdraw(withdrawPojo);
									} catch (SystemException e) {
										System.out.println(e.getMessage());
										break;
									} catch (FundNotEnoughException e) {
										System.out.println(e.getMessage());
										break;
									}
									System.out.println("----------------------------------------");
									System.out.println("Congratulations! \nYou have successfully withdrawn $" + withdrawalAmount + " from Account ID: " +withdrawPojo.getAccountId());
									System.out.println("Your new balance is: $" + withdrawPojo.getBalance());
									System.out.println("----------------------------------------");	
									System.out.println("----------------------------------------");	
									System.out.println("Would you like to go back to the main menu? (y/n)");
									pick = scan.next().charAt(0);
									if(pick == 'n') {
										System.out.println("----------------------------------------");
										System.out.println("Thank you for using our Banking Application System! \nHave a great day!");
										System.out.println("----------------------------------------");
										System.exit(0);
									}
									break;
								}

								
							// View Balance
							case 4:
								AccountPojo returningAccountPojo = new AccountPojo();
								AccountPojo viewAllBalance = null;
								
								System.out.println("Enter the Account ID you want to view the balance of: ");
								scan.nextLine();
								returningAccountPojo.setAccountId(scan.nextInt());
								
								try {
									viewAllBalance = accountService.viewBalance(returningAccountPojo);
									
									if(viewAllBalance == null) {
										System.out.println("No records to show.");
									} else {
										System.out.println("Your balance is: $" +viewAllBalance.getBalance());
										System.out.println("----------------------------------------");
										System.out.println("Would you like to go back to the main menu? (y/n)");
										pick = scan.next().charAt(0);
										
										if(pick == 'n') {
											System.out.println("----------------------------------------");
											System.out.println("Thank you for using our Banking Application System! \nHave a great day!");
											System.out.println("----------------------------------------");
											System.exit(0);
										}
										break;
									}
								} catch (SystemException e1) {
									System.out.println(e1.getMessage());
									break;
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
