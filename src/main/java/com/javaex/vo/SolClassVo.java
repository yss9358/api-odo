package com.javaex.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SolClassVo {

	//이미지 파일
	private MultipartFile classImageFile;

	private int scheduleNo;
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
	private int cate2No;
	private int cate1No;
	private int classPrice;
	private int classMin;
	private int classMax;
	private String classInfo;
	private String classUrl;
	private int recClassNo;
	private List<String> startDateList;
	private String startDate;
	private String endDate;

	public SolClassVo() {
		super();
	}

	
	public int getScheduleNo() {
		return scheduleNo;
	}


	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}


	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getCate1No() {
		return cate1No;
	}

	public void setCate1No(int cate1No) {
		this.cate1No = cate1No;
	}

	public int getCate2No() {
		return cate2No;
	}

	public void setCate2No(int cate2No) {
		this.cate2No = cate2No;
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

	public String getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}

	public String getClassUrl() {
		return classUrl;
	}

	public void setClassUrl(String classUrl) {
		this.classUrl = classUrl;
	}

	public int getRecClassNo() {
		return recClassNo;
	}

	public void setRecClassNo(int recClassNo) {
		this.recClassNo = recClassNo;
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

	public String getClassImage() {
		return classImage;
	}

	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}

	public MultipartFile getClassImageFile() {
		return classImageFile;
	}

	public void setClassImageFile(MultipartFile classImageFile) {
		this.classImageFile = classImageFile;
	}
	public List<String> getStartDateList() {
		return startDateList;
	}

	public void setStartDateList(List<String> startDateList) {
		this.startDateList = startDateList;
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
	


	@Override
	public String toString() {
		return "SolClassVo [classImageFile=" + classImageFile + ", scheduleNo=" + scheduleNo + ", companyNo="
				+ companyNo + ", classNo=" + classNo + ", classType=" + classType + ", classImage=" + classImage
				+ ", className=" + className + ", classIntro=" + classIntro + ", cate1Name=" + cate1Name
				+ ", cate2Name=" + cate2Name + ", classZipcode=" + classZipcode + ", classNameAddress="
				+ classNameAddress + ", classNumAddress=" + classNumAddress + ", classDetailAddress="
				+ classDetailAddress + ", classLatitude=" + classLatitude + ", classLongitutde=" + classLongitutde
				+ ", cate2No=" + cate2No + ", cate1No=" + cate1No + ", classPrice=" + classPrice + ", classMin="
				+ classMin + ", classMax=" + classMax + ", classInfo=" + classInfo + ", classUrl=" + classUrl
				+ ", recClassNo=" + recClassNo + ", startDateList=" + startDateList + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}


	

	

}
