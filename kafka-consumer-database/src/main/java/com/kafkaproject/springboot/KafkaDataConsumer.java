package com.kafkaproject.springboot;

import com.kafkaproject.springboot.Entity.WikimediaData;
import com.kafkaproject.springboot.Repo.WikimediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataConsumer {

    private WikimediaDataRepo wikimediaDataRepo;

    public KafkaDataConsumer(WikimediaDataRepo wikimediaDataRepo) {
        this.wikimediaDataRepo = wikimediaDataRepo;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDataConsumer.class);
    @KafkaListener(topics="${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received -> %s",eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDataRepo.save(wikimediaData);

    }
}
