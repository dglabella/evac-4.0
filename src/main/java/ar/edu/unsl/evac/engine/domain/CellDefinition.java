package ar.edu.unsl.evac.engine.domain;

import java.util.List;

public interface CellDefinition {

    /**
     * Set the agent associated to this cell.
     * 
     * @param agent The agent associated to this cell.
     */
    void setAgent(Agent agent);

    /**
     * This method is called a first time in Cell constructor and used to pass information to the
     * underlying implementation.
     * 
     * @param i Corresponds to the i-row in the automaton.
     * @param j Corresponds to the j-columns in the automaton.
     * @param agent The current Agent associated to this cell.
     * @param neighborhood The neighborhood for this cell.
     */
    void setUp(int i, int j, Agent agent, List<int[]> neighborhood);

    /**
     * Generates a neighborhood for the cell of this cell definition. This cell has the (i,j)
     * position in the automaton.
     * 
     * @param width The automaton width.
     * @param height The automaton height.
     * @return A list of arrays. Each array must have size 2. Each position in the array will store
     *         the position of the neighborhood cells.
     */
    List<int[]> setUpNeighborhood(int width, int height);

    /**
     * This method is used to prepare the change of the cell state, meaning that this method should
     * implement the evolution rules.
     * 
     * @param neighborhood
     */
    void applyRule(List<CellDefinition> neighborhood);

    void update();

    String getCodification();
}
