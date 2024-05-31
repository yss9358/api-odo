package com.javaex.vo;

public class WishClassVo {

	private String classAddress;
	private String className;
	private String classIntro;
	private int classPrice;
	private String classImage;
	private int classNo;
	private int no;
	
	public WishClassVo() {
		super();
	}

	public WishClassVo(String classAddress, String className, String classIntro, int classPrice, String classImage,
			int classNo, int no) {
		super();
		this.classAddress = classAddress;
		this.className = className;
		this.classIntro = classIntro;
		this.classPrice = classPrice;
		this.classImage = classImage;
		this.classNo = classNo;
		this.no = no;
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

	public String getClassImage() {
		return classImage;
	}

	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "WishClassVo [classAddress=" + classAddress + ", className=" + className + ", classIntro=" + classIntro
				+ ", classPrice=" + classPrice + ", classImage=" + classImage + ", classNo=" + classNo + ", no=" + no
				+ "]";
	}
}
