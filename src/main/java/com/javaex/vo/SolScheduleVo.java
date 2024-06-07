package com.javaex.vo;


public class SolScheduleVo {
	
	private int scheduleNo;
	private int companyNo;
	private String title;
	private String start;
	private String end;
	
	private int classType;
	private int classNo;
	
	
	public SolScheduleVo() {
		super();
	}
	public SolScheduleVo(int classNo, String start) {
		super();
		this.classNo = classNo;
		this.start = start;
	}
	public SolScheduleVo(int classNo, String start, String end) {
		super();
		this.classNo = classNo;
		this.start = start;
		this.end = end;
	}
	public SolScheduleVo(int classNo, String start, String end, int classType) {
		super();
		this.classNo = classNo;
		this.start = start;
		this.end = end;
		this.classType = classType;
	}
	
	
	public int getScheduleNo() {
		return scheduleNo;
	}
	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getClassType() {
		return classType;
	}
	public void setClassType(int classType) {
		this.classType = classType;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	@Override
	public String toString() {
		return "SolScheduleVo [scheduleNo=" + scheduleNo + ", companyNo=" + companyNo + ", title=" + title + ", start="
				+ start + ", end=" + end + ", classType=" + classType + ", classNo=" + classNo + "]";
	}
	
	
	

}
