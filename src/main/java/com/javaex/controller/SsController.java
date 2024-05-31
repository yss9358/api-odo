package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SsService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.CheckWishClassVo;
import com.javaex.vo.ClassReviewVo;
import com.javaex.vo.CouponVo;
import com.javaex.vo.MyPayVo;
import com.javaex.vo.OneClassVo;
import com.javaex.vo.ReviewVo;
import com.javaex.vo.UserJoinVo;

import jakarta.servlet.http.HttpServletRequest;
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
	public JsonResult getPayList(
			@RequestParam(value="classType") int classType, 
			HttpServletRequest request,
			@RequestParam(value="page", required = false, defaultValue="1") int page
			) {
		int userNo = JwtUtil.getNoFromHeader(request);

		if(userNo != -1) {
			List<MyPayVo> list = ssService.exePayList(classType,userNo,page);
			if(list != null) {
				return JsonResult.success(list);
			} else {
				return JsonResult.fail("더 이상 불러올 리스트가 없습니다.");
			}
			
		} else {
			return JsonResult.fail("다시 로그인해주세요.");
		}
	}
	
	// 리뷰쓸때 클래스정보 가져오기
	@GetMapping("/odo/ss/getclassone")
	public JsonResult getClassOne(@RequestParam(value="scheduleNo") int no) {
		OneClassVo vo = ssService.exeGetClassOne(no);
		return JsonResult.success(vo);
	}
	
	// 리뷰 작성
	@PostMapping("/odo/ss/reviews")
	public JsonResult writeReveiw(HttpServletRequest request,@ModelAttribute ReviewVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		int count = ssService.exeInsertReview(userNo,vo);
		return JsonResult.success(count);
	}
	
	// 작성한 리뷰 정보 가져오기
	@GetMapping("/odo/ss/reviews")
	public JsonResult getReview(	@RequestParam(value="reviewNo") int reviewNo,
									HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userNo", userNo);
		map.put("reviewNo", reviewNo);
		Map<String, Object> resultMap = ssService.exeGetReview(map);
		return JsonResult.success(resultMap);
	}
	
	// 리뷰 수정하기
	@PutMapping("/odo/ss/reviews")
	public JsonResult modifyReview(HttpServletRequest request,@ModelAttribute ReviewVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		int count = ssService.exeUpdateReview(userNo,vo);
		return JsonResult.success(count);
	}
	
	// 출석정보 가져오기
	@GetMapping("/odo/ss/attenlist")
	public JsonResult attenList(@RequestParam(value="scheduleNo") int scheduleNo, HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		Map<String,Object> map = ssService.exeGetAttenList(userNo,scheduleNo);
		return JsonResult.success(map);
	}
	
	// 쿠폰정보 가져오기
	@GetMapping("/odo/ss/usercoupon")
	public JsonResult couponList(HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		List<CouponVo> list = ssService.exeCheckCoupon(userNo);
		return JsonResult.success(list);
	}
	
	// 리뷰페이지 - 클래스 리뷰 가져오기
	@GetMapping("/odo/ss/classreviewlist")
	public JsonResult classReview(
			@RequestParam(value="classNo") int classNo,
			@RequestParam(value="type") int type,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		List<ClassReviewVo> list = ssService.exeGetClassReviewList(classNo,type,page);
		if(list != null) {
			return JsonResult.success(list); 
		} else {
			return JsonResult.fail("더 이상 불러올 리스트가 없습니다.");
		}
	}
	
	// 리뷰페이지 - 클래스 정보 가져오기
	@GetMapping("/odo/ss/classinfo")
	public JsonResult classInfo(@RequestParam(value="classNo") int classNo) {
		Map<String,Object> map = ssService.exeClassInfo(classNo);
		return JsonResult.success(map);
	}
	
	// 위시 클래스 추가
	@PostMapping("odo/ss/wishclassis")
	public JsonResult addWishClass(HttpServletRequest request, @ModelAttribute CheckWishClassVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		vo.setUserNo(userNo);
		int count = ssService.exeInsertWishClass(vo);
		if(count == 1) {
			return JsonResult.success(vo.getwClassNo());
		} else {
			return JsonResult.fail("등록실패");
		}
	}
	
	// 위시 클래스 삭제
	@DeleteMapping("odo/ss/wishclassis")
	public JsonResult deleteWishClass(HttpServletRequest request, @ModelAttribute CheckWishClassVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		vo.setUserNo(userNo);
		int count = ssService.exeDeleteWishClass(vo);
		if(count == 1) {
			return JsonResult.success(count);
		} else {
			return JsonResult.fail("삭제실패");
		}
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
