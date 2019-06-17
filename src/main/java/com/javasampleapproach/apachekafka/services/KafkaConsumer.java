package com.javasampleapproach.apachekafka.services;

import com.javasampleapproach.apachekafka.model.Messagedb;
import com.javasampleapproach.apachekafka.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.javasampleapproach.apachekafka.storage.MessageStorage;

@Service
public class KafkaConsumer {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	@Autowired
	MessageStorage storage;

	@Autowired
	MessageStorage storageForMsg;

	@Autowired
	private MessageRepository msgRepo;
	
	@KafkaListener(topics="${jsa.kafka.topic}")
    public void processMessage(String message) {
		log.info("received content = '{}'", message);
		storage.put(message, "storage");
		storageForMsg.put(message, "storageForMsg");

		//DATABASE
		Messagedb newMessage = new Messagedb();

		String messageRep = message.replace("  ", " ");
		String[] arrayMsg = messageRep.split(" ");

		newMessage.setTimestamp(arrayMsg[0] + " " + arrayMsg[1]);
		newMessage.setLevel(arrayMsg[2]);
		newMessage.setCityName(arrayMsg[3]);
		newMessage.setMessage(arrayMsg[4]);

		msgRepo.save(newMessage);
    }
}
