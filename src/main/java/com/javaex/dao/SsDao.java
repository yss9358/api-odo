package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserJoinVo;

@Repository
public class SsDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 아이디 중복확인
	public UserJoinVo checkId(String id) {
		UserJoinVo vo = sqlSession.selectOne("ss.checkId", id);
		return vo;
	}
	
	// 일반회원 회원가입
	public int insertUser(UserJoinVo vo) {
		return sqlSession.insert("ss.insertUser",vo);
	}
	
	// 일반회원 로그인
	public UserJoinVo loginByIdPw(UserJoinVo vo) {
		return sqlSession.selectOne("ss.loginByIdPw", vo);
		
	}
	
}
