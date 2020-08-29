package com.usb.usbtestapp.interfaces;

// spring
//import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/rest")
	public UsbTestAppModel model() {
		UsbTestAppModel usbTestAppModel = usbTestAppService.createUsbTestAppModel();
		return usbTestAppModel;
	}
	
}