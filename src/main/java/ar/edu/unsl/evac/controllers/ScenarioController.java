package ar.edu.unsl.evac.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unsl.evac.Application;
import ar.edu.unsl.evac.model.Scenario;
import ar.edu.unsl.evac.services.ScenarioService;

@RestController
@RequestMapping(value = Application.EndPoint.scenarios)
public class ScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    public List<Scenario> getAllScenarios() {
        return this.scenarioService.getAll();
    }
}
