package com.hidrofob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IstController {

	final static String COLLECTOR_SERVER = "http://localhost:8080/jsa/kafka/producer";

	@RequestMapping(value= "/", method= RequestMethod.GET)
	@CrossOrigin(origins = COLLECTOR_SERVER)
	public String index(){
		return "index.html";
	}
}
