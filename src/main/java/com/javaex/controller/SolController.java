package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.SolService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.SolCateVo;
import com.javaex.vo.SolClassVo;
import com.javaex.vo.SolCompanyVo;
import com.javaex.vo.SolListVo;
import com.javaex.vo.SolMemberVo;
import com.javaex.vo.SolScheduleVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("odo/company")
public class SolController {

	@Autowired
	private SolService solservice;

	/**********************************************
	 * 사업자관련 메소드
	 * 
	 * @param vo
	 * @param response
	 * @return
	 */
	// 사업자 로그인
	@PostMapping("login")
	public JsonResult companyLogin(@RequestBody SolCompanyVo vo, HttpServletResponse response) {
		System.out.println("SolController.companyLogin()");
		SolCompanyVo authCompany = solservice.exeLogin(vo);
		if (authCompany != null) {
			JwtUtil.createTokenAndSetHeader(response, "" + authCompany.getCompanyNo());
			return JsonResult.success(authCompany);
		} else {
			return JsonResult.fail("아이디와 비밀번호를 확인하세요.");
		}
	}

	// 사업자가입
	@PostMapping("join")
	public JsonResult companyJoin(@ModelAttribute SolCompanyVo solVo) {
		System.out.println("SolController.companyJoin()");
		String saveName = solservice.exeCompanyImg(solVo.getCompanyFile());
		solVo.setCompanyImage(saveName);

		int count = solservice.exeInsertCompany(solVo);
		if (count > 0) {
			return JsonResult.success("회원가입 성공");
		} else {
			return JsonResult.fail("회원가입 실패");
		}
	}

	// 아이디 중복확인
	@GetMapping("id")
	public JsonResult companyId(@RequestParam(value = "companyId") String id) {
		System.out.println("SolController.companyId()");
		if (solservice.exeId(id) == null) {
			return JsonResult.success(id);
		} else {
			return JsonResult.fail("등록된 아이디 있음");
		}
	}

	/**********************************************
	 * 클래스관련 메소드
	 */
	@PostMapping("cclist")
	public JsonResult classList(@RequestBody Map<Object, String> tempVo) {
		System.out.println("SolController.classList");
//		System.out.println(tempVo.get("type"));
		List<SolClassVo> classList = solservice.exeClassList(tempVo);
//		System.out.println(classList);
		if (classList.size() > 0) {
			return JsonResult.success(classList);
		} else {
			return JsonResult.fail("리스트없음");
		}
	}

	// 선택한클래스 불러오기
	@GetMapping("getclass")
	public JsonResult getSelectClass(@RequestParam(value = "companyNo") int companyNo,
			@RequestParam(value = "classNo") int classNo) {
		System.out.println("SolController.getClass()");
		Map<String, Object> tempVo = new HashMap<String, Object>();
		tempVo.put("companyNo", companyNo);
		tempVo.put("classNo", classNo);
		SolClassVo classVo = solservice.exeGetClass(tempVo);
		System.out.println(classVo);
		if (classVo != null) {
			return JsonResult.success(classVo);
		} else {
			return JsonResult.fail("정보 불러오기 실패");
		}
	}

	// 클래스 불러오기
	@PostMapping("getrclass/{no}")
	public JsonResult getRClass(@PathVariable int no) {
		System.out.println("SolController.getRClass");
		List<SolClassVo> classList = solservice.exegetRClass(no);
//		System.out.println(classList);
		if (classList != null) {
			return JsonResult.success(classList);
		} else {
			return JsonResult.fail(null);
		}

	}

	// 카테고리 불러오기
	@PostMapping("getcate")
	public JsonResult getCate() {
		System.out.println("SolController.getCate()");
		List<SolCateVo> cateList = solservice.exeGetCate();
//			System.out.println(cateList);
		if (cateList != null) {
			return JsonResult.success(cateList);
		} else {
			return JsonResult.fail("불러오기 실패");
		}
	}

	// 2차 카테고리 리스트
	@GetMapping("getcate2/{no}")
	public JsonResult getCate2(@PathVariable int no) {
		System.out.println("SolController.getCate2()");
		List<SolCateVo> cateList = solservice.exeGetCate2(no);
		if (cateList != null) {
			return JsonResult.success(cateList);
		} else {
			return JsonResult.fail(null);
		}

	}

	// 상세이미지 저장
	@PostMapping("file")
	public JsonResult classinfoFile(@RequestParam(value = "file") MultipartFile file) {
		System.out.println("SolController.classinfoFile");

//		System.out.println(file.getOriginalFilename());
		String saveName = solservice.exeCompanyImg(file);
		return JsonResult.success(saveName);
	}//

	/***********************************************
	 * 클래스 추가/수정
	 */
	// 클래스 추가
	@PostMapping("insert")
	public JsonResult classAdd(@ModelAttribute SolClassVo vo) {
		System.out.println("SolController.classAdd");
		System.out.println(vo.getClassImageFile().getOriginalFilename());
		solservice.exeInsertClass(vo);

		return JsonResult.success("");
	}

	// 클래스 수정
	@PostMapping("update")
	public JsonResult getUpdateClass(@ModelAttribute SolClassVo vo) {
		System.out.println("SolController.getUpdateClass");
//		int token = JwtUtil.getNoFromHeader(request);
		int count = -1;
		count = solservice.exeupdate(vo);
		if (count > 0) {
			return JsonResult.success("수정되었습니다.");
		} else {
			return JsonResult.fail("");
		}
	}

	/************************************************
	 * 리스트
	 */
	// 클래스리스트
	@GetMapping("list")
	public JsonResult classTypeList(@RequestParam(value = "classType") int classType,
			@RequestParam(value = "companyNo") int companyNo) {
		System.out.println("SolController.classList");
		Map<String, Object> tempVo = new HashMap<String, Object>();
		tempVo.put("classType", classType);
		tempVo.put("companyNo", companyNo);
		List<SolClassVo> classList = solservice.exeClassTypeList(tempVo);
		System.out.println(classList);
		if (classList != null) {
			return JsonResult.success(classList);
		} else {
			return JsonResult.fail(null);
		}

	}

	// 유저리스트
	@GetMapping("member/{type}/{no}")
	public JsonResult memberList(@PathVariable("type") int type, @PathVariable("no") int schedule) {
		System.out.println("SolController.memberList");
		List<SolMemberVo> memberList = solservice.exeUserList(type, schedule);
		System.out.println(memberList);
		if (memberList != null) {
			return JsonResult.success(memberList);
		}
		return null;
	}

	// 스케줄리스트
	@GetMapping("getschedule/{no}")
	public JsonResult getSchedule(@PathVariable int no) {
		System.out.println("SolController.getSchedule");
		List<SolScheduleVo> scheduleList = solservice.exeScheduleList(no);
		System.out.println(scheduleList);
		if (scheduleList != null) {
			return JsonResult.success(scheduleList);
		} else {
			return JsonResult.fail(null);
		}
	}

	/********************************************
	 * 쿠폰지급
	 */
	@PostMapping("coupon")
	public JsonResult setCoupon(@RequestParam(value = "userNo") int userNo,
			@RequestParam(value = "companyNo") int companyNo, @RequestParam(value = "couponPrice") int couponPrice) {
		System.out.println("SolController.setCoupon");
		Map<String, Object> tempVo = new HashMap<>();
		tempVo.put("userNo", userNo);
		tempVo.put("companyNo", companyNo);
		tempVo.put("couponPrice", couponPrice);
		int count = solservice.exeCoupon(tempVo);
		if (count > 0) {
			return JsonResult.success("지급되었습니다");
		} else {
			return JsonResult.fail(null);
		}
	}

	/******************************************
	 * 검색
	 */
	@GetMapping("classlist")
	public JsonResult getClassList(@ModelAttribute SolListVo vo) {
		System.out.println("SolController.getClassList");
		System.out.println(vo.getIsFind());
		if(vo.getPage() <= 0) {
			vo.setPage(1);
		}
		List<SolListVo> classList = solservice.exeFindClassList(vo);
		System.out.println(classList);
		if(classList != null) {
			return JsonResult.success(classList);
		} else {
			return JsonResult.fail(null);
		}
	}

}
