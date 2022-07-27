package ar.edu.unsl.evac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "executions")
public class Execution {

    @Id
    private String _id;

    @Field
    private String executionData; // deflated data

    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getExecutionData() {
        return this.executionData;
    }

    public void setExecutionData(String executionData) {
        this.executionData = executionData;
    }
}
