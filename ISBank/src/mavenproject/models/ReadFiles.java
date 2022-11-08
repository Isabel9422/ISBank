package mavenproject.models;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadFiles {

	public static String readFileJson() {
		File file = new File("assets\\flow.json");
		Path path = file.toPath();
		String jsonString="";

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			jsonString= Files.readString(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	   return jsonString;
	}
	
    public static ArrayList<Account> addAccountsFromXML() {
        ArrayList<Account> ac = new ArrayList<>();
    	try {
            XmlMapper xmlMapper = new XmlMapper();
            String readContent = new String(Files.readAllBytes(Paths.get("assets\\accounts.xml")));
            String[] items = readContent.split("<CurrentAccount>|<SavingsAccount>");
            
            for(String item: items) {
            	if(item.contains("CurrentAccount")) {
            		String[] balance = item.split("<balance>|</balance>");
            		String[] accountNumber= item.split("<accountNumber>|</accountNumber>");
            		String[] firstname= item.split("<accountNumber>|</accountNumber>");
            		String[] lastname= item.split("<lastname>|</lastname>");
            		String[] clientNumber= item.split("<clientNumber>|</clientNumber>");
            		String[] label= item.split("<label>|</label>");
            		
            		ac.add(new CurrentAccount(label[1],Integer.parseInt(accountNumber[1]),new Client(firstname[1],lastname[1],Integer.parseInt(clientNumber[1])),Double.parseDouble(balance[1])));
            	}else if(item.contains("SavingsAccount")) {
                		String[] balance = item.split("<balance>|</balance>");
                		String[] accountNumber= item.split("<accountNumber>|</accountNumber>");
                		String[] firstname= item.split("<accountNumber>|</accountNumber>");
                		String[] lastname= item.split("<lastname>|</lastname>");
                		String[] clientNumber= item.split("<clientNumber>|</clientNumber>");
                		String[] label= item.split("<label>|</label>");
                		
                	ac.add(new SavingsAccount(label[1],Integer.parseInt(accountNumber[1]),new Client(firstname[1],lastname[1],Integer.parseInt(clientNumber[1])),Double.parseDouble(balance[1])));
                	}
            }         		             
        } catch (IOException e) {
        }
		return ac;
    }
    
  public static void serializeToXML(ArrayList<Account> list) {

      try {
          XmlMapper.Builder builder = XmlMapper.builder().defaultUseWrapper(false);
          XmlMapper xmlMapper = builder.build();

          StringBuilder text = new StringBuilder();

          for (Account account : list) {
              text.append(xmlMapper.writeValueAsString(account));
          }
          System.out.println(text);

          File xmlOutput = new File("accounts.xml");
          FileWriter fileWriter = new FileWriter(xmlOutput);
          fileWriter.write(text.toString());
          fileWriter.close();
      } catch (JsonProcessingException e) {
          System.out.println(e.getMessage());
      } catch (IOException e) {
          System.out.println(e.getMessage());
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
}
}