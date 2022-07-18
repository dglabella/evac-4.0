package ar.edu.unsl.evac.engine.domain;

import java.util.List;
import org.springframework.data.annotation.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ar.edu.unsl.evac.engine.utils.Loc;

public class Cell {

    private int i;
    private int j;

    private Agent agent;

    @Transient
    private List<Cell> neighborhoodCells;
    private List<Loc> neighborhoodCoords;
    @Transient
    private List<PropertiesBundle> neighborhoodCellsPropertiesBundles;

    private CellDefinition definition;

    @Transient
    private CellDefinition postDefinition;

    private int pathUsabilityFrequencyCounter;

    public Cell() {}

    public Cell(int i, int j, CellDefinition definition) {
        this.i = i;
        this.j = j;
        this.definition = definition;
    }

    // =========================== getters and setters ===========================
    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    public Agent getAgent() {
        return this.agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @JsonIgnore
    public List<Cell> getNeighborhoodCells() {
        return this.neighborhoodCells;
    }

    @JsonIgnore
    public void setNeighborhoodCells(List<Cell> neighborhoodCells) {
        this.neighborhoodCells = neighborhoodCells;
    }

    public List<Loc> getNeighborhoodCoords() {
        return this.neighborhoodCoords;
    }

    public void setNeighborhoodCoords(List<Loc> neighborhoodCoords) {
        this.neighborhoodCoords = neighborhoodCoords;
    }

    @JsonIgnore
    public List<PropertiesBundle> getNeighborhoodCellsPropertiesBundles() {
        return this.neighborhoodCellsPropertiesBundles;
    }

    @JsonIgnore
    public void setNeighborhoodCellsPropertiesBundles(List<PropertiesBundle> propertiesBundles) {
        this.neighborhoodCellsPropertiesBundles = propertiesBundles;
    }

    public CellDefinition getDefinition() {
        return this.definition;
    }

    public void setDefinition(CellDefinition definition) {
        this.definition = definition;
    }

    @JsonIgnore
    public CellDefinition getPostDefinition() {
        return this.postDefinition;
    }

    @JsonIgnore
    public void setPostDefinition(CellDefinition definition) {
        this.postDefinition = definition;
    }

    public int getPathUsabilityFrequencyCounter() {
        return this.pathUsabilityFrequencyCounter;
    }

    public void setPathUsabilityFrequencyCounter(int value) {
        this.pathUsabilityFrequencyCounter = value;
    }

    public void incrementPathUsabilityFrequencyCounter() {
        this.pathUsabilityFrequencyCounter++;
    }
}
