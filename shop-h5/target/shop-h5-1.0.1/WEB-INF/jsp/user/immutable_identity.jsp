<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../common/include.jsp"%>
    <title>身份信息</title>
</head>
<body>
<div class="mask"></div>
<section class="main maxH">
	<div class="waring">
        <i class="icon_waring"></i>已实名认证！
    </div>
    <ul class="login card_mes">
        <li>
            <span>姓名</span>
            <span>${userName}</span>
        </li>
        <li>
            <span>身份证</span>
            <span>${idCard}</span>
        </li>
    </ul>
</section>
</body>
</html>