package com.oracle.vo;

import com.oracle.entity.SFB_Token;
import com.oracle.entity.SFB_User;

public class LoginRequset {
    private  SFB_User   loguser;
    private  SFB_Token  logtoken;
    
	
	public LoginRequset(SFB_User user,SFB_Token token) {
		super();
		this.loguser = user;
		this.logtoken = token;
	}
	public SFB_User getUser() {
		return loguser;
	}
	public void setUser(SFB_User user) {
		this.loguser = user;
	}
	public SFB_Token getToken() {
		return logtoken;
	}
	public void setToken(SFB_Token token) {
		this.logtoken = token;
	}
    
}
