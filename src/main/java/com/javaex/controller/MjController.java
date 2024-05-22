package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaex.service.MjService;
import com.javaex.vo.MjVo;

public class MjController {
	
	//필드
	@Autowired
	private MjService mjService;
	
	//전체 리스트 불러오기
	public List<MjVo> list(){
		System.out.println("MjController.list");
		
		List<MjVo> MjList = mjService.exeList();
		
		return MjList;
	}
	
	

}
