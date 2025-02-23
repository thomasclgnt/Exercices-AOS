package fr.insa.mas.StudentEvalService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class StudentEvalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEvalServiceApplication.class, args);
	}

}
