package ar.edu.unsl.model.neighborhoods;

import java.util.ArrayList;
import java.util.List;

public interface Neighborhood {

    /**
     * Generates uniformly the neighborhood of all cells in the automaton.
     * 
     * @param cellularAutomaton The cellular Automaton.
     * @param size The size of the neighborhood.
     */
    static List<int[]> Moore(int i, int j, int sizeFactor, boolean isCircular) {
        List<int[]> ret = new ArrayList<>();

        if (!isCircular) {
            for (int k = 0; k < sizeFactor; k++) {
                ret.add(new int[] {i - (k * 1), j - (k * 1)});
                ret.add(new int[] {i - (k * 1), j - (k * 1)});
            }
        } else {
            System.err.println("not implemented yet...");
        }
        return ret;
    }
}
