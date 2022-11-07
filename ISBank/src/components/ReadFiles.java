package components;

import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReadFiles {

	public static String readFileJson() {

		File file = new File("src\\componentTest\\flow.json");
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
	
	public static String readFileXML() {

		File file = new File("src\\componentTest\\flow.xml");
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
}