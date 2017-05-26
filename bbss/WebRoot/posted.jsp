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
		<title>IT黑洞--发帖</title>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/posted.css"/>
		<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
	</head>
	<body>
		
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
					<a href="">${existUser.name}</a>
					<span> | </span>
					<a href="${pageContext.request.contextPath }/question_listpage.action">返 回</a>
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
				
				<!-----------------------------------发帖部分-------------------------------------->
				<div id="posted_box">
					<form action="${pageContext.request.contextPath }/question_save.action" method="post">
					<lable id="lable2">帖 子 标 题 ：</lable><br />
					<input name="title" type="text" placeholder="请输入标题" id="lable2_input" /><br />
					<label for="textarea" id="label">帖 子 内 容 ：</label>
				    <session id="session">(<span id="num">0</span>/1000)</session>
					<textarea name="content" id="textarea" placeholder="最多输入1000个字符"></textarea>
					<input type="submit" name="posted_ture" id="posted_ture" value=" 发 布 " />
					<input type="button" name="posted_false" id="posted_false" value=" 取 消 "/>
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
<script src="js/posted.js" type="text/javascript" charset="utf-8"></script>
