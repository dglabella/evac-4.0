package ar.edu.unsl.evac.scenarios.evac.cells.definitions;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Cell;
import ar.edu.unsl.evac.engine.domain.CellDefinition;
import ar.edu.unsl.evac.engine.utils.Neighborhood;
import java.awt.Point;

public class GameOfLife implements CellDefinition {

    private boolean alive = false;
    private boolean postAlive = false;

    public GameOfLife() {

    }

    public GameOfLife(boolean isAlive) {
        this.alive = isAlive;
    }

    // =========================== getters and setters ===========================
    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isPostAlive() {
        return this.postAlive;
    }

    public void setPostAlive(boolean postAlive) {
        this.postAlive = postAlive;
    }

    @Override
    public List<Point> setUpNeighborhood(int i, int j, int width, int height) {
        try {
            return Neighborhood.Moore(i, j, 1, width, height, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void applyRule(Cell cell, List<Cell> neighborhood) {
        int neighborsAlive = 0;

        for (int i = 0; i < neighborhood.size(); i++) {
            if (((GameOfLife) neighborhood.get(i).getDefinition()).isAlive())
                neighborsAlive++;
        }

        if (this.alive) {
            this.postAlive = (neighborsAlive == 2 || neighborsAlive == 3) ? true : false;
        } else {
            this.postAlive = neighborsAlive == 3 ? true : false;
        }
    }

    @Override
    public void update() {
        this.alive = this.postAlive;
    }

    @Override
    public String getCodification() {
        return this.isAlive() ? " # " : "   ";
    }
}
