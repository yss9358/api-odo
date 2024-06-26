package com.javaex.vo;

public class WishCompanyVo2 {

	private String companyImage;
	private String companyName;
	private int companyNo;
	private int no;
	private int classCount;
	private int reviewCount;
	private int wishCount;
	
	public WishCompanyVo2() {
		super();
	}

	public WishCompanyVo2(String companyImage, String companyName, int companyNo, int no, int classCount,
			int reviewCount, int wishCount) {
		super();
		this.companyImage = companyImage;
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.no = no;
		this.classCount = classCount;
		this.reviewCount = reviewCount;
		this.wishCount = wishCount;
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

	public int getClassCount() {
		return classCount;
	}

	public void setClassCount(int classCount) {
		this.classCount = classCount;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getWishCount() {
		return wishCount;
	}

	public void setWishCount(int wishCount) {
		this.wishCount = wishCount;
	}

	@Override
	public String toString() {
		return "WishCompanyVo2 [companyImage=" + companyImage + ", companyName=" + companyName + ", companyNo="
				+ companyNo + ", no=" + no + ", classCount=" + classCount + ", reviewCount=" + reviewCount
				+ ", wishCount=" + wishCount + "]";
	}
}
