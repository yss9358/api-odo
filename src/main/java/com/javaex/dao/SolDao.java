package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.SolCateVo;
import com.javaex.vo.SolClassVo;
import com.javaex.vo.SolCompanyVo;
import com.javaex.vo.SolListVo;
import com.javaex.vo.SolMemberVo;
import com.javaex.vo.SolScheduleVo;

@Repository
public class SolDao {

	@Autowired
	private SqlSession sqlSession;

	/******************************************
	 * 사업자
	 * 
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
	public List<SolClassVo> selectAllClass(Map<Object, String> tempVo) {
		System.out.println("SolDao.selectAllClass()");
		return sqlSession.selectList("sr.companyClassList", tempVo);
	}

	// 클래스 불러오기
	public SolClassVo selectClass(Map<String, Object> tempVo) {
		System.out.println("SolDao.selectClass()");
		System.out.println(tempVo);
		return sqlSession.selectOne("sr.getClass", tempVo);
	}
	//최근일정 불러오기
	public SolScheduleVo selectSchedule(int classNo){
		return sqlSession.selectOne("sr.maxSchedule", classNo);
	}
	//원데이 일정 불러오기
	public List<SolScheduleVo> selectAllOneday(int classNo){
		return sqlSession.selectList("sr.ondayScheduleList", classNo);
	}

	// 정규클래스
	public List<SolClassVo> selectRClass(int no) {
		System.out.println("SolDao.selectRClass");
		return sqlSession.selectList("sr.rCalss", no);
	}

	// 카테고리 불러오기
	public List<SolCateVo> selectAllCate() {
		System.out.println("SolDao.selectAllCate()");
		return sqlSession.selectList("sr.selectAllCate1");
	}

	// 2차카테고리
	public List<SolCateVo> selectCate2(int no) {
		System.out.println("SolDao.selectCate2");
		return sqlSession.selectList("sr.selectCate2", no);
	}

	/*********************************
	 * 클래스 추가/수정
	 * 
	 * @return
	 */
	// 클래스 추가
	public int insertClass(SolClassVo vo) {
		System.out.println("SolDao.insertClass");
		return sqlSession.insert("sr.classInsert", vo);
	}

	// 일정등록
	public int insertClassSchedul(SolScheduleVo vo) {
		System.out.println("SolDao.insertClassSchedul");
		System.out.println(vo);
		return sqlSession.insert("sr.scheduleInsert", vo);
	}

	// 클래스 수정
	public int updateClass(SolClassVo vo) {
		System.out.println("SolDao.updateClass");
		System.out.println(vo);
		return sqlSession.update("sr.classUpdate", vo);
	}

	/***********************************
	 * 리스트불러오기
	 */
	// 클래스리스트
	public List<SolClassVo> selectClassList(Map<String, Object> tempVo) {
		System.out.println("SolDao,selectClassList");
		return sqlSession.selectList("sr.classList", tempVo);
	}

	// 정규,상시회원리스트
	public List<SolMemberVo> selectRUser(int schedule) {
		System.out.println("SolDao.selectRUser");
		return sqlSession.selectList("sr.RMemberList", schedule);
	}

	// 원데이회원리스트
	public List<SolMemberVo> selectOndUser(int schedule) {
		System.out.println("SolDao.selectOndUser");
		return sqlSession.selectList("sr.oneMeberList", schedule);
	}
	//운영중인 클래스리스트
	public List<SolScheduleVo> selectAllSchedule(int no){
		System.out.println("SolDao.selectAllSchedule");
		return sqlSession.selectList("sr.selectSchedule", no);
	}

	
	/****************************************
	 * 쿠폰지급
	 */
	public int insertCoupon(Map<String, Object> tempVo) {
		System.out.println("SolDao.insertCoupon");
		return sqlSession.insert("sr.insertCoupon",tempVo);
	}
	
	
	/****************************************
	 * 검색
	 */
	public List<SolListVo> selectAddressList(SolListVo vo){
		System.out.println("SolDao.selectAddressList");
		return sqlSession.selectList("sr.addressList", vo);
	}
	//위시추가
	public int insertWish(Map<String, Object> vo) {
		System.out.println("SolDao.insertWish");
		return sqlSession.insert("sr.insertWish", vo);
	}
	//위시삭제
	public int deleteWish(Map<String, Object> vo) {
		System.out.println("SolDao.deleteWish");
		return sqlSession.delete("sr.deleteWish", vo);
	}
	
}
