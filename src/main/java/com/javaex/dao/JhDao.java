package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.WishClassVo;

@Repository
public class JhDao {

	@Autowired
	SqlSession sqlSession;
	
	//클래스 위시리스트 가져오기
	public List<WishClassVo> wishClass() {
		
		List<WishClassVo> wishClass = sqlSession.selectList("jh.wishclass");
		
		return wishClass;
	}
	
	//업체 위시리스트 가져오기
	public void wishCompany() {
		
		sqlSession.selectList("jh.wishcompany");
	}
}
