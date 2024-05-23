package com.javaex.service;

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
