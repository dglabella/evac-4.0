package ar.edu.unsl.evac.engine.utils;

import java.util.Random;
import ar.edu.unsl.evac.engine.domain.Cell;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.domain.Environment;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifeDefinition;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifeCellState;

public class EnvironmentGenerator {

        private CellularAutomaton generateEnvironment(int width, int height) {
                CellularAutomaton environment = new CellularAutomaton(width, height);
                Cell[][] cells = environment.getCells();
                Cell cell;
                GameOfLifeDefinition d;

                for (Cell[] row : cells) {
                        for (Cell c : row) {
                                d = new GameOfLifeDefinition();
                                d.setState(d.stateSetUp());
                                c.setDef(d);
                                c.setPostState(d.stateSetUp());
                        }
                }

                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                cell = cells[i][j];
                                cell.setNeighbors(cell.getDef().setUpNeighborhood(i, j, width,
                                                height));

                                cell.setNeighborhoodCells(environment
                                                .obtainNeighborhoodCells(cell.getNeighbors()));

                                cell.setNeighborhoodStates(
                                                environment.obtainNeighborhoodCellStates(i, j));
                        }
                }
                return environment;
        }


        public Environment generateEnvironment1(int width, int height) {
                Random random = new Random(System.currentTimeMillis());

                CellularAutomaton environment = this.generateEnvironment(width, height);
                Cell[][] cells = environment.getCells();

                for (Cell[] row : cells) {
                        for (Cell c : row) {
                                ((GameOfLifeCellState) c.getDef().getState())
                                                .setAlive(random.nextDouble() > 0.7 ? true : false);
                        }
                }

                return environment;
        }

        public Environment generateEnvironment2(int width, int height) {
                CellularAutomaton environment = this.generateEnvironment(width, height);

                // Diehard
                ((GameOfLifeCellState) environment.getCells()[10][16].getDef().getState())
                                .setAlive(true);
                ((GameOfLifeCellState) environment.getCells()[10][17].getDef().getState())
                                .setAlive(true);
                ((GameOfLifeCellState) environment.getCells()[11][17].getDef().getState())
                                .setAlive(true);
                ((GameOfLifeCellState) environment.getCells()[9][22].getDef().getState())
                                .setAlive(true);
                ((GameOfLifeCellState) environment.getCells()[11][21].getDef().getState())
                                .setAlive(true);
                ((GameOfLifeCellState) environment.getCells()[11][22].getDef().getState())
                                .setAlive(true);
                ((GameOfLifeCellState) environment.getCells()[11][23].getDef().getState())
                                .setAlive(true);

                return environment;
        }
}
