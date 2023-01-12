package com.consumer.kafkaconsumer.consumer;

import com.consumer.kafkaconsumer.config.KafkaConsumerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Collections;

@Slf4j
@Service
public class KafkaConsumerImpl {

    @Autowired
    KafkaConsumerConfig kafkaConsumerConfig;

    @PostConstruct
    public void init() {
        consumeMessage();
    }

    private void consumeMessage(){
        try(KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaConsumerConfig.getProps(), new StringDeserializer(), new StringDeserializer())){
            consumer.subscribe(Collections.singletonList("my_topic"));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    log.info("Received record: {}", record);
                }
            }
        }
    }

}
