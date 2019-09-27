package com.oracle.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.dao.LoginDao;
import com.oracle.entity.SFB_User;
import com.oracle.vo.LoginRequset;

public class LoginService {
  /**
   * Token为空时 走SelectService方法
   * @param user
   * @return
   * @throws SQLException
   */
	public List<SFB_User> SelectService(SFB_User user) throws SQLException {
		LoginDao ld = new LoginDao();
		List<SFB_User> list=ld.SelectLogin(user);
		return list;

	}
}