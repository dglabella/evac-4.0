package ar.edu.unsl.engine.domain.concretes;

import java.util.List;
import ar.edu.unsl.engine.domain.abstracts.Agent;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;

public class Cell {

    private int i;
    private int j;

    private Agent agent;
    private List<int[]> neighborhood;

    private CellDefinition definition;

    private int pathUsabilityFrequencyCounter;

    public Cell(int i, int j, CellDefinition definition) {
        this.i = i;
        this.j = j;
        this.definition = definition;
        this.neighborhood = this.definition.setUpNeighborhood(i, j, CellularAutomaton.width, CellularAutomaton.height);
        this.definition.setUp(this.agent, this.neighborhood);
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
        this.definition.setUp(agent, neighborhood);
    }

    public List<int[]> getNeighborhood() {
        return this.neighborhood;
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
