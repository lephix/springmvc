package com.lephix.controller;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/simple/*")
public class SimpleController {

	Logger log = LoggerFactory.getLogger(SimpleController.class);

	@RequestMapping(value = "1", method = RequestMethod.GET)
	public String simplePage() throws Exception {
		log.debug("First simple sample for controller!");
		return "simple";
	}

	@RequestMapping(value = "2")
	public @ResponseBody
	String simple2Page() throws Exception {
		log.debug("Simple2 using @ResponseBody annotation");
		return "Simple2 using @ResponseBody annotation";
	}

	@RequestMapping(value = "3")
	public @ResponseBody
	String simple3Page(@RequestParam String foo) throws Exception {
		return "Simple3 with params foo = " + foo;
	}

	@RequestMapping(value = "4/{foo}")
	public @ResponseBody
	String simple4Page(@PathVariable String foo) throws Exception {
		return "Simple4 with path foo = " + foo;
	}

	@RequestMapping(value = "5")
	public @ResponseBody
	String simple5Page(@RequestBody String body) throws Exception {
		return "Simple5 with @RequestBody = " + body;
	}

	@RequestMapping(value = "requestArgs", method = RequestMethod.GET)
	public @ResponseBody
	String standardRequestArgs(Principal user, HttpServletRequest request, 
			Locale locale) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("request = ").append(request).append(", ");
		buffer.append("userPrincipal = ").append(user).append(", ");
		buffer.append("requestLocale = ").append(locale);
		return buffer.toString();
	}
}
