package ar.edu.unsl.evac.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.model.Scenario;
import ar.edu.unsl.evac.repositories.ScenarioRepository;

@Service
public class ScenarioService {

    @Autowired
    private ScenarioRepository scenarioRepository;

    public List<Scenario> getAll() {
        return this.scenarioRepository.findAll();
    }
}
