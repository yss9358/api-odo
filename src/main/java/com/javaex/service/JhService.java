package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.JhDao;
import com.javaex.util.JsonResult;
import com.javaex.vo.CompanyInfoVo;
import com.javaex.vo.CompanyInfoVo2;
import com.javaex.vo.PayVo;
import com.javaex.vo.PayendVo;
import com.javaex.vo.PaymentVo;
import com.javaex.vo.ReClassVo;
import com.javaex.vo.SolCompanyVo;
import com.javaex.vo.WishClassVo;
import com.javaex.vo.WishCompanyVo;
import com.javaex.vo.WishCompanyVo2;

@Service
public class JhService {

	@Autowired
	JhDao jd;

	// 클래스 위시리스트 가져오기
	public JsonResult wishClass(int no) {

		List<WishClassVo> wishClass = jd.wishClass(no);
		if (wishClass != null) {
			return JsonResult.success(wishClass);
		} else {
			return JsonResult.fail("위시클래스가 없습니다");
		}
	}

	// 클래스 위시 제거하기
	public JsonResult delWish(int a) {

		int b = jd.delWish(a);

		if (b == 1) {
			return JsonResult.success(b);
		} else {
			return JsonResult.fail("삭제를 실패했습니다");
		}
	}

	// 업체 위시리스트 가져오기
	public JsonResult wishCompany(int no) {

		// 업체이미지, 이름, 업체 번호 가져오기
		List<WishCompanyVo> wishCompany = jd.wishCompany(no);

		List<WishCompanyVo2> wishCompany2 = new ArrayList<>();

		// 업체 번호로 업체의 클래스, 리뷰, 위시 수 가져오기
		for (int i = 0; i < wishCompany.size(); i++) {

			String companyImage = wishCompany.get(i).getCompanyImage();

			String companyName = wishCompany.get(i).getCompanyName();

			int companyNo = wishCompany.get(i).getCompanyNo();

			int no2 = wishCompany.get(i).getNo();

			int classCount = jd.classCount(no);

			int reviewCount = jd.reviewCount(no);

			int wishCount = jd.wishCount(no);

			WishCompanyVo2 wVo = new WishCompanyVo2(companyImage, companyName, companyNo, no2, classCount, reviewCount,
					wishCount);

			wishCompany2.add(wVo);
		}
		if (wishCompany2 != null) {
			return JsonResult.success(wishCompany2);
		} else {
			return JsonResult.fail("위시업체가 없습니다");
		}
	}

	// 업체 위시리스트 제거
	public JsonResult delWishCompany(int a) {

		int b = jd.delWishCompany(a);

		if (b == 1) {
			return JsonResult.success(b);
		} else {
			return JsonResult.fail("삭제를 실패했습니다");
		}
	}

	// 결제페이지
	public Map<String, Object> paymentPage(int a, int no) {

		PaymentVo pv = jd.paymentPage(a);

		int b = pv.getCompanyNo();

		Map<String, Integer> Map = new HashMap<>();

		Map.put("b", b);
		Map.put("no", no);

		List<Integer> couponList = jd.paymentPage2(Map);

		Map<String, Object> payment = new HashMap<>();
		payment.put("pv", pv);
		payment.put("couponList", couponList);
		System.out.println(pv);

		return payment;
	}

	// 결제
	public JsonResult pay(PayVo pv) {
		int a = jd.pay(pv);

		System.out.println(pv.getCouponNo());

		if (pv.getCouponNo() == 0) {
			if (a > 0) {
				int c = pv.getPay_no();
				return JsonResult.success(c);
			} else {
				return JsonResult.fail("실패");
			}
		} else {
			int b = jd.useCoupon(pv.getCouponNo());
			if (a > 0 && b > 0) {
				int c = pv.getPay_no();
				return JsonResult.success(c);
			} else {
				return JsonResult.fail("실패");
			}
		}

		/*
		 * int b = jd.useCoupon(pv.getCouponNo()); if(a > 0 && b > 0) { int c =
		 * pv.getPay_no(); return JsonResult.success(c); }else { return
		 * JsonResult.fail("실패"); }
		 */
	}

	// 결제완료페이지
	public Map<String, Object> payend(int a) {

		// 가져오기 1번
		PayendVo pv = jd.payend(a);

		// 할인금액 가져오기 2번
		int b = jd.getCoupon(a);

		pv.setCouponPrice(b);

		// 관련 클래스 리스트
		int c = pv.getCompanyNo();
		// 랜덤으로 클래스 번호 가져오기
		List<Integer> cList = jd.randClassNo(c);

		List<ReClassVo> rList = new ArrayList<>();
		for (int i = 0; i < cList.size(); i++) {
			int d = cList.get(i);
			// 클래스 정보 가져오기1
			ReClassVo rc = jd.reclass(d);
			ReClassVo rc2 = jd.reclass2(d);

			rc.setReviewPoint(rc2.getReviewPoint());
			rc.setReviewCount(rc2.getReviewCount());
			rc.setClassNo(d);
			rList.add(rc);
		}
		System.out.println(rList);

		Map<String, Object> payMap = new HashMap<>();
		payMap.put("pv", pv);
		payMap.put("rList", rList);

		return payMap;
	}

	// 업체정보페이지
	public Map<String, Object> companyinfo(int a) {

		CompanyInfoVo ci = jd.companyinfo(a);

		List<CompanyInfoVo2> ci2 = jd.classList(a);

		for (int i = 0; i < ci2.size(); i++) {
			int b = ci2.get(i).getClassNo();

			CompanyInfoVo2 ci3 = jd.classList2(b);

			int classNo = ci2.get(i).getClassNo();
			String className = ci2.get(i).getClassName();
			String classIntro = ci2.get(i).getClassIntro();
			String classImage = ci2.get(i).getClassImage();
			double reviewPoint = 0;
			int reviewCount = 0;
			double q1 = 0;
			double q2 = 0;
			double q3 = 0;
			if (ci3 != null) {
				reviewPoint = ci3.getReviewPoint();
				reviewCount = ci3.getReviewCount();
				q1 = ci3.getQ1();
				q2 = ci3.getQ2();
				q3 = ci3.getQ3();
			}
			CompanyInfoVo2 ci4 = new CompanyInfoVo2(classNo, className, classIntro, classImage, reviewPoint,
					reviewCount, q1, q2, q3);
			ci2.set(i, ci4);
		}
		System.out.println(ci);
		System.out.println(ci2);

		Map<String, Object> infoMap = new HashMap<>();
		infoMap.put("ci", ci);
		infoMap.put("ci2", ci2);

		return infoMap;
	}

	// 업체수정페이지
	public SolCompanyVo companymodify(int a) {

		return jd.companymodify(a);
	}

	//업체수정
	public String update(SolCompanyVo solVo) {
		
		//파일 저장
		MultipartFile file = solVo.getCompanyFile();
		String osName = System.getProperty("os.name").toLowerCase();
		String saveDir;
		if (osName.contains("linux")) {
			saveDir = "/app/upload/"; // Linux 경로. username을 실제 사용자 이름으로 변경하세요.

		} else {
			saveDir = "C:\\uploadImages\\";
		}

		String orgName = file.getOriginalFilename();
		String exName = orgName.substring(orgName.lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		String filePath = saveDir + File.separator + saveName;

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
		solVo.setCompanyImage(saveName);
		System.out.println(solVo);
		
		//db저장
		jd.update(solVo);
		
		
		
		return null;
	}
}
