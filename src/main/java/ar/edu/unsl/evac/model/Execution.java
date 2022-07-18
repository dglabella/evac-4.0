package ar.edu.unsl.evac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "executions")
public class Execution {

    @Id
    private String _id;

}
