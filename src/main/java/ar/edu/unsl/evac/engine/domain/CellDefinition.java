package ar.edu.unsl.evac.engine.domain;

import java.util.List;
import ar.edu.unsl.evac.engine.utils.Loc;

public interface CellDefinition {

    /**
     * 
     * @return The properties bundle associated to this cell definition.
     */
    PropertiesBundle getPropertiesBundle();

    /**
     * Generates a neighborhood for the cell of this cell definition. This cell has the (i,j)
     * position in the automaton.
     * 
     * @param width The automaton width.
     * @param height The automaton height.
     * @return A list of arrays. Each array must have size 2. Each position in the array will store
     *         the position of the neighborhood cells.
     */
    List<Loc> setUpNeighborhood(int i, int j, int width, int height);

    /**
     * This method is used to prepare the change of the cell state, meaning that this method should
     * implement the evolution rules.
     * 
     * @param i The component i of the pair ( i , j ) being ( i , j ) the position of this cell.
     * @param j The component j of the pair ( i , j ) being ( i , j ) the position of this cell.
     * @param agent The agent that is currently in this cell.
     * @param neighbors The neighbors properties of this cell.
     * @return A cell definition. This cell definition will be used to transmute the current
     *         definition of this cell. In other words, if it is not necessary to change the
     *         definition of this cell (i.e transmute it) then return null; otherwise the cell
     *         definition to be used for the transmutation may be returned.
     */
    CellDefinition applyRule(int i, int j, Agent agent, List<PropertiesBundle> neighbors);

    /**
     * This method is used to update properties within properties bundle in this cell.
     */
    void update();

    /**
     * 
     * @return The codification for this cell state.
     */
    String getCodification();

    /**
     * This method is intended to return an integer whose value acts as a type identifier.
     * 
     * @return the group identificator.
     */
    int typeId();
}
