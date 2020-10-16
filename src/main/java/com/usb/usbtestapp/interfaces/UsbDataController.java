package com.usb.usbtestapp.interfaces;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		d1.setMemo("090999999");
		repository.saveAndFlush(d1);
		HumanDataEntity d2 = new HumanDataEntity();
		d2.setName("hikakin");
		d2.setAge(31);
		d2.setMail("hikakin@bb.com");
		d2.setMemo("080888888");
		repository.saveAndFlush(d2);
		HumanDataEntity d3 = new HumanDataEntity();
		d3.setName("mugi");
		d3.setAge(5);
		d3.setMail("mugi@cc.com");
		d3.setMemo("070777777");
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
			@ModelAttribute("formModel")
			@Validated HumanDataEntity humanDataEntity,
			BindingResult result,
			ModelAndView mav) {
		ModelAndView res = null;
		if (!result.hasErrors()) {
			repository.saveAndFlush(humanDataEntity);
			res = new ModelAndView("redirect:/data");
		} else {
			mav.setViewName("edit");
			mav.addObject("msg", "sorry, error is occured...");
			Iterable<HumanDataEntity> list = repository.findAll();
			mav.addObject("datalist", list);
			res = mav;
		}
		return res;
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
	public ModelAndView update(
			@ModelAttribute("formModel") HumanDataEntity humanDataEntity) {
		repository.saveAndFlush(humanDataEntity);
		return new ModelAndView("redirect:/data");
	}
	
	@RequestMapping(value="/data/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id,
			ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title", "delete mydata.");
		Optional<HumanDataEntity> humanData = repository.findById((long)id);
		mav.addObject("formModel", humanData.get());
		return mav;
	}
	
	@RequestMapping(value="/data/delete", method = RequestMethod.POST)
	@Transactional()
	public ModelAndView remove(@RequestParam long id,
			ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/data");
	}
	
	@RequestMapping(value="/data/repoquery", method = RequestMethod.GET)
	public ModelAndView repoQuery(
			@ModelAttribute("formModel") HumanDataEntity humanDataEntity, 
			ModelAndView mav
	) {
		mav.setViewName("data");
		mav.addObject("title", "USB RepoQuery Page");
		Iterable<HumanDataEntity> list = repository.findAllOrderByName();
		mav.addObject("datalist", list);
		return mav;
	}
}
