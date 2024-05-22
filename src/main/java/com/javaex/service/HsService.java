package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.HsDao;

@Service
public class HsService {

	@Autowired
	private HsDao hsDao;
	
	//메인페이지 리스트
	public void exegetList() {
		System.out.println("HsService.exegetList()");
		
		//무료 베스트 클래스 리스트
		hsDao.selectFreeBestList();
		
		//유료 베스트 클래스 리스트
		hsDao.selectPayBestList();
		
		//신규 베스트 클래스 리스트
		hsDao.selectNewBestList();
		
		//리스트의 리스트
		//List<List<HsVo>> listOfLists
		//listOfLists.add(무료베스트클래스리스트)
		//listOfLists.add(유료베스트클래스리스트)
		//listOfLists.add(신규베스트클래스리스트)
	}
}
