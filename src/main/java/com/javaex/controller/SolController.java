package com.javaex.controller;

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
import com.javaex.vo.SolVo;

@RestController
@RequestMapping("odo/company")
public class SolController {
	
	@Autowired
	private SolService solservice;

	@PostMapping("join")
	public JsonResult companyJoin(@ModelAttribute SolVo solVo) {
		System.out.println("SolController.companyJoin()");
		String saveName = solservice.exeCompanyImg(solVo.getCompanyFile());
		
		return null;
	}
	
	@GetMapping("id")
	public JsonResult companyId(@RequestParam(value="companyId") String id) {
		System.out.println("SolController.companyId()");
		if(solservice.exeId(id) == null) {
			return JsonResult.success(id);
		} else {
			return JsonResult.fail("등록된 아이디 있음");
		}
	}
	
}
