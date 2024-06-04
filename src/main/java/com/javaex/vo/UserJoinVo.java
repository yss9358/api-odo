package com.javaex.vo;


public class UserJoinVo {

	private int userNo;
	private String userId;
	private String userEmail;
	private String userPw;
	private String userName;
	private String userNickname;
	private String userHp;
	private String userBirth;
	private String userGender;
	private String userImage;
	private int userType;
	
	public UserJoinVo() {

	}

	public UserJoinVo(int userNo, String userId, String userEmail, String userPw, String userName, String userNickname,
			String userHp, String userBirth, String userGender, String userImage, int userType) {
		this.userNo = userNo;
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPw = userPw;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userHp = userHp;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userImage = userImage;
		this.userType = userType;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserJoinVo [userNo=" + userNo + ", userId=" + userId + ", userEmail=" + userEmail + ", userPw=" + userPw
				+ ", userName=" + userName + ", userNickname=" + userNickname + ", userHp=" + userHp + ", userBirth="
				+ userBirth + ", userGender=" + userGender + ", userImage=" + userImage + ", userType=" + userType
				+ "]";
	}

}
