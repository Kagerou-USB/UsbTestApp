package com.usb.usbtestapp.interfaces;

// spring
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsbController {
	
	@GetMapping(value="/")
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("msg", "お名前を書いて送信してください");
		mav.addObject("res1", "textA");
		mav.addObject("res2", "textB");
		mav.addObject("res3", "textC");
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping(value="/")
	public ModelAndView send(
			@RequestParam("text1")String text1, 
			ModelAndView mav) {
		mav.addObject("msg", "こんにちは、" + text1 + "さん");
		mav.addObject("value", text1);
		mav.addObject("res1", text1 + "くん");
		mav.addObject("res2", text1 + "どの");
		mav.addObject("res3", text1 + "さま");
		mav.setViewName("index");
		return mav;
	}
}