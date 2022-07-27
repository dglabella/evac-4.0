package ar.edu.unsl.evac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class State {
    @Id
    private String _id;

    @Field
    private String environmentData; // deflated data

    public State() {}

    public String getId() {
        return this._id;
    }

    public void set_id(String id) {
        this._id = id;
    }

    public String getEnvironmentData() {
        return this.environmentData;
    }

    public void setEnvironmentData(String environmentData) {
        this.environmentData = environmentData;
    }
}
