package componentTest;

import java.util.ArrayList;

import components.Client;

public class ClientTest {
	
	static ArrayList<Client> clients = new ArrayList<>();

	public static void main(String[] args) {
		clients.add(new Client("Isabel", "Serna"));
		clients.add(new Client("Marta", "Jiménez"));
		clients.add(new Client("Sara", "García"));
		clients.add(new Client("Miguel", "Lopez"));
		clients.add(new Client("Andrés", "Márquez"));
		clients.add(new Client("Alejandro", "Diaz"));
		clients.add(new Client("Martina", "Romero"));
		
		clients.forEach(System.out::println);
		
	}
}
