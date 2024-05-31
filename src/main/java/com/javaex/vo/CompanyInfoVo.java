package com.javaex.vo;

public class CompanyInfoVo {

	private String companyName;
	private String companyHp;
	private String companyAddress;
	private String companyIntro;
	private String companyImage;
	private int wishNo;
	
	public CompanyInfoVo() {
		super();
	}

	public CompanyInfoVo(String companyName, String companyHp, String companyAddress, String companyIntro,
			String companyImage, int wishNo) {
		super();
		this.companyName = companyName;
		this.companyHp = companyHp;
		this.companyAddress = companyAddress;
		this.companyIntro = companyIntro;
		this.companyImage = companyImage;
		this.wishNo = wishNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyHp() {
		return companyHp;
	}

	public void setCompanyHp(String companyHp) {
		this.companyHp = companyHp;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyIntro() {
		return companyIntro;
	}

	public void setCompanyIntro(String companyIntro) {
		this.companyIntro = companyIntro;
	}

	public String getCompanyImage() {
		return companyImage;
	}

	public void setCompanyImage(String companyImage) {
		this.companyImage = companyImage;
	}

	public int getWishNo() {
		return wishNo;
	}

	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
	}

	@Override
	public String toString() {
		return "CompanyInfoVo [companyName=" + companyName + ", companyHp=" + companyHp + ", companyAddress="
				+ companyAddress + ", companyIntro=" + companyIntro + ", companyImage=" + companyImage + ", wishNo="
				+ wishNo + "]";
	}
}
