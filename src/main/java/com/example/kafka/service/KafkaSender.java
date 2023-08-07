package com.example.kafka.service;

import com.example.kafka.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	public static final String TOPIC = "javainusetopic";
	public static final String TOPIC2 = "Kafka_Example_json";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String message) {
		System.out.println(String.format("#### -> Producing message -> %s", message));
		this.kafkaTemplate.send(TOPIC, "test",message);
	}
	public void sendTest(String message) {
		System.out.println(String.format("#### -> Producing message -> %s", message));
		this.kafkaTemplate.send(TOPIC,"test1" ,message );
	}


	public void sendJson(Employee emp) {
		System.out.println(String.format("#### -> Producing message -> %s", emp));
		this.kafkaTemplate.send(TOPIC, emp.toString());
	}
}




