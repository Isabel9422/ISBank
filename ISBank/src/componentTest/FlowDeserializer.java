package componentTest;

import java.awt.Window.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import components.Flow;

public class FlowDeserializer implements JsonDeserializer<Flow>{
	
    private String flowTypeName;
    private Gson gson;
    private Map<String, Class<? extends Flow>> flowType;
    
	    public FlowDeserializer(String flowTypeName) {
		this.flowTypeName = flowTypeName;
		this.gson = new Gson();
		this.flowType = new HashMap<>();;
	}

		public void registerBarnType(String flowTyName, Class<? extends Flow> FlowType) {
	    	flowType.put(flowTyName, FlowType);
	    }

	    public Flow deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
	        JsonObject flowObj = json.getAsJsonObject();
	        JsonElement flowTypeElement = flowObj.get(flowTypeName);

	        Class<? extends Flow> FlowType = flowType.get(flowTypeElement.getAsString());
	        return gson.fromJson(flowObj, FlowType);
	    }

		@Override
		public Flow deserialize(JsonElement arg0, java.lang.reflect.Type arg1, JsonDeserializationContext arg2)
				throws JsonParseException {
			return null;
		}
		}
