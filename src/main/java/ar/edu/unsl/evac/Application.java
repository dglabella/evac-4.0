package ar.edu.unsl.evac;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ar.edu.unsl.evac.engine.Engine;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;
import ar.edu.unsl.evac.engine.utils.EnvironmentCompressor;
import ar.edu.unsl.evac.engine.utils.EnvironmentGenerator;
import ar.edu.unsl.evac.engine.utils.EnvironmentParser;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifeCellState;
import ar.edu.unsl.evac.utils.JsonStateGenerator;

@SpringBootApplication
public class Application {

	public class EndPoint {
		public final static String users = "users";
		public final static String scenarios = "scenarios";
		public final static String projects = "projects";
		public final static String states = "states";
		public final static String executions = "executions";
	}

	public static void main(String[] args) {
		// executeEngine();
		generateState();
		// readCompressedDataAndMakeAPOJO();
		// new JsonStateGenerator().generate();

		// SpringApplication.run(Application.class, args);
	}

	private static void generateState() {
		int width = 32;
		int height = 32;
		CellularAutomatonParser parser = new CellularAutomatonParser();

		Engine engine = new Engine(new EnvironmentGenerator().generateEnvironment2(width, height),
				1, null, parser);
		System.out.println("Runnning Simulation...");
		engine.execute();
		System.out.println("Ending simulation run.");

		System.out.println("Parsing...");
		String jsonInitialState = engine.getRunGenerations().get(0);

		// Save normal file...
		try {
			// Files.write(
			// new
			// File("C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\execution.json")
			// .toPath(),
			// jsonExecution.getBytes(StandardCharsets.UTF_8));
			Files.write(new File(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\initialState.json")
							.toPath(),
					jsonInitialState.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read bytes from the normal file, compress the data and save compressed data
		// into new
		// file...
		EnvironmentCompressor environmentCompressor = new EnvironmentCompressor();
		try {
			byte[] data = Files.readAllBytes(new File(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\initialState.json")
							.toPath());

			environmentCompressor = new EnvironmentCompressor();
			byte[] compressedData = environmentCompressor.compress(data);

			Files.write(new File(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\initialStateCompressed.dat")
							.toPath(),
					compressedData);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readCompressedDataAndMakeAPOJO() {
		try {
			byte[] data = Files.readAllBytes(new File(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\initialStateCompressed.dat")
							.toPath());

			EnvironmentCompressor ec = new EnvironmentCompressor();
			byte[] uncompressedData = ec.uncompress(data);

			CellularAutomatonParser ep = new CellularAutomatonParser();
			CellularAutomaton ca = ep.parseStateToObject(new String(uncompressedData));

			System.out.println("LETS SEE IF IT IS ALIVE: "
					+ ((GameOfLifeCellState) ca.getCells()[10][16].getDef().getState()).isAlive());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void executeEngine() {
		int width = 32;
		int height = 32;
		CellularAutomatonParser parser = new CellularAutomatonParser();

		Engine engine = new Engine(new EnvironmentGenerator().generateEnvironment2(width, height),
				1, null, parser);
		System.out.println("Runnning Simulation...");
		engine.execute();
		System.out.println("Ending simulation run.");

		System.out.println("Parsing...");
		String jsonExecution =
				"{\"width\":" + width + ",\"height\":" + height + ",\"generations\":";
		jsonExecution += parser.generateExecutionJson(width, height, engine.getRunGenerations());

		jsonExecution += "}";

		// ====================================================================================================================
		// ====================================================================================================================
		// Save normal file...
		try {
			// Files.write(
			// new
			// File("C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\execution.json")
			// .toPath(),
			// jsonExecution.getBytes(StandardCharsets.UTF_8));
			Files.write(
					new File("C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\execution.json")
							.toPath(),
					jsonExecution.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read bytes from the normal file, compress the data and save compressed data
		// into new
		// file...
		EnvironmentCompressor environmentCompressor = new EnvironmentCompressor();
		try {
			byte[] data = Files.readAllBytes(
					new File("C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\execution.json")
							.toPath());

			environmentCompressor = new EnvironmentCompressor();
			byte[] compressedData = environmentCompressor.compress(data);

			Files.write(new File(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\executionCompressed.dat")
							.toPath(),
					compressedData);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Read compressed data from the file, uncompress it and saving the uncompressed
		// data into a
		// new file...
		try {
			byte[] data = Files.readAllBytes(new File(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\executionCompressed.dat")
							.toPath());

			byte[] uncompressedData = environmentCompressor.uncompress(data);

			Files.write(new File(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\executionUncompressed.json")
							.toPath(),
					uncompressedData);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// ====================================================================================================================
		// ====================================================================================================================
	}
}
