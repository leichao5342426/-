<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zb.entity.Users"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <!-- 用小脚本形式 输出user对象中id  name -->
    <%
    	Users u = (Users)request.getAttribute("users");
    	out.print(u.getId()+"     "+u.getName());
     %>
     
     
     <hr/>
     
     <!-- el表达式输出user对象中的id  name -->
     ${requestScope.users.id }   ${requestScope.users.name }
     <hr/>
     
     ${requestScope.name }${sessionScope.name }${applicationScope.name }
     <hr/>
     
     
     ${requestScope.param.a }${requestScope.param.b }${requestScope.param.c }
     
     
  </body>
</html>
