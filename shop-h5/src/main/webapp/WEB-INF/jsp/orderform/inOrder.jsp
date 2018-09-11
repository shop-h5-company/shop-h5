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
    	<li>
            <input style="width: 84%;" type="text" autocomplete="on" id="phOrName" name="phOrName" value="" maxlength="20" placeholder="请输入收件人姓名或手机号"/>
            <butten id="query_order" class="" onclick="query()">查询</butten>
        </li>
    </ul>
</section>
<!-- 底部 -->
<script type="text/javascript">
   	function query(){
   		var phOrName = $("#phOrName").val();
   		window.location.href = "../orderform/queryOrder?phOrName="+phOrName;
   	}
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
</body>
</html>