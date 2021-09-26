package ar.edu.unsl.engine.domain.concretes;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;
import ar.edu.unsl.engine.domain.abstracts.Enviroment;
import ar.edu.unsl.engine.domain.definitions.LambdaDefinition;

public class CellularAutomaton implements Enviroment {

    protected static int width;
    protected static int height;

    private Cell[][] cells;

    private List<CellDefinition> neighboorhoodHolder = new ArrayList<>();

    /**
     * The cellular automaton will be instantiated with size width * height. Every cell will be
     * instantiated with a Default definition.
     * 
     * @param width The width.
     * @param height The height.
     * 
     */
    public CellularAutomaton(int width, int height) {
        CellularAutomaton.width = width;
        CellularAutomaton.height = height;
        this.cells = new Cell[width][height];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                this.cells[i][j] = new Cell(i, j, new LambdaDefinition());
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

    private void fillNeighborhoodHolder(List<int[]> neighborhoodCoords) {
        for (int i = 0; i < neighborhoodCoords.size(); i++) {
            this.neighboorhoodHolder
                    .add(this.cells[neighborhoodCoords.get(i)[0]][neighborhoodCoords.get(i)[1]]
                            .getDefinition());
        }
    }

    @Override
    public int agentsRemaining() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void evolve() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.fillNeighborhoodHolder(this.cells[i][j].getNeighborhood());
                this.cells[i][j].getDefinition().applyRule(this.neighboorhoodHolder);
            }
        }

        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; j++)
                this.cells[i][j].getDefinition().update();
    }

    @Override
    public void generateView() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                System.out.print(this.cells[i][j].getDefinition().getCodification());
            }
            System.out.println();
        }
    }
}
