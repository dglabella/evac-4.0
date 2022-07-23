package ar.edu.unsl.evac.engine.domain;

public interface StateParser {

    String parseToJson(Object obj) throws Exception;

    <T> Object parseToObject(String json, Class<T> valueType) throws Exception;

}
