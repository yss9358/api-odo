package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.MjService;
import com.javaex.vo.MjVo;

@RestController
public class MjController {
	
	//필드
	@Autowired
	private MjService mjService;
	
	//수정폼
	@GetMapping("/odo/{no}")
	public Map<String, Object> modifyform(@PathVariable(value="no")int no) {
		System.out.println("MjController.modifyform");
		
		Map<String, Object> pMap = mjService.exeMform(no);
		
		return pMap;
	}
	
	//수정
	@PutMapping("/odo/modify")
	public int modify(@RequestBody MjVo mjVo) {
		System.out.println("MjController.modify");
		
		int count = mjService.exeModify(mjVo);
		
		return count;
	}

}