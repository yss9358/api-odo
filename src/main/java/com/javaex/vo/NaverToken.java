package com.javaex.vo;

public class NaverToken {

	private String code;
	private String state;
	private String access_token;
	private String refresh_token;
	private String token_type;
	private int expires_in;
	
	public NaverToken() {
		
	}

	public NaverToken(String code, String state, String access_token, String refresh_token, String token_type,
			int expires_in) {
		this.code = code;
		this.state = state;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "NaverToken [code=" + code + ", state=" + state + ", access_token=" + access_token + ", refresh_token="
				+ refresh_token + ", token_type=" + token_type + ", expires_in=" + expires_in + "]";
	}
	
}
