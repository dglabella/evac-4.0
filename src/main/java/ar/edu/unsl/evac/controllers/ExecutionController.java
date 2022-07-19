package ar.edu.unsl.evac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unsl.evac.Application;
import ar.edu.unsl.evac.engine.Engine;
import ar.edu.unsl.evac.model.Execution;
import ar.edu.unsl.evac.model.SavedState;
import ar.edu.unsl.evac.services.ExecutionService;

@RestController
@RequestMapping(value = Application.EndPoint.executions)
public class ExecutionController {

    @Autowired
    private ExecutionService executionService;

    @RequestMapping(value = "/{id}")
    public Execution getExecution(@PathVariable String id) {
        return this.executionService.getOne(id);
    }

    @PostMapping(consumes = {"application/json"})
    public void run(@RequestBody SavedState state) {
        Execution execution = null;
        new Runnable() {
            @Override
            public void run() {
                Engine engine = new Engine(state.getEnvironment(), 1);
                engine.execute();
            }
        }.run();
    }
}
