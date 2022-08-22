package ar.edu.unsl.evac.scenarios.gol;

import ar.edu.unsl.evac.engine.domain.Visitor;

public interface GameOfLifeVisitor extends Visitor {

    void visit(Game cellstate);

    void visit(GameOfLifeOtherCellState cellstate);

}
