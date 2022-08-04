package ar.edu.unsl.evac.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ar.edu.unsl.evac.model.SavedStateOld;

public interface StateOldReporsitory extends MongoRepository<SavedStateOld, String> {

}
