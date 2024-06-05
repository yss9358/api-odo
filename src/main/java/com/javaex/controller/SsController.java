package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SsService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.CheckWishClassVo;
import com.javaex.vo.ClassReviewVo;
import com.javaex.vo.CouponVo;
import com.javaex.vo.MyPayVo;
import com.javaex.vo.OneClassVo;
import com.javaex.vo.ReviewVo;
import com.javaex.vo.UserJoinVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class SsController {
	
	@Autowired
	private SsService ssService;
	
//	KakaoAPI kakaoApi = new KaKaoAPI();
	
	// 아이디 중복확인
	@GetMapping("/odo/ss/checkid")
	public JsonResult checkId(@RequestParam(value="id") String id) {
		int count = ssService.exeCheckId(id);
		return JsonResult.success(count);
	}
	
	// 일반회원 회원가입
	@PostMapping("/odo/ss/userjoin")
	public JsonResult userJoin(@RequestBody UserJoinVo vo) {
		int count = ssService.exeJoin(vo);
		return JsonResult.success(count);
	}
	
	// 일반회원 로그인
	@PostMapping("/odo/ss/userlogin")
	public JsonResult userLogin(@RequestBody UserJoinVo vo, HttpServletResponse response) {
		UserJoinVo authVo = ssService.exeLogin(vo);
		if(authVo != null) {
			JwtUtil.createTokenAndSetHeader(response, ""+authVo.getUserNo());
			return JsonResult.success(authVo);
		} else {
			return JsonResult.fail("아이디와 비밀번호를 확인하세요.");
		}
	}
	
	// 회원 결제내역 가져오기
	@GetMapping("/odo/ss/getpaylist")
	public JsonResult getPayList(
			@RequestParam(value="classType") int classType, 
			HttpServletRequest request,
			@RequestParam(value="page", required = false, defaultValue="1") int page
			) {
		
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			List<MyPayVo> list = ssService.exePayList(classType,userNo,page);
			if(list != null) {
				return JsonResult.success(list);
			} else {
				return JsonResult.fail("더 이상 불러올 리스트가 없습니다.");
			}
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 리뷰쓸때 클래스정보 가져오기
	@GetMapping("/odo/ss/getclassone")
	public JsonResult getClassOne(@RequestParam(value="scheduleNo") int scheduleNo) {
		OneClassVo vo = ssService.exeGetClassOne(scheduleNo);
		return JsonResult.success(vo);
	}
	
	// 리뷰 작성
	@PostMapping("/odo/ss/reviews")
	public JsonResult writeReveiw(HttpServletRequest request,@ModelAttribute ReviewVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			int count = ssService.exeInsertReview(userNo,vo);
			return JsonResult.success(count);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 작성한 리뷰 정보 가져오기
	@GetMapping("/odo/ss/reviews")
	public JsonResult getReview(	
			@RequestParam(value="reviewNo") int reviewNo,
			HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			Map<String, Object> resultMap = ssService.exeGetReview(userNo, reviewNo);
			return JsonResult.success(resultMap);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 리뷰 수정하기
	@PutMapping("/odo/ss/reviews")
	public JsonResult modifyReview(HttpServletRequest request,@ModelAttribute ReviewVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			int count = ssService.exeUpdateReview(userNo,vo);
			return JsonResult.success(count);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 출석정보 가져오기
	@GetMapping("/odo/ss/attenlist")
	public JsonResult attenList(@RequestParam(value="scheduleNo") int scheduleNo, HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			Map<String,Object> map = ssService.exeGetAttenList(userNo,scheduleNo);
			return JsonResult.success(map);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 쿠폰정보 가져오기
	@GetMapping("/odo/ss/usercoupon")
	public JsonResult couponList(HttpServletRequest request) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			List<CouponVo> list = ssService.exeCheckCoupon(userNo);
			return JsonResult.success(list);
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 리뷰페이지 - 클래스 리뷰 가져오기
	@GetMapping("/odo/ss/classreviewlist")
	public JsonResult classReview(
			@RequestParam(value="classNo") int classNo,
			@RequestParam(value="type") int type,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		List<ClassReviewVo> list = ssService.exeGetClassReviewList(classNo,type,page);
		if(list != null) {
			return JsonResult.success(list); 
		} else {
			return JsonResult.fail("더 이상 불러올 리스트가 없습니다.");
		}
	}
	
	// 리뷰페이지 - 클래스 정보 가져오기
	@GetMapping("/odo/ss/classinfo")
	public JsonResult classInfo(@RequestParam(value="classNo") int classNo) {
		Map<String,Object> map = ssService.exeClassInfo(classNo);
		return JsonResult.success(map);
	}
	
	// 위시 클래스 추가
	@PostMapping("/odo/ss/wishclassis")
	public JsonResult addWishClass(HttpServletRequest request, @ModelAttribute CheckWishClassVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			vo.setUserNo(userNo);
			int count = ssService.exeInsertWishClass(vo);
			if(count == 1) {
				return JsonResult.success(vo.getwClassNo());
			} else {
				return JsonResult.fail("등록실패");
			}
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 위시 클래스 삭제
	@DeleteMapping("/odo/ss/wishclassis")
	public JsonResult deleteWishClass(HttpServletRequest request, @ModelAttribute CheckWishClassVo vo) {
		int userNo = JwtUtil.getNoFromHeader(request);
		if(userNo != -1) {
			vo.setUserNo(userNo);
			int count = ssService.exeDeleteWishClass(vo);
			if(count == 1) {
				return JsonResult.success(count);
			} else {
				return JsonResult.fail("삭제실패");
			}
		} else {
			return JsonResult.fail("다시 로그인 해주세요.");
		}
	}
	
	// 카카오 로그인 회원 체크
	@PostMapping("/odo/ss/kakaocheck")
	public JsonResult emailCheck(@RequestBody UserJoinVo vo,HttpServletResponse response) {
		UserJoinVo authVo = ssService.exeCheckKakaoEmail(vo);
		if(authVo != null) {
			JwtUtil.createTokenAndSetHeader(response, ""+authVo.getUserNo());
			return JsonResult.success(authVo);
		} else {
			return null;
		}
	}

//	// 네이버 토큰 받기
//	@GetMapping("/odo/ss/navertoken")
//	public JsonResult naverToken(@RequestParam(value="code") String code, @RequestParam(value="state") String state,HttpServletResponse response) {
//		Map<String, Object> map = getNaverToken(code, state);
//		HashMap<String, String> resultMap = requestUser(map,state);
//		Map<String,Object> authMap =ssService.exeCheckNaverEmail(resultMap);
//		if(authMap != null) {
//			JwtUtil.createTokenAndSetHeader(response, ""+((UserJoinVo)authMap.get("authVo")).getUserNo());
//			return JsonResult.success(authMap);
//		} else {
//			return JsonResult.fail("로그인을 다시하세요.");
//		}
//	}
//	
//	// 네이버 토큰얻기
//	private Map<String, Object> getNaverToken(String code, String state) {
//		String access_token = "";
//		String refresh_token = "";
//		
//		String strUrl = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
//		NaverToken naverToken = new NaverToken();
//		
//		try {
//			URL url = new URL(strUrl);
//			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//			
//			conn.setRequestMethod("POST");
//			conn.setDoOutput(true);
//			
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//			StringBuilder sb = new StringBuilder();
//			sb.append("&client_id=G0qt69ejziDW7itLBej_");
//			sb.append("&client_secret=oy3OZnEUm0");
//			sb.append("&redirect_uri=http://localhost:8080/naverlogin");
//			sb.append("&code="+code);
//			sb.append("&state="+state);
//			bw.write(sb.toString());
//			bw.flush();
//			
//			conn.getResponseCode();
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String line = "";
//			String result = "";
//			
//			while((line = br.readLine()) != null) {
//				result += line;
//			}
//			
//			ObjectMapper mapper = new ObjectMapper();
//			
//			naverToken = mapper.readValue(result, NaverToken.class);
//			
//			access_token = naverToken.getAccess_token();
//			refresh_token = naverToken.getRefresh_token();
//			br.close();
//			bw.close();
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("refresh_token", refresh_token);
//		map.put("access_token", access_token);
//		return map;
//	}
//	
//	// 네이버 유저정보 얻기
//	private HashMap<String,String> requestUser(Map<String,Object> map, String state) {
//		
//		String strUrl = "https://openapi.naver.com/v1/nid/me";
//		String accessToken = (String)map.get("access_token");
//		String refreshToken = (String)map.get("refresh_token");
//		
//		HashMap<String, String> userInfo = new HashMap<String,String>();
//		userInfo.put("accessToken", accessToken);
//		userInfo.put("refreshToken", refreshToken);
//		userInfo.put("state", state);
//		
//		try {
//			URL url = new URL(strUrl);
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			
//			conn.setRequestMethod("POST");
//			conn.setDoOutput(true);
//			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
//			
//			int responseCode = conn.getResponseCode();
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(responseCode == 200 ? conn.getInputStream() : conn.getErrorStream()));
//			String line = "";
//			String result = "";
//			while((line = br.readLine()) != null) {
//				result += line;
//			}
//			br.close();
//			
//			if(responseCode == 200) {
//				ObjectMapper mapper = new ObjectMapper();
//				HashMap<String, Object> resultMap = mapper.readValue(result, HashMap.class);
//				HashMap<String, Object> response = (HashMap<String,Object>)resultMap.get("response");
//				
//				String id = (String)response.get("id");
//				String nickname = (String) response.get("nickname");
//				String email = (String)response.get("email");
//				String birthyear = (String)response.get("birthyear");
//				String birthday = (String)response.get("birthday");
//				String gender = (String)response.get("gender");
//				String name = (String)response.get("name");
//				String phone_number = (String)response.get("mobile");
//				
//				userInfo.put("email", email);
//				userInfo.put("id", id);
//				userInfo.put("nickname", nickname);
//				userInfo.put("birthyear", birthyear);
//				userInfo.put("birthday",birthday);
//				userInfo.put("name", name);
//				userInfo.put("gender", gender);
//				userInfo.put("phone_number", phone_number);
//			} else {
//				System.out.println("Failed to get user info : {}" + result);
//			}
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return userInfo;
//	}
	
}


