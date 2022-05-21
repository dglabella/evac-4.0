package ar.edu.unsl.evac.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return this.stateRepository.insert(state);
    }

    public State update(State state) {
        return this.stateRepository.save(state);
    }

    public void delete(State state) {
        this.stateRepository.delete(state);
    }
}
