package com.usb.usbtestapp.domain.service;

import org.springframework.stereotype.Component;

import com.usb.usbtestapp.domain.model.UsbTestAppModel;

@Component
public class UsbTestAppModelFactory {
	
	public UsbTestAppModel createUsbTestAppModel(int id) {
		return new UsbTestAppModel(id, "usb", "31");
	}
}