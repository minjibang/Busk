jQuery(document).ready(
		function($) {
			$("#fansubmit").click(function() {
				console.log($("#emailhidden").val());
				 var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
				if($("#fanuser").val()=="" || $("#fanuser").val()==null || $("#fanuser").val()=="Your NickName"){
					alert("이름을 입력하세요");
					$("#fanuser").focus();
				}
				else if ($("#fanpassword").val() != $("#fanconfirmpassword").val()) {
					alert("패스워드를 확인하세요");
					$("#fanconfirmpassword").focus();
				} else if ($("#emailhidden").val() == "N") {
					alert("메일인증을 시도하세요.");
				} else if ($("#fanemail").val() != $("#fancurrentemail").val()) {
					alert("이메일 중복확인을 시도하세요.");
					$("#emailjbhidden").val("N");
					$("#emailhidden").val("N");
				} else if (!reg_pwd.test($("#fanpassword").val())) {
					alert("패스워드는 영문 숫자를 혼합하여 6~20자리 이내로 입력하세요.");
					$("#fanpassword").focus();
				} else {
					$("#insertform").submit();
					alert("가입을 축하합니다.");
				}
			});

			$("#buskersubmit").click(function() {
						console.log($("#buskeruser").val());
						var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
						if($("#buskeruser").val()=="" || $("#buskeruser").val()==null || $("#buskeruser").val()=="Your NickName"){
							alert("이름을 입력하세요");
							$("#buskeruser").focus();
						}
						else if ($("#buskerpassword").val() != $("#buskerconfirmpassword").val()) {
							alert("패스워드를 확인하세요");
						} else if ($("#emailhidden2").val() == "N") {
							alert("메일인증을 시도하세요.");
						}else if ($("#email").val() != $("#buskercurrentemail").val()) {
							alert("이메일 중복확인을 시도하세요.");
							$("#emailjbhidden2").val("N");
							$("#emailhidden2").val("N");
						}else if ($("#video").val() == "") {
							alert("동영상파일을 업로드하세요.");
						} else if (!reg_pwd.test($("#buskerpassword").val())) {
							alert("패스워드는 영문 숫자를 혼합하여 6~20자리 이내로 입력하세요.");
							$("#buskerpassword").focus();
						}else {
							$("#buskerinsertform").submit();
							alert("가입을 축하합니다.");
						}
					});

			$("#fanemailjb").click(function() {
						console.log($("#fanemail").val() );
						var etest=/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
						if ($("#fanemail").val() == null || $("#fanemail").val() == "" ||$("#fanemail").val() =="Email") {
							alert("이메일을 입력해주세요");
							$("#fanemail").focus();
						}else if (!etest.test($("#fanemail").val())) {
							alert("이메일을 형식이 아닙니다.");
							$("#fanemail").focus();
						}else if($("#emailjbhidden").val()=="Y" && $("#fanemail").val() == $("#fancurrentemail").val() ){
							alert("이메일 인증이 이미 완료되었습니다.");
						} else {
							var data2 = {
								fanemailconfirm : $("#fanemail").val(),
								usertype : $("#usertype").val()
							};
							console.log($("#fanemail").val());
							$.ajax({
								url : "emailjb.busk",
								data : data2,
								dataType : "html",
								success : function(data) {
									console.log(data);
									if (data == "N") {
										alert("아이디 중복");
										$("#fanemail").focus();
										$("#emailjbhidden").val("N");
									} else {
										alert("아이디 사용 가능");
										$("#emailjbhidden").val("Y");
										$("#fancurrentemail").val($("#fanemail").val());
									}
								}
							});
						}
					});
			$("#buskeremailjb").click(function() {
				var etest=/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
				if ($("#email").val() == null || $("#email").val() == "" || $("#email").val() == "Email") {
					alert("이메일을 입력해주세요");
					$("#email").focus();
				}else if (!etest.test($("#email").val())) {
					alert("이메일을 형식이 아닙니다.");
					$("#email").focus();
				} else if($("#emailjbhidden2").val()=="Y" && $("#email").val() == $("#buskercurrentemail").val()){
					alert("이메일 인증이 이미 완료되었습니다.");
				}else {
					var data = {
						buskeremailconfirm : $("#email").val(),
						usertype2 : $("#usertype2").val()
					};
					$.ajax({
						url : "emailjb.busk",
						data : data,
						dataType : "html",
						success : function(data) {
							console.log(data);
							if (data == "N") {
								alert("아이디 중복");
								$("#fanemail").focus();
								$("#emailjbhidden2").val("N");
							} else {
								alert("아이디 사용 가능");
								$("#emailjbhidden2").val("Y");
								$("#buskercurrentemail").val($("#email").val());
							}
						}
					});
				}
			});

		});

function emailcheck(email, hidden, usertype) {
	if(usertype=="fan"){
		if($("#emailjbhidden").val() == "N" || $("#fanemail").val() != $("#fancurrentemail").val()){
			alert("이메일을 중복확인을 해주세요.");
		}else {
			console.log("새창으로 이동");
			console.log(hidden);
			var url = "emailCheck.jsp?email=" + email +  "&usertype=" + usertype;
			open(url, "emailwindow",
					"width=250, height=130, statusbar=no, menubar=no, scrollbars=no");
		}
	}else if(usertype=="busker"){
		if($("#emailjbhidden2").val() == "N" || $("#email").val() != $("#buskercurrentemail").val()) {
			alert("이메일을 중복확인을 해주세요.");
		}else {
			console.log("새창으로 이동");
			console.log(hidden);
			var url = "emailCheck.jsp?email=" + email + "&usertype=" + usertype;
			open(url, "emailwindow",
					"width=250, height=130, statusbar=no, menubar=no, scrollbars=no");
		}
	}

}

function checkPwd() {
	var pw1 = $("#fanpassword").val();
	var pw2 = $("#fanconfirmpassword").val();
	if (pw1 != pw2) {
		document.getElementById('checkPwd').style.color = "red";
		document.getElementById('checkPwd').innerHTML = "동일한 암호를 입력하세요.";
	} else {
		document.getElementById('checkPwd').style.color = "green";
		document.getElementById('checkPwd').innerHTML = "암호가 확인 되었습니다.";

	}

}

function checkPwd2() {
	var pw1 = $("#buskerpassword").val();
	var pw2 = $("#buskerconfirmpassword").val();
	if (pw1 != pw2) {
		document.getElementById('checkPwd2').style.color = "red";
		document.getElementById('checkPwd2').innerHTML = "동일한 암호를 입력하세요.";
	} else {
		document.getElementById('checkPwd2').style.color = "green";
		document.getElementById('checkPwd2').innerHTML = "암호가 확인 되었습니다.";

	}

}