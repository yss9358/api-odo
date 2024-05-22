package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.MjService;
import com.javaex.vo.MjVo;

@RestController
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
	
	//등록
	public int wirte(@RequestBody MjVo MjVo) {
		System.out.println("MjController.write");
		
		int count = mjService.exeWrite(MjVo);
		
		return count;
	}
	
	//삭제
	public int delete(@RequestParam(value="personId")int no) {
		System.out.println("MjController.delete");
		
		int count = mjService.exeDelete(no);
		
		return count;
	}
	
	//수정폼
	public Map<String, Object> modifyform(@PathVariable(value="no")int no) {
		System.out.println("MjController.modifyform");
		
		Map<String, Object> pMap = mjService.exeMform(no);
		
		return pMap;
	}
	
	//수정
	public int modify(@RequestBody MjVo mjVo) {
		System.out.println("MjController.modify");
		
		int count = mjService.exeModify(mjVo);
		
		return count;
	}

}