package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HsDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
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