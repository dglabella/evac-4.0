package ar.edu.unsl.evac.scenarios.gol;

import ar.edu.unsl.evac.engine.domain.CellState;

public class GameOfLifeCellState implements CellState {

    private boolean alive;

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
