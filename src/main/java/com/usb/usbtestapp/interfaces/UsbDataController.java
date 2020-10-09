package com.usb.usbtestapp.interfaces;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/data", method=RequestMethod.POST)
	@Transactional()
	public ModelAndView add(
			@ModelAttribute("formModel") HumanDataEntity humanDataEntity,
			ModelAndView mav) {
		repository.saveAndFlush(humanDataEntity);
		return new ModelAndView("redirect:/data");
	}
	
	@RequestMapping(value="/data/edit/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "Edit HumanData");
		Optional<HumanDataEntity> humanData = repository.findById((long)id);
		mav.addObject("formModel", humanData.get());
		Iterable<HumanDataEntity> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value="/data/edit", method=RequestMethod.POST)
	@Transactional()
<<<<<<< HEAD
	public ModelAndView update(
			@ModelAttribute("formModel") HumanDataEntity humanDataEntity) {
=======
	public ModelAndView update(@ModelAttribute HumanDataEntity humanDataEntity) {
		// addとの違いはIDが指定されているかどうか…
		// 指定されている場合（viewからPOSTされる）更新処理と解釈される
>>>>>>> 542da754e0ac6113f8c34d29cf75e91d29bf6bf5
		repository.saveAndFlush(humanDataEntity);
		return new ModelAndView("redirect:/data");
	}
}
