package com.banking.BankingApp;

import com.banking.BankingApp.exception.AccountNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;
@Slf4j
@SpringBootApplication
public class BankingAppApplication
{

	public static void main(String[] args) throws AccountNotFoundException {
		ApplicationContext context = SpringApplication.run(BankingAppApplication.class, args);

		/*BankAccount bankAccount = context.getBean(BankAccount.class);
		AccountsService service = context.getBean(AccountsService.class);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your account number");
		int accountNumber = Integer.parseInt(sc.nextLine()); // parsing string to integer.
		System.out.println("Enter the desired option");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. View the account balance");
		System.out.println("4. Transfer to another account");
		int option = Integer.parseInt(sc.nextLine());
		switch (option) {
			case 1:
			{
				System.out.println("Enter amount to Deposit");
				double amount = Double.parseDouble(sc.nextLine()); // parsing string to double.
				Double amountAfterDeposit = service.deposit(amount, accountNumber);
				if(amountAfterDeposit != null)
					System.out.println("Your Balance after Deposit is: " + amountAfterDeposit);
				else
					System.out.println("Some error occurred. Try again later");
				break;
			}
			case 2:
			{
				System.out.println("Enter amount to Withdraw");
				double amount = Double.parseDouble(sc.nextLine()); // parsing string to double.
				System.out.println("Your Balance after Withdrawal is: " + service.withdraw(amount, accountNumber));
				break;
			}

			case 3:
			{
				service.printBalance(accountNumber);
				break;
			}
			case 4:
			{
				System.out.println("Enter amount to Transfer");
				double amount = Double.parseDouble(sc.nextLine());
				System.out.println("Enter account number you want to transfer to");
				int otherAccountNumber = Integer.parseInt(sc.nextLine());
				System.out.println("Your Balance after Transfer is: " + service.transfer(amount, accountNumber, otherAccountNumber));
				break;
			}
			default:
				System.out.println("This option does not exist");
		}

		System.exit(0);*/
	}

}
