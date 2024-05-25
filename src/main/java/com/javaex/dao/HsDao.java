package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.HsVo;

@Repository
public class HsDao {

	@Autowired
	private SqlSession sqlSession;

	// 글 전체 갯수
	public int selectTotalCnt(int no) {

		int totalCount = sqlSession.selectOne("hs.selectTotalCnt", no);

		return totalCount;
	}

	// 2차 카테고리 리스트
	public List<HsVo> selectCate2List(int no) {

		List<HsVo> cate2List = sqlSession.selectList("hs.selectCate2List", no);

		return cate2List;
	}//

	// 1차 카테고리 리스트
	public List<HsVo> selectCate1List(Map<String, Integer> limitMap) {

		List<HsVo> cate1List = sqlSession.selectList("hs.selectCate1List", limitMap);

		return cate1List;
	}//

	// 무료베스트클래스 리스트
	public List<HsVo> selectFreeBestList() {

		List<HsVo> fbList = sqlSession.selectList("hs.selectFreeBestList");

		return fbList;
	}//

	// 유료베스트클래스 리스트
	public List<HsVo> selectPayBestList() {

		List<HsVo> pbList = sqlSession.selectList("hs.selectPayBestList");

		return pbList;
	}//

	// 신규베스트클래스 리스트
	public List<HsVo> selectNewBestList() {

		List<HsVo> nList = sqlSession.selectList("hs.selectNewList");

		return nList;
	}//

}