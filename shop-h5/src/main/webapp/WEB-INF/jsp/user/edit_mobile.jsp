<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="../common/include.jsp" %>
    <title>变更手机号</title>
</head>
<body>
<section class="main maxH">
<form id="myRForm">
    <div class="top" id="phoo" style="">
        <span>当前手机号： <span class="darkgray">${mobile}</span></span>
    </div>
	<div class="top" id="ph" style="display:none;">
        <span>已向您的手机 <span class="blue" id="mobile"></span> 发送验证码</span>
    </div>
    <ul class="login login_css">
        <li>
            <span>登录密码</span>
            <input class="" id="passWord" name="passWord" type="passWord" value="" maxlength="16" placeholder="请输入登录密码">
        </li>
        <li>
            <span>新手机号</span>
            <input class="" id="phone" name="phone" type="tel" value="" maxlength="11" placeholder="请输入新手机号">
        </li>
        <li>  
            <span class="message_code">验证码</span>
            <input id="phoneCode" name="phoneCode" type="text" maxlength="4" value="" placeholder="请输入验证码">
            <a class="btnRed btnRed2 again auth_code" id="getRecode" onclick="getRecode();"><font id="phonetext">获取验证码</font><font id="phoneCodeSent" color="#d44032"></font></a>
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
                content: "请输入手机验证码！",
                btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
            });
            return false;
        } else {
            return true;
        }
    }

	//验证手机号
    function check_phone() {
        var phone = $("#phone").val();
        var reg = /^1\d{10}$/;
        if (phone == "") {
            layer.open({
                content: "请输入手机号码！",
                btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
            });
            return false;
        }
        if(reg.test(phone) === false){
			layer.open({
	            content: "手机号码输入不合法！",
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
			return false;
		}
		var flag=false;
        $.ajax({
        	url:'/user/validatePhone',
        	type:'post',
        	dataType:'json',
        	data:$('#myRForm').serialize(),
        	async:false,
        	success:function(result){
	        	var result = eval('(' + result + ')');
	           	if(result.msg == 'false'){
	            	layer.open({
			            content: "您输入的手机号码已被注册！",
			            btn: ['确定'],
					    shadeClose: false,
					    yes: function(index){
					    	layer.close(index);
					    }
		        	});
	            }else{
	            	flag=true;
	            }
        	},
        	error:function(resp){}
        })
        if(flag){
        	return true;
        }else{
        	return false;
        }
        return true;
    }
    //验证密码
    function check_password() {
        var password = $("#passWord").val();
		var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{0,100}$/;
        if ('' == password) {
        	layer.open({
	            content: '请输入登录密码！',
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
        var flag=false;
        $.ajax({
        	url:'/user/verifyPassword',
        	type:'post',
        	dataType:'json',
        	data:$('#myRForm').serialize(),
        	async:false,
        	success:function(result){
	        	var result = eval('(' + result + ')');
	           	if(result.msg == 'false'){
	            	layer.open({
			            content: "登录密码输入错误！",
			            btn: ['确定'],
					    shadeClose: false,
					    yes: function(index){
					    	layer.close(index);
					    }
		        	});
	            }else{
	            	flag=true;
	            }
        	},
        	error:function(resp){}
        })
        if(flag){
        	return true;
        }else{
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
        if (!check_phone()) {
            return false;
        }
        return true;
    }
	function check_fromSms() {
        if (!check_password()) {
            return false;
        }
        if (!check_phone()) {
            return false;
        }
        return true;
    }
    function startRegister() {
        if (!check_from()) {
            return false;
        }
        $.post('/user/modifyPhone', $('#myRForm').serialize(),
        function (result) {
            var result = eval('(' + result + ')');
            if (result.ret == '0000') {
	            layer.open({
				    content: "手机号修改成功！",
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
    	if (check_fromSms()) {
	        $.post('/user/smsPhoneCode',$('#myRForm').serialize(),
	        function (result) {
	            var result = eval('(' + result + ')');
	            var phoneNo=$("#phone").val();
	            if (result.ret == '0000') {
	            	$("#mobile").html(phoneNo);
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
    }
    
</script>
</body>
</html>