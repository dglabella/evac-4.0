package ar.edu.unsl.model.definitions;

import ar.edu.unsl.engine.domain.abstracts.Agent;
import ar.edu.unsl.engine.domain.abstracts.Cell;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;

public class Wall implements CellDefinition {

    private float resistance;

    public float getResistance() {
        return this.resistance;
    }

    public void setResistance(float resistance) {
        this.resistance = resistance;
    }

    @Override
    public void setUp(Agent agent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setUp(Agent agent, Cell[] neighborhood) {
        // TODO Auto-generated method stub

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
