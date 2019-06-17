package com.hidrofob.controller;

import com.hidrofob.Moscow;
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
        Moscow moslog = new Moscow();

        if(data == null){
            data = "Hello-From-Moscow";
        }

        data = data.replace(" ", "-");
        moslog.Creator(data);
        String ui = " <h2 style=\"text-align: center;\"> Your message has been sent:  ";

        return ui + data + "<h2>";
    }

    @RequestMapping(value= "/mosmessage")
    @CrossOrigin(origins = COLLECTOR_SERVER)
    public Message getMessage(){

       Message mosMsg = new Message();
       mosMsg.setData(data);
       mosMsg.setCity("Moscow");

       return mosMsg;
    }
}
