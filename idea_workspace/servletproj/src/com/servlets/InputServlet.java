package com.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/add")
public class InputServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��������ı���
		req.setCharacterEncoding("UTF-8");
		// ������Ӧ�ı���
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		int result = num1 + num2;
		PrintWriter out = resp.getWriter();
		out.println("<h1>����֮��Ϊ��" + result + "</h1>");
		req.getSession().setAttribute("result", result);
		//����������ת��δ��������ֻ���ƽ�����Ȩ��URL����
        RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/show.jsp");
		dispatcher.forward(req,resp);
		
		//�ͻ�����ת���൱�ڷ����µ�����URL�ı�
//		resp.sendRedirect("show.jsp");
		out.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}