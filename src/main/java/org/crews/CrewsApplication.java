package org.crews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CrewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrewsApplication.class, args);
	}

}
