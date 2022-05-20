package ar.edu.unsl.evac.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "projects")
public class Project {

    @Id
    private String _id;
    @Field
    private String name;
    @Field
    private String description;
    @Field
    private String ownerId;
    @Field
    private String scenarioId;
    @Field
    private List<String> savedStates;

    // private User owner;
    // private Scenario scenario;

    public Project() {}

    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSavedStates() {
        return this.savedStates;
    }

    public void setSavedStates(List<String> savedStates) {
        this.savedStates = savedStates;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getScenarioId() {
        return this.scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    // public User getOwner() {
    // return this.owner;
    // }

    // public void setOwner(User owner) {
    // this.owner = owner;
    // }

    // public Scenario getScenario() {
    // return this.scenario;
    // }

    // public void setScenario(Scenario scenario) {
    // this.scenario = scenario;
    // }
}
