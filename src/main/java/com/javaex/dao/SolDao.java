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
	 */
	// 아이디 중복쳌
	public String selectCompanyId(String id) {
		return sqlSession.selectOne("sr.companyId", id);
	}

	// 회원가입
	public int insertCompany(SolCompanyVo solVo) {
		return sqlSession.insert("sr.companyInsert", solVo);
	}

	// 로그인
	public SolCompanyVo login(SolCompanyVo solVo) {
		return sqlSession.selectOne("sr.companyLogin", solVo);
	}

	/********************************************
	 * 클래스
	 */
	// 회사별 클래스 리스트
	public List<SolClassVo> selectAllClass(Map<Object, String> tempVo) {
		return sqlSession.selectList("sr.companyClassList", tempVo);
	}

	// 최근일정 불러오기
	public SolScheduleVo selectSchedule(int classNo) {
		return sqlSession.selectOne("sr.maxSchedule", classNo);
	}
	//일정선택
	public SolScheduleVo selectSchedule1(Map<String, Object> temp) {
		return sqlSession.selectOne("sr.maxSchedule1", temp);
	}

	// 원데이 일정 불러오기
	public List<SolScheduleVo> selectAllOneday(int classNo) {
		return sqlSession.selectList("sr.ondayScheduleList", classNo);
	}

	// 정규클래스
	public List<SolClassVo> selectRClass(int no) {
		return sqlSession.selectList("sr.rCalss", no);
	}

	// 카테고리 불러오기
	public List<SolCateVo> selectAllCate() {
		return sqlSession.selectList("sr.selectAllCate1");
	}

	// 2차카테고리
	public List<SolCateVo> selectCate2(int no) {
		return sqlSession.selectList("sr.selectCate2", no);
	}

	/*********************************
	 * 클래스 추가/수정
	 * 
	 * @return
	 */
	// 클래스 추가
	public int insertClass(SolClassVo vo) {
		return sqlSession.insert("sr.classInsert", vo);
	}

	// 일정등록
	public int insertClassSchedul(SolScheduleVo vo) {
		return sqlSession.insert("sr.scheduleInsert", vo);
	}

	// 수정할 클래스 불러오기
	public SolClassVo selectClass(Map<String, Object> tempVo) {
//		System.out.println("selectClass");
		return sqlSession.selectOne("sr.getClass", tempVo);
	}

	// 클래스 수정
	public int updateClass(SolClassVo vo) {
		System.out.println("클래스 수정");
		return sqlSession.update("sr.classUpdate", vo);
	}

	// 수정할일정
	public List<String> updateScheduleSelect(int classNo) {
		return sqlSession.selectList("sr.updateScheduleSelect", classNo);
	}
	public SolClassVo updateScheduleSelect2(int classNo) {
		return sqlSession.selectOne("sr.updateScheduleSelect1", classNo);
	}

	// 일정수정
	public int updateSchedule(SolScheduleVo vo) {
		System.out.println("일정수정");
		return sqlSession.update("sr.scheduleUpdate", vo);
	}

	/***********************************
	 * 리스트불러오기
	 */
	// 클래스리스트
	public List<SolClassVo> selectClassList(Map<String, Object> tempVo) {
		return sqlSession.selectList("sr.classList", tempVo);
	}

	// 정규,상시회원리스트
	public List<SolMemberVo> selectRUser(int schedule) {
		return sqlSession.selectList("sr.RMemberList", schedule);
	}

	// 원데이회원리스트
	public List<SolMemberVo> selectOndUser(int schedule) {
		return sqlSession.selectList("sr.oneMeberList", schedule);
	}

	// 운영중인 클래스리스트
	public List<SolScheduleVo> selectAllSchedule(int no) {
		return sqlSession.selectList("sr.selectSchedule", no);
	}

	/****************************************
	 * 쿠폰지급
	 */
	public int insertCoupon(Map<String, Object> tempVo) {
		return sqlSession.insert("sr.insertCoupon", tempVo);
	}

	/****************************************
	 * 검색
	 */
	// 검색리스트
	public List<SolListVo> selectAddressList(SolListVo vo) {
		return sqlSession.selectList("sr.addressList", vo);
	}

	// 위시추가
	public int insertWish(Map<String, Object> vo) {
		return sqlSession.insert("sr.insertWish", vo);
	}

	// 위시삭제
	public int deleteWish(Map<String, Object> vo) {
		return sqlSession.delete("sr.deleteWish", vo);
	}

}