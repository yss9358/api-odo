package com.javaex.vo;

public class CompanyInfoVo2 {

	private int classNo;
	private String className;
	private String classIntro;
	private String classImage;
	private double reviewPoint;
	private int reviewCount;
	private double q1;
	private double q2;
	private double q3;
	private int wishNo;
	
	public CompanyInfoVo2() {
		super();
	}

	public CompanyInfoVo2(int classNo, String className, String classIntro, String classImage, double reviewPoint,
			int reviewCount, double q1, double q2, double q3, int wishNo) {
		super();
		this.classNo = classNo;
		this.className = className;
		this.classIntro = classIntro;
		this.classImage = classImage;
		this.reviewPoint = reviewPoint;
		this.reviewCount = reviewCount;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.wishNo = wishNo;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
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

	public String getClassImage() {
		return classImage;
	}

	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}

	public double getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(double reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public double getQ1() {
		return q1;
	}

	public void setQ1(double q1) {
		this.q1 = q1;
	}

	public double getQ2() {
		return q2;
	}

	public void setQ2(double q2) {
		this.q2 = q2;
	}

	public double getQ3() {
		return q3;
	}

	public void setQ3(double q3) {
		this.q3 = q3;
	}

	public int getWishNo() {
		return wishNo;
	}

	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
	}

	@Override
	public String toString() {
		return "CompanyInfoVo2 [classNo=" + classNo + ", className=" + className + ", classIntro=" + classIntro
				+ ", classImage=" + classImage + ", reviewPoint=" + reviewPoint + ", reviewCount=" + reviewCount
				+ ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + ", wishNo=" + wishNo + "]";
	}

	
}
