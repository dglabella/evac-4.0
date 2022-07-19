package ar.edu.unsl.evac.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.model.Execution;
import ar.edu.unsl.evac.repositories.ExecutionRepository;

@Service
public class ExecutionService {

    @Autowired
    private ExecutionRepository executionRepository;

    public Execution getOne(String id) {
        Optional<Execution> optional = Optional.empty();
        optional = this.executionRepository.findById(id);
        return optional.orElse(new Execution());
    }

    public List<Execution> getAll() {
        return this.executionRepository.findAll();
    }

    public Execution insert(Execution execution) {
        return this.executionRepository.save(execution);
    }

    public Execution update(Execution execution) {
        return this.executionRepository.save(execution); // save should update if the user already
                                                         // exists
    }

    public void delete(Execution execution) {
        this.executionRepository.delete(execution);
    }
}
