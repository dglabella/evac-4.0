package ar.edu.unsl.evac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unsl.evac.Application;
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

    // @PostMapping(consumes = {"application/json"})
    @PostMapping
    public String run(@RequestBody SavedState savedState) {
        // should return a object with information about the state
        System.out.println("before insert");

        this.executionService.execute(savedState);

        System.out.println("after insert");

        return "execution request sended!";
    }
}
