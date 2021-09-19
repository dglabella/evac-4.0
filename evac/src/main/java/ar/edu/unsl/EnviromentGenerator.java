package ar.edu.unsl;

import ar.edu.unsl.engine.domain.abstracts.Enviroment;
import ar.edu.unsl.model.CellularAutomaton;

public class EnviromentGenerator {

    public Enviroment generateEnviroment(int width, int height) {

        CellularAutomaton enviroment = new CellularAutomaton(width, height);


        return enviroment;
    }
}
