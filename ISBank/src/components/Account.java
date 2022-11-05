package components;

import java.util.Random;
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
		balance = new Random().nextDouble();
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

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}
}
