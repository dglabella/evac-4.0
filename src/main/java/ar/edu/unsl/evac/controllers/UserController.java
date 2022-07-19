package ar.edu.unsl.evac.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unsl.evac.Application;
import ar.edu.unsl.evac.model.User;
import ar.edu.unsl.evac.services.UserService;

@RestController
@RequestMapping(value = Application.EndPoint.users)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<User> getAllUsers() {
        return this.userService.getAll();
    }

    @RequestMapping(value = "/{userName}")
    public User getUser(@PathVariable String userName) {
        return this.userService.getOne(userName);
    }

    @PostMapping(consumes = {"application/json"})
    public User userRegistration(@RequestBody User user) {
        return this.userService.insert(user);
    }

    @PutMapping(value = "/{username}", consumes = {"application/json"})
    public User userUpdate(@RequestBody User user) {
        return this.userService.update(user);
    }

    @DeleteMapping(value = "/{username}")
    public User userDelete(@RequestBody User user) {
        this.userService.delete(user);
        return user;
    }
}
