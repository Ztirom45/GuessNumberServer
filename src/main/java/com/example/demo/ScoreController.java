
package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.List;

import org.hibernate.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.database.LoggingService;
import com.example.demo.database.LoggingEntity;
import com.example.demo.database.ScoreService;
import com.example.demo.database.ScoreEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalTime; 

@RestController
//@RequestMapping(produces = "aplication/json",value = "greeting")
public class ScoreController{

	@Autowired private LoggingService loggingService;
	@Autowired private ScoreService scoreService;

	//private final AtomicLong counter = new AtomicLong();
	public void log(String content){
		loggingService.savelog(
				LoggingEntity.builder()
				.timestamp(LocalTime.now())
				.loggingContent(content)
				.build()
		);
	}
	public Boolean processScore(Map<String,String> params){

		List<?> values = new ArrayList<>(params.values());
		if(values.size() != 2){
			log("wrong number of params");
			return false;
		}
		try {
			int tries = Integer.parseInt(values.get(0).toString());
			float time = Float.parseFloat(values.get(1).toString());
			log("new score"+Integer.toString(tries)+", "+Float.toString(time));
			scoreService.savescore(
				ScoreEntity.builder()
				.tries(tries)
				.time(time)
				.build()
			);
		} catch (Exception e) {
			log("wrong type of params");
			return false;
		}

		return true;
	}

	@RequestMapping(value="/score", method = RequestMethod.GET)
	public ResponseEntity getParams(@RequestParam Map<String, String> params ) {	
		if(!processScore(params)){
			return new ResponseEntity<String>("bad request", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	@RequestMapping(value="/get_scores", method = RequestMethod.GET)
	public List<ScoreEntity> get_scores() {	
		log("get score reques");

		return scoreService.fetchscoreList();
	}

}
