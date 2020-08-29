package com.usb.usbtestapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UsbTestAppModel {

	private int id;
	
	private String name;
	
	private String value;
}