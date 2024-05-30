package com.javaex.vo;


public class SolScheduleVo {
	
	private int scheduleNo;
	private int companyNo;
	private String startDate;
	private String endDate;
	
	
	public SolScheduleVo() {
		super();
	}
	public SolScheduleVo(int companyNo, String startDate) {
		super();
		this.companyNo = companyNo;
		this.startDate = startDate;
	}
	public SolScheduleVo(int companyNo, String startDate, String endDate) {
		super();
		this.companyNo = companyNo;
		this.startDate = startDate;
		this.endDate = endDate;
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
		return "SolSchedulVo [scheduleNo=" + scheduleNo + ", companyNo=" + companyNo
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}


	
	

}
