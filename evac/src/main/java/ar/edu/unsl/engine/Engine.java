package ar.edu.unsl.engine;

import ar.edu.unsl.engine.domain.abstracts.Enviroment;
import ar.edu.unsl.engine.domain.abstracts.ReportManager;

public class Engine {

    private ReportManager reportManager;

    private Enviroment enviroment;

    private int subSteps;

    public Engine(Enviroment enviroment, int subSteps) {
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
