package ar.edu.unsl;

import ar.edu.unsl.model.CellularAutomaton;

public final class App {

    private final static int WIDTH = 8;
    private final static int HEIGHT = 8;

    private App() {

    }

    public static void main(String[] args) {

        CellularAutomaton enviroment = new CellularAutomaton(WIDTH, HEIGHT);
        for (int i = 0; i < enviroment.getWidth(); i++) {
            for (int j = 0; j < enviroment.getHeight(); j++) {
                double random = Math.random();
                if (random < 0.33) {
                    enviroment.getCells()[i][j].setDefinition(definition);
                }

            }
        }

        enviroment.evolve();
    }
}
