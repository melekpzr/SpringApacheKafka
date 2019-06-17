package com.javasampleapproach.apachekafka.controller;

import com.javasampleapproach.apachekafka.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;

@RestController
public class HomeController {

    @Autowired
    KafkaProducer producer;

    @RequestMapping(value= "/")
    @CrossOrigin(origins = "http://localhost:4200")
    public String home(){

        try {
            FileReader fr = new FileReader("log4j-application.log");
            BufferedReader br = new BufferedReader(fr);


            while (true){

                String line = br.readLine();
                if (line == null)
                {
                    Thread.sleep(1*1000);
                }
                else if(line != null)
                {
                    System.out.println(line);
                    producer.send(line);
                }
            }
        } catch (Exception ex){
            Thread t = Thread.currentThread();
            t.getUncaughtExceptionHandler().uncaughtException(t, ex);
        }
        return "Done";
    }
}
