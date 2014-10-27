package com.devbian.dao;

import org.springframework.data.repository.Repository;

import com.devbian.entity.Hospital;

public interface HospitalDao extends Repository<Hospital, Integer>, HospitalDaoPlus {
	public Hospital save(Hospital hospital);
}