package ar.edu.unsl.evac.engine.utils;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CellularAutomatonParser implements EnvironmentParser {

    private ObjectMapper mapper;

    public CellularAutomatonParser() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public String parseStateToJson(Object obj) throws Exception {
        return this.mapper.writeValueAsString(obj);
    }

    @Override
    public <T> Object parseStateToObject(String json, Class<T> valueType) throws Exception {
        return this.mapper.readValue(json, valueType);
    }

    public String generateExecutionJson(int width, int height, List<String> generations) {
        String jsonExecution = "[";
        try {
            for (int i = 0; i < generations.size() - 1; i++) {
                jsonExecution += generations.get(i);
                jsonExecution += ",";
            }
            jsonExecution += generations.get(generations.size() - 1);
            jsonExecution += "]";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExecution;
    }
}
