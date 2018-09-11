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
    <title>编辑订单</title>
</head>
<body>
<section class="main">
<form id="mForm">
    <ul class="login login_css">
    	<input type="hidden" type="text" id="orderId" name="orderId" value="${orderId}"/>
    	<li>
        	<span>快递公司</span>
            <input type="text" autocomplete="on" id="express" name="express" value="${orderform.express }" maxlength="30" placeholder="请输入快递"/>
        </li>
    	<li>
        	<span>快递单号</span>
            <input type="text" autocomplete="on" id="number" name="number" value="${orderform.number }" maxlength="30" placeholder="请输入快递单号"/>
        </li>
        <li>
        	<span>手机号</span>
            <input type="text" autocomplete="on" id="phone" name="phone" value="${orderform.phone }" maxlength="11" placeholder="请输入收件人手机号"/>
        </li>
        <li>
        	<span>发件人</span>
            <input type="text" autocomplete="on" id="addresser" name="addresser" value="${orderform.addresser }" maxlength="10" placeholder="请输入收件人名称"/>
        </li>
        <li>
        	<span>收件人</span>
            <input type="text" autocomplete="on" id="addressee" name="addressee" value="${orderform.addressee }" maxlength="10" placeholder="请输入收件人名称"/>
        </li>
        <li>
        	<span>收件地址</span>
            <input type="text" autocomplete="on" id="shoppingAddress" name="shoppingAddress" value="${orderform.shoppingAddress }" maxlength="200" placeholder="请输入收件地址"/>
        </li>
        <li>
        	<span>物品信息</span>
            <input type="text" autocomplete="on" id="merchandise" name="merchandise" value="${orderform.merchandise }" maxlength="200" placeholder="请输入物品信息"/>
        </li>
    </ul>
    <a id="set_order" class="confirm" href="javascript:void(0)">确定</a>
    <c:if test="${orderId != null}">
    	<a id="delete_order" class="confirm" href="javascript:void(0)">删除</a>
    </c:if>
    <%-- <c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set>
		判断一月内创建的数据可以操作
	<c:choose>
		<c:when test="${nowDate-orderform.createTime.time < 2629743000}">
			<a id="set_order" class="confirm" href="javascript:void(0)">确定</a>
	    	<a id="delete_order" class="confirm" href="javascript:void(0)">删除</a>
		</c:when>
	</c:choose> --%>
    
</form>
</section>
<div class="mask"></div>
<div class="error_timeout"></div>
<script type="text/javascript">
	$(function () {
	    $('#set_order').on('click', function () {
	        startOrderform();
	    });
	    $('#delete_order').on('click', function () {
	    	deleteOrderform();
	    });
	});
	
	//验证信息
	function check_order() {
	    var number = $("#number").val();
	    var phone = $("#phone").val();
	    var addressee = $("#addressee").val();
	    var express = $("#express").val();
	    var reg = /^1(3|4|5|7|8)\d{9}$/;
	    if ('' == number) {
	        layer.open({
	            content: '快递单号不能为空，请输入！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
	        return false;
	    }
	    if('' == phone){
	    	layer.open({
	            content: '手机号不能为空，请输入！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
	        return false;
	    }
	    if('' == addressee){
	    	layer.open({
	            content: '收件人不能为空，请输入！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
	        return false;
	    }
	    if('' == express){
	    	layer.open({
	            content: '收件公司不能为空，请输入！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
	        return false;
	    }
	    if (reg.test(phone) == false) {
	        layer.open({
	            content: '请输入正确手机号！',
	            btn: ['确定'],
			    shadeClose: false,
			    yes: function(index){
			    	layer.close(index);
			    }
	        });
	        return false;
	    }
	    return true;
	}
	function check_from() {
	    if (!check_order()) {
	        return false;
	    }
	    return true;
	}
	
	function startOrderform() {
	    if (!check_from()) {
	        return;
	    }
	    $.post('/orderform/addOrder', $('#mForm').serialize(),
	    function (result) {
	        var result = eval('(' + result + ')');
	        if (result.code == '1') {
	            layer.open({
				    content: "编辑成功！",
				    btn: ['确定'],
				    shadeClose: false,
				    yes: function(){
				    	window.location.href = "../orderform/index";
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
	
	function deleteOrderform() {
	    if (!check_from()) {
	        return;
	    }
	    $.post('/orderform/deleteOrder', $('#mForm').serialize(),
	    function (result) {
	        var result = eval('(' + result + ')');
	        if (result.code == '1') {
	            layer.open({
				    content: "删除成功！",
				    btn: ['确定'],
				    shadeClose: false,
				    yes: function(){
				    	window.location.href = "../orderform/index";
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