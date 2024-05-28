package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PayVo;
import com.javaex.vo.PaymentVo;
import com.javaex.vo.WishClassVo;
import com.javaex.vo.WishCompanyVo;

@Repository
public class JhDao {

	@Autowired
	SqlSession sqlSession;
	
	//클래스 위시리스트 가져오기
	public List<WishClassVo> wishClass(int no) {
		
		List<WishClassVo> wishClass = sqlSession.selectList("jh.wishclass", no);
		System.out.println(wishClass);
		return wishClass;
	}
	
	//클래스 위시 제거하기
	public int delWish(int a) {
		
		return sqlSession.delete("jh.delwish", a);
	}
	
	//업체 위시리스트 이름, 이미지, 번호 가져오기
	public List<WishCompanyVo> wishCompany(int no) {
		List<WishCompanyVo> wishCompany =  sqlSession.selectList("jh.wishcompany1", no);
		return wishCompany;
	}
	
	//업체 클래스 수 가져오기
	public int classCount(int no) {
		
		return sqlSession.selectOne("jh.classCount", no);
	}
	
	//업체 리뷰 수 가져오기
	public int reviewCount(int no) {
		
		return sqlSession.selectOne("jh.reviewCount", no);
	}
	
	//업체 위시 수 가져오기
	public int wishCount(int no) {
		
		return sqlSession.selectOne("jh.wishCount", no);
	}
	
	//업체 위시리스트 제거
	public int delWishCompany(int a) {
		
		return sqlSession.delete("jh.delWishCompany", a);
	}
	
	//결제페이지
	public PaymentVo paymentPage(int a) {
		
		PaymentVo pv = sqlSession.selectOne("jh.paymentPage", a);
		
		return pv;
	}
	
	//결제페이지 쿠폰리스트
	public List<Integer> paymentPage2(Map<String, Integer> Map) {
		
		
		List<Integer> couponList = sqlSession.selectList("jh.paymentPage2", Map);
		
		return couponList;
	}
	
	//결제
	public int pay(PayVo pv) {
		//System.out.println(pv);
		
		//return 0;
		return sqlSession.insert("jh.pay", pv);
	}
	
	//쿠폰사용처리
	public int useCoupon(int no) {
		
		//return 0;
		return sqlSession.update("jh.useCoupon", no);
	}
	
}
