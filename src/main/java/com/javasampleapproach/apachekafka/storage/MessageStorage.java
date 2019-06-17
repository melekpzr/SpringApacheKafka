package com.javasampleapproach.apachekafka.storage;

import java.util.ArrayList;
import java.util.List;

import com.javasampleapproach.apachekafka.model.Message;
import com.javasampleapproach.apachekafka.model.Messagedb;
import com.javasampleapproach.apachekafka.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageStorage {

    private List<Message> storage = new ArrayList<Message>();
    private List<Message> storageForMsg = new ArrayList<Message>();

	public void put(String message, String storageType){

        message = message.replace("  ", " ");
        String[] arrayMsg = message.split(" ");

        Message msg = new Message();

        msg.setTimestamp(arrayMsg[0] + " " + arrayMsg[1]);
        msg.setLevel(arrayMsg[2]);
        msg.setCityName(arrayMsg[3]);
        msg.setMessage(arrayMsg[4]);

        //FRONT-END
        if(storageType == "storage"){
            storage.add(msg);
        }else if (storageType == "storageForMsg"){
            storageForMsg.add(msg);
        }
	}

	public List<Message> getDashboardStorage() {
        return storage;
    }

    public List<Message> getMessageStorage() {
        return storageForMsg;
    }

    public void dashboardclear(){
        storage.clear();
    }

	public void messagesclear(){
		storageForMsg.clear();
	}


}
