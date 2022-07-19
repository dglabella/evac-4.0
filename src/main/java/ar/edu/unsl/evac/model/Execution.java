package ar.edu.unsl.evac.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "executions")
public class Execution {

    @Id
    private String _id;

    @Field
    private List<State> generations;

    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public List<State> getGenerations() {
        return this.generations;
    }

    public void setGenerations(List<State> generations) {
        this.generations = generations;
    }
}
