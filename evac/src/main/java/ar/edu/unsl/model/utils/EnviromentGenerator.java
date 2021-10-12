package ar.edu.unsl.model.utils;

import java.util.Random;

import ar.edu.unsl.engine.domain.abstracts.Enviroment;
import ar.edu.unsl.engine.domain.concretes.CellularAutomaton;
import ar.edu.unsl.model.definitions.GameOfLife;

public class EnviromentGenerator {

    public Enviroment generateEnviroment1(int width, int height) {
        Random random = new Random(System.currentTimeMillis());

        CellularAutomaton enviroment = new CellularAutomaton(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                enviroment.getCells()[i][j]
                        .setDefinition(new GameOfLife(random.nextDouble() < 0.2 ? true : false));
            }
        }

        return enviroment;
    }

    public Enviroment generateEnviroment2(int width, int height) {
        CellularAutomaton enviroment = new CellularAutomaton(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                enviroment.getCells()[i][j].setDefinition(new GameOfLife(false));
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
        ((GameOfLife) enviroment.getCells()[10][16].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[10][17].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[11][17].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[9][22].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[11][21].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[11][22].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[11][23].getDefinition()).setAlive(true);



        return enviroment;
    }

    public Enviroment generateEnviroment3(int width, int height) {
        CellularAutomaton enviroment = new CellularAutomaton(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                enviroment.getCells()[i][j].setDefinition(new GameOfLife(false));
            }
        }

        // chesslike pattern automaton
        ((GameOfLife) enviroment.getCells()[5][5].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[5][7].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[5][9].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[6][6].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[6][8].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[7][5].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[7][7].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[7][9].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[8][6].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[8][8].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[9][5].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[9][7].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[9][9].getDefinition()).setAlive(true);

        return enviroment;
    }
}
