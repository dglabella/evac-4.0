package ar.edu.unsl.evac.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.model.Project;
import ar.edu.unsl.evac.model.User;
import ar.edu.unsl.evac.repositories.ProjectRepository;
import ar.edu.unsl.evac.repositories.UserRepository;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Project> getAllFromUser(String username) {
        User user = this.userRepository.findByUsername(username);
        return this.projectRepository.findAllFromUser(user.getId());
    }

    // public List<Project> getAll() {
    // return this.projectRepository.findAll();
    // }

    // public Project insert(Project user) {
    // return this.userRepository.save(user);
    // }

    // public Project update(Project user) {
    // return this.userRepository.save(user); // save should update if the user already exists
    // }

    // public void delete(Project user) {
    // this.userRepository.delete(user);
    // }
}
