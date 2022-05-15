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
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("-----------------------------------------");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			System.out.println("----------------------------------------");
			
			switch(option) {
				case 1:
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
					
					System.out.println("----------------------------------------");
					System.out.println("Congratulations! Account successfully created! \nYour CustomerID is: " + customerPojo.getCustomerId());
					System.out.println("----------------------------------------");
					break;
					
//				case 2:
			}
		}
		System.out.println("----------------------------------------");
		System.out.println("Thank you for using Banking Application System! \n Have a great day!");
		System.out.println("----------------------------------------");
		System.exit(0);
	}
}
