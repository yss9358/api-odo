package com.javaex.vo;

public class ListVo {
	private int classNo;
	private String className;
	private int count;
	
	public ListVo() {
		super();
	}

	public ListVo(int classNo, String className, int count) {
		super();
		this.classNo = classNo;
		this.className = className;
		this.count = count;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "listVo [classNo=" + classNo + ", className=" + className + ", count=" + count + "]";
	}
	
}
