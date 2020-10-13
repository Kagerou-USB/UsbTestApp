package com.usb.usbtestapp.domain.dao;

import java.io.Serializable;
import java.util.List;


public interface HumanDataDao <T> extends Serializable {
	public List<T> getAll();
	public T findById(long id);
	public List<T> findByName(String name);
}
