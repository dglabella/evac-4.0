package ar.edu.unsl.evac.scenarios.gol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;
import ar.edu.unsl.evac.engine.domain.CellState;
import ar.edu.unsl.evac.engine.domain.Visitor;
import ar.edu.unsl.evac.engine.utils.Loc;
import ar.edu.unsl.evac.engine.utils.Neighborhood;

public class GameOfLifeDefinition
        implements CellDefinition<GameOfLifeCellState>, GameOfLifeVisitable {

    public GameOfLifeDefinition() {}

    @Override
    public GameOfLifeCellState stateSetUp() {
        return new GameOfLifeCellState();
    }

    @Override
    public List<Loc> setUpNeighborhood(int i, int j, int width, int height) {
        try {
            return Neighborhood.Moore(i, j, 1, width, height, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CellDefinition<? extends CellState> applyRule(int i, int j,
            GameOfLifeCellState actualState, GameOfLifeCellState nextState, Agent agent,
            List<? extends CellState> neighborStates) {

        int neighborsAlive = 0;

        for (CellState cellStates : neighborStates) {
            if (cellStates.isAlive()) {
                neighborsAlive++;
            }
        }

        if (actualState.isAlive())

        {
            nextState.setAlive((neighborsAlive == 2 || neighborsAlive == 3) ? true : false);
        } else {
            nextState.setAlive(neighborsAlive == 3 ? true : false);
        }

        return null; // null means "do not transmute"
    }

    @Override
    public String codification(GameOfLifeCellState actualState) {
        return actualState.isAlive() ? " # " : "   ";
    }

    @Override
    public int typeId() {
        return 0;
    }

    @Override
    public void accept(GameOfLifeVisitor visitor) {
        visitor.visit(cellstate);
    }
}
