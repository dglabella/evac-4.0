package ar.edu.unsl.model.neighborhoods;

import java.util.ArrayList;
import java.util.List;

public interface Neighborhood {

    /***
     * Generates a set of (x,y) coordinates for specify the Moore neighborhood of
     * the current (i,j) cell in the cellular automaton (bi-dimensional).
     * 
     * @param i          The i coordinate of the cell.
     * @param j          The j coordinate of the cell.
     * @param sizeFactor Scales the Moore neighborhood making it bigger. This number
     *                   has to be an integer greater or equal than 1 but not
     *                   greater than floor((min(width,height)-1) / 2).
     * @param width      The automaton width.
     * @param height     The automaton height.
     * @param isModular  If true, will generate a modular Moore neighborhood.
     * @return A list of arrays of size 2 which one containing (x,y) coordinates of
     *         the Moore neighbors.
     * @throws Exception If sizeFactor constraints are violated.
     */
    static List<int[]> Moore(int i, int j, int sizeFactor, int width, int height, boolean isModular) throws Exception {
        if (sizeFactor < 1 || sizeFactor > Math.floor((Math.min(width, height) - 1) / 2))
            throw new Exception("size factor for Moore neighborhood is to big..");

        List<int[]> ret = new ArrayList<>();

        if (isModular) {
            // modular algorithm for Moore
        } else {

        }

        return ret;
    }
}