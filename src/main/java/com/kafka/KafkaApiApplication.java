package com.kafka;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kafka.imp.KafkaProducer;
import com.kafka.models.MenuItem;

@SpringBootApplication
public class KafkaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApiApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner runner(KafkaProducer producer) {
		String date = new Date().toString();
		return(args -> {
			producer.send(new MenuItem("Cheese Fries", "Fries with Cheese", "5.99", "5", "Appitizers", date));
		});
	}

}
