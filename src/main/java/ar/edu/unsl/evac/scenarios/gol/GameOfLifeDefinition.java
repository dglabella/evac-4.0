package ar.edu.unsl.evac.scenarios.gol;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.DefinableCell;
import ar.edu.unsl.evac.engine.domain.CellState;
import ar.edu.unsl.evac.engine.utils.Loc;
import ar.edu.unsl.evac.engine.utils.Neighborhood;

public class GameOfLifeDefinition implements DefinableCell {

    private GameOfLifeCellState cellState;

    public GameOfLifeDefinition() {}

    public GameOfLifeDefinition(GameOfLifeCellState cellState) {
        this.cellState = cellState;
    }

    @Override
    public CellState getState() {
        return this.cellState;
    }

    @Override
    public void setState(CellState cellState) {
        this.cellState = (GameOfLifeCellState) cellState;
    }

    @Override
    public CellState stateSetUp() {
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
    public DefinableCell applyRule(int i, int j, CellState nextState, Agent agent,
            List<CellState> neighborStates) {

        int neighborsAlive = 0;

        for (CellState cellStates : neighborStates) {
            if (((GameOfLifeCellState) cellStates).isAlive()) {
                neighborsAlive++;
            }
        }

        if (this.cellState.isAlive()) {
            ((GameOfLifeCellState) nextState)
                    .setAlive((neighborsAlive == 2 || neighborsAlive == 3) ? true : false);
        } else {
            ((GameOfLifeCellState) nextState).setAlive(neighborsAlive == 3 ? true : false);
        }

        // GameOfLifeDefinition g = new GameOfLifeDefinition();
        // GameOfLifeCellState cs = new GameOfLifeCellState();
        // g.setCellState(cs);

        return null; // null means "do not transmute"
    }

    @Override
    public void update(CellState nextState) {
        this.cellState.setAlive(((GameOfLifeCellState) nextState).isAlive());
    }

    @Override
    public String codification() {
        return this.cellState.isAlive() ? " # " : "   ";
    }

    @Override
    public int typeId() {
        return 0;
    }
}
