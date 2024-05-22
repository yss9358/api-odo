package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserJoinVo;

@Repository
public class SsDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void checkId(String id) {
		System.out.println("dao : "+ id);
		UserJoinVo vo = sqlSession.selectOne("ss.checkId", id);
		System.out.println(vo);
	}
}
