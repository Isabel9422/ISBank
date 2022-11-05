package componentTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map.Entry;

import components.Account;
import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;

public class Main {

	static ArrayList<Client> clients = new ArrayList<>();
	static ArrayList<Account> accounts = new ArrayList<>();

	public static void main(String[] args) {
		clients.add(new Client("Isabel", "Serna"));
		clients.add(new Client("Marta", "Jiménez"));
		clients.add(new Client("Sara", "García"));
		clients.add(new Client("Miguel", "Lopez"));
		clients.add(new Client("Andrés", "Márquez"));
		clients.add(new Client("Alejandro", "Diaz"));
		clients.add(new Client("Martina", "Romero"));

		System.out.println("List of clients");
		clients.forEach(System.out::println);

		accounts.add(new CurrentAccount("general", clients.get(0)));
		accounts.add(new SavingsAccount("general", clients.get(0)));
		accounts.add(new CurrentAccount("individual_tax_advantaged", clients.get(1)));
		accounts.add(new SavingsAccount("general", clients.get(1)));
		accounts.add(new CurrentAccount("general", clients.get(2)));
		accounts.add(new SavingsAccount("individual_tax_advantaged", clients.get(2)));
		accounts.add(new CurrentAccount("individual_tax_advantaged", clients.get(3)));
		accounts.add(new SavingsAccount("general", clients.get(3)));
		accounts.add(new CurrentAccount("individual_tax_advantaged", clients.get(4)));
		accounts.add(new SavingsAccount("general", clients.get(4)));
		accounts.add(new CurrentAccount("individual_tax_advantaged", clients.get(5)));
		accounts.add(new SavingsAccount("general", clients.get(5)));
		accounts.add(new CurrentAccount("individual_tax_advantaged", clients.get(6)));
		accounts.add(new SavingsAccount("general", clients.get(6)));

		System.out.println("List of accounts");
		accounts.forEach(System.out::println);

		Hashtable<Integer, Account> accountsHt = new Hashtable<>();

		for (int i = 0; i < accounts.size(); i++) {
			accountsHt.put(accounts.get(i).getAccountNumber(), accounts.get(i));
		}
		accountsHt.entrySet().stream().sorted(new Comparator<Entry<Integer, Account>>() {

			@Override
			public int compare(Entry<Integer, Account> a1, Entry<Integer, Account> a2) {
				if (a1.getValue().getBalance() < a2.getValue().getBalance()) {
					return -1;
				} else if (a1.getValue().getBalance() > a2.getValue().getBalance()) {
					return 1;
				} else {
					return 0;
				}
			}

		}).forEach((entry) -> System.out.println(entry.toString()));

	}

}
