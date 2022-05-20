package ar.edu.unsl.evac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public class EndPoint {
		public final static String users = "users";
		public final static String scenarios = "scenarios";
		public final static String projects = "projects";
		public final static String states = "states";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
