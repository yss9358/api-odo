package com.javaex.vo;

public class ClassDetailVo {

	//필드
	//클래스
	private int classNo;
	private String classImg;
	private String className;
	private int classPrice;
	private String classIntro;
	private String classNameAdd;
	private String classDetailAdd;
	private String classInfo;
	//회사
	private int companyNo;
	private String companyImg;
	private String companyName;
	//리뷰
	private int reviewNo; 
	private String reviewImg;
	private int reviewPoint;
	private String reviewContent;
	//유저
	private int userNo;
	private String userImg;
	private String userNickname;
	//스케줄
	private int scheduleNo;
	private String startDate;
	private String endDate;

	//클래스 위시
	private int wish;
	private int wClassNo;
	
	//회사 위시
	private int cWish;
	private int wCompanyNo;
	
	//생성자
	public ClassDetailVo() {
	}
	
	public ClassDetailVo(int classNo, int userNo) {
		this.classNo = classNo;
		this.userNo = userNo;
	}

	//클래스 정보 - 비로그인
	public ClassDetailVo(String classImg, String className, int classPrice, String classIntro, String classInfo, String classNameAdd,
			String classDetailAdd, int companyNo) {
		this.classImg = classImg;
		this.className = className;
		this.classPrice = classPrice;
		this.classIntro = classIntro;
		this.classInfo = classInfo;
		this.classNameAdd = classNameAdd;
		this.classDetailAdd = classDetailAdd;
		this.companyNo = companyNo;
	}
	
	//클래스 정보 - 로그인
	public ClassDetailVo(String classImg, String className, int classPrice, String classIntro, String classInfo, String classNameAdd,
			String classDetailAdd, int companyNo, int userNo, int wish, int wClassNo) {
		this.classImg = classImg;
		this.className = className;
		this.classPrice = classPrice;
		this.classIntro = classIntro;
		this.classInfo = classInfo;
		this.classNameAdd = classNameAdd;
		this.classDetailAdd = classDetailAdd;
		this.companyNo = companyNo;
		this.userNo = userNo;
		this.wish = wish;
		this.wClassNo = wClassNo;
	}

	//클래스 운영 회사 정보 - 비로그인
	public ClassDetailVo(String companyImg, String companyName) {
		this.companyImg = companyImg;
		this.companyName = companyName;
	}
	
	//클래스 운영 회사 정보 - 로그인
	public ClassDetailVo(String companyImg, String companyName, int userNo, int cWish, int wCompanyNo) {
		this.companyImg = companyImg;
		this.companyName = companyName;
		this.userNo = userNo;
		this.cWish = cWish;
		this.wCompanyNo = wCompanyNo;
	}

	//클래스 일정 리스트
	public ClassDetailVo(int scheduleNo, String startDate, String endDate) {
		this.scheduleNo = scheduleNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	//해당 클래스 후기 리스트
	public ClassDetailVo(int reviewNo, String reviewImg, int reviewPoint, String reviewContent, int userNo,
			String userImg, String userNickname) {
		this.reviewNo = reviewNo;
		this.reviewImg = reviewImg;
		this.reviewPoint = reviewPoint;
		this.reviewContent = reviewContent;
		this.userNo = userNo;
		this.userImg = userImg;
		this.userNickname = userNickname;
	}
	

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getClassImg() {
		return classImg;
	}

	public void setClassImg(String classImg) {
		this.classImg = classImg;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassPrice() {
		return classPrice;
	}

	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}

	public String getClassIntro() {
		return classIntro;
	}

	public void setClassIntro(String classIntro) {
		this.classIntro = classIntro;
	}

	public String getClassNameAdd() {
		return classNameAdd;
	}

	public void setClassNameAdd(String classNameAdd) {
		this.classNameAdd = classNameAdd;
	}

	public String getClassDetailAdd() {
		return classDetailAdd;
	}

	public void setClassDetailAdd(String classDetailAdd) {
		this.classDetailAdd = classDetailAdd;
	}

	public String getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getCompanyImg() {
		return companyImg;
	}

	public void setCompanyImg(String companyImg) {
		this.companyImg = companyImg;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewImg() {
		return reviewImg;
	}

	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getWish() {
		return wish;
	}

	public void setWish(int wish) {
		this.wish = wish;
	}

	public int getwClassNo() {
		return wClassNo;
	}

	public void setwClassNo(int wClassNo) {
		this.wClassNo = wClassNo;
	}

	public int getcWish() {
		return cWish;
	}

	public void setcWish(int cWish) {
		this.cWish = cWish;
	}

	public int getwCompanyNo() {
		return wCompanyNo;
	}

	public void setwCompanyNo(int wCompanyNo) {
		this.wCompanyNo = wCompanyNo;
	}

	@Override
	public String toString() {
		return "ClassDetailVo [classNo=" + classNo + ", userNo=" + userNo + "]";
	}
	
	
}
