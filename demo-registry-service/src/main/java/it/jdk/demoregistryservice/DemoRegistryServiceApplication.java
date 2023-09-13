package it.jdk.demoregistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRegistryServiceApplication.class, args);
	}

}
