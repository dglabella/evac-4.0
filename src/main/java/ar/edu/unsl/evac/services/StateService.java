package ar.edu.unsl.evac.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.utils.EnvironmentGenerator;
import ar.edu.unsl.evac.model.State;
import ar.edu.unsl.evac.repositories.StateRepository;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public State getOne(String stateId) {
        Optional<State> optional = Optional.empty();
        optional = this.stateRepository.findById(stateId);
        return optional.orElse(new State());
    }

    // public List<State> getAll() {
    // return null;
    // }

    public State insert(State state) {
        // return this.stateRepository.insert(state);
        State s = new State();
        s.setId("628f5326b1ab917d52d82913");
        s.setAnnotation("initial state from a game of life experiment");
        s.setCurrentGeneration(80);
        s.setEnvironment(
                (CellularAutomaton) new EnvironmentGenerator().generateEnvironment2(32, 32));
        this.stateRepository.insert(s);
        return s;
    }

    public State update(State state) {
        return this.stateRepository.save(state);
    }

    public void delete(State state) {
        this.stateRepository.delete(state);
    }
}
