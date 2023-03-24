package com.example.sampleMongoDB;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class SampleMongoDbApplication {



	public static void main(String[] args) {
		SpringApplication.run(SampleMongoDbApplication.class, args);
		System.out.println("Server Started.....");;
		
	}


}
