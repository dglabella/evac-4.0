package ar.edu.unsl.evac.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unsl.evac.model.ProjectState;

@Repository
public interface ProjectStateRepository extends MongoRepository<ProjectState, String> {

}
