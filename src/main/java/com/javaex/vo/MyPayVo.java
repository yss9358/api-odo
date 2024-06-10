package com.javaex.vo;

public class MyPayVo {
	
	private int userNo;
	private int classType;
	private int classNo;
	private String classImage;
	private String endDate;
	private int wishClassNo;
	private int starScore;
	private int payNo;
	private String payDate;
	private String className;
	private String classIntro;
	private int payPrice;
	private int attenCount;
	private int scheduleNo;
	private int reviewNo;
	private int companyNo;
	private int recClassNo;
	private String recClassImage;
	private String recClassName;
	
	public MyPayVo() {
		
	}

	public MyPayVo(int userNo, int classType, int classNo, String classImage, String endDate, int wishClassNo,
			int starScore, int payNo, String payDate, String className, String classIntro, int payPrice, int attenCount,
			int scheduleNo, int reviewNo, int companyNo, int recClassNo, String recClassImage, String recClassName) {
		this.userNo = userNo;
		this.classType = classType;
		this.classNo = classNo;
		this.classImage = classImage;
		this.endDate = endDate;
		this.wishClassNo = wishClassNo;
		this.starScore = starScore;
		this.payNo = payNo;
		this.payDate = payDate;
		this.className = className;
		this.classIntro = classIntro;
		this.payPrice = payPrice;
		this.attenCount = attenCount;
		this.scheduleNo = scheduleNo;
		this.reviewNo = reviewNo;
		this.companyNo = companyNo;
		this.recClassNo = recClassNo;
		this.recClassImage = recClassImage;
		this.recClassName = recClassName;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getClassImage() {
		return classImage;
	}

	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getWishClassNo() {
		return wishClassNo;
	}

	public void setWishClassNo(int wishClassNo) {
		this.wishClassNo = wishClassNo;
	}

	public int getStarScore() {
		return starScore;
	}

	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
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

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public int getAttenCount() {
		return attenCount;
	}

	public void setAttenCount(int attenCount) {
		this.attenCount = attenCount;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getRecClassNo() {
		return recClassNo;
	}

	public void setRecClassNo(int recClassNo) {
		this.recClassNo = recClassNo;
	}

	public String getRecClassImage() {
		return recClassImage;
	}

	public void setRecClassImage(String recClassImage) {
		this.recClassImage = recClassImage;
	}

	public String getRecClassName() {
		return recClassName;
	}

	public void setRecClassName(String recClassName) {
		this.recClassName = recClassName;
	}

	@Override
	public String toString() {
		return "MyPayVo [userNo=" + userNo + ", classType=" + classType + ", classNo=" + classNo + ", classImage="
				+ classImage + ", endDate=" + endDate + ", wishClassNo=" + wishClassNo + ", starScore=" + starScore
				+ ", payNo=" + payNo + ", payDate=" + payDate + ", className=" + className + ", classIntro="
				+ classIntro + ", payPrice=" + payPrice + ", attenCount=" + attenCount + ", scheduleNo=" + scheduleNo
				+ ", reviewNo=" + reviewNo + ", companyNo=" + companyNo + ", recClassNo=" + recClassNo
				+ ", recClassImage=" + recClassImage + ", recClassName=" + recClassName + "]";
	}
	
}
