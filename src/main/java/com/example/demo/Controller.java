package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.database.LoggingService;
import com.example.demo.database.LoggingEntity;


import java.time.LocalTime; 

@RestController
public class Controller{

	@Autowired private NumberGenerator numberGenerator;	
	@Autowired private LoggingService loggingService;

	//private final AtomicLong counter = new AtomicLong();
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
	public ReturnType greeting(@RequestParam(value = "number", defaultValue = "0") String name) {
		log("GET: "+name);
		return reply(numberGenerator.guess(name));
	}
}
