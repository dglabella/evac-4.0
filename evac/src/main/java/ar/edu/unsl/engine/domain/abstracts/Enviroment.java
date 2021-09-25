package ar.edu.unsl.engine.domain.abstracts;

public interface Enviroment {

    int agentsRemaining();

    void evolve();

    void generateView();
}
