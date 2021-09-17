package ar.edu.unsl.engine.domain;

import ar.edu.unsl.engine.domain.abstracts.Agent;
import ar.edu.unsl.engine.domain.abstracts.Cell;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;

public class DefaultDefinition implements CellDefinition {

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
        // defaul definition does nothing here.

    }

    @Override
    public void update() {
        // defaul definition does nothing here.

    }

    @Override
    public String getCodification() {
        return "";
    }
}
