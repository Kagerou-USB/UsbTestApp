package com.usb.usbtestapp.interfaces;

// spring
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// com.usb
//import com.usb.usbtestapp.domain.service.UsbTestAppService;
import com.usb.usbtestapp.domain.model.UsbTestAppModel;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsbController {
	
	//final UsbTestAppService usbTestAppService;
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("res1", "USB text1");
		mav.addObject("res2", "USB text2");
		mav.addObject("res3", "USB text3");
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/model")
	public String model() {
		UsbTestAppModel usbTestAppModel = new UsbTestAppModel(1, "usb", "a");
		return usbTestAppModel.getName();
	}
	
}