package com.javaex.vo;

public class SolMemberVo {

	private int userNo;
	private String userName;
	private int userAge;
	private String userGender;
	private String userHp;
	private int attend;
	private String attendState;
	private String reviewState;
	private String couponState;
	private String startDate;
	private String endDate;
	
	
	public SolMemberVo() {
		super();
	}
	
	
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserHp() {
		return userHp;
	}
	public void setUserHp(String userHp) {
		this.userHp = userHp;
	}
	public int getAttend() {
		return attend;
	}
	public void setAttend(int attend) {
		this.attend = attend;
	}
	public String getAttendState() {
		return attendState;
	}
	public void setAttendState(String attendState) {
		this.attendState = attendState;
	}
	public String getReviewState() {
		return reviewState;
	}
	public void setReviewState(String reviewState) {
		this.reviewState = reviewState;
	}
	public String getCouponState() {
		return couponState;
	}
	public void setCouponState(String couponState) {
		this.couponState = couponState;
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
		return "SolMemberVo [userNo=" + userNo + ", userName=" + userName + ", userAge=" + userAge + ", userGender="
				+ userGender + ", userHp=" + userHp + ", attend=" + attend + ", attendState=" + attendState
				+ ", reviewState=" + reviewState + ", couponState=" + couponState + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
	
}
