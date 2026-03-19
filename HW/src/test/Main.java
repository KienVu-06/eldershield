package test;
import model.BankAccount;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount ac1 = null;
		try {
			ac1 = new BankAccount("090", " ", 100000);
		}
		catch (IllegalArgumentException x) {
			System.out.println("The account can not be created since " + x.getMessage());
		}
		if(ac1 != null) {
			ac1.deposit(50000);
		}
		
		BankAccount ac2 = null;
		try {
			ac2 = new BankAccount("091", "Hong", 50000);
		}
		catch(IllegalArgumentException x){
			System.out.println("The account can not be created since " + x.getMessage());
		}
		BankAccount ac3 = null;
		try {
			ac3 = new BankAccount("092", "Nam", 100000);
		}
		catch(IllegalArgumentException x){
			System.out.println("The account can not be created since " + x.getMessage());
		}
		if(ac2 != null) {
			ac2.deposit(50000);
			System.out.println("The current balance of the account with the number " + ac2.getAccountNumber() + " is " + ac2.getBalance());
		}
		ac2.transferMoney(10000, ac3);
		ac2.transferMoney(5000, ac1);
		ac3.transferMoney(0, ac2);
	}

}
