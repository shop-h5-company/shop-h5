<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/7/4
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微联盟</title>
    <%@ include file="../common/include.jsp"%>
</head>
<body>
<section class="main" id="wrap">
    <div>
        <!--总资产 -->
        <div class="total_assets total_plus gross_assets">
            <a href="/user/personalSet" class="set icon_set">设置</a>
            <span class="yield_p"><span><span class="assert_span">敬请期待</span> </span>
            <a  href="/user/index">
                <ul class="earnings_p">
                </ul>
            </a>
        </div>
        <!-- <div class="deposit">
        	<a href="/orderform/buy" class="confirm deposit_btn" >购买商品</a>
	    </div>  -->
        <div class="deposit">
        	<a href="/orderform/inOrder" class="confirm deposit_btn" >查询订单</a>
	    </div> 
        <div class="weixincode" >
            <span>客服微信号：&nbsp;&nbsp;&nbsp;18911049994</span>
        </div>
    </div>
</section>
<!-- 底部 -->
<script>
    var footSelect = "house";
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
    <script>
    
    var jurisdiction = "${user.jurisdiction}";
    var addFriend = "${user.addFriend}";
    var weixin = "${weixin}";//微信号
    var invitePersonNum = "${user.invitePersonNum}";
    if(jurisdiction == '0'){
    	if(addFriend != '0'){//0是已加好友。
		    layer.open({
		        btn: ['<span class="single">确定</span>'],
		        shadeClose: false,
		        content: '<span style="font-family: 仿宋;">请添加该微信号：<span style="color:pink;">'+weixin+'</span>，并通知对方审核，方可抽奖</span>'
		    });
    	}
    }
    if(jurisdiction == '7'){
    	if(invitePersonNum < 10){//代理邀请名额不足10人时，提示
		    layer.open({
		        btn: ['<span class="single">确定</span>'],
		        shadeClose: false,
		        content: '<span style="font-family: 仿宋;">您的邀请名额剩余：<span style="color:pink;">'+invitePersonNum+'</span>人次。剩余为0人次时，邀请码无效</span>'
		    });
    	}
    }
    
        $(function(){
            $('#explan').on('click',function(){
                layer.open({
                    skin: 'demo-class',
//                    style: ' text-align:center',
                    content: ' <p style="text-align: left">1. 总投资是指用户在投资产的总和。<br>2. 在投总收益是指用户在投资产收益的总和。<br>3. 累计总收益是指用户投资累计收益的总和。</p>' //这里content是一个普通的String
                });
            });
        });
        var swiper = new Swiper('.swiper-container', {
            pagination: '.swiper-pagination',
            autoplay: 3000,
            autoplayDisableOnInteraction: false, //每次都会重新启动autoplay
            loop: "ture"
        });
     /*   var swiper = new Swiper('.notice-container', {
            autoplay: 5000,
            speed:1000,
            direction : 'vertical',
            autoplayDisableOnInteraction: false, //每次都会重新启动autoplay
            loop: "ture"
        });*/
            var total_news = document.querySelector(".total_news_index");
            var time = 0;
            var objW = $(total_news).width();
            var imgW = Math.floor(2900 * $(total_news).height() / 232);
            var res = imgW - objW;
            /* window.setInterval(function(){
                if(time == -res){
                    time = 0;
                }
                total_news.style.backgroundPosition = time-- +"px 0";
            },60) */
    </script>
<script src="/res/js/iscroll.js"></script>
<script>
	var a = "${alert}";
	if(a == "true"){
		 layer.open({
		        btn: ['<span class="single">确定</span>'],
		        shadeClose: false,
		        content: '<span style="font-family: 仿宋;">您尚未填写微信昵称，请完善，以便派奖人在派奖列表找到您。<br /><br />请您在<a style="color: green;font-size: 25px;font-family: 仿宋;" href="/user/personalSet">个人设置</a>中完善微信昵称！</span>'
		    });
	}
    $(function(){
        var  myIscroll;
        myIscroll = new iScroll("wrap",{
            vScrollbar: false,
            checkDOMChanges:true
        });
        myIscroll.refresh();
    })
</script>
</body>
</html>
