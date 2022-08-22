package ar.edu.unsl.evac.scenarios.gol;

import ar.edu.unsl.evac.engine.domain.Visitable;

public interface GameOfLifeVisitable extends Visitable {

    void accept(GameOfLifeVisitor visitor);

}
