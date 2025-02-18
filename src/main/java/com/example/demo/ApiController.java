package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.database.LoggingService;
import com.example.demo.database.LoggingEntity;

import java.time.LocalTime; 

@RestController
//@RequestMapping(produces = "aplication/json",value = "greeting")
public class ApiController{

	@Autowired private NumberGenerator numberGenerator;	
	@Autowired private LoggingService loggingService;

	public void log(String content){
		loggingService.savelog(
				LoggingEntity.builder()
				.timestamp(LocalTime.now())
				.loggingContent(content)
				.build()
		);
	}

	public ReturnType reply(String reply){
		log("reply: "+reply);
		return new ReturnType(reply);
	}
	@GetMapping("/greeting")
	public /*String*/ReturnType greeting(@RequestParam(value = "number", defaultValue = "0") String name) {
		log("GET: "+name);
		//return "{value:"+name+"}";
		return reply(numberGenerator.guess(name));
	}
}
