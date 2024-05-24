package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.WishClassVo;
import com.javaex.vo.WishCompanyVo;

@Repository
public class JhDao {

	@Autowired
	SqlSession sqlSession;
	
	//클래스 위시리스트 가져오기
	public List<WishClassVo> wishClass() {
		
		List<WishClassVo> wishClass = sqlSession.selectList("jh.wishclass");
		
		return wishClass;
	}
	
	//업체 위시리스트 이름, 이미지, 번호 가져오기
	public List<WishCompanyVo> wishCompany() {
		List<WishCompanyVo> wishCompany =  sqlSession.selectList("jh.wishcompany1");
		
		return wishCompany;
	}
	
	//업체 클래스 수 가져오기
	public int classCount(int no) {
		
		return sqlSession.selectOne("jh.classCount", no);
	}
	
	//업체 리뷰 수 가져오기
	public int reviewCount(int no) {
		
		return sqlSession.selectOne("jh.reviewCount", no);
	}
	
	//업체 위시 수 가져오기
	public int wishCount(int no) {
		
		return sqlSession.selectOne("jh.wishCount", no);
	}
}
