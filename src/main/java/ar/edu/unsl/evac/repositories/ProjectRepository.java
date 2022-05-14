package ar.edu.unsl.evac.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ar.edu.unsl.evac.model.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

    // @Query(value = "{ 'owner' : ObjectId(?0) }",
    // fields = "{'owner' : 0, 'scenario' : 0, 'savedStates' : 0}")
    @Query(value = "{ 'ownerId' : ObjectId(?0) }")
    List<Project> findAllFromUser(String ownerId);
}
