package ar.edu.unsl.evac.engine.utils;

public interface EnvironmentParser<T> {

    String parseStateToJson(T obj) throws Exception;

    T parseStateToObject(String json) throws Exception;
}
