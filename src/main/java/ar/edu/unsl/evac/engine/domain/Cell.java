package ar.edu.unsl.evac.engine.domain;

import java.util.List;
import org.springframework.data.annotation.Transient;
import java.awt.Point;

public class Cell {

    private int i;
    private int j;

    private Agent agent;
    private List<Point> neighborhoodCoords;

    private CellDefinition definition;

    private int pathUsabilityFrequencyCounter;

    @Transient
    private List<Cell> neighborhoodCells;

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

    public List<Point> getNeighborhoodCoords() {
        return this.neighborhoodCoords;
    }

    public void setNeighborhood(List<Point> neighborhoodCoords) {
        this.neighborhoodCoords = neighborhoodCoords;
    }

    public CellDefinition getDefinition() {
        return this.definition;
    }

    public void setDefinition(CellDefinition definition) {
        this.definition = definition;
    }

    public int getPathUsabilityFrequencyCounter() {
        return this.pathUsabilityFrequencyCounter;
    }

    public void incrementPathUsabilityFrequencyCounter() {
        this.pathUsabilityFrequencyCounter++;
    }
}
