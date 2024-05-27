package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/odo/mypage/modify/{no}")
	public Map<String, Object> modifyform(@PathVariable(value="no")int no) {
		System.out.println("MjController.modifyform");
		
		Map<String, Object> pMap = mjService.exeMform(no);
		
		return pMap;
	}
	
	//수정
	@PostMapping("/odo/mypage/modify")
	public int modify(@RequestBody MjVo mjVo) {
		System.out.println("MjController.modify");
		
		int count = 0; 
				
		try {
			//1. 먼저 select해서 기존 데이터 체크함
			//2. 데이터 없으면 에러처리
			//3. 데이터 있으면 기존로직 수행
			
			count = mjService.exeModify(mjVo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return count;
	}

}