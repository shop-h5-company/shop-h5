<%--
  Created by IntelliJ IDEA.
  User: zhaozizhen
  Date: 2016/7/4
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../common/include.jsp"%>
    <title>修改登录密码</title>
</head>
<body>
<section class="main">
<form id="mForm">
    <ul class="login login_css">
        <li>
        	<span>旧密码</span>
            <input type="password" autocomplete="on" id="oldPassword" name="oldPassword" maxlength="16" placeholder="请输入旧密码"/>
        </li>
        <li>
        	<span>新密码</span>
            <input type="password" autocomplete="on" id="password" name="password" maxlength="16" placeholder="请输入新密码"/>
        </li>
        <li>
                <span>手机验证</span>
                <input class="textbox" type="tel" maxlength="11" id="verifyCode" name="verifyCode" placeholder="验证码"  value=""/>
                <input id="getVerifyCode" type="button" onclick="getVerifyCode2();" style=" position: absolute;
							    height: 50%;top: 20px;
							    font-size: 15px;    margin-left: -5%;
							    background-color: #e2ebd4;color: black;
							    font-family: 仿宋;" value="获取验证码"></input>
        </li>
    </ul>
    <a id="set_password" class="confirm" href="javascript:void(0)">确定</a>
</form>
</section>
<div class="mask"></div>
<div class="error_timeout"></div>
<script type="text/javascript">
    $(function () {
        $('#set_password').on('click', function () {
            startRegister();
        });
    });

    //验证密码
    function check_password() {
    	var vcode = $("#verifyCode").val();
    	
        var oldPassword = $("#oldPassword").val();
        var password = $("#password").val();
        var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{0,100}$/;
        if ('' == oldPassword) {
            layer.open({
	            content: '您的旧密码不能为空，请输入！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if('' == password){
        	layer.open({
	            content: '您的新密码不能为空，请输入！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if (reg.test(password) == false) {
            layer.open({
	            content: '请输入6位~16位字母和数字组合！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if(oldPassword == password){
        	layer.open({
	            content: '新密码不能与旧密码相同！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if (oldPassword.length < 6 || oldPassword.length > 16) {
        	layer.open({
	            content: '密码长度不能小于6位或大于16位！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if (password.length < 6 || password.length > 16) {
        	layer.open({
	            content: '密码长度不能小于6位或大于16位！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if (vcode == null || vcode == "") {
        	layer.open({
	            content: '手机验证码不能为空！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        return true;
    }
    function check_from() {
        if (!check_password()) {
            return false;
        }
        return true;
    }

    function startRegister() {
        if (!check_from()) {
            return;
        }
        var vcode = $("#verifyCode").val();
        $.post('/user/changePwd', $('#mForm').serialize(),
        function (result) {
            var result = eval('(' + result + ')');
            if (result.code == 1) {
	            layer.open({
				    content: "恭喜您，账户密码修改成功！",
				    btn: ['确定'],
				    shadeClose: false,
				    yes: function(){
				    	window.location.href = "../user/personalSet";
				    }
				});
            }else{
            	layer.open({
		            content: result.msg,
		            btn: ['确定'],
				    shadeClose: false,
				    yes: function(index){
				    	layer.close(index);
				    }
		        });
            }
        }, 'json');
    }
    /**
    	获取手机验证码
    */
	function getVerifyCode2(){
		var flag2 = new Boolean(false);
		$.post('/user/getVerifyCode?mobile=${mobile}',
		        function (result) {
			var a = result.flag;
			flag2 = new Boolean(a);
			layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: result.msg
            });
		        }, 'json');
			
			if(flag2){ //不能用flag2 == true 比较。 上面定义一个布尔变量的方式也要注意。大概是js版本问题。
				//开始60秒倒计时，此时不能再次请求验证码
				var countdown=60;
			    settime();
			    function settime() {
			        if (countdown == 0) {
			            $("#getVerifyCode").removeAttr("disabled"); 
			            $("#getVerifyCode").val("重新发送");
			            countdown = 60;
			            return; //重新赋值、return,如果不写，会有问题。
			        } else {
			            $("#getVerifyCode").attr("disabled",true);
			            $("#getVerifyCode").val("(" + countdown + ") s ");
			            countdown--;
			        }
			        setTimeout(function() {
			                    settime() }
			                ,1000)
			    }
			}
	}
    
</script>
</body>
</html>