package com.usb.usbtestapp.domain.service;

import org.springframework.stereotype.Component;

import com.usb.usbtestapp.domain.model.UsbTestAppModel;

@Component
public class UsbTestAppModelFactory {
	
	public UsbTestAppModel createUsbTestAppModel() {
		return new UsbTestAppModel(1, "usb", "31");
	}
}