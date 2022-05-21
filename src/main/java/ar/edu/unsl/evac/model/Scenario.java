package ar.edu.unsl.evac.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "scenarios")
public class Scenario {

    @Id
    private String _id;
    @Field
    private String name;
    @Field
    private ScenarioDescriptor description;
    @Field
    private List<Element> agents;
    @Field
    private List<Element> environmentals;

    public Scenario() {}

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

    public ScenarioDescriptor getDescription() {
        return this.description;
    }

    public void setDescription(ScenarioDescriptor description) {
        this.description = description;
    }

    public List<Element> getAgents() {
        return this.agents;
    }

    public void setAgents(List<Element> agents) {
        this.agents = agents;
    }

    public List<Element> getEnvironmentals() {
        return this.environmentals;
    }

    public void setEnvironmentals(List<Element> environmentals) {
        this.environmentals = environmentals;
    }
}
