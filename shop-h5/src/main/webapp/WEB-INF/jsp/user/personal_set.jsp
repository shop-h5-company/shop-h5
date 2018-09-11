<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/include.jsp"%>
<%@ include file="../common/include_header.jsp"%>
<title>个人设置</title>
</head>
<body>
<section class="main">
    <div class="message">
        <div class="header">
        	<img src="/res/image/photo.png">
        </div>
        <ul class="meslist">
        	<c:if test="${userName == ''}">
        		<li>小安</li>
        	</c:if>
           <c:if test="${userName != ''}">
        		<li>${userName}</li>
        	</c:if>
           <li><span>${mobile}</span><!-- <a href="/user/modifyPhoneCode" class="modified">修改</a> --> </li>
        </ul>
    </div>
    <ul class="person">
<%--         <li>
            <i class="ico_set1"></i>
            <span>我的邀请码</span>
            <span class="ico_val">${user.hisInviteCode}</span>
        </li> --%>
        <c:if test="${isIdcheck == 'false' && idCard != ''}">
	        <li class="arrow_parent">
	            <a href="/user/identity">
	                <i class="ico_set2"></i>
	                <span>身份信息</span>
	                <span class="ico_val ab_arrow green">修改</span>
	                <em class="arrow"></em>
	            </a>
	        </li>
        </c:if>
        <c:if test="${isIdcheck == 'false' && idCard == ''}">
	        <li class="arrow_parent">
	            <a href="/user/identity">
	                <i class="ico_set2"></i>
	                <span>身份信息</span>
	                <span class="ico_val ab_arrow red">未认证</span>
	                <em class="arrow"></em>
	            </a>
	        </li>
        </c:if>
        <c:if test="${isIdcheck == 'true' && idCard != ''}">
        	<li class="arrow_parent">
	            <a href="/user/immutableIdentity">
	                <i class="ico_set2"></i>
	                <span>身份信息</span>
	                <span class="ico_val ab_arrow green">已认证</span>
	                <em class="arrow"></em>
	            </a>
	        </li>
        </c:if>
        <c:if test="${isIdcheck == 'true'}">
	        <li class="arrow_parent">
            <a href="/user/immutableCard">
                <i class="ico_set3"></i>
                <span>银行信息</span>
                <span class="ico_val ab_arrow green">已认证</span>
                <em class="arrow"></em>
            </a>
        </li>
        </c:if>
    </ul>
    <ul  class="person">
    	<%-- <c:if test="${paswd=='0'}">
	        <li class="arrow_parent">
	            <a href="/user/withdrawPwd">
	                <i class="ico_set4"></i>
	                <span>提现密码</span>
	                <span class="ico_val ab_arrow red">未设置</span>
	                <em class="arrow"></em>
	            </a>
	        </li>
        </c:if>
        <c:if test="${paswd!='0'}">
	        <li class="arrow_parent">
	            <a href="/user/changeWithdrawPwd">
	                <i class="ico_set4"></i>
	                <span>提现密码</span>
	                <span class="ico_val ab_arrow green">修改</span>
	                <em class="arrow"></em>
	            </a>
	        </li>
        </c:if> --%>
        <li class="arrow_parent">
            <a href="/user/loginPwd">
                <i class="ico_set4"></i>
                <span>登录密码</span>
                <span class="ico_val ab_arrow green">修改</span>
                <em class="arrow"></em>
            </a>
        </li>
        
        <c:if test="${user.jurisdiction == '7'}">
	        <li class="arrow_parent">
	                <i class="ico_set4"></i>
	                <span>您的微信号：</span>
	                <input id="weixinHao" style="background-color: antiquewhite;width: 40%;" value="${user.weixin}"></input>
	                <span onclick="updateWeixinHao();" class="ico_val ab_arrow green">修改</span>
	                <em class="arrow"></em>
	        </li>
        </c:if>
        <c:if test="${user.jurisdiction == '0'}">
	        <li class="arrow_parent">
	                <i class="ico_set4"></i>
	                <span>您的微信昵称：</span>
	                <input id="weixin" style="background-color: antiquewhite;width: 40%;" value="${user.userName}"></input>
	                <span onclick="updateWeixin();" class="ico_val ab_arrow green">修改</span>
	                <em class="arrow"></em>
	        </li>
        </c:if>
    </ul>
    <ul class="person">
        <!-- <li class="arrow_parent">
            <a href="/res/html/qc.html">
                <i class="ico_set5"></i>
                <span>常见问题</span>
                <em class="arrow"></em>
            </a>
        </li> -->
        <!-- <li class="arrow_parent">
            <a href="/res/html/about_us.html">
                <i class="ico_set6"></i>
                <span>关于我们</span>
                <em class="arrow"></em>
            </a>
        </li> -->
        <li>
            <i class="ico_set7"></i>
            <span>客服微信号：18911049994</span>
        </li>
    </ul>
    <ul class="unbind">
        <li><a href="/home/outLogin">退出登录</a></li>
    </ul>
    <!-- <ul class="unbind">
        <li><a href="/home/unbindWx">解绑微信自动登录</a></li>
    </ul> -->
</section>
<!-- 底部 -->
<script>
    var footSelect = "people";
    function updateWeixinHao(){
    	var weixinHao = $("#weixinHao").val();
    	$.post('/user/updateWeixinHao?weixinHao='+weixinHao,
 			   function(data){
     				if(data.result == true){
 						alert(data.msg);
     				}else{
 						alert("修改失败");
     				}
 			   },
 			"json");
    }
    function updateWeixin(){
    	var weixin = $("#weixin").val();
    	$.post('/user/updateWeixin?weixin='+weixin,
 			   function(data){
     				if(data.result == true){
 						alert(data.msg);
     				}else{
 						alert("修改失败");
     				}
 			   },
 			"json");
    }
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
</body>
</html>