package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.JhService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class JhController {

	@Autowired
	JhService js;

	// 유저의 클래스 위시리스트 가져오기
	@GetMapping("/odo/wishclass")
	public JsonResult wishclass(HttpServletRequest request) {
		int no = JwtUtil.getNoFromHeader(request);

		if (no > 0) {
			return js.wishClass(no);
		} else {
			return JsonResult.fail("fail");
		}
	}

	// 유저의 클래스 위시 삭제하기
	@DeleteMapping("odo/wishclass")
	public JsonResult delWishClass(HttpServletRequest request, @RequestBody int a) {
		int no = JwtUtil.getNoFromHeader(request);

		if (no > 0) {
			return js.delWish(a);
		} else {
			return JsonResult.fail("fail");
		}
	}

	// 유저의 업체 위시리스트 가져오기
	@GetMapping("/odo/wishcompany")
	public JsonResult wishcompany(HttpServletRequest request) {

		int no = JwtUtil.getNoFromHeader(request);

		if (no > 0) {
			return js.wishCompany(no);
		} else {
			return JsonResult.fail("fail");
		}
	}
	
	//유저의 업체 위시리스트 삭제하기
	@DeleteMapping("odo/wishcompany")
	public JsonResult delWishCompany(HttpServletRequest request, @RequestBody int a) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			return js.delWishCompany(a);
		}else {
			return JsonResult.fail("fail");
		}
		
	}
	
	//결제페이지
	@GetMapping("odo/payment/{no}")
	public JsonResult payment(HttpServletRequest request, @PathVariable("no") int a) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			return JsonResult.success(js.paymentPage(a, no));
		}else {
			return JsonResult.fail("fail");
		}
		
	}

}
