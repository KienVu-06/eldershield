package model;

public class BankAccount {
	private String accountNumber;
	private String owner;
	private double balance;
	public static final double THE_MINIMUM_BALANCE = 50000;
	public static final double THE_FEE = 0.02;
	public BankAccount(String accountNumber, String owner, double balance) {
		if(owner.trim().isEmpty()) {
			throw new IllegalArgumentException("owner is not valid");
		}
		if(balance < THE_MINIMUM_BALANCE) {
			throw new IllegalArgumentException("balance is not valid");
		}
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
		System.out.println("The new account is created successfully. The account number is " + accountNumber + " of the owner " + owner + " with the initial balance " + balance);
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getOwner() {
		return owner;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		if(amount <= 0) {
			System.out.println("the deposit operation is fail");
		}
		else {
			balance += amount;
		}
	}
	public void withdraw(double amount) {
		if(amount <= 0 || balance - amount < THE_MINIMUM_BALANCE) {
			System.out.println("The withdraw operation is faill");
		}
		else {
			balance -= amount;
		}
	}
	public void transferMoney(double amount, BankAccount receiver) {
		if(receiver == null) {
			System.out.println("The receiver is not exist. The transfer operation is fail");
			return ;
		}
		if (amount <= 0 || balance - amount - THE_FEE*amount < THE_MINIMUM_BALANCE ) {
			System.out.println("The transfer operation is fail");
		}
		else {
			balance -= (amount + THE_FEE*amount);
			receiver.balance += amount;
			System.out.println("The account number " + accountNumber + " of the owner " + owner + " transfer " + amount + " for the account number " + receiver.accountNumber + " of the owner " + receiver.owner);
			System.out.println("The current balance of the account number " + accountNumber + " of the owner " + owner + " is " + balance);
			System.out.println("The current balance of the account number " + receiver.accountNumber + " of the owner " + receiver.owner + " is " + receiver.balance);
		}
	}
	public void payBill(double amount, String nameBill) {
		if(nameBill.trim().isEmpty() || amount <= 0 || balance - amount < THE_MINIMUM_BALANCE) {
			System.out.println("The pay bills operation is fail");
		}
		else {
			balance -= amount;
			System.out.println("The bill " + nameBill + " is paid successfully." + " The current balance is " + balance);
		}
	}
}