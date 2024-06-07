package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.AndroidVo;
import com.javaex.vo.CompanyInfoVo;
import com.javaex.vo.CompanyInfoVo2;
import com.javaex.vo.PayVo;
import com.javaex.vo.PayendVo;
import com.javaex.vo.PaymentVo;
import com.javaex.vo.ReClassVo;
import com.javaex.vo.SolCompanyVo;
import com.javaex.vo.UserJoinVo;
import com.javaex.vo.WishClassVo;
import com.javaex.vo.WishCompanyVo;

@Repository
public class JhDao {

	@Autowired
	SqlSession sqlSession;
	
	//클래스 위시리스트 가져오기
	public List<WishClassVo> wishClass(int no) {
		
		List<WishClassVo> wishClass = sqlSession.selectList("jh.wishclass", no);
		//System.out.println(wishClass);
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
	
	//결제완료 페이지
	public PayendVo payend(int a) {
		PayendVo pv = sqlSession.selectOne("jh.payend", a);
		return pv;
	}
	
	//쿠폰번호 가져오기
	public int getCoupon(int a) {
		
		if(sqlSession.selectOne("jh.getCoupon", a) == null) {
			return 0;
		}else {
			int b = sqlSession.selectOne("jh.getCoupon", a);
			//System.out.println(b);
			return b;
		}
	}
	
	//램던으로 클래스 번호 뽑기
	public List<Integer> randClassNo(int a) {
		
		List<Integer> cList = sqlSession.selectList("jh.randClassNo", a);
		//System.out.println(cList);
		return cList;
	}
	
	//클래스 정보가져오기1
	public ReClassVo reclass(int a) {
		
		ReClassVo rc = sqlSession.selectOne("jh.reclass", a);
		
		return rc;
	}
	
	//클래스 정보가져오기2
	public ReClassVo reclass2(int a) {
		
		ReClassVo rc2 = sqlSession.selectOne("jh.reclass2", a);
		
		return rc2;
	}
	
	//업체정보1
	public CompanyInfoVo companyinfo(Map<String, Integer> intMap) {

		CompanyInfoVo ci = sqlSession.selectOne("companyinfo1", intMap);
		
		return ci;
	}
	
	//업체정보2 클래스 리스트
	public List<CompanyInfoVo2> classList(Map<String, Integer> intMap) {
		
		List<CompanyInfoVo2> ci2 = sqlSession.selectList("jh.companyinfo2", intMap);
		//System.out.println(ci2);
		return ci2;
	}
	
	//업체정보3 클래스리스트2
	public CompanyInfoVo2 classList2(int a) {
		
		CompanyInfoVo2 ci2 = sqlSession.selectOne("jh.companyinfo3", a);
		return ci2;
	}
	
	//클래스 위시등록
	public int wishInsert(Map<String, Integer> intMap) {
		
		return sqlSession.insert("jh.wishInsert", intMap);
	}
	
	//업체 위시등록
	public void wishInsert2(WishCompanyVo wc) {
		
		sqlSession.insert("jh.wishInsert2", wc);
	}
	
	//클래스 위시삭제
	public int wishDelete(Map<String, Integer> intMap) {
		
		return sqlSession.delete("jh.wishDelete", intMap);
	}
	
	//업체 위시삭제
	public int wishDelete2(int a) {
		
		return sqlSession.delete("jh.wishDelete2", a);
	}
	
	//업체정보 수정페이지
	public SolCompanyVo companymodify(int a) {
		
		return sqlSession.selectOne("jh.companymodify", a);
	}
	
	//업체정보 수정
	public int update(SolCompanyVo solVo) {
		
		return sqlSession.update("jh.update", solVo);
	}
	
	//안드로이드 수강신청한 업체리스트
	public List<AndroidVo> AndroidList1() {
		
		List<AndroidVo> aList = sqlSession.selectList("jh.androidList1");
		
		return aList;
	}
	
	//안드로이드 수강신청한 업체리스트2
	public int AndroidList2(int a) {
		
		int b = sqlSession.selectOne("jh.androidList2", a);
		
		return b;
	}
	
	//안드로이드 출석체크
	public int AndroidCheck(int no) {
		
		int a = sqlSession.selectOne("jh.androidCheck", no);

		return a;
	}
	
	//안드로이드 출석체크2
	public void AndroidCheck2(int no) {

		sqlSession.insert("jh.androidCheck2", no);
		
	}
	
	//안드로이드 로그인
	public UserJoinVo AndroidLog(UserJoinVo uv ) {
		
		return sqlSession.selectOne("jh.androidLog", uv);
	}
}
