package ar.edu.unsl.evac.engine.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import ar.edu.unsl.evac.engine.domain.StateParser;

public class CustomParser implements StateParser {

    private ObjectMapper mapper;

    public CustomParser() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public String parseToJson(Object obj) throws Exception {
        return this.mapper.writeValueAsString(obj);
    }

    @Override
    public <T> Object parseToObject(String json, Class<T> valueType) throws Exception {
        return this.mapper.readValue(json, valueType);
    }
}
