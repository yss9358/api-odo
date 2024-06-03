package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MjDao;
import com.javaex.vo.ChartVo;
import com.javaex.vo.MjVo;

@Service
public class MjService {
	
	//필드
	@Autowired
	private MjDao mjDao;
	
	//수정폼
	public Map<String, Object> exeMform(int no) {
		
		Map<String, Object> pMap = mjDao.personMform(no);
		
		return pMap;
	}
	
	//수정
	public int exeModify(MjVo mjVo) {
		System.out.println("MjService.exeModify");
		
		int count = mjDao.personModify(mjVo);
		
		return count;
	}
	
	//리스트
	public List<MjVo> exeList() {
		System.out.println("MjService.exeList");
			
		List<MjVo> MjList = mjDao.mjSelect();
			
		return MjList;
	}
	
	//읽기
	public MjVo exeRead(int no) {
		System.out.println("MjService.exeRead");
		
		MjVo MjVo = mjDao.selectOne(no);
		System.out.println(MjVo);
		return MjVo;
	}
	
	//등록
	public int exeWrite() {
		System.out.println("MjService.exeWrite");
		
		int count = mjDao.insert();
		
		return count;
	}
	
	//삭제
		public int exeDelete(int no) {
			System.out.println("MjService.exeDelete()");
			
			return mjDao.delete(no);
		}
		
	//통계
	public void exechart() {
		
		ChartVo c1 = mjDao.chart1();//이번달 원데이
		
		ChartVo c2 = mjDao.chart2();//지난달 원데이
		
		ChartVo c3 = mjDao.chart3();//이번달 정규상시
		
		ChartVo c4 = mjDao.chart4();//지난달 원데이
		
		ChartVo chart = new ChartVo(c1.getOnedayPrice(), c2.getPreonedayPrice(), c3.getRePrice(), c4.getPreRePrice());
		
		System.out.println(chart);
		
		mjDao.list(); //정규상시
		
		mjDao.list1(); //원데이
		
	}

	
	
}
