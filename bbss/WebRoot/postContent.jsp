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
		<title>IT黑洞--帖子内容</title>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/postContent.css"/>
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
					<a href="register.html" >${existUser.name}</a>
					<span> | </span>
					<a href="${pageContext.request.contextPath}/question_toposted.action">发 帖</a>
					<span> | </span>
					<a href="main.html">返 回</a>
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
				
				<!-----------------------------------帖子内容-------------------------------------->
				<div id="postContent">
					<div id="post_title">帖 子 标 题 ： ${question.title}</div>
					<div id="post_content"><span>帖 子 内 容 ：  </span> ${question.content }</div>
					
				</div>
				<input type="button" name="pre" id="pre" value="上一个" />
				<input type="button" name="next" id="next" value="下一个" />
				<br>
			<c:if test="${replyList!=null}">
				<c:forEach items="${replyList}" var="a" varStatus="number">
				<div class="pinglun">
				${number.count}L.&nbsp;${a.user.name}&nbsp;
			    <!-- 判断是否是二级评论 -->
			    <c:if test="${a.touser!=null}">
			    <!-- 用户1 回复 用户2 ：内容  -->
			    	<c:forEach items="${touserList}" var="b">
			    		<c:if test="${b.uid==a.touser}">@${b.name}</c:if>
			    	</c:forEach>
			    </c:if>
			   :&nbsp;${a.content }
			    &nbsp;&nbsp;<a class="huifu" href="javascript:void(0)" onclick="replyshow('${number.count}')" >回复</a>
			</div>
			    <!-- 发表评论的隐藏的输入框 -->
			    <div>
			 		<div id="reply${number.count}" class="reply" style="display: none;">
			 			<form action="${pageContext.request.contextPath }/reply_save.action" method="post">
						<input hidden="hidden" name="qid" value="${qid }"/>
						<input hidden="hidden" name="touser" value="${a.user.uid}"/>
						<div>
							<div class="faBiaoPingLun">
								<textarea class="huifu_text" cols="60" rows="4" name="content"></textarea><br>
								<button class="huifu_submit" id="submit">发表评论</button>
								<button class="huifu_submit" id="submit">取消评论</button>
							</div>
							
						</div>
						</form>
			 		</div>
			    </div>
			</c:forEach>
		</c:if>
		<div
		
>
			<c:if test="${replyList==null}">
				暂无用户评论
			</c:if>
		</div>
				<%-- <ul id="pc_ul">
				<c:forEach var="l" items="${replyList }">
				
					<li>${l.user.name}:${l.content}</li><span id="huifu">回复</span>
					
					<li> ${existUser.name }:@ ${l.user.name } ${content }</li>
				
					
			 		<form action="${pageContext.request.contextPath }/reply_save.action" id="huifuForm" method="post">
						<input hidden name="qid" value="${quesiton.qid }">
						<input hidden name="touser" value="${a.user.uid}">
						<textarea name="content" id="huifuContent"></textarea>
						<input type="submit" id="huifuSubmit" value=" 提 交 " />
					</form> 
				</c:forEach>
				</ul>--%>
				<div>
				<form action="${pageContext.request.contextPath }/reply_save.action?qid=${question.qid}" method="post">
				<textarea name="content" cols="100" rows="6" placeholder="评论" id="faBiao"></textarea><br>
					<button class="huifu_submit" id="submit">发表</button>
					<button class="huifu_submit" id="quxiao">取消</button>
				</form> 
				</div>
			</main>
				
			<!-------------------------------------------底部----------------------------------------------->
			<footer id="footer">
					<p>Copyright @ 2017 IT黑洞小组</p>
			</footer>
		</div>	
			<script type="text/javascript">
			
			function replyshow(id){
				var alldiv = document.getElementsByClassName('reply');
				for(var i=0;i<alldiv.length;i++){
					alldiv[i].style.display="none";
				}
				var div  = document.getElementById("reply"+id);
				div.style.display="block";
			}
		
		</script>
	</body>
</html>
<script src="js/index.js"></script>
<script src="js/postContent.js"></script>