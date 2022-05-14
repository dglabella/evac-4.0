package ar.edu.unsl.evac.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unsl.evac.model.Scenario;

@Repository
public interface ScenarioRepository extends MongoRepository<Scenario, String> {

}
