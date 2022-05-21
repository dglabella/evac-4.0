package ar.edu.unsl.evac.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unsl.evac.Application;
import ar.edu.unsl.evac.model.Project;
import ar.edu.unsl.evac.services.ProjectService;

@RestController
@RequestMapping(value = Application.EndPoint.projects)
public class ProjectController {

    @Autowired
    private ProjectService projectServices;

    @RequestMapping
    public List<Project> getAllProjects() {
        return this.projectServices.getAll();
    }

    @RequestMapping(value = "/{username}")
    public List<Project> getAllProjectsFromUser(@PathVariable String username) {
        return this.projectServices.getAllFromUser(username);
    }

    @RequestMapping(value = "/{id}")
    public Project getProject(@PathVariable String id) {
        return this.projectServices.getOne(id);
    }

    // @PostMapping(consumes = {"application/json"})
    // public User userRegister(@RequestBody User user) {
    // return this.userService.insert(user);
    // }

    // @PutMapping(value = "/{username}", consumes = {"application/json"})
    // public User userUpdate(@RequestBody User user) {
    // return this.userService.update(user);
    // }

    // @DeleteMapping(value = "/{username}")
    // public User userDelete(@RequestBody User user) {
    // this.userService.delete(user);
    // return user;
    // }
}
