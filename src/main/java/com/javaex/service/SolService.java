package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.SolDao;
import com.javaex.vo.SolCateVo;
import com.javaex.vo.SolClassVo;
import com.javaex.vo.SolCompanyVo;
import com.javaex.vo.SolListVo;
import com.javaex.vo.SolMemberVo;
import com.javaex.vo.SolScheduleVo;

@Service
public class SolService {

	@Autowired
	private SolDao solDao;

	/***********************************
	 * 사업자
	 * 
	 * @param id
	 * @return
	 */
	// 아이디 중복확인
	public String exeId(String id) {
		return solDao.selectCompanyId(id);
	}

	// 회원가입
	public int exeInsertCompany(SolCompanyVo solVo) {
		return solDao.insertCompany(solVo);
	}

	// 로그인
	public SolCompanyVo exeLogin(SolCompanyVo solVo) {
		return solDao.login(solVo);
	}

	/**********************************************
	 * 클래스
	 */
	// 기존클래스리스트
	public List<SolClassVo> exeClassList(Map<Object, String> tempVo) {
		return solDao.selectAllClass(tempVo);
	}

	// 수정할 클래스불러오기
	public SolClassVo exeGetClass(Map<String, Object> tempVo) {
		return solDao.selectClass(tempVo);
	}

	// 기존클래스
	public List<SolClassVo> exegetRClass(int no) {
		return solDao.selectRClass(no);
	}

	// 카테고리 불러오기
	public List<SolCateVo> exeGetCate() {
		return solDao.selectAllCate();
	}

	// 2차카테고리
	public List<SolCateVo> exeGetCate2(int no) {
		return solDao.selectCate2(no);
	}

	/***********************************************
	 * 클래스 등록/수정
	 * 
	 * @return
	 */
	// 클래스 등록
	public int exeInsertClass(SolClassVo vo) {
		
		// 이미지저장
		String saveName = exeCompanyImg(vo.getClassImageFile());
		vo.setClassImage(saveName);

		// 클래스 등록
		solDao.insertClass(vo);
		
		// 일정등록
		int count = -1;
		if (vo.getClassType() == 1) {
			for (int i = 0; i < vo.getStartDateList().size(); i++) {
				if (vo.getStartDateList().get(i) != null) {
					count = solDao
							.insertClassSchedul(new SolScheduleVo(vo.getCompanyNo(), vo.getStartDateList().get(i)));
					System.out.println(vo.getStartDateList().get(i));
				}
			}

		} else if (vo.getClassType() == 2 || vo.getClassType() == 3) {
			count = solDao.insertClassSchedul(new SolScheduleVo(vo.getCompanyNo(), vo.getStartDate(), vo.getEndDate()));
			System.out.println(vo.getStartDate());
		}
		
		return count;
	}

	// 클래스 수정
	public int exeupdate(SolClassVo vo) {
		
		String saveName = exeCompanyImg(vo.getClassImageFile());
		vo.setClassImage(saveName);
		int count = solDao.updateClass(vo);
		
		for(int i = 0; i < vo.getStartDateList().size(); i++) {
			count++;
			SolScheduleVo temp = new SolScheduleVo(vo.getScheduleNo(), vo.getStartDateList().get(i),vo.getEndDate());
			solDao.updateSchedule(temp);
		}
		
		return count;
	}

	// 파일업로드
	public String exeCompanyImg(MultipartFile file) {
		
		//운영체계가져오기
		String osName = System.getProperty("os.name").toLowerCase();
		String saveDir;	//저장공간
		
		//운영체제 확인
		if (osName.contains("linux")) {
			saveDir = "/app/upload/"; // Linux 경로. username을 실제 사용자 이름으로 변경하세요.

		} else {
			saveDir = ".\\uploadImages\\";
		}

		//파일명 뒤져서 저장명 꺼내기
		String orgName = file.getOriginalFilename();
		String exName = orgName.substring(orgName.lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		String filePath = saveDir + File.separator + saveName;
//			System.out.println(saveName);

		try {
			byte[] fileData;
			fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saveName;
	}

	/*******************************************
	 * 리스트 불러오기
	 */
	public List<SolClassVo> exeClassTypeList(Map<String, Object> tempVo) {
		return solDao.selectClassList(tempVo);
	}

	// 유저리스트
	public List<SolMemberVo> exeUserList(SolScheduleVo vo) {
		
		if (vo.getClassType() == 1) {
			SolScheduleVo sVo = solDao.selectSchedule(vo.getClassNo());
			return solDao.selectOndUser(sVo.getScheduleNo());
		} else {
			return solDao.selectRUser(vo.getScheduleNo());
		}

	}

	// 운영중인 클래스리스트
	public List<SolScheduleVo> exeScheduleList(int no) {
		return solDao.selectAllSchedule(no);
	}
	//원데이 일정불러오기
	public List<SolScheduleVo> exeOneList(int classNo){
		return solDao.selectAllOneday(classNo);
	}
	
	
	/********************************************
	 * 쿠폰지급
	 */
	public int exeCoupon(Map<String, Object> tempVo) {
		return solDao.insertCoupon(tempVo);
	}

	/*******************************************
	 * 검색
	 */
	public List<SolListVo> exeFindClassList(SolListVo vo) {

		// 키워드 설정
		vo.setKeyword("%" + vo.getKeyword() + "%");
//		System.out.println(vo.getClassType()+vo.getKeyword());
		
		// 페이지당 보일 리스트 갯수
		int page = vo.getPage() > 0 ? vo.getPage() : (page = 1);
		vo.setPage(page);
		vo.setListCount(15);
		vo.setStartRow((vo.getPage() - 1) * vo.getListCount());

		// Dao;
		List<SolListVo> list = solDao.selectAddressList(vo);
		if(list == null) {
			return null; 
		} else {
			return list;
		}

	}
	
	
	// 위시 추가
	public int exeWishP(Map<String, Object> vo) {
		System.out.println("SolService.exeWish");
		return solDao.insertWish(vo);
	}
	//위시삭제
	public int exeWishM(Map<String, Object> vo) {
		System.out.println("SolService.exeWishM");
		return solDao.deleteWish(vo);
	}
	
	
}
