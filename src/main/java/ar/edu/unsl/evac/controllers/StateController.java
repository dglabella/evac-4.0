package ar.edu.unsl.evac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unsl.evac.Application;
import ar.edu.unsl.evac.model.SavedState;
import ar.edu.unsl.evac.model.SavedStateOld;
import ar.edu.unsl.evac.services.StateService;

@RestController
@RequestMapping(value = Application.EndPoint.states)
public class StateController {

    @Autowired
    private StateService stateService;

    @RequestMapping(value = "/{id}")
    public SavedState getAllStatesFromProject(@PathVariable String id) {
        return this.stateService.getOne(id);
    }

    @PostMapping(consumes = {"application/json"})
    public String stateRegister(@RequestBody SavedStateOld state) {
        String s = this.stateService.insert(state).getId();
        return s;
    }
}
