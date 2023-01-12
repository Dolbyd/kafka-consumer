package com.consumer.kafkaconsumer.config;

import lombok.Getter;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Getter
@Configuration
public class KafkaConsumerConfig {

    private Properties props = new Properties();

    public KafkaConsumerConfig() {
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
    }


}
