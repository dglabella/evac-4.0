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
        // try {

        // int i, j;
        // i = 0;
        // j = 0;

        // List<int[]> coords = Neighborhood.Moore(i, j, 1, 8, 4, false);

        // System.out.println("(" + i + "," + j + ") neighbors ->");
        // for (int n = 0; n < coords.size(); n++) {
        // System.out.println("\t(" + coords.get(n)[0] + "," + coords.get(n)[1] + ")");
        // }
        // } catch (Exception e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }


        Engine engine = new Engine(
                new EnviromentGenerator().generateEnviroment1(App.WIDTH, App.HEIGHT), App.SUBSTEPS);
        engine.execute();
        engine.generateReport();

    }
}
