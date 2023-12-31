package com.example.kafka.controller;

import com.example.kafka.dto.Employee;
import com.example.kafka.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApacheKafkaWebController {
    @Autowired
    KafkaSender kafkaSender;

    @GetMapping("/kafka/produce")
    public String produce(@RequestParam("message") String message) {
        this.kafkaSender.send(message);
        return "Message sent to the Kafka Topic java_in_use_topic Successfully";
    }

    @GetMapping("/kafka/produceTest")
    public String produceTest(@RequestParam("message") String message) {
        this.kafkaSender.sendTest(message);
        return "Message sent to the Kafka Topic java_in_use_topic Successfully";
    }
//Kafka producer with JSON message
     @PostMapping("/kafka/produceJson")
        public String produceJson(@RequestBody  Employee employee) {
            this.kafkaSender.sendJson(employee);
            return "Message sent to the Kafka Topic java_in_use_topic Successfully";
        }


}
