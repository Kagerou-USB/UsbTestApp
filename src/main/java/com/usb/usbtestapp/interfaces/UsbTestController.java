package com.usb.usbtestapp.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UsbTestController {
	
	@RequestMapping("/thytest")
	public String thytest() {
		return "thytest";
	}
}
