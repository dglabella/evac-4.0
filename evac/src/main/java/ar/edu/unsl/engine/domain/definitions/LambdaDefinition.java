package ar.edu.unsl.engine.domain.definitions;

import java.util.List;
import ar.edu.unsl.engine.domain.abstracts.Agent;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;

/**
 * This Cell definition represents emptyness.
 */
public class LambdaDefinition implements CellDefinition {

    @Override
    public void setUp(Agent agent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setUp(Agent agent, List<int[]> neighborhood) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<int[]> setUpNeighborhood(int i, int j, int width, int height) {
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
