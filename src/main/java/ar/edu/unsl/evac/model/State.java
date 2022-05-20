package ar.edu.unsl.evac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;

@Document(collection = "states")
public class State {

    @Id
    private String _id;
    @Field
    private String annotation;
    @Field
    private int currentGeneration;
    @Field
    private CellularAutomaton environment;

    public State() {}

    public String getAnnotation() {
        return this.annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public int getCurrentGeneration() {
        return this.currentGeneration;
    }

    public void setCurrentGeneration(int currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    public CellularAutomaton getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(CellularAutomaton environment) {
        this.environment = environment;
    }
}
