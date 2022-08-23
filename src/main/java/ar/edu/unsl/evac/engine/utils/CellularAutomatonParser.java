package ar.edu.unsl.evac.engine.utils;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.model.State;

public class CellularAutomatonParser implements EnvironmentParser<CellularAutomaton> {

    private ObjectMapper mapper;

    public CellularAutomatonParser() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public String parseStateToJson(CellularAutomaton obj) throws Exception {
        return this.mapper.writeValueAsString(obj);
    }

    @Override
    public CellularAutomaton parseStateToObject(String json) throws Exception {
        return this.mapper.readValue(json, CellularAutomaton.class);
    }

    public String generateSavedState(byte[] compressedState) {
        String savedState =
                "{\"_id\":{\"$oid\":\"628f5326b1ab917d52d82913\"},\"annotation\":\"initial state from a game of life experiment\",\"currentGeneration\":65,\"environmentData\":\"";
        savedState += new String(compressedState);
        savedState += "\"}  ";
        return savedState;
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
