<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>IT黑洞--注册</title>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="css/register.css"/>
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
					<a href="index.html">返 回</a>
					<span> | </span>
					<a href="login.html">登 录</a>
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
				
				<!-----------------------------------注册窗口-------------------------------------->
				<form id="register_form" name="register_form" action="${pageContext.request.contextPath }/user_regist.action" method="post">
					<p id="register_p1">注 册</p>
					
					<label>手机号：</label>
					<input name="num" type="text" placeholder="请输入手机号" id="register_tel" /><br />
					<span id="span1"></span>
					<label>用户名：</label>
					<input name="name" type="text" placeholder="请输入用户名" id="register_name" /><br />
					<label>验证码：</label>
					<input name="checkcode" type="text" placeholder="请输入验证码" id="register_identify" /><br />
					<img id="checkImg" class="captchaImage" src="${pageContext.request.contextPath}/checkAction.action"  onclick="change()"  title="点击更换验证码" />
					<div id="checkDiv">${registmessage}</div>
					<label>密 码：</label>
					<input name="pwd" type="password" placeholder="请输入密码" id="register_password" /><br />
					<label>确认密码：</label>
					<input name="epwd" type="password" placeholder="请输入确认密码" id="register_again_password" /><br />
					<div><span id="span2"></span></div>
					<input type="submit" name="register_submit" id="register_submit" value="立 即 注 册" /><br><br>
					
					<p id="register_p2">点击"立即注册"，表示您同意并愿意遵守《IT黑洞--论坛之家法律声明》</p>
				</form>
				
			</main>
				
			<!-------------------------------------------底部----------------------------------------------->
			<footer id="footer">
					<p>Copyright @ 2017 IT黑洞小组</p>
			</footer>
		</div>	
	</body>
</html>

<script type="text/javascript" charset="utf-8">
/* 	$(function(){
	$('#register_tel').blur(function(){
		console.log("123");
	});
	});
	
			$(function(){
			$.get('${pageContext.request.contextPath}/user_findByName.action.action');
		}); */
		$('#register_again_password').blur(
		function(){
			if($('#register_password').val()!=$('#register_again_password').val()){
				$('#span2').html("两次密码输入不一致");
			}
		}
		);
	  $(function(){
	$('#register_tel').blur(function(){
		var num = $('#register_tel').val();
		$.get(
		"${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&num="+num,
		function(data){
		$('#span1').html(data);
		}
		);
	}); 
	}); 
	function change(){
		var img1 = document.getElementById("checkImg");
		img1.src="${pageContext.request.contextPath}/checkAction.action?"+new Date().getTime();
	}
</script>


<script src="js/index.js" type="text/javascript" charset="utf-8">
	
</script>