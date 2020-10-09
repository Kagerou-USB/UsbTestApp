package com.usb.usbtestapp.interfaces;

import org.springframework.web.bind.annotation.PathVariable;
// spring
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// com.usb
import com.usb.usbtestapp.domain.model.UsbTestAppModel;
import com.usb.usbtestapp.domain.service.UsbTestAppService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsbRestController {
	
	final UsbTestAppService usbTestAppService;

	@RequestMapping("/rest/{id}")
	public UsbTestAppModel model(@PathVariable int id) {
		UsbTestAppModel usbTestAppModel = usbTestAppService.createUsbTestAppModel(id);
		return usbTestAppModel;
	}
	
}