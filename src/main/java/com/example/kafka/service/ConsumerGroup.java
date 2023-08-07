package com.example.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Collections;

public class ConsumerGroup {
    private final String topic;
    private final String groupId;
    private final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(KafkaConfig.consumerConfig());
    private static final String TEST_TOPIC = "javainusetopic";
    private static final String TEST_GROUP = "group1";

    public ConsumerGroup(String topic, String groupId) {
        this.topic = topic;
        this.groupId = groupId;
    }

    public static void main(String[] args) {
        ConsumerGroup consumerGroup = new ConsumerGroup(TEST_TOPIC, TEST_GROUP);
        consumerGroup.run();
    }

    private void run() {
        try {
            consumer.subscribe(Collections.singletonList(this.topic));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records)

                        System.out.printf("offset = %d, key = %s, value = %s%n",
                                record.offset(), record.key(), record.value());

                    }
            } finally{
                consumer.close();
            }
        }
    }

/*
    @KafkaListener(topics = "javainusetopic", groupId = "group1", containerFactory = "filterKafkaListenerContainerFactory", id = "test")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }*/





