package com.javaex.vo;

public class SolListVo {
	
	private int userNo;
	private int companyNo;
	private int classNo;
	private int classType;
	private String classImage;
	private String className;
	private String classIntro;
	private String cate1Name;
	private String cate2Name;
	private String classZipcode;
	private String classNameAddress;
	private String classNumAddress;
	private String classDetailAddress;
	private double classLatitude;
	private double classLongitutde;
	private int classPrice;
	private int classMin;
	private int classMax;
	private int review;
	private int wish;
	
	private int isFind;
	private String keyword;
	private int page;
	private int listCount;
	private int startRow;
	private int isMap;
	
	
	public SolListVo() {
		super();
	}
	
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public int getClassType() {
		return classType;
	}
	public void setClassType(int classType) {
		this.classType = classType;
	}
	public String getClassImage() {
		return classImage;
	}
	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassIntro() {
		return classIntro;
	}
	public void setClassIntro(String classIntro) {
		this.classIntro = classIntro;
	}
	public String getCate1Name() {
		return cate1Name;
	}
	public void setCate1Name(String cate1Name) {
		this.cate1Name = cate1Name;
	}
	public String getCate2Name() {
		return cate2Name;
	}
	public void setCate2Name(String cate2Name) {
		this.cate2Name = cate2Name;
	}
	public String getClassZipcode() {
		return classZipcode;
	}
	public void setClassZipcode(String classZipcode) {
		this.classZipcode = classZipcode;
	}
	public String getClassNameAddress() {
		return classNameAddress;
	}
	public void setClassNameAddress(String classNameAddress) {
		this.classNameAddress = classNameAddress;
	}
	public String getClassNumAddress() {
		return classNumAddress;
	}
	public void setClassNumAddress(String classNumAddress) {
		this.classNumAddress = classNumAddress;
	}
	public String getClassDetailAddress() {
		return classDetailAddress;
	}
	public void setClassDetailAddress(String classDetailAddress) {
		this.classDetailAddress = classDetailAddress;
	}
	public double getClassLatitude() {
		return classLatitude;
	}
	public void setClassLatitude(double classLatitude) {
		this.classLatitude = classLatitude;
	}
	public double getClassLongitutde() {
		return classLongitutde;
	}
	public void setClassLongitutde(double classLongitutde) {
		this.classLongitutde = classLongitutde;
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
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public int getWish() {
		return wish;
	}
	public void setWish(int wish) {
		this.wish = wish;
	}
	public int getIsFind() {
		return isFind;
	}
	public void setIsFind(int isFind) {
		this.isFind = isFind;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getIsMap() {
		return isMap;
	}
	public void setIsMap(int isMap) {
		this.isMap = isMap;
	}


	@Override
	public String toString() {
		return "SolListVo "+ isMap+"[userNo=" + userNo + ", companyNo=" + companyNo + ", classNo=" + classNo + ", classType="
				+ classType + ", classImage=" + classImage + ", className=" + className + ", classIntro=" + classIntro
				+ ", cate1Name=" + cate1Name + ", cate2Name=" + cate2Name + ", classZipcode=" + classZipcode
				+ ", classNameAddress=" + classNameAddress + ", classNumAddress=" + classNumAddress
				+ ", classDetailAddress=" + classDetailAddress + ", classLatitude=" + classLatitude
				+ ", classLongitutde=" + classLongitutde + ", classPrice=" + classPrice + ", classMin=" + classMin
				+ ", classMax=" + classMax + ", review=" + review + ", wish=" + wish + ", isFind=" + isFind
				+ ", keyword=" + keyword + "]";
	}


}
