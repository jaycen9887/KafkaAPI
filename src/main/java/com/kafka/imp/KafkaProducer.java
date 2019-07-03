package com.kafka.imp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kafka.models.MenuItem;

@Component
public class KafkaProducer {
	private final KafkaTemplate<String, MenuItem> kafkaTemplate;
	
	@Value("${cloudkarafka.menu-topic}")
	private String topic;
	
	KafkaProducer(KafkaTemplate<String, MenuItem> kafkaTemplate){
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(MenuItem item) {
		this.kafkaTemplate.send(topic, item);
	}
}
