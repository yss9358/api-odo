package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ClassReviewVo;
import com.javaex.vo.CouponVo;
import com.javaex.vo.MyPayVo;
import com.javaex.vo.OneClassVo;
import com.javaex.vo.ReviewVo;
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
	public List<MyPayVo> getOneDayPayListByNo(int userNo) {
		return sqlSession.selectList("ss.getOneDayPayListByNo",userNo);
	}
	
	// 회원 정규 결제내역 가져오기
	public List<MyPayVo> getRegularPayListByNo(int userNo) {
		return sqlSession.selectList("ss.getRegularPayListByNo",userNo);
	} 
	
	// 리뷰 쓸때 클래스 정보 가져오기
	public OneClassVo getClassOne(int no) {
		return sqlSession.selectOne("ss.getClassOne", no);
	}
	
	// 리뷰 작성
	public int insertReview(ReviewVo vo) {
		return sqlSession.insert("ss.insertReview", vo);
	}
	
	// 작성한 리뷰 정보 가져오기
	public Map<String,Object> getReview(Map<String, Integer> map) {
		return sqlSession.selectOne("ss.getReivew", map);
	}
	
	// 리뷰 수정하기
	public int updateReview(ReviewVo vo) {
		return sqlSession.update("ss.updateReview", vo);
	}
	
	// 출석정보 가져오기
	public List<Map<String,Object>> getAttenList(Map<String, Integer> map) {
		return sqlSession.selectList("ss.getAttenList",map);
	}
	
	// 출석횟수 가져오기
	public int getAttenCount(Map<String, Integer> map) {
		return sqlSession.selectOne("ss.getAttenCount", map);
	}
	
	// 쿠폰정보 가져오기
	public List<CouponVo> getCouponByNo(int no) {
		return sqlSession.selectList("ss.getCouponByNo",no);
	}
	
	// 리뷰페이지 - 클래스 리뷰 가져오기
	public List<ClassReviewVo> getClassReviewList(int classNo) {
		return sqlSession.selectList("ss.getClassReviewList", classNo);
	}
	
	// 리뷰페이지 - 클래스 정보 가져오기
	public Map<String,Object> getClassInfo(int classNo) {
		return sqlSession.selectOne("ss.getClassInfo", classNo);
	}
	
}
