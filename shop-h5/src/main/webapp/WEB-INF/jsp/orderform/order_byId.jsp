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
    <title>查看订单</title>
</head>
<body>
<section class="main">
<form id="mForm">
    <ul class="login login_css">
    	<li>
        	<span>快递公司</span>
            <input type="text" autocomplete="on" id="express" name="express" value="${orderform.express }"/>
        </li>
    	<li>
        	<span>快递单号</span>
            <input type="text" autocomplete="on" id="number" name="number" value="${orderform.number }"/>
        </li>
        <li>
        	<span>手机号</span>
            <input type="text" autocomplete="on" id="phone" name="phone" value="${orderform.phone }"/>
        </li>
        <li>
        	<span>发件人</span>
            <input type="text" autocomplete="on" id="addresser" name="addresser" value="${orderform.addresser }"/>
        </li>
        <li>
        	<span>收件人</span>
            <input type="text" autocomplete="on" id="addressee" name="addressee" value="${orderform.addressee }"/>
        </li>
        <li>
        	<span>收件地址</span>
            <input type="text" autocomplete="on" id="shoppingAddress" name="shoppingAddress" value="${orderform.shoppingAddress }"/>
        </li>
        <li>
        	<span>物品信息</span>
            <input type="text" autocomplete="on" id="merchandise" name="merchandise" value="${orderform.merchandise }"/>
        </li>
        <li>
        	<span>订单创建时间</span>
            <input type="text" autocomplete="on" id="createTime" name="createTime" value="<fmt:formatDate value="${orderform.createTime }" pattern="yy-MM-dd HH:mm E"/>"/>
        </li>
    </ul>
</form>
</section>
<div class="mask"></div>
<div class="error_timeout"></div>
<script type="text/javascript">
</script>
</body>
</html>