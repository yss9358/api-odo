package com.javaex.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.HsDao;
import com.javaex.vo.HsVo;

@Service
public class HsService {

	@Autowired
	private HsDao hsDao;

	// 검색페이지 - 2차 카테고리 리스트
	public Map<String, Object> execate2List(int no, int crtPage) {

		// 한 페이지당 출력 글 갯수
		int listCnt = 8;

		// crtPage
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);

		int startRowNo = (crtPage - 1) * listCnt;

		// startRowNo, listCnt Map으로 묶는다
		Map<String, Integer> limitMap = new HashMap<String, Integer>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("cate2No", no);

		// dao에 전달해서 현재 페이지의 리스트 8개를 받는다
		List<HsVo> cate2List = hsDao.selectCate2List(limitMap);
		
		////////////////////////////////////////////
		// 페이징 계산
		////////////////////////////////////////////

		// 페이지당 버튼 갯수
		int pageBtncount = 5;

		// 전체 글 갯수
		int totalCnt = hsDao.selectTotalCnt2(no);

		// 마지막 버튼 번호
		// 1page- 1, 5
		// 2page- 1, 5 ...
		// 5page- 1, 5
		// 6page- 6, 10 ...
		// 10page-6, 10
		// 11page-11, 15
		int endPageBtnNo = (int) Math.ceil(crtPage / (double) pageBtncount) * pageBtncount;
		// (현재페이지/갯수)*갯수 = 올림(1/5)*5 = 5 -> 0.2올림(1)*5 = 5
		// (현재페이지/갯수)*갯수 = 올림(2/5)*5 = 5 -> 0.4올림(1)*5 = 5 ...
		// (현재페이지/갯수)*갯수 = 올림(6/5)*5 = 5 -> 1.2올림(2)*5 = 10

		// 시작 버튼 번호
		int startPageBtnNo = (endPageBtnNo - pageBtncount) + 1;

		// 다음 화살표 유무
		boolean next = false;
		if (listCnt * endPageBtnNo < totalCnt) { // 한 페이지당 글 갯수(10)*마지막버튼번호(5) < 전체글갯수(187)
			next = true;
		} else { // 다음화살표가 false 일 때 마지막 번호 정확히 계산
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);
		}

		// 이전 화살표 유무
		boolean prev = false;
		if (startPageBtnNo != 1) {
			prev = true;
		}

		// 5개 map으로 묶어서 controller로 보낸다
		Map<String, Object> pMap = new HashMap<String, Object>();

		pMap.put("cate2List", cate2List);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("prev", prev);
		pMap.put("next", next);

		return pMap;
	}//

	// 검색페이지 - 1차 카테고리 리스트
	public Map<String, Object> execate1List(int no, int crtPage) {

		// 한 페이지당 출력 글 갯수
		int listCnt = 8;

		// crtPage
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);

		int startRowNo = (crtPage - 1) * listCnt;

		// startRowNo, listCnt Map으로 묶는다
		Map<String, Integer> limitMap = new HashMap<String, Integer>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("cate1No", no);

		// dao에 전달해서 현재 페이지의 리스트 8개를 받는다
		List<HsVo> cate1List = hsDao.selectCate1List(limitMap);

		////////////////////////////////////////////
		// 페이징 계산
		////////////////////////////////////////////

		// 페이지당 버튼 갯수
		int pageBtncount = 5;

		// 전체 글 갯수
		int totalCnt = hsDao.selectTotalCnt(no);

		// 마지막 버튼 번호
		// 1page- 1, 5
		// 2page- 1, 5 ...
		// 5page- 1, 5
		// 6page- 6, 10 ...
		// 10page-6, 10
		// 11page-11, 15
		int endPageBtnNo = (int) Math.ceil(crtPage / (double) pageBtncount) * pageBtncount;
		// (현재페이지/갯수)*갯수 = 올림(1/5)*5 = 5 -> 0.2올림(1)*5 = 5
		// (현재페이지/갯수)*갯수 = 올림(2/5)*5 = 5 -> 0.4올림(1)*5 = 5 ...
		// (현재페이지/갯수)*갯수 = 올림(6/5)*5 = 5 -> 1.2올림(2)*5 = 10

		// 시작 버튼 번호
		int startPageBtnNo = (endPageBtnNo - pageBtncount) + 1;

		// 다음 화살표 유무
		boolean next = false;
		if (listCnt * endPageBtnNo < totalCnt) { // 한 페이지당 글 갯수(10)*마지막버튼번호(5) < 전체글갯수(187)
			next = true;
		} else { // 다음화살표가 false 일 때 마지막 번호 정확히 계산
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);
		}

		// 이전 화살표 유무
		boolean prev = false;
		if (startPageBtnNo != 1) {
			prev = true;
		}

		// 5개 map으로 묶어서 controller로 보낸다
		Map<String, Object> pMap = new HashMap<String, Object>();

		pMap.put("cate1List", cate1List);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("prev", prev);
		pMap.put("next", next);

		return pMap;
	}//

	// 메인페이지 - 리스트
	public List<List<HsVo>> exegetList() {

		// 무료 베스트 클래스 리스트
		List<HsVo> fbList = hsDao.selectFreeBestList();

		// 유료 베스트 클래스 리스트
		List<HsVo> pbList = hsDao.selectPayBestList();

		// 신규 베스트 클래스 리스트
		List<HsVo> nList = hsDao.selectNewBestList();

		// 리스트의 리스트 생성
		List<List<HsVo>> listOfLists = new ArrayList<>();
		// listOfLists.add(무료베스트클래스리스트)
		listOfLists.add(fbList);
		// listOfLists.add(유료베스트클래스리스트)
		listOfLists.add(pbList);
		// listOfLists.add(신규베스트클래스리스트)
		listOfLists.add(nList);

		return listOfLists;
	}//
}
