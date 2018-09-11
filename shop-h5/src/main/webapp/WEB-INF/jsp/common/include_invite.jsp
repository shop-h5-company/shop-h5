<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<meta name="format-detection" content="telephone=no"/>
<meta id="viewport" name="viewport"
      content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<script type="text/javascript" src="/res/js/adaptive.js"></script><!--适配js-->
<script type="text/javascript" src="/res/js/zepto.js"></script>  <!--基础-->
<link rel="stylesheet" type="text/css" href="/res/css/style.css?v=11">
<link rel="stylesheet" type="text/css" href="/res/css/invite.css?v=11">

<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
    /* alert(location.href.split('#')[0]); */
    wx.config({
        debug: false,
        appId: "${appId}",
        timestamp: "${timestamp}",
        nonceStr: "${noncestr}",
        signature: "${signature}",
        jsApiList: ['onMenuShareTimeline', 'onMenuShareAppMessage', 'startRecord', 'onVoiceRecordEnd', 'stopRecord', 'playVoice', 'pauseVoice', 'onVoicePlayEnd', 'uploadVoice', 'downloadVoice']
    });
    wx.ready(function(){
        wx.onMenuShareTimeline({
            title: "${title}",
            link: "${link}",
            imgUrl: "${imgUrl}"
        });
        wx.onMenuShareAppMessage({
            title: "${title}",
            desc: "${desc}",
            link:"${link}",
            imgUrl: "${imgUrl}",
            type: 'link'
        });

    });
</script>