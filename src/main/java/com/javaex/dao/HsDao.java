package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.HsVo;

@Repository
public class HsDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//무료베스트클래스 리스트
	public List<HsVo> selectFreeBestList() {
		System.out.println("HsDao.selectFreeBestList()");
		
		List<HsVo> fbList = sqlSession.selectList("hs.selectFreeBestList");
		
		return fbList;
	}

	//유료베스트클래스 리스트
	public List<HsVo> selectPayBestList() {
		System.out.println("HsDao.selectPayBestList()");
		
		List<HsVo> pbList = sqlSession.selectList("hs.selectPayBestList");
		
		return pbList;
	}
	
	//신규베스트클래스 리스트
	public List<HsVo> selectNewBestList() {
		System.out.println("HsDao.selectNewBestList()");
		
		List<HsVo> nList = sqlSession.selectList("hs.selectNewList");
		
		return nList;
	}
	
}