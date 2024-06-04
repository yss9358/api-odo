package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MjDao;
import com.javaex.vo.ChartVo;
import com.javaex.vo.ListVo;
import com.javaex.vo.MjVo;

@Service
public class MjService {

	// 필드
	@Autowired
	private MjDao mjDao;

	// 수정폼
	public Map<String, Object> exeMform(int no) {

		Map<String, Object> pMap = mjDao.personMform(no);

		return pMap;
	}

	// 수정
	public int exeModify(MjVo mjVo) {
//		System.out.println("MjService.exeModify");

		int count = mjDao.personModify(mjVo);

		return count;
	}

	// 리스트
	public List<MjVo> exeList() {
//		System.out.println("MjService.exeList");

		List<MjVo> MjList = mjDao.mjSelect();

		return MjList;
	}

	// 읽기
	public MjVo exeRead(int no) {
//		System.out.println("MjService.exeRead");

		MjVo MjVo = mjDao.selectOne(no);
//		System.out.println(MjVo.getPagesNo());

		int count = MjVo.getPagesNo();
		count = count + 1;
//		System.out.println(count);

		MjVo.setPagesNo(count);
//		MjVo.setIdx(no);
		System.out.println(MjVo);
		mjDao.getPagesNo(MjVo);

		return MjVo;
	}

	// 등록
	public int exeWrite(MjVo mjVo) {
//		System.out.println("MjService.exeWrite");

		MjVo name = mjDao.getName(mjVo);

		mjVo.setName(name.getName());

		int count = mjDao.insert(mjVo);

		return count;
	}

	// 삭제
	public int exeDelete(int no) {
//			System.out.println("MjService.exeDelete()");

		return mjDao.delete(no);
	}

	// 통계
	public Map<String, Object> exechart(int no) {

		ChartVo c1 = mjDao.chart1(no);// 이번달 원데이

		ChartVo c2 = mjDao.chart2(no);// 지난달 원데이

		ChartVo c3 = mjDao.chart3(no);// 이번달 정규상시

		ChartVo c4 = mjDao.chart4(no);// 지난달 정규상시

		ChartVo chart = new ChartVo(c1.getOnedayPrice(), c2.getPreonedayPrice(), c3.getRePrice(), c4.getPreRePrice());

		// System.out.println(chart);

		List<ListVo> list = mjDao.list(no); // 정규상시

		List<ListVo> list1 = mjDao.list1(no); // 원데이

		Map<String, Object> mMap = new HashMap<>();

		mMap.put("chart", chart);
		mMap.put("list", list);
		mMap.put("list1", list1);

		System.out.println(mMap);

		return mMap;
	}

}
