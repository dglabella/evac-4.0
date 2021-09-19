package ar.edu.unsl.model;

import ar.edu.unsl.engine.domain.DefaultDefinition;
import ar.edu.unsl.engine.domain.abstracts.Cell;
import ar.edu.unsl.engine.domain.abstracts.Enviroment;
import ar.edu.unsl.model.neighborhoods.Neighborhood;

public class CellularAutomaton implements Enviroment {

    private Cell[][] cells;

    private int width;
    private int height;

    /**
     * The cellular automaton will be instantiated with size width * height. Every
     * cell will be instantiated with a Default definition.
     * 
     * @param width  The width.
     * @param height The height.
     * 
     */
    public CellularAutomaton(int width, int height, Neighborhood neighborhood) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[this.width][this.height];

        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.width; j++)
                this.cells[i][j] = new Cell(new DefaultDefinition());

        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.width; j++)
                this.cells[i][j].setNeighborhood(neighborhood.calculate());
    }

    // =========================== getters and setters ===========================
    public Cell[][] getCells() {
        return this.cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public int agentsRemaining() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void evolve() {
        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; i++)
                this.cells[i][j].getDefinition().applyRule();

        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; i++)
                this.cells[i][j].getDefinition().update();
    }
}
