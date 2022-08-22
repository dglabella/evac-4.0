package ar.edu.unsl.evac.engine.domain.definitions;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.DefinableCell;
import ar.edu.unsl.evac.engine.domain.CellState;
import ar.edu.unsl.evac.engine.utils.Loc;

/**
 * This Cell definition represents emptyness.
 */
public class LambdaDefinition implements DefinableCell {

    @Override
    public CellState getState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setState(CellState state) {
        // TODO Auto-generated method stub

    }

    @Override
    public CellState stateSetUp() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Loc> setUpNeighborhood(int i, int j, int width, int height) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DefinableCell applyRule(int i, int j, CellState nextState, Agent agent,
            List<CellState> neighborStates) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(CellState nextState) {
        // TODO Auto-generated method stub

    }

    @Override
    public String codification() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int typeId() {
        // TODO Auto-generated method stub
        return 0;
    }
}
