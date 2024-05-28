package com.javaex.vo;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVo {
	
	private int userNo;
	private int reviewNo;
	private int scheduleNo;
	private String reviewImage;
	private int reviewPoint;
	private String reviewContent;
	private int reviewQ1;
	private int reviewQ2;
	private int reviewQ3;
	private String reviewDate;
	private MultipartFile file;
	
	public ReviewVo() {
		
	}

	public ReviewVo(int userNo, int reviewNo, int scheduleNo, String reviewImage, int reviewPoint, String reviewContent,
			int reviewQ1, int reviewQ2, int reviewQ3, String reviewDate, MultipartFile file) {
		this.userNo = userNo;
		this.reviewNo = reviewNo;
		this.scheduleNo = scheduleNo;
		this.reviewImage = reviewImage;
		this.reviewPoint = reviewPoint;
		this.reviewContent = reviewContent;
		this.reviewQ1 = reviewQ1;
		this.reviewQ2 = reviewQ2;
		this.reviewQ3 = reviewQ3;
		this.reviewDate = reviewDate;
		this.file = file;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public String getReviewImage() {
		return reviewImage;
	}

	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewQ1() {
		return reviewQ1;
	}

	public void setReviewQ1(int reviewQ1) {
		this.reviewQ1 = reviewQ1;
	}

	public int getReviewQ2() {
		return reviewQ2;
	}

	public void setReviewQ2(int reviewQ2) {
		this.reviewQ2 = reviewQ2;
	}

	public int getReviewQ3() {
		return reviewQ3;
	}

	public void setReviewQ3(int reviewQ3) {
		this.reviewQ3 = reviewQ3;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ReviewVo [userNo=" + userNo + ", reviewNo=" + reviewNo + ", scheduleNo=" + scheduleNo + ", reviewImage="
				+ reviewImage + ", reviewPoint=" + reviewPoint + ", reviewContent=" + reviewContent + ", reviewQ1="
				+ reviewQ1 + ", reviewQ2=" + reviewQ2 + ", reviewQ3=" + reviewQ3 + ", reviewDate=" + reviewDate
				+ ", file=" + file + "]";
	}
	
}
