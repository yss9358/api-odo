package com.javaex.service;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaex.dao.SsDao;
import com.javaex.util.KakaoToken;
import com.javaex.vo.CheckWishClassVo;
import com.javaex.vo.ClassReviewVo;
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
	public List<MyPayVo> exePayList(int classType, int userNo, int page) {		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("classType", classType);
		map.put("userNo", userNo);
		
		page = (page>0) ? page : (page=1);
		int listCount = 7;
		int startRowNo = (page-1)*listCount;
		
		map.put("startRowNo", startRowNo);
		map.put("listCount", listCount);
		
		List<MyPayVo> list = ssDao.getPayListByNo(map);
		if(list == null) {
			return null;
		} else {
			return list;
		}
	}
	
	// 리뷰쓸때 클래스정보 가져오기
	public OneClassVo exeGetClassOne(int no) {
		return ssDao.getClassOne(no);
	}
	
	// 리뷰 작성
	public int exeInsertReview(int userNo,ReviewVo vo) {
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
			
			int count = ssDao.insertReview(vo);
			return count;
		} else {
			int count = ssDao.insertReview(vo);
			return count;
		}
	}
	
	// 작성한 리뷰 정보 가져오기
	public Map<String,Object> exeGetReview(int userNo, int reviewNo) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userNo", userNo);
		map.put("reviewNo", reviewNo);
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
	
	// 리뷰페이지 - 클래스 리뷰 가져오기
	public List<ClassReviewVo> exeGetClassReviewList(int classNo, int type, int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("classNo", classNo);
		map.put("type", type);
		
		page = (page>0) ? page : (page=1);
		int listCount = 7;
		int startRowNo = (page-1)*listCount;
		map.put("startRowNo", startRowNo);
		map.put("listCount", listCount);
		
		List<ClassReviewVo> list = ssDao.getClassReviewList(map);
		if(list == null) {
			return null;
		} else {
			return list;
		}
	}
	
	// 리뷰페이지 - 클래스 정보 가져오기
	public Map<String,Object> exeClassInfo(int classNo) {
		return ssDao.getClassInfo(classNo);
	}
	
	// 위시 클래스 추가
	public int exeInsertWishClass(CheckWishClassVo vo) {
		return ssDao.insertWishClass(vo);
	}
	
	// 위시 클래스 삭제
	public int exeDeleteWishClass(CheckWishClassVo vo) {
		return ssDao.deleteWishClass(vo);
	}
	
	
	
	
	
	
	// 카카오 로그인 토큰 가져오기 
	public String requestToken(String code) {
		
//		https://henniee.tistory.com/221
		System.out.println(code);
//		
		String accessToken = "";
		String refreshToken = "";
//		
		String strUrl = "https://kauth.kakao.com/oauth/token";
		KakaoToken kakaoToken = new KakaoToken();
		
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("post");
			conn.setDoOutput(true);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=4946b7c22ba5fb9b866b344e8f2f4224");
			sb.append("&redirect_uri=http://localhost:8080/login/user");
			sb.append("&code="+code);
			sb.append("&client_secret=377Ja2giI9wqMcjpTmUwNlhKIoNgX7bV");
			
			bw.write(sb.toString());
			bw.flush();
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode(200이면성공):{}"+ responseCode);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			
			while((line = br.readLine()) != null) {
				result += line;
			}
			
			System.out.println("response body : {}"+result);
			
			ObjectMapper mapper  = new ObjectMapper();
			
			kakaoToken = mapper.readValue(result, KakaoToken.class);
			System.out.println("kakaoToken : " + kakaoToken);
			
			accessToken = kakaoToken.getAccessToken();
			refreshToken = kakaoToken.getRefreshToken();
			
			System.out.println("액세스토큰 : "+accessToken);
			System.out.println("리프레시토큰 : "+refreshToken);
			
			br.close();
			bw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("카카오토큰생성완료");
		return accessToken;
		
	}
	
	
}
