package ar.edu.unsl.evac.engine.domain;

import java.util.List;
import java.awt.Point;

public interface CellDefinition {

    /**
     * Generates a neighborhood for the cell of this cell definition. This cell has the (i,j)
     * position in the automaton.
     * 
     * @param width The automaton width.
     * @param height The automaton height.
     * @return A list of arrays. Each array must have size 2. Each position in the array will store
     *         the position of the neighborhood cells.
     */
    List<Point> setUpNeighborhood(int i, int j, int width, int height);

    // /**
    // * This method is used to prepare the change of the cell state, meaning that this method
    // should
    // * implement the evolution rules.
    // *
    // * @param neighborhood
    // */
    // void applyRule(List<CellDefinition> neighborhood);

    /**
     * This method is used to prepare the change of the cell state, meaning that this method should
     * implement the evolution rules.
     * 
     * @param cell The cell of this definition.
     * @param neighborhood The neighborhood of the cell.
     */
    void applyRule(Cell cell, List<Cell> neighborhood);

    void update();

    String getCodification();
}
