package ar.edu.unsl.evac.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;
import ar.edu.unsl.evac.engine.utils.EnvironmentCompressor;
import ar.edu.unsl.evac.engine.utils.EnvironmentParser;
import ar.edu.unsl.evac.model.Execution;
import ar.edu.unsl.evac.repositories.ExecutionRepository;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifePropertiesBundle;

@Service
public class ExecutionService {

    @Autowired
    private ExecutionRepository executionRepository;

    public Execution getOne(String id) {
        Optional<Execution> optional = Optional.empty();
        optional = this.executionRepository.findById(id);
        return optional.orElse(new Execution());
    }

    public List<Execution> getAll() {
        return this.executionRepository.findAll();
    }

    @Async
    public void insert(byte[] savedStateByteArray) {
        EnvironmentCompressor environmentCompressor = new EnvironmentCompressor();
        EnvironmentParser<CellularAutomaton> environmentParser = new CellularAutomatonParser();
        try {
            byte[] uncompressData = environmentCompressor.uncompress(savedStateByteArray);
            CellularAutomaton environment =
                    environmentParser.parseStateToObject(new String(uncompressData));

            System.out.println("Cell[10][16] is alive ?: "
                    + ((GameOfLifePropertiesBundle) environment.getCells()[10][16].getDefinition()
                            .getPropertiesBundle()).isAlive());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Execution update(Execution execution) {
        return this.executionRepository.save(execution); // save should update if the user already
                                                         // exists
    }

    public void delete(Execution execution) {
        this.executionRepository.delete(execution);
    }
}
