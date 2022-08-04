package ar.edu.unsl.evac.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;
import ar.edu.unsl.evac.engine.utils.EnvironmentGenerator;
import ar.edu.unsl.evac.model.SavedState;
import ar.edu.unsl.evac.repositories.StateRepository;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifePropertiesBundle;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public SavedState getOne(String stateId) {
        Optional<SavedState> optional = Optional.empty();
        optional = this.stateRepository.findById(stateId);
        return optional.orElse(new SavedState());
    }

    @Async
    public SavedState insert() {
        SavedState s = new SavedState();
        s.setId("628f5326b1ab917d52d82913");
        s.setAnnotation("initial state from a game of life experiment");
        s.setCurrentGeneration(65);

        // s.setEnvironmentData(new CellularAutomatonParser().parseStateToJson(
        // (CellularAutomaton) new EnvironmentGenerator().generateEnvironment2(32, 32)));

        s.setEnvironmentData(
                (CellularAutomaton) new EnvironmentGenerator().generateEnvironment2(32, 32));

        // System.out.println("cell[10][16] is alive?: "
        // + ((GameOfLifePropertiesBundle) s.getEnvironmentData().getCells()[10][16].getDef()
        // .getPropertiesBundle()).isAlive());

        System.out.println("22222222222");
        this.stateRepository.save(s);
        System.out.println("3333333333333");
        return s;
    }

    public SavedState update(SavedState state) {
        return this.stateRepository.save(state);
    }

    public void delete(SavedState state) {
        this.stateRepository.delete(state);
    }
}
