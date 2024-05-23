package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SsService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
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
	
	// 카카오 로그인
	@GetMapping("/odo/ss/oauth/kakao")
	public void kakaoLogin() {
		System.out.println("kakao");
	}
	
	
	
	
}
