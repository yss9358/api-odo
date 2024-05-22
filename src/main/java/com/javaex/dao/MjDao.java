package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MjVo;

@Repository
public class MjDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//전체리스트
	public List<MjVo> selectList(){
		System.out.println("MjDao.selectList");
		
		List<MjVo> MjList = sqlSession.selectList("Mj.selectList");
		
		return MjList;
	}
	
	//등록
	public int personInsert(MjVo mjVo) {
		System.out.println("MjDao.personInsert");
		
		int count = sqlSession.insert("Mj.insert", mjVo);
		System.out.println(count);
		
		return count;
	}
	
	//삭제
	public int personDelete(int no) {
		System.out.println("MjDao.PersonDelete");
		
		int count = sqlSession.delete("Mj.delete",no);
		
		return count;
	}

}
