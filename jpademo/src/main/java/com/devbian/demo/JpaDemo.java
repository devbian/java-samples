package com.devbian.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devbian.entity.Hospital;
import com.devbian.service.HospitalService;

public class JpaDemo {
	private static ClassPathXmlApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("spring.xml");

		HospitalService service = context.getBean("hospitalService", HospitalService.class);
		service.saveHospital(new Hospital("0091", "ac"));
		service.removeP(new Hospital("zz","zc"));
	}
}
