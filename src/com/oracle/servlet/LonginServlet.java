package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.parser.Token;

import com.google.gson.Gson;

import com.oracle.entity.SFB_Token;
import com.oracle.entity.SFB_User;

import com.oracle.service.LoginService;
import com.oracle.vo.LoginRequset;
import com.oracle.vo.LoginRespond;

public class LonginServlet extends HttpServlet {

	private Gson gson = new Gson();

	/**
	 * Constructor of the object.
	 */
	public LonginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//解析JSON
		String json = request.getParameter("JSON");
		System.out.println(json);
		LoginRequset lg = gson.fromJson(json, LoginRequset.class);   
		//将解析后的JOSN封装成对象
		SFB_User user = lg.getUser();
		if(lg.getToken()!=null){
			
			//判断token令牌值是否与memcache中token的值相等
			//如果相等 -------
			if(lg.getToken().getToken()!=null){
				
			}else{
				
				
			}
//			if(user.getUsername().equals("123")&&user.getPassword().equals("123")){
//				LoginRespond lr = new LoginRespond();
//				String resultMessage = "ok";
//				lr.setResultMessage(resultMessage);
//				String json1 = gson.toJson(lr);
//				System.out.println(json1);
//				out.write(json1);
//				out.flush();
//				out.close();
//			}
		}else{
			  /**
			   * 连接Service
			   */
			    LoginService loginService = new LoginService();
			    List<SFB_User> list=null;
			    LoginRespond lr = new LoginRespond();
			    try {
			    	 list=loginService.SelectService(user);
			    	//判断数据库是否有返回值
			    	if(list.size()>0){	
			    		String resultMessage = "ok";
			    	
			    		lr.setResultMessage(resultMessage);
			    		//生成Token令牌
			    		 String token = UUID.randomUUID().toString();
			    		 //将令牌存入SFB_Token.token对象中
			    		 SFB_Token sfb_Token = new SFB_Token();
			    		 sfb_Token.setToken(token);
			    		 lr.setLogtoken(sfb_Token);
			    		//将字符串封装成JSON形式返回
			    		String json1=gson.toJson(lr);
			    	} else{
			    		String resultMessage = "no";
			    		lr.setResultMessage(resultMessage);
			    		//将字符串封装成JSON形式返回
			    		String json1=gson.toJson(lr);
			    	}
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    
			
		}


	}
}
