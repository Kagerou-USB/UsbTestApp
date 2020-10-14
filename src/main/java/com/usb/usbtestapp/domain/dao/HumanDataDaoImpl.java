package com.usb.usbtestapp.domain.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.usb.usbtestapp.entities.HumanDataEntity;

@Repository
public class HumanDataDaoImpl implements HumanDataDao<HumanDataEntity> {
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	public HumanDataDaoImpl() {
		super();
	}
	
	public HumanDataDaoImpl(EntityManager manager) {
		this();
		this.entityManager = manager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HumanDataEntity> getAll() {
		Query query = this.entityManager.createQuery("from HumanDataEntity");
		List<HumanDataEntity> list = query.getResultList();
		this.entityManager.close();
		return list;
	}
	
	
	@Override
	public HumanDataEntity findById(long id) {
		return (HumanDataEntity) this.entityManager.createQuery("from HumanDataEntity where id = "
				+ id).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HumanDataEntity> findByName(String name) {
		return (List<HumanDataEntity>)this.entityManager.createQuery("from HumanDataEntity where name = "
				+ name).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<HumanDataEntity> find(String fstr) {
		List<HumanDataEntity> list = null;
		String qstr = "from HumanDataEntity where id = :fstr";
		Query query = this.entityManager.createQuery(qstr).setParameter("fstr", Long.parseLong(fstr));
		list = query.getResultList();
		return list;
	}
}
