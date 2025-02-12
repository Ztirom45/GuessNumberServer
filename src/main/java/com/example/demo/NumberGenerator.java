package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.ThreadLocalRandom;

@Service
public class NumberGenerator{

	//private static final String template = "%s";
	//private final AtomicLong counter = new AtomicLong();
	
	private final float GUESS = (float)(ThreadLocalRandom.current().nextInt(-0x7fffffff,0x7fffffff))/10000.f;
	
	public static final String TOO_HIGH = "Too High";
	public static final String TOO_LOW = "Too Low";
	public static final String OK = "Hacked";
	public static final String SYNTAX_ERROR = "Syntax Error: use numbers in range -0x7fffffff/10000.0:0x7fffffff/10000.0";

	public String guess(String input) {
		float number;
		try {
			number = Float.parseFloat(input);
		} catch (Exception e) {
			return SYNTAX_ERROR;
		}
		if(number < GUESS){	
			return TOO_LOW;
		}
		if(number > GUESS){	
			return TOO_HIGH;
		}
		return OK;
	}
}
