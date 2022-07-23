package ar.edu.unsl.evac.engine.domain;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ar.edu.unsl.evac.engine.domain.definitions.LambdaDefinition;
import ar.edu.unsl.evac.engine.utils.Loc;

public class CellularAutomaton implements Environment {

    @Transient
    private int width;
    @Transient
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

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.cells[i][j] = new Cell(i, j, new LambdaDefinition());
            }
        }
    }

    // =========================== getters and setters ===========================
    public Cell[][] getCells() {
        return this.cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    @JsonIgnore
    public int getWidth() {
        return this.width;
    }

    @JsonIgnore
    public void setWidth(int width) {
        this.width = width;
    }

    @JsonIgnore
    public int getHeight() {
        return this.height;
    }

    @JsonIgnore
    public void setHeight(int height) {
        this.height = height;
    }

    public int agentsRemaining() {
        // TODO Auto-generated method stub
        return 0;
    }

    public List<Cell> obtainNeighborhoodCells(List<Loc> neighborhoodCoords) {
        List<Cell> ret = new ArrayList<>();

        for (Loc loc : neighborhoodCoords) {
            ret.add(this.cells[loc.getI()][loc.getJ()]);
        }

        return ret;
    }

    public List<PropertiesBundle> obtainNeighborhoodCellsPropertiesBundles(int i, int j) {
        List<PropertiesBundle> ret = new ArrayList<>();

        for (Cell cell : this.cells[i][j].getNeighborhoodCells()) {
            ret.add(cell.getDefinition().getPropertiesBundle());
        }

        return ret;
    }

    @Override
    public void evolve() {
        Cell cell;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                cell = this.cells[i][j];
                cell.setPostDefinition(cell.getDefinition().applyRule(i, j, cell.getAgent(),
                        cell.getNeighborhoodCellsPropertiesBundles()));
            }
        }

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                cell = this.cells[i][j];
                if (cell.getPostDefinition() != null) {
                    cell.setDefinition(cell.getPostDefinition()); // transmute here
                    cell.setPostDefinition(null);
                    // recalculate neighborhood. Maybe this recalculation can be ommited if the new
                    // definition has the same neighboorhood type (e.g both definition has Moore
                    // neighborhood)
                    cell.setNeighborhoodCoords(
                            cell.getDefinition().setUpNeighborhood(i, j, this.width, this.height));
                    cell.setNeighborhoodCells(
                            this.obtainNeighborhoodCells(cell.getNeighborhoodCoords()));
                } else {
                    cell.getDefinition().update(); // otherwise, update definition state
                }
            }
        }
    }

    @Override
    public String generateState(StateParser parser) {
        String state;
        try {
            state = parser.parseToJson(this);
        } catch (Exception e) {
            state = null;
            e.printStackTrace();
        }
        return state;
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
