package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<WishClassVo> wishClass(int no) {
		
		List<WishClassVo> wishClass = sqlSession.selectList("jh.wishclass", no);
		System.out.println(wishClass);
		return wishClass;
	}
	
	//클래스 위시 제거하기
	public int delwish(int a) {
		
		return sqlSession.delete("jh.delwish", a);
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
