package com.zb.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zb.entity.Users;

public class HelloServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users u = new Users();
		u.setId(1);
		u.setName("������");
		
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("a", "������");
		param.put("b", "�ڽ���");
		param.put("c", "���Ҹ��Ͽ�");
		
		
		request.setAttribute("users", u);
		
		request.setAttribute("name", "�ܽ���");
		request.getSession().setAttribute("name", "����");
		this.getServletContext().setAttribute("name", "�ܺ�Ѽ");	
		
		request.setAttribute("param", param);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
