package rinat.isangulov.stolovka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class StolovkaApplication {

	public static void main(String[] args) {

		//SpringApplication.run(StolovkaApplication.class, args);
		SpringApplication app = new SpringApplication(StolovkaApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8081"));
		app.run(args);
	}

}