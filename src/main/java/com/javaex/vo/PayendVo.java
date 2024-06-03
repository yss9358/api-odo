package com.javaex.vo;

public class PayendVo {

	private String classImage;
	private String nickname;
	private String companyName;
	private String className;
	private String startDate;
	private String endDate;
	private String payType;
	private int payPirce;
	private int couponPrice;
	private int companyNo;
	private int classPrice;
	
	public PayendVo() {
		super();
	}

	public PayendVo(String classImage, String nickname, String companyName, String className, String startDate,
			String endDate, String payType, int payPirce, int couponPrice, int companyNo, int classPrice) {
		super();
		this.classImage = classImage;
		this.nickname = nickname;
		this.companyName = companyName;
		this.className = className;
		this.startDate = startDate;
		this.endDate = endDate;
		this.payType = payType;
		this.payPirce = payPirce;
		this.couponPrice = couponPrice;
		this.companyNo = companyNo;
		this.classPrice = classPrice;
	}

	public String getClassImage() {
		return classImage;
	}

	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getPayPirce() {
		return payPirce;
	}

	public void setPayPirce(int payPirce) {
		this.payPirce = payPirce;
	}

	public int getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getClassPrice() {
		return classPrice;
	}

	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}

	@Override
	public String toString() {
		return "PayendVo [classImage=" + classImage + ", nickname=" + nickname + ", companyName=" + companyName
				+ ", className=" + className + ", startDate=" + startDate + ", endDate=" + endDate + ", payType="
				+ payType + ", payPirce=" + payPirce + ", couponPrice=" + couponPrice + ", companyNo=" + companyNo
				+ ", classPrice=" + classPrice + "]";
	}
}
