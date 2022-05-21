package ar.edu.unsl.evac.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.model.Scenario;
import ar.edu.unsl.evac.repositories.ScenarioRepository;

@Service
public class ScenarioService {

    @Autowired
    private ScenarioRepository scenarioRepository;

    public Scenario getOne(String id) {
        Optional<Scenario> optional = Optional.empty();
        optional = this.scenarioRepository.findById(id);
        return optional.orElse(new Scenario());
    }

    public List<Scenario> getAll() {
        return this.scenarioRepository.findAll();
    }

    public Scenario insert(Scenario scenario) {
        return this.scenarioRepository.save(scenario);
    }

    public Scenario update(Scenario scenario) {
        return this.scenarioRepository.save(scenario); // save should update if the user already
                                                       // exists
    }

    public void delete(Scenario scenario) {
        this.scenarioRepository.delete(scenario);
    }

}
