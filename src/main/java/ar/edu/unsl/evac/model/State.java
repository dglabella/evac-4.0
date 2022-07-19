package ar.edu.unsl.evac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;

public class State {
    @Id
    private String _id;

    @Field
    private CellularAutomaton environment;

    public State() {}

    public String getId() {
        return this._id;
    }

    public void set_id(String id) {
        this._id = id;
    }

    public CellularAutomaton getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(CellularAutomaton environment) {
        this.environment = environment;
    }
}
