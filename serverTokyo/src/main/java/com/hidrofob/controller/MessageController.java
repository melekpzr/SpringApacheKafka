package com.hidrofob.controller;

import com.hidrofob.Tokyo;
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
        Tokyo tokyolog = new Tokyo();

        if(data == null){
            data = "Hello-From-Tokyo";
        }

        data = data.replace(" ", "-");
        tokyolog.Creator(data);
        String ui = " <h2 style=\"text-align: center;\"> Your message has been sent:  ";

        return ui + data + "<h2>";
    }

    @RequestMapping(value= "/tokyomessage")
    @CrossOrigin(origins = COLLECTOR_SERVER)
    public Message getMessage(){

       Message tokyoMsg = new Message();
       tokyoMsg.setData(data);
       tokyoMsg.setCity("Tokyo");

       return tokyoMsg;
    }
}
