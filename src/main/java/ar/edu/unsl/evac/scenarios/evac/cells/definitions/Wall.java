package ar.edu.unsl.evac.scenarios.evac.cells.definitions;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;


public class Wall implements CellDefinition {

    private float resistance;

    @Override
    public void setAgent(Agent agent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setUp(int i, int j, Agent agent, List<int[]> neighborhood) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<int[]> setUpNeighborhood(int width, int height) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void applyRule(List<CellDefinition> neighborhood) {
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
