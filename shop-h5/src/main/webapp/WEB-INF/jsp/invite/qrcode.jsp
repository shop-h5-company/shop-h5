<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" style="background: #fde258;">
<head>
<%@ include file="../common/include_invite.jsp"%>
<title>专享二维码</title>
</head>
<body style="background: #fde258;">
<article class="invite_wrap" id="invite_wrap">
<div class="invtebg bg5"></div>
<div class="invtebg bg6"></div>
    <div class="head_img2"><img src="${headImgUrl }"></div>
    <div class="head_text2">我是 <span>${nickName}</span></div>
    <div class="code code2">
        <img src="${codeUrl }" alt="">
    </div>
    <div class="invitationcode">我的邀请码：${inviteCode }</div>
</article>
</body>
</html>