<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">
<title></title>
<link rel="stylesheet" href="/res/forUnLoginLuck/bootstrap.min.css">
<link rel="stylesheet" href="/res/forUnLoginLuck/style-cj.css">


<script type="text/javascript" src="/res/js/adaptive.js?v=4"></script><!--适配js layer需要这两个js文件-->
<script type="text/javascript" src="/res/js/layer/layer.js?v=4"></script>

</head>
<body>
<div class="main">
  <div class="banner"><img src="/res/forUnLoginLuck/banner-cj.jpg"/></div>
  <div class="main-header">
  <p>您当前拥有积分:<span id="jifen">89995600</span></p>
  <p class="p1">您有<span class="coud_num">899956</span> 次抽奖机会</p>
  <!-- <span id="dejiang" style="color: black;font-family: 仿宋;font-size: 12px;"></span> -->
  <div id="dejiang" style="color: red;font-family: 仿宋;font-size: 12px;">
	  <marquee scrollamount="3">
	  </marquee>
  </div>
  </div>
  <div class="main-body">
     <div id="zhuanpan">
          <img id="img" class="rotary-table" src="/res/forUnLoginLuck/zhuanpan2.png">
          <img id="tip" class="point i_cont" src="/res/forUnLoginLuck/Pointer1.png" >
      </div>
  </div>  

  <div class="main-footer"><a id="zhongjiang" href="#" class="footer-a2" data-toggle="modal" data-target="#myModal2" class="footer-a2">中奖记录>></a><a id="guize" href="#" class="footer-a" data-toggle="modal" data-target="#myModal">活动规则>></a></div> 
  
</div>
		

<!-- 温馨提示 -->
<div id="myModal" class="modal fade s3" tabindex="-1" data-replace="true" data-backdrop="static">
  <div class="modal-dialog">
      <div class="hd-title"></div>
      <a style="    font-size: 16px;margin-top: 16%;" href="#" class="close2">关闭</a>
      <div class="modal-body" style="height: 250px; overflow: auto;">

      <p id="rule">
      </p>
      
      </div>
  
  </div>
</div>
<!-- 中奖记录 -->
<div id="myModal2" class="modal fade s3" tabindex="-1" data-replace="true" data-backdrop="static">
  <div class="modal-dialog">
      <div class="hd-title"></div>
      <a style="font-size: 16px;
			    margin-left: 91%;
			    position: absolute;
			    top: 2%;" href="#" class="close22">关闭</a>
      <div class="modal-body" style="height: 250px; overflow: auto;">

      <p id="zhongj">
      </p>
      
      </div>
  
  </div>
</div>

<script src="/res/forUnLoginLuck/jquery.min.js"></script> 
<script src="/res/forUnLoginLuck/bootstrap.min.js"></script>  
<script type="text/javascript">
	var a0 = "代理商：185xxxx1546下 186xxxx1549抽到了 iphonex";
	var a1 = "代理商：188xxxx3256下 177xxxx7952抽到了 50元红包";
	var a2 = "代理商：155xxxx5665下 133xxxx7852抽到了 10元红包";
	var a3 = "代理商：152xxxx2563下 170xxxx2369抽到了 抱枕";
	var a4 = "代理商：137xxxx8985下 152xxxx6563抽到了 电风扇";
	var a5 = "代理商：182xxxx8567下 177xxxx1289抽到了 500元红包";
	var a6 = "代理商：177xxxx1238下 136xxxx8551抽到了 联想笔记本";
	var a7 = "代理商：139xxxx8253下 188xxxx9625抽到了 5元红包";
	var a8 = "代理商：170xxxx7518下 136xxxx8765抽到了 迷你洗衣机";
	var a9 = "代理商：185xxxx5263下 152xxxx8628抽到了 热水器";
	// $("#dejiang").text(<marquee scrollamount='3'>a0</marquee>);
	document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a0+"</marquee>";
	setInterval(function(){
		var num = parseInt(Math.random()*10);
		if(num == 0){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a0+"</marquee>";
		}else if(num == 1){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a1+"</marquee>";
		}else if(num == 2){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a2+"</marquee>";
		}else if(num == 3){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a3+"</marquee>";
		}else if(num == 4){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a4+"</marquee>";
		}else if(num == 5){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a5+"</marquee>";
		}else if(num == 6){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a6+"</marquee>";
		}else if(num == 7){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a7+"</marquee>";
		}else if(num == 8){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a8+"</marquee>";
		}else if(num == 9){
			document.all.dejiang.innerHTML = "<marquee scrollamount='3'>"+a9+"</marquee>";
		}
	},15000)
			$('#tip').click(function(){
				
				//跳转到登录页面
				window.location.href="/login/toLogin";
				return;
				
			});
			//规则
			$(".close2").click(function(){
				 $('#myModal').modal('hide');
			});
			var flag = 0;
			$("#guize").click(function(){
			 if(flag == 0){ //解决不刷新页面时，重复点击之后，内容会出现重复叠加的问题。
									$("#rule").append("1、活动时间：2018年04月01日——2020年12月31日。<br/>2、活动期间，积分每达100分，即可参与抽奖一次。<br/>3、抽奖奖池：<br/>");
									
									$("#rule").append("一等奖：iPhone8<br/>");
									$("#rule").append("二等奖：联想笔记本<br/>");
									$("#rule").append("三等奖：500元红包<br/>");
									$("#rule").append("四等奖：抱枕<br/>");
									$("#rule").append("五等奖：100元红包<br/>");
									$("#rule").append("六等奖：电风扇<br/>");
									$("#rule").append("七等奖：30元红包<br/>");
									$("#rule").append("八等奖：10元红包<br/>");
									
									$("#rule").append("<span>备注：奖品派发时间由发奖人确定。 </span>");
									$("#rule").append("<span>奖品将按照微信昵称派发，如已派发，请在首页订单查询查看订单进度</span>");
									flag++;
							}
			});			
			//中奖记录
			$(".close22").click(function(){
				 $('#myModal2').modal('hide');
			});
			var flag2 = 0;
			$("#guize").click(function(){
			 if(flag2 == 0){ //解决不刷新页面时，重复点击之后，内容会出现重复叠加的问题。
									
									$("#zhongj").append("橘子，一等奖：iPhone8<br/>");
									$("#zhongj").append("岁月如歌，六等奖：电风扇<br/>");
									$("#zhongj").append("暖梦旧歌，四等奖：抱枕<br/>");
									$("#zhongj").append("喵喵，二等奖：联想笔记本<br/>");
									$("#zhongj").append("一粒沙，二等奖：联想笔记本<br/>");
									$("#zhongj").append("一滴水，三等奖：500元红包<br/>");
									$("#zhongj").append("冰雪，五等奖：100元红包<br/>");
									
									$("#zhongj").append("<span>备注：奖品派发时间由发奖人确定。 </span>");
									$("#zhongj").append("<span>奖品将按照微信昵称派发，如已派发，请在首页订单查询查看订单进度</span>");
									flag2++;
							}
			});				

</script>
<a href="/home/index" class="bt1">返&nbsp;回</a>
</body>

</html>