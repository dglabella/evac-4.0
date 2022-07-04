package ar.edu.unsl.evac.engine.domain;

import java.util.List;
import java.util.ArrayList;
import ar.edu.unsl.evac.engine.domain.definitions.LambdaDefinition;
import java.awt.Point;

public class CellularAutomaton implements Environment {

    private int width;
    private int height;

    private Cell[][] cells;

    /**
     * The cellular automaton will be instantiated with size width * height. Every cell will be
     * instantiated with a Default definition.
     * 
     * @param width The width.
     * @param height The height.
     * 
     */
    public CellularAutomaton(int width, int height) {
        this.width = width;
        this.height = height;

        this.cells = new Cell[height][width];

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

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private List<Cell> obtainNeighborhoodCells(List<Point> neighborhoodCoords) {
        List<Cell> ret = new ArrayList<>();
        for (int i = 0; i < neighborhoodCoords.size(); i++) {
            ret.add(this.cells[neighborhoodCoords.get(i).x][neighborhoodCoords.get(i).y]);
        }
        return ret;
    }

    public int agentsRemaining() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void evolve() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.cells[i][j].getDefinition().applyRule(this.cells[i][j],
                        this.obtainNeighborhoodCells(this.cells[i][j].getNeighborhoodCoords()));
            }
        }

        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < this.width; j++)
                this.cells[i][j].getDefinition().update();
    }

    @Override
    public void generateView() {
        System.out.println(
                "-----------------------------------------------------------------------------------");
        for (int i = 0; i < this.height; i++) {
            System.out.print("|");
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.cells[i][j].getDefinition().getCodification());
            }
            System.out.println("|");
        }
        System.out.println(
                "------------------------------------------------------------------------------------");
        System.out.println();

        try {
            Thread.sleep(100);
            // Scanner scanner = new Scanner(System.in);
            // scanner.nextLine();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
