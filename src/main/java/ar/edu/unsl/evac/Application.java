package ar.edu.unsl.evac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ar.edu.unsl.evac.engine.Engine;
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
		Engine engine = new Engine(new EnvironmentGenerator().generateEnvironment2(32, 32), 1);
		engine.execute();
		// new JsonStateGenerator().generate();
		// SpringApplication.run(Application.class, args);
	}
}
