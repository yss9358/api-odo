package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.HsService;
import com.javaex.util.JsonResult;
import com.javaex.vo.HsVo;

@RestController
public class HsController {

	@Autowired
	private HsService hsService;
	
	//카테고리 검색 리스트
	@GetMapping("odo/categories")
	public JsonResult getcateList(@RequestParam(value="cate1No") int no) {
		System.out.println("HsController.getcateList()");
		
		List<HsVo> cate1List = hsService.execate1List(no);
		System.out.println(cate1List);
		
		return JsonResult.success(cate1List);
	}

	// 메인 페이지 리스트
	@GetMapping("odo/mains")
	public JsonResult getList() {

		List<List<HsVo>> listOfLists = hsService.exegetList();

		return JsonResult.success(listOfLists);
	}

}