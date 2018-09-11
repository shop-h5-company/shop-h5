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
    <title>设置提现密码</title>
</head>
<body>
<section class="main maxH">
<form id="myRForm">
	<div class="top" id="phoo" style="">
        <span>当前手机号： <span class="blue">${mobile}</span></span>
    </div>
	<div class="top" id="ph" style="display:none;">
        <span>已向您的手机 <span class="blue">${mobile}</span> 发送验证码</span>
    </div>
    <ul class="login login_css">
        <li>  
            <span class="message_code">验证码</span>
            <input id="phoneCode" name="phoneCode" type="text" maxlength="4" value="" placeholder="请输入验证码">
            <a class="btnRed btnRed2 again auth_code" id="getRecode" onclick="getRecode()"><font id="phonetext">获取验证码</font><font id="phoneCodeSent" color="#d44032"></font></a>
        </li>
        <li style="height: 0.10rem; background-color: #f2f2f2"></li>
        <li class="login_pwd_li">
            <span>设置密码</span>
            <input type="tel" id="oldpwd" name="" maxlength="6" placeholder="请输入提现密码，6位数字"/>
        </li>
        <li class="login_pwd_li">
            <span>重复密码 </span>
            <input type="tel" id="newpwd" name="password" maxlength="6" placeholder="请再次输入提现密码"/>
        </li>
    </ul>
    <a id="doRegister" class="confirm" href="javascript:void(0)">确定</a>
    </form>
</section>
<div class="mask"></div>
<div class="error_timeout"></div>
<script type="text/javascript">
	style="display: none;"
    $(function () {
        $('#doRegister').on('click', function () {
            startRegister();
        });
    });
    //验证短信验证码
    function check_smsCode() {
        var phoneCode = $("#phoneCode").val();
        if (phoneCode == "") {
            layer.open({
                btn: ['<span class="single">确定</span>'],
                content: '<div class="redrule"><p style="color: #4e9be9;text-align: center;">请输入手机验证码！</p></div>'
            });
            return false;
        } else {
            return true;
        }
    }

    //验证密码
    function check_password() {
        var oldpwd = $("#oldpwd").val();
        var newpwd = $("#newpwd").val();
        var reg = /^\d{6}$/;
        if ('' == oldpwd) {
        	layer.open({
	            content: '请输入提现密码，6位数字！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if(oldpwd != newpwd){
        	layer.open({
	            content: '两次密码必须相同！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if (oldpwd.length != 6) {
        	layer.open({
	            content: '提现密码必须为六位数字密码！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if(reg.test(oldpwd) == false){
        	layer.open({
	            content: '提现密码必须为六位数字密码！',
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
        if (!check_smsCode()) {
            return false;
        }
        if (!check_password()) {
            return false;
        }
        return true;
    }

    function startRegister() {
        if (!check_from()) {
            return;
        }
        $.post('/user/setWithdrawPwd', $('#myRForm').serialize(),
        function (result) {
            var result = eval('(' + result + ')');
            if (result.ret == '0000') {
	            layer.open({
				    content: "恭喜您，提现密码设置成功！",
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
    
    function getRecode() {
        $.post('/user/smsCode',
        function (result) {
            var result = eval('(' + result + ')');
            if (result.ret == '0000') {
            	$("#ph").show();
            	$("#phoo").hide();
            	_clocking("getRecode", 60);
            } else {
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
</script>
</body>
</html>