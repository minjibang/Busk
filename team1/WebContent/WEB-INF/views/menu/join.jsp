<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="application/x-javascript">
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<script src="js/join.js"></script>

	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/signup_style.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/font-awesome.css" rel="stylesheet">
	<link href="css/font-awesome.css" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Merriweather+Sans:300,300i,400,400i,700,700i,800" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Mallanna" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Sansita:400,400i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
<!--//online_fonts-->
	<link href="css/signup_style.css" rel='stylesheet' type='text/css' media="all" /><!--stylesheet-->
</head>

<body>

	<!--Header-->
	<div class="top-bar_sub_w3layouts_agile">
		<% pageContext.include("/WEB-INF/views/include/topbar.jsp"); %>
	</div>
	<div class="header inner_banner" id="home">
		<!--/top-bar-->
		<% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
		<!--//top-bar-->
	</div>

	<!--/short-->
	<div class="services-breadcrumb-w3ls-agile">
		<div class="inner_breadcrumb">

			<ul class="short">
				<li><a href="main.busk">Home</a><span>|</span></li>
				<li>Join now</li>
			</ul>
		</div>
	</div>
	<!--//short-->





	<!--//Header-->
	<!--/inner_connectent-->
	<div class="banner_bottom">
		<div class="container">
			
			<div class="form-w3ls">
	<div class="form-head-w3l">
		<h2>signup</h2>
	</div>
    <ul class="tab-group cl-effect-4"  id="signlist">
        <li class="tab active"><a href="#signfan-agile">Sign Up As Fan</a></li><li class="tab"><a href="#signbusker-agile">Sign Up As Busker</a></li>        
    </ul>
    <div class="tab-content">
    
        <div id="signfan-agile">   
        
			<form action="joinconfirm.busk" method="post" id="insertform">			
				<p class="header">NickName</p>
				<input type="text" name="fanuser" id="fanuser" placeholder="Your NickName" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your NickName';}" required="required">

				<p class="header">Email Address</p>
				<input type="email" name="fanemail"  id="fanemail" placeholder="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="required" value="">
				<input type="button" name="fanemailjb" id="fanemailjb"value="중복확인">
				<input type="hidden"  id="emailjbhidden" name="emailjbhidden" value="N">
				<input type="hidden"  id="fancurrentemail" name="fancurrentemail" value="">
				<input type="button" name="emailconfirm_btn" value="인증메일 보내기" onclick="javascript:emailcheck(insertform.fanemail.value, insertform.emailhidden.value, insertform.usertype.value)">
				<input type="hidden"  id="emailhidden" name="emailhidden" value="N">
				<input type="hidden"  id="usertype" name="usertype" value="fan">
				
				<p class="header">Password</p>
				<input type="password" name="fanpassword" id="fanpassword" placeholder="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="required">
				
				<p class="header">Confirm Password</p>
				<input type="password" name="fanconfirmpassword"  id="fanconfirmpassword" placeholder="Confirm Password" onkeyup="checkPwd()" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Confirm Password';}" required="required">
				<div id="checkPwd">동일한 암호를 입력하세요.</div> 
				<input type="button" class="register" value="Sign up"  id="fansubmit">				
			</form>
			
		</div>
		<div id="signbusker-agile">  
		 
			<form action="joinconfirm.busk" method="post" id="buskerinsertform">				
				<p class="header">NickName</p>
				<input type="text" name="user" id="buskeruser" placeholder="Your NickName" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your NickName';}" required="required">
				
				<p class="header">Email Address</p>
				<input type="email" name="email"  id="email" placeholder="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="required">
				<input type="button" name="buskeremailjb" id="buskeremailjb"value="중복확인">
				<input type="hidden"  id="emailjbhidden2"   name="emailjbhidden2" value="N">
				<input type="hidden"  id="buskercurrentemail" name="buskercurrentemail" value="">
				<input type="button" name="emailconfirm_btn" value="인증메일 보내기" onclick="javascript:emailcheck(buskerinsertform.email.value, buskerinsertform.emailhidden2.value, buskerinsertform.usertype2.value)">
				<input type="hidden"  id="emailhidden2"   name="emailhidden2" value="N">
				<input type="hidden"  id="usertype2" name="usertype2" value="busker">
				<p class="header">Password</p>
				<input type="password" name="password"  id="buskerpassword" placeholder="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="required">
				
				<p class="header">Confirm Password</p>
				<input type="password" name="password" id="buskerconfirmpassword" placeholder="Confirm Password" onkeyup="checkPwd2()" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Confirm Password';}" required="required">
				<div id="checkPwd2">동일한 암호를 입력하세요.</div> 
				<p class="header">File Upload</p>
				
				<input type="file"  id="video" name="video" value="upload" required="required">				
				<input type="button" class="register" value="Sign up" id="buskersubmit">
			</form>
			
		</div> 
    </div><!-- tab-content -->
</div> <!-- /form -->	  
			</div>
		</div>
	</div>
	<!--//inner_connectent-->
	<!--footer-->
	<div class="contact-footer-w3layouts-agile">
		<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
	</div>
	<!--/footer -->
	<!-- js -->

	<!-- signup_js -->
<script src='js/signup_jquery.min.js'></script>
<script src="js/signup_index.js"></script>
	<!-- //js -->
	<!--search-bar-->
	<script src="js/main.js"></script>
	<!--//search-bar-->
	<!-- start-smoth-scrolling -->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function ($) {
			$(".scroll").click(function (event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop: $(this.hash).offset().top
				}, 900);
			});
		});
	</script>
	<!-- start-smoth-scrolling -->
	<script type="text/javascript">
		$(document).ready(function () {
			/*
									var defaults = {
							  			containerID: 'toTop', // fading element id
										containerHoverID: 'toTopHover', // fading element hover id
										scrollSpeed: 1200,
										easingType: 'linear' 
							 		};
									*/

			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>


</body>
</html>