package com.javaex.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.JhService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.PayVo;
import com.javaex.vo.SolCompanyVo;
import com.javaex.vo.WishCompanyVo;

import jakarta.servlet.http.HttpServletRequest;

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
	
	//결제
	@PutMapping("odo/pay")
	public JsonResult pay(HttpServletRequest request, @RequestBody PayVo pv) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			pv.setUserNo(no);
			return JsonResult.success(js.pay(pv));
		}else {
			return JsonResult.fail("fail");
		}
	}
	
	//결제완료 페이지
	@GetMapping("odo/payend/{no}")
	public JsonResult payend(HttpServletRequest request, @PathVariable("no") int a) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			return JsonResult.success(js.payend(a));
		}else {
			return JsonResult.fail("fail");
		}
	}
	
	//업체정보
	@GetMapping("odo/companyinfo/{no}")
	public Map<String, Object> companyifno(HttpServletRequest request, @PathVariable("no") int a) {
		int no = JwtUtil.getNoFromHeader(request);
		
		Map<String, Integer> intMap = new HashMap<>();
		intMap.put("no", no);
		intMap.put("companyNo", a);
		
		return js.companyinfo(intMap);
	}
	
	//클래스 위시등록
	@PostMapping("odo/companyinfo/wishInsert")
	public JsonResult wishInsert(HttpServletRequest request, @RequestBody int a) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			Map<String, Integer> intMap = new HashMap<>();
			intMap.put("classNo", a);
			intMap.put("userNo", no);
			
			return JsonResult.success(js.wishInsert(intMap));
		}else {
			return JsonResult.fail("fail");
		}
	}
	
	//업체 위시등록
	@PostMapping("odo/companyinfo/wishInsert2")
	public JsonResult wishInsert2(HttpServletRequest request, @RequestBody int a) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			WishCompanyVo wc = new WishCompanyVo(a, no);
			
			return JsonResult.success(js.wishInsert2(wc));
		}else {
			return JsonResult.fail("fail");
		}
		
	}
	
	//클래스 위시삭제
	@DeleteMapping("odo/companyinfo/wishDelete")
	public JsonResult wishDelete(HttpServletRequest request, @RequestBody int a) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			Map<String, Integer> intMap = new HashMap<>();
			intMap.put("classNo", a);
			intMap.put("userNo", no);
			
			return JsonResult.success(js.wishDelete(intMap));
		}else {
			return JsonResult.fail("fail");
		}
	}
	
	//업체 위시삭제
	@DeleteMapping("odo/companyinfo/wishDelete2")
	public JsonResult wishDelete2(HttpServletRequest request, @RequestBody int a) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			return JsonResult.success(js.wishDelete2(a));
		}else {
			return JsonResult.fail("fail");
		}
	}
	
	//업체정보 수정페이지
	@GetMapping("odo/companymodify")
	public JsonResult companymodify(HttpServletRequest request) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			js.companymodify(no);
			return JsonResult.success(js.companymodify(no));
		}else {
			return JsonResult.fail("fail");
		}
	}
	
	//업체수정
	@PutMapping("odo/companymodify")
	public JsonResult modify(HttpServletRequest request, @ModelAttribute SolCompanyVo solVo) {
		int no = JwtUtil.getNoFromHeader(request);
		
		if(no > 0) {
			//solVo.setCompanyNo(no);
			//System.out.println(solVo);
			js.update(solVo);
			return JsonResult.success(solVo);
		}else {
			return JsonResult.fail("fail");
		}
	}
	
	//안드로이드 회원의 학원 등록 리스트
	@PostMapping("odo/android/list")
	public void AndroidList() {
		
	}
	
}
