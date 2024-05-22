package com.javaex.vo;

public class MjVo {
	
	//필드
	private int personId;
	private String name;
	private String hp;
	private String company;
	
	
	//생성자
	public MjVo() {
		super();
	}
	
	//메소드-gs
	public MjVo(int personId, String name, String hp, String company) {
		super();
		this.personId = personId;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	//메소드-일반
	@Override
	public String toString() {
		return "MjVo [personId=" + personId + ", name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}

}
