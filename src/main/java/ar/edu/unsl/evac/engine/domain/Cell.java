package ar.edu.unsl.evac.engine.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;

public class Cell {

    private int i;
    private int j;

    private Agent agent;
    private List<int[]> neighborhood;

    private CellDefinition definition;

    private int pathUsabilityFrequencyCounter;

    public Cell() {}

    public Cell(int i, int j, CellDefinition definition) {
        this.i = i;
        this.j = j;
        this.definition = definition;
        this.definition.setUp(i, j, this.agent, null);
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

    public List<int[]> getNeighborhood() {
        return this.neighborhood;
    }

    public void setNeighborhood(List<int[]> neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setUpNeighborhood(List<int[]> neighborhood) {
        this.neighborhood = neighborhood;
        this.definition.setUp(this.i, this.j, this.agent, this.neighborhood);
    }

    public CellDefinition getDefinition() {
        return this.definition;
    }

    public void setDefinition(CellDefinition definition) {
        this.definition = definition;
        this.definition.setUp(i, j, agent, neighborhood);
    }

    public int getPathUsabilityFrequencyCounter() {
        return this.pathUsabilityFrequencyCounter;
    }

    public void incrementPathUsabilityFrequencyCounter() {
        this.pathUsabilityFrequencyCounter++;
    }
}
