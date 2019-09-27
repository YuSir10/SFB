package com.oracle.entity;

public class SFB_Token {
	private String result;
	private String token;
	
	
	
	public SFB_Token() {
		super();
	}

	public SFB_Token(String result, String token) {
		super();
		this.result = result;
		this.token = token;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String lgtoken) {
		this.token = lgtoken;
	}
	
	

}
