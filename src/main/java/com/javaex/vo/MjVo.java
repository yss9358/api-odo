package com.javaex.vo;

public class MjVo {
	
	//필드
	private int userno;
	private String name;
	private String hp;
	private String birth;
	private String userpw;
	
	//생성자
	public MjVo() {
		super();
	}
	
	public MjVo(int userno, String name, String hp, String birth, String userpw) {
		super();
		this.userno = userno;
		this.name = name;
		this.hp = hp;
		this.birth = birth;
		this.userpw = userpw;
	}
	
	//메소드-gs
	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String gethp() {
		return hp;
	}

	public void sethp(String hp) {
		this.hp = hp;
	}

	public String getbirth() {
		return birth;
	}

	public void setbirth(String birth) {
		this.birth = birth;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	//메소드-일반
	@Override
	public String toString() {
		return "MjVo [userno=" + userno + ", name=" + name + ", hp=" + hp + ", birth="
				+ birth + ", userpw=" + userpw + "]";
	}

}
