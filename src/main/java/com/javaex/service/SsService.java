package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.SsDao;

@Service
public class SsService {
	
	@Autowired
	private SsDao ssDao;

	public void exeCheckId(String id) {
		ssDao.checkId(id);
	}
}
