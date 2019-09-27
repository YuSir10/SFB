package com.oracle.vo;

import com.oracle.entity.SFB_Token;
import com.oracle.entity.SFB_User;

public class LoginRespond {
	private String resultMessage;
     private  SFB_Token logtoken;

    
     
	public LoginRespond() {
		super();
	}

	public LoginRespond(String resultMessage, SFB_Token logtoken) {
		super();
		this.resultMessage = resultMessage;
		this.logtoken = logtoken;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public SFB_Token getLogtoken() {
		return logtoken;
	}

	public void setLogtoken(SFB_Token logtoken) {
		this.logtoken = logtoken;
	}

	public LoginRespond(SFB_User token) {
		super();
	}

	public LoginRespond(SFB_Token token) {
		super();
		this.logtoken = token;
	}
     
     
}
