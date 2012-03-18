package com.lephix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

	Logger log = LoggerFactory.getLogger(SimpleController.class);
	
	@RequestMapping("/simple")
	public String simplePage() throws Exception {
		log.debug("haha");
		return "simple";
	}
}
