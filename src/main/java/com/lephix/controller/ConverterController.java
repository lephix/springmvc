package com.lephix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping ("/converter")
public class ConverterController {

	@RequestMapping (value = "json", method = RequestMethod.GET)
	public @ResponseBody ConverterTestObject json() {
		ConverterTestObject object = new ConverterTestObject();
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
}
