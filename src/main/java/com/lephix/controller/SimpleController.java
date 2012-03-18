package com.lephix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

	Logger log = LoggerFactory.getLogger(SimpleController.class);
	
	@RequestMapping(value = "/simple", method = RequestMethod.GET)
	public String simplePage() throws Exception {
		log.debug("haha");
		return "simple";
	}
}
