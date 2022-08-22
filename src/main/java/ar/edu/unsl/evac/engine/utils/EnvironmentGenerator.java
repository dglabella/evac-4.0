package ar.edu.unsl.evac.engine.utils;

import java.util.Random;
import ar.edu.unsl.evac.engine.domain.Cell;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.domain.Environment;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifeDefinition;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifeCellState;

public class EnvironmentGenerator {

        public Environment generateEnvironment1(int width, int height) {
                Random random = new Random(System.currentTimeMillis());

                CellularAutomaton environment = new CellularAutomaton(width, height);
                Cell cell;
                GameOfLifeDefinition gol;
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                gol = new GameOfLifeDefinition();
                                gol.setState(new GameOfLifeCellState());
                                cell.setDef(gol);
                        }
                }

                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                cell.setNeighbors(cell.getDef().setUpNeighborhood(i, j, width,
                                                height));

                                cell.setNeighborhoodCells(environment
                                                .obtainNeighborhoodCells(cell.getNeighbors()));

                                cell.setNeighborhoodCellsPropertiesBundles(environment
                                                .obtainNeighborhoodCellsPropertiesBundles(i, j));
                        }
                }

                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                ((GameOfLifePropertiesBundle) cell.getDef().getPropertiesBundle())
                                                .setAlive(random.nextDouble() > 0.7 ? true : false);
                        }
                }

                return environment;
        }

        public Environment generateEnvironment2(int width, int height) {
                CellularAutomaton environment = new CellularAutomaton(width, height);
                Cell cell;
                GameOfLifeDefinition gol;
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                gol = new GameOfLifeDefinition();
                                gol.setPropertiesBundle(new GameOfLifePropertiesBundle());
                                cell.setDef(gol);
                        }
                }

                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                cell.setNeighbors(cell.getDef().setUpNeighborhood(i, j, width,
                                                height));

                                cell.setNeighborhoodCells(environment
                                                .obtainNeighborhoodCells(cell.getNeighbors()));

                                cell.setNeighborhoodCellsPropertiesBundles(environment
                                                .obtainNeighborhoodCellsPropertiesBundles(i, j));
                        }
                }

                // Diehard
                ((GameOfLifePropertiesBundle) environment.getCells()[10][16].getDef()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[10][17].getDef()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[11][17].getDef()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[9][22].getDef()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[11][21].getDef()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[11][22].getDef()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[11][23].getDef()
                                .getPropertiesBundle()).setAlive(true);

                return environment;
        }

        // public Environment generateEnvironment3(int width, int height) {
        // CellularAutomaton environment = new CellularAutomaton(width, height);
        // Cell cell;
        // for (int i = 0; i < height; i++) {
        // for (int j = 0; j < width; j++) {
        // cell = environment.getCells()[i][j];
        // cell.setDef(new GameOfLifeDefinition(
        // new GameOfLifePropertiesBundle()));
        // }
        // }

        // for (int i = 0; i < height; i++) {
        // for (int j = 0; j < width; j++) {
        // cell = environment.getCells()[i][j];
        // cell.setNeighbors(cell.getDef().setUpNeighborhood(i, j, width,
        // height));

        // cell.setNeighborhoodCells(environment
        // .obtainNeighborhoodCells(cell.getNeighbors()));

        // cell.setNeighborhoodCellsPropertiesBundles(environment
        // .obtainNeighborhoodCellsPropertiesBundles(i, j));
        // }
        // }

        // // chesslike pattern automaton
        // ((GameOfLifePropertiesBundle) environment.getCells()[5][5].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[5][7].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[5][9].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[6][6].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[6][8].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[7][5].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[7][7].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[7][9].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[8][6].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[8][8].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[9][5].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[9][7].getDef()
        // .getPropertiesBundle()).setAlive(true);
        // ((GameOfLifePropertiesBundle) environment.getCells()[9][9].getDef()
        // .getPropertiesBundle()).setAlive(true);

        // return environment;
        // }
}
