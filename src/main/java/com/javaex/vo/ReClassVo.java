package com.javaex.vo;

public class ReClassVo {

	private int classNo;
	private String classImage;
	private String classAddress;
	private String className;
	private String classIntro;
	private int classPrice;
	private int reviewPoint;
	private int reviewCount;
	
	public ReClassVo() {
		super();
	}

	public ReClassVo(int classNo, String classImage, String classAddress, String className, String classIntro,
			int classPrice, int reviewPoint, int reviewCount) {
		super();
		this.classNo = classNo;
		this.classImage = classImage;
		this.classAddress = classAddress;
		this.className = className;
		this.classIntro = classIntro;
		this.classPrice = classPrice;
		this.reviewPoint = reviewPoint;
		this.reviewCount = reviewCount;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getClassImage() {
		return classImage;
	}

	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}

	public String getClassAddress() {
		return classAddress;
	}

	public void setClassAddress(String classAddress) {
		this.classAddress = classAddress;
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

	public int getClassPrice() {
		return classPrice;
	}

	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "ReClassVo [classNo=" + classNo + ", classImage=" + classImage + ", classAddress=" + classAddress
				+ ", className=" + className + ", classIntro=" + classIntro + ", classPrice=" + classPrice
				+ ", reviewPoint=" + reviewPoint + ", reviewCount=" + reviewCount + "]";
	}
}
