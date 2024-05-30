package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MjVo;

@Repository
public class MjDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//수정폼
	public Map<String, Object> personMform(int no){
		System.out.println("MjDao.personMform");
		
		Map<String, Object> pMap = sqlSession.selectOne("Mj.selectOne", no);
		
		return pMap;
	}
	
	//수정
	public int personModify(MjVo mjVo) {
		System.out.println("MjDao.personModify");
		
		int count = sqlSession.update("Mj.update",mjVo);
		
		return count;
	}
	
	//리스트
	public List<MjVo> mjSelect() {
		System.out.println("MjDao.mjSelect");
			
		List<MjVo> MjList = sqlSession.selectList("Mj.select");
			
		return MjList;
	}

}
