package ar.edu.unsl.evac.engine.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ar.edu.unsl.evac.engine.utils.Loc;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
public interface CellDefinition<T extends CellState> {

    /**
     * Set up the state for this definition. Use this function to initialize the state of this cell.
     * 
     * @return the state of this cell to be used as initial value.
     */
    T stateSetUp();

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
     * @param neighbors The neighbors states of this cell.
     * @return A cell definition. This cell definition will be used to transmute the current
     *         definition of this cell. In other words, if it is not necessary to change the
     *         definition of this cell (i.e transmute it) then return null; otherwise the cell
     *         definition to be used for the transmutation may be returned.
     */
    CellDefinition<? extends CellState> applyRule(int i, int j, T actualState, T nextState,
            Agent agent, List<? extends CellState> neighborStates);



    /**
     * 
     * @return The codification for this cell state.
     */
    String codification(T actualState);

    /**
     * This method is intended to return an integer whose value acts as a type identifier.
     * 
     * @return the group identificator.
     */
    int typeId();
}
