package com.javaex.vo;

public class Android2Vo {

	private int userNo;
	private int scheduleNo;
	
	public Android2Vo() {
		super();
	}

	public Android2Vo(int userNo, int scheduleNo) {
		super();
		this.userNo = userNo;
		this.scheduleNo = scheduleNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	@Override
	public String toString() {
		return "Android2Vo [userNo=" + userNo + ", scheduleNo=" + scheduleNo + "]";
	}
	
	
}
