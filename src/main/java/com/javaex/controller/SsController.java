package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SsService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.CouponVo;
import com.javaex.vo.UserJoinVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class SsController {
	
	@Autowired
	private SsService ssService;
	
	// 아이디 중복확인
	@GetMapping("/odo/ss/checkid")
	public JsonResult checkId(@RequestParam(value="id") String id) {
		int count = ssService.exeCheckId(id);
		return JsonResult.success(count);
	}
	
	// 일반회원 회원가입
	@PostMapping("/odo/ss/userjoin")
	public JsonResult userJoin(@RequestBody UserJoinVo vo) {
		int count = ssService.exeJoin(vo);
		return JsonResult.success(count);
	}
	
	// 일반회원 로그인
	@PostMapping("/odo/ss/userlogin")
	public JsonResult userLogin(@RequestBody UserJoinVo vo, HttpServletResponse response) {
		UserJoinVo authVo = ssService.exeLogin(vo);
		if(authVo != null) {
			JwtUtil.createTokenAndSetHeader(response, ""+authVo.getUserNo());
			return JsonResult.success(authVo);
		} else {
			return JsonResult.fail("아이디와 비밀번호를 확인하세요.");
		}
	}
	
	// 회원 결제내역 가져오기
	@GetMapping("/odo/ss/getpaylist")
	public void getPayList(@RequestParam(value="no") int no,@RequestParam(value="userNo") int userNo) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("no", no); // 원데이,정규 구분
		map.put("userNo", userNo); // 유저번호
		ssService.exePayList(map);
		
		
		
	}
	
	
	// 쿠폰정보 가져오기
	@GetMapping("/odo/ss/usercoupon/{no}")
	public JsonResult couponList(@PathVariable(value="no") int no) {
		List<CouponVo> list = ssService.exeCheckCoupon(no);
		return JsonResult.success(list);
	}
	
	
	
	
	
	
	
//	// 카카오 로그인
//	@GetMapping("/odo/user/oauth")
//	public String kakaoLogin() {
//		System.out.println("kakao");
//		String url = "http://kauth.kakao.com/oauth/authorize?client_id=4946b7c22ba5fb9b866b344e8f2f4224&redirect_uri=http://localhost:8080/kak&response_type=code";
//		System.out.println(url);
//		return url;
//	}
	
	// 카카오 로그인 토큰 가져오기 
	@GetMapping("/odo/ss/token/{code}")
	public void kakaoToken(@PathVariable(value="code") String code) {
		ssService.requestToken(code);
	}
	
	
	
	
}
