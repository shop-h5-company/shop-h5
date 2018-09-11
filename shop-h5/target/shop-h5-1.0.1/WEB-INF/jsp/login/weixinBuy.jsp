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
	    </form>
        <div style="font-family: 仿宋;font-size: 20px;color: cornflowerblue;margin-left: 10%;">
	        <div style="float:left;">
	                 <input name="inviteCode" type="radio" value="20" />20元（20次）<br/>
	                 &nbsp&nbsp<span style="color: darkseagreen;">1元/次</span>
	        </div>
	        <div style="position: relative;margin-left: 45%;">
	                 <input name="inviteCode" type="radio" value="50" />40元（50次）<br/>
	                 &nbsp&nbsp<span style="color: darkseagreen;">8毛/次</span>
	        </div>
	        <div style="float:left;">
	                <input name="inviteCode" type="radio" value="100" />70元（100次）<br/>
	                &nbsp&nbsp<span style="color: darkseagreen;">7毛/次</span>
	        </div>
	        <div style="position: relative;margin-left: 45%;">
	                <input name="inviteCode" type="radio" value="200" />130元（200次）<br/>
	                &nbsp&nbsp<span style="color: darkseagreen;">6毛5/次</span>
	        </div>
	        <div style="float:left;">
	                <input name="inviteCode" type="radio" value="500" />260元（500次）<br/>
	                &nbsp&nbsp<span style="color: darkseagreen;">5毛2/次</span>
	        </div>
	        <div style="position: relative;margin-left: 45%;">
	                <input name="inviteCode" type="radio" value="1000" />450元（1000次）<br/>
	                &nbsp&nbsp<span style="color: darkseagreen;">4毛5/次</span>
	        </div>
        </div>
        <br/>
        	<input onclick="weixinBuy();" style="margin-left: 37%; color: red; font-family: 仿宋;" type="button" value="确认购买" /><br/><br/>
        <br/>
        <span>备注：首次购买，赠送当前购买次数一半的权限邀请码</span>
        <span>活动：买一送一</span>
    </div>
</section>
<!-- 底部 -->
<script>

	function weixinBuy(){
		var inviteCode = $("input[name='inviteCode']:checked").val();
		if(inviteCode == null){
			return;
		}
		alert(inviteCode);
	}

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