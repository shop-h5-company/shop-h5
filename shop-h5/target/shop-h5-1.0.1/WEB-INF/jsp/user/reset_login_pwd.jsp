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
    <title>重置登录密码</title>
</head>
<body>
<section class="main">
<form id="mForm">
    <ul class="login login_css">
        <li>
        	<span>手机号</span>
            <input type="text" autocomplete="on" id="mobile" name="mobile" maxlength="11" placeholder="请输入手机号"/>
        </li>
    </ul>
    <a id="set_reset" class="confirm" href="javascript:void(0)">确定</a>
</form>
</section>
<div class="mask"></div>
<div class="error_timeout"></div>
<script type="text/javascript">
    $(function () {
        $('#set_reset').on('click', function () {
            startReset();
        });
    });

    function startReset() {
        $.post('/user/resetPwd', $('#mForm').serialize(),
        function (result) {
            var result = eval('(' + result + ')');
            if (result.code == 1) {
	            layer.open({
				    content: "恭喜您，账户密码重置成功！",
				    btn: ['确定'],
				    shadeClose: false,
				    yes: function(){
				    	window.location.href = "../user/index";
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