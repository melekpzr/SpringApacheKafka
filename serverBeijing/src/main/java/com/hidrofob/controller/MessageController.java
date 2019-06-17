package com.hidrofob.controller;

import com.hidrofob.Beijing;
import com.hidrofob.model.DataLog;
import com.hidrofob.model.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MessageController {

    String data;
    DataLog tmpLog = new DataLog();

    final static String COLLECTOR_SERVER = "http://localhost:8080/jsa/kafka/producer";

    @RequestMapping(value= "/", method= RequestMethod.POST)
    @CrossOrigin(origins = COLLECTOR_SERVER)
    public String getData(HttpServletRequest request){

        data = request.getParameter("data");
        Beijing beilog = new Beijing();

        if(data == null){
            data = "Hello-From-Beijing";
        }

        data = data.replace(" ", "-");
        beilog.Creator(data);
        String ui = " <h2 style=\"text-align: center;\"> Your message has been sent:  ";

        return ui + data + "<h2>";
    }

    @RequestMapping(value= "/beimessage")
    @CrossOrigin(origins = COLLECTOR_SERVER)
    public Message getMessage(){

       Message beiMsg = new Message();
       beiMsg.setData(data);
       beiMsg.setCity("Beijing");

       return beiMsg;
    }
}
