package com.javaex.vo;

public class PaymentVo {
	
	private String className;
	private String classIntro;
	private String companyName;
	private String startDate;
	private String endDate;
	private int classPrice;
	private String classImage;
	private int companyNo;
	
	public PaymentVo() {
		super();
	}

	public PaymentVo(String className, String classIntro, String companyName, String startDate, String endDate,
			int classPrice, String classImage, int companyNo) {
		super();
		this.className = className;
		this.classIntro = classIntro;
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.classPrice = classPrice;
		this.classImage = classImage;
		this.companyNo = companyNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassIntro() {
		return classIntro;
	}

	public void setClassIntro(String classIntro) {
		this.classIntro = classIntro;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public int getClassPrice() {
		return classPrice;
	}

	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}

	public String getClassImage() {
		return classImage;
	}

	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	@Override
	public String toString() {
		return "PaymentVo [className=" + className + ", classIntro=" + classIntro + ", companyName=" + companyName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", classPrice=" + classPrice + ", classImage="
				+ classImage + ", companyNo=" + companyNo + "]";
	}
}
