package ar.edu.unsl.evac.engine.domain.definitions;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;
import ar.edu.unsl.evac.engine.domain.PropertiesBundle;
import ar.edu.unsl.evac.engine.utils.Loc;

/**
 * This Cell definition represents emptyness.
 */
public class LambdaDefinition implements CellDefinition {

    @Override
    public PropertiesBundle getPropertiesBundle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Loc> setUpNeighborhood(int i, int j, int width, int height) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CellDefinition applyRule(int i, int j, Agent agent, List<PropertiesBundle> neighbors) {
        // TODO Auto-generated method stub
        return null;
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

    @Override
    public int typeId() {
        // TODO Auto-generated method stub
        return 0;
    }
}
