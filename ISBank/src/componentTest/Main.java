package componentTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import components.Account;
import components.Client;
import components.Credit;
import components.CurrentAccount;
import components.Debit;
import components.Flow;
import components.SavingsAccount;
import components.Transfer;
import components.ReadFiles;


public class Main {

	static ArrayList<Client> clients = new ArrayList<>();
	static ArrayList<Account> accounts = new ArrayList<>();
	static ArrayList<Flow> flows = new ArrayList<>();
	static boolean negativeBalance;
	static ArrayList<Account> accounts_negativeBalance = new ArrayList<>();
	

	public static void main(String[] args) {
		clients.add(new Client("Isabel", "Serna"));
		clients.add(new Client("Marta", "Jiménez"));
		clients.add(new Client("Sara", "García"));
		clients.add(new Client("Miguel", "Lopez"));
		clients.add(new Client("Andrés", "Márquez"));
		clients.add(new Client("Alejandro", "Diaz"));
		clients.add(new Client("Martina", "Romero"));

		System.out.println('\t' + "List of clients");
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

		System.out.println('\t' + "List of accounts");
		accounts.forEach(System.out::println);

		Hashtable<Integer, Account> accountsHt = new Hashtable<>();

		flows.add(new Debit("First Debit", "43KH", 50.0, accounts.get(0).getAccountNumber(), true, new Date()));
		

		for (Account account : accounts) { // To add 100 credit to currentAccounts and 1500 to savingAccounts
			int i = 0;
			if (account instanceof CurrentAccount) {
				flows.add(new Credit("First credit - Current Accounts", "2JM" + i, 100.5, account.getAccountNumber(), true,
						new Date()));
			} else if (account instanceof SavingsAccount) {
				flows.add(new Credit("Second Credit - Saving Accounts", "33SO" + i, 1500.0, account.getAccountNumber(), true,
						new Date()));
			}
			i++;
		}

		flows.add(new Transfer("First Transfer", "17JH", 50.0, accounts.get(1).getAccountNumber(), true, new Date(),
				accounts.get(0).getAccountNumber()));
	
					
		String in = ReadFiles.writeFileJson(flows);
		
		System.out.println(in);
		
		
		FlowDeserializer deserializer = new FlowDeserializer("Type");
	    deserializer.registerBarnType("Debit", Debit.class);
	    deserializer.registerBarnType("Credit", Credit.class);
	    deserializer.registerBarnType("Transfer", Transfer.class);
	    Gson gson = new GsonBuilder()
	      .registerTypeAdapter(Flow.class, deserializer)
	      .create();

	    List<Flow> outList = gson.fromJson(in, new TypeToken<List<Flow>>(){}.getType());
	    
	    System.out.println("asi?" +outList);
		
		for (int i = 0; i < accounts.size(); i++) { // To reload balance of all accounts
			for (int j = 0; j < flows.size(); j++) {
				if (accounts.get(i).getAccountNumber() == flows.get(j).getTargetAccountNumber()) {
					accounts.get(i).setBalance(accounts.get(i).getBalance(), flows.get(j));
				} else if (flows.get(j).getClass().getName().contains("Transfer")) {
					Transfer transfer = (Transfer) flows.get(j);
					if (accounts.get(i).getAccountNumber() == transfer.getAccountNumber()) {
						accounts.get(i).setBalance(accounts.get(i).getBalance(), transfer);
					}
				}
			}
		}

		Account.checkNegativeBalance(accounts);

		for (int i = 0; i < accounts.size(); i++) {
			accountsHt.put(accounts.get(i).getAccountNumber(), accounts.get(i));
		}
		
		System.out.println('\t' + "List of accounts in the Hashtable");
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
