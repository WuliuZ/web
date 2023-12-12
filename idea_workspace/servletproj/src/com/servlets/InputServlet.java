package com.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/add")
public class InputServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求的编码
		req.setCharacterEncoding("UTF-8");
		// 设置响应的编码
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		int result = num1 + num2;
		PrintWriter out = resp.getWriter();
		out.println("<h1>二数之和为：" + result + "</h1>");
		req.getSession().setAttribute("result", result);
		//服务器端跳转：未发起请求，只是移交控制权。URL不变
        RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/show.jsp");
		dispatcher.forward(req,resp);
		
		//客户端跳转：相当于发起新的请求。URL改变
//		resp.sendRedirect("show.jsp");
		out.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}