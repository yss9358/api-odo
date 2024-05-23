package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.SolDao;

@Service
public class SolService {
	
	@Autowired
	private SolDao solDao;
	
	public String exeId(String id) {
		System.out.println("SolService.exeId()");
		return solDao.selectCompanyId(id);
	}

}
