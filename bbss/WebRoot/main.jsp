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
		<meta http-equiv="Cache-Control" content="no-cache">
		<title>IT黑洞--论坛之家</title>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/main.css"/>
		<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
	</head>
	<body>
		
		<div id="all">
			<!-------------------------------------------头部----------------------------------------------->
			<header id="header">
				<img id="header_img1" src="img/Logo.png"/>
				<p id="header_p1">IT黑洞--论坛之家</p>
				
				<!-----------------------------------搜索框-------------------------------------->
				<form id="header_form" name="header_form" action="${pageContext.request.contextPath }/question_search.action" method="post">
					<input name="title" type="text" name="header_search" id="header_search" placeholder="请输入您要搜索的内容" />
					<button type="submit"id="header_submit"><img src="img/search.png"></button>
				</form>
				
				<div id="header_RL">
					<a href="" >${existUser.name}</a>
					<span> | </span>
					<a href="${pageContext.request.contextPath }/question_toposted.action">发 帖</a>
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
				
				<!-----------------------------------帖子部分-------------------------------------->
				<ul id="main_ul1">
					 <c:forEach var="l" items="${pageBean.list}">
					<li><a href="${pageContext.request.contextPath }/question_topostContent.action?qid=${l.qid}">${l.title}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${l.wtime }</a></li>
    								</c:forEach>
				
					<c:if test="${pageBean.currentPage!=1}">
						 <a href="${pageContext.request.contextPath}/question_listpage.action?currentPage=${pageBean.currentPage-1}"/>   前一页
					</c:if>
					<c:if test="${pageBean.currentPage!=pageBean.totalPage}">
					<a href="${pageContext.request.contextPath}/question_listpage.action?currentPage=${pageBean.currentPage+1}"/>
					后一页
						</c:if>
				</ul>
		<!-- 		<ul id="main_ul2">
					<li>【 最 多 评 论 】</li>
					<li><a href="postContent.html">Java -- SSH框架之详情&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017/05/02</a></li>
					<li><a href="postContent.html">JavaScript入门级介绍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017/05/02</a></li>
					<li><a href="postContent.html">vue.js框架实例&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017/05/02</a></li>
					<li><a href="postContent.html">论程序的腐蚀化&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017/05/02</a></li>
				</ul>
				<ul id="main_ul3">
					<li>【 新 闻 头 条 】</li>
					<li><a href="postContent.html">Java -- SSH框架之详情&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017/05/02</a></li>
					<li><a href="postContent.html">JavaScript入门级介绍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017/05/02</a></li>
					<li><a href="postContent.html">vue.js框架实例&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017/05/02</a></li>
					<li><a href="postContent.html">论程序的腐蚀化&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017/05/02</a></li>
				</ul> -->
			
			</main>
				
			<!-------------------------------------------底部----------------------------------------------->
			<footer id="footer">
					<p>Copyright @ 2017 IT黑洞小组</p>
			</footer>
		</div>	
		
	</body>
	<script type="text/javascript">
	$(function(){
		$.get("${pageContext.request.contextPath}/question_listpage.action");
	});
	</script>
</html>


<script src="js/index.js"></script>