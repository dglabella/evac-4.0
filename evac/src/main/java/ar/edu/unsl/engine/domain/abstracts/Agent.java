package ar.edu.unsl.engine.domain.abstracts;

import ar.edu.unsl.engine.domain.Observation;

public abstract class Agent {

    private BehaviorEngine behaviorEngine;
    private Cell cell;

    protected abstract Observation perceive(Enviroment enviroment);
}
