<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/7/4
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微联盟</title>
    <%@ include file="../common/include.jsp"%>
</head>
<body>
<section class="main" id="">
    <div class="total_plus gross_assets">
        <div class="total_assets total_plus gross_assets"><br/><br/><br/><br/>
            <span style="font-size: x-large;font-family: 仿宋;margin-left: 20%;" >剩余可邀请人数：&nbsp;${inviteNum}</span><br/><br/>
            <c:if test="${inviteNum < 10 }">
            	<span style="font-size: 15px;font-family: 仿宋;margin-left: 28%;">权限验证码已不足10名</span><br/><br/>
            </c:if>
            <span style="font-size: 15px;font-family: 仿宋;margin-left: 8%;">请联系QQ：726935697 或微信：1891104999 进行购买</span><br/><br/>
            <span style="font-size: 15px;font-family: 仿宋;margin-left: 28%;">客服微信号：&nbsp;&nbsp;&nbsp;18911049994</span>
            <a href="/user/index">
                <ul class="earnings_p">
                </ul>
            </a>
        </div>
        <form id="myForm">
            <ul class="login_main login_special">
                <input type="hidden" id="backUrl" value="${backUrl}"/>
                <li>
                    <span class="pwd"></span>
                    <input class="textbox" type="input" id="inviteAuthorityCode"  maxlength="16"  name="inviteAuthorityCode"  placeholder="邀请权限码" style="width:4.2rem"/>
	            	<a style="position: absolute;top: 1px;color:green;" id="registerNew" onclick="jihuo();">立即激活</a>
                </li>
            </ul>
	        <ul class="login_quick">
	        </ul>
	    </form>
        <div class="weixincode" >
            <div class="code" style="float: left;width: 42%;    margin-left: 8%;">
		        <img  src="/res/image/weixin.jpg" alt="微信"><br/><br/>
		        <a style="margin-left: 36%;color: steelblue;font-family: 仿宋;" href="/login/weixinBuy">微信购买</a>
		    </div>
		    <div class="code" style="float: left;width: 42%;">
		        <img  src="/res/image/qq.jpg" alt="qq"><br/><br/>
		        <a style="margin-left: 36%;color: steelblue;font-family: 仿宋;" href="/login/aliBuy">支付宝购买</a>
		    </div>
        </div>
    </div>
</section>
<!-- 底部 -->
<script>
    var footSelect = "house";
    function jihuo(){
    	var inviteAuthorityCode = $("#inviteAuthorityCode").val();
    	if(inviteAuthorityCode == ""){
    		alert("不能为空");
    		return;
    	}
    	$.post('/invite/activateAuthorityCode?inviteAuthorityCode='+inviteAuthorityCode,
  			   function(data){
      				if(data.result == true){
  						/* $("#jieshou"+userId).text("已审核");
  						$("#jujue"+userId).hide(); */
  						location.reload(); //刷新当前页面，类似浏览器的刷新
  						alert(data.msg);
  						/* location.href="/invite/inviteList?currentUserId="+userId; */
      				}else{
      					alert(data.msg);
      				}
  			   },
  			"json");
    }
</script>
<%@ include file="../common/footer.jsp"%>
</body>
</html>