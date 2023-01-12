package com.consumer.kafkaconsumer;

import com.consumer.kafkaconsumer.consumer.KafkaConsumerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {



	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);

	}

}
