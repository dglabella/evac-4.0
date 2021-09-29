package ar.edu.unsl.model.definitions;

import java.util.List;
import ar.edu.unsl.engine.domain.abstracts.Agent;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;
import ar.edu.unsl.engine.domain.neighborhoods.Neighborhood;

public class GameOfLife implements CellDefinition {

    private boolean alive = false;
    private boolean postAlive = false;

    private int i;
    private int j;

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
        this.i = i;
        this.j = j;
        try {
            return Neighborhood.Moore(i, j, 1, width, height, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void applyRule(List<CellDefinition> neighborhood) {
        int neighborsAlive = 0;
        for (int i = 0; i < neighborhood.size(); i++) {
            if (((GameOfLife) neighborhood.get(i)).isAlive())
                neighborsAlive++;
        }

        if (1 < neighborsAlive) {
            this.postAlive = true;
        } else {
            this.postAlive = false;
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
