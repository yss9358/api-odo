package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.HsVo;

@Repository
public class HsDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//
	public List<HsVo> selectCate1List(int no) {
		
		List<HsVo> cate1List = sqlSession.selectList("hs.selectCate1List", no);
		
		return cate1List;
	}
	
	//무료베스트클래스 리스트
	public List<HsVo> selectFreeBestList() {
		
		List<HsVo> fbList = sqlSession.selectList("hs.selectFreeBestList");
		
		return fbList;
	}

	//유료베스트클래스 리스트
	public List<HsVo> selectPayBestList() {
		
		List<HsVo> pbList = sqlSession.selectList("hs.selectPayBestList");
		
		return pbList;
	}
	
	//신규베스트클래스 리스트
	public List<HsVo> selectNewBestList() {
		
		List<HsVo> nList = sqlSession.selectList("hs.selectNewList");
		
		return nList;
	}
	
}