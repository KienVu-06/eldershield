package main;

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
}
