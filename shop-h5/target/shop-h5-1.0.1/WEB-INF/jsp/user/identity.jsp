<%--
  Created by IntelliJ IDEA.
  User: zhaozizhen
  Date: 2016/7/4
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../common/include.jsp"%>
    <%@ include file="../common/include_header.jsp"%>
    <title>设置身份信息</title>
</head>
<body>
<section class="main">
    <div class="waring">
        <i class="icon_waring"></i>为保证您的账户安全，充值前请先进行实名认证！
    </div>
    <ul class="login login_css">
        <li>
            <span>姓名</span>
            <span>
                <input type="text" autocomplete="on" name="userName" id="userName" value="${userName}" maxlength="14" placeholder="请输入真实姓名">
            </span>
        </li>
        <li>
            <span>身份证</span>
            <span>
                <input type="text" autocomplete="on" name="idCard" id="idCard" value="${idCard}" maxlength="18" placeholder="请输入身份证号码">
            </span>
        </li>
    </ul>
    <a href="javascript:void(0)" onclick="userForm()" class="confirm">确定</a>
</section>
<script type="text/javascript">
function userForm(){
	var username = $("#userName").val();
	var idcard = $("#idCard").val();
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	var pattern = /^\s*[\u4e00-\u9fa5]{2,7}$/;	
	if(username == ""){
		layer.open({
            content: "您的姓名不能为空，请输入！",
            btn: ['确定'],
		    shadeClose: false,
		    yes: function(index){
		    	layer.close(index);
		    }
        });
		return false;
	}
	if(pattern.test(username)==false){
		layer.open({
            content: "姓名输入不能低于2个汉字，不允许输入英文或数字！",
            btn: ['确定'],
		    shadeClose: false,
		    yes: function(index){
		    	layer.close(index);
		    }
        });
		return false;
	}
	if(idcard == ""){
		layer.open({
            content: "您的身份证不能为空，请输入！",
            btn: ['确定'],
		    shadeClose: false,
		    yes: function(index){
		    	layer.close(index);
		    }
        });
		return false;
	}
	if(reg.test(idcard) === false){
		layer.open({
            content: "您输入的身份证件号码有误，请重新输入！",
            btn: ['确定'],
		    shadeClose: false,
		    yes: function(index){
		    	layer.close(index);
		    }
        });
		return false;
	}
	$.ajax({
		url:'/user/addIdentity',
		type:'post',
		data:{"userName":username ,"idCard":idcard},
		async:false,
		dataType:'json',
		success:function(result){
			var result = eval('(' + result + ')');
			if (result.ret == '1') {
	            layer.open({
				    content: "身份信息保存成功！",
				    btn: ['确定'],
				    shadeClose: false,
				    yes: function(){
				    	window.location.href = "../user/personalSet";
				    }
				});
            }else if (result.ret == '2'){
            	layer.open({
		            content: result.msg,
		            btn: ['确定'],
				    shadeClose: false,
				    yes: function(index){
				    	layer.close(index);
				    }
	        	});
            }
		},
		error:function(res){}
	}) 
}
</script>
</body>
</html>