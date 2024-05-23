package com.javaex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.JhDao;
import com.javaex.util.JsonResult;
import com.javaex.vo.WishClassVo;
import com.javaex.vo.WishCompanyVo;
import com.javaex.vo.WishCompanyVo2;

@Service
public class JhService {
	
	@Autowired
	JhDao jd;
	
	//클래스 위시리스트 가져오기
	public JsonResult wishClass() {
		
		List<WishClassVo> wishClass = jd.wishClass();
		if(wishClass != null) {
			return JsonResult.success(wishClass);
		}else {
			return JsonResult.fail("위시클래스가 없습니다");
		}
	}
	
	//업체 위시리스트 가져오기
	public JsonResult wishCompany() {
		
		//업체이미지, 이름, 업체 번호 가져오기
		List<WishCompanyVo> wishCompany = jd.wishCompany();
		
		List<WishCompanyVo2> wishCompany2 = new ArrayList<>();
		
		//업체 번호로 업체의 클래스, 리뷰, 위시 수 가져오기
		for(int i = 0; i<wishCompany.size(); i++) {
			
			String companyImage = wishCompany.get(i).getCompanyImage();
			
			String companyName = wishCompany.get(i).getCompanyName();
			
			int no = wishCompany.get(i).getCompanyNo();
			
			int classCount = jd.classCount(no);
			
			int reviewCount = jd.reviewCount(no);
			
			int wishCount = jd.wishCount(no);
			
			WishCompanyVo2 wVo = new WishCompanyVo2(companyImage, companyName, classCount, reviewCount, wishCount);
			
			wishCompany2.add(wVo);
		}
		if(wishCompany2 != null) {
			return JsonResult.success(wishCompany2);
		}else {
			return JsonResult.fail("위시업체가 없습니다");
		}
	}
	
}
