package ar.edu.unsl.evac.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ar.edu.unsl.evac.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query(value = "{ 'username' : ?0 }")
    User findByUsername(String username);

}
