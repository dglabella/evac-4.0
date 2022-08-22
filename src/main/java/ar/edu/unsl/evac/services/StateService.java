package ar.edu.unsl.evac.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;
import ar.edu.unsl.evac.engine.utils.EnvironmentCompressor;
import ar.edu.unsl.evac.engine.utils.EnvironmentParser;
import ar.edu.unsl.evac.model.SavedState;
import ar.edu.unsl.evac.repositories.StateRepository;

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
    public SavedState insert(byte[] savedStateCompressed) {
        EnvironmentCompressor environmentCompressor = new EnvironmentCompressor();
        EnvironmentParser<CellularAutomaton> environmentParser = new CellularAutomatonParser();

        try {
            byte[] uncompressedData = environmentCompressor.uncompress(savedStateCompressed);
            CellularAutomaton cellularAutomaton =
                    environmentParser.parseStateToObject(new String(uncompressedData));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.stateRepository.save(new SavedState());
    }

    public SavedState update(SavedState state) {
        return this.stateRepository.save(state);
    }

    public void delete(SavedState state) {
        this.stateRepository.delete(state);
    }
}
