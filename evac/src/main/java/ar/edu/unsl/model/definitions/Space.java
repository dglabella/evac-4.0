package ar.edu.unsl.model.definitions;

import java.util.List;
import ar.edu.unsl.engine.domain.abstracts.Agent;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;
import ar.edu.unsl.model.definitions.elements.Fire;
import ar.edu.unsl.model.definitions.elements.Smoke;
import ar.edu.unsl.model.neighborhoods.Neighborhood;

public class Space implements CellDefinition {

    private Fire fire;
    private Smoke smoke;

    @Override
    public void setUp(Agent agent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setUp(Agent agent, List<int[]> neighborhood) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<int[]> setUpNeighborhood(int i, int j) {
        int sizeFactor = 1;
        return Neighborhood.Moore(i, j, sizeFactor, false);
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
