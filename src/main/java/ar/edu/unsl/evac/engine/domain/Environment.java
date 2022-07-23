package ar.edu.unsl.evac.engine.domain;

public interface Environment {

    int agentsRemaining();

    void evolve();

    String generateState(StateParser parser);

    void generateView();
}
