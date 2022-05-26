package ar.edu.unsl.evac.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.model.User;
import ar.edu.unsl.evac.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getOne(String username) {
        return this.userRepository.findByUsername(username);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User insert(User user) {
        return this.userRepository.insert(user);
    }

    public User update(User user) {
        return this.userRepository.save(user); // save should update if the user already exists
    }

    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
