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
			<!-------------------------------------------头部----------------------------------------------->
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
				<!-----------------------------------当地天气-------------------------------------->
				<div id="weather">
			    	<iframe style="float: right;" width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
			    </div>
			    
				<!-----------------------------------时钟部分-------------------------------------->
				<canvas id="clock" width="100" height="100"></canvas>
				
				<!------------------------------------管理员--------------------------------------->
				<ul id="main_ul1">
					<li>【 用 户 信 息 】</li>
					<c:forEach items="${ulist}" var="u">
					<input type="checkbox" name="cb1" id="cb1" value="" />
					<label name="cb1">${u.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${u.role }</label><a href="${pageContext.request.contextPath }/manager_udelete.action?uid=${u.uid}">删除</a>
					<a href="${pageContext.request.contextPath }/manager_toEdit.action?uid=${u.uid}">编辑</a>
					 <br />
					</c:forEach>
				</ul>
				<ul id="main_ul3">
					<li>【 最 新 主 题 】</li>
					<c:forEach items="${qlist }" var="q">
					<input type="checkbox" name="zhuti1" id="zhuti1" value="" />
					<label name="zhuti1">${q.title }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${q.wtime }</label><a href="${pageContext.request.contextPath }/manager_qdelete.action?qid=${q.qid}">删除</a>
					<a href="${pageContext.request.contextPath }/manager_toQuestion.action?qid=${q.qid}">编辑</a><br>
					</c:forEach>
				</ul>
			
			</main>
				
			<!-------------------------------------------底部----------------------------------------------->
			<footer id="footer">
					<p>Copyright @ 2017 IT黑洞小组</p>
			</footer>
		</div>	
		
	</body>
</html>

<script src="js/index.js"></script>
