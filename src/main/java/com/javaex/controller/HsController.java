package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.HsService;
import com.javaex.util.JsonResult;
import com.javaex.vo.HsVo;

@RestController
public class HsController {

	@Autowired
	private HsService hsService;

	// 메인 페이지 리스트
	@GetMapping("odo/mains")
	public JsonResult getList() {
		System.out.println("HsController.getList()");

		List<List<HsVo>> listOfLists = hsService.exegetList();

		return JsonResult.success(listOfLists);
	}

}