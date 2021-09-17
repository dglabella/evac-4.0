package ar.edu.unsl.engine.domain.abstracts;

public interface CellDefinition {

    void setUp(Agent agent);

    void setUp(Agent agent, Cell[] neighborhood);

    void applyRule();

    void update();

    String getCodification();
}
