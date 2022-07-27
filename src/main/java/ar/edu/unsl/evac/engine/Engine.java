package ar.edu.unsl.evac.engine;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unsl.evac.engine.domain.Environment;
import ar.edu.unsl.evac.engine.domain.ReportManager;
import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;

public class Engine {

    private Environment enviroment;
    private int subSteps;

    private ReportManager reportManager;

    private CellularAutomatonParser parser;
    private List<String> runGenerations;

    public Engine(Environment enviroment, int subSteps, ReportManager reportManager,
            CellularAutomatonParser parser) {

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

    public void execute() {
        // while (this.enviroment.agentsRemaining() > 0) {
        // this.timeStep();
        // }
        for (int n = 0; n < 131; n++) {
            this.timeStep();
        }


    }
}
