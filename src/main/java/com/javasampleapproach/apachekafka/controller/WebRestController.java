package com.javasampleapproach.apachekafka.controller;

import com.javasampleapproach.apachekafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javasampleapproach.apachekafka.storage.MessageStorage;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/jsa/kafka")
public class WebRestController {

	@Autowired
	MessageStorage storage;

	@Autowired
	MessageStorage storageForMsg;

	@GetMapping(value="/dashboard")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Message> getDashboardMessage(){

		List<Message> messages = new ArrayList<Message>();
		List<Message> message = storage.getDashboardStorage();

		for (Message x:message) {
			Message newmessage = new Message();

			newmessage.setTimestamp(x.getTimestamp());
			newmessage.setLevel(x.getLevel());
			newmessage.setCityName(x.getCityName());
			newmessage.setMessage(x.getMessage());

			messages.add(newmessage);
		}

		storage.dashboardclear();
		return messages;
	}

	@GetMapping(value="/consumer")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Message> getAllRecievedMessage(){

		List<Message> messages = new ArrayList<Message>();
		List<Message> message = storageForMsg.getMessageStorage();

		for (Message x:message) {
			Message newmessage = new Message();

			newmessage.setTimestamp(x.getTimestamp());
			newmessage.setLevel(x.getLevel());
			newmessage.setCityName(x.getCityName());
			newmessage.setMessage(x.getMessage());

			messages.add(newmessage);
		}

		storageForMsg.messagesclear();
		return messages;
	}
}
