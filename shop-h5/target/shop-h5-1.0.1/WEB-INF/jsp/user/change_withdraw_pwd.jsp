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
    <title>修改提现密码</title>
</head>
<body>
<section class="main">
<form id="mForm">
    <ul class="login login_css login_pwd">
        <li>
        	<span>旧密码</span>
            <input type="tel" autocomplete="on" id="oldPassword" name="oldPassword" maxlength="6" placeholder="请输入旧密码"/>
        </li>
        <li>
        	<span>新密码</span>
            <input type="tel" autocomplete="on" id="password" name="password" maxlength="6" placeholder="请输入新密码"/>
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
    	var reg = /^\d{6}$/;
        var oldPassword = $("#oldPassword").val();
        var password = $("#password").val();
        if ('' == oldPassword) {
        	layer.open({
	            content: '请输入旧密码！',
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
	            content: '请输入新密码！',
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
        if (oldPassword.length != 6) {
        	layer.open({
	            content: '提现密码为6位数字密码！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if (password.length != 6) {
        	layer.open({
	            content: '提现密码为6位数字密码！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
            return false;
        }
        if(reg.test(password) == false){
        	layer.open({
	            content: '提现密码为6位数字密码！',
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
        $.post('/user/editWithdrawPwd', $('#mForm').serialize(),
        function (result) {
            var result = eval('(' + result + ')');
            if (result.ret == '0000') {
            	layer.open({
				    content: "恭喜您，提现密码修改成功！",
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
</script>
</body>
</html>