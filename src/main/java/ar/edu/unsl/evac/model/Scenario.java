package ar.edu.unsl.evac.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;

@Document(collection = "scenarios")
public class Scenario {

    @Id
    private String _id;
    @Field
    private String name;
    @Field
    private String description;
    @Field
    private List<Agent> agents;
    @Field
    private List<CellDefinition> environmentals;

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Agent> getAgents() {
        return this.agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public List<CellDefinition> getEnvironmentals() {
        return this.environmentals;
    }

    public void setEnvironmentals(List<CellDefinition> environmentals) {
        this.environmentals = environmentals;
    }
}
