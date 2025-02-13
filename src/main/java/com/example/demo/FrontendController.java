package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
public class FrontendController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String aName() {
		return "index.html";
	}

}
