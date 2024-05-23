package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.SolVo;

@Repository
public class SolDao {

	@Autowired
	private SqlSession sqlSession;
	
	//아이디 중복쳌
	public String selectCompanyId(String id) {
		System.out.println("SolDao.selectCompanyId()");
		return sqlSession.selectOne("sr.companyId", id);
	}
	
	//회원가입
	public int insertCompany(SolVo solVo) {
		System.out.println("SolDao.insertCompany()");
		System.out.println(solVo);
		sqlSession.insert("sr.companyInsert", solVo);
		return 0;
	}
}
