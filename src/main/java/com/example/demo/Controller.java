package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.example.demo.database.LoggingService;
import com.example.demo.database.LoggingEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller{

	@Autowired private NumberGenerator numberGenerator;	
	@Autowired private LoggingService loggingService;

	//private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public ReturnType greeting(@RequestParam(value = "number", defaultValue = "0") String name) {
		loggingService.savelog(
				LoggingEntity.builder()
				.loggingContent(name)
				.build()
		);
		return new ReturnType(numberGenerator.guess(name));
	}
}
