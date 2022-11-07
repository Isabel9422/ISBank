package components;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Account {

	protected String Label;
	protected Double balance;
	protected static final AtomicInteger count = new AtomicInteger(0);
	protected final Integer accountNumber;
	protected Client client;

	public Account(String label, Client client) {
		this.Label = label;
		accountNumber = count.incrementAndGet();
		this.client = client;
		this.balance = 0.0;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance, Flow amount) {
		if (amount.getClass().getName().contains("Debit")) {
			this.balance = balance - amount.getAmount();
		} else if (amount.getClass().getName().contains("Credit")) {
			this.balance = balance + amount.getAmount();
		} else if (amount.getClass().getName().contains("Transfer")) {
			Transfer transfer = (Transfer) amount;

			if (transfer.getTargetAccountNumber() == this.accountNumber) {
				this.balance = balance + amount.getAmount();
			} else if (transfer.getAccountNumber() == this.accountNumber) {
				this.balance = balance - amount.getAmount();
			} else if (!(transfer.getTargetAccountNumber() == this.accountNumber)) {
				System.out.println("That account number does not exist.");
			}
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Account [Label=" + Label + ", balance=" + balance + ", accountNumber=" + accountNumber + ", client="
				+ client + this.getClass().getName() + "]";
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}
	
	public static void checkNegativeBalance(ArrayList<Account> accounts) {
		if (accounts.stream().anyMatch(e -> e.getBalance() < 0)) {
			System.out.println('\t' + "The following accounts have a negative balance:");
			accounts.stream().filter(e -> e.getBalance() < 0).map(e -> e).forEach(System.out::println);
		} else {
			System.out.println("There are no accounts with a negative balance");
		}
	}
}
