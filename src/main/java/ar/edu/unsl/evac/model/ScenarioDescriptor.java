package ar.edu.unsl.evac.model;

import java.util.List;

public class ScenarioDescriptor {

    private String general;
    private List<String> imgs;

    public ScenarioDescriptor() {}

    public String getGeneral() {
        return this.general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public List<String> getImgs() {
        return this.imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
