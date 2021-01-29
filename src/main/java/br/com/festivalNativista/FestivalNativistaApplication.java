package br.com.festivalNativista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FestivalNativistaApplication {
	
	private static Logger logger = LoggerFactory.getLogger(FestivalNativistaApplication.class);

	public static void main(String[] args) {
		logger.info("Start Festival Nativista API");
		SpringApplication.run(FestivalNativistaApplication.class, args);
		logger.info("API iniciada com sucesso");
	}

}
