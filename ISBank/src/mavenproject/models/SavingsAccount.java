package mavenproject.models;

public class SavingsAccount extends Account{

	public SavingsAccount(String label, Client client) {
		super(label, client);
	}
	
	public SavingsAccount(String label, Integer accountNumber, Client client, Double balance) {
		super(label, accountNumber, client, balance);
	}

}
