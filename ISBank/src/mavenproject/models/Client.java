package mavenproject.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {

	private String firstname;
	private String lastname;
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int clientNumber;
	
	
	public Client(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		clientNumber = count.incrementAndGet();
	}
	
	public Client(String firstname, String lastname, Integer clientNumber) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.clientNumber = clientNumber;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getClientNumber() {
		return clientNumber;
	}
	
	@Override
	public String toString() {
		return "Client [firstname=" + firstname + ", lastname=" + lastname + ", clientNumber=" + clientNumber + "]";
	}


}
