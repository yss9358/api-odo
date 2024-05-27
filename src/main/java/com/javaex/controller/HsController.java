package com.javaex.controller;

import java.util.List;
import java.util.Map;

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
	
	
	//검색페이지 - 2차 카테고리 리스트
	@GetMapping("odo/subcategories")
	public JsonResult getsubCateList(@RequestParam(value="cate2No") int no,
			@RequestParam(value="crtPage", required = false, defaultValue = "1") int crtPage) {

		Map<String, Object> pMap = hsService.execate2List(no, crtPage);
		
		return JsonResult.success(pMap);
	}//
	
	//검색페이지 - 1차 카테고리 검색 리스트
	@GetMapping("odo/categories")
	public JsonResult getcateList(@RequestParam(value="cate1No") int no,
			@RequestParam(value="crtPage", required = false, defaultValue = "1") int crtPage) {
		
		Map<String, Object> pMap = hsService.execate1List(no, crtPage);
		
		return JsonResult.success(pMap);
	}//

	// 메인 페이지 - 리스트
	@GetMapping("odo/mains")
	public JsonResult getList() {

		List<List<HsVo>> listOfLists = hsService.exegetList();

		return JsonResult.success(listOfLists);
	}//

}