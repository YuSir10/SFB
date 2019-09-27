package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.oracle.entity.SFB_Token;
import com.oracle.entity.SFB_User;
import com.oracle.service.RegisterService;

public class RegisterServlet extends HttpServlet {
	private Gson gson = new Gson();

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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
	 * 1.获取 用户名 密码 2.短信返回 验证 3.连接Service
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
		SFB_Token re = new SFB_Token();//
		String json = request.getParameter("json");
		SFB_User user = gson.fromJson(json, SFB_User.class);
		/**
		 * 判断验证码是否正确 如果正确 连接Service 如果错误把错误信息返回界面
		 */
//		if (user.getNote() != null) {
//			RegisterService rs = new RegisterService();
//			int no = rs.RegisterService(user);
//			/**
//			 * 判断是否注册成功
//			 */
//			if (no >0) {
//				re.setResult("注册成功");
//				String json1 = gson.toJson(re);
//				out.write(json1);
//
//			} else {
//				re.setResult("注册失败");
//				String json1 = gson.toJson(re);
//				out.write(json1);
//			}
//
//		} else {
//			re.setResult("验证码错误");
//			String json1 = gson.toJson(re);
//			out.write(json1);
//		}
//
//		out.flush();
//		out.close();

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
