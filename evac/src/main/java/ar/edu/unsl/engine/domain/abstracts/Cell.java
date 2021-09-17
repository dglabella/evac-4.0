package ar.edu.unsl.engine.domain.abstracts;

public class Cell {

    private Agent agent;
    private Cell[] neighborhood;

    private CellDefinition definition;

    public Cell(CellDefinition definition) {
        this.definition = definition;
        this.definition.setUp(this.agent, this.neighborhood);
    }

    // =========================== getters and setters ===========================
    public Agent getAgent() {
        return this.agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
        this.definition.setUp(agent, neighborhood);
    }

    public Cell[] getNeighborhood() {
        return this.neighborhood;
    }

    public void setNeighborhood(Cell[] neighborhood) {
        this.neighborhood = neighborhood;
    }

    public CellDefinition getDefinition() {
        return this.definition;
    }

    public void setDefinition(CellDefinition definition) {
        this.definition = definition;
    }
}
