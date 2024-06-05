package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.HsService;
import com.javaex.util.JsonResult;
import com.javaex.vo.ClassDetailVo;
import com.javaex.vo.HsVo;

@RestController
public class HsController {

	@Autowired
	private HsService hsService;

	
	// 클래스 위시 삭제
	@DeleteMapping("odo/wishes")
	public JsonResult deleteWish(@RequestBody ClassDetailVo wishVo) {

		int count = hsService.exeDeleteClassWish(wishVo);

		return JsonResult.success(count);
	}

	// 클래스 위시 추가
	@PostMapping("odo/wishes")
	public JsonResult postWish(@RequestBody ClassDetailVo wishVo) {

		int count = hsService.exeInsertClassWish(wishVo);

		return JsonResult.success(count);
	}

	// 클래스 상세페이지 도로명주소
	@GetMapping("odo/classdetails/nameadd")
	public JsonResult getNameAdd(@RequestParam(value = "classNo") int no) {

		String nameAdd = hsService.exeGetNameAdd(no);

		return JsonResult.success(nameAdd);
	}

	///////////////////////////////////////////////////////////////////////

	// 클래스 상세 페이지 정보 - 로그인
	@GetMapping("odo/classdetails/users")
	public JsonResult getUsersClassDetails(@RequestParam(value = "userNo") int userNo,
			@RequestParam(value = "classNo") int no) {

		Map<String, Object> cMap = hsService.exeGetUsersClassDeatils(userNo, no);

		return JsonResult.success(cMap);
	}

	// 클래스 상세 페이지 정보 - 비로그인
	@GetMapping("odo/classdetails")
	public JsonResult getClassDetails(@RequestParam(value = "classNo") int no) {

		Map<String, Object> cMap = hsService.exeGetClassDeatils(no);

		return JsonResult.success(cMap);
	}

	///////////////////////////////////////////////////////////////////////////

	// 검색페이지 - 2차 카테고리 리스트 - 로그인
	@GetMapping("odo/subcategories/users")
	public JsonResult getsubCateUsersList(@RequestParam(value = "userNo") int userNo,
			@RequestParam(value = "cate2No") int no,
			@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {

		Map<String, Object> pMap = hsService.execate2UsersList(userNo, no, crtPage);

		return JsonResult.success(pMap);
	}//

	// 검색페이지 - 2차 카테고리 리스트 - 비로그인
	@GetMapping("odo/subcategories")
	public JsonResult getsubCateList(@RequestParam(value = "cate2No") int no,
			@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {

		Map<String, Object> pMap = hsService.execate2List(no, crtPage);

		return JsonResult.success(pMap);
	}//

	// 검색페이지 - 1차 카테고리 검색 리스트 - 로그인
	@GetMapping("odo/categories/users")
	public JsonResult getCateUsersList(@RequestParam(value = "userNo") int userNo,
			@RequestParam(value = "cate1No") int no,
			@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {

		Map<String, Object> pMap = hsService.execate1UsersList(userNo, no, crtPage);

		return JsonResult.success(pMap);
	}//

	// 검색페이지 - 1차 카테고리 검색 리스트 - 비로그인
	@GetMapping("odo/categories")
	public JsonResult getCateList(@RequestParam(value = "cate1No") int no,
			@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {

		Map<String, Object> pMap = hsService.execate1List(no, crtPage);

		return JsonResult.success(pMap);
	}//

	//////////////////////////////////////////////////////////////////

	// 메인 페이지 - 로그인 시 리스트
	@GetMapping("odo/mains/users")
	public JsonResult getUsersList(@RequestParam(value = "userNo") int no) {

		List<List<HsVo>> usersListOfLists = hsService.exegetUsersList(no);

		return JsonResult.success(usersListOfLists);
	}//

	// 메인 페이지 - 비로그인 리스트
	@GetMapping("odo/mains")
	public JsonResult getList() {

		List<List<HsVo>> listOfLists = hsService.exegetList();

		return JsonResult.success(listOfLists);
	}//

}