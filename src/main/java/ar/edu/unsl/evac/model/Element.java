package ar.edu.unsl.evac.model;

public class Element {

    private String name;
    private String description;
    private String uriImg;

    public Element() {}

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

    public String getUriImg() {
        return this.uriImg;
    }

    public void setUriImg(String uriImg) {
        this.uriImg = uriImg;
    }
}
