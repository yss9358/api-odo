package com.javaex.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.JhDao;
import com.javaex.util.JsonResult;
import com.javaex.vo.PayVo;
import com.javaex.vo.PayendVo;
import com.javaex.vo.PaymentVo;
import com.javaex.vo.ReClassVo;
import com.javaex.vo.WishClassVo;
import com.javaex.vo.WishCompanyVo;
import com.javaex.vo.WishCompanyVo2;

@Service
public class JhService {
	
	@Autowired
	JhDao jd;
	
	//클래스 위시리스트 가져오기
	public JsonResult wishClass(int no) {
		
		List<WishClassVo> wishClass = jd.wishClass(no);
		if(wishClass != null) {
			return JsonResult.success(wishClass);
		}else {
			return JsonResult.fail("위시클래스가 없습니다");
		}
	}
	
	//클래스 위시 제거하기
	public JsonResult delWish(int a) {
		
		int b = jd.delWish(a);
		
		if(b == 1) {
			return JsonResult.success(b);
		}else {
			return JsonResult.fail("삭제를 실패했습니다");
		}
	}
	
	//업체 위시리스트 가져오기
	public JsonResult wishCompany(int no) {
		
		//업체이미지, 이름, 업체 번호 가져오기
		List<WishCompanyVo> wishCompany = jd.wishCompany(no);
		
		List<WishCompanyVo2> wishCompany2 = new ArrayList<>();
		
		//업체 번호로 업체의 클래스, 리뷰, 위시 수 가져오기
		for(int i = 0; i<wishCompany.size(); i++) {
			
			String companyImage = wishCompany.get(i).getCompanyImage();
			
			String companyName = wishCompany.get(i).getCompanyName();
			
			int companyNo = wishCompany.get(i).getCompanyNo();
			
			int no2 = wishCompany.get(i).getNo();
			
			int classCount = jd.classCount(no);
			
			int reviewCount = jd.reviewCount(no);
			
			int wishCount = jd.wishCount(no);
			
			WishCompanyVo2 wVo = new WishCompanyVo2(companyImage, companyName, companyNo, no2, classCount, reviewCount, wishCount);
			
			wishCompany2.add(wVo);
		}
		if(wishCompany2 != null) {
			return JsonResult.success(wishCompany2);
		}else {
			return JsonResult.fail("위시업체가 없습니다");
		}
	}
	
	//업체 위시리스트 제거
	public JsonResult delWishCompany(int a) {
		
		int b = jd.delWishCompany(a);
		
		if(b == 1) {
			return JsonResult.success(b);
		}else {
			return JsonResult.fail("삭제를 실패했습니다");
		}
	}
	
	//결제페이지
	public Map<String, Object> paymentPage(int a, int no) {
		
		PaymentVo pv = jd.paymentPage(a);
		
		int b = pv.getCompanyNo();
		
		Map<String, Integer> Map = new HashMap<>();
		
		Map.put("b", b);
		Map.put("no", no);
		
		List<Integer> couponList = jd.paymentPage2(Map);
		
		Map<String, Object> payment = new HashMap<>();
		payment.put("pv", pv);
		payment.put("couponList", couponList);
		System.out.println(pv);
		
		return payment;
	}
	
	//결제
	public JsonResult pay(PayVo pv) {
		int a = jd.pay(pv);
		
		System.out.println(pv.getCouponNo());
		
		if(pv.getCouponNo() == 0) {
			if(a>0) {
				int c = pv.getPay_no();	
				return JsonResult.success(c);
			}else {
				return JsonResult.fail("실패");
			}
		}else {
			int b = jd.useCoupon(pv.getCouponNo());
			if(a > 0 && b > 0) {
				int c = pv.getPay_no();	
				return JsonResult.success(c);
			}else {
				return JsonResult.fail("실패");
			}
		}
		
		/*
		int b = jd.useCoupon(pv.getCouponNo());
		if(a > 0 && b > 0) {
			int c = pv.getPay_no();	
			return JsonResult.success(c);
		}else {
			return JsonResult.fail("실패");
		}
		*/
	}
	
	//결제완료페이지
	public Map<String, Object> payend(int a) {
		
		//가져오기 1번
		PayendVo pv = jd.payend(a);
		
		//할인금액 가져오기 2번
		int b = jd.getCoupon(a);
		
		pv.setCouponPrice(b);
		
		//관련 클래스 리스트
		int c = pv.getCompanyNo();
		//랜덤으로 클래스 번호 가져오기
		List<Integer> cList = jd.randClassNo(c);
		
		List<ReClassVo> rList = new ArrayList<>();
		for(int i = 0; i<cList.size(); i++) {
			int d = cList.get(i);
			//클래스 정보 가져오기1
			ReClassVo rc = jd.reclass(d);
			ReClassVo rc2 = jd.reclass2(d);
			
			rc.setReviewPoint(rc2.getReviewPoint());
			rc.setReviewCount(rc2.getReviewCount());
			rc.setClassNo(d);
			rList.add(rc);
		}
		System.out.println(rList);
		
		Map<String, Object> payMap = new HashMap<>();
		payMap.put("pv", pv);
		payMap.put("rList", rList);
		
		return payMap;
	}
	
}
