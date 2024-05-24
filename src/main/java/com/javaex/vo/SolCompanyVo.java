package com.javaex.vo;

import org.springframework.web.multipart.MultipartFile;

public class SolCompanyVo {
	private int companyNo;	//기업번호
	private String companyName;//기업이름
	private String companyId;	//아이디
	private String companyPass;//비밀번호
	private String companyBn;	//사업자번호
	private String companyZipCode;//우편번호
	private String companyNameAddress;//도로명주소
	private String companyNumAddress;//지번주소
	private String companyDetailAddress;//상세주소
	private double companyLatitude;//위도
	private double companyLongitude;//경도
	private String companyHp;//핸드폰번호
	private String companyIntro;//회사소개
	private String companyImage;//대표이미지
	
	
	private MultipartFile companyFile;//대표이미지


	public SolCompanyVo() {
		super();
	}


	public int getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getCompanyPass() {
		return companyPass;
	}


	public void setCompanyPass(String companyPass) {
		this.companyPass = companyPass;
	}


	public String getCompanyBn() {
		return companyBn;
	}


	public void setCompanyBn(String companyBn) {
		this.companyBn = companyBn;
	}


	public String getCompanyZipCode() {
		return companyZipCode;
	}


	public void setCompanyZipCode(String companyZipCode) {
		this.companyZipCode = companyZipCode;
	}


	public String getCompanyNameAddress() {
		return companyNameAddress;
	}


	public void setCompanyNameAddress(String companyNameAddress) {
		this.companyNameAddress = companyNameAddress;
	}


	public String getCompanyNumAddress() {
		return companyNumAddress;
	}


	public void setCompanyNumAddress(String companyNumAddress) {
		this.companyNumAddress = companyNumAddress;
	}


	public String getCompanyDetailAddress() {
		return companyDetailAddress;
	}


	public void setCompanyDetailAddress(String companyDetailAddress) {
		this.companyDetailAddress = companyDetailAddress;
	}


	public double getCompanyLatitude() {
		return companyLatitude;
	}


	public void setCompanyLatitude(double companyLatitude) {
		this.companyLatitude = companyLatitude;
	}


	public double getCompanyLongitude() {
		return companyLongitude;
	}


	public void setCompanyLongitude(double companyLongitude) {
		this.companyLongitude = companyLongitude;
	}


	public String getCompanyHp() {
		return companyHp;
	}


	public void setCompanyHp(String companyHp) {
		this.companyHp = companyHp;
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


	public MultipartFile getCompanyFile() {
		return companyFile;
	}


	public void setCompanyFile(MultipartFile companyFile) {
		this.companyFile = companyFile;
	}


	@Override
	public String toString() {
		return "SolVo [companyNo=" + companyNo + ", companyName=" + companyName + ", companyId=" + companyId
				+ ", companyPass=" + companyPass + ", companyBn=" + companyBn + ", companyZipCode=" + companyZipCode
				+ ", companyNameAddress=" + companyNameAddress + ", companyNumAddress=" + companyNumAddress
				+ ", companyDetailAddress=" + companyDetailAddress + ", companyLatitude=" + companyLatitude
				+ ", companyLongitude=" + companyLongitude + ", companyHp=" + companyHp + ", companyIntro="
				+ companyIntro + ", companyImage=" + companyImage + ", companyFile=" + companyFile + "]";
	}

	
	
}
