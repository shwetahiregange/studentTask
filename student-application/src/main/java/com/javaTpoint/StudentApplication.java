package com.javaTpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {
	private static final Logger logger = LogManager.getLogger(StudentApplication.class);
	public static void main(String[] args) {
		logger.debug("Started spring boot application");
		SpringApplication.run(StudentApplication.class, args);
		
	}

}
