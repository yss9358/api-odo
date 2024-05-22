package com.javaex.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HsDao {
	
	
	//무료베스트클래스 리스트
	public void selectFreeBestList() {
		System.out.println("HsDao.selectFreeBestList()");
		
	}

	//유료베스트클래스 리스트
	public void selectPayBestList() {
		System.out.println("HsDao.selectPayBestList()");
		
	}
	
	//신규베스트클래스 리스트
	public void selectNewBestList() {
		System.out.println("HsDao.selectNewBestList()");
		
	}
	
}