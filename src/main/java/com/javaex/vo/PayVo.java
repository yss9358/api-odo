package com.javaex.vo;

public class PayVo {
	
	private int pay_no;
	private int scheduleNo;
	private String payType;
	private int total;
	private int couponNo;
	private int userNo;
	
	public PayVo() {
		super();
	}

	public PayVo(int pay_no, int scheduleNo, String payType, int total, int couponNo, int userNo) {
		super();
		this.pay_no = pay_no;
		this.scheduleNo = scheduleNo;
		this.payType = payType;
		this.total = total;
		this.couponNo = couponNo;
		this.userNo = userNo;
	}

	public int getPay_no() {
		return pay_no;
	}

	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	@Override
	public String toString() {
		return "PayVo [pay_no=" + pay_no + ", scheduleNo=" + scheduleNo + ", payType=" + payType + ", total=" + total
				+ ", couponNo=" + couponNo + ", userNo=" + userNo + "]";
	}
}
