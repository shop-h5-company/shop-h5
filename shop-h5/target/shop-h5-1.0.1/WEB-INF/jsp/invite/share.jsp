<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/include_invite.jsp"%>
<%@ include file="../common/include_header.jsp"%>
<title>注册即送豪礼</title>
</head>
<body style="background: #fff;">
<article class="invite_wrap" id="invite_wrap">
    <section class="part1">
        <div class="invtebg bg3"></div>
        <div class="invtebg bg4"></div>
        <div class="head_img">
        <img src="${headImgUrl }">
        </div>
        <div class="head_text">我是你的好友 <span>${nickName}</span> 邀请您加入微联盟</div>
        <div class="code">
            <img src="${codeUrl }" alt="">
        </div>
    </section>
    <section class="part3">
        微联盟
    </section>
</article>
</body>
</html>