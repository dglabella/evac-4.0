package ar.edu.unsl.engine.domain.abstracts;

import java.util.List;

public interface CellDefinition {

    void setUp(Agent agent);

    void setUp(Agent agent, List<int[]> neighborhood);

    /**
     * Generates a neighborhood for the cell of this cell definition. This cell has
     * the (i,j) position in the automaton.
     * 
     * @param i      Corresponds to the i-row in the automaton.
     * @param j      Corresponds to the j-columns in the automaton.
     * @param width  The automaton width.
     * @param height The automaton height.
     * @return A list of arrays. Each array must have size 2. Each position in the
     *         array will store the position of the neighborhood cells.
     */
    List<int[]> setUpNeighborhood(int i, int j, int width, int height);

    void applyRule(List<CellDefinition> neighborhood);

    void update();

    String getCodification();
}
