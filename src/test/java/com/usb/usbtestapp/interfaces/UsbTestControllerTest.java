package com.usb.usbtestapp.interfaces;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class UsbTestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testTest() throws Exception {
		this.mockMvc.perform(get("/usb/test")).andDo(print()).andExpect(status().isOk());
	}
}
