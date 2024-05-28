package com.javaex.vo;

public class CouponVo {
	
	private int couponNo;
	private int userNo;
	private String companyName;
	private int couponPrice;
	private String couponDate;
	private int couponState;
	
	public CouponVo() {

	}

	public CouponVo(int couponNo, int userNo, String companyName, int couponPrice, String couponDate, int couponState) {
		this.couponNo = couponNo;
		this.userNo = userNo;
		this.companyName = companyName;
		this.couponPrice = couponPrice;
		this.couponDate = couponDate;
		this.couponState = couponState;
	}

	public int getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}

	public String getCouponDate() {
		return couponDate;
	}

	public void setCouponDate(String couponDate) {
		this.couponDate = couponDate;
	}

	public int getCouponState() {
		return couponState;
	}

	public void setCouponState(int couponState) {
		this.couponState = couponState;
	}

	@Override
	public String toString() {
		return "CouponVo [couponNo=" + couponNo + ", userNo=" + userNo + ", companyName=" + companyName
				+ ", couponPrice=" + couponPrice + ", couponDate=" + couponDate + ", couponState=" + couponState + "]";
	}
	
}
