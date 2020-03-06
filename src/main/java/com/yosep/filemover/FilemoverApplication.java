package com.yosep.filemover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class FilemoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilemoverApplication.class, args);
	}

}
