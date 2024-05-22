package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MjDao;
import com.javaex.vo.MjVo;

@Service
public class MjService {
	
	//필드
	@Autowired
	private MjDao mjDao;
	
	//전체 리스트
	public List<MjVo> exeList(){
		System.out.println("MjService.exeList");
		
		List<MjVo> MjList = mjDao.selectList();
		
		return MjList;
	}
	
	//등록
	public int exeWrite(MjVo mjVo){
		System.out.println("MjService.exeWrite");
		
		int count = mjDao.personInsert(mjVo);
		
		return count;
	}
	
	//삭제
	public int exeDelete(int no) {
		System.out.println("MjService.exeDelete");
		
		int count = mjDao.personDelete(no);
		
		return count;
	}
	
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
	
}
