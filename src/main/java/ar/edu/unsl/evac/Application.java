package ar.edu.unsl.evac;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ar.edu.unsl.evac.engine.Engine;
import ar.edu.unsl.evac.engine.utils.CellularAutomatonParser;
import ar.edu.unsl.evac.engine.utils.EnvironmentGenerator;
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
		// new JsonStateGenerator().generate();

		SpringApplication.run(Application.class, args);
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
		String jsonExecution = "{\"width\":" + width + ",\"height\":" + height + ",";
		jsonExecution += parser.generateExecutionJson(width, height, "generations",
				engine.getRunGenerations());

		jsonExecution += "}";

		// Saving normal size File...
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\executionTest.json"));
			writer.write(jsonExecution);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Saving deflated size File...
		try {
			// ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
			DeflaterOutputStream deflater = new DeflaterOutputStream(new FileOutputStream(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\executionTestDeflated.dat"));
			deflater.write(jsonExecution.getBytes());
			deflater.finish();
			deflater.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		// Reading deflated File...
		try {
			String result = null;
			DataInputStream reader = new DataInputStream(new FileInputStream(
					"C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\executionTestDeflated.dat"));
			int nBytesToRead;

			nBytesToRead = reader.available();
			if (nBytesToRead > 0) {
				byte[] bytes = new byte[nBytesToRead];
				reader.read(bytes);
				result = new String(bytes);

				ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
				InflaterOutputStream inflater = new InflaterOutputStream(outputStream2);
				inflater.write(bytes);

				// System.out.println("========================== RESULT
				// ==========================\n"
				// + outputStream2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
