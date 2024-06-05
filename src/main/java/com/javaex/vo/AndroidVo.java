package com.javaex.vo;

public class AndroidVo {

	private String className;
	private String classAddress;
	private int classType;
	private int scheduleNo;
	private int attenCount;
	
	public AndroidVo() {
		super();
	}

	public AndroidVo(String className, String classAddress, int classType, int scheduleNo, int attenCount) {
		super();
		this.className = className;
		this.classAddress = classAddress;
		this.classType = classType;
		this.scheduleNo = scheduleNo;
		this.attenCount = attenCount;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassAddress() {
		return classAddress;
	}

	public void setClassAddress(String classAddress) {
		this.classAddress = classAddress;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public int getAttenCount() {
		return attenCount;
	}

	public void setAttenCount(int attenCount) {
		this.attenCount = attenCount;
	}

	@Override
	public String toString() {
		return "AndroidVo [className=" + className + ", classAddress=" + classAddress + ", classType=" + classType
				+ ", scheduleNo=" + scheduleNo + ", attenCount=" + attenCount + "]";
	}
}
