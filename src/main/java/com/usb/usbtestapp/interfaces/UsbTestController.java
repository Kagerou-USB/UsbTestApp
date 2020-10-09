package com.usb.usbtestapp.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usb")
public class UsbTestController {
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
