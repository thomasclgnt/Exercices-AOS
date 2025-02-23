package fr.insa.msa.msDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
// Notre ms devient un serveur de découverte de ms
public class MsDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDiscoveryApplication.class, args);
	}

}
