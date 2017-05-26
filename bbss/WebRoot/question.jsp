<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>IT黑洞--管理员</title>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/main.css"/>
		<link rel="stylesheet" type="text/css" href="css/manager.css"/>
	</head>
	<body background="img/theme.jpg">
		
		<div id="all">
			h<textarea rows="" cols=""></textarea><!-------------------------------------------头部----------------------------------------------->
			<header id="header">
				<img id="header_img1" src="img/Logo.png"/>
				<p id="header_p1">IT黑洞--论坛之家</p>
				
				<!-----------------------------------搜索框-------------------------------------->
				<form id="header_form" name="header_form">
					<input type="text" name="header_search" id="header_search" placeholder="请输入您要搜索的内容" />
					<button id="header_submit"><a href="#"><img src="img/search.png"></a></button>
				</form>
				
				<div id="header_RL">
					<a href="">管理员</a>
					<span> | </span>
					<a href="index.html">返 回</a>
					<span> | </span>
					<a href="" onclick="window.close()">退 出</a>
				</div>
				
				
			</header>
			<!-------------------------------------------主体----------------------------------------------->
			<main id="main">	
			<div>			
				<form action="${pageContext.request.contextPath }/manager_qupdate.action" method="post">	
				<input type="text" name="qid" value="${question.qid }" hidden><br>
				<input type="text" name="title" value="${question.title }"><br>
				<input type="text" name="wtime" value="${question.wtime }"><br>
				<input type="submit" value="修改">
				</form>
			</div>
			</main>
				
			<!-------------------------------------------底部----------------------------------------------->
			<footer id="footer">
					<p>Copyright @ 2017 IT黑洞小组</p>
			</footer>
		</div>	
		
	</body>
</html>

<script src="js/index.js"></script>
