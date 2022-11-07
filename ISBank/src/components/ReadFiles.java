package components;

import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.Window.Type;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadFiles {

	public static String writeFileJson(ArrayList<Flow> flows) {		
		
		File file = new File("src\\componentTest\\flow.json");
		
        if (!file.exists()) { try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}}
		        
		Gson gson = new Gson();
				
	    String jsonString = new Gson().toJson(flows);
        
        return jsonString;
	}

//	public static void readFileJson(ArrayList<Flow> flows) {
//
//		File file = new File("src\\componentTest\\flow.json");
//
//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		}
//
//		Gson gson = new Gson();
//
//		try (Reader reader = new FileReader("C:\\Users\\isabe\\git\\repository\\ISBank\\staff.json")) {
//
//			// Convert JSON File to Java Object
//			Flow transfer = gson.fromJson(reader, Flow.class);
//
//			// print staff
//			System.out.println(" aqui estas : " + transfer);
//			flows.add(transfer);
//			System.out.println("OBJETO AÑADIDO" + flows.get(0).toString());
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}