package ar.edu.unsl.evac.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unsl.evac.model.Project;
import ar.edu.unsl.evac.services.ProjectServices;

@RestController
public class ProjectController {

    @Autowired
    private ProjectServices projectServices;

    @RequestMapping(value = "users/{username}/projects")
    public List<Project> getAllProyects(@PathVariable String username) {
        return this.projectServices.getAllFromUser(username);
    }

    // @RequestMapping(value = "users/{username}/projects/{id}")
    // public User getProject(@PathVariable String username, @PathVariable String id) {

    // }

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
