package components;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class FlowDeserializer implements JsonDeserializer<Flow> {
    private String flowTypeElementName;
    private Gson gson;
    private Map<String, Class<? extends Flow>> flowTypeRegistry;

    public FlowDeserializer(String flowTypeElementName) {
        this.flowTypeElementName = flowTypeElementName;
        this.gson = new Gson();
        this.flowTypeRegistry = new HashMap<>();
    }

    public void registerBarnType(String flowTypeName, Class<? extends Flow> flowType) {
        flowTypeRegistry.put(flowTypeName, flowType);
    }

    public Flow deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        JsonObject FlowObject = json.getAsJsonObject();
        JsonElement flowTypeElement = FlowObject.get(flowTypeElementName);

        Class<? extends Flow> flowType = flowTypeRegistry.get(flowTypeElement.getAsString());
        return gson.fromJson(FlowObject, flowType);
    }

}
