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

        List<int[]> ret = new ArrayList<>();

        int topLimit = i - sizeFactor;
        int leftLimit = j - sizeFactor;
        int bottomLimit = i + sizeFactor;
        int rightLimit = j + sizeFactor;

        if (topLimit < 0)
            topLimit = 0;

        if (leftLimit < 0)
            leftLimit = 0;

        if (bottomLimit > height)
            bottomLimit = height;

        if (rightLimit > width)
            rightLimit = width;

        if (isModular) {
            if (sizeFactor < 1 || sizeFactor > Math.floor((Math.min(width, height) - 1) / 2))
                throw new Exception("size factor for modular Moore neighborhood is to big..");
            throw new Exception("modular moore not implemented yet...");
        } else {
            for (int a = topLimit; a < i; a++)
                for (int b = leftLimit; b < rightLimit; b++)
                    ret.add(new int[] { a, b });

            for (int b = leftLimit; b < rightLimit; b++) {
                if (b != j)
                    ret.add(new int[] { i, b });
            }

            for (int a = i + 1; a < bottomLimit; a++)
                for (int b = leftLimit; b < rightLimit; b++)
                    ret.add(new int[] { a, b });

        }

        return ret;
    }
}