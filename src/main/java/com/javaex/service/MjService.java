package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaex.dao.MjDao;
import com.javaex.vo.MjVo;

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

}
