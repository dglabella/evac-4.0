package ar.edu.unsl.evac.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.model.State;
import ar.edu.unsl.evac.repositories.StateRepository;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public State getState(String stateId) {
        State ret = null;
        Optional<State> optional = this.stateRepository.findById(stateId);
        optional.ifPresent((state) -> ret = state);
        return ret;
    }
}
