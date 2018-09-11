<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/include.jsp"%>
<%@ include file="../common/include_header.jsp"%>
<title>订单</title>
</head>
<body>
<section class="main">
	<div class="message">
        <ul class="meslist">
        	<!-- 最后为邀请的当前用户  在后面显示未结算金额（） -->
        	<%-- <li>${level }<li>
        	<li>未结算金额（${unsettledAmt } 元）<li> --%>
			<li><a href="/user/set_ban"></a></li>
			<a href="/orderform/inAddOrder">添加订单</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/orderform/inOrderUpload">批量添加订单</a>
        </ul>
    </div>
    <ul  class="person">
	    	<c:forEach items="${orderformList }" var="orderform" >
		        <li class="arrow_parent" ><a href="/orderform/inAddOrder?orderId=${orderform.id }"/>
		                <i class="ico_set2"></i>
		                <span>${orderform.number }</span>
		                <span>${orderform.express }</span>
		                <span>${orderform.addressee }</span>
		                <span class="ico_val ab_arrow green"></span>
		                <em class="arrow"></em>
		        </li>
	       </c:forEach>
	       <c:if test="${orderformList == '[]'}"><font size="8"> 暂无数据！！</font></c:if>
    </ul>
</section>
<!-- 底部 -->
<script>
    var footSelect = "people";
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
</body>
</html>