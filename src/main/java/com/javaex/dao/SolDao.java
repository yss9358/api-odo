package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.SolCateVo;
import com.javaex.vo.SolClassVo;
import com.javaex.vo.SolCompanyVo;

@Repository
public class SolDao {

	@Autowired
	private SqlSession sqlSession;

	/******************************************
	 * 사업자
	 * @param id
	 * @return
	 */
	// 아이디 중복쳌
	public String selectCompanyId(String id) {
		System.out.println("SolDao.selectCompanyId()");
		return sqlSession.selectOne("sr.companyId", id);
	}

	// 회원가입
	public int insertCompany(SolCompanyVo solVo) {
		System.out.println("SolDao.insertCompany()");
		return sqlSession.insert("sr.companyInsert", solVo);
	}

	// 로그인
	public SolCompanyVo login(SolCompanyVo solVo) {
		System.out.println("SolDao.login");
		SolCompanyVo authCompany = sqlSession.selectOne("sr.companyLogin", solVo);
		return authCompany;
	}
	
	/********************************************
	 * 클래스
	 */
	public List<SolClassVo> selectAllClass(Map<Object, String> tempVo){
		System.out.println("SolDao.selectAllClass()");
		return sqlSession.selectList("sr.companyClassList", tempVo);
	}
	//클래스 불러오기
	public SolClassVo selectClass(Map<Object, String> tempVo) {
		System.out.println("SolDao.selectClass()");
		System.out.println(tempVo);
		return sqlSession.selectOne("sr.getClass", tempVo);
	}
	//카테고리 불러오기
	public List<SolCateVo> selectAllCate(){
		System.out.println("SolDao.selectAllCate()");
		return sqlSession.selectList("sr.selectAllCate1");
	}
	//2차카테고리
	public List<SolCateVo> selectCate2(int no){
		System.out.println("SolDao.selectCate2");
		return sqlSession.selectList("sr.selectCate2", no);
	}
}
