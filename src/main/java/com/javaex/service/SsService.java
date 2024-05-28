package com.javaex.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.SsDao;
import com.javaex.vo.CouponVo;
import com.javaex.vo.MyPayVo;
import com.javaex.vo.OneClassVo;
import com.javaex.vo.UserJoinVo;

@Service
public class SsService {
	
	@Autowired
	private SsDao ssDao;

	// 아이디 중복확인
	public int exeCheckId(String id) {
		UserJoinVo vo = ssDao.checkId(id);
		if(vo == null) {
			return 1;
		} else {
			return -1;
		}
	}
	
	// 일반회원 회원가입
	public int exeJoin(UserJoinVo vo) {
		int count = ssDao.insertUser(vo);
		if(count == 1) {
			return count;
		} else {
			return -1;
		}
	}
	
	// 일반회원 로그인
	public UserJoinVo exeLogin(UserJoinVo vo) {
		UserJoinVo authVo = ssDao.loginByIdPw(vo);
		if(authVo != null) {
			return authVo;
		} else {
			return null;
		}
	}
	
	// 회원 결제내역 가져오기 
	public List<MyPayVo> exePayList(Map<String, Integer> map) {		
		if(map.get("classType") == 1) {
//			클래스타입이 1이면 원데이클래스 정보
			List<MyPayVo> list = ssDao.getOneDayPayListByNo(map.get("userNo"));
			if(list == null) {
				return null;
			} else {
				return list;
			}
		} else {
//			클래스타입이 1이 아니면 정규,상시클래스 정보
			List<MyPayVo> list = ssDao.getRegularPayListByNo(map.get("userNo"));
			if(list == null) {
				return null;
			} else {
				return list;
			}
		}
	}
	
	
	// 리뷰쓸때 클래스정보 가져오기
	public OneClassVo exeGetClassOne(int no) {
		return ssDao.getClassOne(no);
	}
	
	
	// 쿠폰정보 가져오기
	public List<CouponVo> exeCheckCoupon (int no) {
		List<CouponVo> list = ssDao.getCouponByNo(no);
		if(list.size() < 1) {
			return null;
		} else {
			return ssDao.getCouponByNo(no);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	// 카카오 로그인 토큰 가져오기 
	public void requestToken(String code) {
		
//		https://henniee.tistory.com/221
//		System.out.println("ser");
		System.out.println(code);
//		
//		String accessToken = "";
//		String refreshToken = "";
//		
//		String strUrl = "https://kauth.kakao.com/oauth/token";
//		KakaoToken kakaoToken = new KakaoToken();
		
		

		
	}
	
	
}
