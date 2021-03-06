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
		//String qstr = "from HumanDataEntity where id = :fid or name like :fname or mail like :fmail";
		//String qstr = "from HumanDataEntity where id = ?1 or name like ?2 or mail like ?3";
		Long fid = 0L;
		try {
			fid = Long.parseLong(fstr);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		/*
		Query query = this.entityManager.createQuery(qstr)
				.setParameter("fid", fid)
				.setParameter("fname", "%" + fstr + "%")
				.setParameter("fmail", fstr + "@%");
		*/
		/*
		Query query = this.entityManager.createQuery(qstr)
				.setParameter(1, fid)
				.setParameter(2, "%" + fstr + "%")
				.setParameter(3, fstr + "@%");
		*/
		Query query = this.entityManager.createNamedQuery("findWithName")
				.setParameter("fname", "%" + fstr + "%");
		list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HumanDataEntity> findByAge(int min, int max) {
		return (List<HumanDataEntity>)entityManager.createNamedQuery("findByAge")
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}
}
