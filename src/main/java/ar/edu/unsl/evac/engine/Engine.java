package ar.edu.unsl.evac.engine;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.domain.Environment;
import ar.edu.unsl.evac.engine.domain.StateParser;
import ar.edu.unsl.evac.engine.domain.ReportManager;
import ar.edu.unsl.evac.model.Execution;
import ar.edu.unsl.evac.model.State;
import ar.edu.unsl.evac.services.ExecutionService;

public class Engine implements Runnable {

    private ExecutionService executionService;

    private Environment enviroment;
    private int subSteps;

    private ReportManager reportManager;

    private StateParser parser;
    private List<String> runGenerations;

    public Engine(ExecutionService executionService, Environment enviroment, int subSteps,
            ReportManager reportManager, StateParser parser) {
        this.executionService = executionService;

        this.enviroment = enviroment;
        this.subSteps = subSteps;

        this.reportManager = reportManager;

        this.parser = parser;
        this.runGenerations = new ArrayList<>();
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

            this.runGenerations.add(this.enviroment.generateState(this.parser));
        }
    }

    public List<String> getRunGenerations() {
        return this.runGenerations;
    }

    public void setRunGenerations(List<String> runGenerations) {
        this.runGenerations = runGenerations;
    }

    public void generateReport() {
        System.err.println("No implementation yet for reporting results");
    }

    @Override
    public void run() {
        // while (this.enviroment.agentsRemaining() > 0) {
        // this.timeStep();
        // }

        System.out.println("Runnning Simulation...");

        for (int n = 0; n < 132; n++) {
            this.timeStep();
        }

        System.out.println("Ending simulation run.");
    }
}
