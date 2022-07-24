package ar.edu.unsl.evac.engine.domain;

public interface EnvironmentParser {

    String parseStateToJson(Object obj) throws Exception;

    <T> Object parseStateToObject(String json, Class<T> valueType) throws Exception;
}
