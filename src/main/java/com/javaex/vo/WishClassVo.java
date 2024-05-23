package com.javaex.vo;

public class WishClassVo {

	private String classAddress;
	private String className;
	private String classIntro;
	private int classPrice;
	private String classImage;
	
	public WishClassVo() {
		super();
	}

	public WishClassVo(String classAddress, String className, String classIntro, int classPrice, String classImage) {
		super();
		this.classAddress = classAddress;
		this.className = className;
		this.classIntro = classIntro;
		this.classPrice = classPrice;
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

	public String getClassImage() {
		return classImage;
	}

	public void setClassImage(String classImage) {
		this.classImage = classImage;
	}

	@Override
	public String toString() {
		return "WishClassVo [classAddress=" + classAddress + ", className=" + className + ", classIntro=" + classIntro
				+ ", classPrice=" + classPrice + ", classImage=" + classImage + "]";
	}
}
