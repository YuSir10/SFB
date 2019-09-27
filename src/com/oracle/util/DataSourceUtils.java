package com.oracle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 访问数据库工具类
 * @author Administrator
 *
 */
public class DataSourceUtils {
	static String driverName ;
	static String url ;
	static String user ;
	static String pass ;
	static Connection con;
	private static BasicDataSource dataSource = new BasicDataSource();
	static {	
		
		driverName = "com.mysql.jdbc.Driver";
		url ="jdbc:mysql://localhost:3306/work";
		user="root";
		pass ="mysql";
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(pass);
	}	
	
	
	public static BasicDataSource getDataSource(){
		return dataSource;
		
		
	}
	public static  Connection getConnection () {		
		try {
			//Class.forName( driverName );
			//con = DriverManager.getConnection(url, user, pass);	
			con = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con ;
	}
	/**
	 * 执行 更新操作   update  insert  delete
	 * @param sql  sql语句
	 * @param obj  动态数组 
	 * @return
	 */
	public static int excuteUpdate( String sql ,Object ... obj ){
		con = getConnection ();
		try {
			PreparedStatement prep = con.prepareStatement( sql);
			for (int i = 0; i < obj.length; i++) {
				prep.setObject( (i+1) , obj[i] );				
			}					
			//4. 让数据库执行并返回结果集
			return  prep.executeUpdate( );			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 执行检索操作  select
	 * @param sql  sql语句
	 * @param obj  动态数组 
	 * @return
	 */
	public static ResultSet excuteQuery( String sql ,Object ... obj ){
		con = getConnection ();
		try {
			PreparedStatement prep = con.prepareStatement( sql);
			//if (obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					prep.setObject( (i+1) , obj[i] );				
				}
			//}
			
			
			//4. 让数据库执行并返回结果集
			return  prep.executeQuery( );
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		System.out.println(DataSourceUtils.getConnection());
	  String insert ="insert into tb_student (studentId,username) values (null,?)";
	  System.out.println(DataSourceUtils.excuteUpdate(insert, "张三"));
	}
}
