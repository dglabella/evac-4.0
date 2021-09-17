package ar.edu.unsl;

import ar.edu.unsl.engine.Engine;

public final class App {

    private final static int WIDTH = 8;
    private final static int HEIGHT = 8;
    private final static int SUBSTEPS = 10;

    private App() {

    }

    public static void main(String[] args) {

        EnviromentGenerator mapGenerator = new EnviromentGenerator();
        Engine engine =
                new Engine(mapGenerator.generateEnviroment(App.WIDTH, App.HEIGHT), App.SUBSTEPS);

        engine.execute();
        engine.generateReport();
    }
}
