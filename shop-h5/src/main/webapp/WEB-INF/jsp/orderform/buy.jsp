<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/include.jsp"%>
<%@ include file="../common/include_header.jsp"%>
<title>商品列表</title>
</head>
<body>
<section class="main">
	<div class="message">
        <ul class="meslist">
			<li><a href="">商品列表</a></li>
			<li><a style="color: antiquewhite;
    					font-size: 20px;
    					font-family: 仿宋;" href=""></a></li>
        </ul>
    </div>
    	<div style="height: 220px;">
    		<div style="width: 200px;height: 180px;float:left;">
    			<img alt="" src="/res/image/invite/good1.jpg">
    		</div>
    		<div style="font-size: 10px;">
    			<span style="color:red;">love her复活霜小红瓶娇伊凡焕彩亮颜霜一正品晚霜面霜</span><br><br>
    			<span style="">价格：200元</span><br><br>
    			<span style="color:green;">收货地址</span>：<br>
    			<input style="width: 17%;"></input><br>
    			或联系本站客服<br><br>
    			<span style="">配送方式：快递（免运费）</span><br><br>
    			<a style="background-color: springgreen" onclick="goodDetail1();">商品详情</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    			<a style="background-color: darkturquoise" onclick="goumai();">立即购买</a>
    		</div>
    	</div>
    	<div style="height: 220px;">
    		<div style="width: 200px;height: 180px;float:left;">
    			<img alt="" src="/res/image/invite/good2.png">
    		</div>
    		<div style="font-size: 10px;">
    			<span style="color:red;">娇伊凡焕彩靓颜霜最新款 复活霜小红瓶去痘提亮肤色</span><br><br>
    			<span style="">价格：188元</span><br><br>
    			<span style="color:green;">收货地址</span>：<br>
    			<input style="width: 17%;"></input><br>
    			或联系本站客服<br><br>
    			<span style="">配送方式：快递（免运费）</span><br><br>
    			<a style="background-color: springgreen" onclick="goodDetail2();">商品详情</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    			<a style="background-color: darkturquoise" onclick="goumai();">立即购买</a>
    		</div>
    	</div>
    	<div style="height: 220px;">
    		<div style="width: 200px;height: 180px;float:left;">
    			<img alt="" src="/res/image/invite/good3.jpg">
    		</div>
    		<div style="font-size: 10px;">
    			<span style="color:red;">一代女王 焕彩靓颜霜 晚霜面霜</span><br><br>
    			<span style="">价格：220元</span><br><br>
    			<span style="color:green;">收货地址</span>：<br>
    			<input style="width: 17%;"></input><br>
    			或联系本站客服<br><br>
    			<span style="">配送方式：快递（免运费）</span><br><br>
    			<a style="background-color: springgreen" onclick="goodDetail3();">商品详情</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    			<a style="background-color: darkturquoise" onclick="goumai();">立即购买</a>
    		</div>
    	</div>
    	<!--  <li>
            <input style="width: 84%;" type="text" autocomplete="on" id="phOrName" name="phOrName" value="" maxlength="20" placeholder="请输入收件人姓名或手机号"/>
            <butten id="query_order" class="" onclick="query()">购买</butten>
        </li>-->
</section>
<!-- 底部 -->
<script type="text/javascript">
   	function query(){
   		var phOrName = $("#phOrName").val();
   		window.location.href = "../orderform/queryOrder?phOrName="+phOrName;
   	}
   	function goumai(){
		alert("等待开通微信支付");   		
   	}
   	function goodDetail1(){
   		layer.open({
            content:"<span >产地：中国大陆</span>&nbsp&nbsp"+
            		"<span style='position: relative;margin-left: 20%;'>种类：面霜</span><br/><br/>"+
            		"<span >品牌：小红瓶</span>&nbsp&nbsp"+
            		"<span style='position: relative;margin-left: 21%;'>规格：50g装</span>",
            btn:['确定'],
            });   		
   	}
   	function goodDetail2(){
   		layer.open({
            content:"<span >产地：中国大陆</span>&nbsp&nbsp"+
            		"<span style='position: relative;margin-left: 20%;'>种类：面霜</span><br/><br/>"+
            		"<span >品牌：JAKCOM</span>&nbsp&nbsp"+
            		"<span style='position: relative;margin-left: 12%;'>规格：50g/mL</span>",
            btn:['确定'],
            });   		
   	}
   	function goodDetail3(){
   		layer.open({
            content:"<span >产地：中国大陆</span>&nbsp&nbsp"+
            		"<span style='position: relative;margin-left: 20%;'>种类：面霜</span><br/><br/>"+
            		"<span >品牌：一代女皇</span>&nbsp&nbsp"+
            		"<span style='position: relative;margin-left: 14%;'>规格：100g装</span>",
            btn:['确定'],
            });   		
   	}
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
</body>
</html>