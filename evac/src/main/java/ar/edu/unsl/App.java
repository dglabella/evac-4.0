package ar.edu.unsl;

import java.util.Iterator;
import java.util.List;

import ar.edu.unsl.engine.Engine;
import ar.edu.unsl.model.neighborhoods.Neighborhood;

public final class App {

    private final static int WIDTH = 8;
    private final static int HEIGHT = 8;
    private final static int SUBSTEPS = 10;

    private App() {

    }

    public static void main(String[] args) {

        try {
            Iterator<int[]> moore = Neighborhood.Moore(3, 3, 2, 8, 8, false).iterator();
            while (moore.hasNext()) {
                moore.next().toString();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Engine engine = new Engine(
        // new EnviromentGenerator().generateEnviroment(App.WIDTH, App.HEIGHT),
        // App.SUBSTEPS);
        // engine.execute();
        // engine.generateReport();
    }
}
