package com.oracle.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import com.oracle.entity.SFB_User;
import com.oracle.util.DataSourceUtils;
import com.oracle.vo.LoginRequset;
/**
 * 
 * @author 1
 *
 */
public class LoginDao {
      public List<SFB_User> SelectLogin(SFB_User user) throws SQLException{
    	  DataSourceUtils db = new DataSourceUtils();
    		String sql = "select * from user where username=?and password=?";
    		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
    		List<SFB_User> list = qr.query(sql, new BeanListHandler<SFB_User>(SFB_User.class),user.getUsername(),user.getPassword());
			return list;
    		 
      }
	

}
