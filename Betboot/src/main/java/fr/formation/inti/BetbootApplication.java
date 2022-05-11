package fr.formation.inti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("fr.formation.inti")
public class BetbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetbootApplication.class, args);
	}

}
