package com.javaex.util;


public class JsonResult {

	/** 필드 **/
	private String result; // "success" or "fail"
	private Object apiData; // 성공일때 데이타
	private String message; // 실패일때 실패메세지

	private JsonResult(Object apiData) {
		result = "success";
		this.apiData = apiData;
		message = null;
	}
	
	private JsonResult(String message) {
		result = "fail";
		apiData = null;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public Object getApiData() {
		return apiData;
	}

	public String getMessage() {
		return message;
	}

	public static JsonResult success(Object data) {
		return new JsonResult(data);
	}
	public static JsonResult fail(String message) {
		return new JsonResult(message);
	}
}
