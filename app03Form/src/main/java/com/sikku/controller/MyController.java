package com.sikku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hellopage";
	}
	
	@RequestMapping(value = "/wish", method = RequestMethod.POST)
	public ModelAndView wish(@RequestParam String uname) {
		return new ModelAndView("wish", "uname",uname);
	}
}
