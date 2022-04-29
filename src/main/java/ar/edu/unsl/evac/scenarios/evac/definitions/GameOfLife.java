package ar.edu.unsl.evac.scenarios.evac.definitions;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;
import ar.edu.unsl.evac.engine.utils.Neighborhood;

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
    public void setAgent(Agent agent) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setUp(int i, int j, Agent agent, List<int[]> neighborhood) {
        this.i = i;
        this.j = j;
    }

    @Override
    public List<int[]> setUpNeighborhood(int width, int height) {
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
