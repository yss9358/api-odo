package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ChartVo;
import com.javaex.vo.MjVo;
import com.javaex.vo.ListVo;

@Repository
public class MjDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 수정폼
	public Map<String, Object> personMform(int no) {
//		System.out.println("MjDao.personMform");

		Map<String, Object> pMap = sqlSession.selectOne("Mj.selectOne", no);

		return pMap;
	}

	// 수정
	public int personModify(MjVo mjVo) {
//		System.out.println("MjDao.personModify");

		int count = sqlSession.update("Mj.update", mjVo);

		return count;
	}

	// 리스트
	public List<MjVo> mjSelect() {
//		System.out.println("MjDao.mjSelect");

		List<MjVo> MjList = sqlSession.selectList("Mj.selectlist");

		return MjList;
	}

	// 읽기
	public MjVo selectOne(int no) {
//		System.out.println("MjDao.selectOneNotice()");

		MjVo MjVo = sqlSession.selectOne("Mj.selectOneNO", no);

		return MjVo;
	}
	
	public void getPagesNo(MjVo mjVo) {
		sqlSession.update("Mj.Pagesupdate", mjVo);
		
	}

	// 등록
	public int insert(MjVo mjVo) {
//		System.out.println("MjDao.insert");

		int count = sqlSession.insert("Mj.insert", mjVo);

		return count;
	}
	
	public MjVo getName(MjVo mjVo) {
		MjVo name = sqlSession.selectOne("Mj.getName", mjVo);
		
		return name;
	}

	// 삭제
	public int delete(int no) {
//		System.out.println(no);

		int count = sqlSession.delete("Mj.delete", no);

		return count;

	}

	// 통계
	public ChartVo chart1(int no) {

		ChartVo c = new ChartVo(0, 0, 0, 0);
		ChartVo h;
//		System.out.println(no);
		if (sqlSession.selectOne("Mj.chart", no) == null) {
			h = c;
		} else {
			h = sqlSession.selectOne("Mj.chart", no);
		}

		//System.out.println(h);

		return h;

	}

	public ChartVo chart2(int no) {

		ChartVo c = new ChartVo(0, 0, 0, 0);
		ChartVo h;

		if (sqlSession.selectOne("Mj.chart2",no) == null) {
			h = c;
		} else {
			h = sqlSession.selectOne("Mj.chart2", no);
		}

		//System.out.println(h);

		return h;

	}

	public ChartVo chart3(int no) {

		ChartVo c = new ChartVo(0, 0, 0, 0);
		ChartVo h;

		if (sqlSession.selectOne("Mj.chart3", no) == null) {
			h = c;
		} else {
			h = sqlSession.selectOne("Mj.chart3", no);
		}

		//System.out.println(h);

		return h;

	}
	public ChartVo chart4(int no) {

		ChartVo c = new ChartVo(0, 0, 0, 0);
		ChartVo h;

		if (sqlSession.selectOne("Mj.chart4", no) == null) {
			h = c;
		} else {
			h = sqlSession.selectOne("Mj.chart4", no);
		}

		//System.out.println(h);

		return h;

	}
	
	public List<ListVo> list(int no) {
		
		List<ListVo> list = sqlSession.selectList("Mj.list", no);
		
		//System.out.println(list);
		
		return list;
	}
	
	public List<ListVo> list1(int no) {
		List<ListVo> list1 = sqlSession.selectList("Mj.list1", no);
		
		//System.out.println(list1);
		
		return list1;
	}
	
}
