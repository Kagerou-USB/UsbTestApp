package com.usb.usbtestapp.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsbController {
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("res1", "USB text1");
		mav.addObject("res2", "USB text2");
		mav.addObject("res3", "USB text3");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/sum/{num1}/{num2}")
	public ModelAndView sum(
			@PathVariable int num1,
			@PathVariable int num2,
			ModelAndView mav) {
		mav.addObject("res1", (num1 + num2));
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/diff/{num1}/{num2}")
	public ModelAndView diff(
			@PathVariable int num1,
			@PathVariable int num2,
			ModelAndView mav) {
		mav.addObject("res1", (num1 - num2));
		mav.setViewName("index");
		return mav;
	}
}