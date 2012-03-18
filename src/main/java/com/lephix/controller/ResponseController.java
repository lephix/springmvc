package com.lephix.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/response/*")
public class ResponseController {

	@RequestMapping (value = "1", produces = "text/plain;charset=ISO-8859-1")
	public @ResponseBody String response1() throws Exception {
		return "你好北京 with encoding ISO-8859-1";
	}

	@RequestMapping (value = "2", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String response2() throws Exception {
		return "你好北京 with encoding UTF-8";
	}
	
	@RequestMapping (value = "2", params = {"foo"}) 
	public @ResponseBody String response3(@RequestParam String foo) throws Exception {
		return "你好北京 without explicit encoding code but with request parameter foo = " + foo;
	}
	
	@RequestMapping(value="3", method=RequestMethod.GET)
	public ResponseEntity<String> responseEntityCustomHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/plain",
				headers, HttpStatus.OK);
	}
}
