package ar.edu.unsl.model.definitions;

import ar.edu.unsl.engine.domain.abstracts.Agent;
import ar.edu.unsl.engine.domain.abstracts.Cell;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;

public class Fire implements CellDefinition {

    private float temp;
    private Agent agent;
    private Cell[] neighborhood;

    public float getTemp() {
        return this.temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Override
    public void setUp(Agent agent) {
        this.agent = agent;
    }

    @Override
    public void setUp(Agent agent, Cell[] neighborhood) {
        this.agent = agent;
        this.neighborhood = neighborhood;
    }

    @Override
    public void applyRule() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCodification() {
        // TODO Auto-generated method stub
        return null;
    }
}
