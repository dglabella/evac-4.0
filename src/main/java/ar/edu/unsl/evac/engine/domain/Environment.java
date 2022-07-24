package ar.edu.unsl.evac.engine.domain;

import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;

public interface Environment {

    int agentsRemaining();

    void evolve();

    String generateState(CellularAutomatonParser parser);

    void generateView();
}
