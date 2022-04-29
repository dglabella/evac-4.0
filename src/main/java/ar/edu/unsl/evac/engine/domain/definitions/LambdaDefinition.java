package ar.edu.unsl.evac.engine.domain.definitions;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;

/**
 * This Cell definition represents emptyness.
 */
public class LambdaDefinition implements CellDefinition {

    public void setAgent(Agent agent) {
        // TODO Auto-generated method stub

    }

    public void setUp(int i, int j, Agent agent, List<int[]> neighborhood) {
        // TODO Auto-generated method stub

    }

    public List<int[]> setUpNeighborhood(int width, int height) {
        // TODO Auto-generated method stub
        return null;
    }

    public void applyRule(List<CellDefinition> neighborhood) {
        // TODO Auto-generated method stub

    }

    public void update() {
        // TODO Auto-generated method stub

    }

    public String getCodification() {
        // TODO Auto-generated method stub
        return null;
    }
}
