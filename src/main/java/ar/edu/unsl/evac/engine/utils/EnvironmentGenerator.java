package ar.edu.unsl.evac.engine.utils;

import ar.edu.unsl.evac.engine.domain.Cell;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.domain.Environment;
// import java.util.Random;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifeDefinition;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifePropertiesBundle;

public class EnvironmentGenerator {

        public Environment generateEnvironment1(int width, int height) {
                // Random random = new Random(System.currentTimeMillis());

                CellularAutomaton environment = new CellularAutomaton(width, height);
                Cell cell;
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                cell.setDefinition(new GameOfLifeDefinition(
                                                new GameOfLifePropertiesBundle()));
                        }
                }

                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                cell.setNeighborhoodCoords(cell.getDefinition().setUpNeighborhood(i,
                                                j, width, height));

                                cell.setNeighborhoodCells(environment.obtainNeighborhoodCells(
                                                cell.getNeighborhoodCoords()));

                                cell.setNeighborhoodCellsPropertiesBundles(environment
                                                .obtainNeighborhoodCellsPropertiesBundles(i, j));
                        }
                }

                return environment;
        }

        public Environment generateEnvironment2(int width, int height) {
                CellularAutomaton environment = new CellularAutomaton(width, height);
                Cell cell;
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                cell.setDefinition(new GameOfLifeDefinition(
                                                new GameOfLifePropertiesBundle()));
                        }
                }

                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                cell.setNeighborhoodCoords(cell.getDefinition().setUpNeighborhood(i,
                                                j, width, height));

                                cell.setNeighborhoodCells(environment.obtainNeighborhoodCells(
                                                cell.getNeighborhoodCoords()));

                                cell.setNeighborhoodCellsPropertiesBundles(environment
                                                .obtainNeighborhoodCellsPropertiesBundles(i, j));
                        }
                }

                // Diehard
                ((GameOfLifePropertiesBundle) environment.getCells()[10][16].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[10][17].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[11][17].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[9][22].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[11][21].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[11][22].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[11][23].getDefinition()
                                .getPropertiesBundle()).setAlive(true);

                return environment;
        }

        public Environment generateEnvironment3(int width, int height) {
                CellularAutomaton environment = new CellularAutomaton(width, height);
                Cell cell;
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                cell.setDefinition(new GameOfLifeDefinition(
                                                new GameOfLifePropertiesBundle()));
                        }
                }

                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = environment.getCells()[i][j];
                                cell.setNeighborhoodCoords(cell.getDefinition().setUpNeighborhood(i,
                                                j, width, height));

                                cell.setNeighborhoodCells(environment.obtainNeighborhoodCells(
                                                cell.getNeighborhoodCoords()));

                                cell.setNeighborhoodCellsPropertiesBundles(environment
                                                .obtainNeighborhoodCellsPropertiesBundles(i, j));
                        }
                }

                // chesslike pattern automaton
                ((GameOfLifePropertiesBundle) environment.getCells()[5][5].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[5][7].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[5][9].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[6][6].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[6][8].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[7][5].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[7][7].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[7][9].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[8][6].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[8][8].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[9][5].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[9][7].getDefinition()
                                .getPropertiesBundle()).setAlive(true);
                ((GameOfLifePropertiesBundle) environment.getCells()[9][9].getDefinition()
                                .getPropertiesBundle()).setAlive(true);

                return environment;
        }
}
