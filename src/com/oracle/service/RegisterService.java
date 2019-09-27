package com.oracle.service;

import com.oracle.dao.RegisterDao;
import com.oracle.entity.SFB_User;
public class RegisterService {

	public int RegisterService(SFB_User user) {
		RegisterDao rd = new RegisterDao();
		int no= rd.RegisterDao(user);
		return no;
	}
 
}
