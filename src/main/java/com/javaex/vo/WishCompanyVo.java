package com.javaex.vo;

public class WishCompanyVo {
	
	private String companyImage;
	private String companyName;
	private int companyNo;
	private int no;
	
	public WishCompanyVo() {
		super();
	}
	
	

	public WishCompanyVo(int companyNo, int no) {
		super();
		this.companyNo = companyNo;
		this.no = no;
	}



	public WishCompanyVo(String companyImage, String companyName, int companyNo, int no) {
		super();
		this.companyImage = companyImage;
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.no = no;
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "WishCompanyVo [companyImage=" + companyImage + ", companyName=" + companyName + ", companyNo="
				+ companyNo + ", no=" + no + "]";
	}
}
