package com.javaex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.HsDao;
import com.javaex.vo.HsVo;

@Service
public class HsService {

	@Autowired
	private HsDao hsDao;
	
	
	//
	public List<HsVo> execate1List(int no) {
		System.out.println("hsDao.execate1List()");
		
		List<HsVo> cate1List = hsDao.selectCate1List(no);
		
		return cate1List;
	}
	
	//메인페이지 리스트
	public List<List<HsVo>> exegetList() {
		
		//무료 베스트 클래스 리스트
		List<HsVo> fbList = hsDao.selectFreeBestList();
		
		//유료 베스트 클래스 리스트
		List<HsVo> pbList = hsDao.selectPayBestList();
		
		//신규 베스트 클래스 리스트
		List<HsVo> nList = hsDao.selectNewBestList();
		
		//리스트의 리스트 생성
		List<List<HsVo>> listOfLists = new ArrayList<>();
		//listOfLists.add(무료베스트클래스리스트)
		listOfLists.add(fbList);
		//listOfLists.add(유료베스트클래스리스트)
		listOfLists.add(pbList);
		//listOfLists.add(신규베스트클래스리스트)
		listOfLists.add(nList);
		
		return listOfLists;
	}
}
