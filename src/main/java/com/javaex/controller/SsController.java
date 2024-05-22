package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SsService;
import com.javaex.vo.UserJoinVo;

@RestController
public class SsController {
	
	@Autowired
	private SsService ssService;
	
	@PostMapping("/odo/ss/test")
	public void checkId(@RequestBody UserJoinVo vo) {
		ssService.exeCheckId(vo.getUserId());
	}
}
