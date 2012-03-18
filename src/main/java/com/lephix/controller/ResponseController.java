package com.lephix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/response/*")
public class ResponseController {

	public @ResponseBody String response1() throws Exception {
		return "";
	}
}
