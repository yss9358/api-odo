package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ClassDetailVo;
import com.javaex.vo.HsVo;

@Repository
public class HsDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	//도로명주소 가져오기
	public String selectNameAdd(int no) {
		
		String nameAdd = sqlSession.selectOne("hs.selectNameAdd", no);
		
		return nameAdd;
	}
	
	//해당클래스 총 후기 수
	public int selectClassReviewCnt(int no) {
		
		int classReviewCnt = sqlSession.selectOne("hs.selectClassReviwCnt", no);

		return classReviewCnt;
	}
	
	//해당클래스 후기 리스트
	public List<ClassDetailVo> selectClassReviewList(int no) {
		
		List<ClassDetailVo> classReviewList = sqlSession.selectList("hs.selectClassReviewList", no);
		
		return classReviewList;
	}
	
	//해당클래스 운영회사 찜 수
	public int selectComWishCnt(int no) {
		
		int comWishCnt = sqlSession.selectOne("hs.selectComWishCnt", no);

		return comWishCnt;
	}
	
	//해당클래스 운영회사 후기 수
	public int selectComReviewCnt(int no) {
		
		int comReviewCnt = sqlSession.selectOne("hs.selectComReviewCnt", no);

		return comReviewCnt;
	}
	
	//해당클래스 운영회사 클래스 수
	public int selectComClassCnt(int no) {

		int comClassCnt = sqlSession.selectOne("hs.selectComClassCnt", no);
		
		return comClassCnt;
	}
	
	//해당클래스 운영회사 정보
	public ClassDetailVo selectComInfo(int no) {
		
		ClassDetailVo companyInfo = sqlSession.selectOne("hs.selectComInfo", no);
		
		return companyInfo;
	}
	
	//클래스 스케줄 리스트
	public List<ClassDetailVo> selectScheduleList(int no) {
		
		List<ClassDetailVo> schList = sqlSession.selectList("hs.selectScheduleList", no);
		
		return schList;
	}
	
	//클래스 정보
	public ClassDetailVo selectClassDetail(int no) {
		
		ClassDetailVo classDetailVo = sqlSession.selectOne("hs.selectClassDetail", no);
		
		
		return classDetailVo;
	}

	// 글 전체 갯수2
	public int selectTotalCnt2(int no) {

		int totalCount = sqlSession.selectOne("hs.selectTotalCnt2", no);

		return totalCount;
	}

	// 글 전체 갯수
	public int selectTotalCnt(int no) {

		int totalCount = sqlSession.selectOne("hs.selectTotalCnt", no);

		return totalCount;
	}

	// 2차 카테고리 리스트
	public List<HsVo> selectCate2List(Map<String, Integer> limitMap) {

		List<HsVo> cate2List = sqlSession.selectList("hs.selectCate2List", limitMap);

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