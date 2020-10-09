package com.usb.usbtestapp.interfaces;

// spring
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsbController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView get(ModelAndView mav) {
		mav.addObject("msg", "お客様情報をご入力ください。");
		mav.addObject("res1", "入力した名前が表示されます。");
		mav.addObject("res2", "入力した年齢が表示されます。");
		mav.addObject("res3", "選択した値が表示されます。");
		mav.addObject("value1", "名前を入力してください。");
		mav.addObject("value2", "年齢を入力してください。");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView post(
			@RequestParam("text1")String text1,
			@RequestParam("text2")String text2,
			@RequestParam(value="check1", required=false)String check1,
			@RequestParam(value="radio1", required=false)String radio1,
			@RequestParam(value="select1", required=false)String select1,
			@RequestParam(value="select2", required=false)String[] select2,
			ModelAndView mav) {
		mav.addObject("msg", "お客様情報をご入力ください。");
		mav.addObject("value1", text1);
		mav.addObject("value2", text2);
		mav.addObject("res1", text1);
		mav.addObject("res2", text2);
		String res3 = "";
		try {
			res3 = "check:" + check1 + 
					" \nradio1:" + radio1 +
					" \nselect1:" + select1 +
					" \nselect2:";
		} catch (NullPointerException e) {}
		try {
			res3 += select2[0];
			for(int i=1; i<select2.length; i++) {
				res3 += ", " + select2[i];
			} 
		} catch(NullPointerException e) {
			res3 += null;
		}
		mav.addObject("res3", res3);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:/";
	}
	
	@RequestMapping("/forward")
	public String forward() {
		return "forward:/";
	}
}