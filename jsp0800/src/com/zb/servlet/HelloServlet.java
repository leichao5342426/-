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
		u.setName("高晓松");
		
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("a", "高晓松");
		param.put("b", "在教室");
		param.put("c", "看堃哥上课");
		
		
		request.setAttribute("users", u);
		
		request.setAttribute("name", "周杰伦");
		request.getSession().setAttribute("name", "周润发");
		this.getServletContext().setAttribute("name", "周黑鸭");	
		
		request.setAttribute("param", param);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
