<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/include.jsp"%>
<%@ include file="../common/include_header.jsp"%>
<title>已邀请的好友</title>
</head>
<body>
<section class="main">
	<div class="message">
        <ul class="meslist">
        	<!-- 最后为邀请的当前用户  在后面显示未结算金额（） -->
        	<%-- <li>${level }<li> --%>
        	<li>未审核好友（${UnInvitedPerson } 人）<li>
        </ul>
    </div>
    <ul  class="person">
    	 <c:if test="${userList != null}">
	    	<c:forEach items="${userList }" var="user">
	    	<!-- （addFriend字段0是，1否。字段为null，则是未审核） -->
		        <li class=""><!-- arrow_parent -->
		                <i class="ico_set4"></i>
		                <span style="color: pink;font-family: 仿宋;">昵称：${user.userName }</span>&nbsp
		                <span>
		                	<!-- 顶级代理商 -->
		                		<c:if test="${user.addFriend == null || user.addFriend == ''}">
			                		<button id="jieshou${user.userId}" onclick="jieshou(${user.userId});">接受</button>&nbsp&nbsp
			                		<button id="jujue${user.userId}" onclick="jujue(${user.userId});">拒绝</button>
		                		</c:if>
		                		<c:if test="${user.addFriend == '0'}">
			                		<span style="color:green">已审核</span>
		                		</c:if>
		                		<c:if test="${user.addFriend == '1'}">
			                		<span style="color:red">已拒绝</span>
		                		</c:if>&nbsp
		                	<span>积分:${user.count}</span>	
		                </span>
		                <span class="ico_val ab_arrow green"></span>
		                <em class="arrow"></em>
		        </li>
	         </c:forEach>
        </c:if>
    </ul>
<%--     <ul  class="person">
    	 <c:if test="${userList != null}">
	    	<c:forEach items="${userList }" var="user">
		        <li class="arrow_parent">
		        	<!-- 点击时传id到后台 查询下级所有用户，当用户标示为未邀请时不可点击，已邀请时显示未结算金额，并可进入到下级，没有未结算金额则为0 -->
		            <a href="/invite/inviteList?currentUserId=${user.userId}">
		                <i class="ico_set4"></i>
		                	<!-- 未结算的为当前用户下级所有未结算的总额    10元为当前用户未结算的金额   -->
		                <span>${user.userName }<c:if test=""> <!-- 未结算或者一个图片感叹号 --></c:if></span>
                		<span><!-- 2017-09-25 12:11:11  --> <c:if test=""><!-- 参数为空的时候显示 --><button>接受  拒绝</button></c:if></span>
		                <span class="ico_val ab_arrow green"></span>
		                <em class="arrow"></em>
		            </a>
		        </li>
	         </c:forEach>
        </c:if>
    </ul> --%>
</section>
<!-- 底部 -->
<script>
    var footSelect = "people";
    function jieshou(userId){
    	$.post('/invite/jieshou?userId='+userId,
 			   function(data){
     				if(data.result == true){
 						$("#jieshou"+userId).text("已审核");
 						//$("#jieshou"+userId).attr("color","green");
 						$("#jujue"+userId).hide();
 						/* alert(data.msg); */
 						layer.open({
 			                content:data.msg,
 			                btn:['确定'],
 			                shadeClose: false,
				            /* yes:function(index,layero){//按确定，则执行yes。点击取消关闭弹框层
				            	//location.reload();  //刷新当前页面，类似浏览器的刷新
		                      } */
 			                });
 						/* location.href="/invite/inviteList?currentUserId="+userId; */
     				}else{
 						//alert("审核失败，请重试");
     					layer.open({
 			                content:'审核失败，请重试',
 			                btn:['确定'],
 			                shadeClose: false,
 			                yes:function(index,layero){//按确定，则执行yes。点击取消关闭弹框层
				            	//location.reload(); //刷新当前页面，类似浏览器的刷新
		                      }
 			                });
     				}
 			   },
 			"json");
    }
    function jujue(userId){
    	$.post('/invite/jujue?userId='+userId,
 			   function(data){
     				if(data.result == true){
 						$("#jujue"+userId).text("已拒绝");
 						$("#jieshou"+userId).hide();
 						/* alert(data.msg); */
 						layer.open({
 							content:data.msg,
 			                btn:['确定'],
 			                shadeClose: false,
				            /* yes:function(index,layero){//按确定，则执行yes。点击取消关闭弹框层
				            	//location.reload(); //刷新当前页面，类似浏览器的刷新
		                      } */
 			                });
 						/* location.href="/invite/inviteList?currentUserId="+userId; */
     				}else{
 						//alert("审核失败，请重试");
 						layer.open({
 			                content:'审核失败，请重试',
 			                btn:['确定'],
 			                shadeClose: false,
 			                /* yes:function(index,layero){//按确定，则执行yes。点击取消关闭弹框层
				            	//location.reload(); //刷新当前页面，类似浏览器的刷新
		                      } */
 			                });
     				}
 			   },
 			"json");
    }
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
</body>
</html>