package ar.edu.unsl.evac.engine.domain;

import ar.edu.unsl.evac.engine.domain.Cell;
import ar.edu.unsl.evac.engine.domain.Observation;

public abstract class Agent {

    private BehaviorEngine behaviorEngine;
    private Cell cell;

    public BehaviorEngine getBehaviorEngine() {
        return this.behaviorEngine;
    }

    public void setBehaviorEngine(BehaviorEngine behaviorEngine) {
        this.behaviorEngine = behaviorEngine;
    }

    public Cell getCell() {
        return this.cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public abstract Observation perceive(Environment enviroment);
}
