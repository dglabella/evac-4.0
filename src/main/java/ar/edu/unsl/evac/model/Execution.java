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
    private int width;

    @Field
    private int height;

    @Field
    private List<State> generations;

    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<State> getGenerations() {
        return this.generations;
    }

    public void setGenerations(List<State> generations) {
        this.generations = generations;
    }
}
