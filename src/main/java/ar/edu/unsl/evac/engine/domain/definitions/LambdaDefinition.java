package ar.edu.unsl.evac.engine.domain.definitions;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;
import ar.edu.unsl.evac.engine.domain.CellState;
import ar.edu.unsl.evac.engine.utils.Loc;

/**
 * This Cell definition represents emptyness.
 */
public class LambdaDefinition implements CellDefinition<LambdaCellState> {

    @Override
    public LambdaCellState setUpState() {
        return new LambdaCellState();
    }

    @Override
    public List<Loc> setUpNeighborhood(int i, int j, int width, int height) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CellDefinition<? extends CellState> applyRule(int i, int j, LambdaCellState actualState,
            List<CellState> neighborStates, LambdaCellState nextState, Agent agent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String codification(LambdaCellState actualState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int typeId() {
        // TODO Auto-generated method stub
        return 0;
    }

}
