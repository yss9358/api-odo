package com.javaex.vo;

public class UserJoinVo {

	private int userNo;
	private String userId;
	private String userPw;
	private String userNickname;
	private String userHp;
	private String userBirth;
	private String userGender;
	private boolean userKakao;
	private boolean userNaver;
	
	public UserJoinVo() {

	}

	public UserJoinVo(int userNo, String userId, String userPw, String userNickname, String userHp, String userBirth,
			String userGender, boolean userKakao, boolean userNaver) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userNickname = userNickname;
		this.userHp = userHp;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userKakao = userKakao;
		this.userNaver = userNaver;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserHp() {
		return userHp;
	}

	public void setUserHp(String userHp) {
		this.userHp = userHp;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public boolean isUserKakao() {
		return userKakao;
	}

	public void setUserKakao(boolean userKakao) {
		this.userKakao = userKakao;
	}

	public boolean isUserNaver() {
		return userNaver;
	}

	public void setUserNaver(boolean userNaver) {
		this.userNaver = userNaver;
	}

	@Override
	public String toString() {
		return "UserJoinVo [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userNickname="
				+ userNickname + ", userHp=" + userHp + ", userBirth=" + userBirth + ", userGender=" + userGender
				+ ", userKakao=" + userKakao + ", userNaver=" + userNaver + "]";
	}
	
	
	
	
	
	
}
