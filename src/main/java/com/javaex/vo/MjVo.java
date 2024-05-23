package com.javaex.vo;

public class MjVo {
	
	//필드
	int user_no;
	String user_nickname;
	String user_hp;
	String user_birth;
	String user_pw;
	
	
	//생성자
	public MjVo() {
		super();
	}

	public MjVo(int user_no, String user_nickname, String user_hp, String user_birth, String user_pw) {
		super();
		this.user_no = user_no;
		this.user_nickname = user_nickname;
		this.user_hp = user_hp;
		this.user_birth = user_birth;
		this.user_pw = user_pw;
	}
	
	//메소드-gs
	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_hp() {
		return user_hp;
	}

	public void setUser_hp(String user_hp) {
		this.user_hp = user_hp;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
	//메소드-일반
	@Override
	public String toString() {
		return "MjVo [user_no=" + user_no + ", user_nickname=" + user_nickname + ", user_hp=" + user_hp
				+ ", user_birth=" + user_birth + ", user_pw=" + user_pw + "]";
	}

}
