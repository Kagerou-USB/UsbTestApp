package com.usb.usbtestapp.interfaces;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

//com.usb
import com.usb.usbtestapp.entities.HumanDataEntity;
import com.usb.usbtestapp.repositories.HumanDataRepository;

@Controller
public class UsbDataController {
	
	@Autowired
	HumanDataRepository repository;
	
	@PostConstruct
	public void init(){
		HumanDataEntity d1 = new HumanDataEntity();
		d1.setName("usb");
		d1.setAge(31);
		d1.setMail("usb@aaa.com");
		d1.setMemo("3.0");
		repository.saveAndFlush(d1);
		HumanDataEntity d2 = new HumanDataEntity();
		d2.setName("hikakin");
		d2.setAge(31);
		d2.setMail("hikakin@bb.com");
		d2.setMemo("I`m Youtuber.");
		repository.saveAndFlush(d2);
		HumanDataEntity d3 = new HumanDataEntity();
		d3.setName("mugi");
		d3.setAge(5);
		d3.setMail("mugi@cc.com");
		d3.setMemo("I`m Plant.");
		repository.saveAndFlush(d3);
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ModelAndView index(
			@ModelAttribute("formModel") HumanDataEntity humanDataEntity,
			ModelAndView mav) {
		mav.setViewName("data");
		mav.addObject("msg", "This is sample content.");
		Iterable<HumanDataEntity> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	@Transactional()
	public ModelAndView form(
			@ModelAttribute("formModel") HumanDataEntity humanDataEntity,
			ModelAndView mav) {
		repository.saveAndFlush(humanDataEntity);
		return new ModelAndView("redirect:/data");
	}
}




