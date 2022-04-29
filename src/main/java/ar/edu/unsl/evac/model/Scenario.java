package ar.edu.unsl.evac.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;

@Document
public class Scenario {

    @Id
    private String _id;
    @Field
    private String name;
    @Field
    private String description;

    private List<Agent> agents;

    private List<CellDefinition> environmentals;
}
