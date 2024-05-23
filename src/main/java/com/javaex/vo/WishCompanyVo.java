package com.javaex.vo;

public class WishCompanyVo {
	
	private String companyImage;
	private String companyName;
	private int companyNo;
	
	public WishCompanyVo() {
		super();
	}

	public WishCompanyVo(String companyImage, String companyName, int companyNo) {
		super();
		this.companyImage = companyImage;
		this.companyName = companyName;
		this.companyNo = companyNo;
	}

	public String getCompanyImage() {
		return companyImage;
	}

	public void setCompanyImage(String companyImage) {
		this.companyImage = companyImage;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	@Override
	public String toString() {
		return "WishCompanyVo [companyImage=" + companyImage + ", companyName=" + companyName + ", companyNo="
				+ companyNo + "]";
	}
	
	
}
