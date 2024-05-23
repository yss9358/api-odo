package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.JhService;
import com.javaex.util.JsonResult;

@RestController
public class JhController {

	@Autowired
	JhService js;
	
	//유저의 클래스 위시리스트 가져오기
	@GetMapping("/odo/wishclass")
	public JsonResult wishclass() {
		
		return js.wishClass();
	}
	
	//유저의 업체 위시리스트 가져오기
	@GetMapping("/odo/wishcompany")
	public void wishcompany(){
		
		js.wishCompany();
	}
	
	
}
