<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" style="background: #fde258;">
<head>
<%@ include file="../common/include_invite.jsp"%>
<title>邀请赚好礼</title>
</head>
<body style="background: #fde258;">
<article class="invite_wrap" id="invite_wrap">
<div class="invtebg bg1"></div>
<div class="invtebg bg2"></div>
<a href="/invite/hasLogin" class="point"><img src="/res/image/invite/point.png"></a>
<a href="/invite/hasLogin" class="invte_inp"><img src="/res/image/invite/invte_inp.png" alt=""></a>
<a href="javascript:void(0)" class="invte_rule" id="invte_rule">邀请规则 &gt;&gt; </a>
</article>
<div class="inv_mask" id="rule" style="display: none;">
    <span class="close"></span>
    <div class="inv_mask_text">
        <span class="rule_tit">规则说明</span>
        <p>
            1、活动期内，好友完成首次交易，且首次交易金额＜2000元，
            送您10元现金红包。</p>
        <p>2、活动期内，好友完成首次交易，且首次交易金额≥2000元，
            送您20元现金红包。</p>
        </p>
        <span class="rule_tit">奖励说明</span>
        <p>1、好友通过您的邀请链接或扫描您的二维码完成注册并投资即
            表示好友与您建立邀请关系。</p>
        <p>2、您获得的现金红包将在1—3个工作日内发放到您账户中。</p>
        <p>3、好友所获得的加息券，有效期为30天。</p>
        <p>4、相同手机号、相同身份证号视为相同用户；每个用户最多只
            能被邀请一次。</p>
        </p>
    </div>
</div>
<div class="inv_mask_share" id="share" style="display: none;">
    <img src="/res/image/invite/share_02.png" alt="">
</div>
<script>
    $(function(){
        $(".close").on("click",function(){ //规则关闭
            $(this).parent().hide();
        })
        $(".inv_mask_share").on("click",function(){  //分享点击关闭
            $(this).hide();
        })
        $("#invte_rule").on("click",function(){  //点击弹出规则
            $("#rule").show();
        })
        $("#invte_inp").on("click",function(){ //点击分享弹出分享指示
            $("#share").show();
        })

    })
</script>
</body>
</html>