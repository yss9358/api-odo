package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CouponVo;
import com.javaex.vo.UserJoinVo;

@Repository
public class SsDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 아이디 중복확인
	public UserJoinVo checkId(String id) {
		return sqlSession.selectOne("ss.checkId", id);
	}
	
	// 일반회원 회원가입
	public int insertUser(UserJoinVo vo) {
		return sqlSession.insert("ss.insertUser",vo);
	}
	
	// 일반회원 로그인
	public UserJoinVo loginByIdPw(UserJoinVo vo) {
		return sqlSession.selectOne("ss.loginByIdPw", vo);
	}
	
	// 회원 원데이 결제내역 가져오기
	public void getOneDayPayListByNo(int no) {
		System.out.println(no);
		
		
//		sqlSession.selectList("ss.getOneDayPayListByNo",no);
	}
	
	// 회원 정규 결제내역 가져오기
	public void getRegularPayListByNo(int no) {
		System.out.println(no);
	}
	
	// 쿠폰정보 가져오기
	public List<CouponVo> getCouponByNo(int no) {
		return sqlSession.selectList("ss.getCouponByNo",no);
	}
	
}
