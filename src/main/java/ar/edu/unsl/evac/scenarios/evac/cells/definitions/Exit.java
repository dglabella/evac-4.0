package ar.edu.unsl.evac.scenarios.evac.cells.definitions;

import java.awt.Point;
import java.util.List;
import ar.edu.unsl.evac.engine.domain.Cell;
import ar.edu.unsl.evac.engine.domain.CellDefinition;

public class Exit implements CellDefinition {

    @Override
    public List<Point> setUpNeighborhood(int i, int j, int width, int height) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void applyRule(Cell cell, List<Cell> neighborhood) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCodification() {
        // TODO Auto-generated method stub
        return null;
    }
}
