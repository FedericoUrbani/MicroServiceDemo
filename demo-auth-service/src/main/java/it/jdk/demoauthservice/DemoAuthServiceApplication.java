package it.jdk.demoauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAuthServiceApplication.class, args);
	}

}
