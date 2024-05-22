package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void checkId(String id) {
		System.out.println("dao : "+ id);
		
	}
}
