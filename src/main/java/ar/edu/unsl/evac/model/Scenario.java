package ar.edu.unsl.evac.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Scenario {

    private String _id;

    private String name;

    private String description;

    private List<Agent> agents;

    private List<Environmental> environmentals;
}
