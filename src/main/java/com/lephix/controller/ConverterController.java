package com.lephix.controller;

import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping ("/converter")
public class ConverterController {

	Logger log = LoggerFactory.getLogger(ConverterController.class);
	
	// Require Jack son library.
	@RequestMapping (value = "json", method = RequestMethod.GET)
	public @ResponseBody ConverterTestObject json(ConverterTestObject object) {
		// parameters will be auto filled into the object.
		return object;
	}
	
	@RequestMapping (value = "xml", method = RequestMethod.GET)
	public @ResponseBody ConverterXMLTestObject xmlRaw() {
		ConverterXMLTestObject object = new ConverterXMLTestObject();
		object.setBoolTest(true);
		object.setDoubleTest(18.8);
		object.setIntegerTest(881);
		object.setStringTest("XML TEST!");
		return object;
	}
	
	@RequestMapping (value = "xml2", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ConverterXMLTestObject> xmlRawWithHeader() {
		ConverterXMLTestObject object = new ConverterXMLTestObject();
		object.setBoolTest(true);
		object.setDoubleTest(18.8);
		object.setIntegerTest(881);
		object.setStringTest("XML TEST!");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_XML);
		HttpEntity<ConverterXMLTestObject> entity = new HttpEntity<ConverterXMLTestObject>(object);
		return entity;
	}
	
	// requires Joda-Time on the classpath
	@RequestMapping("date/{value}")
	public @ResponseBody String date(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date value) {
		return "Converted date " + value;
	}
	
	@RequestMapping("collection")
	public @ResponseBody String collection(@RequestParam Collection<Integer> values) {
		return "Converted collection " + values;
	}
	
	@RequestMapping("bean/{integerTest}/{boolTest}")
	public @ResponseBody String bean(ConverterTestObject object, BindingResult result) {
		if (result.hasErrors()) {
			return object + "" + result.getAllErrors()+"";
		}
		return "Converted object successfully " + object;
	}
	
	@RequestMapping(value="path/{foo}/{fruit}", method=RequestMethod.GET)
	public String path(@PathVariable String foo, @PathVariable String fruit, Model model) {
		model.addAttribute("integerTest", 1);
		model.addAttribute("boolTest", false);
		return "converter";
	}
	
	/**
	 * This example shows the request path value can be used in both java bean and @PathVariable annotated
	 * @param stringTest
	 * @param object
	 * @param model
	 * @return
	 */
	@RequestMapping(value="path/{stringTest}/{doubleTest}/{boolTest}", method=RequestMethod.GET)
	public String path(@PathVariable String stringTest, ConverterTestObject object, Model model) {
		// CAUTION: No matter what the variable name in the controller method, the view will 
		// only use the uncapitalized name of the variable's class.
		// eg: ${converterTestObject} is working.
		// eg: ${object} is NOT working.
		
		model.addAttribute("integerTest", 1);
		model.addAttribute("boolTest", false);
		return "converter";
	}
}
