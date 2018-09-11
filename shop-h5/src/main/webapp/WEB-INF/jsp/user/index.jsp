<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/7/4
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="../common/include.jsp"%>
	<title>我的首页</title>
</head>
<script type="text/javascript">
function withdraw(){
	if("${isInvest}"=="no"){
		layer.open({
		    content: '您还未投资，暂不能提现，赶快去投资吧！',
		    btn: ['取消','立即投资'],
		    shadeClose: false,
		    yes: function(index){
		    	 layer.close(index);
		    }, 
		    no: function(){
		    	window.location.href="/financing/index"
		    }
		});
	}
	if("${isInvest}"=="yes"){
		window.location.href="/user/withdrawals";
	} 
}
</script>
<body>
<section class="main">
    <!--总资产 -->
    <div class="total_plus gross_assets">
    	<c:if test="${jurisdiction != '1'}"> <!-- 1是仓库 -->
	        <!-- <a href="/invite/qrcode" class="code_mask" id="code_mask"></a> -->
	        <a href="/invite/hasLogin" class="code_mask" id="code_mask"></a><!-- 页面右上角的小图片 -->
	        <span class="yield_p"><span><span class="assert_span">总邀请人数(人)</span> </span><span>${totalInviteFriend}</span> </span>
	        <ul class="earnings_p">
	            <%-- <li><span>已成功邀请(人)</span><span>${hqTotalProfit+hqZtProfit }</span></li> --%>
	            <li><span>已审核通过(人)</span><span>${VerifySuccessFriend }</span></li>
	            <li><span>未审核好友(人)</span><span>${noVerifyFriend }</span></li>
	        </ul>
        </c:if>
    </div>
    <!--总资产-->

    <!--定活期预期收益--->
    <c:if test="${jurisdiction != '1'}">
	    <div class="deposit">
			<a href="/prize/prizeList" class="confirm deposit_btn" >派奖名单</a>
			<ul class="person_set">
				<c:if test="${jurisdiction == '7'}">
					<li>
		            <a href="/invite/verify" class="triangle">去审核</a>
		            </li>
	            </c:if>
				<li>
	            <a href="/invite/inviteList" class="triangle">已邀请的好友</a>
	            </li>
	        </ul>    
	    </div>
    </c:if>
    <!--定活期预期收益--->

    <!--个人设置-->
    <ul class="person_set">
    	<c:if test="${jurisdiction != '1'}">
	        <li>
	            <a href="/invite/hasLogin?id=${userId}" class="triangle"> <span><img src="/res/image/icon_d.png"></span>邀请好友</a>
	        </li>
	    </c:if>     
    	<c:if test="${jurisdiction == '7'}">
	        <li>
	            <a href="/invite/inviteAgent?id=${userId}" class="triangle"> <span><img src="/res/image/icon_d.png"></span>邀请代理商</a>
	        </li>
	    </c:if>     
	    <c:if test="${jurisdiction == '7'}">
	        <li>
	            <a href="/prize/index" class="triangle"> <span><img src="/res/image/icon_e.png"></span>奖品设置</a>
	        </li>
	    </c:if> 
	    <c:if test="${jurisdiction == '1' || jurisdiction == '7'}">
	        <li>
	            <a href="/orderform/index" class="triangle"> <span><img src="/res/image/icon_e.png"></span>订单添加</a>
	        </li>
	    </c:if>    
        <!-- <li>
            <a href="/res/html/insurance.html" class="triangle"> <span><img src="/res/image/icon_b.png"></span>安全保障 </a>
        </li> -->
        <c:if test="${jurisdiction == '9'}"><!-- 管理员才可以重置密码 -->
	        <li>
	            <a href="/user/resetLoginPwd" class="triangle"><span><img src="/res/image/icon_c.png"></span>密码重置</a>
	        </li>
        </c:if>
        <c:if test="${jurisdiction == '7'}">
	    <li>
	            <a href="/login/inviteAuthorityCode" class="triangle"> <span><img src="/res/image/icon_c.png"></span>购买邀请权限码</a>
	        </li>
	    </c:if>    
        <c:if test="${jurisdiction == '7'}">
	    	<li>
	            <a href="/login/myInviteAuthorityCode" class="triangle"> <span><img src="/res/image/icon_c.png"></span>我的邀请权限码</a>
	        </li>
	    </c:if>    
        <li>
            <a href="/user/personalSet" class="triangle"><span><img src="/res/image/icon_c.png"></span>个人设置</a>
        </li>
    </ul>
    <!--<div class="triangle triangle_mb guarantee">
        <a href="#"><span><img src="/res/image/icon_a.png"></span>邀请返利</a>
    </div>-->
</section>
<!-- 底部 -->
<script>
    var footSelect = "people";
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
    <script>
        $(function(){
            $('#explan').click(function(){
                layer.open({
                    skin: 'demo-class',
                    content: ' <p style="text-align: left;">1. 总投资是指用户在投资产的总和。<br>2. 在投总收益是指用户在投资产收益的总和。<br>3. 累计总收益是指用户投资累计收益的总和。</p>' //这里content是一个普通的String
                });
            })
            $("#income").click(function(){
            	if("${hasCoupons}"=='has'){
            		var hqCouponEndTime="${hqCouponEndTime}";
	                layer.open({
	                    skin: 'demo-class',
	                    content: ' <p style="text-align: center;"><span style="font-size: 0.26rem; color: #000; line-height: 1.56; display: block; width: 2.26rem; margin: 0 auto; text-align: left;">活：公司活动利率<br>加：个人加息券</span><span style="color: #6c6c6c; font-size: 0.20rem;">（加息截止日期：'+hqCouponEndTime+'）</span></p>' ,
	                    btn: ['确定'],
	                    yes: function(index){
	                        layer.close(index);
	                    }
	                });
            	}else{
            		layer.open({
	                    skin: 'demo-class',
	                    content: ' <p style="text-align: center;"><span style="font-size: 0.26rem; color: #000; line-height: 1.56; display: block; width: 2.26rem; margin: 0 auto; text-align: left;">活：公司活动利率</span></p>' ,
	                    btn: ['确定'],
	                    yes: function(index){
	                        layer.close(index);
	                    }
	                });
            	}
            })
        })
    </script>
</body>
</html>