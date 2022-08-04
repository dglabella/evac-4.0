package ar.edu.unsl.evac.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;
import ar.edu.unsl.evac.engine.utils.EnvironmentGenerator;
import ar.edu.unsl.evac.model.SavedState;
import ar.edu.unsl.evac.model.SavedStateOld;
import ar.edu.unsl.evac.repositories.StateOldReporsitory;
import ar.edu.unsl.evac.repositories.StateRepository;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private StateOldReporsitory stateOldRepository;

    public SavedState getOne(String stateId) {
        Optional<SavedState> optional = Optional.empty();
        optional = this.stateRepository.findById(stateId);
        return optional.orElse(new SavedState());
    }

    // public List<State> getAll() {
    // return null;
    // }

    public SavedStateOld insert(SavedStateOld state) {
        // return this.stateRepository.insert(state);
        // SavedState s = new SavedState();
        SavedStateOld s = new SavedStateOld();
        s.setId("628f5326b1ab917d52d82913");
        s.setAnnotation("initial state from a game of life experiment");
        s.setCurrentGeneration(65);

        try {
            // s.setEnvironmentData(new CellularAutomatonParser().parseStateToJson(
            // (CellularAutomaton) new EnvironmentGenerator().generateEnvironment2(32, 32)));

            s.setEnvironment(
                    (CellularAutomaton) new EnvironmentGenerator().generateEnvironment2(32, 32));
            this.stateOldRepository.insert(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public SavedState update(SavedState state) {
        return this.stateRepository.save(state);
    }

    public void delete(SavedState state) {
        this.stateRepository.delete(state);
    }
}
