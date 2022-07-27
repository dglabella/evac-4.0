package ar.edu.unsl.evac.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.InflaterOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ar.edu.unsl.evac.engine.Engine;
import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;
import ar.edu.unsl.evac.engine.utils.EnvironmentGenerator;
import ar.edu.unsl.evac.model.Execution;
import ar.edu.unsl.evac.model.SavedState;
import ar.edu.unsl.evac.repositories.ExecutionRepository;

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
    public Execution insert(SavedState savedState) {

        // Reading deflated data...
        try {
            ByteArrayInputStream inputStream =
                    new ByteArrayInputStream(savedState.getEnvironmentData().getBytes());
            DataInputStream reader = new DataInputStream(inputStream);

            int nBytesToRead;
            nBytesToRead = reader.available();
            if (nBytesToRead > 0) {
                byte[] bytes = new byte[nBytesToRead];
                reader.read(bytes);
                String deflatedData = new String(bytes);

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                InflaterOutputStream inflater = new InflaterOutputStream(outputStream);
                inflater.write(bytes);

                // System.out.println("========================== RESULT
                // ==========================\n"
                // + outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // int width = 32;
        // int height = 32;

        // CellularAutomatonParser parser = new CellularAutomatonParser();

        // Engine engine = new Engine(new EnvironmentGenerator().generateEnvironment2(width,
        // height),
        // 1, null, parser);
        // System.out.println("Runnning Simulation...");
        // engine.execute();
        // System.out.println("Ending simulation run.");

        // System.out.println("Parsing...");
        // String jsonExecution = "{\"width\":" + width + ",\"height\":" + height + ",";
        // jsonExecution += parser.generateExecutionJson(width, height, "generations",
        // engine.getRunGenerations());

        // jsonExecution += "}";


        // Execution execution = new Execution();

        // return this.executionRepository.save(execution);
        return null;
    }

    public Execution update(Execution execution) {
        return this.executionRepository.save(execution); // save should update if the user already
                                                         // exists
    }

    public void delete(Execution execution) {
        this.executionRepository.delete(execution);
    }
}
