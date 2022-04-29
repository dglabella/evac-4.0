package ar.edu.unsl.evac.engine;

import ar.edu.unsl.evac.engine.domain.Environment;
import ar.edu.unsl.evac.engine.domain.ReportManager;

public class Engine {

    private ReportManager reportManager;

    private Environment enviroment;

    private int subSteps;

    public Engine(Environment enviroment, int subSteps) {
        this.enviroment = enviroment;
        this.subSteps = subSteps;
    }

    private void agentsUpdatePhase() {}

    private void responsePropagationPhase() {}

    private void conflictResolutionPhase() {}

    private void intentionalPhase() {}

    private void environmentalPhase() {
        this.enviroment.generateView();
        this.enviroment.evolve();
    }

    private void timeStep() {
        for (int i = 0; i < this.subSteps; i++) {
            this.environmentalPhase();
            this.intentionalPhase();
            this.conflictResolutionPhase();
            this.responsePropagationPhase();
            this.agentsUpdatePhase();
        }
    }

    public void execute() {
        // while (this.enviroment.agentsRemaining() > 0) {
        // this.timeStep();
        // }
        for (int n = 0; n < 135; n++) {
            this.timeStep();
        }
    }

    public void generateReport() {
        System.err.println("No implementation yet for reporting results");
    }
}
