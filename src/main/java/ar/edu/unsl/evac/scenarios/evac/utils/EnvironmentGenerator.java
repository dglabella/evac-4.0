package ar.edu.unsl.evac.scenarios.evac.utils;

import java.util.Random;
import ar.edu.unsl.evac.engine.domain.Cell;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.domain.Environment;
import ar.edu.unsl.evac.scenarios.evac.definitions.GameOfLife;

public class EnvironmentGenerator {

    public Environment generateEnvironment1(int width, int height) {
        Random random = new Random(System.currentTimeMillis());

        CellularAutomaton environment = new CellularAutomaton(width, height);
        Cell cell;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                cell = environment.getCells()[i][j];
                cell.setDefinition(new GameOfLife(false));
                cell.getDefinition().setUpNeighborhood(width, height);
            }
        }

        return environment;
    }

    public Environment generateEnvironment2(int width, int height) {
        CellularAutomaton environment = new CellularAutomaton(width, height);
        Cell cell;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cell = environment.getCells()[i][j];
                cell.setDefinition(new GameOfLife(false));
                cell.getDefinition().setUpNeighborhood(width, height);
            }
        }

        // // chesslike automaton
        // ((GameOfLife) enviroment.getCells()[0][2].getDefinition()).setAlive(true);
        // ((GameOfLife) enviroment.getCells()[1][1].getDefinition()).setAlive(true);
        // ((GameOfLife) enviroment.getCells()[1][2].getDefinition()).setAlive(true);
        // ((GameOfLife) enviroment.getCells()[1][3].getDefinition()).setAlive(true);
        // ((GameOfLife) enviroment.getCells()[2][2].getDefinition()).setAlive(true);
        // ((GameOfLife) enviroment.getCells()[3][2].getDefinition()).setAlive(true);

        // Diehard
        ((GameOfLife) environment.getCells()[10][16].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[10][17].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[11][17].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[9][22].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[11][21].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[11][22].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[11][23].getDefinition()).setAlive(true);



        return environment;
    }

    public Environment generateEnvironment3(int width, int height) {
        CellularAutomaton environment = new CellularAutomaton(width, height);
        Cell cell;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cell = environment.getCells()[i][j];
                cell.setDefinition(new GameOfLife(false));
                cell.getDefinition().setUpNeighborhood(width, height);
            }
        }

        // chesslike pattern automaton
        ((GameOfLife) environment.getCells()[5][5].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[5][7].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[5][9].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[6][6].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[6][8].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[7][5].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[7][7].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[7][9].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[8][6].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[8][8].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[9][5].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[9][7].getDefinition()).setAlive(true);
        ((GameOfLife) environment.getCells()[9][9].getDefinition()).setAlive(true);

        return environment;
    }
}
