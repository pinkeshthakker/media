package com.mediaocean.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException() {
		//ModelMap model  = new ModelMap();
		//model.addAttribute("customMessage", "Exception Occured");
		return new ModelAndView("failure", "customMessage", "Exception Occured");
	}
}
