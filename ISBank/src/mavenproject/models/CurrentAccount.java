package mavenproject.models;

public class CurrentAccount extends Account{

	public CurrentAccount(String label, Client client) {
		super(label, client);
	}
	
	public CurrentAccount(String label, Integer accountNumber, Client client, Double balance) {
		super(label, accountNumber, client, balance);
	}
}
