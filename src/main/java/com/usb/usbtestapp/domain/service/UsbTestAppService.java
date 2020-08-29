package com.usb.usbtestapp.domain.service;

import org.springframework.stereotype.Service;

import com.usb.usbtestapp.domain.model.UsbTestAppModel;

import lombok.RequiredArgsConstructor;

/**
 * ビジネスロジック
 */
@RequiredArgsConstructor
@Service
public class UsbTestAppService {
	
	final UsbTestAppModelFactory usbTestAppModelFactory;
	
	public UsbTestAppModel createUsbTestAppModel() {
		return usbTestAppModelFactory.createUsbTestAppModel();
	}
}
