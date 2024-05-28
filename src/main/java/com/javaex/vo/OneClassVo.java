package com.javaex.vo;

public class OneClassVo {

	// 클래스 정보 하나 가져올 때 쓸 vo
	private int classNo;
	private String classImage;
	private String className;
	private String classIntro;
	private int classType;
	private int scheduleNo;
	private String startDate;
	private String endDate;
	
	public OneClassVo() {
		
	}

	public OneClassVo(int classNo, String classImage, String className, String classIntro, int classType,
			int scheduleNo, String startDate, String endDate) {
		this.classNo = classNo;
		this.classImage = classImage;
		this.className = className;
		this.classIntro = classIntro;
		this.classType = classType;
		this.scheduleNo = scheduleNo;
		this.startDate = startDate;
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return "OneClassVo [classNo=" + classNo + ", classImage=" + classImage + ", className=" + className
				+ ", classIntro=" + classIntro + ", classType=" + classType + ", scheduleNo=" + scheduleNo
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
