package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
//	KakaoAPI kakaoApi = new KaKaoAPI();
	
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
			return JsonResult.fail("다시 로그인 해주세요.");
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
		if(userNo != -1) {
			int count = ssService.exeInsertReview(userNo,vo);
			return JsonResult.success(count);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 작성한 리뷰 정보 가져오기
	@GetMapping("/odo/ss/reviews")
	public JsonResult getReview(	
			@RequestParam(value="reviewNo") int reviewNo,
			HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			Map<String, Object> resultMap = ssService.exeGetReview(userNo, reviewNo);
			return JsonResult.success(resultMap);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 리뷰 수정하기
	@PutMapping("/odo/ss/reviews")
	public JsonResult modifyReview(HttpServletRequest request,@ModelAttribute ReviewVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			int count = ssService.exeUpdateReview(userNo,vo);
			return JsonResult.success(count);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 출석정보 가져오기
	@GetMapping("/odo/ss/attenlist")
	public JsonResult attenList(@RequestParam(value="scheduleNo") int scheduleNo, HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			Map<String,Object> map = ssService.exeGetAttenList(userNo,scheduleNo);
			return JsonResult.success(map);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 쿠폰정보 가져오기
	@GetMapping("/odo/ss/usercoupon")
	public JsonResult couponList(HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			List<CouponVo> list = ssService.exeCheckCoupon(userNo);
			return JsonResult.success(list);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
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
		if(userNo != -1) {
			vo.setUserNo(userNo);
			int count = ssService.exeInsertWishClass(vo);
			if(count == 1) {
				return JsonResult.success(count);
			} else {
				return JsonResult.fail("등록실패");
			}
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 위시 클래스 삭제
	@DeleteMapping("odo/ss/wishclassis")
	public JsonResult deleteWishClass(HttpServletRequest request, @ModelAttribute CheckWishClassVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			vo.setUserNo(userNo);
			int count = ssService.exeDeleteWishClass(vo);
			if(count == 1) {
				return JsonResult.success(count);
			} else {
				return JsonResult.fail("삭제실패");
			}
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	

	
}
