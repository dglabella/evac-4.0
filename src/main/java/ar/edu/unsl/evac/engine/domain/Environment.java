package ar.edu.unsl.evac.engine.domain;

public interface Environment {

    int agentsRemaining();

    void evolve();

    void generateView();
}
