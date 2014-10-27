package com.devbian.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.devbian.entity.Hospital;

public class HospitalDaoPlusImpl implements HospitalDaoPlus{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void removePhnix(Hospital hospital) {
		em.persist(hospital);
	}

}
