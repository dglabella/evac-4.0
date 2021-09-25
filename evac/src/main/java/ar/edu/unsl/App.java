package ar.edu.unsl;

import ar.edu.unsl.engine.Engine;
import ar.edu.unsl.model.utils.EnviromentGenerator;

public final class App {

    private final static int WIDTH = 8;
    private final static int HEIGHT = 8;
    private final static int SUBSTEPS = 1;

    private App() {

    }

    public static void main(String[] args) {
        Engine engine = new Engine(new EnviromentGenerator().generateEnviroment(App.WIDTH, App.HEIGHT), App.SUBSTEPS);
        engine.execute();
        engine.generateReport();
    }
}
