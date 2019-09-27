package com.oracle.dao;


import com.oracle.entity.SFB_User;
import com.oracle.util.DataSourceUtils;

public class RegisterDao {
	  DataSourceUtils db = new DataSourceUtils();
	public int RegisterDao(SFB_User user) {
		String sql ="insert into user (username,password) values (?,?)";
		int no = DataSourceUtils.excuteUpdate(sql,user.getUsername(),user.getPassword());
		return no;
		
	}

}
