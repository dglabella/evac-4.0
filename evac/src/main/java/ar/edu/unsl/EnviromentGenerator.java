package ar.edu.unsl;

import ar.edu.unsl.engine.domain.abstracts.Enviroment;
import ar.edu.unsl.model.CellularAutomaton;
import ar.edu.unsl.model.neighborhoods.Neighborhood;

public class EnviromentGenerator {

    public Enviroment generateEnviroment(int width, int height, Neighborhood neighborhood) {

        CellularAutomaton enviroment = new CellularAutomaton(width, height, neighborhood);

        for (int i = 0; i < enviroment.getWidth(); i++) {
            for (int j = 0; j < enviroment.getHeight(); j++) {
                double random = Math.random();
                if (random < 0.25) {
                    enviroment.getCells()[i][j].setDefinition(new Fire());
                } else if (random < 0.5) {
                    enviroment.getCells()[i][j].setDefinition(new Grass());
                }
            }
        }
        return enviroment;
    }
}