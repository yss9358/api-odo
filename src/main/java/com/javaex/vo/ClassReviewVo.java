package com.javaex.vo;

public class ClassReviewVo {

	private int classNo;
	private int classType;
	private String className;
	private String classIntro;
	private int userNo;
	private String userImage;
	private String userNickname;
	private int reviewPoint;
	private String reviewDate;
	private String reviewContent;
	private String reviewImage;
	
	public ClassReviewVo() {
		
	}

	public ClassReviewVo(int classNo, int classType, String className, String classIntro, int userNo, String userImage,
			String userNickname, int reviewPoint, String reviewDate, String reviewContent, String reviewImage) {
		this.classNo = classNo;
		this.classType = classType;
		this.className = className;
		this.classIntro = classIntro;
		this.userNo = userNo;
		this.userImage = userImage;
		this.userNickname = userNickname;
		this.reviewPoint = reviewPoint;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.reviewImage = reviewImage;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
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

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewImage() {
		return reviewImage;
	}

	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}

	@Override
	public String toString() {
		return "ClassReviewVo [classNo=" + classNo + ", classType=" + classType + ", className=" + className
				+ ", classIntro=" + classIntro + ", userNo=" + userNo + ", userImage=" + userImage + ", userNickname="
				+ userNickname + ", reviewPoint=" + reviewPoint + ", reviewDate=" + reviewDate + ", reviewContent="
				+ reviewContent + ", reviewImage=" + reviewImage + "]";
	}
	
}
