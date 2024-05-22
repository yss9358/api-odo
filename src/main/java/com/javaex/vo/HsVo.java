package com.javaex.vo;

public class HsVo {

	//회사 필드
	private int comNo;
	private String comName;
	private String comImg;
	private String comNameAdd;
	private String comNumAdd;
	private String comDetailAdd;
	private String latitude;
	private String longtitude;
	
	//1차카테고리필드
	private int cate1No;
	private String cate1Name;
	
	//2차카테고리필드
	private int cate2No;
	private String cate2Name;
	
	//클래스 필드
	private int classNo;
	private String className;
	private int classType;
	private String classIntro;
	private String classNameAdd;
	private String classNumAdd;
	private String classDetailAdd;
	private String classLatitude;
	private String classLongtitude;
	private String classImg;
	private int classPrice;
	private int classMin;
	private int classMax;
	private String classInfo;
	
	//후기 필드
	private int reviewPointAvg;
	private int reviewCount;
	
	//생성자
	public HsVo() {
		
	}
	
	//메인페이지 클래스 리스트 후기부분 빼고
	public HsVo(int classNo, String className, String classNameAdd, String classImg, int classPrice) {
		super();
		this.classNo = classNo;
		this.className = className;
		this.classNameAdd = classNameAdd;
		this.classImg = classImg;
		this.classPrice = classPrice;
	}

	//메인페이지 클래스 리스트에 필요한 모든 정보들. 후기테이블이랑 조인해야함.
	public HsVo(int classNo, String className, String classNameAdd, String classImg, int classPrice, int reviewPointAvg,
			int reviewCount) {
		super();
		this.classNo = classNo;
		this.className = className;
		this.classNameAdd = classNameAdd;
		this.classImg = classImg;
		this.classPrice = classPrice;
		this.reviewPointAvg = reviewPointAvg;
		this.reviewCount = reviewCount;
	}

	
	//메소드 - g/s
	public int getComNo() {
		return comNo;
	}
	
	public void setComNo(int comNo) {
		this.comNo = comNo;
	}
	
	public String getComName() {
		return comName;
	}
	
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	public String getComImg() {
		return comImg;
	}
	
	public void setComImg(String comImg) {
		this.comImg = comImg;
	}
	
	public String getComNameAdd() {
		return comNameAdd;
	}
	
	public void setComNameAdd(String comNameAdd) {
		this.comNameAdd = comNameAdd;
	}
	
	public String getComNumAdd() {
		return comNumAdd;
	}
	
	public void setComNumAdd(String comNumAdd) {
		this.comNumAdd = comNumAdd;
	}
	
	public String getComDetailAdd() {
		return comDetailAdd;
	}
	
	public void setComDetailAdd(String comDetailAdd) {
		this.comDetailAdd = comDetailAdd;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongtitude() {
		return longtitude;
	}
	
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	
	public int getCate1No() {
		return cate1No;
	}
	
	public void setCate1No(int cate1No) {
		this.cate1No = cate1No;
	}
	
	public String getCate1Name() {
		return cate1Name;
	}
	
	public void setCate1Name(String cate1Name) {
		this.cate1Name = cate1Name;
	}
	
	public int getCate2No() {
		return cate2No;
	}
	
	public void setCate2No(int cate2No) {
		this.cate2No = cate2No;
	}
	
	public String getCate2Name() {
		return cate2Name;
	}
	
	public void setCate2Name(String cate2Name) {
		this.cate2Name = cate2Name;
	}
	
	public int getClassNo() {
		return classNo;
	}
	
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public int getClassType() {
		return classType;
	}
	
	public void setClassType(int classType) {
		this.classType = classType;
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
	
	public String getClassNumAdd() {
		return classNumAdd;
	}
	
	public void setClassNumAdd(String classNumAdd) {
		this.classNumAdd = classNumAdd;
	}
	
	public String getClassDetailAdd() {
		return classDetailAdd;
	}
	
	public void setClassDetailAdd(String classDetailAdd) {
		this.classDetailAdd = classDetailAdd;
	}
	
	public String getClassLatitude() {
		return classLatitude;
	}
	
	public void setClassLatitude(String classLatitude) {
		this.classLatitude = classLatitude;
	}
	
	public String getClassLongtitude() {
		return classLongtitude;
	}
	
	public void setClassLongtitude(String classLongtitude) {
		this.classLongtitude = classLongtitude;
	}
	
	public String getClassImg() {
		return classImg;
	}
	
	public void setClassImg(String classImg) {
		this.classImg = classImg;
	}
	
	public int getClassPrice() {
		return classPrice;
	}
	
	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}
	
	public int getClassMin() {
		return classMin;
	}
	
	public void setClassMin(int classMin) {
		this.classMin = classMin;
	}
	
	public int getClassMax() {
		return classMax;
	}
	
	public void setClassMax(int classMax) {
		this.classMax = classMax;
	}
	
	public String getClassInfo() {
		return classInfo;
	}
	
	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}
	
	public int getReviewPointAvg() {
		return reviewPointAvg;
	}
	
	public void setReviewPointAvg(int reviewPointAvg) {
		this.reviewPointAvg = reviewPointAvg;
	}
	
	public int getReviewCount() {
		return reviewCount;
	}
	
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	//메소드
	
}

