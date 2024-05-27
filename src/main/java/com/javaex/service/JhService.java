package com.javaex.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.JhDao;
import com.javaex.util.JsonResult;
import com.javaex.vo.PaymentVo;
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
	
}
