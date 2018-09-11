<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/include.jsp"%>
<%@ include file="../common/include_header.jsp"%>
<title>查看订单</title>
</head>
<body>
<section class="main">
	<div class="message">
        <ul class="meslist">
			<li><a href="/user/set_ban"></a></li>
        </ul>
    </div>
    <ul  class="person">
    	<c:forEach items="${orderformList }" var="orderform" >
	        <li class="arrow_parent" ><a href="/orderform/orderById?orderId=${orderform.id }"/>
	                <i class="ico_set2"></i>
	                <span>${orderform.number }&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${orderform.createTime }" pattern="yy-MM-dd HH:mm E"/></span>
	                <span class="ico_val ab_arrow green"></span>
	                <em class="arrow"></em>
	        </li>
       </c:forEach>
       <c:if test="${orderformList == '[]'}"><font size="8"> 暂无数据！！</font></c:if>
    </ul>
</section>
<!-- 底部 -->
<script type="text/javascript">
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
</body>
</html>