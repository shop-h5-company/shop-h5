<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" style="background: #fde258;">
<head>
<%@ include file="../common/include_invite.jsp"%>
<title>邀请赚好礼</title>
<link rel="stylesheet" href="/prizeluck/css/bootstrap.min.css">
<link rel="stylesheet" href="/prizeluck/css/style-cj.css">
    <script type="text/javascript" src="/res/js/adaptive.js?v=4"></script><!--适配js layer需要这两个js文件-->
	<script type="text/javascript" src="/res/js/layer/layer.js?v=4"></script>
</head>
<body style="background: #fde258;">
<article class="invite_wrap" id="invite_wrap">
<div class="invtebg bg1"></div>
<div class="invtebg bg2"></div>
    <div class="code code2">
        <img src="/invite/codeUrlForInviteAgent?id=${userId}" alt="">
    </div>
    <%-- <div class="invitationcode">我的邀请码：${hisInviteCode }</div> --%>
<a href="javascript:void(0)" class="invte_inp" id="invte_inp"><img src="/res/image/invite/invte_inp.png" alt=""></a>
<a href="javascript:void(0)" class="invte_rule" id="invte_rule">邀请规则 &gt;&gt; </a><br/>
<a style="position: relative;top: 110px;" href="/user/index" class="bt1">返&nbsp;回</a>
</article>
<div class="inv_mask" id="rule" style="display: none;">
    <span class="close"></span>
    <div class="inv_mask_text">
        <span class="rule_tit">邀请规则</span>
        <p>1、好友通过扫描您的二维码完成注册即表示好友与您建立邀请关系。</p>
        <p>2、相同手机号、相同身份证号视为相同用户；每位用户最多只能被邀请一次。</p>
        <p>3、被邀请人注册之后，您可以获取奖励。</p>
        </p>
        <span class="rule_tit">奖励说明</span>
        <p>1、被邀请人注册后，购买权限邀请码，邀请人则获得其百分之十的邀请人数。</p>
        <p>2、活动期间凡邀请一位代理商成功注册，邀请人获得5位好友邀请人数。</p>
        <p>3、最终解释权归微联盟所有。</p>
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