package com.lephix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

	@ExceptionHandler
	public @ResponseBody String handle(IllegalStateException e) {
		return "IllegalStateException handled!" + e;
	}
	
	@ExceptionHandler
	public String handleHomeException(Exception e) {
		return "home";
	}
	
	@RequestMapping("/exception")
	public @ResponseBody String exception() {
		throw new IllegalStateException("Sorry!");
	}

	@RequestMapping("/exception/home")
	public @ResponseBody String exceptionToHome() throws Exception {
		throw new Exception("Sorry!");
	}
	
}
