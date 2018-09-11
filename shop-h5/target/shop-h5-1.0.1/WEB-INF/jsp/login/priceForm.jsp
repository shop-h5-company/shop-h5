<%--
  Created by IntelliJ IDEA.  这是真实的购买页面。
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
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>
</head>
<body>
<section class="main" id="">
    <div class="total_plus gross_assets">
        <div class="total_assets total_plus gross_assets"><br/><br/><br/><br/>
            <span style="font-size: x-large;font-family: 仿宋;margin-left: 20%;" >剩余可邀请人数：&nbsp;${inviteNum}</span><br/><br/>
            <c:if test="${inviteNum < 10 }">
            	<span style="font-size: 15px;font-family: 仿宋;margin-left: 28%;">剩余可邀请人数已不足10名</span><br/><br/>
            </c:if>
            <!-- <span style="font-size: 15px;font-family: 仿宋;margin-left: 8%;">请联系QQ：726935697 或微信：1891104999 进行购买</span><br/><br/> -->
            <span style="font-size: 15px;font-family: 仿宋;margin-left: 28%;">客服微信号：&nbsp;&nbsp;&nbsp;18911049994</span>
            <a href="/user/index">
                <ul class="earnings_p">
                </ul>
            </a>
        </div>
        <form id="myForm">
            <ul class="login_main login_special">
                <input type="hidden" id="backUrl" value="${backUrl}"/>
                <li>
                    <span class="pwd"></span>
                    <input class="textbox" type="input" id="inviteAuthorityCode"  maxlength="16"  name="inviteAuthorityCode"  placeholder="邀请权限码" style="width:4.2rem"/>
	            	<a style="position: absolute;top: 1px;color:green;" id="registerNew" onclick="jihuo();">立即激活</a>
                </li>
            </ul>
	    </form><br/>
        <div style="font-family: 仿宋;font-size: 10px;color: cornflowerblue;margin-left: 15%;">
	        <div style="float:left;">
	                 <input name="inviteCode" type="radio" value="20" onclick = "type1();" checked>20元（20次）</input><br/><br/>
	                 <!-- &nbsp&nbsp<span style="color: darkseagreen;">1元/次</span> -->
	        </div>
	        <div style="position: relative;margin-left: 45%;">
	                 <input name="inviteCode" type="radio" value="40" onclick = "type1();"/>40元（50次）<br/><br/>
	                 <!-- &nbsp&nbsp<span style="color: darkseagreen;">8毛/次</span> -->
	        </div>
	        <div style="float:left;">
	                <input name="inviteCode" type="radio" value="70" onclick = "type1();"/>70元（100次）<br/><br/>
	                <!-- &nbsp&nbsp<span style="color: darkseagreen;">7毛/次</span> -->
	        </div>
	        <div style="position: relative;margin-left: 45%;">
	                <input name="inviteCode" type="radio" value="130" onclick = "type1();"/>130元（200次）<br/><br/>
	                <!-- &nbsp&nbsp<span style="color: darkseagreen;">6毛5/次</span> -->
	        </div>
	        <div style="float:left;">
	                <input name="inviteCode" type="radio" value="260" onclick = "type1();"/>260元（500次）<br/><br/>
	                <!-- &nbsp&nbsp<span style="color: darkseagreen;">5毛2/次</span> -->
	        </div>
	        <div style="position: relative;margin-left: 45%;">
	                <input name="inviteCode" type="radio" value="450" onclick = "type1();"/>450元（1000次）<br/><br/>
	                <!-- &nbsp&nbsp<span style="color: darkseagreen;">4毛5/次</span> -->
	        </div>
        </div>
        <br/><br/>
        	<span style="margin-left: 18%;">
        		<button onclick="jianyi();">-</button>
        			<input id="shuliang" style="width: 15%;" value="1" disabled></input>
        		<button onclick="jiayi();">+</button>&nbsp
        		<span>
        			<span style="color: black;">金额合计：</span>
        			<input style="width: 15%;" id="realMoney" value="20" disabled></input><span style="color:black;">元</span><br />
        			<!-- <span style="color: black;">沙箱：</span>
        			<input style="width: 15%;" id="money" value="20" ></input><span style="color:black;">元</span> -->
        		</span>
        	</span>
        <br/>
        <br/>
        <br/>
        <br/>
        	<input onclick="buy();" style="margin-left: 37%; color: red; font-family: 仿宋;" type="button" value="确认购买" />
        	
        	<input id="appId" type="text" style="display:none"/>
        	<input id="timeStamp" type="text" style="display:none"/>
        	<input id="nonceStr" type="text" style="display:none"/>
        	<input id="package2" type="text" style="display:none"/>
        	<input id="paySign" type="text" style="display:none"/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <!-- 是否开展活动，不在前端通知后端，只在后端配置。可以用hidden隐藏活动标签 -->
        <span  style="position: relative;
        		font-size: 12px;
			    margin-left: 18%;
			    color: red;
			    top: -10px;">活动：买一送一，&nbsp&nbsp日期：5月1日—5月20日</span><br /><br />
        <span style="position: relative;
        			font-size: 12px;
				    margin-left: 18%;
				    color: red;
				    top: -10px;">备注：首次购买，赠送当前购买次数一半的权限邀请码</span>
    </div>
</section>
<!-- 底部 -->
<script>
	//确认购买，跳出微信支付、支付宝支付两个选项。
	function buy(){
		
		layer.open({
            content: '<button  onclick="weixinPay();">微信支付</button><br /><br /><button  onclick="aliPay();">支付宝支付</button>',
            btn: ['<span class="single">取消</span>'],
            shadeClose: false,
        });
		
		/* 
		var inviteCode = $("input[name='inviteCode']:checked").val();
		if(inviteCode == null){
			return;
		}
		alert(inviteCode); 
		*/
	}
	//点击微信支付，
	function weixinPay(){
		if(is_weixn() == false){
			alert("请在微信中打开支付");
			return;
		}
		var typePay = $("input[name='inviteCode']:checked").val();
		var buyNumber = $("#shuliang").val();
		var realPay = $("#realMoney").val();
		
		
		
		if(typePay == null || realPay == 0){
			return;
		}
		$.post("/wxpay/weixinBuy?typePay="+typePay+"&buyNumber="+buyNumber+"&realPay="+realPay,
	  			   function(data){
					
					 $("#appId").val(data.appId);    //公众号名称，由商户传入     
			         $("#timeStamp").val(data.timeStamp);         //时间戳，自1970年以来的秒数     
			         $("#nonceStr").val(data.nonceStr); //随机串     
			         $("#package2").val(data.package);    
			         $("#paySign").val(data.paySign);
				
				if (typeof WeixinJSBridge == "undefined"){
			    	   if( document.addEventListener ){
			    	       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
			    	   }else if (document.attachEvent){
			    	       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
			    	       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
			    	   }
			    	}else{
			    	   onBridgeReady();
			    	} 
				
	  			   },
	  			"json");
		
	}
	//点击支付宝支付，
	function aliPay(){
		var typePay = $("input[name='inviteCode']:checked").val();
		var buyNumber = $("#shuliang").val();
		var realPay = $("#realMoney").val();
		
		if(typePay == null || realPay == 0){
			return;
		}
		location.href="/login/aliPay?typePay="+typePay+"&buyNumber="+buyNumber+"&realPay="+realPay;
	}
	
    var footSelect = "house";
    function jihuo(){
    	var inviteAuthorityCode = $("#inviteAuthorityCode").val();
    	if(inviteAuthorityCode == ""){
    		alert("不能为空");
    		return;
    	}
    	$.post('/invite/activateAuthorityCode?inviteAuthorityCode='+inviteAuthorityCode,
  			   function(data){
      				if(data.result == true){
  						/* $("#jieshou"+userId).text("已审核");
  						$("#jujue"+userId).hide(); */
  						location.reload(); //刷新当前页面，类似浏览器的刷新
  						alert(data.msg);
  						/* location.href="/invite/inviteList?currentUserId="+userId; */
      				}else{
      					alert(data.msg);
      				}
  			   },
  			"json");
    }
    //点击单选框radio时，
    function type1(){
    	var money = $("input[name='inviteCode']:checked").val();
    	var shuliang = $("#shuliang").val();
    	var rm = parseInt(money)*parseInt(shuliang);
    	$("#realMoney").val(rm);
    }
    function jianyi(){
    	var money = $("input[name='inviteCode']:checked").val();
    	var shuliang = $("#shuliang").val();
    	if(shuliang == 1){
    		return;
    	}
    	var now = parseInt(shuliang)-1;
    	$("#shuliang").val(now);
    	//展示实际支付realMoney
    	if(money != null ){
	    	var rm = parseInt(money)*parseInt(now);
    		$("#realMoney").val(rm);
    	}
    }
    function jiayi(){
    	var money = $("input[name='inviteCode']:checked").val();
    	var shuliang = $("#shuliang").val();
    	var now = parseInt(shuliang)+1;
    	$("#shuliang").val(now);
    	//展示实际支付realMoney
    	if(money != null ){
	    	var rm = parseInt(money)*parseInt(now);
    		$("#realMoney").val(rm);
    	}
    }
    //判断是否在微信浏览器中打开
    function is_weixn(){
        var ua = navigator.userAgent.toLowerCase();
        if(ua.match(/MicroMessenger/i)=="micromessenger") {
            return true;
        } else {
            return false;
        }
    }
    //进入该页面时，进行微信授权，获取openid（大概是微信打开页面时，微信授权该页面可以调用微信支付功能）
    if(is_weixn()){
      $(function(){
		var code = getQueryString('code');
	    if (code == null) {
	    	var href = location.href;//获取授权code的回调地址，获取到code  //直接返回到当前页？ 
	    	var url = 'https://open.weixin.qq.com/connect/oauth2/authorize?'+
	    			'appid=wxcf91fa4d9f461854'+
	    			'&redirect_uri=' + encodeURIComponent(href) + 
	    			'&response_type=code&scope=snsapi_base&state=0#wechat_redirect';
	    	
	       location.href = url;//微信端打开这个url之后，可以根据redirect_uri返回到该页面
	    	
	       }else{
	    	$.post('/wxpay/getOpenid',{'code':code},function(data){
		    }); 
	    }
	
});
    }
    function getQueryString(name) { //获取传给本页面的一个值。
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = location.search.substr(1).match(reg);
        if (r != null)
            return unescape(decodeURI(r[2]));
        return null;
    } 
    
     function onBridgeReady(){
    	   WeixinJSBridge.invoke(
    			   'getBrandWCPayRequest', {
		    	         "appId":$("#appId").val()+"",//公众号名称，由商户传入     
		    	         "timeStamp":$("#timeStamp").val()+"",//时间戳，自1970年以来的秒数     
		    	         "nonceStr":$("#nonceStr").val()+"",//随机串     
		    	         "package":$("#package2").val()+"",     
		    	         "signType":"MD5",//微信签名方式：     
		    	         "paySign":$("#paySign").val()+""//微信签名 
		    	      },
    	      function(res){
    	      if(res.err_msg == "get_brand_wcpay_request:ok" ){
    	      		// 使用以上方式判断前端返回,微信团队郑重提示：
    	            //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
		    	   alert("购买成功，请在我的邀请权限码中查看");
		    	   location.href="/user/index";
    	      } 
    	   }); 
    	}
     
</script>
<%@ include file="../common/footer.jsp"%>
</body>
</html>