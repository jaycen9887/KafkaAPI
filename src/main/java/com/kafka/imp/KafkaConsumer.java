package com.kafka.imp;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "${cloudkarafka.menu-topic}")
	public void receive(Object obj, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
			@Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics, @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
		System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), getJson(obj));
	}
	
	public JsonObject getJson(Object obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		JsonElement jElement = new JsonParser().parse(json);
		JsonObject jobject = jElement.getAsJsonObject();
		return jobject.getAsJsonObject("value");
	}

}
