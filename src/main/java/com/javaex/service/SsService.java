package com.javaex.service;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.SsDao;
import com.javaex.vo.CouponVo;
import com.javaex.vo.MyPayVo;
import com.javaex.vo.OneClassVo;
import com.javaex.vo.ReviewVo;
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
	
	// 리뷰 작성
	public int exeInsertReview(int userNo,ReviewVo vo) {
		vo.setUserNo(userNo);
		
		// 파일처리
		MultipartFile file = vo.getFile();
		
		String osName = System.getProperty("os.name").toLowerCase();
		String saveDir;
		
		if (osName.contains("linux")) { 
			saveDir = "/app/upload";
		} else {
			saveDir = "C:\\uploadImages\\";
		}
		
		String orgName = file.getOriginalFilename();
		String exName = orgName.substring(orgName.lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		String filePath = saveDir + File.separator + saveName;
		vo.setReviewImage(saveName);
		
		try {
			byte[] fileData;
			fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		int count = ssDao.insertReview(vo);
		
		if(count == 1) {
			return count;
		} else {
			return -1;
		}
		
	}
	
	// 작성한 리뷰 정보 가져오기
	public Map<String,Object> exeGetReview(Map<String, Integer> map) {
		return ssDao.getReview(map);
	}
	
	// 리뷰 수정하기
	public int exeUpdateReview(int userNo, ReviewVo vo) {
		vo.setUserNo(userNo);
		MultipartFile file = vo.getFile();

		if(file != null) {
			String osName = System.getProperty("os.name").toLowerCase();
			String saveDir;
			if (osName.contains("linux")) { 
				saveDir = "/app/upload";
			} else {
				saveDir = "C:\\uploadImages\\";
			}
			String orgName = file.getOriginalFilename();
			String exName = orgName.substring(orgName.lastIndexOf("."));
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
			String filePath = saveDir + File.separator + saveName;
			vo.setReviewImage(saveName);
			
			try {
				byte[] fileData;
				fileData = file.getBytes();

				OutputStream os = new FileOutputStream(filePath);
				BufferedOutputStream bos = new BufferedOutputStream(os);

				bos.write(fileData);
				bos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int count = ssDao.updateReview(vo);
			return count;
		} else {
			int count = ssDao.updateReview(vo);
			return count;
		}
		
		
	}
	
	// 출석정보 가져오기
	public Map<String,Object> exeGetAttenList(int userNo, int scheduleNo) {
		OneClassVo vo =  ssDao.getClassOne(scheduleNo);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userNo", userNo);
		map.put("scheduleNo", scheduleNo);
		
		List<Map<String,Object>> list = ssDao.getAttenList(map);
		int attenCount = ssDao.getAttenCount(map);
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("className", vo.getClassName());
		resultMap.put("startDate", vo.getStartDate());
		resultMap.put("endDate",vo.getEndDate());
		resultMap.put("list", list);
		resultMap.put("attenCount", attenCount);
		
		return resultMap;
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
