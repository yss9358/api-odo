package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.JhDao;
import com.javaex.util.JsonResult;
import com.javaex.vo.WishClassVo;

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
	public void wishCompany() {
		
		//업체이미지, 이름, 업체 번호 가져오기
		jd.wishCompany();
		
		//업체 번호로 업체의 클래스 수 가져오기
		
		
		//업체 번호로 업체의 위시 수 가져오기
		
		
		//업체 번호로 업체가 가진 클래스의 리뷰 수 가져오기
		
		
	}
	
}
