<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/7/4
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<meta name="format-detection" content="telephone=no"/>
<meta id="viewport" name="viewport"
      content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<link rel="stylesheet" type="text/css" href="/res/css/swiper.min.css?v=4"/>
<link rel="stylesheet" type="text/css" href="/res/css/style.css?v=0908ccifn">
<script type="text/javascript" src="/res/js/adaptive.js?v=4"></script><!--适配js-->
<script type="text/javascript" src="/res/js/zepto.js?v=4"></script>  <!--基础-->
<script type="text/javascript" src="/res/js/swiper-3.3.1.jquery.min.js?v=4"></script>
<script type="text/javascript" src="/res/js/layer/layer.js?v=4"></script>
<script type="text/javascript" src="/res/js/utils.js?v=4"></script>

<script type="text/javascript">
    if (window!=top) // 判断当前的window对象是否是top对象
        top.location.href =window.location.href; // 如果不是，将top对象的网址自动导向被嵌入网页的网址
</script>

<script src="/res/js/hmt.js"></script>

<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

 <script>
    window.onload = function(){
        var rad = $("#rad");
        var adv = rad.next("div");
        if(adv && parseInt(adv.css("width")) == 300){
            adv.css("width",0);
        }
        if(rad){
           rad.remove();
        }
    }
</script>

