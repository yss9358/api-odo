package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.MjService;
import com.javaex.util.JwtUtil;
import com.javaex.vo.MjVo;

import jakarta.servlet.http.HttpServletRequest;


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
	
	//리스트
	@GetMapping("/odo/mypage/notice")
	public Map<String, Object> list(HttpServletRequest request, Model model) {
		System.out.println("MjController.list");
		int no = JwtUtil.getNoFromHeader(request);
			
		List<MjVo> MjList = mjService.exeList();
			
		model.addAttribute("list", MjList);
		
		Map<String, Object> Mlist = new HashMap<>();
		
		Mlist.put("no", no);
		Mlist.put("MjList", MjList);
			
		return Mlist;
	}
	
	//읽기
	@GetMapping("/odo/mypage/notice/{no}")
	public Map<String, Object> Read(HttpServletRequest request,@PathVariable("no") int no) {
		int num = JwtUtil.getNoFromHeader(request);
		
		MjVo MjVo = mjService.exeRead(no);
		
		Map<String, Object> Mread = new HashMap<>();
		
		Mread.put("num", num);
		Mread.put("MjVo", MjVo);
		
		return Mread;
	}
	
	//등록폼
	
	
	//등록
	@PostMapping("/odo/mypage/notice/write")
	public String write(HttpServletRequest request, @RequestBody MjVo mjVo) {
//		System.out.println("MjController.write()");
		int num = JwtUtil.getNoFromHeader(request);
		mjVo.setUserno(num);
		System.out.println(mjVo);
		
//		
		int count = mjService.exeWrite(mjVo);
//		
		String result = count + "건 등록 되었습니다.";
//		
		return result;
	}
	
	//삭제
	@DeleteMapping("/odo/mypage/notice/delete/{no}")
	public String delete(@PathVariable("no") int no) {
		System.out.println("MjController.delete");
		
		int count = mjService.exeDelete(no);
		
		String result = count + "건 삭제 되었습니다.";
		
		return result;
	}
	
	//통계리스트
	//public void 
	@GetMapping("/odo/chart")
	public Map<String, Object> chart(HttpServletRequest request) {
		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(no);
		return mjService.exechart(no);
		
		
	}
	

}