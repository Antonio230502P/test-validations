package com.trainibit.test_validations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestValidationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestValidationsApplication.class, args);
		System.out.println("Escuchando mensajes del tópico emails_sent");
	}

}
