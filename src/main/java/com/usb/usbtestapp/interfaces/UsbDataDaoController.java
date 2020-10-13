package com.usb.usbtestapp.interfaces;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.usb.usbtestapp.domain.dao.HumanDataDaoImpl;
import com.usb.usbtestapp.entities.HumanDataEntity;
import com.usb.usbtestapp.repositories.HumanDataRepository;

@Controller
public class UsbDataDaoController {
	
	@Autowired
	HumanDataRepository repository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	HumanDataDaoImpl dao;
	
	@PostConstruct
	public void init() {
		dao = new HumanDataDaoImpl(this.entityManager);
	}
	
	@RequestMapping(value = "/dao", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("dao");
		mav.addObject("msg", "Daoサンプル");
		Iterable<HumanDataEntity> list = dao.getAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value = "/dao/id/{id}", method = RequestMethod.GET)
	public ModelAndView searchId(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("dao");
		mav.addObject("msg", "Daoサンプル");
		HumanDataEntity humanDataEntity = dao.findById((long)id);
		mav.addObject("datalist", humanDataEntity);
		return mav;
	}
	
	// 動作しない{name}をColumnと認識されてしまう
	@RequestMapping(value = "/dao/name/{name}", method = RequestMethod.GET)
	public ModelAndView searchName(@PathVariable String name, 
			ModelAndView mav) {
		mav.setViewName("dao");
		mav.addObject("msg", "Daoサンプル");
		Iterable<HumanDataEntity> list = dao.findByName(name);
		mav.addObject("datalist", list);
		return mav;
	}
}
