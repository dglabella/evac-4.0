package ar.edu.unsl.evac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "states")
public class SavedState {

    @Id
    private String _id;
    @Field
    private String annotation;
    @Field
    private int currentGeneration;
    @Field
    private String environmentCompressedData; // deflated data

    public SavedState() {}

    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

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

    public String getEnvironmentCompressedData() {
        return this.environmentCompressedData;
    }

    public void setEnvironmentCompressedData(String environmentCompressedData) {
        this.environmentCompressedData = environmentCompressedData;
    }
}
