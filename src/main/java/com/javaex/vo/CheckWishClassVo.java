package com.javaex.vo;

public class CheckWishClassVo {
	
	private int wClassNo;
	private int classNo;
	private int userNo;
	private String wClassDate;
	
	public CheckWishClassVo() {
		
	}

	public CheckWishClassVo(int wClassNo, int classNo, int userNo, String wClassDate) {
		this.wClassNo = wClassNo;
		this.classNo = classNo;
		this.userNo = userNo;
		this.wClassDate = wClassDate;
	}

	public int getwClassNo() {
		return wClassNo;
	}

	public void setwClassNo(int wClassNo) {
		this.wClassNo = wClassNo;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getwClassDate() {
		return wClassDate;
	}

	public void setwClassDate(String wClassDate) {
		this.wClassDate = wClassDate;
	}

	@Override
	public String toString() {
		return "CheckWishClassVo [wClassNo=" + wClassNo + ", classNo=" + classNo + ", userNo=" + userNo
				+ ", wClassDate=" + wClassDate + "]";
	}
	
}
