package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SolService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.SolClassVo;
import com.javaex.vo.SolCompanyVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("odo/company")
public class SolController {

	@Autowired
	private SolService solservice;

	/**********************************************
	 * 사업자관련 메소드
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
			JwtUtil.createTokenAndSetHeader(response, ""+authCompany.getCompanyNo());
			return JsonResult.success("");
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
	public JsonResult classList(@RequestBody Map<Object, String> tempVo){
		System.out.println("SolController.classList");
		System.out.println(tempVo.get("type"));
		List<SolClassVo> classList = solservice.exeClassList(tempVo);
		System.out.println(classList);
		if (classList.size() > 0) {
			return JsonResult.success(classList);
		} else {
			return JsonResult.fail("리스트없음");
		}
	}
	
	//선택한클래스 불러오기
	@PostMapping("getclass")
	public JsonResult getSelectClass(@RequestBody Map<Object, String> tempVo) {
		System.out.println("SolController.getClass()");
		System.out.println(tempVo);
		return null;
	}
	
	
	
	
	
}
