package ar.edu.unsl.model.utils;

import java.util.Random;

import ar.edu.unsl.engine.domain.abstracts.Enviroment;
import ar.edu.unsl.engine.domain.concretes.CellularAutomaton;
import ar.edu.unsl.model.definitions.GameOfLife;

public class EnviromentGenerator {

    // public Enviroment generateEnviroment(int width, int height) {
    // Random random = new Random(System.currentTimeMillis());

    // CellularAutomaton enviroment = new CellularAutomaton(width, height);

    // for (int i = 0; i < height; i++) {
    // for (int j = 0; j < height; j++) {
    // enviroment.getCells()[i][j].setDefinition(new GameOfLife(random.nextDouble()
    // < 0.3 ? true : false));
    // }
    // }

    // return enviroment;
    // }

    public Enviroment generateEnviroment(int width, int height) {
        CellularAutomaton enviroment = new CellularAutomaton(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                enviroment.getCells()[i][j].setDefinition(new GameOfLife(false));
            }
        }

        ((GameOfLife) enviroment.getCells()[0][2].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[1][1].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[1][2].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[1][3].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[2][2].getDefinition()).setAlive(true);
        ((GameOfLife) enviroment.getCells()[3][2].getDefinition()).setAlive(true);

        return enviroment;
    }
}
