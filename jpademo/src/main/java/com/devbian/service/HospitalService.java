package com.devbian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devbian.dao.HospitalDao;
import com.devbian.entity.Hospital;

@Service("hospitalService")
@Transactional
public class HospitalService {

	@Autowired
	HospitalDao hospitalDao;

	public Hospital saveHospital(Hospital hospital) {
		hospitalDao.save(hospital);
		System.out.println("===============");
		return hospital;
	}
	
	public void removeP(Hospital hospital) {
		hospitalDao.removePhnix(hospital);
	}
}
