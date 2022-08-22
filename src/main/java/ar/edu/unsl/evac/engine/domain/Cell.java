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
    private List<Cell> neighborsCells;
    private List<Loc> neighborsCoords;
    @Transient
    private List<CellState> neighborhoodStates;

    @Transient
    private CellState postState;

    private DefinableCell definition;

    @Transient
    private DefinableCell postDefinition;

    private int usabilityFrequencyCounter;

    public Cell() {}

    public Cell(int i, int j, DefinableCell definition) {
        this.i = i;
        this.j = j;
        this.definition = definition;
        this.postState = definition.stateSetUp(); // replicate for next state
        this.definition.setState(definition.stateSetUp());// instantiate in the definition
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
    public List<CellState> getNeighborhoodStates() {
        return this.neighborhoodStates;
    }

    @JsonIgnore
    public void setNeighborhoodStates(List<CellState> neighborhoodStates) {
        this.neighborhoodStates = neighborhoodStates;
    }

    @JsonIgnore
    public CellState getPostState() {
        return this.postState;
    }

    @JsonIgnore
    public void setPostState(CellState postState) {
        this.postState = postState;
    }

    /**
     * 
     * @return The cell definition for this cell.
     */
    public DefinableCell getDef() {
        return this.definition;
    }

    /**
     * 
     * @param definition The cell definition for this cell.
     */
    public void setDef(DefinableCell definition) {
        this.definition = definition;
        this.postState = definition.stateSetUp();
    }

    @JsonIgnore
    public DefinableCell getPostDefinition() {
        return this.postDefinition;
    }

    @JsonIgnore
    public void setPostDefinition(DefinableCell definition) {
        this.postDefinition = definition;
        // this.postState = definition.stateSetUp();
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
    public void setUfc(int value) {
        this.usabilityFrequencyCounter = value;
    }

    /**
     * increment by 1 the usability frequency counter for this cell.
     */
    public void incrementPathUsabilityFrequencyCounter() {
        this.usabilityFrequencyCounter++;
    }
}
