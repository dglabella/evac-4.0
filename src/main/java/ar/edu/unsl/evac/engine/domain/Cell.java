package ar.edu.unsl.evac.engine.domain;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ar.edu.unsl.evac.engine.utils.Loc;

public class Cell implements Serializable {

    private int i;
    private int j;

    private Agent agent;

    @Transient
    private List<Cell> neighborsCells;
    private List<Loc> neighborsCoords;
    @Transient
    private List<PropertiesBundle> neighborhoodCellsPropertiesBundles;

    private CellDefinition definition;

    @Transient
    private CellDefinition postDefinition;

    private int usabilityFrequencyCounter;

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
    public List<Cell> getNeighborsCells() {
        return this.neighborsCells;
    }

    @JsonIgnore
    public void setNeighborhoodCells(List<Cell> neighborsCells) {
        this.neighborsCells = neighborsCells;
    }

    public List<Loc> getNeighbors() {
        return this.neighborsCoords;
    }

    public void setNeighbors(List<Loc> neighbors) {
        this.neighborsCoords = neighbors;
    }

    @JsonIgnore
    public List<PropertiesBundle> getNeighborhoodCellsPropertiesBundles() {
        return this.neighborhoodCellsPropertiesBundles;
    }

    @JsonIgnore
    public void setNeighborhoodCellsPropertiesBundles(List<PropertiesBundle> propertiesBundles) {
        this.neighborhoodCellsPropertiesBundles = propertiesBundles;
    }

    /**
     * 
     * @return The cell definition for this cell.
     */
    public CellDefinition getDef() {
        return this.definition;
    }

    /**
     * 
     * @param definition The cell definition for this cell.
     */
    public void setDef(CellDefinition definition) {
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

    /**
     * @return The usability frequency counter number for this cell.
     */
    public int getUfc() {
        return this.usabilityFrequencyCounter;
    }

    /**
     * 
     * @param value is the usability frequency counter for this cell.
     */
    public void setPufc(int value) {
        this.usabilityFrequencyCounter = value;
    }

    /**
     * increment by 1 the usability frequency counter for this cell.
     */
    public void incrementPathUsabilityFrequencyCounter() {
        this.usabilityFrequencyCounter++;
    }
}
