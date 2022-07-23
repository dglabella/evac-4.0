package ar.edu.unsl.evac;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ar.edu.unsl.evac.engine.Engine;
import ar.edu.unsl.evac.engine.domain.CellularAutomaton;
import ar.edu.unsl.evac.engine.utils.CustomParser;
import ar.edu.unsl.evac.engine.utils.EnvironmentGenerator;
import ar.edu.unsl.evac.scenarios.gol.GameOfLifePropertiesBundle;
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

		new Engine(null, new EnvironmentGenerator().generateEnvironment2(32, 32), 1, null,
				new CustomParser()).run();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		// new JsonStateGenerator().generate();
		// SpringApplication.run(Application.class, args);
	}
}
