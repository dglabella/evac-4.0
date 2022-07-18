package ar.edu.unsl.evac.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unsl.evac.Application;

@RestController
@RequestMapping(value = Application.EndPoint.executions)
public class ExecutionController {

}
